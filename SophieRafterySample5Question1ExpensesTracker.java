import java.util.Scanner;

public class SophieRafterySample5Question1
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        // Display welcome message
        System.out.println("========================================");
        System.out.println("      WEEKLY EXPENSES TRACKER");
        System.out.println("========================================");
        System.out.println();

        // Array of days
        String[] days =
        {
            "Monday", "Tuesday", "Wednesday",
            "Thursday", "Friday", "Saturday", "Sunday"
        };

        // Array to store expenses
        double[] expenses = new double[7];

        // Input expenses with validation
        for (int i = 0; i < days.length; i++)
        {
            System.out.print("Enter expense for " + days[i] + " (€): ");
            double value = input.nextDouble();

            while (value < 0)
            {
                System.out.print("Expense cannot be negative. Re-enter for "
                        + days[i] + " (€): ");
                value = input.nextDouble();
            }

            expenses[i] = value;
        }

        // Calculate statistics
        double total = 0;
        double highest = expenses[0];
        double lowest = expenses[0];
        int highestDayIndex = 0;
        int lowestDayIndex = 0;

        for (int i = 0; i < expenses.length; i++)
        {
            total += expenses[i];

            if (expenses[i] > highest)
            {
                highest = expenses[i];
                highestDayIndex = i;
            }

            if (expenses[i] < lowest)
            {
                lowest = expenses[i];
                lowestDayIndex = i;
            }
        }

        double average = total / expenses.length;

        // Display summary table
        System.out.println();
        System.out.println("========================================");
        System.out.println("      WEEKLY EXPENSE SUMMARY");
        System.out.println("========================================");
        System.out.printf("%-15s %-12s %-10s%n", "Day", "Expense", "Status");

        for (int i = 0; i < expenses.length; i++)
        {
            String status;

            if (expenses[i] > average)
            {
                status = "Above Avg";
            }
            else
            {
                status = "Below Avg";
            }

            System.out.printf(
                "%-15s €%-11.2f %-10s%n",
                days[i], expenses[i], status
            );
        }

        // Display statistics
        System.out.println();
        System.out.println("========================================");
        System.out.println("          STATISTICS");
        System.out.println("========================================");
        System.out.printf("Total Weekly Expenses: €%.2f%n", total);
        System.out.printf("Average Daily Expense: €%.2f%n", average);
        System.out.printf(
            "Highest Expense: €%.2f (%s)%n",
            highest, days[highestDayIndex]
        );
        System.out.printf(
            "Lowest Expense: €%.2f (%s)%n",
            lowest, days[lowestDayIndex]
        );
        System.out.println("========================================");

        input.close();
    }
}
