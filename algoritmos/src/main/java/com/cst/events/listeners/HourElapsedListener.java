package com.cst.events.listeners;

import com.cst.model.clinic.Trip;
import com.cst.model.employee.Stretcher;

/**
 * HourElapsedListener interface
 */
public interface HourElapsedListener {

    /**
     * Method fire when an hour gets elapsed in the system
     */
    void onHourElapsed();

}
