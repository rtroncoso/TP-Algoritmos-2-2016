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
    public static final int STATUS_VISIT = 2;
    public static final int STATUS_OPERATION = 3;

    /**
     * Stretcher status constants
     */
    public static final int STATUS_TRIP = 4;

    /** Employee name field */
    private String name;

    /** Employee salary field. Base monthly-paid salary. */
    private Double salary;

    /** Employee status */
    private int status;

    /**
     * Employee constructor - Must be implemented
     *
     * @param name
     * @param salary
     */
    public Employee(String name, Double salary) {
        this.status = Employee.STATUS_WAITING;
        this.salary = salary;
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
     * Employee salary getter
     * @return String
     */
    public Double getSalary() {
        return salary;
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

}
