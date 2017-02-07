package com.milica.services;

import com.milica.entities.Employee;
import com.milica.entities.SubjectEmployee;
import java.util.List;

/**
 *
 * @author Milica
 */
public class PairTransporterEmployee {
    private Employee employee;
    private List<SubjectEmployee> subjects;

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public List<SubjectEmployee> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<SubjectEmployee> subjects) {
        this.subjects = subjects;
    }
//    
}
