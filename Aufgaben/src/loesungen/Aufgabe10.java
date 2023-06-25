package loesungen;

/*
 *  Copyright (C) 2022 Christian Knorr, Simon Lenz.
 *  All rights reserved.
 */

public class Aufgabe10 {

    public static void main(String[] args) {
        // *** initialize board size ***
        int rowMax = 8;
        int colMax = 8;

        // *** create board ***
        char[][] board = new char[rowMax][colMax];

        // *** set pieces ***
        // *** start with pawns ***
        for (int col = 0; col < colMax; col++) {
            board[1][col] = board[rowMax - 2][col] = 'b';
        }
        // *** set rooks ***
        board[0][0] = board[0][colMax - 1] = board[rowMax - 1][0] = board[rowMax - 1][colMax - 1] = 't';
        // *** set knights ***
        board[0][1] = board[0][colMax - 2] = board[rowMax - 1][1] = board[rowMax - 1][colMax - 2] = 's';
        // *** set bishops ***
        board[0][2] = board[0][colMax - 3] = board[rowMax - 1][2] = board[rowMax - 1][colMax - 3] = 'l';
        // *** set queens ***
        board[0][3] = board[rowMax - 1][3] = 'd';
        // *** set kings ***
        board[0][4] = board[rowMax - 1][4] = 'k';

        // *** mark whites by upper-case ***
        for (int row = 0; row < 2; row++) {
            for (int col = 0; col < colMax; col++) {
                board[row][col] = Character.toUpperCase(board[row][col]);
            }
        }

        // *** print board ***
        for (int row = rowMax - 1; row > -1; row--) {
            System.out.println();
            for (int col = 0; col < colMax; col++) {
                System.out.print(' ');
                if (board[row][col] == 0) {
                    System.out.print('_');
                } else {
                    System.out.print(board[row][col]);
                }
            }
        }
        System.out.println();
    }

}
