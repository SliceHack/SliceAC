package com.sliceclient.anticheat.utils;

public class MathUtil {

    public static double roundTo(double n, double r) {
        return Math.round(n * Math.pow(10, r)) / Math.pow(10, r);
    }

}
