package com.ciattisevillanotroncoso.view;

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
    public void nativeKeyTyped(NativeKeyEvent e) {
        switch (e.getKeyChar()){
            case '1': loadPersonnelMenu();
            case '2': loadPatientsMenu();
            case '3': loadAmbulanceMenu();
            case '4': quit();
        }
    }

    private void loadPersonnelMenu(){
        GlobalScreen.removeNativeKeyListener(this);
        clearScreen();
        GlobalScreen.addNativeKeyListener(new PersonnelMenu());
    }

    private void loadPatientsMenu(){

    }

    private void loadAmbulanceMenu(){

    }

    private void quit(){
        System.exit(0);
    }
}
