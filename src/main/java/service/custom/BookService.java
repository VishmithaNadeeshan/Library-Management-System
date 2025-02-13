package service.custom;

import dto.Book;
import repository.CRUDRepository;
import service.SuperService;

import java.util.List;

public interface BookService extends SuperService {
    boolean addBook(Book book);
    boolean searchBook(String id);
    boolean updateBook(Book book);
    boolean deleteBook(String id);
    List<Book>getAll();
}
