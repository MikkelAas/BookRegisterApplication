import java.util.HashMap;
import java.util.Iterator;

/**
 * The class holds the properties of a book register
 * @author Mikkel Aas
 * @version 1.0
 */
public class BookRegister {
    /**
     * register field that stores the value of a HashMap object with String as key and Book as value
     */
    private final HashMap<String, Book> register;

    /**
     * A BookRegister constructor that creates a new instance of a HashMap with String as key and Book as value
     */
    public BookRegister(){
        register = new HashMap<>();
    }

    /**
     * The method generates x number of test books
     * @param amount Amount sets the amount of books you wish to create. Type int.
     */
    public void generateTestBooks(int amount){
        for(int i = 0; i < amount; i++){
            register.put("0000000000000" + i, new Book("Book" + i, "Author" + i, "Publisher" + i,
                    2000 + i, 100 + i, "0000000000000" + i, false));
        }
    }

    /**
     * The method adds a book to the register
     * @param title Title sets the title of the book. Type String
     * @param author Author sets the author of the book. Type String.
     * @param publisher Publisher sets the publisher of the book. Type String.
     * @param yearPublished yearPublished sets the year the book was published. Type int.
     * @param pages Pages sets the number of pages the book contains. Type int.
     * @param barcode Barcode sets the barcode of the book. Type String.
     * @param isLoaned isLoaned sets the loaned status of the book. Type boolean.
     */
    public void addBook(String title, String author, String publisher, int yearPublished, int pages, String barcode,
                        boolean isLoaned){
        register.put(barcode, new Book(title, author, publisher, yearPublished, pages, barcode, isLoaned));
    }

    /**
     * The method removes a book from the register
     * @param barcode Barcode sets the barcode of the book you wish to remove. Type String.
     */
    public void removeBook(String barcode){
        register.remove(barcode);
    }

    /**
     * The method returns a book from the register
     * @param barcode Barcode sets the barcose of the book you wish to return. Type String.
     * @return Returns the book with the corresponding key value
     */
    public Book getBook(String barcode){
        return register.get(barcode);
    }

    /**
     * The method returns a iterator of the values of the HashMap register
     * @return Returns the iterator of the register values
     */
    public Iterator<Book> getIteratorValues(){
        return register.values().iterator();
    }

    /**
     * The method returns an iterator of the keys of the HashMap register
     * @return Returns the iterator of the register keys
     */
    public Iterator<String> getIteratorKeys(){
        return register.keySet().iterator();
    }
}
