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
        dao.Save(map);
        return false;
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

        return false;
    }

    @Override
    public List<Book> getAll() {

        return List.of();
    }
}
