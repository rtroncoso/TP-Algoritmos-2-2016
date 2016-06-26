package com.cst.model.clinic;

import com.cst.model.patient.Patient;
import com.cst.model.employee.Doctor;

/**
 * Clinical Consult class - Translation: "Consulta Médica"
 */
public class Consult extends Visit {

    /**
     * Consult class constructor
     *
     * @param doctor
     * @param patient
     */
    public Consult(Doctor doctor, Patient patient) {
        super(doctor, patient);
    }

}
