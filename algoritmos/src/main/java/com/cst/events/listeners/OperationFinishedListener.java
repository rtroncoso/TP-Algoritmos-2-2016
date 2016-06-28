package com.cst.events.listeners;

import com.cst.model.clinic.Operation;

/**
 * OperationFinishedListener interface
 */
public interface OperationFinishedListener {

    /**
     * Method fired when an operation finishes
     * @param operation
     */
    void onOperationFinished(Operation operation);

}
