package com.cst.events.listeners;

import com.cst.model.clinic.Trip;
import com.cst.model.employee.Stretcher;

/**
 * TripStartedListener interface
 * @package com.cst.events.listeners
 */
public interface TripStartedListener {

    /**
     * Method fire when a trip gets started
     * @param trip
     */
    void onTripStarted(Trip trip, Stretcher stretcher);

}
