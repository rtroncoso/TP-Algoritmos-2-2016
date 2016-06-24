package com.ciattisevillanotroncoso;

import com.ciattisevillanotroncoso.view.MainMenu;
import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import sun.applet.Main;

import java.util.logging.Level;
import java.util.logging.Logger;

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

    public static void main(String[] args) {
        initInputHandlers();
        System.out.println("Bienvenido!");
        mainMenu();
        //TODO: meter algun loop para que el programa siga corriendo (buscar un lugar piola o significativo)
        // IDEA: que sea algo llamando al MainMenu si no hay ningún NativeKeyListener en el GlobalScreen
    }

    static private void initInputHandlers(){
        // Get the logger for "org.jnativehook" and set the level to warning.
        Logger logger = Logger.getLogger(GlobalScreen.class.getPackage().getName());
        logger.setLevel(Level.WARNING);
        // Disable the parent handlers.
        logger.setUseParentHandlers(false);
        try {
            GlobalScreen.registerNativeHook();
        }
        catch (NativeHookException ex) {
            System.err.println("There was a problem registering the native hook.");
            System.err.println(ex.getMessage());
            System.exit(1);
        }
    }

    static private void mainMenu(){
        GlobalScreen.addNativeKeyListener(new MainMenu());
    }
}
