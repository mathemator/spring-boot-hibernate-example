package com.concretepage.service;

import java.sql.Time;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.concretepage.dao.IOrderDAO;
import com.concretepage.entity.Order;
@Service
public class OrderService implements IOrderService {
	@Autowired
	private IOrderDAO articleDAO;
	@Override
	public Order getOrderByTitle(String title) {
		Order obj = articleDAO.getOrderByTitle(title);
		return obj;
	}

	@Override
	public String getOrderLeftTime(String title) {
		return articleDAO.getOrderLeftTime(title);
	}

	@Override
	public List<Order> getAllOrders(){
		return articleDAO.getAllOrders();
	}

	@Override
	public List<Order> getUnfinishedOrders() {
		return articleDAO.getUnfinishedOrders();
	}

	@Override
	public List<Order> getOrdersByDepartament(String departament) {
		return articleDAO.getOrdersByDepartament(departament);
	}

	@Override
	public List<Order> getOrdersByMaster(String master) {
		return articleDAO.getOrdersByMaster(master);
	}

	@Override
	public synchronized boolean addOrder(Order order){
       if (articleDAO.orderExists(order.getTitle())) {
    	   return false;
       } else {
    	   articleDAO.addArticle(order);
    	   return true;
       }
	}
	@Override
	public void updateOrder(Order order) {
		articleDAO.updateOrder(order);
	}
	@Override
	public void deleteOrder(String title) {
		articleDAO.deleteOrder(title);
	}
}
