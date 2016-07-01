package com.cst.events;


import com.cst.events.listeners.OperationStartedListener;
import com.cst.model.clinic.Operation;
import com.cst.model.employee.Doctor;

/**
 * OperationStarted class
 */
public class OperationStarted implements Event<OperationStartedListener> {

    /** Operation corresponding to this event */
    private Operation operation;

    /**
     * OperationStarted class consturctor
     * @param operation
     */
    public OperationStarted(Operation operation) {
        this.operation = operation;
    }

    /**
     * Notify the listeners of the event
     * @param listener
     */
    public void notify(final OperationStartedListener listener) {
        listener.onOperationStarted(this.operation);
    }

}
