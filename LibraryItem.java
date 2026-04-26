public class LibraryItem
{
    protected String title;
    protected String itemId;

    private static int totalItemsCreated = 0;

    // Constructor
    public LibraryItem(String title, String itemId)
    {
        this.title = title;
        this.itemId = itemId;
        totalItemsCreated++;
    }

    // Display method
    public void displayItemDetails()
    {
        System.out.println("Item ID: " + itemId + " | Title: " + title);
    }

    // Static method
    public static int getTotalItems()
    {
        return totalItemsCreated;
    }
}