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
        this.options.add("Salir.");
        listOptions();
    }

    @Override
    protected void menu(int opt) {
        switch (opt) {
            case 1: loadEmergencySystem(); break;
            case 2: quit(); break;
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
