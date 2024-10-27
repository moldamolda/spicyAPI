package dat.config;

import dat.entities.Cuisine;
import dat.entities.Spice;
import dat.security.entities.User;
import dat.security.enums.Role;
import jakarta.persistence.EntityManagerFactory;

import java.util.Set;

public class Populate {
    public static void main(String[] args) {

        EntityManagerFactory emf = HibernateConfig.getEntityManagerFactory("spice");

        Set<Spice> indianSpice = getIndianSpice();
        Set<Spice> middleEasternSpice = getMiddleEasternSpice();
        Set<Spice> mexicanSpice = getMexicanSpice();
        Set<Spice> chineseSpice = getChineseSpice();
        Set<Spice> thaiSpice = getThaiSpice();
        Set<Spice> mediterraneanSpice = getMediterraneanSpice();
        Set<Spice> japaneseSpice = getJapaneseSpice();
        Set<Spice> ethiopianSpice = getEthiopianSpice();
        Set<Spice> morrocanSpice = getMorrocanSpice();
        Set<Spice> carribbeanSpice = getCarribbeanSpice();




        try (var em = emf.createEntityManager()) {
            em.getTransaction().begin();

            Cuisine indianCuisne = new Cuisine("Indian","Indian cuisine is known for its rich and bold flavors, often using a combination of spices (referred to as: masala)","Complex, warm, spicy, and aromatic");
            Cuisine middleEasternCuisine = new Cuisine("Middle Eastern","Middle Eastern cuisine uses aromatic and earthy spices to flavor meats, vegetables, and grains","Aromatic, earthy, tangy, and slightly sweet");
            Cuisine mexicanCuisine = new Cuisine("Mexican","Mexican cuisine features bold, smoky, and spicy flavors","Bold, smoky, spicy, and earthy");
            Cuisine chineseCuisine = new Cuisine("Chinese","Chinese cuisine is known for balancing many flavors","Balanced, umami-rich, slightly sweet, sour, and spicy");
            Cuisine thaiCuisine = new Cuisine("Thai","Thai cuisine is known for its bold, vibrant, and complex flavors","Spicy, sweet, sour, and salty with fresh herbal notes");
            Cuisine mediterraneanCuisine = new Cuisine("Mediterranean","Mediterranean cuisine uses fresh herbs and spices to flavor dishes","Fresh, herbal, slightly bitter, and tangy");
            Cuisine japaneseCuisine = new Cuisine("Japanese","Japanese cuisine is known for its delicate and subtle flavors","Delicate, subtle, umami-rich, and slightly sweet");
            Cuisine ethiopianCuisine = new Cuisine("Ethiopian","Ethiopian cuisine uses a variety of spices to create complex and flavorful dishes","Complex, spicy, earthy, and slightly sweet");
            Cuisine morrocanCuisine = new Cuisine("Morrocan","Moroccan cuisine is known for its aromatic and flavorful tagines","Aromatic, flavorful, slightly sweet, and spicy");
            Cuisine carribbeanCuisine = new Cuisine("Carribbean","Caribbean cuisine is known for its bold and spicy flavors","Bold, spicy, sweet, and tangy");

            indianCuisne.setSpice(indianSpice);
            middleEasternCuisine.setSpice(middleEasternSpice);
            mexicanCuisine.setSpice(mexicanSpice);
            chineseCuisine.setSpice(chineseSpice);
            thaiCuisine.setSpice(thaiSpice);
            mediterraneanCuisine.setSpice(mediterraneanSpice);
            japaneseCuisine.setSpice(japaneseSpice);
            ethiopianCuisine.setSpice(ethiopianSpice);
            morrocanCuisine.setSpice(morrocanSpice);
            carribbeanCuisine.setSpice(carribbeanSpice);

            //users
            User user1 = new User("user1", "password1");
            User user2 = new User("user2", "password2");
            User admin = new User("admin", "admin");
            User both = new User("user_admin", "test");

            em.persist(user1);
            em.persist(user2);
            em.persist(admin);
            em.persist(both);

            em.persist(indianCuisne);
            em.persist(middleEasternCuisine);
            em.persist(mexicanCuisine);
            em.persist(chineseCuisine);
            em.persist(thaiCuisine);
            em.persist(mediterraneanCuisine);
            em.persist(japaneseCuisine);
            em.persist(ethiopianCuisine);
            em.persist(morrocanCuisine);
            em.persist(carribbeanCuisine);


            em.getTransaction().commit();
        }
    }

