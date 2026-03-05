/*
Name: Sophie Raftery
Student ID: g00477839
Date: 5/3/2026
*/
import java.util.Scanner;
public class SophieRafterySample6Question1StudentMarkbook
{
    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);

        int[][] marks = new int[4][3];

        double classTotal = 0;
        int highestMark = 0;
        int highestStudent = 0;
        int highestTest = 0;

        // ================= HEADER =================
        System.out.println("=====================================================");
        System.out.printf("%30s\n", "STUDENT MARKBOOK");
        System.out.println("=====================================================");

        // ================= INPUT =================
        for(int row = 0; row < marks.length; row++)
        {
            for(int col = 0; col < marks[row].length; col++)
            {
                System.out.printf("Enter mark for Student %d, Test %d: ",
                                   row + 1, col + 1);

                marks[row][col] = keyboard.nextInt();

                while(marks[row][col] < 0 || marks[row][col] > 100)
                {
                    System.out.print("Invalid mark! Must be between 0 and 100. Re-enter: ");
                    marks[row][col] = keyboard.nextInt();
                }
            }
        }
        // ================= REPORT =================
        System.out.println("\n=====================================================");
        System.out.printf("%30s\n", "REPORT");
        System.out.println("=====================================================");

        System.out.printf("%-12s %-8s %-8s %-8s %-8s\n",
                          "", "Test 1", "Test 2", "Test 3", "Avg");

        for(int row = 0; row < marks.length; row++)
        {
            int studentTotal = 0;

            System.out.printf("%-12s", "Student " + (row + 1));

            for(int col = 0; col < marks[row].length; col++)
            {
                System.out.printf("%-10d", marks[row][col]);

                studentTotal += marks[row][col];
                classTotal += marks[row][col];

                if(marks[row][col] > highestMark)
                {
                    highestMark = marks[row][col];
                    highestStudent = row + 1;
                    highestTest = col + 1;
                }
            }

            double studentAvg = (double) studentTotal / marks[row].length;
            System.out.printf("%-10.2f\n", studentAvg);
        }

        // ================= CLASS RESULTS =================
        double classAverage = classTotal / (marks.length * marks[0].length);

        System.out.printf("\nClass Average: %.2f\n", classAverage);
        System.out.printf("Highest Mark: %d (Student %d, Test %d)\n",
                          highestMark, highestStudent, highestTest);

        System.out.println("=====================================================");
    }
}

