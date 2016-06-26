package com.cst.model.clinic;

import com.cst.events.listeners.DistanceTravelledListener;
import com.cst.model.employee.Stretcher;
import com.cst.model.patient.Patient;
import com.cst.util.DateHelper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Calendar;
import java.util.List;

/**
 * Trip class
 */
public class Trip implements DistanceTravelledListener {

    /** Status used when a trip is not yet dispatched */
    public final static int STATUS_WAITING = 1;

    /** Status used when stretcher is on route to clinic */
    public final static int STATUS_ON_ROUTE = 2;

    /** Finished trip status */
    public final static int STATUS_FINISHED = 3;

    /** Distance from rescue point to clinic (kilometers) */
    private int distance;

    /** Current distance travelled in the trip (kilometers) */
    private int travelled;

    /** Status of the trip */
    private int status;

    /** Calendar when this trip got started */
    private Calendar date;

    /** Stretcher that carries on the trip */
    private Stretcher stretcher;

    /** List of patients to be picked up */
    private List<Patient> patients;

    /**
     * Trip class constructor
     * @param distance
     * @param patients
     */
    public Trip(int distance, ArrayList<Patient> patients) {
        this.distance = distance;
        this.patients = patients;
        this.travelled = 0;
    }

    /**
     * One-patient Trip class constructor
     * @param distance
     * @param patient
     */
    public Trip(int distance, Patient patient) {
        this(distance, new ArrayList<Patient>((Collection<? extends Patient>) patient));
    }

    /**
     * Event fired when the trip gets distance travelled (1 kilometer)
     * @param trip
     */
    public void onDistanceTravelled(Trip trip) {
        if(trip != this) return; // dirty fix for global events

        if(this.travelled == this.distance) {
            // TODO : Fire an event or start right away an operation through clinic object
            this.setStatus(Trip.STATUS_FINISHED);
            return;
        }

        this.getStretcher().addSalary(DateHelper.isWeekend(this.date) ?
                Stretcher.DISTANCE_TRAVELLED_SALARY * 2 :
                Stretcher.DISTANCE_TRAVELLED_SALARY);
        this.travelled += 1;
    }

    /**
     * Trip distance getter
     * @return int
     */
    public int getDistance() {
        return distance;
    }

    /**
     * Trip distance setter
     * @param distance
     */
    public void setDistance(int distance) {
        this.distance = distance;
    }

    /**
     * Trip status getter
     * @return int
     */
    public int getStatus() {
        return status;
    }

    /**
     * Trip status setter
     * @param status
     */
    public void setStatus(int status) {
        this.status = status;
    }

    /**
     * Trip stretcher getter
     * @return Stretcher
     */
    public Stretcher getStretcher() {
        return stretcher;
    }

    /**
     * Trip stretcher setter
     * @param stretcher
     */
    public void setStretcher(Stretcher stretcher) {
        this.stretcher = stretcher;
    }

    /**
     * Obtains the list of patients for this trip
     * @return List
     */
    public List<Patient> getPatients() {
        return patients;
    }

    /**
     * Sets the list of patients for this trip
     * @param patients
     */
    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }

    /**
     * Obtains this trip starting date
     * @return Calendar
     */
    public Calendar getDate() {
        return date;
    }

    /**
     * Sets this trip starting date
     * @param date
     */
    public void setDate(Calendar date) {
        this.date = date;
    }

}
