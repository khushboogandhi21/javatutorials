package com.leetcode.practice.medium;

import java.util.Scanner;

/**
 * Design a Tic-tac-toe game that is played between two players on a nxn grid.
 * You may assume the following rules:
 * A move is guaranteed to be valid and is placed on an empty block.
 * Once a winning condition is reached, no more moves is allowed.
 * A player who succeeds in placing n of their marks in a horizontal, vertical, or diagonal row wins the game.
 */
public class DesignTicTacToe {

    static int matrixSize = 3; //these should not be declared inside playerMove method
    static int[] row = new int[matrixSize];
    static int[] column =  new int[matrixSize];
    static int diagonal = 0;
    static int adjDiagonal = 0;

    public static void main(String args[]){

        Scanner scanner =new Scanner(System.in);
        int playerNo =0, rowNo =0, columnNo =0;

        while (true){
            System.out.println("Please enter Player no : " );
            playerNo = Integer.parseInt(scanner.next());
            System.out.println("Please input Row no : " );
            rowNo = Integer.parseInt(scanner.next());
            System.out.println("Please input Column no : " );
            columnNo = Integer.parseInt(scanner.next());
            int result = playerMove(playerNo,rowNo,columnNo, matrixSize);
            if(result == 1){
                System.out.println("Player 1 wins " );
                System.exit(0);
            }
            else if(result == 2){
                System.out.println("Player 2 wins " );
                System.exit(0);
            }

        }

    }

    private static int playerMove(int playerNo,int rowNo, int columnNo,int matrixSize) {


        int process = 1;

        if(playerNo == 2)
            process = -1;


        /* if(playerNo == 1){
           row[rowNo]++;
            column[columnNo]++;
            if(rowNo == columnNo){
                diagonal++;
                adjDiagonal++;
            }
            if(rowNo + columnNo == (matrixSize - 1)){
                adjDiagonal++;
            }
        }*/ //NOT required use process variable

        row[rowNo] = row[rowNo] + process;
        if(row[rowNo] == matrixSize || row[rowNo] == -matrixSize )
            return playerNo;

        column[columnNo] = column[columnNo] + process;
        if( column[columnNo] == matrixSize || column[columnNo]  == -matrixSize )
            return playerNo;

        if(rowNo == columnNo){
            diagonal = diagonal + process;
        }
        if(diagonal == matrixSize || diagonal == -matrixSize )
            return playerNo;

        if(rowNo + columnNo == (matrixSize - 1)){
            adjDiagonal = adjDiagonal + process;
        }

        if(diagonal == matrixSize || adjDiagonal == -matrixSize )
            return playerNo;

        return 0;
    }
}
