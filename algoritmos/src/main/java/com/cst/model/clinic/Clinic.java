package com.cst.model.clinic;

import com.cst.events.*;
import com.cst.events.listeners.OperationStartedListener;
import com.cst.events.listeners.TripFinishedListener;
import com.cst.exceptions.NoAdministrativeAvailableException;
import com.cst.exceptions.NoDoctorAvailableException;
import com.cst.exceptions.NoStretcherAvailableException;
import com.cst.model.employee.Administrative;
import com.cst.model.employee.Doctor;
import com.cst.model.employee.Employee;
import com.cst.model.employee.Stretcher;
import com.cst.model.patient.Patient;
import com.cst.systems.SATSystem;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Clinic class - Base container model
 */
public class Clinic implements TripFinishedListener, OperationStartedListener {

    /** List of doctors assigned to the clinic */
    private List<Doctor> doctors;

    /** List of administrative employees assigned to the clinic*/
    private List<Administrative> administratives;

    /** List of stretchers assigned to the clinic */
    private List<Stretcher> stretchers;

    /** List of operations performed by the clinic */
    private List<Operation> operations;

    /** Clinics will handle their own event dispatchers */
    private Dispatcher dispatcher;

    /** Reference of a clinic's SATSystem */
    private SATSystem satSystem;

    /**
     * Clinic class constructor
     */
    public Clinic() {
        this.doctors = new ArrayList<Doctor>();
        this.administratives = new ArrayList<Administrative>();
        this.stretchers = new ArrayList<Stretcher>();
        this.dispatcher = new Dispatcher();
        this.satSystem = new SATSystem(this);
        this.dispatcher.listen(TripStarted.class, this.satSystem);
        this.dispatcher.listen(TripFinished.class, this);
    }

    /**
     * Event fired when a trip gets finished
     * @param trip
     */
    public void onTripFinished(Trip trip) throws NoDoctorAvailableException {
        for(Patient patient : trip.getPatients()) {
            Doctor doctor = this.getFreeDoctor();
            Operation operation = new Operation(doctor, patient);

            this.operations.add(operation);
            this.dispatcher.notify(new OperationStarted(operation));
        }
    }

    /**
     * Operation started event listener
     * @param operation
     */
    public void onOperationStarted(Operation operation) {
        operation.setStatus(Visit.STATUS_IN_PROGRESS);
        operation.getDoctor().addSalary(operation);
        operation.perform();
    }

    /**
     * Adds a new doctor to the clinic
     * @param doctor
     * @return Clinic self-reference for chaining methods
     */
    public Clinic addDoctor(Doctor doctor) {
        this.doctors.add(doctor);
        return this;
    }

    /**
     * Adds a new stretcher to the clinic
     * @param stretcher
     * @return Clinic
     */
    public Clinic addStretcher(Stretcher stretcher) {
        this.dispatcher.listen(EmergencyCallDispatch.class, stretcher);
        this.stretchers.add(stretcher);
        return this;
    }

    /**
     * Obtains a free stretcher from the stretchers pool
     * @return Administrative
     */
    public Administrative getFreeAdministrativeEmployee() throws NoAdministrativeAvailableException {
        for(Administrative administrative : this.administratives) {
            if(administrative.getStatus() == Employee.STATUS_WAITING) {
                return administrative;
            }
        }

        throw new NoAdministrativeAvailableException();
    }

    /**
     * Obtains a free stretcher from the stretchers pool
     * @return Stretcher
     */
    public Stretcher getFreeStretcher() throws NoStretcherAvailableException {
        for(Stretcher stretcher : this.stretchers) {
            if(stretcher.getStatus() == Employee.STATUS_WAITING) {
                return stretcher;
            }
        }

        throw new NoStretcherAvailableException();
    }

    /**
     * Obtains all the free stretchers from the stretcher pool
     * @return ArrayList
     */
    public ArrayList<Stretcher> getFreeStretchers() throws NoStretcherAvailableException {
        ArrayList<Stretcher> free = new ArrayList<Stretcher>();

        for(Stretcher stretcher : this.stretchers) {
            if(stretcher.getStatus() == Employee.STATUS_WAITING) {
                free.add(stretcher);
            }
        }

        if(free.size() < 1) {
            throw new NoStretcherAvailableException();
        }

        return free;
    }

    /**
     * Obtains a free doctor from the stretchers pool
     * @return Stretcher
     */
    public Doctor getFreeDoctor() throws NoDoctorAvailableException {
        for(Doctor doctor : this.doctors) {
            if(doctor.getStatus() == Employee.STATUS_WAITING) {
                return doctor;
            }
        }

        throw new NoDoctorAvailableException();
    }

    /**
     * Obtains a list of all the doctor salaries
     * TODO : Move this logic into a separate class,
     *        as it should be able to calculate all
     *        the stretcher salaries as long with
     *        the other employee salaries.
     *        (Punto 1 del tp)
     *
     * @return List
     */
    public List<Salary> getSalaries() {
        List<Salary> salaries = new LinkedList<Salary>();
        for (Doctor doctor : doctors) {
            salaries.add(new Salary(doctor));
        }
        return salaries;
    }

    /**
     * Clinic dispatcher getter
     * @return Dispatcher
     */
    public Dispatcher getDispatcher() {
        return dispatcher;
    }

    /**
     * Clinic dispatcher setter
     * @param dispatcher
     */
    public void setDispatcher(Dispatcher dispatcher) {
        this.dispatcher = dispatcher;
    }

    /**
     * Clinic SATSystem getter
     * @return SATSystem
     */
    public SATSystem getSatSystem() {
        return satSystem;
    }

    /**
     * Clinic SATSystem setter
     * @param satSystem
     */
    public void setSatSystem(SATSystem satSystem) {
        this.satSystem = satSystem;
    }

}
