package com.cst.systems.tasks;

import com.cst.model.clinic.Trip;
import com.cst.systems.RealTimeEmergencySystem;

/**
 * TripFinishTask class
 */
public class TripFinishTask extends HourElapsedTask {

    public static final int HOURS_PER_KILOMETER = 1;

    private Trip trip;

    /**
     * TripFinishTask constructor
     * @param rteSystem
     */
    public TripFinishTask(RealTimeEmergencySystem rteSystem, Trip trip) {
        super(rteSystem);
        this.trip = trip;
    }

    @Override
    public void run() {

    }

}
