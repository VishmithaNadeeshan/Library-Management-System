package service.custom;

import dto.User;
import service.SuperService;

import java.util.List;

public interface UserService extends SuperService {
    boolean addUser(User user);
    User searchUser(String id);
    boolean updateUser(User user);
    boolean deleteUser(String id);
    List<User>getAll();
}
