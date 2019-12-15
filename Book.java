/**
 * The class holds the properties of a book
 * @author Mikkel Aas
 * @version 1.0
 */
public class Book {

    /**
     * title field that stores the title of the book. Type String.
     */
    private final String title;
    /**
     * author field that stores the author of the book. Type String.
     */
    private final String author;
    /**
     * publisher field that stores the publisher of the book. Type String.
     */
    private final String publisher;
    /**
     * yearPublished field that stores the year the book was published. Type int.
     */
    private final int yearPublished;
    /**
     * pages field that stores the number of pages the book contains. Type int.
     */
    private final int pages;
    /**
     * barcode field which stores the barcode of the book. Type String.
     */
    private final String barcode;
    /**
     * isLoaned field which stores the loaned status of the book. Type boolean.
     */
    private boolean isLoaned;

    /**
     * A book constructor that constructs a book object
     * @param title Title sets the title of the book. Type String.
     * @param author Author sets the author of the book. Type String.
     * @param publisher Publisher sets the publisher of the book. Type String.
     * @param yearPublished yearPublished sets the year the book was published. Type int.
     * @param pages Pages sets the number of pages the book contains. Type int.
     * @param barcode Barcode sets the barcode of the book. Type String.
     * @param isLoaned isLoaned sets the loaned status of the book. Type Boolean.
     */
    public Book(String title, String author, String publisher, int yearPublished, int pages, String barcode,
                boolean isLoaned){
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.yearPublished = yearPublished;
        this.pages = pages;
        this.barcode = barcode;
        this.isLoaned = isLoaned;
    }

    /**
     * The method returns the title of the book
     * @return Returns variable title of type String
     */
    public String getTitle(){
        return title;
    }

    /**
     * The method returns the author of the book
     * @return Returns variable author of type String
     */
    public String getAuthor(){
        return author;
    }

    /**
     * The method returns the publisher of the book
     * @return Returns variable publisher of type String
     */
    public String getPublisher(){
        return publisher;
    }

    /**
     * The method returns the year the book was published
     * @return Returns variable yearPublished of type int
     */
    public int getYearPublished(){
        return yearPublished;
    }

    /**
     * The method returns the number of pages the book contains
     * @return Returns variable pages of type int
     */
    public int getPages(){
        return pages;
    }

    /**
     * The method returns the barcode of the book
     * @return Returns variable barcode of type String
     */
    public String getBarcode(){
        return barcode;
    }

    /**
     * The method returns the loaned status of the book
     * @return Returns variable isLoaned of type boolean
     */
    public boolean getIsLoaned() {
        return isLoaned;
    }

    /**
     * The method sets the loaned status of the book
     * @param loanedStatus Takes parameter loanedStatus of type boolean
     */
    public void setIsLoaned(boolean loanedStatus){
        isLoaned = loanedStatus;
    }

    /**
     * The method uses the isLoaned variable to print YES for true, and NO for false
     */
    public void loanedStatus(){
        if (isLoaned){
            System.out.println("Available: no");
        } else {
            System.out.println("Available: yes");
        }
    }

    /**
     * The method prints all the information of a single book
     */
    public void printInfo(){
        System.out.println("| " + title + " | " + author + " | " + publisher + " | " + yearPublished + " | " + pages +
                " | " + barcode +" | " + isLoaned + " |");
    }

    /**
     * The method prints a verbose version of the information of the book
     */
    public void printInfoVerbose(){
        System.out.println("------------------------------------");
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Publisher: " + publisher);
        System.out.println("Year published: " + yearPublished);
        System.out.println("Pages: " + pages);
        System.out.println("Barcode: " + barcode);
        loanedStatus();
        System.out.println("------------------------------------");

    }
}
