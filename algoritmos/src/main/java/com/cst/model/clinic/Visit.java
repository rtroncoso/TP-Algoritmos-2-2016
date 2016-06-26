package com.cst.model.clinic;

import com.cst.model.patient.Patient;
import com.cst.model.employee.Doctor;

/**
 * Visit class
 */
public abstract class Visit {

    private Doctor doctor;
    private Patient patient;

    /**
     * Visit class constructor
     * @param doctor
     * @param patient
     */
    public Visit(Doctor doctor, Patient patient) {
        this.doctor = doctor;
        this.patient = patient;
    }

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

}
