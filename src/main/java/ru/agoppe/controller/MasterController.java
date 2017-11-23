package ru.agoppe.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.UriComponentsBuilder;

import ru.agoppe.entity.Master;
import ru.agoppe.entity.Order;
import ru.agoppe.service.IMasterService;

@Controller
@RequestMapping("roga")
public class MasterController {
    @Autowired
    private IMasterService masterService;
    @GetMapping("master/{fullName}")
    public ResponseEntity<Master> getMasterByName(@PathVariable("fullName") String fullName) {
        Master master = masterService.getMasterByName(fullName);
        return new ResponseEntity<Master>(master, HttpStatus.OK);
    }
    @PostMapping("master")
    public ResponseEntity<Void> addMaster(@RequestBody Master master, UriComponentsBuilder builder) {
        boolean flag = masterService.addMaster(master);
        if (flag == false) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/master/{fullName}").buildAndExpand(master.getFullName()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
    @PutMapping("master")
    public ResponseEntity<Master> updateMaster(@RequestBody Master master) {
        masterService.updateMaster(master);
        return new ResponseEntity<Master>(master, HttpStatus.OK);
    }
    @DeleteMapping("master/{fullName}")
    public ResponseEntity<Void> deleteOrder(@PathVariable("fullName") String fullName) {
        masterService.deleteMaster(fullName);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}