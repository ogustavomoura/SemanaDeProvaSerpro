package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import db.Db;
import db.DbException;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class SellerDaoJDBC implements SellerDao{

    private Connection conn;

    public SellerDaoJDBC(Connection conn) {
        this.conn = conn;
    }

    @Override
    public Seller findById(Integer id) {
        PreparedStatement st = null;
        ResultSet rs = null;

        try{
            st = conn.prepareStatement(
                "SELECT seller.*, department.Name as DepName "
                + "FROM seller INNER JOIN department "
                + "ON seller.DepartmentId = department.Id "
                + "WHERE seller.Id = ?"
                );
                st.setInt(1, id);
                rs = st.executeQuery();

                if (rs.next()){
                    // public Department(Integer id, String name)
                    Department department = new Department(rs.getInt("DepartmentId"), rs.getString("DepName"));
                    // public Seller(Integer id, String name, String email, Date birthDate, Double baseSalary, Department department)
                    Seller seller = new Seller(rs.getInt("id"), rs.getString("Name"), rs.getString("Email"), rs.getDate("BirthDate"),
                                            rs.getDouble("baseSalary"), department);
                    return seller;
                }
                return null;
        }
        catch(SQLException e){
            throw new DbException(e.getMessage());
        }
        finally{
            Db.closeStatement(st);
            Db.closeResultSet(rs);
        }
    }

    @Override
    public List<Seller> findByDepartment(Department department) {
        PreparedStatement st = null;
        ResultSet rs = null;

        try{
            st = conn.prepareStatement(
                "SELECT seller.*, department.Name as DepName "
                + "FROM seller INNER JOIN department "
                + "ON seller.DepartmentId = department.Id "
                + "WHERE DepartmentId = ?"
                );
                st.setInt(1, department.getId());
                rs = st.executeQuery();

                List<Seller> list = new ArrayList<>();
                Map<Integer, Department> map = new HashMap<>();

                while (rs.next()){
                    Department dep = map.get(department.getId());

                    if (dep == null){
                        // public Department(Integer id, String name)
                        dep = new Department(rs.getInt("DepartmentId"), rs.getString("DepName"));
                        map.put(rs.getInt("DepartmentId"), dep);
                    }
                    // public Seller(Integer id, String name, String email, Date birthDate, Double baseSalary, Department department)
                    Seller seller = new Seller(rs.getInt("id"), rs.getString("Name"), rs.getString("Email"), rs.getDate("BirthDate"),
                                            rs.getDouble("baseSalary"), dep);
                    list.add(seller);
                }
                return list;
        }
        catch(SQLException e){
            throw new DbException(e.getMessage());
        }
        finally{
            Db.closeStatement(st);
            Db.closeResultSet(rs);
        }
    }

    @Override
    public List<Seller> findAll() {
        PreparedStatement st = null;
        ResultSet rs = null;

        try{
            st = conn.prepareStatement(
                "SELECT seller.*, department.Name as DepName "
                + "FROM seller INNER JOIN department "
                + "ON seller.DepartmentId = department.Id "
                + "ORDER BY Id"
                );
                rs = st.executeQuery();

                List<Seller> list = new ArrayList<>();
                Map<Integer, Department> map = new HashMap<>();

                while (rs.next()){
                    Department dep = map.get(rs.getInt("DepartmentId"));

                    if (dep == null){
                        // public Department(Integer id, String name)
                        dep = new Department(rs.getInt("DepartmentId"), rs.getString("DepName"));
                        map.put(rs.getInt("DepartmentId"), dep);
                    }
                    // public Seller(Integer id, String name, String email, Date birthDate, Double baseSalary, Department department)
                    Seller seller = new Seller(rs.getInt("id"), rs.getString("Name"), rs.getString("Email"), rs.getDate("BirthDate"),
                                            rs.getDouble("baseSalary"), dep);
                    list.add(seller);
                }
                return list;
        }
        catch(SQLException e){
            throw new DbException(e.getMessage());
        }
        finally{
            Db.closeStatement(st);
            Db.closeResultSet(rs);
        }
    }

    @Override
    public void insert(Seller seller) {
        PreparedStatement st = null;
        ResultSet rs = null;

        try{
            st = conn.prepareStatement(
                "INSERT INTO seller "
                + "(Name, Email, BirthDate, BaseSalary, DepartmentId) "
                + "VALUES "
                + "(?, ?, ?, ?, ?)",
                Statement.RETURN_GENERATED_KEYS
                );

                st.setString(1, seller.getName());
                st.setString(2, seller.getEmail());
                st.setDate(3, new java.sql.Date(seller.getBirthDate().getTime()));
                st.setDouble(4, seller.getBaseSalary());
                st.setInt(5, seller.getDepartment().getId());

                int rowsAffected = st.executeUpdate();

                if (rowsAffected > 0){
                    rs = st.getGeneratedKeys();
                    if (rs.next()){
                        int id = rs.getInt(1);
                        seller.setId(id);
                    }
                }
                else{
                    throw new DbException("Error! None line affected!");
                }
        }
        catch(SQLException e){
            throw new DbException(e.getMessage());
        }
        finally{
            Db.closeStatement(st);
            Db.closeResultSet(rs);
        }
    }

    @Override
    public void update(Seller seller) {
        PreparedStatement st = null;
        // ResultSet rs = null;

        try{
            st = conn.prepareStatement(
                "UPDATE seller "
                + "SET Name = ?, Email = ?, BirthDate = ?, BaseSalary = ?, DepartmentId = ? "
                + "WHERE Id = ? " 
                );

                st.setString(1, seller.getName());
                st.setString(2, seller.getEmail());
                st.setDate(3, new java.sql.Date(seller.getBirthDate().getTime()));
                st.setDouble(4, seller.getBaseSalary());
                st.setInt(5, seller.getDepartment().getId());
                st.setInt(6, seller.getId());

                st.executeUpdate();
        }
        catch(SQLException e){
            throw new DbException(e.getMessage());
        }
        finally{
            Db.closeStatement(st);
            //Db.closeResultSet(rs);
        }
    }

    @Override
    public void deleteById(Integer id) {
        PreparedStatement st = null;
        // ResultSet rs = null;

        try{
            st = conn.prepareStatement(
                "DELETE FROM seller "
                + "WHERE Id = ? " 
                );

                st.setInt(1, id);

                int rows = st.executeUpdate();

                if (rows == 0){
                    throw new DbException("Error! This id not exists!");
                }
        }
        catch(SQLException e){
            throw new DbException(e.getMessage());
        }
        finally{
            Db.closeStatement(st);
            //Db.closeResultSet(rs);
        }
    }
    
}
