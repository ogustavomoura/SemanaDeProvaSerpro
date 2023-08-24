package test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import enums.OrderStatus;

public class OrderTest {

    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    
    @Test
    public void idAddItemWorkingProperly() throws ParseException{
        List<OrderItem> list = new ArrayList<>();
        // public Product(String name, Double price) 
        Product product = new Product("TV", 1400.0);
        // public OrderItem(Integer quantity, Double price, Product product)
        OrderItem orderItem1 = new OrderItem(2, 1800.0, product);
        // public Client(String name, String email, Date birthDate)
        Client client = new Client("Gustavo", "soaares@hotmail.com", sdf.parse("17/11/1996"));
        // public Order(Date moment, OrderStatus orderStatus, Client client)
        Order order = new Order(new Date(), OrderStatus.valueOf("DELIVERED"), client);
        order.addItem(orderItem1);
        list.add(orderItem1);
        Assertions.assertEquals(list, order.getItems());
    }

    @Test
    public void idRemoveItemWorkingProperly() throws ParseException{
        List<OrderItem> list = new ArrayList<>();
        // public Product(String name, Double price) 
        Product product = new Product("TV", 1400.0);
        // public OrderItem(Integer quantity, Double price, Product product)
        OrderItem orderItem1 = new OrderItem(2, 1800.0, product);
        OrderItem orderItem2 = new OrderItem(1, 2800.0, product);
        // public Client(String name, String email, Date birthDate)
        Client client = new Client("Gustavo", "soaares@hotmail.com", sdf.parse("17/11/1996"));
        // public Order(Date moment, OrderStatus orderStatus, Client client)
        Order order = new Order(new Date(), OrderStatus.valueOf("DELIVERED"), client);
        order.addItem(orderItem1);
        order.addItem(orderItem2);
        order.removeItem(orderItem1);
        list.add(orderItem1);
        list.add(orderItem2);
        list.remove(orderItem1);
        Assertions.assertEquals(list, order.getItems());
    }

    @Test
    public void idTotalWorkingProperly() throws ParseException{
        // public Product(String name, Double price) 
        Product product = new Product("TV", 1400.0);
        // public OrderItem(Integer quantity, Double price, Product product)
        OrderItem orderItem1 = new OrderItem(2, 1800.0, product);
        OrderItem orderItem2 = new OrderItem(1, 2800.0, product);
        OrderItem orderItem3 = new OrderItem(4, 1000.0, product);
        // public Client(String name, String email, Date birthDate)
        Client client = new Client("Gustavo", "soaares@hotmail.com", sdf.parse("17/11/1996"));
        // public Order(Date moment, OrderStatus orderStatus, Client client)
        Order order = new Order(new Date(), OrderStatus.valueOf("DELIVERED"), client);
        order.addItem(orderItem1);
        order.addItem(orderItem2);
        order.addItem(orderItem3);
        order.removeItem(orderItem1);
        Assertions.assertEquals(1*2800.0 + 4*1000.0, order.total());
    }
}
