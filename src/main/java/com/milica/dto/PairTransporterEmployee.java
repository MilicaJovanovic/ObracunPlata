package com.milica.dto;

import com.milica.entities.Employee;
import com.milica.entities.Subject;
import java.util.List;

/**
 * Klasa se koristi za trasport podataka
 * Ona sadrzi dva atributa koji predstavljaju liste elemanata koji se cuvaju u bazi podataka
 * @author Milica
 */
public class PairTransporterEmployee {
    private Employee employee;
    private List<Subject> subjects;

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }    
}
