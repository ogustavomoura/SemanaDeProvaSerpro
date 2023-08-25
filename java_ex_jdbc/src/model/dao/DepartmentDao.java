package model.dao;

import java.util.List;

import entities.Department;
import entities.Seller;

public interface DepartmentDao {
    
    void insert(Seller obj);
    void update(Seller obj);
    void deleteById(Seller obj);
    Seller findById(Integer id);
    List<Department> findAll();
}
