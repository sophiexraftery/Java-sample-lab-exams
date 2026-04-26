public class Book extends LibraryItem
{
    private String author;
    private int pageCount;

    // Constructor
    public Book(String title, String itemId, String author, int pageCount)
    {
        super(title, itemId);
        this.author = author;
        this.pageCount = pageCount;
    }

    // Override method
    @Override
    public void displayItemDetails()
    {
        super.displayItemDetails();
        System.out.println("Author: " + author + " | Pages: " + pageCount);
        System.out.println("--------------------------");
    }
}