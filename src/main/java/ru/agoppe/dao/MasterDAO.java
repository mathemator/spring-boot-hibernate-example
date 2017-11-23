package ru.agoppe.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.agoppe.entity.Master;
import ru.agoppe.entity.Order;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Transactional
@Repository
public class MasterDAO implements IMasterDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Master getMasterByName(String masterName) {

        String hql = "FROM Master where fullName = ?";
        return (Master) entityManager.createQuery(hql).setParameter(1, masterName).getSingleResult();

    }

    @Override
    public void updateMaster(Master master) {

        Master mstr = this.getMasterByName(master.getFullName());
        if(master.getDepartament() != null) {
            mstr.setDepartament(master.getDepartament());
        }
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

    @Override
    public boolean masterExists(String masterName) {
        String hql = "FROM Master WHERE fullName = ?";
        int count = entityManager.createQuery(hql).setParameter(1, masterName)
                .getResultList().size();
        return count > 0 ? true : false;
    }
}
