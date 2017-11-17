package ru.agoppe.service;

import java.util.List;

import ru.agoppe.entity.Order;

public interface IOrderService {
     List<Order> getAllOrders();
     List<Order> getUnfinishedOrders();
     List<Order> getOrdersByDepartament(String departament);
     List<Order> getOrdersByMaster(String master);
     Order getOrderByTitle(String title);
     String getOrderLeftTime(String title);
     void updateOrder(Order order);
     boolean addOrder(Order article);
     void deleteOrder(String orderTitle);
}
