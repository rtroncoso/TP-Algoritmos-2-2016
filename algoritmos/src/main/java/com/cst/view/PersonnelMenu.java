package com.cst.view;

import com.cst.App;
import com.cst.model.clinic.Salary;
import com.cst.model.employee.Employee;
import org.jnativehook.GlobalScreen;
import org.jnativehook.keyboard.NativeKeyEvent;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA by: alejandro
 * Date: 24/06/16
 * Time: 14:55
 */
public class PersonnelMenu extends Menu {

    public PersonnelMenu(){
        this.title = "Menu de Personal";
        this.options = new ArrayList<String>(3);
        this.options.add("Sueldos");
        this.options.add("Agregar doctor");
        this.options.add("Agregar camillero");      //TODO: pensar que cosas necesitamos poder hacer
        listOptions();
    }

    @Override
    protected void menu(int opt) {
        clearScreen();
        System.out.println(opt+": ");
        switch (opt){
            case 1: loadSalaries(); break;
            default: invalidOption(); break;
        }
    }

    private void loadSalaries(){
        // TODO: escupir salarios, (con algun key listener para volver a algún menu)
        List<Employee> employees = App.CLINIC.getEmployees();
        for (Employee employee : employees) {
            System.out.println((new Salary(employee)).toString());
        }
    }

    private void loadPatientsMenu(){

    }

    private void loadAmbulanceMenu(){

    }
}
