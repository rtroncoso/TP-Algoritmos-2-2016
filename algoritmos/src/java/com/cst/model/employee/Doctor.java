package com.cst.model.employee;

import com.cst.exceptions.NoAdministrativeAvailableException;
import com.cst.model.clinic.Clinic;
import com.cst.model.clinic.Visit;

/**
 * Doctor class
 */
public class Doctor extends Employee {

    /** Salary modifier for patients without healthcare */
    public static final int BASE_VISIT_PRICE = 75;

    /**
     * Doctor class constructor
     * @param name
     * @param salary
     */
    public Doctor(String name, double salary){
        super(name, salary);
    }

    /**
     * Adds a salary to a doctor based on a visit
     * @param visit
     */
    public void addSalary(Visit visit, Clinic clinic) {
        double price = 0.0d;

        if(visit.getPatient().getAge() < 18) {
            try {
                Administrative ad = clinic.getFreeAdministrativeEmployee();
                price = ad.calculate(visit);
            } catch (NoAdministrativeAvailableException e) { }
        } else {
            price = visit.getPatient().getAge() * Doctor.BASE_VISIT_PRICE;
        }

        if(visit.getPatient().getHealthcare() != null) {
            price = visit.getPatient().getHealthcare().applyDiscount(price);
        }

        this.addSalary(price);
    }

}
