package ru.agoppe.dao;

import ru.agoppe.entity.Master;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class MasterDAO implements IMasterDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Master getMasterByName(String masterName) {
        return null;
    }

    @Override
    public void updateMaster(Master master) {

        Master mstr = this.getMasterByName(master.getFullName());
//        mstr.setMaster(order.getMaster());
//        mstr.setType(order.getType());
//        mstr.setStartDate(order.getStartDate());
//        mstr.setEndDate(order.getEndDate());
        entityManager.flush();
    }

    @Override
    public void addMaster(Master master) {
        entityManager.persist(master);
    }

    @Override
    public void deleteMaster(String masterName) {
        entityManager.remove(this.getMasterByName(masterName));
    }
}
