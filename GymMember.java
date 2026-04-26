public class GymMember
{
    private String memberName;
    private String memberId;

    private static int totalMembers = 0;
    private static double totalMonthlyIncome = 0.0;

    // Constructor
    public GymMember(String memberName, String memberId, double monthlyFee)
    {
        this.memberName = memberName;
        this.memberId = memberId;

        totalMembers++;
        totalMonthlyIncome += monthlyFee;
    }

    // Display method
    public void displayMemberDetails()
    {
        System.out.println("Member ID: " + memberId + " | Name: " + memberName);
    }

    // Static methods
    public static int getTotalMembers()
    {
        return totalMembers;
    }

    public static double getTotalIncome()
    {
        return totalMonthlyIncome;
    }
}