package com.cst.systems.tasks;

import com.cst.model.clinic.Trip;
import com.cst.systems.RealTimeEmergencySystem;

/**
 * DistanceTravelledTask class
 */
public class DistanceTravelledTask extends HourElapsedTask {

    /** Saves trip instance */
    private Trip trip;

    /**
     * DistanceTravelledTask constructor
     * @param rteSystem
     */
    public DistanceTravelledTask(RealTimeEmergencySystem rteSystem, Trip trip) {
        super(rteSystem);
        this.trip = trip;
    }

    @Override
    public void run() {
        if(this.trip.getStatus() == Trip.STATUS_FINISHED) {
            return;
        }

        this.rteSystem.addTask(
            new DistanceTravelledTask(this.rteSystem, trip),
            this.rteSystem.getMilliseconds(DistanceTravelledTask.HOUR_DURATION * .1) // 10 minutes per kilometer
        );
    }

}
