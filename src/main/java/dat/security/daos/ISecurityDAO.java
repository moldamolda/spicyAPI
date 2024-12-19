package dat.security.daos;

import dat.dtos.UserDTO;
import dat.security.entities.User;
import dat.security.exceptions.ValidationException;

public interface ISecurityDAO {
    UserDTO getVerifiedUser(String username, String password) throws ValidationException;
    User createUser(String username, String password);
    User addRole(UserDTO user, String newRole);
}
