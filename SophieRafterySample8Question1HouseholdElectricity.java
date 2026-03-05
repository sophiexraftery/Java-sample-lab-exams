/*
Name: Sophie Raftery
Student ID: g00477839
Date: 5/3/2026
*/
import java.util.Scanner;
public class SophieRafterySample8Question1HouseholdElectricity
{
    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);

		System.out.println("==================================================");
		System.out.println("\tHOUSEHOLD ELECTRICITY USAGE (kWh)");
        System.out.println("==================================================");

        // 4 households x 3 months
        double[][] usage = new double[4][3];

        double overallTotal = 0;
        double highestUsage = 0;
        int highestHousehold = 0;
        int highestMonth = 0;

        // ================= INPUT =================
        for(int row = 0; row < usage.length; row++) // household
        {
            for(int col = 0; col < usage[row].length; col++) // month
            {
                System.out.printf("Enter usage for Household %d, Month %d: ", row + 1, col + 1);
                usage[row][col] = keyboard.nextDouble();

                // validate input
                while(usage[row][col] < 0 || usage[row][col] > 2000)
                {
                    System.out.print("Invalid! Usage must be 0–2000. Re-enter: ");
                    usage[row][col] = keyboard.nextDouble();
                }

                // check for highest usage
                if(usage[row][col] > highestUsage)
                {
                    highestUsage = usage[row][col];
                    highestHousehold = row + 1;
                    highestMonth = col + 1;
                }

                overallTotal += usage[row][col];
            }
        }

        // ================= REPORT =================
        System.out.println("==================================================");
        System.out.println(" \tREPORT ");
		System.out.println("==================================================");

        // Print header row
        System.out.printf("%-12s %-10s %-10s %-10s %-10s%n",
                          "", "Month 1", "Month 2", "Month 3", "Avg");

        // Print data rows
        for(int row = 0; row < usage.length; row++)
        {
            double householdTotal = 0;
            System.out.printf("%-12s", "Household " + (row + 1));

            for(int col = 0; col < usage[row].length; col++)
            {
                System.out.printf("%-10.2f", usage[row][col]);
                householdTotal += usage[row][col];
            }

            double householdAvg = householdTotal / usage[row].length;
            System.out.printf("%-10.2f%n", householdAvg);
        }

        // ================= SUMMARY =================
        double overallAverage = overallTotal / (usage.length * usage[0].length);
        System.out.printf("%nOverall Average: %.2f kWh%n", overallAverage);
        System.out.printf("Highest Usage: %.2f (Household %d, Month %d)%n",
                          highestUsage, highestHousehold, highestMonth);

        System.out.println("==================================================");

        keyboard.close();

	}
}