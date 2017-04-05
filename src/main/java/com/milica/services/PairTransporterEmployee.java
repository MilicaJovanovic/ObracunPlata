package com.milica.services;

import com.milica.entities.Employee;
import com.milica.entities.Subject;
import com.milica.entities.SubjectEmployee;
import java.util.List;

/**
 *
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
//    
}
