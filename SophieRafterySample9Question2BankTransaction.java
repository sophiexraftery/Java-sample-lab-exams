/*
Name: Sophie Raftery
Student ID: g00477839
Date: 5/3/2026
*/

import java.util.Scanner;

public class SophieRafterySample9Question2BankTransaction
{
    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);

        System.out.println("======================");
        System.out.println("BANK ACCOUNT TRANSACTION PROCESSOR");
        System.out.println("======================");

        // --- Read account holder name ---
        System.out.print("Enter account holder name: ");
        String accountHolder = keyboard.nextLine();

        // --- Read starting balance ---
        double startingBalance = 0;
        boolean keepRunning = true;
        while (keepRunning)
        {
            System.out.print("Enter starting balance: ");
            if (keyboard.hasNextDouble())
            {
                startingBalance = keyboard.nextDouble();
                if (startingBalance >= 0)
                {
                    keepRunning = false;
                }
                else
                {
                    System.out.println("Balance must be >= 0.");
                }
            }
            else
            {
                System.out.println("Invalid number. Please try again.");
                keyboard.next(); // consume invalid input
            }
        }

        // --- Create BankAccount object ---
        BankAccount account;
        if (startingBalance == (int) startingBalance)
        {
            account = new BankAccount(accountHolder, (int) startingBalance);
        }
        else
        {
            account = new BankAccount(accountHolder, startingBalance);
        }

        double totalDeposited = 0;
        double totalWithdrawn = 0;
        int failedWithdrawals = 0;

        // --- Number of transactions ---
        int numTransactions = 0;
        keepRunning = true;
        while (keepRunning)
        {
            System.out.print("How many transactions (1-5): ");
            if (keyboard.hasNextInt())
            {
                numTransactions = keyboard.nextInt();
                if (numTransactions >= 1 && numTransactions <= 5)
                {
                    keepRunning = false;
                }
                else
                {
                    System.out.println("Number must be between 1 and 5.");
                }
            }
            else
            {
                System.out.println("Invalid number. Please try again.");
                keyboard.next(); // consume invalid input
            }
        }

        // --- Process transactions ---
        for (int i = 1; i <= numTransactions; i++)
        {
            System.out.println("Transaction " + i);

            // Read transaction type
            char type = ' ';
            keepRunning = true;
            keyboard.nextLine(); // consume leftover newline
            while (keepRunning)
            {
                System.out.print("Enter type (D-deposit, W-withdraw): ");
                String input = keyboard.next();
                input = input.toUpperCase();

                if (input.equals("D") || input.equals("W"))
                {
                    type = input.charAt(0);
                    keepRunning = false;
                }
                else
                {
                    System.out.println("Invalid type. Enter D or W.");
                }
            }

            // Read amount
            double amount = 0;
            keepRunning = true;
            while (keepRunning)
            {
                System.out.print("Enter amount: ");
                if (keyboard.hasNextDouble())
                {
                    amount = keyboard.nextDouble();
                    if (amount > 0)
                    {
                        keepRunning = false;
                    }
                    else
                    {
                        System.out.println("Amount must be > 0.");
                    }
                }
                else
                {
                    System.out.println("Invalid number.");
                    keyboard.next(); // consume invalid input
                }
            }

            // --- Process deposit or withdrawal ---
            boolean success = false;
            if (type == 'D')
            {
                success = account.deposit(amount);
                if (success)
                {
                    totalDeposited += amount;
                }
            }
            else
            {
                success = account.withdraw(amount);
                if (success)
                {
                    totalWithdrawn += amount;
                }
                else
                {
                    failedWithdrawals++;
                }
            }

            System.out.println(account.getLastMessage() + " Balance: " + account.getBalance());
        }

        // --- Summary ---
        System.out.println("-- SUMMARY ---");
        System.out.printf("Starting Balance: %.2f%n", startingBalance);
        System.out.printf("Total Deposited: %.2f%n", totalDeposited);
        System.out.printf("Total Withdrawn: %.2f%n", totalWithdrawn);
        System.out.printf("Failed Withdrawals: %d%n", failedWithdrawals);
        System.out.printf("Final Balance: %.2f%n", account.getBalance());
        System.out.println("=======================");

        keyboard.close();
    }
}