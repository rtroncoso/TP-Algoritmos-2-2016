package com.cst.factory;

import com.cst.model.employee.Administrative;

/**
 * AdministrativeFActory class
 * Creates dummy administratives with dummy data
 */
public class AdministrativeFactory extends Factory<Administrative> {

    /**
     * Creates a new administratie employee using fake dummy data
     * @return
     */
    public Administrative create() {
        return new Administrative(
            this.faker.name().fullName(),
            this.faker.number().numberBetween(4000, 5000)
        );
    }

}
