package service.custom.Impl;

import dto.Book;
import service.SuperService;
import service.custom.BookService;

import java.util.List;

public class BookServiceImpl implements BookService {
    @Override
    public boolean addBook(Book book) {
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
