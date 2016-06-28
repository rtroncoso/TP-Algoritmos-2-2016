package com.cst.events;

import com.cst.events.listeners.EmergencyCallDispatchListener;
import com.cst.model.clinic.Clinic;
import com.cst.model.clinic.Trip;

/**
 * EmergencyCallDispatch class
 */
public class EmergencyCallDispatch implements Event<EmergencyCallDispatchListener> {

    /** Trip used in this EmergencyCall */
    private Trip trip;

    /** Clinic belonging to this emergency call */
    private Clinic clinic;

    /**
     * EmergencyCallDispatch class constructor
     * @param trip
     */
    public EmergencyCallDispatch(Trip trip, Clinic clinic) {
        this.trip = trip;
        this.clinic = clinic;
    }

    /**
     * Notifies a listener about the event
     * @param listener
     */
    public void notify(final EmergencyCallDispatchListener listener) {
        listener.onEmergencyCallDispatch(this.trip, this.clinic);
    }

}
