package service.impl;

import dto.Book;
import dto.Borrow;
import jakarta.inject.Inject;
import service.custom.BookService;
import service.custom.BorrowService;

import java.util.List;

public class BorrowServiceImpl implements BorrowService {


    @Override
    public boolean placeBorrowOrder(Borrow borrow) {
        return false;
    }

    @Override
    public List<Borrow> getAll() {

        return List.of();
    }



}
