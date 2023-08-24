package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import entities.OrderItem;
import entities.Product;

public class OrderItemTest {
    
    @Test
    public void isSubTotalWorkingProperly(){
        // public Product(String name, Double price) 
        Product product = new Product("TV", 1400.0);
        // public OrderItem(Integer quantity, Double price, Product product)
        OrderItem orderItem = new OrderItem(2, 1800.0, product);
        Assertions.assertEquals(3600.0, orderItem.subTotal());
    }

}
