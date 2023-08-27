package model.dao;

import java.util.List;

import model.entities.Department;
import model.entities.Seller;

public interface SellerDao {

    public Seller findById(Integer id);
    public List<Seller> findAll();
    public List<Seller> findByDepartment(Department department);
    public void insert(Seller seller);
    public void update(Seller seller);
    public void deleteById(Integer id);
    
}
