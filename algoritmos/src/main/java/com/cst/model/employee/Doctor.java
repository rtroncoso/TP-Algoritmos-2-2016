package com.cst.model.employee;

import com.cst.exceptions.NoAdministrativeAvailableException;
import com.cst.model.clinic.Clinic;
import com.cst.model.clinic.Visit;

/**
 * Doctor class
 */
public class Doctor extends Employee {

    /** Salary modifier for patients without healthcare */
    public static final int NON_HEALTHCARE_SALARY_MODIFIER = 75;

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
        if(visit.getPatient().getAge() < 18) {
            try {
                Administrative ad = clinic.getFreeAdministrativeEmployee();
                this.addSalary(ad.calculate(visit));
                return;
            } catch (NoAdministrativeAvailableException e) { }
        }

        if(visit.getPatient().getHealthcare() == null) {
            this.addSalary(visit.getPatient().getAge() *
                Doctor.NON_HEALTHCARE_SALARY_MODIFIER);
            return;
        }

        // TODO : Calculate salaries for healthcare-covered patients
    }

}
