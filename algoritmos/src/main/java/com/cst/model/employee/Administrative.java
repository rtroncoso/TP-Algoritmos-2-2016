package com.cst.model.employee;

import com.cst.model.clinic.Clinic;
import com.cst.model.clinic.Visit;

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
     * Calculates the salary to be paid for a given consult
     * @param consult
     * @return double
     */
    public double calculate(Visit consult) {
        return 0;
    }

}
