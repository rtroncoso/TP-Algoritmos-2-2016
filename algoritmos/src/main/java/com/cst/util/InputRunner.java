package com.cst.util;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA by: alejandro
 * Date: 30/06/16
 * Time: 17:25
 */
class InputRunner implements Runnable {
    private ArrayList<InputListener> listeners = new ArrayList<InputListener>();
    private Scanner scanner;
    private boolean stop;

    public InputRunner(){
        stop = false;
        scanner = new Scanner(System.in);
        scanner.useDelimiter("\\n");
    }

    public void run() {
        while (!stop){
            fireInputReceived(scanner.nextLine());
        }
        scanner.close();
    }

    public void stop(){
        stop = true;
    }

    public void addListener(InputListener listener) {
        listeners.add(listener);
    }

    public void fireInputReceived(String input) {
        for (InputListener listener : listeners) {
            listener.inputReceived(input);
        }
    }
}
