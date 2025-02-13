package service;

import javafx.concurrent.Service;
import repository.custom.Impl.BookDaoImpl;
import service.custom.Impl.BookServiceImpl;
import util.ServiceType;

import static util.ServiceType.BOOK;

public class ServiceFactory {
    private static ServiceFactory instance;
    private ServiceFactory() {

    }
    public static ServiceFactory getInstance(){
        return instance==null?instance = new ServiceFactory():instance;

    }
    public <T extends SuperService >T getServiceType(ServiceType type){
        switch(type){
            case BOOK:return (T) new BookServiceImpl();

        }
        return null;
    }
}
