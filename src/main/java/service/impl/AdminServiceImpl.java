package service.impl;

import com.google.inject.Inject;
import dto.Admin;
import entity.AdminEntity;
import org.modelmapper.ModelMapper;
import repository.custom.AdminDao;
import service.custom.AdminService;

public class AdminServiceImpl implements AdminService {
    @Inject
    AdminDao dao;
    @Override
    public boolean addAdmin(Admin admin) {
        AdminEntity map = new ModelMapper().map(admin, AdminEntity.class);
        boolean isSave = dao.save(map);
        return isSave;
    }
}
