package Prac15and16.Orders;

import Prac15and16.Customers.Customer;
import Prac15and16.Items.Item;

import java.util.Arrays;
import java.util.HashMap;

public class InternetOrdersManager implements OrdersManager{
    private HashMap<Customer,Order> adressedOrders = new HashMap<>();

    public void add(Customer address, Order order){
        adressedOrders.put(address,order);
    }

    public Order getOrder(Customer address){return adressedOrders.get(address);}

    public void addItem(Item item, Customer address){
        adressedOrders.get(address).add(item);
    }

    public void removeOrder(Customer address){
        adressedOrders.remove(address);
    }

    public HashMap<Customer,Order> getOrders(){
        return adressedOrders;
    }

    @Override
    public double ordersCostSummary(){
        double cost =0;
        for (Customer i : adressedOrders.keySet()){
            cost += adressedOrders.get(i).costTotal();
        }
        return cost;
    }

    @Override
    public int itemQuantity(String dishName){
        int count =0;
        for (Customer i : adressedOrders.keySet()){
            count += adressedOrders.get(i).itemQuantity(dishName);
        }
        return count;
    }

    @Override
    public int itemQuantity(Item dish){
        int count =0;
        for (Customer i : adressedOrders.keySet()){
            count += adressedOrders.get(i).itemQuantity(dish.getName());
        }
        return count;
    }

    @Override
    public int ordersQuantity(){
        return adressedOrders.size();
    }

    public String readAddressedOrders(){
        StringBuilder message = new StringBuilder();
        for (Customer i : adressedOrders.keySet()){
            String itemNames = Arrays.toString(adressedOrders.get(i).itemsNames());
            message.append(itemNames.substring(1, itemNames.length() - 1)).append("\n");
        }
        return message.toString();
    }
}
