import java.util.Iterator;
import java.util.Scanner;

/**
 * The class contains all the properties of a book register application
 * @author Mikkel Aas
 * @version 1.0
 */
public class BookRegisterApp {
    /**
     * A field that stores register as the type BookRegister
     */
    private BookRegister register;

    /**
     * A constructor that constructs a book library register application object
     */
    private BookRegisterApp(){
    }

    /**
     * The method checks if the user input is a valid int number
     * @return Returns user input of type int
     */
    private int getValidInt() {
        boolean done = false;
        int number = 0;
        while (!done)
            try {
                Scanner scanner = new Scanner(System.in);
                number = scanner.nextInt();
                done = true;
            }catch (Exception e){
                System.out.println("Please enter a reasonable number: ");
                }
        return number;
    }

    /**
     * The method takes an user input and checks if it is a valid barcode by making sure it's a number and that it is
     * 13 digits long.
     * @return Returns user input as a barcode of type String
     */
    private String getValidBarcode() {
        boolean done = false;
        String barcode = null;
        while (!done) {
            try {
                Scanner scanner = new Scanner(System.in);
                barcode = scanner.next();
                int convertedNumber = Integer.parseInt(barcode);
                if (Integer.toString(convertedNumber).length() == 13) {
                    done = true;
                } else {
                    System.out.println("NON VALID INPUT: Please enter a 13 digit number: ");
                }
            } catch (Exception e) {
                System.out.println("Please enter a number that is 13 digits long: ");
            }
        }
        return barcode;
    }

    /**
     * The method checks if the book is rented by taking a user input as String and running it through an if else sequence
     * @return Returns a user input of type boolean
     */
    private Boolean checkIfRented(){
        boolean done = false;
        boolean isLoaned = false;
        while(!done){
            Scanner scanner = new Scanner(System.in);
            String rented = scanner.next();
            if (rented.equalsIgnoreCase("NO")){
                done = true;
            } else if (rented.equalsIgnoreCase("yes")){
                isLoaned = true;
                done = true;
            } else {
                System.out.println("Please type either YES or NO.");
            }
        }
        return isLoaned;
    }

    /**
     * The method prints the help menu for the user
     */
    private void commandHelp(){
        System.out.println("-----------------------------------------------------------------------------");
        System.out.println("These are the avaiable commands: HELP, ADD, REMOVE, LIST, SEARCH, EXIT");
        System.out.println("HELP: " + "displays this help menu.");
        System.out.println("ADD: " + "lets you add a book to the register.");
        System.out.println("REMOVE TITLE: " + "removes a book from the register based on the title.");
        System.out.println("REMOVE AUTHOR: " + "removes a book from the register based on the author.");
        System.out.println("REMOVE BARCODE: " +"removes a book from the register based on the author");
        System.out.println("SEARCH TITLE : " + "searches through the register based on the title.");
        System.out.println("SEARCH AUTHOR: " + "searches through the register based on the title.");
        System.out.println("SEARCH BARCODE: " + "searches through the register based on the title.");
        System.out.println("LIST: " + "lists all the books in the register.");
        System.out.println("EXIT: " + "exits the program");
        System.out.println("-----------------------------------------------------------------------------");
    }

    /**
     * The method adds a book to the register for the user
     */
    private void commandAdd(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type the book title: ");
        String title = scanner.next();
        System.out.println("Type the author of the book: ");
        String author = scanner.next();
        System.out.println("Type the publisher of the book: ");
        String publisher = scanner.next();
        System.out.println("Type the publisher year: ");
        int yearPublished = getValidInt();
        System.out.println("Type the number of pages: ");
        int pages = getValidInt();
        System.out.println("Type the barcode: ");
        String barcode = getValidBarcode();
        System.out.println("Is the book currently rented? YES/NO");
        boolean isLoaned = checkIfRented();
        register.addBook(title, author, publisher, yearPublished, pages, barcode, isLoaned);
        System.out.println("The book was successfully added to the library.");
    }

    /**
     * The method prints every book in the register
     */
    private void commandList(){
        Iterator<Book> registerIterator = register.getIteratorValues();
        while(registerIterator.hasNext()){
            registerIterator.next().printInfoVerbose();
        }
    }

    /**
     * The method searches for all titles in the register and returns them to the user
     * @param title Uses the parameter title of type String to search
     */
    private void searchTitle(String title){
        Iterator<Book> registerIterator = register.getIteratorValues();
        boolean done = false;
        while(registerIterator.hasNext()){
            Book book = registerIterator.next();
            if(book.getTitle().equalsIgnoreCase(title)){
                book.printInfoVerbose();
                done = true;
            }
        }
       if (!done){
           System.out.println("No books found!");
       }
   }

