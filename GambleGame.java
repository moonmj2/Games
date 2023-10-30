/**
 * @author Morgan Moon
 * CSE 174
 * Section B
 * This code will mimick a gambling game.  The player will have a certain amount of money and must place bets to reach a target value
 */
//import Scanner
    import java.util.Scanner;
    import java.util.Random;

public class GambleGame
{
    public static void main(String[] args)
    {
        //prompt user for how much money they want to "gamble" with
        System.out.print("How much money would you like to start gambling with: ");
        //initialize scanner
        Scanner scan = new Scanner(System.in);
        //assign variable
        double stake = scan.nextDouble();

        //prompt user for goal
        System.out.print("How much money do you aim to win? ");
        //assign variable
        double goal = scan.nextDouble();

        //initialize cash with stake
        double cash = stake;

        //set counter to zero to keep track of bets made
        int counter = 0;

        //make loop
        while(cash > 0 && cash < goal)
        {
            //generate random number using random class
            Random rand = new Random();
            double randomNumber = Math.random();

            if(randomNumber > 0.5)
            {
                cash++;
            }
            else
            {
                cash--;
            }
            //increase counter variable to keep track of bets
            counter++;
        }
        //check if cash equals the goal or equals 0
        if(cash == goal)
        {
            System.out.print("Congratulations, you won " + goal + " after " + counter + " bet(s)");
        }
        else if(cash == 0)
        {
            System.out.print("Sorry, you lost all your money after " + counter + " bet(s). STOP GAMBLING!");
        }
        //close scanner
        scan.close();
    }
}