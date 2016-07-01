package com.cst;

import com.cst.model.clinic.Clinic;
import com.cst.model.employee.Doctor;
import com.cst.view.MainMenu;

/**
 * Hello world!
 *
 */
public class App {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public static final Clinic CLINIC = new Clinic();

    // TODO: meter algun loop para que el programa siga corriendo (buscar un lugar piola o significativo)
    // IDEA: que sea algo llamando al MainMenu si no hay ningún NativeKeyListener en el GlobalScreen
    // PROTIP: (new Scanner(System.in)).nextLine() borra el input!!
    public static void main(String[] args) {
        System.out.println("Bienvenido!");
        simulation1();
        new MainMenu();
    }

    private static void simulation1(){
        CLINIC.addDoctor(new Doctor("Eriberto Eribedes", 7400.00));
    }
}