    /**
     * The method searches for all authors in the register and returns them to the user
     * @param author Uses the parameter author of type String to search
     */
    private void searchAuthor(String author){
        Iterator<Book> registerIterator = register.getIteratorValues();
        boolean done = false;
        while(registerIterator.hasNext()){
            Book book = registerIterator.next();
            if(book.getAuthor().equalsIgnoreCase(author)){
                book.printInfoVerbose();
                done = true;
            }
        }
        if (!done){
            System.out.println("No books found!");
        }
    }

    /**
     * The method searches for all barcodes in the register and returns them to the user
     * @param barcode Uses the parameter barcode of type String to search
     */
    private void searchBarcode(String barcode){
        Iterator<String> registerIterator = register.getIteratorKeys();
        boolean done = false;
        while(registerIterator.hasNext()){
            String key = registerIterator.next();
            if (key.equals(barcode)){
                register.getBook(key).printInfoVerbose();
                done = true;
            }
        }
        if (!done){
            System.out.println("No books found!");
        }
    }

    /**
     * The method removes a book based on the title
     * @param title It takes a title parameter of type String
     */
    private void removeTitle(String title){
        Iterator<Book> registerIterator = register.getIteratorValues();
        while(registerIterator.hasNext()){
            Book book = registerIterator.next();
            if (book.getTitle().equalsIgnoreCase(title)){
                registerIterator.remove();
            }
        }
    }

    /**
     * The method removes a book based on the author
     * @param author It takes an author parameter of type String
     */
    private void removeAuthor(String author){
        Iterator<Book> registerIterator = register.getIteratorValues();
        while(registerIterator.hasNext()){
            Book book = registerIterator.next();
            if (book.getAuthor().equalsIgnoreCase(author)){
                registerIterator.remove();
            }
        }
    }

    /**
     * The method removes a book based on the barcode
     * @param barcode It takes a barcode parameter of type String
     */
    private void removeBarcode(String barcode){
        Iterator<Book> registerIterator = register.getIteratorValues();
        while(registerIterator.hasNext()){
            Book book = registerIterator.next();
            if (book.getBarcode().equals(barcode)){
                registerIterator.remove();
            }
        }
    }

    /**
     * This method initializes the application
     */
    private void init() {
        boolean done = false;

        // Creates a new BookRegister object
        register = new BookRegister();

        // Creates 10 test books
        register.generateTestBooks(10);

        System.out.println("Welcome to the book register application!");
        System.out.println("Type " + "HELP" + " to get started.");
        while (!done) {
            Scanner scanner = new Scanner(System.in);
            String command = scanner.nextLine();
            switch (command.toUpperCase()) {
                case "HELP":
                    commandHelp();
                    break;
                case "ADD":
                    commandAdd();
                    break;
                case "REMOVE TITLE":
                    System.out.println("Please enter the title you wish to remove: ");
                    String title = scanner.next();
                    removeTitle(title);
                    System.out.println("The book was successfully removed.");
                    break;
                case "REMOVE AUTHOR":
                    System.out.println("Please enter the author you wish to remove: ");
                    String author = scanner.next();
                    removeAuthor(author);
                    System.out.println("The book was successfully removed.");
                break;
                case "REMOVE BARCODE":
                    System.out.println("Please enter the barcode you wish to remove: ");
                    String barcode = scanner.next();
                    removeBarcode(barcode);
                    System.out.println("The book was successfully removed.");
                break;
                case "LIST":
                    commandList();
                    break;
                case "SEARCH TITLE":
                    System.out.println("Enter the title you wish to search for: ");
                    String titleSearch = scanner.next();
                    searchTitle(titleSearch);
                    break;
                case "SEARCH AUTHOR":
                    System.out.println("Enter the author you wish to search for: ");
                    String authorSearch = scanner.next();
                    searchAuthor(authorSearch);
                    break;
                case "SEARCH BARCODE":
                    System.out.println("Enter the barcode you wish to search for: ");
                    String barcodeSearch = scanner.next();
                    searchBarcode(barcodeSearch);
                    break;
                case "EXIT":
                    System.out.println("Thank you for using the book register application.");
                    done = true;
                    break;
                default:
                    System.out.println("Invalid command.");
                    break;
            }
        }
    }
    public static void main(String[] args) {
        BookRegisterApp bookRegisterApp = new BookRegisterApp();
        bookRegisterApp.init();
    }
}
