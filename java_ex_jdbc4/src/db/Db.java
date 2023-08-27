package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Db {
    
    public static Connection conn = null;

    public static Connection getConnection(){
        if (conn == null){
            try{
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_ex_jdbc4", "developer", "12345678");
            }
            catch(SQLException e){
                throw new DbException(e.getMessage());
            }
        }
        return conn;
    }

    public static void closeConnection(){
        if (conn != null){
            try{
                conn.close();
            }
            catch(SQLException e){
                throw new DbException(e.getMessage());
            }
        }
    }

    public static void closeStatement(Statement st){
        if (st != null){
            try{
                st.close();
            }
            catch(SQLException e){
                throw new DbException(e.getMessage());
            }
        }
    }

    public static void closeResultSet(ResultSet rs){
        if (rs != null){
            try{
                rs.close();
            }
            catch(SQLException e){
                throw new DbException(e.getMessage());
            }
        }
    }

}
