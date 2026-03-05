/*
Name: Sophie Raftery
Student ID: g00477839
Date: 12/11/2025
*/

import java.util.Scanner;
public class SophieRafterySample3Question1
{
 public static void main(String[] args)
    {
        // Create scanner for user input
        Scanner keyboard = new Scanner(System.in);

        // Display welcome message
        System.out.println("========================================");
        System.out.println("     PARKING METER CALCULATOR");
        System.out.println("========================================");
        System.out.println("Welcome to the ATU Car Park System\n");

        int dayOfWeek;
        int hoursParked;
        String hasStudentCard;

        // === Ask for day of the week ===
        System.out.print("What day is it today?\n(1=Mon, 2=Tue, 3=Wed, 4=Thu, 5=Fri, 6=Sat, 7=Sun): ");
        dayOfWeek = keyboard.nextInt();

        // Validate input for day
        while (dayOfWeek < 1 || dayOfWeek > 7)
        {
            System.out.print("Invalid day! Please enter a number between 1 and 7: ");
            dayOfWeek = keyboard.nextInt();
        }

        // === Ask for hours parked ===
        System.out.print("\nHow many hours will you park (1-12)? ");
        hoursParked = keyboard.nextInt();

        // Validate input for hours
        while (hoursParked < 1 || hoursParked > 12)
        {
            System.out.print("Invalid input! Please enter hours between 1 and 12: ");
            hoursParked = keyboard.nextInt();
        }

        // Clear newline from buffer
        keyboard.nextLine();

        // === Ask if user has student discount card ===
        System.out.print("\nDo you have a student discount card? (yes/no): ");
        hasStudentCard = keyboard.nextLine().trim().toLowerCase();

        // Validate yes/no input
        while (!hasStudentCard.equals("yes") && !hasStudentCard.equals("no"))
        {
            System.out.print("Invalid input! Please enter 'yes' or 'no': ");
            hasStudentCard = keyboard.nextLine().trim().toLowerCase();
        }

        // === Determine hourly rate based on day ===
        double hourlyRate = 0.0;
        String dayName = "";

        if (dayOfWeek >= 1 && dayOfWeek <= 5)
        {
            hourlyRate = 2.50;
            switch (dayOfWeek)
            {
                case 1: dayName = "Monday"; break;
                case 2: dayName = "Tuesday"; break;
                case 3: dayName = "Wednesday"; break;
                case 4: dayName = "Thursday"; break;
                case 5: dayName = "Friday"; break;
            }
        }
        else if (dayOfWeek == 6)
        {
            hourlyRate = 3.00;
            dayName = "Saturday";
        }
        else
        {
            hourlyRate = 1.50;
            dayName = "Sunday";
        }

        // === Calculate cost ===
        double totalCost = 0.0;
        double firstFiveHoursCost = 0.0;
        double remainingHoursCost = 0.0;

        if (hoursParked > 5)
        {
            // First 5 hours at normal rate
            firstFiveHoursCost = 5 * hourlyRate;

            // Remaining hours at half price
            double discountedRate = hourlyRate / 2;
            remainingHoursCost = (hoursParked - 5) * discountedRate;

            totalCost = firstFiveHoursCost + remainingHoursCost;
        }
        else
        {
            totalCost = hoursParked * hourlyRate;
            firstFiveHoursCost = totalCost;
        }

        // === Apply student discount if applicable (only weekdays) ===
        double studentDiscount = 0.0;

        if (hasStudentCard.equals("yes") && dayOfWeek >= 1 && dayOfWeek <= 5)
        {
            studentDiscount = totalCost * 0.20; // 20% discount
            totalCost -= studentDiscount;
        }

        // === Display detailed receipt ===
        System.out.println("\n========================================");
        System.out.println("           PARKING RECEIPT");
        System.out.println("========================================");

        System.out.printf("Day: %s%n", dayName);
        System.out.printf("Hourly Rate: %.2f%n", hourlyRate);
        System.out.printf("Hours Parked: %d%n%n", hoursParked);

        System.out.println("Calculation:");

        if (hoursParked > 5)
        {
            System.out.printf("First 5 hours: 5 × %.2f = %.2f%n", hourlyRate, firstFiveHoursCost);
            System.out.printf("Remaining %d hours: %d × %.2f = %.2f%n",
                    hoursParked - 5, hoursParked - 5, hourlyRate / 2, remainingHoursCost);
        }
        else
        {
            System.out.printf("%d × %.2f = %.2f%n", hoursParked, hourlyRate, totalCost);
        }

        double subtotal = firstFiveHoursCost + remainingHoursCost;
        System.out.printf("Subtotal: %.2f%n", subtotal);

        if (studentDiscount > 0)
        {
            System.out.printf("%nStudent Discount (20%%): -%.2f%n", studentDiscount);
        }

        System.out.println("========================================");
        System.out.printf("TOTAL TO PAY: %.2f%n", totalCost);
        System.out.println("========================================");
        System.out.println("\nThank you for using ATU Car Park!");

        // Close scanner
        keyboard.close();
    }
}