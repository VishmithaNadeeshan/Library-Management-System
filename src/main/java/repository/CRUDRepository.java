package repository;

import java.util.List;

public interface CRUDRepository <T, ID> extends SuperDao{
    boolean Save(T entity);
    boolean update(ID id, T entity);
    boolean delete(ID id);
    T search(T entity);
    List<T> getAll();
}
