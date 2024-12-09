import java.io.IOException;
public class Driver extends DriverBase {
    
   public static void main(String[] args) {
      //Initialize the library class
       Library library = new Library();

       //Create three book objects that should access the book class with parameters 
       //from the library csv dataset
       Book book1 = new Book("The Hobbit", "J.R.R. Tolkien", "12345", 5, 15);
       Book book2 = new Book("1984", "George Orwell", "67890", 3, 10);
       Book book3 = new Book("To Kill a Mockingbird", "Harper Lee", "11223", 2, 12);

       //Print the books added
       for(Book book : library.getBooks()) {
           System.out.println(book);
       }

       System.out.println();

       //Library class test cases:

       //Test case #1: Adding books to the library
       try {
            System.out.println("Test case 1: Adding book into the library");
            library.addBook(book1);
            library.addBook(book2);
            library.addBook(book3);

            System.out.println("Books added successfully!");
        } catch (Exception e) {
            System.out.println("Error adding books: " + e.getMessage());
        }

        System.out.println();

        //Test case 2: Adding a null value to the library
        try {
            System.out.println("Test case 1: Adding a null value into the library");
            library.addBook(null);
        } catch(Exception e) {
            System.out.println("Error adding books: " + e.getMessage());
        }

        System.out.println();

       // Test Case 3: Checkout a book
        try {
            System.out.println("Test case 3: Checking out 'The Hobbit'...");
            library.checkout("12345");
            System.out.println("'The Hobbit' checked out successfully.");
        } catch (Exception e) {
            System.out.println("Error checking out book: " + e.getMessage());
        }

        System.out.println();

        // Test Case 4: Finding a book by Title and Author existed in Library
        try {
            System.out.println("Test case 4: Finding book 'To kill a Mockingbird by Harper Lee'");
            library.findByTitleAndAuthor("Finding book 'To kill a Mockingbird by Harper Lee", "Harper Lee");
            System.out.println("We found the book!");
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println();

        // Test Case 5: Finding a book by Title and Author does not exist in Library
        try {
            System.out.println("Test case 5: Finding book 'To kill a Mockingbird by Harper Lee'");
            library.findByTitleAndAuthor("The Hobbit", "Harper Lee");
            System.out.println("We found the book!");
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println();

        // Test Case 6: Finding a book by ISBN
        try{
            System.out.println("Test case 6: Finding book with ISBN:12345");
            library.findByISBN("12345");
            System.out.println("We found the book!");
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println();

        // Test Case 7: Finding a book by ISBN
        try{
            System.out.println("Test case 7: Finding book with ISBN does not exist in library");
            library.findByISBN("640598604");
            System.out.println("We found the book!");
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }

       System.out.println();
        
       // Test Case 8: Return book existed other copies in library
        try{
            System.out.println("Test case 8: Return book existed copies in library");
            library.returnBook("12345");
            System.out.println(book1.getNumberOfCopies());
            System.out.println("Return successful!");
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }

       //Book class test cases
       //Test case #1: get hashcode for a completely null book object
        Book a = new Book(null, null, null, 0, 0);
        System.out.println(a.hashCode());

        //Test case #2: get hashcode for a half null object
        Book b = new Book("book name", "author name", null, 0, 0);
        System.out.println(b.hashCode());

        //Test case #3: get hashcode for a completed book object
        Book c = new Book("book name", "author name", "123456", 2024, 5);
        System.out.println(c.hashCode());

        //Test case #4: compare two null book objects
        Book d = new Book(null, null, null, 0, 0);
        try {
            System.out.println(a.equals(d));
        } catch (Exception e) {
            System.out.println("an exception occurs" + e.getMessage());
        }
        
        //Test case #5: compare a book object to an object that is not book
        String e = new String("I'm not a book object");
        try {
            System.out.println(a.equals(e));
        } catch (Exception ex) {
            System.out.println("an exception occurs: " + ex.getMessage());
        }
        
        //Test case #6: compare two different book objects
        Book f = new Book("book name 2", "author name 2", "123456", 2024, 5);
        System.out.println(b.equals(f));

        //Test case #7: compare two identical book objects
        Book g = new Book("book name 2", "author name 2", "123456", 2024, 5);
        System.out.println(f.equals(g));

        //Test case #8: check if two identical book objects have the same hashcode
        System.out.println(f.hashCode() == g.hashCode());
   }
}
