package model.dao;

import java.util.List;

import model.entities.Department;

public interface DepartmentDao {

    public Department findById(Integer id);
    public List<Department> findAll();
    public void insert(Department department);
    public void update(Department department);
    public void deleteById(Department department);
    
}
