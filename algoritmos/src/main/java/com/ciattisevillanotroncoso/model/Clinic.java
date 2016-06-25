package com.ciattisevillanotroncoso.model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Clinic class - Base container model
 *
 * @packaage com.ciattisevillanotroncoso.model
 */
public class Clinic {

    List<Doctor> doctors;

    /**
     * Clinic class constructor
     * TODO :
     *  - Should initialize all required models
     */
    public Clinic() {
        this.doctors = new ArrayList<Doctor>();
    }

    /**
     * Obtains a list of all the doctor salaries
     * @return List<Salary>
     */
    public List<Salary> getSalaries(){
        List<Salary> salaries = new LinkedList<Salary>();
        for (Doctor doctor : doctors) {
            salaries.add(new Salary(doctor));
        }
        return salaries;
    }

    /**
     * Adds a new doctor to the clinic
     * @param doctor
     * @return Clinic self-reference for chaining methods
     */
    public Clinic addDoctor(Doctor doctor) {
        this.doctors.add(doctor);
        return this;
    }

}
