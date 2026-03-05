import java.util.Scanner;
import java.io.*;
import java.io.IOException;

public class SophieRafterySample5Question2
{
    public static void main(String[] args) throws IOException
    {
        Scanner keyboard = new Scanner(System.in);
        File playlistFile = new File("playlist.txt");

        int choice;

        // Welcome message
        System.out.println("========================================");
        System.out.println("      MUSIC PLAYLIST MANAGER");
        System.out.println("========================================");
        System.out.println("Welcome to your Music Playlist!\n");

        do
        {
            // Main menu
            System.out.println("MAIN MENU:");
            System.out.println("1. Display All Songs");
            System.out.println("2. Add New Song");
            System.out.println("3. Search Songs by Artist");
            System.out.println("4. Calculate Total Playlist Duration");
            System.out.println("5. Find Highest Rated Songs");
            System.out.println("6. Exit");
            System.out.print("\nEnter your choice (1-6): ");

            choice = keyboard.nextInt();
            keyboard.nextLine(); // clear buffer

            while (choice < 1 || choice > 6)
            {
                System.out.print("Invalid choice. Enter 1-6: ");
                choice = keyboard.nextInt();
                keyboard.nextLine();
            }

            switch (choice)
            {
                case 1:
                {
                    // Display all songs
                    Scanner fileScanner = new Scanner(playlistFile);
                    int songCount = 0;

                    System.out.println("\n========================================");
                    System.out.println("         YOUR PLAYLIST");
                    System.out.println("========================================");
                    System.out.printf("%-4s %-24s %-20s %-10s %-6s%n",
                            "No.", "Title", "Artist", "Duration", "Rating");

                    while (fileScanner.hasNextLine())
                    {
                        String line = fileScanner.nextLine();

						// Find the position of the first comma in the line
						// This marks the end of the song title
                        int c1 = line.indexOf(',');

                        // Find the position of the second comma
						// Start searching AFTER the first comma (c1 + 1)
						// This marks the end of the artist name
                        int c2 = line.indexOf(',', c1 + 1);

                        // Find the position of the third comma
						// Start searching AFTER the second comma (c2 + 1)
						// This marks the end of the duration value
                        int c3 = line.indexOf(',', c2 + 1);

						// Extract the song title (from start of line up to first comma)
                        String title = line.substring(0, c1);

                        // Extract the artist name (between first and second comma)
                        String artist = line.substring(c1 + 1, c2);

						// Extract the duration (between second and third comma)
						// Convert from String to double
                        double duration = Double.parseDouble(line.substring(c2 + 1, c3));

                        // Extract the rating (from after third comma to end of line)
						// Convert from String to int
                        int rating = Integer.parseInt(line.substring(c3 + 1));

                        songCount++;

                        System.out.printf("%-4d %-24s %-20s %-5.2f min %3d/5%n", songCount, title, artist, duration, rating);
                    }

                    System.out.println("========================================");
                    System.out.println("Total Songs: " + songCount);
                    System.out.println("========================================");

                    fileScanner.close();
                    break;
                }

                case 2:
                {
                    // Add new song
                    System.out.println("\n========================================");
                    System.out.println("          ADD NEW SONG");
                    System.out.println("========================================");

                    System.out.print("Enter song title: ");
                    String title = keyboard.nextLine();

                    System.out.print("Enter artist name: ");
                    String artist = keyboard.nextLine();

                    System.out.print("Enter duration in minutes: ");
                    double duration = keyboard.nextDouble();

                    while (duration <= 0)
                    {
                        System.out.print("Duration must be positive. Re-enter: ");
                        duration = keyboard.nextDouble();
                    }

                    System.out.print("Enter rating (1-5): ");
                    int rating = keyboard.nextInt();
                    keyboard.nextLine();

                    while (rating < 1 || rating > 5)
                    {
                        System.out.print("Rating must be between 1 and 5: ");
                        rating = keyboard.nextInt();
                        keyboard.nextLine();
                    }

                    FileWriter fw = new FileWriter(playlistFile, true);
                    PrintWriter pw = new PrintWriter(fw);

                    pw.println(title + "," + artist + "," + duration + "," + rating);

                    pw.close();

                    System.out.println("\nSong '" + title + "' added successfully!");
                    break;
                }

                case 3:
                {
                    // Search by artist
                    System.out.println("\n========================================");
                    System.out.println("      SEARCH SONGS BY ARTIST");
                    System.out.println("========================================");

                    System.out.print("Enter artist name to search: ");
                    String searchArtist = keyboard.nextLine().toLowerCase();

                    Scanner fileScanner = new Scanner(playlistFile);
                    int found = 0;

                    while (fileScanner.hasNextLine())
                    {
                        String line = fileScanner.nextLine();

                        int c1 = line.indexOf(',');
                        int c2 = line.indexOf(',', c1 + 1);
                        int c3 = line.indexOf(',', c2 + 1);

                        String title = line.substring(0, c1);
                        String artist = line.substring(c1 + 1, c2);
                        double duration = Double.parseDouble(line.substring(c2 + 1, c3));
                        int rating = Integer.parseInt(line.substring(c3 + 1));

                        if (artist.toLowerCase().equals(searchArtist))
                        {
                            found++;
                            System.out.printf("%d. %s - %.1f min - Rating: %d/5%n",
                                    found, title, duration, rating);
                        }
                    }

                    if (found == 0)
                    {
                        System.out.println("No songs found by this artist");
                    }
                    else
                    {
                        System.out.println("\nFound " + found + " song(s) by this artist.");
                    }

                    fileScanner.close();
                    break;
                }

                case 4:
                {
                    // Total duration
                    Scanner fileScanner = new Scanner(playlistFile);
                    double totalMinutes = 0;

                    while (fileScanner.hasNextLine())
                    {
                        String line = fileScanner.nextLine();
                        int c2 = line.indexOf(',', line.indexOf(',') + 1);
                        int c3 = line.indexOf(',', c2 + 1);

                        double duration = Double.parseDouble(line.substring(c2 + 1, c3));
                        totalMinutes += duration;
                    }

                    int hours = (int) totalMinutes / 60;
                    int minutes = (int) totalMinutes % 60;

                    System.out.println("\n========================================");
                    System.out.println("    TOTAL PLAYLIST DURATION");
                    System.out.println("========================================");
                    System.out.printf("Total Duration: %.1f minutes%n", totalMinutes);
                    System.out.println("(" + hours + " hours and " + minutes + " minutes)");

                    fileScanner.close();
                    break;
                }

                case 5:
                {
                    // Highest rated songs
                    Scanner fileScanner = new Scanner(playlistFile);
                    int count = 0;

                    System.out.println("\n========================================");
                    System.out.println("      HIGHEST RATED SONGS");
                    System.out.println("========================================");

                    while (fileScanner.hasNextLine())
                    {
                        String line = fileScanner.nextLine();

                        int c1 = line.indexOf(',');
                        int c2 = line.indexOf(',', c1 + 1);
                        int c3 = line.indexOf(',', c2 + 1);

                        String title = line.substring(0, c1);
                        String artist = line.substring(c1 + 1, c2);
                        double duration = Double.parseDouble(line.substring(c2 + 1, c3));
                        int rating = Integer.parseInt(line.substring(c3 + 1));

                        if (rating == 5)
                        {
                            count++;
                            System.out.printf("%d. %s - %s - %.1f min%n",
                                    count, title, artist, duration);
                        }
                    }

                    if (count == 0)
                    {
                        System.out.println("No songs with 5-star rating found.");
                    }

                    fileScanner.close();
                    break;
                }

                case 6:
                {
                    System.out.println("\n========================================");
                    System.out.println("Thank you for using Music Playlist Manager!");
                    System.out.println("Keep enjoying your music!");
                    System.out.println("========================================");
                    break;
                }
            }

            if (choice != 6)
            {
                System.out.print("\nPress Enter to continue...");
                keyboard.nextLine();
                System.out.println();
            }

        }
        while (choice != 6);

        keyboard.close();
    }
}
