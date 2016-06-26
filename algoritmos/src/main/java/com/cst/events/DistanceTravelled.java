package com.cst.events;

import com.cst.events.listeners.DistanceTravelledListener;
import com.cst.model.clinic.Trip;

/**
 * DistanceTravelled class
 */
public class DistanceTravelled implements Event<DistanceTravelledListener> {

    /** Trip used in this EmergencyCall */
    private Trip trip;

    /**
     * DistanceTravelled class constructor
     * @param trip
     */
    public DistanceTravelled(Trip trip) {
        this.trip = trip;
    }

    /**
     * Notifies a listener about the event
     * @param listener
     */
    public void notify(final DistanceTravelledListener listener) {
        listener.onDistanceTravelled(this.trip);
    }

}
