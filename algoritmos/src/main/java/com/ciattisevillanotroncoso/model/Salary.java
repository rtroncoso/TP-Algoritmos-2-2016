package com.ciattisevillanotroncoso.model;

import java.text.DecimalFormat;

/**
 * Created with IntelliJ IDEA by: alejandro
 * Date: 24/06/16
 * Time: 12:06
 */
public class Salary {

    Employee employee;

    public Salary(Employee employee){
        this.employee = employee;
    }

    public String getSalaryAsString(){
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
