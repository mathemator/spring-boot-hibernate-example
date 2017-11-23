package ru.agoppe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ru.agoppe.dao.IOrderDAO;
import ru.agoppe.entity.Order;
@Service
public class OrderService implements IOrderService {
	@Autowired
	private IOrderDAO orderDAO;
	@Override
	public Order getOrderByTitle(String title) {
		Order obj = orderDAO.getOrderByTitle(title);
		return obj;
	}

	@Override
	public String getOrderLeftTime(String title) {
		return orderDAO.getOrderLeftTime(title);
	}

	@Override
	public List<Order> getAllOrders(){
		return orderDAO.getAllOrders();
	}

	@Override
	public List<Order> getUnfinishedOrders() {
		return orderDAO.getUnfinishedOrders();
	}

	@Override
	public List<Order> getOrdersByDepartament(String departament) {
		return orderDAO.getOrdersByDepartament(departament);
	}

	@Override
	public List<Order> getOrdersByMaster(String master) {
		return orderDAO.getOrdersByMaster(master);
	}

	@Override
	public synchronized boolean addOrder(Order order){
       if (orderDAO.orderExists(order.getTitle())) {
    	   return false;
       } else {
    	   orderDAO.addOrder(order);
    	   return true;
       }
	}
	@Override
	public void updateOrder(Order order) {

		orderDAO.updateOrder(order);
	}
	@Override
	public void deleteOrder(String title) {

		orderDAO.deleteOrder(title);
	}
}
