package com.cst.view;

import com.cst.model.clinic.Clinic;
import com.cst.systems.RealTimeEmergencySystem;

import java.util.Scanner;

/**
 * RealTimeEmergencyMeu class
 * Ties up all systems together and launches the emergency system.
 * Handles all console ouput for every event.
 */
public class RealTimeEmergencyMenu {

    /** Real time emergency system instance reference */
    private RealTimeEmergencySystem rteSystem;

    /** Private reference to clinic */
    private Clinic clinic = new Clinic();

    /** Scans for user input */
    private Scanner scanner = new Scanner(System.in);

    /**
     * RealTimeEmergencyMenu constructor
     */
    public RealTimeEmergencyMenu(){
        // Step one hour every 10 seconds
        this.rteSystem = new RealTimeEmergencySystem(this.clinic, 30, 's');
        this.showHelp();

        while(true) {
            String command = this.scanner.nextLine();
            this.processCommand(command.toLowerCase());
        }
    }

    /**
     * Processes a command typed in by the user
     * @param command
     */
    private void processCommand(String command) {
        if(command.equals("start")) this.rteSystem.start();
        if(command.equals("quit")) new MainMenu();
//        if(command.equals("pause")) this.rteSystem.pause();
    }

    /**
     * Shows help banner to the user
     */
    private void showHelp() {
        System.out.println("================================================================");
        System.out.println("Bienvenido al sistema de emergencias automatizado de la clínica!");
        System.out.println("Ingrese \"start\" para empezar");
        System.out.println("Ingrese \"quit\" en cualquier momento para salir del sistema de emergencias.");
    }

}
