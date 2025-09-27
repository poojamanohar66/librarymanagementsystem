package LMS;

import java.util.ArrayList;
import java.util.List;

public class Library {
    // Composition: A Library HAS-A list of books and a list of users.
    private List<Book> books;
    private List<User> users;

    // 🔨 Constructor
    public Library() {
        this.books = new ArrayList<>();
        this.users = new ArrayList<>();
    }

    // 📚 Book Management
    public void addBook(Book book) {
        books.add(book);
        System.out.println("✅ Book added: " + book.getTitle());
    }

    public Book findBookByISBN(String ISBN) {
        for (Book book : books) {
            if (book.getISBN().equals(ISBN)) {
                return book;
            }
        }
        return null; // Book not found
    }

    public void displayAllBooks() {
        if (books.isEmpty()) {
            System.out.println("🚫 No books in the library.");
            return;
        }
        System.out.println("\n--- Library Collection ---");
        for (Book book : books) {
            System.out.println(book);
        }
        System.out.println("--------------------------");
    }

    // 👥 User Management
    public void addUser(User user) {
        users.add(user);
        System.out.println("✅ User registered: " + user.getName());
    }

    public User findUserById(int userId) {
        for (User user : users) {
            if (user.getUserId() == userId) {
                return user;
            }
        }
        return null; // User not found
    }
    
    // ----------------------------------------------------
    // 🔑 Core Features: Book Issue and Return
    // ----------------------------------------------------

    /** Issues a book to a user. */
    public void issueBook(String ISBN, int userId) {
        Book book = findBookByISBN(ISBN);
        User user = findUserById(userId);

        if (book == null) {
            System.out.println("❌ Error: Book with ISBN " + ISBN + " not found.");
            return;
        }

        if (user == null) {
            System.out.println("❌ Error: User with ID " + userId + " not found.");
            return;
        }

        if (book.isIssued()) {
            System.out.println("⚠️ Book '" + book.getTitle() + "' is already issued.");
            return;
        }

        // 🎯 Success logic
        book.issueBook();       // Change book status
        user.addBook(book);     // Add book to user's list
        System.out.println("🎉 Successfully issued '" + book.getTitle() + 
                           "' to user " + user.getName() + ".");
    }

    /** Returns a book from a user. */
    public void returnBook(String ISBN, int userId) {
        Book book = findBookByISBN(ISBN);
        User user = findUserById(userId);

        if (book == null || user == null) {
            System.out.println("❌ Error: Invalid Book ISBN or User ID.");
            return;
        }

        if (!book.isIssued()) {
            System.out.println("⚠️ Book '" + book.getTitle() + "' was not issued in the first place.");
            return;
        }
        
        // Check if the book is actually with this user
        if (!user.getIssuedBooks().contains(book)) {
             System.out.println("❌ Error: Book '" + book.getTitle() + "' was not issued to user " + user.getName() + ".");
            return;
        }

        // 🎯 Success logic
        book.returnBook();      // Change book status
        user.removeBook(book);  // Remove book from user's list
        System.out.println("👍 Successfully returned '" + book.getTitle() + 
                           "' from user " + user.getName() + ".");
    }
}