package com.cst.systems;

import com.cst.events.TripStarted;
import com.cst.events.listeners.TripStartedListener;
import com.cst.exceptions.NoStretcherAvailableException;
import com.cst.model.clinic.Clinic;
import com.cst.model.clinic.Trip;
import com.cst.model.employee.Employee;
import com.cst.model.employee.Stretcher;
import com.cst.model.patient.Patient;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * SATSystem class - translation: "Sistema de Atención Telefónica"
 * @package com.cst.systems;
 */
public class SATSystem implements TripStartedListener {

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
        Stretcher stretcher = this.clinic.getFreeStretcher();
        Trip trip = new Trip(distance, stretcher, patients);
        this.clinic.getDispatcher().notify(new TripStarted(trip, stretcher));
        this.trips.add(trip);
    }

    /**
     * Event applied when a trip gets started
     * @param trip
     */
    public void onTripStarted(Trip trip, Stretcher stretcher) {
        // TODO : Implement RTES (Real Time Emergency System) and start
        //        to count the distance travelled by the stretcher
        stretcher.setStatus(Employee.STATUS_TRIPPING);
        trip.setStatus(Trip.STATUS_ON_ROUTE);
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
