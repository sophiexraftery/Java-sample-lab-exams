/*
Name: Sophie Raftery
Student ID: g00477839
Date: 14/12/2025
*/
//import classes
import java.util.Scanner;
import java.io.*;

public class SophieRafterySample4Question1
{
    public static void main(String[] args) throws IOException //handles read/write file errors
	{
             // Scanner object to allow user input
             Scanner keyboard = new Scanner(System.in);

             // Array to store temperatures for 7 days
             double[] temp = new double[7];

             // Array to store day names
             String[] days = {
                 "Monday", "Tuesday", "Wednesday",
                 "Thursday", "Friday", "Saturday", "Sunday"
             };

             // Variables for calculations
             double total = 0.0;
             double highestTemperature;
             double lowestTemperature;
             int highestDayIndex = 0;
             int lowestDayIndex = 0;

             // Display welcome message
             System.out.println("=======================================");
             System.out.println("      WEEKLY TEMPERATURE ANALYZER");
             System.out.println("=======================================");

             // Input temperatures with validation
             for (int i = 0; i < temp.length; i++)
             {
                 // Validate input using a while loop
                 do
                 {
                     System.out.print(
                         "Enter temperature for " + days[i] +
                         " (-50 to 50 degrees Celsius): "
                     );
                     temp[i] = keyboard.nextDouble();
                 }
                 while (temp[i] < -50 || temp[i] > 50); // Validation condition
             }

             // Initialize highest and lowest temperatures using first value
             highestTemperature = temp[0];
             lowestTemperature = temp[0];

             // Calculate total, highest, and lowest temperatures
             for (int i = 0; i < temp.length; i++)
             {
                 total += temp[i];

                 // Check for highest temperature
                 if (temp[i] > highestTemperature)
                 {
                     highestTemperature = temp[i];
                     highestDayIndex = i;
                 }

                 // Check for lowest temperature
                 if (temp[i] < lowestTemperature)
                 {
                     lowestTemperature = temp[i];
                     lowestDayIndex = i;
                 }
             }

             // Calculate average temperature
             double averageTemperature = total / temp.length;

             // Display summary table
             System.out.println("\n=======================================");
             System.out.println("       WEEKLY TEMPERATURE SUMMARY");
             System.out.println("=======================================");
             System.out.printf("%-15s %-15s %-12s%n", "Day", "Temperature", "Status");

             // Display each day with above/below average indicator
             for (int i = 0; i < temp.length; i++)
             {
                 String status;

                 if (temp[i] > averageTemperature)
                 {
                     status = "Above Avg";
                 }
                 else
                 {
                     status = "Below Avg";
                 }

                 System.out.printf(
                     "%-15s %6.1f C        %s%n",
                     days[i], temp[i], status
                 );
             }

             // Display statistics
             System.out.println("\n=======================================");
             System.out.println("              STATISTICS");
             System.out.println("=======================================");
             System.out.printf("Average Temperature: %.1f C%n", averageTemperature);
             System.out.printf(
                 "Highest Temperature: %.1f C (%s)%n",
                 highestTemperature, days[highestDayIndex]
             );
             System.out.printf(
                 "Lowest Temperature:  %.1f C (%s)%n",
                 lowestTemperature, days[lowestDayIndex]
             );

             // Close scanner
             keyboard.close();
         }
     }

