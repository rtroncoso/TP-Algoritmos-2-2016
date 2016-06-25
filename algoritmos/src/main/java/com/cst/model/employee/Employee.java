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
    private String name;

    /** Employee baseSalary field. Base monthly-paid salary. */
    private Double baseSalary;

    /** Current employee salary accumulator */
    private Double salary;

    /** Employee status */
    private int status;

    /**
     * Employee constructor - Must be implemented
     *
     * @param name
     * @param baseSalary
     */
    public Employee(String name, Double baseSalary) {
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
    public Double getBaseSalary() {
        return baseSalary;
    }

    /**
     * Employee baseSalary setter
     * @param salary
     */
    public void setBaseSalary(Double salary) {
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
     * @return Double
     */
    public Double getSalary() {
        return salary;
    }

    /**
     * Sets employee current salary
     * @param salary
     */
    public void setSalary(Double salary) {
        this.salary = salary;
    }

    /**
     * Adds a given salary amount to an employee
     * @param salary
     */
    public void addSalary(Double salary) {
        this.salary += salary;
    }

}
