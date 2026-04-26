public class StandardMember extends GymMember
{
    private boolean poolAccess;

    public StandardMember(String memberName, String memberId, double monthlyFee, boolean poolAccess)
    {
        super(memberName, memberId, monthlyFee);
        this.poolAccess = poolAccess;
    }

    @Override
    public void displayMemberDetails()
    {
        System.out.println("[STANDARD]");
        super.displayMemberDetails();

        if(poolAccess)
        {
            System.out.println("Pool Access: Yes");
        }
        else
        {
            System.out.println("Pool Access: No");
        }
    }
}