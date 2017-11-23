package ru.agoppe.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.agoppe.entity.Master;

@Transactional
@Repository
public interface IMasterDAO {

    Master getMasterByName(String masterName);
    void updateMaster(Master master);
    void addMaster(Master master);
    void deleteMaster(String masterName);
    boolean masterExists(String title);
}
