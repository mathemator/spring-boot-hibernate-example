package ru.agoppe.dao;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ru.agoppe.entity.Master;
import ru.agoppe.entity.Order;

@Transactional
@Repository
public class OrderDAO implements IOrderDAO {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Order getOrderByTitle(String title) {
        String hql = "FROM Order where title = ? ";
        return (Order) entityManager.createQuery(hql).setParameter(1, title).getSingleResult();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Order> getAllOrders() {
        String hql = "FROM Order ORDER BY id";
        return (List<Order>) entityManager.createQuery(hql).getResultList();
    }

    @Override
    public List<Order> getUnfinishedOrders() {
        String hql = "FROM Order where end_date > ?";
        return (List<Order>) entityManager.createQuery(hql).setParameter(1, Calendar.getInstance()).getResultList();
    }

    @Override
    public List<Order> getOrdersByDepartament(String departament) {
        String hql = "FROM Order where type = ?";
        return (List<Order>) entityManager.createQuery(hql).setParameter(1, departament).getResultList();
    }

    @Override
    public List<Order> getOrdersByMaster(String master) {
        String hql = "FROM Order where master = ?";
        return (List<Order>) entityManager.createQuery(hql).setParameter(1, master).getResultList();
    }

    @Override
    public String getOrderLeftTime(String title) {
        String hql1 = "SELECT EXTRACT(EPOCH FROM (endDate - CURRENT_TIMESTAMP)) FROM Order where title = ?";
        int totalDifference = (int) entityManager.createQuery(hql1).setParameter(1, title).getSingleResult();
        int days = totalDifference / (3600 * 24);
        int hours = (totalDifference - (days * 3600 * 24)) / 3600;
        return days + " DAYS and " + hours + " HOURS left";
    }

    @Override
    public void addOrder(Order order) {
        if(order.getMaster() == null || order.getMaster().isEmpty()) {
            String hql = "FROM Master ORDER BY RANDOM()";
            Master master = (Master) entityManager.createQuery(hql).setMaxResults(1).getSingleResult();
            order.setMaster(master.getFullName());
            order.setType(master.getDepartament());
        } else if (order.getType() == null || order.getType().isEmpty()){
            String hql = "FROM Master where full_name = ?";
            Master master = (Master) entityManager.createQuery(hql).setParameter(1, order.getMaster()).getSingleResult();
            order.setType(master.getDepartament());
        }

        entityManager.persist(order);
    }

    @Override
    public void updateOrder(Order order) {
        Order ordr = this.getOrderByTitle(order.getTitle());
        if(order.getMaster() != null) {
            ordr.setMaster(order.getMaster());
        }
        if(order.getType() != null) {
            ordr.setType(order.getType());
        }
        if(order.getStartDate() != null) {
            ordr.setStartDate(order.getStartDate());
        }
        if(order.getEndDate() != null) {
            ordr.setEndDate(order.getEndDate());
        }
        entityManager.flush();
    }

    @Override
    public void deleteOrder(String title) {

        entityManager.remove(this.getOrderByTitle(title));
    }

    @Override
    public boolean orderExists(String title) {
        String hql = "FROM Order as ordr WHERE ordr.title = ?";
        int count = entityManager.createQuery(hql).setParameter(1, title)
                .getResultList().size();
        return count > 0 ? true : false;
    }
}
