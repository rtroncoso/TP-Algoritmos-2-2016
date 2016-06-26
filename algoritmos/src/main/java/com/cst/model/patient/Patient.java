package com.cst.model.patient;


/**
 * Patient class
 */
public class Patient {

    private String name;
    private int age;
    private Healthcare healthcare;

    /**
     * Patient class - optional parameter constructor
     * Use this to instantiate Patients without healthcare
     *
     * @param name
     * @param age
     */
    public Patient(String name, int age) {
        this(name, age, null);
    }

    /**
     * Patient class constructor
     *
     * @param name
     * @param age
     * @param healthcare
     */
    public Patient(String name, int age, Healthcare healthcare) {
        this.name = name;
        this.age = age;
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
     * Patient age getter
     * @return int
     */
    public int getAge() {
        return age;
    }

    /**
     * Patient age setter
     * @param age
     */
    public void setAge(int age) {
        this.age = age;
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
