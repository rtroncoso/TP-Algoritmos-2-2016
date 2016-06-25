package com.cst.view;

import com.cst.util.KeyboardListener;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA by: alejandro
 * Date: 24/06/16
 * Time: 14:20
 */
public class Menu extends KeyboardListener {

    protected String title;
    protected ArrayList<String> options;

    protected void listOptions(){
        System.out.println("#####################");
        System.out.println("    " + title);
        System.out.println("#####################");
        int optNumber = 1;
        for (String option : options) {
            System.out.println(optNumber+". "+option);
            optNumber++;
        }
    }

    protected void clearScreen(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
