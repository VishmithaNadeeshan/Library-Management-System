package controller;

import dto.BorrowDetails;
import jakarta.inject.Inject;
import service.custom.BorrowDetailService;
import service.impl.BorrowDetailServiceImpl;

import java.util.List;

public class BorrowDetailController {
    BorrowDetailService service  = new BorrowDetailServiceImpl();

    public boolean addBorrowDetail(List<BorrowDetails>borrowDetails){
        for (BorrowDetails borrowDetail : borrowDetails){
            boolean addBorrowDetails = addBorrowDetail(borrowDetail);

            if (!addBorrowDetails) {
                return false;

            }

        }
        return true;

    }

    private boolean addBorrowDetail(BorrowDetails borrowDetail) {
        return service.add(borrowDetail);
    }
}
