package repository.custom.impl;

import entity.BorrowEntity;
import repository.custom.AdminDao;
import repository.custom.BorrowDao;

import java.util.List;

public class BorrowDaoImpl implements BorrowDao {
    @Override
    public boolean save(BorrowEntity entity) {
        return false;
    }

    @Override
    public BorrowEntity search(String string) {
        return null;
    }

    @Override
    public boolean update(BorrowEntity entity) {
        return false;
    }

    @Override
    public boolean delete(String string) {
        return false;
    }

    @Override
    public List<BorrowEntity> getAll() {
        return List.of();
    }
}
