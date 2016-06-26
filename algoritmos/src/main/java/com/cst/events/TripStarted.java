package com.cst.events;


import com.cst.events.listeners.TripStartedListener;
import com.cst.model.clinic.Trip;
import com.cst.model.employee.Stretcher;

/**
 * TripStarted class
 */
public class TripStarted implements Event<TripStartedListener> {

    /** Trip corresponding to this event */
    private Trip trip;

    /** Stretcher corresponding to this event */
    private Stretcher stretcher;

    /**
     * TripStarted class consturctor
     * @param trip
     */
    public TripStarted(Trip trip, Stretcher stretcher) {
        this.stretcher = stretcher;
        this.trip = trip;
    }

    /**
     * Notify the listeners of the event
     * @param listener
     */
    public void notify(final TripStartedListener listener) {
        listener.onTripStarted(this.trip, this.stretcher);
    }

}
