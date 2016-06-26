package com.cst.events.listeners;

import com.cst.model.clinic.Operation;
import com.cst.model.clinic.Trip;
import com.cst.model.employee.Doctor;
import com.cst.model.employee.Stretcher;

/**
 * OperationStartedListener interface
 */
public interface OperationStartedListener {

    /**
     * Method fired when an operation gets started
     * @param operation
     */
    void onOperationStarted(Operation operation);

}
