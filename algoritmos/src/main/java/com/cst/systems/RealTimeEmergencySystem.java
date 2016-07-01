package com.cst.systems;

import com.cst.events.OperationStarted;
import com.cst.events.TripFinished;
import com.cst.events.listeners.OperationStartedListener;
import com.cst.model.clinic.Clinic;
import com.cst.model.clinic.Operation;
import com.cst.systems.tasks.EmergencyStartTask;
import com.cst.systems.tasks.HourElapsedTask;
import com.cst.systems.tasks.OperationFinishTask;

import java.security.InvalidParameterException;
import java.util.*;

/**
 * RealTimeEmergencySystem class
 */
public class RealTimeEmergencySystem implements OperationStartedListener {

    /** Stores the tasks to be run by this system */
    private List<TimerTask> tasks = new ArrayList<TimerTask>();

    /** Stores the global timer scheduler for this system */
    private Timer timer = new Timer();

    /** Clinic used for this real-time scheduler */
    private Clinic clinic;

    /** Stores this emergency system current time */
    private Calendar time;

    /** Stores the amount of time representing one hour */
    private int step;

    /** Unit of time to be measured for each task */
    private char unit;

    /**
     * RealTimeEmergencySystem constructor
     * @param clinic clinic associated to this scheduler
     * @param step amount of time that represents one hour
     * @param unit unit of time to be used
     */
    public RealTimeEmergencySystem(Clinic clinic, int step, char unit) {
        this.clinic = clinic;
        this.setUnit(unit);
        this.step = step;
    }

    /**
     * Entry point which creates all the need tasks
     * for a working system
     */
    public void start() {
        this.addTask(new HourElapsedTask(this), HourElapsedTask.HOUR_DURATION);
        this.addTask(new EmergencyStartTask(this), HourElapsedTask.HOUR_DURATION);
        this.getClinic().getDispatcher().listen(OperationStarted.class, this);
    }

    /**
     * Adds a task to the system, units of time registered in hours
     * @param task
     * @param time
     */
    public void addTask(TimerTask task, double time) {
        this.timer.schedule(task, this.getMilliseconds(time));
        this.tasks.add(task);
    }

    /**
     * Converts a given amount of hours to application
     * miliseconds using the settings stored in this
     * object.
     * @param hours
     */
    public long getMilliseconds(double hours) {
        switch(this.unit) {
            case 'h': return (long) (hours * this.step * 60 * 60 * 1000);
            case 'm': return (long) (hours * this.step * 60 * 1000);
            case 's': return (long) (hours * this.step * 1000);
        }

        throw new InvalidParameterException();
    }

    /**
     * Waits for an operation to start to create it's
     * finishing task
     * @param operation
     */
    public void onOperationStarted(Operation operation) {
        this.addTask(new OperationFinishTask(this, operation),
                this.getMilliseconds(OperationFinishTask.OPERATION_DURATION));
    }

    /**
     * RealTimeEmergencySystem step getter
     * @return int
     */
    public int getStep() {
        return step;
    }

    /**
     * RealTimeEmergencySystem step setter
     * @param step
     */
    public void setStep(int step) {
        this.step = step;
    }

    /**
     * RealTimeEmergencySystem unit getter
     * @return int
     */
    public int getUnit() {
        return unit;
    }

    /**
     * RealTimeEmergencySystem unit setter
     * @param unit
     */
    public void setUnit(char unit) throws InvalidParameterException {
        if(unit != 's' || unit != 'm' || unit != 'h') {
            throw new InvalidParameterException();
        }

        this.unit = unit;
    }

    /**
     * RealTimeEmergencySystem time getter
     * @return Calendar
     */
    public Calendar getTime() {
        return time;
    }

    /**
     * RealTimeEmergencySystem time setter
     * @param time
     */
    public void setTime(Calendar time) {
        this.time = time;
    }

    /**
     * RealTimeEmergencySystem clinic getter
     * @return Clinic
     */
    public Clinic getClinic() {
        return clinic;
    }

}
