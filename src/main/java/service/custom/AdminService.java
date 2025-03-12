package service.custom;

import dto.Admin;
import entity.AdminEntity;
import service.SuperService;

public interface AdminService extends SuperService {
    boolean addAdmin(Admin admin);

    AdminEntity searchAdmin(String string);
}
