package ru.agoppe.entity;

import javax.persistence.*;

@Entity
@Table(name="masters")
public class Departament {

    @Id
    @Column(name="departament")
    private String departament;


    public String getDepartament() {
        return departament;
    }

    public void setDepartament(String departament) {
        this.departament = departament;
    }
}
