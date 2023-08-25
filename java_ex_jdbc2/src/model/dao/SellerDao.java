package model.dao;

import java.util.List;

import model.entities.Department;
import model.entities.Seller;

public interface SellerDao {

    Seller findById(Integer id); 
    List<Seller> findByDepartment (Department department);
    List<Seller> findAll();
    void insert(Seller seller);
    void update(Seller seller);
    void deleteById (Integer id);
    
}
