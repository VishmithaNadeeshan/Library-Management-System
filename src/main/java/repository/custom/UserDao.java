package repository.custom;

import entity.UserEntity;
import repository.CRUDRepository;

public interface UserDao extends CRUDRepository<UserEntity, String> {
}
