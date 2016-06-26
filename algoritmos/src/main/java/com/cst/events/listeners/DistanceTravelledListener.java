package com.cst.events.listeners;

import com.cst.model.clinic.Trip;

/**
 * DistanceTravelledListener interface
 */
public interface DistanceTravelledListener {

    /**
     * Event method for when a trip travels a certain distance
     * @param trip
     */
    void onDistanceTravelled(Trip trip);

}
