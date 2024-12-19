package dat.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Data

@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDTO {
    @JsonProperty("username")
    private String username;
    @JsonProperty("password")
    private String password;
    Set<String> roles = new HashSet();
    @JsonProperty("id")
    private Long id;

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o != null && this.getClass() == o.getClass()) {
            UserDTO dto = (UserDTO)o;
            return Objects.equals(this.username, dto.username) && Objects.equals(this.roles, dto.roles);
        } else {
            return false;
        }
    }

    public UserDTO(String username, String password) {
        this.username = username;
        this.password = password;
    }
    public UserDTO(String username, Set<String> roles) {
        this.username = username;
        this.roles = roles;
    }

    public UserDTO(String username, Set<String> roles, Long id) {
        this.username = username;
        this.roles = roles;
        this.id = id;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.username, this.roles});
    }

    public static UserDTO.UserDTOBuilder builder() {
        return new UserDTO.UserDTOBuilder();
    }


    public String toString() {
        String var10000 = this.getUsername();
        return "UserDTO(username=" + var10000 + ", password=" + this.getPassword() + ", roles=" + this.getRoles() + ")";
    }

    public UserDTO(String username, String password, Set<String> roles) {
        this.username = username;
        this.password = password;
        this.roles = roles;

    }

    public UserDTO() {
    }

    public static class UserDTOBuilder {
        private String username;
        private String password;
        private Set<String> roles;

        UserDTOBuilder() {
        }

        public UserDTO.UserDTOBuilder username(String username) {
            this.username = username;
            return this;
        }

        public UserDTO.UserDTOBuilder password(String password) {
            this.password = password;
            return this;
        }

        public UserDTO.UserDTOBuilder roles(Set<String> roles) {
            this.roles = roles;
            return this;
        }

        public dk.bugelhartmann.UserDTO build() {
            return new dk.bugelhartmann.UserDTO(this.username, this.password, this.roles);
        }

        public String toString() {
            return "UserDTO.UserDTOBuilder(username=" + this.username + ", password=" + this.password + ", roles=" + this.roles + ")";
        }
    }
}
