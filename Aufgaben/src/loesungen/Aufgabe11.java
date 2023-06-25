package loesungen;

/*
 *  Copyright (C) 2022 Christian Knorr, Simon Lenz.
 *  All rights reserved.
 */

public class Aufgabe11 {

    /**
     * Print multiple characters into a single line.
     *
     * @param length    The number of characters to be printed
     * @param c         The character symbol to be used
     * @param offset    The number of leading spaces
     */
    public static void printLine(int length, char c, int offset) {
        int i;
        for (i = 0; i < offset; i++) {
            System.out.print(" ");
        }
        for (i = 0; i < length; i++) {
            System.out.print(c);
        }
        System.out.println();
    }


    /**
     * Print a triangle using the provided character symbol.
     *
     * @param height    The height of the triangle in lines
     * @param c         The character symbol to be used
     */
    public static void printTriangle(int height, char c) {
        int offset = height - 1;
        for (int i = 0; i < height; i++) {
            printLine(i * 2 + 1, c, offset - i);
        }
    }


    public static void main(String[] args) throws Exception {
        // *** variable declaration
        int height;
        char c;

        // *** program header ***
        System.out.println("Triangle printing");
        System.out.println("-----------------");

        // *** data input ***
        System.out.print("Enter the number of lines for the triangle: ");
        height = SystemInReader.readInt();
        System.out.print("Enter the character to be used as drawing character: ");
        c = SystemInReader.readChar();

        // *** processing and output ***
        printTriangle(height, c);
    }

}
