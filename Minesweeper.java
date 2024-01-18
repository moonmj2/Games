/**
 * @authors Finley Payne and Morgan Moon
 * CSE 174
 * Section B
 * This code demonstrates a simplified version of the game minesweeper.  It allows for user input so the player can control their own movements and the player either wins or loses based on certain conditions.
 */
//import necessary classes
import java.util.Random;
import java.util.Scanner;
public class Minesweeper
{
    // Creating a method that fills the grid with brown squares
    public static void initializeGrid(String[][] grid)
    {
        for (int i = 0; i < grid.length; i++)
        {
            for (int j = 0; j < grid[i].length; j++)
            {
                grid[i][j] = "\uD83D\uDFEB";
            }
        }
    }

    // Creating a method that randomly distributes mines across the grid
    public static void placeMines(String[][] grid, int numMines)
    {
        Random random = new Random();
        int row, col;
        for (int i = 0; i < numMines; i++)
        {
            do
            {
                row = random.nextInt(grid.length);
                col = random.nextInt(grid[row].length);
            }
            while ((row == 0 && col == 0) || (row == 0 && col == 1) || (row == 1 && col == 0) || !grid[row][col].equals("\uD83D\uDFEB"));
            grid[row][col] = (i < numMines / 2) ? "\uD83D\uDCA3": "\uD83D\uDEA8";
        }
    }
    //print grid method
    public static void printGrid(String[][] grid)
    {
        //iterating through and printing the grid
        for (String[] row : grid)
        {
            for (String cell : row)
            {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }
    public static void playerPosition (String[][] grid , int playerX, int playerY)
    {
        for (int i = 0; i < grid.length; i++)
        {
            for (int j = 0; j < grid[i].length; j++)
            {
                if (i == playerX && j == playerY)
                {
                    // Print the player's position
                    System.out.print("\uD83D\uDC64" + " ");
                }
                else if (grid[i][j].equals("\u2705"))
                {
                    System.out.print("\u2705" + " ");
                }
                else
                {
                    // Print a brown square for other positions
                    System.out.print("\uD83D\uDFEB" + " ");
                }
            }
            System.out.println();
        }
    }
    //Creating a method to detect mines in the spaces above, below, and on either side of the player's current position
    public static void detectNearbyMines(String[][] grid, int playerx, int playery)
    {
        int[] dx = {-1, 0, 1, 0}; // Changes in the x-direction (left, no change, right, no change)
        int[] dy = {0, -1, 0, 1}; // Changes in the y-direction (no change, up, no change, down)
        int undetectable = 0;
        int detectable = 0;

        //checking if the player has stepped onto an undetectable mine
        if (grid[playerx][playery].equals("\uD83D\uDEA8"))
        {
            //if so, replace it with fire and display the losing message
            grid[playerx][playery] = "\uD83D\uDD25";
            System.out.println("Game over! You stepped on an undetectable mine.");
            //prints the grid so the player can see the location of the bombs
            printGrid(grid);
            //exits the game
            System.exit(0);
            return;
        }

        //checks the spots above, below, and next to the player's current position
        //declaring variables
        int newX;
        int newY;
        for (int i = 0; i < dx.length; i++)
        {
            newX = playerx + dx[i];
            newY = playery + dy[i];

            if (newX >= 0 && newX < grid.length && newY >= 0 && newY < grid[0].length)
            {
                //if detectable mine is in these spots, replaces it with green checkmark and updates the variable for the print statement
                if (grid[newX][newY].equals("\uD83D\uDCA3"))
                {
                    grid[newX][newY] = "\u2705";
                    detectable++;
                }
                //if undetectable is above, below, or besides, updates the variable for the print statement
                else if (grid[newX][newY].equals("\uD83D\uDEA8"))
                {
                    undetectable++;
                }
            }
        }
        //prints a statement letting the player know how many detectable/undetectable mines are nearby
        System.out.println(detectable + " regular mine(s) were detected and swept nearby, but there's still " + undetectable + " undetectable mine(s) nearby!");
    }

    public static void main(String[] args)
    {
        //initializing scanner
        Scanner scanner = new Scanner(System.in);
        //calling on initializeGrid method
        int gridSize = 10;
        String[][] grid = new String[gridSize][gridSize];
        initializeGrid(grid);
        //calling on placeMines method
        placeMines(grid, 20);
        //initialize variables
        int playerX = 0;
        int playerY = 0;
        int playerPoints = 0;

        //prints welcome statement and gives player directions
        System.out.println("Hello! Welcome to Minesweeper! The goal of this game is to detect all of the mines in the grid while not hitting one.");
        System.out.println("To do this you will use the W (up), A (left), S (down) and D (right) to move along the grid.");
        System.out.print("You will start in spot [0][0]. You can also use the Q key to quit the game. Good luck!");
        //game loop for while the player has not won/lost yet
        //declaring variable move
        char move;
        while (playerPoints < 15)
        {
            //telling the scanner to read the first character entered
            System.out.print("\nW/A/S/D to move, Q to quit:");
            move = scanner.next().toUpperCase().charAt(0);

            //if player enters q, it gives players the quit message, prints the grid, and exits the loop
            if (move == 'Q' || move == 'q')
            {
                System.out.println("Game over! You quit the game :(");
                printGrid(grid);
                break;
            }
            // Update player position based on input
            if ((move == 'W' || move == 'w') && playerX > 0)
            {
                playerX--;
                playerPoints++;
            }
            else if ((move == 'A' || move == 'a') && playerY > 0)
            {
                playerY--;
                playerPoints++;
            }
            else if ((move == 'S' || move == 's') && playerX < grid.length - 1)
            {
                playerX++;
                playerPoints++;
            }
            else if ((move == 'D' || move == 'd') && playerY < grid.length - 1)
            {
                playerY++;
                playerPoints++;
            }
            //if an unknown character is entered or player tries to move outside of grid, give the player an error message
            else
            {
                System.out.print("Incorrect Move, please enter W/A/S/D: ");
                continue; // Continue to the next iteration of the loop
            }
            // calling on detectNearbyMines
            detectNearbyMines(grid, playerX, playerY);
            playerPosition(grid, playerX, playerY);
            //lets player know where they currently are and current point total
            System.out.print("Your current position is: [" + playerX + "] [" + playerY + "] and you currently have " + playerPoints + " point(s)");
            // Check for winning condition
            if (playerPoints == 15)
            {
                //if the condition is met, gives a winning message, prints the grid, and exits the game
                System.out.println("\nCongratulations! You won!  Thank you for playing.");
                printGrid(grid);
                System.exit(0);
                break; // Exit the loop if the player wins
            }
        }
        //closing the scanner
        scanner.close();
    }
}