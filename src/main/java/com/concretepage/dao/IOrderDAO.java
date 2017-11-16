package com.concretepage.dao;
import java.sql.Time;
import java.util.Date;
import java.util.List;
import com.concretepage.entity.Order;
public interface IOrderDAO {
    List<Order> getAllOrders();
    List<Order> getUnfinishedOrders();
    List<Order> getOrdersByDepartament(String departament);
    List<Order> getOrdersByMaster(String master);
    Order getOrderByTitle(String title);
    String getOrderLeftTime(String title);
    void addOrder(Order order);
    void updateOrder(Order order);
    void addArticle(Order article);
    void deleteOrder(String orderTitle);
    boolean orderExists(String order);
}
 