    private static Set<Spice> getIndianSpice() {
        Spice s1 = new Spice("Cumin", "Cumin seeds or ground cumin are staples in curries and spice blends like garam masala", "Warm, earthy, slightly sweet, and bitter");
        Spice s2 = new Spice("Turmeric", "Used for its flavor and bright yellow color, turmeric is a key ingredient in Indian curries", "Earthy, slightly bitter, and peppery");
        Spice s3 = new Spice("Coriander", "Ground coriander seeds are used to add freshness and depth to dishes", "Citrusy, slightly sweet, and floral");
        Spice s4 = new Spice("Cardamom", "Cardamom is used in both sweet dishes and savory curries", "Sweet, floral, and slightly citrusy");

        Spice[] spiceArray = {s1, s2, s3, s4};

        return Set.of(spiceArray);
    }

    private static Set<Spice> getMiddleEasternSpice() {
        Spice s1 = new Spice("Cumin", "Cumin seeds or ground cumin are staples in curries and spice blends like garam masala", "Warm, earthy, slightly sweet, and bitter");
        Spice s2 = new Spice("Sumac", "Ground dried sumac berries are sprinkled over meats, salads, and rice dishes for a citrusy flavor", "Tangy, lemony, and slightly fruity");
        Spice s3 = new Spice("Za'atar", "A blend of thyme, sesame seeds, sumac, and other spices, used to season breads and meats", "Herbal, nutty, and tangy");
        Spice s4 = new Spice("Cinnamon", "Used in both sweet and savory dishes, especially in stews and tagines", "Sweet, warm, and slightly spicy");
        Spice s5 = new Spice("Coriander", "Ground coriander seeds are used to add freshness and depth to dishes", "Citrusy, slightly sweet, and floral");

        Spice[] spiceArray = {s1, s2, s3, s4, s5};

        return Set.of(spiceArray);
    }

    private static Set<Spice> getMexicanSpice() {
        Spice s1 = new Spice("Cumin", "Cumin seeds or ground cumin are staples in curries and spice blends", "Warm, earthy, slightly sweet, and bitter");
        Spice s2 = new Spice("Chili Powder", " Ground dried chilies used in sauces, marinades, and stews", "Spicy, earthy, and slightly smoky");
        Spice s3 = new Spice("Cinnamon", "Used in both sweet and savory dishes, especially in stews and tagines", "Sweet, warm, and slightly spicy");
        Spice s4 = new Spice("Oregano", " Mexican oregano is more pungent and citrusy than Mediterranean oregano and is used in salsas and soups", "Earthy, slightly bitter, and peppery");

        Spice[] spiceArray = {s1, s2, s3, s4};

        return Set.of(spiceArray);
    }

    private static Set<Spice> getChineseSpice() {
        Spice s1 = new Spice("Sichuan Peppercorns", "Unique for its numbing effect, used in Sichuan-style cooking", "Spicy, citrusy, and slightly numbing");
        Spice s2 = new Spice("Star Anise", "Used whole in soups, broths, and stews, particularly in braised dishes", "Sweet, licorice-like, and slightly peppery");
        Spice s3 = new Spice("Five-Spice Powder", "A blend of star anise, cloves, cinnamon, Sichuan peppercorns, and fennel seeds, used in meat marinades and stir-fries", "Sweet, spicy, and aromatic");
        Spice s4 = new Spice("Ginger", "Fresh ginger is essential in stir-fries, soups, and marinades", "Warm, spicy, and slightly sweet");
        Spice s5 = new Spice("Garlic", "Garlic is used to flavor oil in stir-fries and sauces, giving depth to many dishes", "Pungent, spicy, and slightly sweet");

        Spice[] spiceArray = {s1, s2, s3, s4, s5};

        return Set.of(spiceArray);
    }

    private static Set<Spice> getThaiSpice() {
        Spice s1 = new Spice("Galangal", "Similar to ginger but more pungent; used in soups and curries", "Sharp, citrusy, and earthy");
        Spice s2 = new Spice("Lemongrass", "Used fresh in soups, curries, and marinades", "Citrusy and slightly floral");
        Spice s3 = new Spice("Kaffir Lime Leaves", "Adds a fragrant citrus note to curries and soups", "Citrusy and floral");
        Spice s4 = new Spice("Chili Peppers", "Fresh or dried chili peppers are used to add heat to dishes like Thai curries and salads", "Spicy and slightly sweet");
        Spice s5 = new Spice("Turmeric", "Used for its flavor and bright yellow color, turmeric is a key ingredient in Indian curries", "Earthy, slightly bitter, and peppery");

        Spice[] spiceArray = {s1, s2, s3, s4, s5};

        return Set.of(spiceArray);
    }

