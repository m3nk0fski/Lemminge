package loesungen;

/*
 *  Copyright (C) 2022 Christian Knorr, Simon Lenz.
 *  All rights reserved.
 */

public class Aufgabe9 {

    public static void main(String[] args) {
        // *** variable declaration (and partial initialization) ***
        int n, sum = 0;
        int[] values;
        double average, stdDeviation;

        // *** program header ***
        System.out.println("Statistics");
        System.out.println("----------");

        // *** data input ***
        System.out.print("Enter the number of samples: ");
        while ((n = SystemInReader.readInt()) < 1) {
            System.out.print("Number of samples cannot be smaller than 1. Please enter again: ");
        }

        values = new int[n];
        for (int i = 0; i < n; i++) {   // fill array with user provided values
            System.out.print("Enter value for " + (i + 1) + ". number: ");
            values[i] = SystemInReader.readInt();
            sum += values[i];           // calculate sum of values immediately during data input
        }

        // *** processing ***
        average = (double) sum / n;     // calculate average, notice the cast to 'double' due to integer division (floating point result expected)

        double tempSum = 0;                // calculate an intermediate sum for the standard deviation
        for (int i = 0; i < n; i++) {
            tempSum += Math.pow(values[i] - average, 2);
        }
        stdDeviation = Math.pow(tempSum / n, 0.5);

        // *** result output ***
        System.out.println();
        System.out.println("You entered the following " + n + "values: ");

        for (int i = 0; i < n; i++) {
            System.out.print("  " + values[i]);
        }
        System.out.println();

        System.out.println("The average is:            " + average);
        System.out.println("The standard deviation is: " + stdDeviation);

        System.out.println();
    }

}
