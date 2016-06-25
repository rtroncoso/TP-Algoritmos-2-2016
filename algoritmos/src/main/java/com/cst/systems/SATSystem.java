package com.cst.systems;

import com.cst.exceptions.NoStretcherAvailableException;
import com.cst.model.clinic.Clinic;
import com.cst.model.clinic.Trip;
import com.cst.model.patient.Patient;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * SATSystem class - translation: "Sistema de Atención Telefónica"
 * @package com.cst.systems;
 */
public class SATSystem {

    /** Clinic associated to this SAT */
    private Clinic clinic;

    /** List of trips registered in the SAT */
    private List<Trip> trips;

    /**
     * SAT System class constructor
     * @param clinic
     */
    public SATSystem(Clinic clinic) {
        this.clinic = clinic;
    }

    /**
     * Starts a trip using the SATSystem
     * @param patients
     */
    public void startTrip(int distance, ArrayList<Patient> patients) throws NoStretcherAvailableException {
        // TODO : Implement start trip event and other weeds
        Trip trip = new Trip(distance, this.clinic.getFreeStretcher(), patients);
        this.trips.add(trip);
    }

    /**
     * Starts a trip using the SATSystem.
     * Constructor for a one-patient trip.
     * @param patient
     */
    public void startTrip(int distance, Patient patient) throws NoStretcherAvailableException {
        this.startTrip(distance, new ArrayList<Patient>((Collection<? extends Patient>) patient));
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
