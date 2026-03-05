/*
Name: Sophie Raftery
Student ID: g00477839
Date: 14/12/2025
*/
//import classes
import java.util.Scanner;
import java.io.*;

public class SophieRafterySample4Question2
{
    public static void main(String[] args) throws IOException //handles read/write file errors
    {
        Scanner keyboard = new Scanner(System.in); //allows user input

        int choice;

        System.out.println("=======================================");
        System.out.println("   BOOK LIBRARY CATALOG MANAGER");
        System.out.println("=======================================");

        do
        {
			//Main Menu
            System.out.println("\n1. Display All Books");
            System.out.println("2. Add New Book");
            System.out.println("3. Search Book by Title");
            System.out.println("4. Count Books by Year Range");
            System.out.println("5. Calculate Total Catalog Value");
            System.out.println("6. Exit");
            System.out.print("Enter choice (1-6): ");

            choice = keyboard.nextInt();
            keyboard.nextLine();

            while (choice < 1 || choice > 6)
            {
                System.out.print("Invalid choice. Enter 1-6: ");
                choice = keyboard.nextInt();
                keyboard.nextLine();
            }

            switch (choice)
            {
                // -----------------------------------------
                case 1:
                {
                    // DISPLAY ALL BOOKS
                    File file = new File("library.txt");
                    Scanner fileScanner = new Scanner(file);

                    int count = 0;

                    System.out.printf("%-5s %-25s %-25s %-6s %-8s%n",
                            "No.", "Title", "Author", "Year", "Price");

                    while (fileScanner.hasNext())
                    {
                        String title = fileScanner.next();
                        String author = fileScanner.next();
                        int year = fileScanner.nextInt();
                        double price = fileScanner.nextDouble();

                        count++;

                        System.out.printf("%-5d %-25s %-25s %-6d €%.2f%n",
                                count, title, author, year, price);
                    }

                    System.out.println("\nTotal books: " + count);
                    fileScanner.close();
                    break;
                }

                // -----------------------------------------
                case 2:
                {
                    // ADD NEW BOOK
                    System.out.print("Enter title (use _ instead of spaces): ");
                    String title = keyboard.next();

                    System.out.print("Enter author (use _ instead of spaces): ");
                    String author = keyboard.next();

                    int year;
                    do
                    {
                        System.out.print("Enter year (1000-2025): ");
                        year = keyboard.nextInt();
                    }
                    while (year < 1000 || year > 2025);

                    double price;
                    do
                    {
                        System.out.print("Enter price: ");
                        price = keyboard.nextDouble();
                    }
                    while (price <= 0);

                    FileWriter fw = new FileWriter("library.txt", true);
                    fw.write(title + " " + author + " " + year + " " + price + "\n");
                    fw.close();

                    System.out.println("Book added successfully.");
                    break;
                }

                // -----------------------------------------
                case 3:
                {
                    // SEARCH BOOK BY TITLE
                    System.out.print("Enter title to search: ");
                    String searchTitle = keyboard.next().toLowerCase();

                    File file = new File("library.txt");
                    Scanner fileScanner = new Scanner(file);

                    boolean found = false;

                    while (fileScanner.hasNext())
                    {
                        String title = fileScanner.next();
                        String author = fileScanner.next();
                        int year = fileScanner.nextInt();
                        double price = fileScanner.nextDouble();

                        if (title.toLowerCase().equals(searchTitle))
                        {
                            System.out.println("\nBook Found:");
                            System.out.printf("Title: %s%nAuthor: %s%nYear: %d%nPrice: €%.2f%n",
                                    title, author, year, price);
                            found = true;
                            break;
                        }
                    }

                    if (!found)
                    {
                        System.out.println("Book not found.");
                    }

                    fileScanner.close();
                    break;
                }

                // -----------------------------------------
                case 4:
                {
                    // COUNT BOOKS BY YEAR RANGE
                    System.out.print("Enter start year: ");
                    int startYear = keyboard.nextInt();

                    System.out.print("Enter end year: ");
                    int endYear = keyboard.nextInt();

                    while (startYear > endYear)
                    {
                        System.out.print("Re-enter start year: ");
                        startYear = keyboard.nextInt();
                        System.out.print("Re-enter end year: ");
                        endYear = keyboard.nextInt();
                    }

                    File file = new File("library.txt");
                    Scanner fileScanner = new Scanner(file);

                    int count = 0;

                    while (fileScanner.hasNext())
                    {
                        fileScanner.next(); // title
                        fileScanner.next(); // author
                        int year = fileScanner.nextInt();
                        fileScanner.nextDouble(); // price

                        if (year >= startYear && year <= endYear)
                        {
                            count++;
                        }
                    }

                    System.out.println("Books in range: " + count);
                    fileScanner.close();
                    break;
                }

                // -----------------------------------------
                case 5:
                {
                    // TOTAL CATALOG VALUE
                    File file = new File("library.txt");
                    Scanner fileScanner = new Scanner(file);

                    double total = 0.0;

                    while (fileScanner.hasNext())
                    {
                        fileScanner.next();
                        fileScanner.next();
                        fileScanner.nextInt();
                        total += fileScanner.nextDouble();
                    }

                    System.out.printf("Total catalog value: €%.2f%n", total);
                    fileScanner.close();
                    break;
                }

                // -----------------------------------------
                case 6:
                {
                    System.out.println("Goodbye!");
                    break;
                }
            }
        }
        while (choice != 6);

        keyboard.close();
    }
}

