package service.impl;

import dto.BorrowDetails;
import entity.BorrowDetailsEntity;
import jakarta.inject.Inject;
import org.modelmapper.ModelMapper;
import repository.custom.BorrowDetailDao;
import repository.custom.impl.BorrowDetailDaoImpl;
import service.custom.BorrowDetailService;
import service.custom.BorrowService;

public class BorrowDetailServiceImpl implements BorrowDetailService {

    BorrowDetailDao dao = new BorrowDetailDaoImpl();
    @Override
    public boolean add(BorrowDetails borrowDetails) {
        BorrowDetailsEntity map = new ModelMapper().map(borrowDetails, BorrowDetailsEntity.class);
        boolean isSave = dao.save(map);
        return isSave;
    }

    @Override
    public boolean update(BorrowDetails borrowDetails) {
        return false;
    }
}
