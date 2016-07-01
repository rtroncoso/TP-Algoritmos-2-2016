package com.cst.systems.tasks;


import com.cst.events.EmployeePayday;
import com.cst.model.employee.Administrative;
import com.cst.model.employee.Employee;
import com.cst.systems.RealTimeEmergencySystem;

import java.util.Calendar;

/**
 * Hour elapsed task
 */
public class HourElapsedTask extends Task {

    /** duh */
    public static final int HOUR_DURATION = 1;

    /** Chance that administrative employees have to not be in their place of work */
    public static final int ADMINISTRATIVE_NOT_WORKING_CHANCE = 5;

    /**
     * HourElapsedTask constructor
     * @param rteSystem
     */
    public HourElapsedTask(RealTimeEmergencySystem rteSystem) {
        super(rteSystem);
    }

    /**
     * Updates the real-time emregency system time
     */
    @Override
    public void run() {
        this.rteSystem.getTime().add(Calendar.HOUR, this.HOUR_DURATION);
        int hour = this.rteSystem.getTime().get(Calendar.HOUR_OF_DAY);
        int day = this.rteSystem.getTime().get(Calendar.DAY_OF_MONTH);

        if(hour >= 9 && hour <= 18) {
            for(Administrative administrative : this.rteSystem.getClinic().getAdministratives()) {
                // If this fails they've gone for a smoke and will not be paid the hour
                if( ! this.percentageChance(this.ADMINISTRATIVE_NOT_WORKING_CHANCE)) {
                    administrative.addWorkedHour();
                }
            }
        }

        // Payday time
        if(day == 1 && hour == 0) {
            for(Employee employee : this.rteSystem.getClinic().getEmployees()) {
                double salary = employee.payday();

                // Notify this employee's payday time and amount
                this.rteSystem.getClinic().getDispatcher().notify(
                    new EmployeePayday(employee, salary)
                );
            }
        }
    }

}
