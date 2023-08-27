package model.dao;

import db.Db;
import model.dao.impl.SellerDaoJDBC;

public class DaoFactory {

    public static SellerDaoJDBC createSellerDaoJDBC(){
        return new SellerDaoJDBC(Db.getConnection());
    }
    
}
