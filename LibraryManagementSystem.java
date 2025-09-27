package LMS;

public class LibraryManagementSystem {
    public static void main(String[] args) {
        // 1. Initialize Library
        Library myLibrary = new Library();

        // 2. Create Books
        Book b1 = new Book("The Java Programming", "J. Gosling", "12345");
        Book b2 = new Book("OOP Principles", "E. Gamma", "67890");
        Book b3 = new Book("Data Structures in Java", "A. V. Aho", "11223");

        // 3. Add Books to Library
        myLibrary.addBook(b1);
        myLibrary.addBook(b2);
        myLibrary.addBook(b3);

        // 4. Create Users
        User u1 = new User(101, "Alice");
        User u2 = new User(102, "Bob");

        // 5. Register Users
        myLibrary.addUser(u1);
        myLibrary.addUser(u2);
        
        myLibrary.displayAllBooks();

        // ----------------------------------------------------
        // 6. Test Core Features: Issue and Return
        // ----------------------------------------------------

        // Test 1: Successful Issue
        System.out.println("\n--- Test 1: Successful Issue ---");
        myLibrary.issueBook("12345", 101); // Alice issues "The Java Programming"

        // Test 2: Attempt to issue an already issued book
        System.out.println("\n--- Test 2: Re-Issue Attempt ---");
        myLibrary.issueBook("12345", 102); // Bob tries to issue the same book

        // Test 3: Another Successful Issue
        System.out.println("\n--- Test 3: Another Issue ---");
        myLibrary.issueBook("67890", 102); // Bob issues "OOP Principles"

        myLibrary.displayAllBooks();

        // Test 4: Successful Return
        System.out.println("\n--- Test 4: Successful Return ---");
        myLibrary.returnBook("12345", 101); // Alice returns "The Java Programming"

        myLibrary.displayAllBooks();
        
        // Test 5: Attempt to return a book by the wrong user
        System.out.println("\n--- Test 5: Wrong User Return Attempt ---");
        myLibrary.returnBook("67890", 101); // Alice tries to return Bob's book
        
        // Final State Check
        System.out.println("\n--- Final State of Users ---");
        System.out.println(u1);
        System.out.println(u2);
    }
}
