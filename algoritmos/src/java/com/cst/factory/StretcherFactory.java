package com.cst.factory;

import com.cst.model.employee.Stretcher;

/**
 * StretcherFActory class
 * Creates dummy stretchers with dummy data
 */
public class StretcherFactory extends Factory<Stretcher> {

    /**
     * Creates a new stretchers using fake dummy data
     * @return
     */
    public Stretcher create() {
        return new Stretcher(
            this.faker.name().fullName(),
            this.faker.number().numberBetween(3000, 4000)
        );
    }

}
