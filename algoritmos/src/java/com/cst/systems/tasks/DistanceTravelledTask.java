package com.cst.systems.tasks;

import com.cst.events.DistanceTravelled;
import com.cst.model.clinic.Trip;
import com.cst.systems.RealTimeEmergencySystem;

import java.util.Calendar;

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
        if(this.trip.getStatus() == Trip.STATUS_ON_ROUTE) {
            this.rteSystem.addTask(
                new DistanceTravelledTask(this.rteSystem, this.trip),
                DistanceTravelledTask.HOUR_DURATION * .1
            );

            this.rteSystem.getTime().add(Calendar.MINUTE, 10);
            this.rteSystem.getClinic().getDispatcher().notify(new DistanceTravelled(this.trip));
        }
    }

}
