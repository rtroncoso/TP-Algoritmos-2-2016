package com.cst.systems.tasks;


import com.cst.systems.RealTimeEmergencySystem;

import java.util.Calendar;

/**
 * Hour elapsed task
 */
public class HourElapsedTask extends Task {

    /** duh */
    public static final int HOUR_DURATION = 1;

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
    }

}
