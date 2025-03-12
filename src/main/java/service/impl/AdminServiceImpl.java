package service.impl;

import dto.Admin;
import dto.Book;
import entity.AdminEntity;
import jakarta.inject.Inject;
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

    @Override
    public AdminEntity searchAdmin(String txtEmail){
        AdminEntity search = dao.search(txtEmail);
        if (search != null) {
            return new ModelMapper().map(search, AdminEntity.class);
        }
        return null;
    }
}
