/**
 * @author Morgan Moon
 * CSE 174
 * Section B
 * This code will create a deck of cards using arrays and will shuffle the deck.  It will then play a game where it selects winning cards and tracks the users selection.  It will measure how many selections the user makes before getting all the winning cards.
 */

//import scanners
import java.util.Scanner;
import java.util.Random;

public class CardGame
{
        public static void main(String[] args)
        {
            //declare the constant variable, or the size of the deck
            final int deckSize = 52;

            //create arrays for suits and numbers, then create an array to hold the card combinations
            String[] suits = {"\u2663", "\u2666", "\u2665", "\u2660"};
            String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
            String[] deck = new String[suits.length * ranks.length];

            //generate deck of cards: Assigns the unicode character to each value in the ranks array, gives each selection an index value
            int index = 0;
            for (int i = 0; i < suits.length; i++)
            {
                for (int j = 0; j < ranks.length; j++)
                {
                    //calculating index value
                    index = ranks.length * i + j;
                    deck[index] = ranks[j] + suits[i];
                }
            }

            //Prints the precursor statement for the deck
            System.out.println("The original deck is arranged as below: ");
            for (int i = 0; i <= deckSize - 1; i++)
            {
                //prints the original deck
                System.out.print(deck[i] + " ");
            }

            //shuffles the deck
            Random rand = new Random();
            for (int i = 51; i >= 0; i--)
            {
                int r = rand.nextInt(51);
                //Here I am swapping the original deck with the shuffled deck
                String j = deck[i];
                deck[i] = deck[r];
                deck[r] = j;
            }

            //Printing the shuffled deck
            System.out.println("\n" + "The shuffled deck is arranged as below: ");
            for (int r = 0; r <= 51; r++)
            {
                System.out.print(deck[r] + " ");
            }

            //initialize scanner object called keyboard
            Scanner keyboard = new Scanner(System.in);
            //prompt user to enter number of cards
            System.out.print("\n" + "Enter the number of winning cards: ");
            //store user input
            int cardNum = keyboard.nextInt();

            //initialize arrays called winningCards and isDrawn
            String[] winningCards = new String[cardNum];
            boolean[] isDrawn = new boolean[deck.length];

            //counter of zero (line below)
            int counter = 0;
            //this is done until the counter reaches cardNum
            while (counter < cardNum)
            {
                //generates random index
                int randNum = rand.nextInt(deck.length - 1);

                //when the index is false the card is stored and adds to the winningCards counter, which increases each time a card is drawn
                if (isDrawn[randNum] == false)
                {
                    winningCards[counter] = deck[randNum];
                    isDrawn[randNum] = true;
                    counter++;
                }
            }

            //prints the statement and displays the winning cards
            System.out.print("The winning cards are arranged as below: " + "\n");
            for (String winningCard : winningCards)
            {
                System.out.print(winningCard + " ");
            }

            //creating a new array to track the found cards
            boolean[] isFound = new boolean[deck.length];

            //initializing collectedCards and distinctCards
            int collectedCards = 0;
            int distinctCards = 0;

            //generates random index and iterates through each card, then evaluates if the winning card has the same index
            while (distinctCards < cardNum)
            {
                int randNum = rand.nextInt(deck.length);
                if (isFound[randNum] == false)
                {
                    for (String winningCard : winningCards)
                    {
                        //comparing the strings to see if they match
                        if (winningCard.equals(deck[randNum]))
                        {
                            //if the cards match, then distinct cards increases and the card is tracked as found
                            distinctCards++;
                            isFound[randNum] = true;
                            break;
                        }
                        //the number of collected cards also increases
                        collectedCards++;
                    }
                }
            }
            //Prints the result statement and how many cards were drawn before you got the set of winning cards
            System.out.println("\n" + "Number of drawn cards to win the set of winning cards = " + collectedCards);

            //close the scanner
            keyboard.close();
        }
}