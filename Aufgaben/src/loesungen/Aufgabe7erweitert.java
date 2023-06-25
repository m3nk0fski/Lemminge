package loesungen;

/*
 *  Copyright (C) 2022 Christian Knorr, Simon Lenz.
 *  All rights reserved.
 */

public class Aufgabe7erweitert {

    public static void main(String[] args) throws Exception {
        // *** variable declaration (and partial initialization) ***
        final int PRICE = 85;
        int c5 = 10, c10 = 5, c20 = 5, c50 = 10, c100 = 5;    // variables to count the number of coins the
                                                                        // machine currently has in stock for each value
        int sum, change, coinCount;
        int input;
        boolean cancelled;

        while (true) {
            sum = 0;
            cancelled = false;

            // *** program header ***
            System.out.println("Beverage Machine");
            System.out.println("----------------");

            if (c5 < 1 || c10 < 1 || c20 < 2 || c50 < 1) {
                System.out.println("CAUTION: no change possible!");
            }

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
                System.out.println("  7 - Cancel");
                System.out.println();
                System.out.print("Please insert coin (enter associated number): ");

                // *** ensure we only receive valid data ***
                while ((input = SystemInReader.readInt()) < 1 || input > 7) {
                    System.out.print("Invalid input, enter again: ");
                }
                switch (input) {
                    case 1:
                        sum += 5;
                        c5++;
                        break;
                    case 2:
                        sum += 10;
                        c10++;
                        break;
                    case 3:
                        sum += 20;
                        c20++;
                        break;
                    case 4:
                        sum += 50;
                        c50++;
                        break;
                    case 5:
                        sum += 100;
                        c100++;
                        break;
                    case 6:
                        sum += 200;
					break;
                    case 7:
                        cancelled = true;
                        break;
                }

                if (cancelled) {
                    break;          // the user pressed 'cancel' leave money input loop
                }
            }

            // *** calculate change ***
            if (cancelled) {
                change = sum;
            } else {
                change = sum - PRICE;
            }

            if (change > 0) {
                System.out.println("Your change: ");

                if (c100 > 0) {
                    coinCount = change / 100;
                    if (c100 < coinCount) {     // check if we have enough coins of value '100'
                        System.out.println("  " + c100 + " x € 1,00");
                        change -= c100 * 100;   // don't have enough, reduce change-sum according to maximum number of coins
                        c100 = 0;
                    } else {
                        if (coinCount > 0) {
                            System.out.println("  " + coinCount + " x € 1,00");
                        }
                        change %= 100;          // have enough, take modulo result for change
                        c100 -= coinCount;
                    }
                }

                if (c50 > 0) {
                    coinCount = change / 50;
                    if (c50 < coinCount) {     // check if we have enough coins of value '50'
                        System.out.println("  " + c50 + " x € 0,50");
                        change -= c50 * 50;
                        c50 = 0;
                    } else {
                        if (coinCount > 0) {
                            System.out.println("  " + coinCount + " x € 0,50");
                        }
                        change %= 50;
                        c50 -= coinCount;
                    }
                }

                if (c20 > 0) {
                    coinCount = change / 20;
                    if (c20 < coinCount) {     // check if we have enough coins of value '20'
                        System.out.println("  " + c20 + " x € 0,20");
                        change -= c20 * 20;
                        c20 = 0;
                    } else {
                        if (coinCount > 0) {
                            System.out.println("  " + coinCount + " x € 0,20");
                        }
                        change %= 20;
                        c20 -= coinCount;
                    }
                }

                if (c10 > 0) {
                    coinCount = change / 10;
                    if (c10 < coinCount) {     // check if we have enough coins of value '10'
                        System.out.println("  " + c10 + " x € 0,10");
                        change -= c10 * 10;
                        c10 = 0;
                    } else {
                        if (coinCount > 0) {
                            System.out.println("  " + coinCount + " x € 0,10");
                        }
                        change %= 10;
                        c10 -= coinCount;
                    }
                }

                if (c5 > 0) {
                    coinCount = change / 5;
                    if (c5 < coinCount) {     // check if we have enough coins of value '5'
                        System.out.println("  " + coinCount + " x € 0,05");
                        change -= c5 * 5;
                        c5 = 0;
                    } else {
                        if (coinCount > 0) {
                            System.out.println("  " + coinCount + " x € 0,05");
                        }
                        c5 -= coinCount;
                    }
                }

            } else {
                System.out.print("No change. ");
            }

            System.out.println(!cancelled ? "Take beverage. Cheers." : "");
            System.out.println();
        }
    }

}
