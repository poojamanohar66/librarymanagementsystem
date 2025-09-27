package LMS;

import java.util.ArrayList;
import java.util.List;

public class User {
    private int userId;
    private String name;
    // Composition: A User HAS-A list of books they've issued.
    private List<Book> issuedBooks; 

    // 🔨 Constructor
    public User(int userId, String name) {
        this.userId = userId;
        this.name = name;
        this.issuedBooks = new ArrayList<>();
    }

    // 💡 Getters
    public int getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public List<Book> getIssuedBooks() {
        return issuedBooks;
    }

    // 🔄 Methods to manage the user's issued books list
    public void addBook(Book book) {
        issuedBooks.add(book);
    }

    public void removeBook(Book book) {
        issuedBooks.remove(book);
    }

    // 📝 Override toString()
    @Override
    public String toString() {
        return "User ID: " + userId + ", Name: " + name + 
               ", Books Issued: " + issuedBooks.size();
    }
}
