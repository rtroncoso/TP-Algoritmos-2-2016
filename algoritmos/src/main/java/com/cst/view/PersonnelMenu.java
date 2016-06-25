package com.cst.view;

import org.jnativehook.GlobalScreen;
import org.jnativehook.keyboard.NativeKeyEvent;

import java.util.ArrayList;

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
    public void nativeKeyTyped(NativeKeyEvent e) {
        switch (e.getKeyChar()){
            case '1': loadSalaries();
            case '2': loadPatientsMenu();     //TODO: hacerlo posta
            case '3': loadAmbulanceMenu();
        }
    }

    private void loadSalaries(){
        GlobalScreen.removeNativeKeyListener(this);
        // TODO: escupir salarios, (con algun key listener para volver a algún menu)
        clearScreen();
        GlobalScreen.addNativeKeyListener(new PersonnelMenu());
    }

    private void loadPatientsMenu(){

    }

    private void loadAmbulanceMenu(){

    }
}
