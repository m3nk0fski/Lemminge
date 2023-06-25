package loesungen;

/*
 *  Copyright (C) 2022 Christian Knorr, Simon Lenz.
 *  All rights reserved.
 */

public class Aufgabe7 {

    public static void main(String[] args) throws Exception {
        // *** variable declaration (and partial initialization) ***
        final int PRICE = 85;
        int sum = 0, change, coinCount;
        int input;

        // *** program header ***
        System.out.println("Beverage Machine");
        System.out.println("----------------");

        // *** money input and balance calculation ***
        while (sum < PRICE) {       // repeat money input until the beverage price has been hit
            System.out.println("Price is: € " + ((float) PRICE / 100));
            System.out.println("Current balance is: € " + ((float) sum / 100));
            System.out.println();
            System.out.println("  1 - € 0,05");
            System.out.println("  2 - € 0,10");
            System.out.println("  3 - € 0,20");
            System.out.println("  4 - € 0,50");
            System.out.println("  5 - € 1,00");
            System.out.println("  6 - € 2,00");
            System.out.println();
            System.out.print("Please insert coin (enter associated number): ");

            // *** ensure we only receive valid data ***
            while ((input = SystemInReader.readInt()) < 1 || input > 6) {
                System.out.print("Invalid input, enter again: ");
            }
            switch (input) {
                case 1: sum += 5;
                        break;
                case 2: sum += 10;
                        break;
                case 3: sum += 20;
                        break;
                case 4: sum += 50;
                        break;
                case 5: sum += 100;
                        break;
                case 6: sum += 200;
                        break;
            }
        }

        // *** calculate change ***
        change = sum - PRICE;
        if (change > 0) {
            System.out.println("Your change: ");

            coinCount = change / 100;
            if (coinCount > 0) {
                System.out.println("  " + coinCount + " x € 1,00");
            }
            change %= 100;

            coinCount = change / 50;
            if (coinCount > 0) {
                System.out.println("  " + coinCount + " x € 0,50");
            }
            change %= 50;

            coinCount = change / 20;
            if (coinCount > 0) {
                System.out.println("  " + coinCount + " x € 0,20");
            }
            change %= 20;

            coinCount = change / 10;
            if (coinCount > 0) {
                System.out.println("  " + coinCount + " x € 0,10");
            }
            change %= 10;

            coinCount = change / 5;
            if (coinCount > 0) {
                System.out.println("  " + coinCount + " x € 0,05");
            }

        } else {
            System.out.println("No change. Take beverage. Cheers.");
        }
    }

}
