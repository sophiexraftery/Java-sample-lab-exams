/*
Name: Sophie Raftery
Student ID: g00477839
Date: 12/11/2025
*/

import java.util.Scanner;
public class SophieRafterySample3Question2
{
    public static void main(String[] args)
    {
        // Create scanner for user input
        Scanner keyboard = new Scanner(System.in);

        // ========================================
        // 1. MEMBER REGISTRATION
        // ========================================
        System.out.println("========================================");
        System.out.println("         FITNOW GYM MEMBERSHIP");
        System.out.println("========================================");
        System.out.println("Welcome to FitNow Gym!\n");

        int age;
        String isStudent;
        int membershipMonths;

        // Ask for age
        System.out.print("Enter your age: ");
        age = keyboard.nextInt();

        // Validate minimum age
        while (age < 16)
        {
            System.out.print("You must be at least 16 to register. Enter your age again: ");
            age = keyboard.nextInt();
        }

        // Clear buffer
        keyboard.nextLine();

        // Ask if student
        System.out.print("Are you a student? (yes/no): ");
        isStudent = keyboard.nextLine().trim().toLowerCase();

        // Validate yes/no
        while (!isStudent.equals("yes") && !isStudent.equals("no"))
        {
            System.out.print("Invalid input! Please enter 'yes' or 'no': ");
            isStudent = keyboard.nextLine().trim().toLowerCase();
        }

        // Ask for membership duration
        System.out.print("How many months? (1/3/6/12): ");
        membershipMonths = keyboard.nextInt();

        // Validate duration
        while (membershipMonths != 1 && membershipMonths != 3 &&
               membershipMonths != 6 && membershipMonths != 12)
        {
            System.out.print("Invalid input! Please enter 1, 3, 6, or 12: ");
            membershipMonths = keyboard.nextInt();
        }

        // ========================================
        // 2. MEMBERSHIP PACKAGE SELECTION
        // ========================================
        System.out.println("\nSelect your package:");
        System.out.println("1. Basic (€30/month) - Gym access");
        System.out.println("2. Standard (€50/month) - Gym + Classes");
        System.out.println("3. Premium (€75/month) - Gym + Classes + Pool");

        int packageChoice;
        double monthlyRate = 0.0;
        String packageName = "";

        System.out.print("Your choice (1/2/3): ");
        packageChoice = keyboard.nextInt();

        // Validate package selection
        while (packageChoice < 1 || packageChoice > 3)
        {
            System.out.print("Invalid input! Enter 1, 2, or 3: ");
            packageChoice = keyboard.nextInt();
        }

        // Assign rates and names
        if (packageChoice == 1)
        {
            packageName = "Basic";
            monthlyRate = 30.00;
        }
        else if (packageChoice == 2)
        {
            packageName = "Standard";
            monthlyRate = 50.00;
        }
        else
        {
            packageName = "Premium";
            monthlyRate = 75.00;
        }

        // Calculate base cost
        double baseMembershipCost = monthlyRate * membershipMonths;

        // Apply multi-month discount
        double monthDiscountRate = 0.0;

        if (membershipMonths == 3)
        {
            monthDiscountRate = 0.05;
        }
        else if (membershipMonths == 6)
        {
            monthDiscountRate = 0.10;
        }
        else if (membershipMonths == 12)
        {
            monthDiscountRate = 0.20;
        }

        double membershipDiscountAmount = baseMembershipCost * monthDiscountRate;
        double membershipSubtotal = baseMembershipCost - membershipDiscountAmount;

        // ========================================
        // 3. PERSONAL TRAINING SESSIONS
        // ========================================
        keyboard.nextLine(); // clear buffer
        System.out.print("\nDo you want personal training? (yes/no): ");
        String wantsTraining = keyboard.nextLine().trim().toLowerCase();

        // Validate yes/no
        while (!wantsTraining.equals("yes") && !wantsTraining.equals("no"))
        {
            System.out.print("Invalid input! Enter 'yes' or 'no': ");
            wantsTraining = keyboard.nextLine().trim().toLowerCase();
        }

        double trainingTotalCost = 0.0;
        int sessionsPerMonth = 0;
        double sessionRate = 0.0;

        if (wantsTraining.equals("yes"))
        {
            System.out.print("How many sessions per month? (1-8): ");
            sessionsPerMonth = keyboard.nextInt();

            // Validate sessions
            while (sessionsPerMonth < 1 || sessionsPerMonth > 8)
            {
                System.out.print("Invalid input! Enter between 1 and 8: ");
                sessionsPerMonth = keyboard.nextInt();
            }

            // Determine rate per session
            if (sessionsPerMonth >= 4)
            {
                sessionRate = 35.00;
            }
            else
            {
                sessionRate = 40.00;
            }

            trainingTotalCost = sessionsPerMonth * membershipMonths * sessionRate;
        }

        // ========================================
        // 4. FITNESS GOAL TRACKER
        // ========================================
        System.out.println("\nFITNESS GOAL TRACKER:");

        double currentWeight;
        double targetWeight;

        System.out.print("Current weight (kg): ");
        currentWeight = keyboard.nextDouble();
        while (currentWeight <= 0)
        {
            System.out.print("Invalid weight! Enter a positive number: ");
            currentWeight = keyboard.nextDouble();
        }

        System.out.print("Target weight (kg): ");
        targetWeight = keyboard.nextDouble();
        while (targetWeight <= 0)
        {
            System.out.print("Invalid weight! Enter a positive number: ");
            targetWeight = keyboard.nextDouble();
        }

        double weightDifference = currentWeight - targetWeight;
        int weeklyVisits;

        if (weightDifference > 10)
        {
            weeklyVisits = 5;
        }
        else if (weightDifference >= 5)
        {
            weeklyVisits = 4;
        }
        else
        {
            weeklyVisits = 3;
        }

        // Approx. 4 weeks per month
        int totalRecommendedVisits = weeklyVisits * membershipMonths * 4;

        // ========================================
        // 5. FINAL INVOICE
        // ========================================
        double subtotal = membershipSubtotal + trainingTotalCost;
        double studentDiscountAmount = 0.0;

        if (isStudent.equals("yes"))
        {
            studentDiscountAmount = subtotal * 0.15;
            subtotal -= studentDiscountAmount;
        }

        double registrationFee = 25.00;
        double grandTotal = subtotal + registrationFee;

        // ========================================
        // PRINT INVOICE
        // ========================================
        System.out.println("\n========================================");
        System.out.println("               INVOICE");
        System.out.println("========================================");

        System.out.printf("Package: %s (%d months)%n", packageName, membershipMonths);
        System.out.printf("Base Cost: €%.2f%n", baseMembershipCost);
        if (monthDiscountRate > 0)
        {
            System.out.printf("Multi-month Discount (%.0f%%): -€%.2f%n",
                    monthDiscountRate * 100, membershipDiscountAmount);
        }
        System.out.printf("Membership Subtotal: €%.2f%n%n", membershipSubtotal);

        if (wantsTraining.equals("yes"))
        {
            System.out.printf("Personal Training:%n%d sessions × %d months × €%.2f = €%.2f%n%n",
                    sessionsPerMonth, membershipMonths, sessionRate, trainingTotalCost);
        }

        System.out.printf("Subtotal: €%.2f%n", membershipSubtotal + trainingTotalCost);

        if (isStudent.equals("yes"))
        {
            System.out.printf("Student Discount (15%%): -€%.2f%n", studentDiscountAmount);
        }

        System.out.printf("Registration Fee: €%.2f%n", registrationFee);
        System.out.println("========================================");
        System.out.printf("GRAND TOTAL: €%.2f%n", grandTotal);
        System.out.println("========================================\n");

        // Fitness summary
        System.out.println("FITNESS SUMMARY:");
        if (weightDifference >= 0)
        {
            System.out.printf("Weight Goal: Lose %.1f kg%n", weightDifference);
        }
        else
        {
            System.out.printf("Weight Goal: Gain %.1f kg%n", Math.abs(weightDifference));
        }

        System.out.printf("Recommended: %d visits per week%n", weeklyVisits);
        System.out.printf("Total Visits (%d months): %d visits%n", membershipMonths, totalRecommendedVisits);

        System.out.println("\nThank you for joining FitNow Gym!");

        // Close scanner
        keyboard.close();
    }
}