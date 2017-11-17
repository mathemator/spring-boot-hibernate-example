package ru.agoppe.dao;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.agoppe.entity.Order;




@Transactional
@Repository
public interface IOrderDAO {
    List<Order> getAllOrders();
    List<Order> getUnfinishedOrders();
    List<Order> getOrdersByDepartament(String departament);
    List<Order> getOrdersByMaster(String master);
    Order getOrderByTitle(String title);
    String getOrderLeftTime(String title);
    void addOrder(Order order);
    void updateOrder(Order order);
    void deleteOrder(String orderTitle);
    boolean orderExists(String order);
}
 