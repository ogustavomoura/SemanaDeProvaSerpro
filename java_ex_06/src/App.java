import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import enums.OrderStatus;

public class App {
    public static void main(String[] args) throws Exception {
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter client data: ");
        System.out.print("\nName: ");
        String name = sc.nextLine();
        System.out.print("E-mail: ");
        String email = sc.nextLine();
        System.out.print("Birth Date (DD/MM/YYYY): ");
        Date birthDate = sdf.parse(sc.next());
        sc.nextLine();
        // public Client(String name, String email, Date birthDate)
        Client client = new Client(name, email, birthDate);
        
        System.out.print("Enter order data: ");
        System.out.print("\nStatus: ");
        String status = sc.nextLine();
        System.out.print("How many items to this order? ");
        int qtde = sc.nextInt();
        sc.nextLine();

        // public Order(Date moment, OrderStatus orderStatus, Client client)
        Order order = new Order(new Date(), OrderStatus.valueOf(status), client);

        for (int i = 0; i < qtde; i++){
            System.out.print("Enter #" + (int)(i + 1) +  " item data: ");
            System.out.print("\nProduct name: ");
            String productName = sc.nextLine();
            System.out.print("Product price: ");
            double productPrice = sc.nextDouble();
            sc.nextLine();
            System.out.print("Quantity: ");
            int productQtde = sc.nextInt();
            sc.nextLine();

            // public Product(String name, Double price)
            Product product = new Product(productName, productPrice);
            // public OrderItem(Integer quantity, Double price, Product product) 
            OrderItem orderItem = new OrderItem(productQtde, productPrice, product);
            order.addItem(orderItem);
        }
        
        System.out.print("\nORDER SUMMARY");
        System.out.print("\nOrder moment: " + sdf1.format(order.getMoment()));
        System.out.print("\nOrder status: " + order.getOrderStatus());
        System.out.print("\nClient: " + client);
        System.out.print("\nOrder items: " + order.getItems());
        System.out.print("\nTotal price: " + order.total());

        sc.close();

    }
}
