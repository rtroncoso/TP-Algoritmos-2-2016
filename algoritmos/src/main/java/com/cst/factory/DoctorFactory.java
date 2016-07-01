package com.cst.factory;

import com.cst.model.employee.Doctor;
import com.cst.model.patient.Healthcare;
import com.cst.model.patient.Patient;

/**
 * DoctorFactory class
 * Creates dummy doctors with dummy data
 */
public class DoctorFactory extends Factory<Doctor> {

    /**
     * Creates a new doctor using fake dummy data
     * @return
     */
    public Doctor create() {
        return new Doctor(
            this.faker.name().fullName(),
            this.faker.number().numberBetween(7000, 9000)
        );
    }

}
