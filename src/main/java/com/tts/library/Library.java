package com.tts.library;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private final String address;
    private final ArrayList<Book> bookList;
    private static String openingHours;

    private final static String DEFAULT_HOURS = "9 AM to 5 PM daily";
    private String currentHours;

    // Add the missing implementation to this class

    public static void main(String[] args) {
        // Create two libraries
        Library firstLibrary = new Library("10 Main St.");
        Library secondLibrary = new Library("228 Liberty St.");

        // Add four books to the first library
        firstLibrary.addBook(new Book("The Da Vinci Code"));
        firstLibrary.addBook(new Book("Le Petit Prince"));
        firstLibrary.addBook(new Book("A Tale of Two Cities"));
        firstLibrary.addBook(new Book("The Lord of the Rings"));

        // Print opening hours and the addresses
        System.out.println("Library hours:");
        printOpeningHours();
        System.out.println();

        System.out.println("Library addresses:");
        firstLibrary.printAddress();
        secondLibrary.printAddress();
        System.out.println();

        // Try to borrow The Lords of the Rings from both libraries
        System.out.println("Borrowing The Lord of the Rings:");
        firstLibrary.borrowBook("The Lord of the Rings");
        firstLibrary.borrowBook("The Lord of the Rings");
        secondLibrary.borrowBook("The Lord of the Rings");
        System.out.println();

        // Print the titles of all available books from both libraries
        System.out.println("Books available in the first library:");
        firstLibrary.printAvailableBooks();
        System.out.println();
        System.out.println("Books available in the second library:");
        secondLibrary.printAvailableBooks();
        System.out.println();

        // Return The Lords of the Rings to the first library
        System.out.println("Returning The Lord of the Rings:");
        firstLibrary.returnBook("The Lord of the Rings");
        System.out.println();

        // Print the titles of available from the first library
        System.out.println("Books available in the first library:");
        firstLibrary.printAvailableBooks();
    }

    private static void printOpeningHours() {
        System.out.println(openingHours);
    }

    private void printCurrentHours() {
        if (currentHours != null) System.out.println(currentHours);
        else printOpeningHours();
    }

    private void addBook(Book book) {
        bookList.add(book);
    }

    public Library(String address) {
        this.address = address;
        bookList = new ArrayList<>();
        openingHours = DEFAULT_HOURS;
    }

    public Library(String address, String hours) {
        this(address);
        currentHours = hours;
    }

    private void printAddress() {
        System.out.println(this.address);
    }

    private void borrowBook(String book) {
        boolean inCatalog = false;
        for (Book shelfBook : bookList) {
            if (shelfBook.getTitle().equalsIgnoreCase(book)
            ) {
                inCatalog = true;
                System.out.println("Fount the listing! Let me see here...");
                if (shelfBook.isBorrowed()) {
                    System.out.println("Sorry! Already rented.");
                } else {
                    shelfBook.rented();
                    System.out.println("Rented you the book! Have fun!");
                }
            }
        }
        if(!inCatalog) {
            System.out.println("Sorry, not available in our catalog!");
        }
    }

    private void printAvailableBooks() {
        for (Book shelfBook : bookList) {
            if (!shelfBook.isBorrowed()) {
                System.out.println(shelfBook.getTitle());
            }
        }
    }

    private void returnBook(String returnedBook) {
        boolean inCatalog = false;
        for (Book shelfBook : bookList) {
            if (shelfBook.getTitle().equalsIgnoreCase(returnedBook)) {
                inCatalog = true;
                if (shelfBook.isBorrowed()) {
                    System.out.println("This book is checked in. Thanks!");
                    shelfBook.returned();
                }else System.out.println("We, uh, weren't missing that one, but thanks...");
            }
        }
        if(!inCatalog){
            System.out.println("Sorry, I've never heard of that book. You can keep it!");
        }
    }

}