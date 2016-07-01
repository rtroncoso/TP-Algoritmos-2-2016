package com.cst.systems.tasks;

import com.cst.events.OperationFinished;
import com.cst.model.clinic.Operation;
import com.cst.systems.RealTimeEmergencySystem;

/**
 * OperationFinishTask class
 */
public class OperationFinishTask extends Task {

    /** Determines how much time (hours) should an operation last */
    public static final int OPERATION_DURATION = 2;

    /** Stores current operation */
    private Operation operation;

    /**
     * OperationFinishTask constructor
     * @param rteSystem
     */
    public OperationFinishTask(RealTimeEmergencySystem rteSystem, Operation operation) {
        super(rteSystem);
        this.operation = operation;
    }

    @Override
    public void run() {
        this.rteSystem.getClinic().getDispatcher().notify(new OperationFinished(operation));
    }

}
