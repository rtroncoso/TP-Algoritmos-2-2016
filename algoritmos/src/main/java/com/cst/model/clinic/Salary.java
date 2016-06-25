package com.cst.model.clinic;

import com.cst.model.employee.Employee;

import java.text.DecimalFormat;

/**
 * Salary class
 * @package com.cst.model
 */
public class Salary {

    /** Employee to which this salary is assigned to */
    Employee employee;

    /**
     * Salary class constructor
     * @param employee
     */
    public Salary(Employee employee){
        this.employee = employee;
    }

    /**
     * Obtains the Salary in a prettified format
     * @return
     */
    public String getSalaryAsString() {
        Double salary = employee.getSalary();
        String prettyString = "$";
        prettyString += new DecimalFormat("#.##").format(salary);
        return prettyString;
    }

    @Override
    public String toString() {
        return employee.getName() + "   " + getSalaryAsString();
    }

}
