package com.cst.model.clinic;

import com.cst.events.Dispatcher;
import com.cst.exceptions.NoDoctorAvailableException;
import com.cst.exceptions.NoStretcherAvailableException;
import com.cst.model.employee.Administrative;
import com.cst.model.employee.Doctor;
import com.cst.model.employee.Employee;
import com.cst.model.employee.Stretcher;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Clinic class - Base container model
 * @packaage com.cst.model
 */
public class Clinic {

    /** List of doctors assigned to the clinic */
    private List<Doctor> doctors;

    /** List of administrative employees assigned to the clinic*/
    private List<Administrative> administratives;

    /** List of stretchers assigned to the clinic */
    private List<Stretcher> stretchers;

    /** Clinics will handle their own event dispatchers */
    private Dispatcher dispatcher;

    /**
     * Clinic class constructor
     * TODO : Should initialize all required models
     */
    public Clinic() {
        this.doctors = new ArrayList<Doctor>();
        this.administratives = new ArrayList<Administrative>();
        this.stretchers = new ArrayList<Stretcher>();
        this.dispatcher = new Dispatcher();
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
     * @return List<Salary>
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

}
