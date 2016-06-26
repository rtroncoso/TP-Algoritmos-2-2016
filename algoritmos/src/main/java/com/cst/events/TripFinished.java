package com.cst.events;


import com.cst.events.listeners.TripFinishedListener;
import com.cst.model.clinic.Trip;
import com.cst.model.employee.Stretcher;

/**
 * TripFinished class
 */
public class TripFinished implements Event<TripFinishedListener> {

    /** Trip corresponding to this event */
    private Trip trip;

    /**
     * TripFinished class consturctor
     * @param trip
     */
    public TripFinished(Trip trip) {
        this.trip = trip;
    }

    /**
     * Notify the listeners of the event
     * @param listener
     */
    public void notify(final TripFinishedListener listener) {
        listener.onTripFinished(this.trip);
    }

}
