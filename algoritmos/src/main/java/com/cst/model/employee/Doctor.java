package com.cst.model.employee;

import com.cst.exceptions.NoAdministrativeAvailableException;
import com.cst.model.clinic.Clinic;
import com.cst.model.clinic.Operation;

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
     * @param clinic
     */
    public Doctor(String name, double salary, Clinic clinic){
        super(name, salary, clinic);
    }

    /**
     * Adds a salary to a doctor based on an operation
     * @param operation
     */
    public void addSalary(Operation operation) {
        if(operation.getPatient().getAge() < 18) {
            try {
                Administrative ad = this.clinic.getFreeAdministrativeEmployee();
                this.addSalary(ad.calculate(operation));
            } catch (NoAdministrativeAvailableException e) { }
        }

        if(operation.getPatient().getHealthcare() == null) {
            this.addSalary(operation.getPatient().getAge() *
                Doctor.NON_HEALTHCARE_SALARY_MODIFIER);
            return;
        }

        // TODO : Calculate salaries for healthcare-covered patients
    }

}
