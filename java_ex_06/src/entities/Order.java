package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import enums.OrderStatus;

public class Order {
    
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    List<OrderItem> items = new ArrayList<>();

    private Date moment;
    private OrderStatus orderStatus;
    private Client client;

    public Order(){

    }

    public Order(Date moment, OrderStatus orderStatus, Client client) {
        this.moment = moment;
        this.orderStatus = orderStatus;
        this.client = client;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    // public void setItems(List<OrderItem> items) {
    //     this.items = items;
    // }

    public Date getMoment() {
        return moment;
    }

    public void setMoment(Date moment) {
        this.moment = moment;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "Order [items=" + items + ", moment=" + moment + ", orderStatus=" + orderStatus + ", client=" + client
                + "]";
    }

    public void addItem(OrderItem item){
        items.add(item);
    }

    public void removeItem(OrderItem item){
        items.remove(item);
    }

    public Double total() {
        double sum = 0.0;
        for (OrderItem item : items){
            sum += item.subTotal();
        }
        return sum;
    }

}
