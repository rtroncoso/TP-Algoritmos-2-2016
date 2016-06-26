package com.cst.model.clinic;

import com.cst.model.patient.Patient;
import com.cst.model.employee.Doctor;

/**
 * Visit class
 */
public abstract class Visit {

    /** Used when an operation is on hold */
    public static final int STATUS_WAITING = 1;

    /** Status for when an operation is in progress */
    public static final int STATUS_IN_PROGRESS = 2;

    /** Status for when an operation is finished */
    public static final int STATUS_FINISHED = 3;

    /** Doctor associated to this visit */
    protected Doctor doctor;

    /** Patient associated to this patient */
    protected Patient patient;

    /** Current status of this visit */
    private int status;

    /**
     * Visit class constructor
     * @param doctor
     * @param patient
     */
    public Visit(Doctor doctor, Patient patient) {
        this.status = STATUS_WAITING;
        this.doctor = doctor;
        this.patient = patient;
    }

    /**
     * Performs a medical visit, implementation on each super class
     */
    public abstract void perform();

    /**
     * Visit doctor getter
     * @return Doctor
     */
    public Doctor getDoctor() {
        return doctor;
    }

    /**
     * Visit doctor setter
     * @param doctor
     */
    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    /**
     * Visit patient getter
     * @return Patient
     */
    public Patient getPatient() {
        return patient;
    }

    /**
     * Visit patient setter
     * @param patient
     */
    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    /**
     * Visit status getter
     * @return int
     */
    public int getStatus() {
        return status;
    }

    /**
     * Visit status setter
     * @param status
     */
    public void setStatus(int status) {
        this.status = status;
    }

}
