package com.cst.systems;

import com.cst.events.EmergencyCallDispatch;
import com.cst.events.listeners.TripStartedListener;
import com.cst.exceptions.CallAlreadyDispatched;
import com.cst.model.clinic.Clinic;
import com.cst.model.clinic.Trip;
import com.cst.model.employee.Stretcher;
import com.cst.model.patient.Patient;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * SATSystem class - translation: "Sistema de Atención Telefónica"
 */
public class SATSystem implements TripStartedListener {

    /** Status for the SATSystem on hold */
    public static final int STATUS_WAITING = 1;

    /** Status when a call gets dispatched */
    public static final int STATUS_DISPATCHED = 2;

    /** Clinic associated to this SAT */
    private Clinic clinic;

    /** List of trips registered in the SAT */
    private List<Trip> trips;

    /** Current SATSystem status */
    private int status;

    /**
     * SAT System class constructor
     * @param clinic
     */
    public SATSystem(Clinic clinic) {
        this.clinic = clinic;
    }

    /**
     * Starts an emergency using the SAT System
     * with a given distance and patients
     * @param distance
     * @param patients
     */
    public void startEmergency(int distance, ArrayList<Patient> patients)
            throws CallAlreadyDispatched {
        if(this.status == SATSystem.STATUS_DISPATCHED) {
            throw new CallAlreadyDispatched();
        }

        Trip trip = new Trip(distance, patients, this.clinic);
        this.clinic.getDispatcher().notify(new EmergencyCallDispatch(trip));
        this.status = SATSystem.STATUS_DISPATCHED;
    }

    /**
     * Starts an emergency using the SAT System
     * with a given distance and patients
     * @param distance
     * @param patient
     */
    public void startEmergency(int distance, Patient patient)
            throws CallAlreadyDispatched {
        this.startEmergency(distance, new ArrayList<Patient>((Collection<? extends Patient>) patient));
    }

    /**
     * Event applied when a trip gets started
     * @param trip
     */
    public void onTripStarted(Trip trip, Stretcher stretcher) {
        // TODO : Implement RTES (Real Time Emergency System) and start
        //        to count the distance travelled by the stretcher
        this.status = SATSystem.STATUS_WAITING;
    }

    /**
     * SATSystem clinic getter
     * @return Clinic
     */
    public Clinic getClinic() {
        return clinic;
    }

    /**
     * SATSystem clinic setter
     * @param clinic
     */
    public void setClinic(Clinic clinic) {
        this.clinic = clinic;
    }

}
