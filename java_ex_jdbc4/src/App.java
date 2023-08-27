import java.util.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class App {
    public static void main(String[] args) throws Exception {
        
        SellerDao sellerDao = DaoFactory.createSellerDaoJDBC();

        System.out.println("=== findById ===");
        Seller seller = sellerDao.findById(1);
        System.out.println(seller);

        System.out.println("=== findAll ===");
        List<Seller> sellerList = sellerDao.findAll();
        for (Seller element : sellerList){
            System.out.println(element);
        }

        System.out.println("=== findByDepartment ===");
        Department department = new Department(2, "Electronics");
        List<Seller> sellerList2 = sellerDao.findByDepartment(department);
        for (Seller element : sellerList2){
            System.out.println(element);
        }

        System.out.println("=== insert ===");
        Department department2 = new Department(2, "Electronics");
        // public Seller(Integer id, String name, String email, Date birthDate, Double baseSalary, Department department)
        Seller seller2 = new Seller(null, "Gustavo Moura", "soaares@hotmail.com", new Date(), 9000.00, department2);
        sellerDao.insert(seller2);
        System.out.println("Inserted! New id: " + seller2.getId());

        System.out.println("=== update ===");
        Seller seller3 = sellerDao.findById(2);
        seller3.setBaseSalary(0.0);
        sellerDao.update(seller3);
        System.out.println("Updated!");

        System.out.println("=== delete ===");
        sellerDao.deleteById(2);
        System.out.println("Deleted!");

    }
}
