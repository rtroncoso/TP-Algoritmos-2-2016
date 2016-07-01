package com.cst.events.listeners;

import com.cst.exceptions.NoDoctorAvailableException;
import com.cst.model.clinic.Trip;

/**
 * TripFinishedListener interface
 */
public interface TripFinishedListener {

    /**
     * Event method for when a trip reaches it's destination
     * @param trip
     */
    void onTripFinished(Trip trip) throws NoDoctorAvailableException;

}
