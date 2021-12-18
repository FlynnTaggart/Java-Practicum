package Prac15and16.Orders;

import Prac15and16.Customers.Customer;
import Prac15and16.Items.Item;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;

public class RestaurantOrder implements Order{
    private ArrayList<Item> items = new ArrayList<>();
    private int size = 0;
    private Customer customer;
    private Item head;

    @Override
    public boolean add(Item item){
        items.add(item);
        if (size == 0)
            head = item;
        size++;
        return true;
    }

    @Override
    public boolean remove(String itemName){
        for (Item i : items){
            if (i.getName().equals(itemName))
                return items.remove(i);
        }
        return false;
    }

    @Override
    public boolean remove(Item item){
        for (Item i : items){
            if (i.getName().equals(item.getName()))
                return items.remove(i);
        }
        return false;
    }

    @Override
    public int removeAll(String itemName){
        int cnt = 0;
        for (Item i : items)
            if (i.getName().equals(itemName)) {
                items.remove(i);
                cnt++;
            }
        return cnt;
    }

    @Override
    public int removeAll(Item item){
        int cnt = 0;
        for (Item i : items)
            if (i.getName().equals(item.getName())) {
                items.remove(i);
                cnt++;
            }
        return cnt;
    }

    @Override
    public String getOrderInfo(){
        StringBuilder s = new StringBuilder();
        for (Item i : items){
            s.append(i.getName()).append(" ").append(i.getDescription()).append(" ").append(i.getPrice()).append("\n");
        }
        return s.toString();
    }

    @Override
    public int itemQuantity(){
        return size;
    }

    @Override
    public int itemQuantity(Item item){
        int count = 0;
        for (Item i : items){
            if (i.getName().equals(item.getName()))
                count++;
        }
        return count;
    }

    @Override
    public int itemQuantity(String itemName){
        int count = 0;
        for (Item i : items){
            if (i.getName().equals(itemName))
                count++;
        }
        return count;
    }

    @Override
    public Item[] getItems(){
        return (Item[]) items.toArray();
    }

    @Override
    public double costTotal(){
        int totalCost =0;
        for (Item i : items){
            totalCost += i.getPrice();
        }
        return totalCost;
    }

    @Override
    public String[] itemsNames(){
        HashSet<String> set = new HashSet<>();
        for (Item i : items){
            set.add(i.getName());
        }
        String[] s = new String[set.size()];
        int index = 0;
        for(String i : set){
            s[index] = i;
            index++;
        }
        return s;
    }

    @Override
    public Item[] sortedItemsByCostDesc(){
        ArrayList<Item> sorted = items;
        sorted.sort(Comparator.comparing(Item::getPrice));
        Collections.reverse(sorted);
        return (Item[]) sorted.toArray();
    }

    @Override
    public void setCustomer(Customer customer){
        this.customer = customer;
    }

    @Override
    public Customer getCustomer(){
        return customer;
    }
}
