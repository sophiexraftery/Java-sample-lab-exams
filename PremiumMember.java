public class PremiumMember extends GymMember
{
    private String personalTrainer;

    public PremiumMember(String memberName, String memberId, double monthlyFee, String personalTrainer)
    {
        super(memberName, memberId, monthlyFee);
        this.personalTrainer = personalTrainer;
    }

    @Override
    public void displayMemberDetails()
    {
        System.out.println("[PREMIUM]");
        super.displayMemberDetails();
        System.out.println("Personal Trainer: " + personalTrainer);
    }
}