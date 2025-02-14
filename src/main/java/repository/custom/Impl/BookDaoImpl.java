package repository.custom.Impl;

import entity.BookEntity;
import repository.CRUDRepository;
import repository.custom.BookDao;

import java.util.List;

public class BookDaoImpl implements BookDao {


    @Override
    public boolean Save(BookEntity entity) {
        System.out.println("Repository"+entity);
        return false;
    }

    @Override
    public boolean add(String s, BookEntity entity) {
        return false;
    }

    @Override
    public boolean update(String s, BookEntity entity) {
        return false;
    }

    @Override
    public boolean delete(String s, BookEntity entity) {
        return false;
    }

    @Override
    public BookEntity search(BookEntity entity) {
        return null;
    }

    @Override
    public List<BookEntity> getAll() {
        return List.of();
    }
}
