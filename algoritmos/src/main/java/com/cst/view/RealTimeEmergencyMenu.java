package com.cst.view;

import com.cst.factory.AdministrativeFactory;
import com.cst.factory.DoctorFactory;
import com.cst.factory.StretcherFactory;
import com.cst.model.clinic.Clinic;
import com.cst.model.employee.Administrative;
import com.cst.model.employee.Doctor;
import com.cst.model.employee.Stretcher;
import com.cst.systems.RealTimeEmergencySystem;
import com.cst.util.RandomNumber;

import java.text.SimpleDateFormat;
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
        this.rteSystem = new RealTimeEmergencySystem(this.clinic, 1, 's');
        this.addStretchers();
        this.addAdministratives();
        this.addDoctors();
        this.showHelp();

        while(true) {
            String command = this.scanner.nextLine();
            this.processCommand(command.toLowerCase());
        }
    }

    /**
     * Adds dummy doctors to the system
     */
    private void addDoctors() {
        for(int i=0; i < RandomNumber.get(1, 4); i++) {
            Doctor doctor = new DoctorFactory().create();
            this.clinic.addDoctor(doctor);
            this.print("Agregado un doctor a la clinica: " + doctor.getName() +
                       " con remuneración mensual: " + doctor.getBaseSalary());
        }
    }

    /**
     * Adds dummy administrative employees to the clinic
     */
    private void addAdministratives() {
        for(int i=0; i < RandomNumber.get(1, 1); i++) {
            Administrative administrative = new AdministrativeFactory().create();
            this.clinic.addAdministrative(administrative);
            this.print("Agregado administrativo a la clínica: " + administrative.getName() +
                    " con remuneración mensual: " + administrative.getBaseSalary());
        }
    }

    /**
     * Adds dummy stretchers to the clinic
     */
    private void addStretchers() {
        for(int i=0; i < RandomNumber.get(1, 2); i++) {
            Stretcher stretcher = new StretcherFactory().create();
            this.clinic.addStretcher(stretcher);
            this.print("Agregado camillero a la clínica: " + stretcher.getName() +
                    " con remuneración mensual: " + stretcher.getBaseSalary());
        }
    }

    /**
     * Processes a command typed in by the user
     * @param command
     */
    private void processCommand(String command) {
        if(command.equals("start")) this.start();
        if(command.equals("quit")) new MainMenu();
//        if(command.equals("pause")) this.rteSystem.pause();
    }

    /**
     * Starts the emergency system
     */
    private void start() {
        this.rteSystem.start();
        this.print("Sistema de emergencias iniciado, cada 10 segundos el sistema avanzará una hora.");
    }

    /**
     * Prints a message to the string with prettified timestamps
     * @param message
     */
    private void print(String message) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("[" + format.format(this.rteSystem.getTime().getTime()) + "]: " + message);
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
