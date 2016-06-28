package com.cst.model.employee;

import com.cst.events.TripStarted;
import com.cst.events.listeners.EmergencyCallDispatchListener;
import com.cst.model.clinic.Clinic;
import com.cst.model.clinic.Trip;
import com.cst.util.DateHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Stretcher class - Translation: "Camillero"
 */
public class Stretcher extends Employee implements EmergencyCallDispatchListener {

    /** Base salary for an emergency pickup */
    public static final double BASE_PICKUP_SALARY = 20;

    /** Salary to be added on each kilometer travelled */
    public static final double DISTANCE_TRAVELLED_SALARY = 100;

    /** Salary to be added for each person in the trip */
    public static final double ADDITIONAL_PERSON_SALARY = 120;

    /** List of finished trips done by the stretcher */
    private List<Trip> trips;

    /** Current trip being carried by the stretcher */
    private Trip currentTrip;

    /** Clinic associated with this stretcher */
    private Clinic clinic;

    /**
     * Stretcher class constructor
     * @param name
     * @param salary
     */
    public Stretcher(String name, double salary) {
        super(name, salary);
        this.clinic = clinic;
        this.trips = new ArrayList<Trip>();
    }

    /**
     * Called when an emergency gets dispatched
     * @param trip
     */
    public void onEmergencyCallDispatch(Trip trip) {
        if(trip.getStatus() == Trip.STATUS_WAITING &&
           this.status == Employee.STATUS_WAITING) {
            this.addSalary(DateHelper.isWeekend(trip.getDate()) ?
                    Stretcher.BASE_PICKUP_SALARY * 2:
                    Stretcher.BASE_PICKUP_SALARY);

            if(trip.getPatients().size() > 1) {
                this.addSalary(DateHelper.isWeekend(trip.getDate()) ?
                        trip.getPatients().size() * Stretcher.ADDITIONAL_PERSON_SALARY * 2:
                        trip.getPatients().size() * Stretcher.ADDITIONAL_PERSON_SALARY);
            }

            this.setStatus(Employee.STATUS_TRIPPING);
            trip.setStatus(Trip.STATUS_ON_ROUTE);
            trip.setStretcher(this);
            this.clinic.getDispatcher().notify(new TripStarted(trip, this));
        }
    }

    /**
     * Obtains all finished trips from the stretcher
     * @return List
     */
    public List<Trip> getTrips() {
        return trips;
    }

    /**
     * Sets the Trips list of a stretcher (not going to be used?)
     * @param trips
     */
    public void setTrips(List<Trip> trips) {
        this.trips = trips;
    }

    /**
     * Gets the current trip of a stretcher
     * @return Trip
     */
    public Trip getCurrentTrip() {
        return currentTrip;
    }

    /**
     * Sets the current trip for the stretcher
     * @param currentTrip
     */
    public void setCurrentTrip(Trip currentTrip) {
        this.currentTrip = currentTrip;
    }

    /**
     * Stretcher clinic getter
     * @return Clinic
     */
    public Clinic getClinic() {
        return clinic;
    }

    /**
     * Stretcher clinic setter
     * @param clinic
     */
    public void setClinic(Clinic clinic) {
        this.clinic = clinic;
    }

}
