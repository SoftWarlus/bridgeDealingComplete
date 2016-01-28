package p1;

/*
 * Basic deck shuffling and dealing exercise
 * CSC 164
 * Uros Vorkapic
 * Jan 26, '16
 * Version 1.0
 */

import java.util.Arrays;

public class Main {

    //Constants
    public static final String[] SUITS = {"Clubs", "Diamonds", "Hearts", "Spades"};
    public static final String[] RANKS = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
    public static final String[] PLAYER = {"North", "East", "South", "West"};

    public static void main(String[] args) {
        int[] deck = new int[52];
        int[][] players = new int[4][13];
        for (int i = 0; i < deck.length; i++)
            deck[i] = i;
        shuffleDeck(deck);
        dealDeck(deck, players);
        sortHands(players);
        showHands(players);
    }

    //Shuffles deck 3 times for best results
    public static void shuffleDeck(int[] deck) {
        for (int numShuffles = 0; numShuffles < 3; numShuffles++) {
            for (int i = 0; i < deck.length; i++) {
                int index = (int) (Math.random() * deck.length);
                int temp = deck[i];
                deck[i] = deck[index];
                deck[index] = temp;
            }
        }
    }

    public static void dealDeck(int[] deck, int[][] players) {
        int index = 0;
        for (int col = 0; col < RANKS.length; col++) {
            for (int row = 0; row < SUITS.length; row++) {
                players[row][col] = deck[index];
                index++;
            }
        }
    }

    public static void showHands(int[][] players) {
        for (int i = 0; i < SUITS.length; i++) {
            System.out.print(PLAYER[i] + "'s hand is: ");
            for (int j = 0; j < RANKS.length; j++) {
                String suit = SUITS[players[i][j] / 13];
                String rank = RANKS[players[i][j] % 13];
                if (j != RANKS.length - 1) {
                    System.out.print(rank + " of " + suit + ", ");
                } else {
                    System.out.print(rank + " of " + suit + ".");
                }
            }
            System.out.print("\n");
        }
    }

    public static void sortHands(int[][]players) {
        int tempArray[] = new int[13];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 13; j++) {
                tempArray[j] = players[i][j];
            }
            Arrays.sort(tempArray);
            for (int j = 0; j < 13; j++) {
                players[i][j] = tempArray[j];
            }
        }
    }
}