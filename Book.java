package LMS;

public class Book {
    // 🔒 Encapsulation: Private fields protect the data.
    private String title;
    private String author;
    private String ISBN; // International Standard Book Number
    private boolean isIssued;

    // 🔨 Constructor
    public Book(String title, String author, String ISBN) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.isIssued = false; // By default, a new book is not issued.
    }

    // 💡 Getters (Accessors)
    public String getTitle() {
        return title;
    }

    public String getISBN() {
        return ISBN;
    }

    public boolean isIssued() {
        return isIssued;
    }

    // 🔧 Setters (Mutators) for issuing/returning
    public void issueBook() {
        this.isIssued = true;
    }

    public void returnBook() {
        this.isIssued = false;
    }

    // 📝 Override toString() for easy printing of book details
    @Override
    public String toString() {
        return "Title: " + title + ", Author: " + author + ", ISBN: " + ISBN 
               + (isIssued ? " (ISSUED)" : " (AVAILABLE)");
    }
}
