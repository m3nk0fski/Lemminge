package loesungen;

/*
 *  Copyright (C) 2022 Christian Knorr, Simon Lenz.
 *  All rights reserved.
 */

public class Aufgabe12 {

    public static int fibo(int i) {
        if (i <= 1) {
            return 1;
        } else {
            return fibo(i - 2) + fibo(i - 1);
        }
    }


    public static void main(String[] args) throws Exception {
        // *** variable declaration
        int i;

        // *** program header ***
        System.out.println("Fibonacci numbers");
        System.out.println("-----------------");

        // *** data input ***
        System.out.print("Enter the starting number: ");
        i = SystemInReader.readInt();

        // *** processing and output ***
        System.out.println("Fibonacci number of " + i + ": " + fibo(i));
    }

}
