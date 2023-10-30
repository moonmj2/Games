/**
 * @author Morgan Moon
 * CSE 174
 * Section B
 * The aim of this code is to produce a playable battleship game that the user can play
 */
//import necessary classes
import java.util.Random;
import java.util.Scanner;
public class BattleshipGame
{
    public static void main(String[] args)
    {
        //initialize scanner
        Scanner scan = new Scanner(System.in);

        //prompt for player one's name and store in a variable
        System.out.print("Please enter player one's name: ");
        String player1 = scan.next();

        //prompt for player 2's name and store in variable
        System.out.print("Please enter player two's name: ");
        String player2 = scan.next();

        //declare the unicode variables
        String waterIcon = ("\uD83C\uDF0A");
        String shipIcon = ("\uD83D\uDEA2");
        String fireIcon = ("\uD83D\uDD25");

        //player 1 grid creation
        int gridSize = 6;
        String[][] gridPlayer1 = new String[gridSize][gridSize];
        int i = 0;
        int j = 0;
        for (i = 0; i < gridSize; i++)
        {
            for (j = 0; j < gridSize; ++j)
            {
                gridPlayer1[i][j] = waterIcon;
            }
        }

        //placing the random ships within grid 1
        Random random = new Random();
        int ships = 0;

        for (ships = 0; ships < gridSize; ++ships)
        {
            gridPlayer1[ships][random.nextInt(6)] = shipIcon;
        }


        //begin creation of player 2 grid
        String[][] gridPlayer2 = new String[gridSize][gridSize];
        int k = 0;
        int m = 0;
        for (k = 0; k < gridSize; k++)
        {
            for (m = 0; m < gridSize; m++)
            {
                gridPlayer2[k][m] = waterIcon;
            }
        }

        //placing random ships in grid 2
        for (ships = 0; ships < gridSize; ++ships)
        {
            gridPlayer2[ships][random.nextInt(6)] = shipIcon;
        }

        System.out.println("All the ships have been positioned within the ocean areas.");

        //initialize the variables concerning sunk ships
        int shipsSunk1 = 0;
        int shipsSunk2 = 0;

        //playing the game
        while (shipsSunk1 < 6 && shipsSunk2 < 6)
        {
            //prompting player 1 to enter guess
            System.out.print(player1 + " please enter a guess for the latitude and longitude (eg 0 1) of a ship to fire at in " + player2 + "'s fleet: ");
            //storing this guess as a row and column
            int playerOneRow = scan.nextInt();
            int playerOneColumn = scan.nextInt();

            //if it equals the ship icon, it will replace with the fire icon and increase the counter
            if (gridPlayer2[playerOneRow][playerOneColumn].equals(shipIcon))
            {
                gridPlayer2[playerOneRow][playerOneColumn] = fireIcon;
                shipsSunk1++;
                //let player 1 know they hit a ship
                System.out.println("That's a hit .... a ship at [" + playerOneRow + "," + playerOneColumn + "] in " + player2 + "'s fleet has just been fired!");
                //if they have hit six ships, end the game and display the winning message
                if (shipsSunk1 == 6)
                {
                    System.out.println("WINNER! Congratulations " + player1 + ", you've successfully fired all ships in " + player2 + "'s fleet!");
                    break;
                }
            }
            //if not, let them know they missed and move on to player two's turn
            else
            {
                System.out.println("Sorry, that's a miss .... there was no ship deployed at [" + playerOneRow + " " + playerOneColumn + "]");
            }
            // prompt player two for guess
            System.out.print(player2 + " please enter a guess for the latitude and longitude (eg 0 1) of a ship to fire at in " + player1 + "'s fleet: ");
            //store their guess in a row and column variables
            int playerTwoRow = scan.nextInt();
            int playerTwoColumn = scan.nextInt();

            //if it equals the location of a ship icon
            if (gridPlayer1[playerTwoRow][playerTwoColumn].equals(shipIcon))
            {
                //if a hit, replace with fire icon and increase player 2's sunk ship counter
                gridPlayer1[playerTwoRow][playerTwoColumn] = fireIcon;
                shipsSunk2++;
                //let them know they hit a ship
                System.out.println("That's a hit .... a ship at [" + playerTwoRow + "," + playerTwoColumn + "] in " + player1 + "'s fleet has just been fired!");
                //if six ships have been sunk, let them know they won and break the loop
                if (shipsSunk2 == 6)
                {
                    System.out.println("WINNER! Congratulations " + player2 + ", you've successfully fired all ships in " + player1 + "'s fleet!");
                    break;
                }
            }
            //if not, let them know they missed and keep going
            else
            {
                System.out.println("Sorry, that's a miss .... there was no ship deployed at [" + playerTwoRow + " " + playerTwoColumn + "]");
            }
        }
        //now that game has ended, print out both grids showing where the remaining ships and the hit ships are
        System.out.println(player1 + "'s Fleet \t\t\t\t\t\t\t\t\t " + player2 + "'s Fleet");
        System.out.println("-------------------- \t\t\t --------------------");

        for (i = 0; i < gridSize; i++)
        {
            for (j = 0; j < gridSize; j++)
            {
                System.out.print(gridPlayer1[i][j] + " ");
            }
            System.out.print("\t\t\t");
            for (k = 0; k < gridSize; k++)
            {
                System.out.print(gridPlayer2[i][k] + " ");
            }
            System.out.println();
        }
        //close scanner
        scan.close();
    }
}