    private static Set<Spice> getMediterraneanSpice() {
        Spice s1 = new Spice("Oregano", "Mexican oregano is more pungent and citrusy than Mediterranean oregano and is used in salsas and soups", "Earthy, slightly bitter, and peppery");
        Spice s2 = new Spice("Rosemary", " Used to season meats, especially lamb, and roasted vegetables", "Pine-like, slightly bitter, and woody");
        Spice s3 = new Spice("Paprika", "Used in spice rubs for meats and stews", "Sweet, mild, and smoky");
        Spice s4 = new Spice("Coriander", "Ground coriander seeds are used to add freshness and depth to dishes", "Citrusy, slightly sweet, and floral");
        Spice s5 = new Spice("Sumac", "Ground dried sumac berries are sprinkled over meats, salads, and rice dishes for a citrusy flavor", "Tangy, lemony, and slightly fruity");

        Spice[] spiceArray = {s1, s2, s3, s4, s5};

        return Set.of(spiceArray);
    }

    private static Set<Spice> getJapaneseSpice() {
        Spice s1 = new Spice("Shichimi Togarashi","A Japanese spice blend made with chili, orange peel, sesame seeds, and nori, used to season soups, noodles, and grilled meats","Spicy, citrusy, and aromatic");
        Spice s2 = new Spice("Wasabi","A spicy green paste made from the wasabi plant, used to season sushi and sashimi","Spicy, pungent, and slightly sweet");
        Spice s3 = new Spice("Sansho pepper","Similar to Sichuan pepper, used as a seasoning for grilled dishes and soups","Citrusy, spicy, and numbing");
        Spice s4 = new Spice("Soy Sauce","Although not a spice, soy sauce is essential in flavoring Japanese dishes","Salty, umami, and slightly sweet");
        Spice s5 = new Spice("Ginger", "Fresh ginger is essential in stir-fries, soups, and marinades", "Warm, spicy, and slightly sweet");

        Spice[] spiceArray = {s1, s2, s3, s4, s5};

        return Set.of(spiceArray);
    }

    private static Set<Spice> getEthiopianSpice() {
        Spice s1 = new Spice("Berbere","A key spice blend made from chili peppers, garlic, ginger, basil, and other spices, used in stews and meats","Spicy, earthy, and slightly sweet");
        Spice s2 = new Spice("Niter","A clarified butter infused with spices like cumin, fenugreek, and cardamom, used in cooking","Buttery, spicy, and slightly nutty");
        Spice s3 = new Spice("Mitmita","A spicy blend of chili peppers, cardamom, cloves, and salt, used to season meats and stews","Spicy, aromatic, and slightly sweet");
        Spice s4 = new Spice("Cardamom","Adds depth to Ethiopian coffee and savory dishes","Sweet, floral, and slightly citrusy");
        Spice s5 = new Spice("Fenugreek","Used in spice blends and stews","Bitter, nutty, and slightly sweet");

        Spice[] spiceArray = {s1, s2, s3, s4, s5};

        return Set.of(spiceArray);
    }

    private static Set<Spice> getMorrocanSpice() {
        Spice s1 = new Spice("Ras el Hanout","A complex spice blend made with cardamom, cumin, coriander, and other spices, used in tagines and stews","Warm, aromatic, and slightly sweet");
        Spice s2 = new Spice("Saffron","Used to add both color and flavor to rice dishes like couscous and stews","Delicate, slightly sweet, and earthy");
        Spice s3 = new Spice("Cumin", "Cumin seeds or ground cumin are staples in curries and spice blends", "Warm, earthy, slightly sweet, and bitter");
        Spice s4 = new Spice("Cinnamon", "Used in both sweet and savory dishes, especially in stews and tagines", "Sweet, warm, and slightly spicy");
        Spice s5 = new Spice("Paprika", "Used in spice rubs for meats and stews", "Sweet, mild, and smoky");

        Spice[] spiceArray = {s1, s2, s3, s4, s5};

        return Set.of(spiceArray);
    }

    private static Set<Spice> getCarribbeanSpice() {
        Spice s1 = new Spice("Allspice","A dried berry that tastes like a combination of cinnamon, nutmeg, and cloves, used in jerk seasoning and stews","Warm, sweet, and slightly spicy");
        Spice s2 = new Spice("Scotch Bonnet Peppers","A type of chili pepper used in hot sauces and marinades","Spicy, fruity, and slightly sweet");
        Spice s3 = new Spice("Thyme","Used in spice rubs and marinades for meats and stews","Earthy, slightly minty, and lemony");
        Spice s4 = new Spice("Cinnamon", "Used in both sweet and savory dishes, especially in stews and tagines", "Sweet, warm, and slightly spicy");
        Spice s5 = new Spice("Nutmeg","Used in spice blends and desserts","Warm, nutty, and slightly sweet");

        Spice[] spiceArray = {s1, s2, s3, s4, s5};

        return Set.of(spiceArray);
    }

}