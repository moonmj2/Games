/**
 * @author Morgan Moon
 * CSE 174
 * Section B
 */
//import the Scanner class
import java.util.Scanner;
public class ZodiacSign
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);

        //Prompt user to enter birth month and storing this as variable "month"
        System.out.print("Enter your birth month (1-12): ");
        int month = scan.nextInt();

        //Prompt user to enter birth day and storing this as the variable "day"
        System.out.print("Enter your birth day (1-31): ");
        int day = scan.nextInt();

        //close scanner
        scan.close();

        //create empty string variable
        String zodiacSign ="";

        //Within this switch statement, I will assign the appropriate unicode characters and zodiac sign
        switch (month)
        {
            //For month 1
            case 1:
                if (day <= 19)
                {
                    zodiacSign = "\u2651" + "Capricorn";
                }
                else
                {
                    zodiacSign = "\u2652" + "Aquarius";
                }
                break;

            //For month 2
            case 2:
                if (day <= 18)
                {
                    zodiacSign = "\u2652" + "Aquarius";
                }
                else
                {
                    zodiacSign = "\u2653" + "Pisces";
                }
                break;

            //For month 3
            case 3:
                if (day <= 20)
                {
                    zodiacSign = "\u2653" + "Pisces";
                }
                else
                {
                    zodiacSign = "\u2648" + "Aries";
                }
                break;

            //For month 4
            case 4:
                if (day <= 19)
                {
                    zodiacSign = "\u2648" + "Aries";
                }
                else
                {
                    zodiacSign = "\u2649" + "Taurus";
                }
                break;

            //For month 5
            case 5:
                if (day <= 20)
                {
                    zodiacSign = "\u2649" + "Taurus";
                }
                else
                {
                    zodiacSign = "\u264A" + "Gemini";
                }
                break;

            //For month 6
            case 6:
                if (day <= 20)
                {
                    zodiacSign = "\u264A" + "Gemini";
                }
                else
                {
                    zodiacSign = "\u264B" + "Cancer";
                }
                break;

            //For month 7
            case 7:
                if (day <= 22)
                {
                    zodiacSign = "\u264B" + "Cancer";
                }
                else
                {
                    zodiacSign = "\u264C" + "Leo";
                }
                break;

            //For month 8
            case 8:
                if (day <= 22)
                {
                    zodiacSign = "\u264C" + "Leo";
                }
                else
                {
                    zodiacSign = "\u264D" + "Virgo";
                }
                break;

            //For month 9
            case 9:
                if (day <= 22)
                {
                    zodiacSign = "\u264D" + "Virgo";
                }
                else
                {
                    zodiacSign = "\u264E" + "Libra";
                }
                break;

            //For month 10
            case 10:
                if (day <= 22)
                {
                    zodiacSign = "\u264E" + "Libra";
                }
                else
                {
                    zodiacSign = "\u264F" + "Scorpio";
                }
                break;

            //For month 11
            case 11:
                if (day <= 21)
                {
                    zodiacSign = "\u264F" + "Scorpio";
                }
                else
                {
                    zodiacSign = "\u2650" + "Sagittarius";
                }
                break;

            //For month 12
            case 12:
                if (day <= 21)
                {
                    zodiacSign = "\u2650" + "Sagittarius";
                }
                else
                {
                    zodiacSign = "\u2651" + "Capricorn";
                }
                break;

                //The default statement is here inc ase the user enters an invalid month/day
                default:
                zodiacSign ="The entered information is invalid.";
        }
        //Display the zodiac sign
        System.out.println("Your zodiac sign is: " + zodiacSign);
    }
}
