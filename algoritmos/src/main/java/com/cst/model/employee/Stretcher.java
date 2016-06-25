package com.cst.model.employee;

import com.cst.model.clinic.Trip;
import com.cst.model.employee.Employee;

import java.util.ArrayList;
import java.util.List;

/**
 * Stretcher class - Translation: "Camillero"
 * @package com.cst.model
 */
public class Stretcher extends Employee {

    /** List of finished trips done by the stretcher */
    List<Trip> trips;

    /**
     * Stretcher class constructor
     *
     * @param name
     * @param salary
     */
    public Stretcher(String name, Double salary) {
        super(name, salary);
        this.trips = new ArrayList<Trip>();
    }

}
