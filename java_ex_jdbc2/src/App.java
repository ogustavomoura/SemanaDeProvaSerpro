import java.util.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class App {
    public static void main(String[] args) throws Exception {
        
        SellerDao sellerDao = DaoFactory.createSellerDao();
        
        System.out.println("=== findById ===");
        Seller seller = sellerDao.findById(2);
        System.out.println(seller);

        System.out.println("=== findAll ===");
        List<Seller> sellerList = sellerDao.findAll();
        for (Seller element : sellerList){
            System.out.println(element);
        }

        System.out.println("=== findByDepartment ===");
        // public Department(Integer id, String name)
        Department department = new Department(2, null);
        List<Seller> sellerList2 = sellerDao.findByDepartment(department);
        for (Seller element : sellerList2){
            System.out.println(element);
        }

        System.out.println("=== Insert ===");
        // public Seller(Integer id, String name, String email, Date birthDate, Double baseSalary, Department department)
        Department department2 = new Department(2, "Electronics");
        Seller seller2 = new Seller(null, "Gustavo Moura", "soaares@hotmail.com", new Date(), 1500.0, department2);
        sellerDao.insert(seller2);
        System.out.println("Inserted! New id = " + seller2.getId());

        System.out.println("=== Update ===");
        Seller seller3 = sellerDao.findById(2);
        seller3.setName("NomeTeste");
        sellerDao.update(seller3);
        System.out.println("Update completed!");

        System.out.println("=== DeleteById ===");
        sellerDao.deleteById(11);
        System.out.println("Delete completed!");

    }
}
