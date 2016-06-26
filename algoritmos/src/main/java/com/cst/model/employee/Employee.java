package com.cst.model.employee;

/**
 * Employee class - Base abstract class
 *
 * @package com.cst.model
 */
public abstract class Employee {

    /**
     * Global status constants
     */
    public static final int STATUS_WAITING = 1;

    /**
     * Doctors status constants
     */
    public static final int STATUS_CONSULT = 2;
    public static final int STATUS_OPERATION = 3;

    /**
     * Stretcher status constants
     */
    public static final int STATUS_TRIPPING = 4;

    /** Employee name field */
    protected String name;

    /** Employee baseSalary field. Base monthly-paid salary. */
    protected double baseSalary;

    /** Current employee salary accumulator */
    protected double salary;

    /** Employee status */
    protected int status;

    /**
     * Employee constructor - Must be implemented
     *
     * @param name
     * @param baseSalary
     */
    public Employee(String name, double baseSalary) {
        this.status = Employee.STATUS_WAITING;
        this.baseSalary = baseSalary;
        this.name = name;
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
     * Adds a given salary amount to an employee
     * @param salary
     */
    public void addSalary(double salary) {
        this.salary += salary;
    }

}
