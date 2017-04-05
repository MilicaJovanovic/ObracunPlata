package com.milica.services;

import com.milica.entities.PartTimeEmployee;
import com.milica.entities.Subject;
import java.util.List;

/**
 *
 * @author Milica
 */
public class PairTransporterPartTimeEmployee {
    private PartTimeEmployee employee;
    private List<Subject> subjects;

    public PartTimeEmployee getEmployee() {
        return employee;
    }

    public void setEmployee(PartTimeEmployee employee) {
        this.employee = employee;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }
}
