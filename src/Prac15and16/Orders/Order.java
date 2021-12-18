package Prac15and16.Orders;

import Prac15and16.Customers.Customer;
import Prac15and16.Items.Item;

public interface Order {
    boolean add(Item item);
    String[] itemsNames();
    int itemQuantity();
    int itemQuantity(String itemName);
    int itemQuantity(Item item);
    Item[] getItems();
    boolean remove(String itemName);
    boolean remove (Item item);
    int removeAll(String itemName);
    int removeAll(Item item);
    String getOrderInfo();
    Item[] sortedItemsByCostDesc();
    double costTotal();
    Customer getCustomer();
    void setCustomer(Customer customer);
}
