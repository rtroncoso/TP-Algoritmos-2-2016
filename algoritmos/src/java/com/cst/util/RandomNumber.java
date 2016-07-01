package com.cst.util;

import java.util.Random;

/**
 * Created by rtroncoso on 6/29/16.
 */
public class RandomNumber {

    private static Random randomGenerator;

    public static int get(int min, int max) {
        return (int) (Math.random() * (max - min)) + min;
    }

}
