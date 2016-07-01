package com.cst.model.clinic;

import com.cst.events.DistanceTravelled;
import com.cst.events.TripFinished;
import com.cst.events.listeners.DistanceTravelledListener;
import com.cst.model.employee.Employee;
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

    /** Local reference of this trip's clinic */
    private Clinic clinic;

    /**
     * Trip class constructor
     * @param distance
     * @param patients
     */
    public Trip(int distance, ArrayList<Patient> patients, Clinic clinic) {
        clinic.getDispatcher().listen(DistanceTravelled.class, this);
        this.status = STATUS_WAITING;
        this.clinic = clinic;
        this.distance = distance;
        this.patients = patients;
        this.travelled = 0;
    }

    /**
     * One-patient Trip class constructor
     * @param distance
     * @param patient
     */
    public Trip(int distance, Patient patient, Clinic clinic) {
        this(distance, new ArrayList<Patient>((Collection<? extends Patient>) patient), clinic);
    }

    /**
     * Event fired when the trip gets distance travelled (1 kilometer)
     * @param trip
     */
    public void onDistanceTravelled(Trip trip) {
        if(this.travelled >= this.distance) {
            this.clinic.getDispatcher().notify(new TripFinished(this));
            this.stretcher.setStatus(Employee.STATUS_WAITING);
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
     * Trip travelled getter
     * @return int
     */
    public int getTravelled() {
        return travelled;
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

    /**
     * Trip clinic getter
     * @return Clinic
     */
    public Clinic getClinic() {
        return clinic;
    }

    /**
     * Trip clinic setter
     * @param clinic
     */
    public void setClinic(Clinic clinic) {
        this.clinic = clinic;
    }

}
