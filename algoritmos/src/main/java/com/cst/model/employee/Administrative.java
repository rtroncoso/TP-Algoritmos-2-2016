package com.cst.model.employee;

import com.cst.model.clinic.Visit;

/**
 * Administrative class
 */
public class Administrative extends Employee {

    /** Price modifier for underaged patients */
    public static final int BASE_MINOR_VISIT_PRICE = 50;

    /** Bonus to be added to Administrative employees for calculations */
    public static final int CALCULATION_BONUS = 50;

    /** Discount for each hour not worked by this employee */
    public static final int HOUR_NOT_WORKED_DISCOUNT = 10;

    /** Defines the amount of hours this employee has worked */
    private int hoursWorked;

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
     * Calculates the salary to be paid for a given visit
     * @param visit
     * @return double
     */
    public double calculate(Visit visit) {
        this.addSalary(Administrative.CALCULATION_BONUS);
        return visit.getPatient().getAge() * Administrative.BASE_MINOR_VISIT_PRICE;
    }

    /**
     * Gets the amount of hours worked by this employee
     * @return
     */
    public int getWorkedHous() {
        return hoursWorked;
    }

    /**
     * Adds an hour to the amount of hours worked of this employee
     */
    public void addWorkedHour() {
        this.hoursWorked++;
    }

}
