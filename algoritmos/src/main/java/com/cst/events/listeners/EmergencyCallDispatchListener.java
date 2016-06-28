package com.cst.events.listeners;

import com.cst.model.clinic.Clinic;
import com.cst.model.clinic.Trip;

/**
 * EmergencyCallDispatchListener interface
 */
public interface EmergencyCallDispatchListener {

    /**
     * Event method for when a emergency gets dispatched
     * @param trip
     */
    void onEmergencyCallDispatch(Trip trip, Clinic clinic);

}
