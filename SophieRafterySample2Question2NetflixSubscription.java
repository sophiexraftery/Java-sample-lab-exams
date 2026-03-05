/*
Name: Sophie Raftery
Student ID: g00477839
Date: 12/11/2025
*/

import java.util.Scanner;
import java.util.Random;
public class SophieRafterySample2Question2NetflixSubscription
{
 public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);
        Random random = new Random();

        // Variables to track a single subscriber
        int subscriberID = 0;
        String subscriberName = "";
        String subscriberEmail = "";
        String planType = "";
        double monthlyFee = 0.0;
        int durationMonths = 0;
        boolean accountActive = false;
        int subscriberCount = 0;

        int choice;

        do
        {
            // Display main menu
            System.out.println("========================================");
            System.out.println("   NETFLIX SUBSCRIPTION MANAGEMENT");
            System.out.println("========================================");
            System.out.println("MAIN MENU:");
            System.out.println("1. Check Subscription Plans");
            System.out.println("2. Create New Account");
            System.out.println("3. Renew Subscription");
            System.out.println("4. View Account Details");
            System.out.println("5. Cancel Subscription");
            System.out.println("6. Exit");
            System.out.print("\nEnter your choice (1-6): ");

            while (!keyboard.hasNextInt())
            {
                System.out.print("Invalid input! Please enter a number between 1 and 6: ");
                keyboard.next();
            }

            choice = keyboard.nextInt();
            keyboard.nextLine(); // consume newline

            while (choice < 1 || choice > 6)
            {
                System.out.print("Invalid choice! Please enter a number between 1 and 6: ");
                choice = keyboard.nextInt();
                keyboard.nextLine();
            }

            switch (choice)
            {
                case 1:
                {
                    // Check Subscription Plans
                    System.out.println("========================================");
                    System.out.println("          SUBSCRIPTION PLANS");
                    System.out.println("========================================");
                    System.out.println("Plan Type       Monthly Fee   Features");
                    System.out.println("----------------------------------------");
                    System.out.printf("Basic           %.2f        SD Quality, 1 Device%n", 9.99);
                    System.out.printf("Standard        %.2f        HD Quality, 2 Devices%n", 15.49);
                    System.out.printf("Premium         %.2f        4K Quality, 4 Devices%n", 19.99);
                    System.out.println("----------------------------------------");
                    System.out.printf("Current Subscribers: %d%n", subscriberCount);
                    System.out.println("\nPress Enter to continue...");
                    keyboard.nextLine();
                    break;
                }

                case 2:
                {
                    // Create New Account
                    System.out.println("========================================");
                    System.out.println("          CREATE NEW ACCOUNT");
                    System.out.println("========================================");

                    System.out.print("Subscriber Name: ");
                    subscriberName = keyboard.nextLine();

                    System.out.print("Email Address: ");
                    subscriberEmail = keyboard.nextLine();

                    // Display plans
                    System.out.println("\nAvailable Plans:");
                    System.out.println("1. Basic - 9.99/month (SD, 1 device)");
                    System.out.println("2. Standard - 15.49/month (HD, 2 devices)");
                    System.out.println("3. Premium - 19.99/month (4K, 4 devices)");

                    int planChoice;
                    System.out.print("\nPlan Type (1-3): ");
                    planChoice = keyboard.nextInt();

                    while (planChoice < 1 || planChoice > 3)
                    {
                        System.out.print("Invalid plan! Enter 1, 2, or 3: ");
                        planChoice = keyboard.nextInt();
                    }

                    switch (planChoice)
                    {
                        case 1:
                            planType = "Basic";
                            monthlyFee = 9.99;
                            break;
                        case 2:
                            planType = "Standard";
                            monthlyFee = 15.49;
                            break;
                        case 3:
                            planType = "Premium";
                            monthlyFee = 19.99;
                            break;
                    }

                    System.out.print("Duration (1-12 months): ");
                    durationMonths = keyboard.nextInt();

                    while (durationMonths < 1 || durationMonths > 12)
                    {
                        System.out.print("Invalid! Enter a duration between 1 and 12: ");
                        durationMonths = keyboard.nextInt();
                    }

                    // Calculate total cost
                    double totalCost = monthlyFee * durationMonths;

                    // Generate ID and update count
                    subscriberID = 3000 + random.nextInt(1000);
                    accountActive = true;
                    subscriberCount++;

                    // Display confirmation
                    System.out.println("\nAccount Created Successfully!");
                    System.out.printf("Subscriber ID: %d%n", subscriberID);
                    System.out.printf("Name: %s%n", subscriberName);
                    System.out.printf("Plan: %s%n", planType);
                    System.out.printf("Duration: %d months%n", durationMonths);
                    System.out.printf("Total Cost: %.2f%n", totalCost);
                    System.out.println("\nPress Enter to continue...");
                    keyboard.nextLine(); // consume leftover newline
                    keyboard.nextLine();
                    break;
                }

                case 3:
                {
                    // Renew Subscription
                    if (!accountActive)
                    {
                        System.out.println("No active account found! Please create one first.");
                        System.out.println("Press Enter to continue...");
                        keyboard.nextLine();
                        break;
                    }

                    System.out.println("========================================");
                    System.out.println("          RENEW SUBSCRIPTION");
                    System.out.println("========================================");

                    System.out.print("Enter Subscriber ID to renew: ");
                    int enteredID = keyboard.nextInt();

                    if (enteredID == subscriberID)
                    {
                        System.out.print("Renewal duration (1-12 months): ");
                        int renewMonths = keyboard.nextInt();

                        while (renewMonths < 1 || renewMonths > 12)
                        {
                            System.out.print("Invalid! Enter between 1 and 12 months: ");
                            renewMonths = keyboard.nextInt();
                        }

                        double renewalCost = monthlyFee * renewMonths;

                        // Apply discount for 6+ months
                        if (renewMonths >= 6)
                        {
                            renewalCost *= 0.85; // 15% discount
                            System.out.println("15% renewal discount applied!");
                        }

                        durationMonths += renewMonths;
                        System.out.printf("Renewal successful!%nNew duration: %d months%nTotal cost: %.2f%n", durationMonths, renewalCost);
                    }
                    else
                    {
                        System.out.println("Subscriber ID not found!");
                    }

                    System.out.println("Press Enter to continue...");
                    keyboard.nextLine();
                    keyboard.nextLine();
                    break;
                }

                case 4:
                {
                    // View Account Details
                    System.out.println("========================================");
                    System.out.println("          VIEW ACCOUNT DETAILS");
                    System.out.println("========================================");

                    if (!accountActive)
                    {
                        System.out.println("No active account found!");
                    }
                    else
                    {
                        System.out.print("Enter Subscriber ID: ");
                        int checkID = keyboard.nextInt();

                        if (checkID == subscriberID)
                        {
                            System.out.printf("Subscriber ID: %d%n", subscriberID);
                            System.out.printf("Name: %s%n", subscriberName);
                            System.out.printf("Email: %s%n", subscriberEmail);
                            System.out.printf("Plan: %s%n", planType);
                            System.out.printf("Remaining Months: %d%n", durationMonths);
                        }
                        else
                        {
                            System.out.println("Subscriber ID not found!");
                        }
                    }

                    System.out.println("\nPress Enter to continue...");
                    keyboard.nextLine();
                    keyboard.nextLine();
                    break;
                }

                case 5:
                {
                    // Cancel Subscription
                    System.out.println("========================================");
                    System.out.println("          CANCEL SUBSCRIPTION");
                    System.out.println("========================================");

                    if (!accountActive)
                    {
                        System.out.println("No active subscription to cancel!");
                    }
                    else
                    {
                        System.out.print("Enter Subscriber ID to cancel: ");
                        int cancelID = keyboard.nextInt();

                        if (cancelID == subscriberID)
                        {
                            double refundAmount = (monthlyFee * durationMonths) * 0.5; // 50% refund policy
                            System.out.printf("Subscription cancelled for %s.%n", subscriberName);
                            System.out.printf("Refund amount: %.2f%n", refundAmount);

                            accountActive = false;
                            subscriberCount--;
                        }
                        else
                        {
                            System.out.println("Subscriber ID not found!");
                        }
                    }

                    System.out.println("\nPress Enter to continue...");
                    keyboard.nextLine();
                    keyboard.nextLine();
                    break;
                }

                case 6:
                {
                    // Exit
                    System.out.println("========================================");
                    System.out.println("Thank you for choosing Netflix!");
                    System.out.println("Happy streaming!");
                    System.out.println("========================================");
                    break;
                }

                default:
                    System.out.println("Invalid choice! Please select between 1 and 6.");
                    break;
            }

        }
        while (choice != 6);

        keyboard.close();
    }
}