package service.custom;

import dto.Borrow;
import service.SuperService;

import java.util.List;

public interface BorrowService extends SuperService {
    boolean placeBorrowOrder(Borrow borrow);
    List<Borrow>getAll();
}
