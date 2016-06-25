package com.cst.model.employee;

import com.cst.model.clinic.Trip;
import com.cst.model.employee.Employee;

import java.util.ArrayList;
import java.util.List;

/**
 * Stretcher class - Translation: "Camillero"
 * @package com.cst.model
 */
public class Stretcher extends Employee {

    /** List of finished trips done by the stretcher */
    private List<Trip> trips;

    /** Current trip being carried by the stretcher */
    private Trip currentTrip;

    /**
     * Stretcher class constructor
     *
     * @param name
     * @param salary
     */
    public Stretcher(String name, Double salary) {
        super(name, salary);
        this.trips = new ArrayList<Trip>();
    }

    /**
     * Obtains all finished trips from the stretcher
     * @return List<Trip>
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

}
