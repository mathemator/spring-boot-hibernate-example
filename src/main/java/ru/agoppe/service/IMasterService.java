package ru.agoppe.service;

import ru.agoppe.entity.Master;

public interface IMasterService {

    Master getMasterByName(String masterName);
    void updateMaster(Master master);
    boolean addMaster(Master master);
    void deleteMaster(String masterName);

}
