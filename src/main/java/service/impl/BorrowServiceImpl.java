package service.impl;

import dto.Book;
import dto.Borrow;
import entity.BorrowEntity;
import jakarta.inject.Inject;
import org.modelmapper.ModelMapper;
import repository.custom.BorrowDao;
import repository.custom.impl.BorrowDaoImpl;
import service.custom.BookService;
import service.custom.BorrowService;

import java.util.List;

public class BorrowServiceImpl implements BorrowService {
    BorrowDao dao = new BorrowDaoImpl();

    @Override
    public boolean placeBorrowOrder(Borrow borrow) {
        BorrowEntity map = new ModelMapper().map(borrow, BorrowEntity.class);
        boolean isSave = dao.save(map);
        return isSave;
    }

    @Override
    public List<Borrow> getAll() {

        return List.of();
    }



}
