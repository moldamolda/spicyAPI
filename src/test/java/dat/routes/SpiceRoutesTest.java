package dat.routes;

import dat.config.ApplicationConfig;
import dat.config.HibernateConfig;
import dat.config.Populate;
import dat.daos.SpiceDao;
import io.javalin.Javalin;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import dat.dtos.SpiceDTO;
import org.junit.jupiter.api.*;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Purpose:
 *
 * @author: Jeppe Koch
 */
public class SpiceRoutesTest {

    private static Javalin app;
    private static final EntityManagerFactory emf = HibernateConfig.getEntityManagerFactoryForTest();
    private static final SpiceDao spiceDao = new SpiceDao(emf);
    private static final String BASE_URL = "http://localhost:7080/api/spices";

    private static Populator populator = new Populator(spiceDao, emf);
    private static SpiceDTO s1, s2, s3;

    private static List<SpiceDTO> spices;

    @BeforeAll
    static void init() {
        app = ApplicationConfig.startServer(7080, emf);
    }

    @BeforeEach
    void setUp() {
        spices = populator.populate3Spices();
        s1 = spices.get(0);
        s2 = spices.get(1);
        s3 = spices.get(2);
    }


    @AfterEach
    void tearDown() {
        // Delete all data from database
        populator.clean();
    }


    @AfterAll
    static void closeDown() {
        ApplicationConfig.stopServer(app);
    }

    @Test
    void testReadSpice() {
        SpiceDTO spice =
                given()
                        .when()
                        .get(BASE_URL + "/spice/" + s1.getId())
                        .then()
                        .log().all()
                        .statusCode(200)
                        .extract()
                        .as(SpiceDTO.class);

        assertThat(spice, equalTo(s1));
    }

    @Test
    void testCreateSpiceAPI() {

        SpiceDTO newSpice = new SpiceDTO("cumin", "spicy, sweet", "cumin is delicious");


        SpiceDTO createdSpice =
                given()
                        .contentType("application/json")
                        .body(newSpice)
                        .when()
                        .post(BASE_URL + "/spice/")
                        .then()
                        .log().all()
                        .statusCode(201)
                        .extract()
                        .as(SpiceDTO.class);

        // Assert: Verify that the spice ID is assigned (non-zero)
        assertNotNull(createdSpice.getId(), "Spice ID should be assigned and not null");

        // Assert: Verify the spice details
        assertEquals("cumin", createdSpice.getName());
        assertEquals("spicy, sweet", createdSpice.getFlavorProfile());
        assertEquals("cumin is delicious", createdSpice.getDescription());
    }

    @Test
    void testUpdateSpice() {
        SpiceDTO updatedSpice = new SpiceDTO("Cumin", "Spice", "A spice that is used in many dishes");

        given()
                .contentType("application/json")
                .body(updatedSpice)
                .when()
                .put(BASE_URL + "/spice/" + s1.getId())
                .then()
                .log().all()
                .statusCode(200);

        SpiceDTO spice =
                given()
                        .when()
                        .get(BASE_URL + "/spice/" + s1.getId())
                        .then()
                        .log().all()
                        .statusCode(200)
                        .extract()
                        .as(SpiceDTO.class);

        assertEquals("Cumin", spice.getName());
        assertEquals("Spice", spice.getFlavorProfile());
        assertEquals("A spice that is used in many dishes", spice.getDescription());
    }

    @Test
    void testDeleteSpice() {
        given()
                .when()
                .delete(BASE_URL + "/spice/" + s1.getId())
                .then()
                .log().all()
                .statusCode(204); // Assuming 204 No Content is the expected status code for a successful delete
    }

}
