package com.cst.events;


import com.cst.events.listeners.OperationFinishedListener;
import com.cst.model.clinic.Operation;

/**
 * OperationFinished class
 */
public class OperationFinished implements Event<OperationFinishedListener> {

    /** Operation corresponding to this event */
    private Operation operation;

    /**
     * OperationFinished class consturctor
     * @param operation
     */
    public OperationFinished(Operation operation) {
        this.operation = operation;
    }

    /**
     * Notify the listeners of the event
     * @param listener
     */
    public void notify(final OperationFinishedListener listener) {
        listener.onOperationFinished(this.operation);
    }

}
