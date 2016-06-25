package com.cst.model;

/**
 * Created by rtroncoso on 6/25/16.
 */
public class Visit {

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
