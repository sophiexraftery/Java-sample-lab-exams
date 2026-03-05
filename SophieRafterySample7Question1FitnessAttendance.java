/*
Name: Sophie Raftery
Student ID: g00477839
Date: 5/3/2026
*/
import java.util.Scanner;
public class SophieRafterySample7Question1FitnessAttendance
{
    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);

		// ================= CREATE 2D ARRAY =================
		        int[][] attendance = new int[4][3];

		        int highestAttendance = 0;
		        int highestClass = 0;
		        int highestSession = 0;

		        double overallTotal = 0;

		//PRINT HEADER
		System.out.println("==============================================");
		System.out.println("\tFITNESS CLASS ATTENDANCE");
		System.out.println("==============================================");


		        // ================= INPUT SECTION =================
		        for(int row = 0; row < attendance.length; row++)
		        {
		            for(int col = 0; col < attendance[row].length; col++)
		            {
		                System.out.printf("Enter attendance for Class %d, Session %d: ",
		                                  row + 1, col + 1);

		                attendance[row][col] = keyboard.nextInt();

		                // Validate input (0–40 inclusive)
		                while(attendance[row][col] < 0 || attendance[row][col] > 40)
		                {
		                    System.out.print("Invalid! Attendance must be between 0 and 40. Re-enter: ");
		                    attendance[row][col] = keyboard.nextInt();
		                }
		            }
		        }

		        // ================= REPORT HEADER =================
		        System.out.println("\n==============================================");
		        System.out.printf("%20s\n", "REPORT");
		        System.out.println("==============================================");

		        System.out.printf("%-10s %-10s %-10s %-10s %-10s\n",
		                          "", "Session 1", "Session 2", "Session 3", "Avg");

		        // ================= PROCESSING + DISPLAY =================
		        for(int row = 0; row < attendance.length; row++)
		        {
		            int classTotal = 0;

		            System.out.printf("%-10s", "Class " + (row + 1));

		            for(int col = 0; col < attendance[row].length; col++)
		            {
		                System.out.printf("%-10d", attendance[row][col]);

		                classTotal += attendance[row][col];
		                overallTotal += attendance[row][col];

		                // Check for highest attendance
		                if(attendance[row][col] > highestAttendance)
		                {
		                    highestAttendance = attendance[row][col];
		                    highestClass = row + 1;
		                    highestSession = col + 1;
		                }
		            }

		            double classAverage = (double) classTotal / attendance[row].length;
		            System.out.printf("%-10.2f\n", classAverage);
		        }

		        // ================= OVERALL AVERAGE =================
		        double overallAverage =
		                overallTotal / (attendance.length * attendance[0].length);

		        // ================= SUMMARY =================
		        System.out.printf("\nOverall Average: %.2f\n", overallAverage);
		        System.out.printf("Highest attendance: %d (Class %d, Session %d)\n",
		                          highestAttendance, highestClass, highestSession);

		        System.out.println("==============================================");

		        keyboard.close();
    }
}