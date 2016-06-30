package com.cst.factory;

import com.github.javafaker.Faker;

/**
 * Factory class
 */
public abstract class Factory<T> {

    /** Faker object to create randomized entities */
    protected Faker faker = new Faker();

    /**
     * Returns an instance of the object to factorize
     * @return
     */
    public abstract T create();

}
