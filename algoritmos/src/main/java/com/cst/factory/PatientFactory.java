package com.cst.factory;

import com.cst.model.patient.Healthcare;
import com.cst.model.patient.Patient;

/**
 * Created by rtroncoso on 6/30/16.
 */
public class PatientFactory extends Factory<Patient> {

    /**
     * Creates a new patient using fake dummy data
     * @return
     */
    public Patient create() {
        return new Patient(
            this.faker.name().fullName(),
            this.faker.number().numberBetween(10, 90),
            this.faker.bool().bool() ?
                new Healthcare(
                    this.faker.number().numberBetween((long) 1, (long) 100),
                    this.faker.company().name()
                ) : null
        );
    }

}
