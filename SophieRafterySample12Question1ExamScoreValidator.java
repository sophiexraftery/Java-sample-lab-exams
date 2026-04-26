/*
Name: Sophie Raftery
Student ID: g00477839
Date: 5/3/2026
*/
import java.util.Scanner;
import java.util.InputMismatchException;

public class SophieRafterySample12Question1ExamScoreValidator
{
    public static void main(String[] args)
    {
        // Scanner for user input
        Scanner Keyboard = new Scanner(System.in);

        boolean validInput = false;
        int mark;

        // Display header
        System.out.println("===================================================");
        System.out.println("\tEXAM SCORE VALIDATOR");
        System.out.println("===================================================");

        // Loop until valid mark is entered
        while (!validInput)
        {
            try
            {
                // Prompt user for exam mark
                System.out.print("Enter exam mark: ");
                mark = Keyboard.nextInt();

                // Validate range
                if (mark < 0 || mark > 100)
                {
                    throw new InvalidMarkException("Mark must be between 0 and 100.");
                }

                // Determine grade
                String grade;

                if (mark >= 70)
                {
                    grade = "Distinction";
                }
                else if (mark >= 60)
                {
                    grade = "Merit";
                }
                else if (mark >= 50)
                {
                    grade = "Pass";
                }
                else if (mark >= 40)
                {
                    grade = "Compensating Fail";
                }
                else
                {
                    grade = "Fail";
                }

                // Output result
                System.out.println("Mark: " + mark + " | Grade: " + grade);
                System.out.println("Result recorded successfully.");

                validInput = true; // exit loop
            }
            catch (InvalidMarkException e)
            {
                System.out.println("Error: " + e.getMessage());
            }
            catch (InputMismatchException e)
            {
                System.out.println("Error: Please enter a valid whole number.");
                Keyboard.next(); // clear buffer
            }
        }

        System.out.println("==================================================");
        Keyboard.close();
    }
}