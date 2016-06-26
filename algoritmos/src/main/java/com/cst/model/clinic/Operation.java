package com.cst.model.clinic;

import com.cst.model.patient.Patient;
import com.cst.model.employee.Doctor;

/**
 * Operation class
 */
public class Operation extends Visit {

    /**
     * Visit class constructor
     *
     * @param doctor
     * @param patient
     */
    public Operation(Doctor doctor, Patient patient) {
        super(doctor, patient);
    }

}
