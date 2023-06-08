//*************************************************************************
//2D-Dalmuti-Cards.java
//Author: David Taylor
//Purpose: Develop a Java application where you will create a two-dimensional array to hold cards dealt to the
//players. You will use the one-dimensional array to hold the entire card deck (ease of
//use for shuffling and playing new games) use the two-dimensional array to
//hold each player’s card for a current game being played.
//We will assume the game is played with 4.
//*************************************************************************

import java.util.Scanner;

public class Main {

    //Static method used to shuffle the cards in the array
    public static void shuffleCards(String[] deck) {
        int n = deck.length;
        for (int i = 0; i < n; i++) {
            int r = i + (int) (Math.random() * (n-i));
            String temp = deck[r];
            deck[r] = deck[i];
            deck[i] = temp;
        }
    }

    //Static method used to deal cards to the players
    public static String[][] dealCards(String[] deck) {

        //temporary 4 x 20 array to store dealt cards
        String[][] playersCards = new String[4][20];

        //counter to traverse through deck array
        int cardNum = 0;

        //loop for matrix row traversal
        for (int row = 0; row < 4; row++) {
            //loop for matrix column traversal
            for (int column = 0; column < 20; column++) {
                playersCards[row][column] = deck[cardNum];
                cardNum++;
            }
        }
        //return array
        return playersCards;
    }

    //display cards
    public static void printCards(String[][] playersCards) {

        //display interface
        System.out.printf("%-15s\t\t\t%-15s\t\t\t%-15s\t\t\t%-15s", "Player 1", "Player 2", "Player 3", "Player 4");
        System.out.println("\n==========================================================================================");

        //counter for card number
        int count = 1;

        //loop for matrix row traversal
        for (int a = 0; a < 4; a++) {
            //loop for matrix column traversal
            for (int b = 0; b < 20; b++) {

                System.out.printf("%-15s\t\t\t", playersCards[a][b]);
                //print out newline every 4 cards
                if (count % 4 == 0) {
                    System.out.println();
                }
                count++;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Hello world!\n");

        //stop game when 'quit' = "no"
        String quit = "no";

        //loop while true
        while (!quit.equals("yes")) {

            //create array for deck
            String[] deck = new String[80];
            String[][] playersCards = new String[4][20];

            //assign deck to array
            for (int i = 0; i <= 79; i++) {

                if (i == 0) {
                    deck[i] = "1: Dalmuti";
                } else if (i <= 2) {
                    deck[i] = "2: Archbishop";
                } else if (i <= 5) {
                    deck[i] = "3: Earl Marshal";
                } else if (i <= 9) {
                    deck[i] = "4: Baroness";
                } else if (i <= 14) {
                    deck[i] = "5: Abbess";
                } else if (i <= 20) {
                    deck[i] = "6: Knight";
                } else if (i <= 27) {
                    deck[i] = "7: Seamstress";
                } else if (i <= 35) {
                    deck[i] = "8: Mason";
                } else if (i <= 44) {
                    deck[i] = "9: Cook";
                } else if (i <= 54) {
                    deck[i] = "10: Shepherdess";
                } else if (i <= 65) {
                    deck[i] = "11: Stonecutter";
                } else if (i <= 77) {
                    deck[i] = "12: Peasant";
                } else {
                    deck[i] = "13: Jester";
                }
            }

            //shuffle cards
            shuffleCards(deck);

            //deals cards
            playersCards = dealCards(deck);

            //display cards
            printCards(playersCards);

            //ask user to continue game
            System.out.print("\nquit game?: 'yes' or 'no': ");
            quit = scan.nextLine();
            System.out.println();

        }
        System.out.println("Thanks for playing :)");
    }
}
