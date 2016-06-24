package com.ciattisevillanotroncoso.model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created with IntelliJ IDEA by: alejandro
 * Date: 24/06/16
 * Time: 11:57
 */
public class Clinic {
    List<Doctor> doctors;

    public Clinic(){
        doctors = new ArrayList<Doctor>();
    }

    public List<Salary> getSalaries(){
        List<Salary> salaries = new LinkedList<Salary>();
        for (Doctor doctor : doctors) {
            salaries.add(new Salary(doctor));
        }
        return salaries;
    }
}
