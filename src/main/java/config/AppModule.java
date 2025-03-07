package config;

import com.google.inject.AbstractModule;
import repository.custom.AdminDao;
import repository.custom.BookDao;
import repository.custom.UserDao;
import repository.custom.impl.AdminDaoImpl;
import repository.custom.impl.BookDaoImpl;
import repository.custom.impl.UserDaoImpl;
import service.custom.AdminService;
import service.custom.BookService;
import service.custom.UserService;
import service.impl.AdminServiceImpl;
import service.impl.BookServiceImpl;
import service.impl.UserServiceImpl;

public class AppModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(BookService.class).to(BookServiceImpl.class);
        bind(BookDao.class).to(BookDaoImpl.class);
        bind(UserService.class).to(UserServiceImpl.class);
        bind(UserDao.class).to(UserDaoImpl.class);
        bind(AdminDao.class).to(AdminDaoImpl.class);
        bind(AdminService.class).to(AdminServiceImpl.class);
    }

}
