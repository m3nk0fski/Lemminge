package loesungen;

/*
 *  Copyright (C) 2022 Christian Knorr, Simon Lenz.
 *  All rights reserved.
 */

public class Aufgabe8 {

    public static void main(String[] args) throws Exception {
        // *** variable declaration (and partial initialization) ***
        int input, n, i, temp;

        // *** program header ***
        System.out.println("Roman figures");
        System.out.println("-------------");

        // *** data input ***
        System.out.print("Enter a number to be converted into a roman numeral: ");
        // *** ensure we only receive valid data ***
        while ((input = SystemInReader.readInt()) < 1) {
            System.out.print("Invalid input, enter again: ");
        }

        // *** calculation and output ***
        System.out.print("The roman numeral for '" + input + "' is: ");

        n = input / 1000;
        for (i = 0; i < n; i++) System.out.print("M");
        temp = input % 1000;

        if (temp >= 900) {
            System.out.print("CM");
            temp -= 900;
        }

        if (temp >= 500) {
            System.out.print("D");
            temp -= 500;
        }

        if (temp >= 400) {
            System.out.print("CD");
            temp -= 400;
        }

        n = temp / 100;
        for (i = 0; i < n; i++) System.out.print("C");
        temp = input % 100;

        if (temp >= 90) {
            System.out.print("XC");
            temp -= 90;
        }

        if (temp >= 50) {
            System.out.print("L");
            temp -= 50;
        }

        if (temp >= 40) {
            System.out.print("XL");
            temp -= 40;
        }

        n = temp / 10;
        for (i = 0; i < n; i++) System.out.print("X");
        temp = input % 10;

        if (temp >= 9) {
            System.out.print("IX");
            temp -= 9;
        }

        if (temp >= 5) {
            System.out.print("V");
            temp -= 5;
        }

        if (temp >= 4) {
            System.out.print("IV");
            temp -= 4;
        }

        for (i = 0; i < temp; i++) System.out.print("I");

        System.out.println();
    }

}
