package service.impl;

import com.google.inject.Inject;
import dto.User;
import entity.UserEntity;
import javafx.scene.control.Alert;
import org.modelmapper.ModelMapper;
import repository.custom.UserDao;
import repository.custom.impl.UserDaoImpl;
import service.custom.UserService;

import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService {
    //@Inject
    UserDao dao = new UserDaoImpl();

    @Override
    public boolean addUser(User user) {
        UserEntity map = new ModelMapper().map(user, UserEntity.class);
        boolean isSave = dao.save(map);

        return isSave;

    }

    @Override
    public User searchUser(String id) {
        UserEntity search = dao.search(id);
        if (search!=null){
          return   new ModelMapper().map(search, User.class);
        }
        return null;
    }

    @Override
    public boolean updateUser(User user) {
        UserEntity map = new ModelMapper().map(user, UserEntity.class);
        return dao.update(map);
    }

    @Override
    public boolean deleteUser(String id) {
        boolean isDelete = dao.delete(id);

        return isDelete;
    }

    @Override
    public List<User> getAll() {
        List<UserEntity> all = dao.getAll();
        ArrayList<User> user = new ArrayList<>();

        for (UserEntity entity:all){
            User map = new ModelMapper().map(entity, User.class);
            user.add(map);
        }
        return user;
    }
}
