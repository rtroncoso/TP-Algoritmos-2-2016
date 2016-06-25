package com.ciattisevillanotroncoso.model;

/**
 * Employee class - Base abstract class
 *
 * @package com.ciattisevillanotroncoso.model
 */
public abstract class Employee {

    private String name;
    private Double salary;

    /**
     * Employee constructor - Must be implemented
     *
     * @param name
     * @param salary
     */
    public Employee(String name, Double salary) {
        this.name = name;
        this.salary = salary;
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

}
