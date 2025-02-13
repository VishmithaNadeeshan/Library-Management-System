package service.custom;

import dto.Book;

import java.util.List;

public interface BookService {
    boolean addBook(Book book);
    boolean searchBook(String id);
    boolean updateBook(Book book);
    boolean deleteBook(String id);
    List<Book>getAll();
}
