package com.programs;

import java.util.Random;
import java.util.Scanner;

public class RockPaperScissorsGame {

    public static final String ROCK = "R";
    public static final String PAPER = "P";
    public static final String SCISSORS = "S";


    static String   getPlayerMove(){
        Scanner in = new Scanner(System.in);
        String input =  in.next().toUpperCase();
        return input;
    }

    static String  getComputerMove(){
        int random = new Random().nextInt(3) + 1; //don't use seed else u will get same random number each time
        if(random == 1)
            return ROCK;
       else if(random == 2)
            return PAPER;
       else
            return SCISSORS;
    }


    public static void main(String args[]){
        System.out.println("Enter your Option:");
        System.out.println("R for Rock");
        System.out.println("P for Paper");
        System.out.println("S for Scissors");

        String playerMove =  getPlayerMove();
        String computerMove = getComputerMove();

        System.out.println("Computer Move is: " + computerMove);

        if(playerMove.equals(computerMove))
            System.out.println("Its a Tie");
        else if(ROCK.equals(playerMove))
            System.out.println(PAPER.equals(computerMove)? "Computer Wins!":"Player Wins!");
        else if(PAPER.equals(playerMove))
            System.out.println(SCISSORS.equals(computerMove)? "Computer Wins!":"Player Wins!");
        else if(SCISSORS.equals(playerMove))
            System.out.println(ROCK.equals(computerMove)? "Computer Wins!":"Player Wins!");
        else
            System.out.println("Invalid Input");


    }
}
