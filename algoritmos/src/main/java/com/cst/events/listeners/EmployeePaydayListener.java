package com.cst.events.listeners;

import com.cst.model.clinic.Trip;
import com.cst.model.employee.Employee;
import com.cst.model.employee.Stretcher;

/**
 * EmployeePaydayListener interface
 */
public interface EmployeePaydayListener {

    /**
     * Method fired when an employee gets it's payday
     * @param employee
     * @param amount
     */
    void onPayday(Employee employee, double amount);

}
