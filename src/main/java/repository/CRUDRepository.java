package repository;

import java.util.List;

public interface CRUDRepository <T, ID> extends SuperDao{
    boolean Save(T entity);
    boolean add(ID id, T entity);
    boolean update(ID id, T entity);
    boolean delete(ID id, T entity);
    T search(T entity);
    List<T> getAll();
}
