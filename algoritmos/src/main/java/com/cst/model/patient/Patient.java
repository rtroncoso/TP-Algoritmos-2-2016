package com.cst.model.patient;

import java.util.Date;

/**
 * Patient class
 */
public class Patient {

    private String name;
    private Date birthdate;
    private Healthcare healthcare;

    /**
     * Patient class - optional parameter constructor
     * Use this to instantiate Patients without healthcare
     *
     * @param name
     * @param birthdate
     */
    public Patient(String name, Date birthdate) {
        this(name, birthdate, null);
    }

    /**
     * Patient class constructor
     *
     * @param name
     * @param birthdate
     * @param healthcare
     */
    public Patient(String name, Date birthdate, Healthcare healthcare) {
        this.name = name;
        this.birthdate = birthdate;
        this.healthcare = healthcare;
    }

    /**
     * Patient name getter
     * @return String name
     */
    public String getName() {
        return name;
    }

    /**
     * Patient name setter
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Patient birthdate getter
     * @return Date
     */
    public Date getBirthdate() {
        return birthdate;
    }

    /**
     * Patient birthdate setter
     * @param birthdate
     */
    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    /**
     * Patient healthcare getter
     * @return Healthcare
     */
    public Healthcare getHealthcare() {
        return healthcare;
    }

    /**
     * Patient healthcare setter
     * @param healthcare
     */
    public void setHealthcare(Healthcare healthcare) {
        this.healthcare = healthcare;
    }

}
