/*
Name: Sophie Raftery
Student ID: g00477839
Date: 12/11/2025
*/
import java.util.Scanner;
public class SophieRafterySample1Question1
{
    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);
        char repeat; // to control whether to repeat for another student

        do
        {
            System.out.println("======================================");
            System.out.println("GRADE CALCULATOR AND ANALYZER");
            System.out.println("======================================");

            // Ask user how many scores they want to enter
            System.out.print("\nHow many assignment scores do you want to enter (3-10)? ");
            int numScores = keyboard.nextInt();

            // Validate number of scores
            while (numScores < 3 || numScores > 10)
            {
                System.out.print("Invalid number! Please enter a number between 3 and 10: ");
                numScores = keyboard.nextInt();
            }

            double totalScore = 0;
            double highestScore = Double.MIN_VALUE;
            double lowestScore = Double.MAX_VALUE;

            // Loop to enter each assignment score
            for (int i = 1; i <= numScores; i++)
            {
                System.out.print("Enter score #" + i + " (0-100): ");
                double currentScore = keyboard.nextDouble();

                // Validate score
                while (currentScore < 0 || currentScore > 100)
                {
                    System.out.print("Invalid! Enter a score between 0 and 100: ");
                    currentScore = keyboard.nextDouble();
                }

                // Display individual score
                System.out.printf("Score recorded: %.2f%n", currentScore);

                // Update total, highest, and lowest
                totalScore += currentScore;

                if (currentScore > highestScore)
                {
                    highestScore = currentScore;
                }
                if (currentScore < lowestScore)
                {
                    lowestScore = currentScore;
                }
            }

            // Calculate average
            double averageScore = totalScore / numScores;

            // Determine letter grade (based on exam instructions)
            char letterGrade;
            if (averageScore >= 70)
            {
                letterGrade = 'A';
            }
            else if (averageScore >= 60)
            {
                letterGrade = 'B';
            }
            else if (averageScore >= 50)
            {
                letterGrade = 'C';
            }
            else if (averageScore >= 40)
            {
                letterGrade = 'D';
            }
            else
            {
                letterGrade = 'F';
            }

            // Display summary
            System.out.println("\n======================================");
            System.out.println("\tGRADE SUMMARY");
            System.out.println("======================================");
            System.out.printf("Total Score:   %.2f%n", totalScore);
            System.out.printf("Average Score: %.2f%n", averageScore);
            System.out.printf("Highest Score: %.2f%n", highestScore);
            System.out.printf("Lowest Score:  %.2f%n", lowestScore);
            System.out.printf("Letter Grade:  %c%n", letterGrade);
            System.out.println("======================================");

            // Ask to repeat
            System.out.print("\nWould you like to calculate grades for another student? (Y/N): ");
            repeat = keyboard.next().charAt(0);

        }
        while (Character.toUpperCase(repeat) == 'Y'); // repeat if user enters Y/y

        System.out.println("\nThank you for using the Grade Calculator!");
        keyboard.close();
    }
}
