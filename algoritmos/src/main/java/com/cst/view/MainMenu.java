package com.cst.view;

import org.jnativehook.GlobalScreen;
import org.jnativehook.keyboard.NativeKeyEvent;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA by: alejandro
 * Date: 24/06/16
 * Time: 14:55
 */
public class MainMenu extends Menu {

    public MainMenu(){
        this.title = "Menu Principal";
        this.options = new ArrayList<String>(3);
        this.options.add("Empezar sistema de emergencias automatizado.");
        this.options.add("Personal");
        this.options.add("Pacientes");
        this.options.add("Ambulancia");
        this.options.add("Salir");
        listOptions();
    }

    @Override
    protected void menu(int opt) {
        switch (opt) {
            case 1: loadEmergencySystem(); break;
            case 2: loadPersonnelMenu(); break;
            case 3: loadPatientsMenu(); break;
            case 4: loadAmbulanceMenu(); break;
            case 5: quit(); break;
            default: invalidOption(); break;
        }
    }

    private void loadEmergencySystem() {
        clearScreen();
        new RealTimeEmergencyMenu();
    }

    private void loadPersonnelMenu(){
        clearScreen();
        new PersonnelMenu();
    }

    private void loadPatientsMenu(){

    }

    private void loadAmbulanceMenu(){

    }

    private void quit(){
        System.exit(0);
    }
}
