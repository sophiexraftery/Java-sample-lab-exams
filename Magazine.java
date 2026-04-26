public class Magazine extends LibraryItem
{
    private int issueNumber;

    // Constructor
    public Magazine(String title, String itemId, int issueNumber)
    {
        super(title, itemId);
        this.issueNumber = issueNumber;
    }

    // Override method
    @Override
    public void displayItemDetails()
    {
        super.displayItemDetails();
        System.out.println("Issue Number: " + issueNumber);
        System.out.println("--------------------------");
    }
}