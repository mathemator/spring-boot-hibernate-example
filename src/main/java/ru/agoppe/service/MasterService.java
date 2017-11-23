package ru.agoppe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.agoppe.dao.IMasterDAO;
import ru.agoppe.entity.Master;

@Service
public class MasterService implements IMasterService {

    @Autowired
    private IMasterDAO masterDAO;

    @Override
    public Master getMasterByName(String masterName) {

        return masterDAO.getMasterByName(masterName);
    }

    @Override
    public void updateMaster(Master master) {
        masterDAO.updateMaster(master);
    }

    @Override
    public boolean addMaster(Master master) {

        if (masterDAO.masterExists(master.getFullName())) {
            return false;
        } else {
            masterDAO.addMaster(master);
            return true;
        }
    }

    @Override
    public void deleteMaster(String masterName) {

        masterDAO.deleteMaster(masterName);
    }
}
