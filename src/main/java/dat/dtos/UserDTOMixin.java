package dat.dtos;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Set;

public abstract class UserDTOMixin {
    @JsonCreator
    public UserDTOMixin(
            @JsonProperty("username") String username,
            @JsonProperty("password") String password,
            @JsonProperty("roles") Set<String> roles
    ) {}
}
