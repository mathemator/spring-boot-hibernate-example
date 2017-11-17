package ru.agoppe.dao;

import ru.agoppe.entity.Master;

public interface IMasterDAO {

    Master getMasterByName(String masterName);
    void updateMaster(Master master);
    void addMaster(Master master);
    void deleteMaster(String masterName);

}
