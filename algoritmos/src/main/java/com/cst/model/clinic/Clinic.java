package com.cst.model.clinic;

import com.cst.events.*;
import com.cst.events.listeners.*;
import com.cst.exceptions.NoAdministrativeAvailableException;
import com.cst.exceptions.NoDoctorAvailableException;
import com.cst.exceptions.NoStretcherAvailableException;
import com.cst.model.employee.Administrative;
import com.cst.model.employee.Doctor;
import com.cst.model.employee.Employee;
import com.cst.model.employee.Stretcher;
import com.cst.model.patient.Patient;
import com.cst.systems.SATSystem;
import com.cst.util.JoinList;

import java.util.ArrayList;
import java.util.List;

/**
 * Clinic class - Base container model
 */
public class Clinic implements
        TripFinishedListener, OperationStartedListener,
        OperationFinishedListener, ConsultStartedListener,
        ConsultFinishedListener {

    /** List of doctors assigned to the clinic */
    private List<Doctor> doctors;

    /** List of administrative employees assigned to the clinic*/
    private List<Administrative> administratives;

    /** List of stretchers assigned to the clinic */
    private List<Stretcher> stretchers;

    /** List of operations performed by the clinic */
    private List<Operation> operations;

    /** List of consults performed by the clinic */
    private List<Consult> consults;

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
        this.operations = new ArrayList<Operation>();
        this.consults = new ArrayList<Consult>();
        this.dispatcher = new Dispatcher();
        this.satSystem = new SATSystem(this);
        this.dispatcher.listen(TripStarted.class, this.satSystem);
        this.dispatcher.listen(TripFinished.class, this);
        this.dispatcher.listen(OperationStarted.class, this);
        this.dispatcher.listen(OperationFinished.class, this);
        this.dispatcher.listen(ConsultStarted.class, this);
        this.dispatcher.listen(ConsultFinished.class, this);
    }

    /**
     * Event fired when a trip gets finished
     *
     * TODO : If no doctors are available, patients should be moved to a
     *        waiting pool and get attended as soon as a doctor frees up
     *
     * @param trip
     */
    public void onTripFinished(Trip trip) throws NoDoctorAvailableException {
        for(Patient patient : trip.getPatients()) {
            Doctor doctor = this.getFreeDoctor();
            Operation operation = new Operation(doctor, patient);

            this.dispatcher.notify(new OperationStarted(operation));
            return;
        }
    }

    /**
     * Operation started event listener
     * @param operation
     */
    public void onOperationStarted(Operation operation) {
        this.operations.add(operation);
        operation.setStatus(Visit.STATUS_IN_PROGRESS);
        operation.getDoctor().setStatus(Employee.STATUS_OPERATION);
        operation.getDoctor().addSalary(operation, this);
    }

    /**
     * Operation started event listener
     * @param operation
     */
    public void onOperationFinished(Operation operation) {
        operation.getDoctor().setStatus(Employee.STATUS_WAITING);
        operation.setStatus(Visit.STATUS_FINISHED);
        this.satSystem.setStatus(SATSystem.STATUS_WAITING);
    }

    /**
     * Consult started event listener
     * @param consult
     */
    public void onConsultStarted(Consult consult) {
        this.consults.add(consult);
        consult.getDoctor().setStatus(Employee.STATUS_CONSULT);
        consult.getDoctor().addSalary(consult, this);
        consult.setStatus(Visit.STATUS_IN_PROGRESS);
    }

    /**
     * Consult finished event listener
     * @param consult
     */
    public void onConsultFinished(Consult consult) {
        consult.getDoctor().setStatus(Employee.STATUS_WAITING);
        consult.setStatus(Visit.STATUS_FINISHED);
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
     * Adds a new administrative employees to the clinic
     * @param administrative
     * @return Clinic self-reference for chaining methods
     */
    public Clinic addAdministrative(Administrative administrative) {
        this.administratives.add(administrative);
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
     * Clinic dispatcher getter
     * @return Dispatcher
     */
    public Dispatcher getDispatcher() {
        return dispatcher;
    }

    /**
     * Clinic SATSystem getter
     * @return SATSystem
     */
    public SATSystem getSatSystem() {
        return satSystem;
    }

    /**
     * Returns the list of administrative employees in this clinic
     * @return
     */
    public List<Administrative> getAdministratives() {
        return this.administratives;
    }

    /**
     * Returns a list of all the employees in this clinic
     * @return
     */
    public List<Employee> getEmployees(){
        return new JoinList<Employee>(new JoinList<Employee>(this.doctors, this.stretchers), this.administratives);
    }

}
