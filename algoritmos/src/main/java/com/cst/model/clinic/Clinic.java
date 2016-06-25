package com.cst.model.clinic;

import com.cst.model.employee.Administrative;
import com.cst.model.employee.Doctor;
import com.cst.model.employee.Stretcher;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Clinic class - Base container model
 * @packaage com.cst.model
 */
public class Clinic {

    /** List of doctors assigned to the clinic */
    List<Doctor> doctors;

    /** List of administrative employees assigned to the clinic*/
    List<Administrative> administratives;

    /** List of stretchers assigned to the clinic */
    List<Stretcher> stretchers;

    /**
     * Clinic class constructor
     * TODO : Should initialize all required models
     */
    public Clinic() {
        this.doctors = new ArrayList<Doctor>();
        this.administratives = new ArrayList<Administrative>();
        this.stretchers = new ArrayList<Stretcher>();
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
    public List<Salary> getSalaries() {
        List<Salary> salaries = new LinkedList<Salary>();
        for (Doctor doctor : doctors) {
            salaries.add(new Salary(doctor));
        }
        return salaries;
    }

}
