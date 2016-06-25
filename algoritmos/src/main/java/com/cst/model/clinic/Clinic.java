package com.cst.model.clinic;

import com.cst.model.employee.Doctor;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Clinic class - Base container model
 * @packaage com.cst.model
 */
public class Clinic {

    List<Doctor> doctors;

    /**
     * Clinic class constructor
     * TODO : Should initialize all required models
     */
    public Clinic() {
        this.doctors = new ArrayList<Doctor>();
    }

    /**
     * Obtains a list of all the doctor salaries
     * TODO : Move this logic into a separate class,
     *        as it should be able to calculate all
     *        the stretcher salaries as long with
     *        the other employee salaries.
     *        (Punto 1 del tp)
     *
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
