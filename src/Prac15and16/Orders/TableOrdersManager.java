package Prac15and16.Orders;

import Prac15and16.Exceptions.IllegalTableNumberException;
import Prac15and16.Exceptions.OrderAlreadyAddedException;
import Prac15and16.Items.Item;

import java.util.ArrayList;
import java.util.Arrays;

public class TableOrdersManager implements OrdersManager{
    ArrayList<Order> restaurantOrders = new ArrayList<>();
    boolean[] tableFreeArray;

    public TableOrdersManager(int tableQuantity){
        tableFreeArray = new boolean[tableQuantity];
        for (int i =0;i<tableQuantity;i++){
            tableFreeArray[i] = false;
            restaurantOrders.add(null);
        }
    }

    @Override
    public double ordersCostSummary(){
        double cost = 0;
        for (Order i : restaurantOrders){
            cost += i.costTotal();
        }
        return cost;
    }

    @Override
    public int ordersQuantity() {
        return restaurantOrders.size();
    }

    @Override
    public int itemQuantity(String dishName){
        int count = 0;
        for (Order i : restaurantOrders){
            count += i.itemQuantity(dishName);
        }
        return count;
    }

    @Override
    public int itemQuantity(Item dish) {
        int count = 0;
        for (Order i : restaurantOrders){
            count += i.itemQuantity(dish.getName());
        }
        return count;
    }

    public void add(Order restaurantOrder, int tableNumber) throws OrderAlreadyAddedException, IllegalTableNumberException {
        if (tableNumber <= 0 || tableNumber >= tableFreeArray.length)
            throw new IllegalTableNumberException("Столика с таким номером не существует");
        if (tableFreeArray[tableNumber])
            throw new OrderAlreadyAddedException("Со столика уже был сделан заказ");
        restaurantOrders.add(tableNumber, restaurantOrder);
        tableFreeArray[tableNumber] = true;
    }

    public Order getOrder(int tableNumber) throws IllegalTableNumberException {
        if (tableNumber < 0 || tableNumber > tableFreeArray.length)
            throw new IllegalTableNumberException("Столика с таким номером не существует");
        return restaurantOrders.get(tableNumber);
    }

    public void addItem(Item item, int tableNumber) throws IllegalTableNumberException {
        if (tableNumber < 0 || tableNumber > tableFreeArray.length)
            throw new IllegalTableNumberException("Столика с таким номером не существует");
        restaurantOrders.get(tableNumber).add(item);
    }

    public void removeOrder(int tableNumber){
        restaurantOrders.remove(tableNumber);
        tableFreeArray[tableNumber] = false;
    }

    public int freeTableNumber(){
        int index;
        for (int i = 0; i < tableFreeArray.length; i++){
            if (!tableFreeArray[i]){
                index = i;
                return index;
            }
        }
        return -1;
    }

    public int[] freeTableNumbers(){
        int size = 0;
        for (boolean b : tableFreeArray)
            if (!b)
                size++;
        int[] number = new int[size];
        int cnt = 0;
        for (int i = 0; i < tableFreeArray.length; i++)
            if (!tableFreeArray[i]) {
                number[cnt] = i;
                cnt++;
            }
        return number;
    }

    public ArrayList<Order> getOrders(){
        return restaurantOrders;
    }

    public String readOrders(){
        StringBuilder message = new StringBuilder();
        for (Order i : restaurantOrders)
            if(i != null) {
                String itemNames = Arrays.toString(i.itemsNames());
                message.append(itemNames.substring(1, itemNames.length() - 1)).append("\n");
            }
        return message.toString();
    }
}
