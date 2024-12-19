package dat.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import dat.entities.Favorite;
import dat.entities.Spice;
import dat.entities.Cuisine;
import lombok.*;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class FavoriteDTO {

    @JsonProperty("id")
    private long id;

    @JsonProperty("user_name")
    private String username;

    @JsonProperty("name")
    private String name;

    @JsonProperty("spices")
    @EqualsAndHashCode.Exclude
    private Set<String> spices = new HashSet<>();

    @JsonProperty("cuisines")
    @EqualsAndHashCode.Exclude
    private Set<String> cuisines = new HashSet<>();

    // Constructor to map from the Favorite entity to FavoriteDTO
    public FavoriteDTO(Favorite favorite) {
        this.id = favorite.getId();
        this.username = favorite.getUser().getUsername();
        this.name = favorite.getName();

        if (favorite.getSpices() != null) {
            this.spices = favorite.getSpices().stream()
                    .map(Spice::getName)
                    .collect(Collectors.toSet());
        }

        if (favorite.getCuisines() != null) {
            this.cuisines = favorite.getCuisines().stream()
                    .map(Cuisine::getName)
                    .collect(Collectors.toSet());
        }
    }
}
