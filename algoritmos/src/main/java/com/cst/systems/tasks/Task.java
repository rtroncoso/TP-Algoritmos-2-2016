package com.cst.systems.tasks;

import com.cst.systems.RealTimeEmergencySystem;
import com.github.javafaker.Faker;

import java.util.TimerTask;

/**
 * Task class
 */
public abstract class Task extends TimerTask {

    /** Stores this task's associated emergency system */
    protected RealTimeEmergencySystem rteSystem;

    /**
     * Task constructor
     * @param rteSystem
     */
    public Task(RealTimeEmergencySystem rteSystem) {
        this.rteSystem = rteSystem;
    }

    /**
     * Obtains this task's Emergency System
     * @return
     */
    public RealTimeEmergencySystem getRTESystem() {
        return rteSystem;
    }

    /**
     * Determines if a randomly generated number fits into a chance
     * percentage
     * @param chance
     * @return
     */
    public boolean percentageChance(int chance) {
        return new Faker().number().numberBetween(1, 100) <= chance;
    }

}
