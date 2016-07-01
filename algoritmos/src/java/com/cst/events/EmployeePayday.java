package com.cst.events;

import com.cst.events.listeners.EmployeePaydayListener;
import com.cst.model.employee.Employee;

/**
 * EmployeePayday class
 */
public class EmployeePayday implements Event<EmployeePaydayListener> {

    /** Employee corresponding to this event */
    private Employee employee;

    /** Amount of money to be paid to employee */
    private double amount;

    /**
     * EmployeePayday class consturctor
     * @param employee
     */
    public EmployeePayday(Employee employee, double amount) {
        this.amount = amount;
        this.employee = employee;
    }

    /**
     * Notify the listeners of the event
     * @param listener
     */
    public void notify(final EmployeePaydayListener listener) {
        listener.onPayday(this.employee, this.amount);
    }

}
