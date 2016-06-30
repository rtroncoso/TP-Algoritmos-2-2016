package com.cst.systems;

import com.cst.events.EmergencyCallDispatch;
import com.cst.events.listeners.TripStartedListener;
import com.cst.exceptions.CallAlreadyDispatched;
import com.cst.model.clinic.Clinic;
import com.cst.model.clinic.Trip;
import com.cst.model.employee.Stretcher;
import com.cst.model.patient.Patient;

import java.util.*;

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
     * @param date
     */
    public Trip startEmergency(int distance, ArrayList<Patient> patients, Calendar date)
            throws CallAlreadyDispatched {
        if(this.status == SATSystem.STATUS_DISPATCHED) {
            throw new CallAlreadyDispatched();
        }

        Trip trip = new Trip(distance, patients, this.clinic);
        trip.setDate(date);
        this.clinic.getDispatcher().notify(new EmergencyCallDispatch(trip, this.clinic));
        this.status = SATSystem.STATUS_DISPATCHED;
        return trip;
    }

    /**
     * Starts an emergency using the SAT System
     * with a given distance and patients
     * @param distance
     * @param patient
     * @param date
     */
    public void startEmergency(int distance, Patient patient, Calendar date)
            throws CallAlreadyDispatched {
        this.startEmergency(distance, new ArrayList<Patient>((Collection<? extends Patient>) patient), date);
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
