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
        this.options.add("Personal");
        this.options.add("Pacientes");
        this.options.add("Ambulancia");
        this.options.add("Salir");
        listOptions();
    }

    @Override
    protected void menu(int opt) {
        switch (opt) {
            case 1: loadPersonnelMenu(); break;
            case 2: loadPatientsMenu(); break;
            case 3: loadAmbulanceMenu(); break;
            case 4: quit(); break;
            default: invalidOption(); break;
        }
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
