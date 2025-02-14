package service.custom.Impl;

import com.google.inject.Inject;
import dto.Book;
import entity.BookEntity;
import org.modelmapper.ModelMapper;
import repository.DaoFactory;
import repository.custom.BookDao;
import service.SuperService;
import service.custom.BookService;
import util.DaoType;

import java.util.List;

public class BookServiceImpl implements BookService {
    @Inject
    BookDao dao;
    @Override
    public boolean addBook(Book book) {

        BookEntity map = new ModelMapper().map(book, BookEntity.class);
        boolean isSave = dao.Save(map);
        return isSave;
    }

    @Override
    public boolean searchBook(String id) {

        return false;
    }

    @Override
    public boolean updateBook(Book book) {

        return false;
    }

    @Override
    public boolean deleteBook(String id) {
        boolean isDelete = dao.delete(id);

        return isDelete;
    }

    @Override
    public List<Book> getAll() {

        return List.of();
    }
}
