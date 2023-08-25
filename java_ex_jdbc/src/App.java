import java.util.Date;
import java.util.List;

import entities.Department;
import entities.Seller;
import model.dao.DaoFactory;
import model.dao.SellerDao;

public class App {
    public static void main(String[] args) throws Exception {
        
        SellerDao sellerDao = DaoFactory.createSellerDao();

        System.out.println("=== findById ===");
        Seller seller = sellerDao.findById(1);
        System.out.println(seller);

        System.out.println("=== findByDepartment ===");
        Department department = new Department(2, null);
        List<Seller> list = sellerDao.findByDepartment(department);
        for (Seller obj : list){
            System.out.println(obj);
        }

        System.out.println("=== findAll ===");
        List<Seller> list2 = sellerDao.findAll();
        for (Seller obj : list2){
            System.out.println(obj);
        }

        System.out.println("=== Insert ===");
        Department department2 = new Department(2, "Electronics");
        // Seller(Integer id, String name, String email, Date birthDate, Double baseSalary, Department department)
        // Department(Integer id, String name)
        Seller seller2 = new Seller(null, "Gustavo Moura", "soaares@hotmail.com", new Date(), 4000.0, department2);
        sellerDao.insert(seller2);
        System.out.println("Inserted! New id = " + seller2.getId());

        System.out.println("=== Seller Update ===");
        Seller seller3 = sellerDao.findById(2);
        seller3.setName("Martha Waine");
        sellerDao.update(seller3);
        System.out.println("Update completed!");

        System.out.println("=== DeleteById ===");
        sellerDao.deleteById(5);
        System.out.println("Delete completed");

    }
}
