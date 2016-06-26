package com.cst.model.employee;

import com.cst.model.clinic.Clinic;

/**
 * Employee class - Base abstract class
 */
public abstract class Employee {

    /** Status for waiting for duty employees */
    public static final int STATUS_WAITING = 1;

    /** Status used when a doctor is on a consult */
    public static final int STATUS_CONSULT = 2;

    /** Status used for when a doctor is in an operation */
    public static final int STATUS_OPERATION = 3;

    /** Status when a stretcher is tripping (no pun intended) */
    public static final int STATUS_TRIPPING = 4;

    /** Employee name field */
    protected String name;

    /** Employee baseSalary field. Base monthly-paid salary. */
    protected double baseSalary;

    /** Current employee salary accumulator */
    protected double salary;

    /** Employee status */
    protected int status;

    /** Reference to this employee's clinic */
    protected Clinic clinic;

    /**
     * Employee constructor - Must be implemented
     *
     * @param name
     * @param baseSalary
     */
    public Employee(String name, double baseSalary, Clinic clinic) {
        this.status = Employee.STATUS_WAITING;
        this.baseSalary = baseSalary;
        this.name = name;
        this.clinic = clinic;
    }

    /**
     * Employee name getter
     * @return String
     */
    public String getName() {
        return name;
    }

    /**
     * Employee baseSalary getter
     * @return String
     */
    public double getBaseSalary() {
        return baseSalary;
    }

    /**
     * Employee baseSalary setter
     * @param salary
     */
    public void setBaseSalary(double salary) {
        this.salary = salary;
    }

    /**
     * Employee status getter
     * @return int
     */
    public int getStatus() {
        return status;
    }

    /**
     * Employee status setter
     * @param status
     */
    public void setStatus(int status) {
        this.status = status;
    }

    /**
     * Gets employee current salary
     * @return double
     */
    public double getSalary() {
        return salary;
    }

    /**
     * Sets employee current salary
     * @param salary
     */
    public void setSalary(double salary) {
        this.salary = salary;
    }

    /**
     * Obtains this employee's associated clinic
     * @return Clinic
     */
    public Clinic getClinic() {
        return this.clinic;
    }

    /**
     * Sets this employee's associated clinic
     * @param clinic
     */
    public void setClinic(Clinic clinic) {
        this.clinic = clinic;
    }

    /**
     * Adds a given salary amount to an employee
     * @param salary
     */
    public void addSalary(double salary) {
        this.salary += salary;
    }

}
