package service.custom;

import dto.BorrowDetails;
import service.SuperService;

public interface BorrowDetailService extends SuperService {
    boolean add(BorrowDetails borrowDetails);
    boolean update(BorrowDetails borrowDetails);
}
