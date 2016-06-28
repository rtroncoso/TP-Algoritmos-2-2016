package com.cst.model.employee;

import com.cst.model.clinic.Clinic;
import com.cst.model.clinic.Operation;

/**
 * Administrative class
 */
public class Administrative extends Employee {

    /**
     * Administrative constructor
     *
     * @param name
     * @param salary
     */
    public Administrative(String name, double salary) {
        super(name, salary);
    }

    /**
     * Calculates the salary for a given operation
     * @param operation
     * @return double
     */
    public double calculate(Operation operation) {
        return 0;
    }

}
