package Prac15and16.Orders;

import Prac15and16.Items.Item;

public interface OrdersManager {
    int itemQuantity(String dishName);
    int itemQuantity(Item dish);
    double ordersCostSummary();
    int ordersQuantity();
}
