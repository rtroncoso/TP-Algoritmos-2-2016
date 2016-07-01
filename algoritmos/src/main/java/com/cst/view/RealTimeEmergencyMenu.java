package com.cst.view;

import com.cst.events.*;
import com.cst.events.listeners.*;
import com.cst.factory.AdministrativeFactory;
import com.cst.factory.DoctorFactory;
import com.cst.factory.StretcherFactory;
import com.cst.model.clinic.Clinic;
import com.cst.model.clinic.Operation;
import com.cst.model.clinic.Trip;
import com.cst.model.employee.Administrative;
import com.cst.model.employee.Doctor;
import com.cst.model.employee.Stretcher;
import com.cst.model.patient.Patient;
import com.cst.systems.RealTimeEmergencySystem;
import com.cst.util.RandomNumber;

import java.text.SimpleDateFormat;
import java.util.Scanner;

/**
 * RealTimeEmergencyMeu class
 * Ties up all systems together and launches the emergency system.
 * Handles all console ouput for every event.
 */
public class RealTimeEmergencyMenu implements
        EmergencyCallDispatchListener, TripStartedListener,
        DistanceTravelledListener, OperationStartedListener,
        OperationFinishedListener {

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
        this.clinic.getDispatcher().listen(EmergencyCallDispatch.class, this);
        this.clinic.getDispatcher().listen(TripStarted.class, this);
        this.clinic.getDispatcher().listen(DistanceTravelled.class, this);
        this.clinic.getDispatcher().listen(OperationStarted.class, this);
        this.clinic.getDispatcher().listen(OperationFinished.class, this);

        // Step one hour every 10 seconds
        this.rteSystem = new RealTimeEmergencySystem(this.clinic, 10, 's');
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
        for(int i=0; i < RandomNumber.get(2, 4); i++) {
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
        System.out.println("Cada una hora habrá una posibilidad de 20% de que se genere una emergencia.");
        System.out.println("Ingrese \"start\" para empezar");
        System.out.println("Ingrese \"quit\" en cualquier momento para salir del sistema de emergencias.");
    }

    /**
     * Fired when an emergency call gets dispatched
     * @param trip
     * @param clinic
     */
    public void onEmergencyCallDispatch(Trip trip, Clinic clinic) {
        this.print("Se ha recibido una llamada de emergencia a " +
                trip.getDistance() + " kilómetros de la clínica!");
        for(Patient patient : trip.getPatients()) {
            this.print("Paciente asociado a la llamada: " + patient.getName() +
                       ((patient.getHealthcare() != null) ?
                       " con obra social: " + patient.getHealthcare().getCompany() :
                       " sin obra social."));
        }
    }

    /**
     * Fired when a trip to the clinic gets started
     * @param trip
     * @param stretcher
     */
    public void onTripStarted(Trip trip, Stretcher stretcher) {
        this.print("El camillero " + stretcher.getName() + " ha atendido la llamada y " +
                   "está en camino a la clinica!");
    }

    /**
     * Fired when the trip progresses 1 kilometer of distance
     * @param trip
     */
    public void onDistanceTravelled(Trip trip) {
        this.print("La ambulancia ha avanzado un kilómetro, quedan " +
                   (trip.getDistance() - trip.getTravelled()) +
                   " kilómetros para llegar a la clínica.");
    }

    /**
     * Fired when an operation gets started
     * @param operation
     */
    public void onOperationStarted(Operation operation) {
        this.print("La ambulancia ha llegado a la clínica y el doctor " +
                   operation.getDoctor().getName() + " está atendiendo la operación.");
    }

    /**
     * Fired when an operation gets finished
     * @param operation
     */
    public void onOperationFinished(Operation operation) {
        this.print("La operación ha finalizado con éxito!");
    }

}
