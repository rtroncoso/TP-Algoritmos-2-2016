package com.cst.systems.tasks;


import com.cst.exceptions.CallAlreadyDispatched;
import com.cst.factory.PatientFactory;
import com.cst.model.clinic.Trip;
import com.cst.model.patient.Patient;
import com.cst.systems.RealTimeEmergencySystem;
import com.cst.util.RandomNumber;

import java.util.ArrayList;

/**
 * EmergencyStartTask class
 */
public class EmergencyStartTask extends HourElapsedTask {

    /** Chance factor to start an emergency (percentage) */
    public static final int EMERGENCY_CHANCE_FACTOR = 1;

    /** Max distance to launch an emergency */
    public static final int MAX_EMERGENCY_DISTANCE = 20;

    /**
     * EmergencyStartTask constructor
     * @param rteSystem
     */
    public EmergencyStartTask(RealTimeEmergencySystem rteSystem) {
        super(rteSystem);
    }

    /**
     * Checks every hour if a given percentage chance if given,
     * if it is an emergency will start and the SATSystem will
     * dispatch it with random dummy data.
     */
    @Override
    public void run() {
        if(this.percentageChance(this.MAX_EMERGENCY_DISTANCE)) {
            ArrayList<Patient> patients = new ArrayList<Patient>();

            for(int i=0; i < RandomNumber.get(1, 3); i++) {
                patients.add(new PatientFactory().create());
            }

            try {
                Trip trip = this.rteSystem.getClinic().getSatSystem().startEmergency(
                    RandomNumber.get(1, this.MAX_EMERGENCY_DISTANCE), patients,
                    this.rteSystem.getTime()
                );

                this.rteSystem.addTask(
                    new DistanceTravelledTask(this.rteSystem, trip),
                    this.rteSystem.getMilliseconds(
                        DistanceTravelledTask.HOUR_DURATION * .1 // 10 minutes per kilometer
                    )
                );
            } catch (CallAlreadyDispatched callAlreadyDispatched) {
            }
        }
    }

}
