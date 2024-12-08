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

       //Add the books in the library
       library.addBook(book1);
       library.addBook(book2);
       library.addBook(book3);

       //Print the books added
       for(Book book : library.getBooks()) {
           System.out.println(book);
       }

       //Library class test cases:

       //Test case #1: Adding books to the library
       try {
            Book book1 = new Book("The Hobbit", "J.R.R. Tolkien", "12345", 1937, 5);
            Book book2 = new Book("1984", "George Orwell", "67890", 1949, 3);
            Book book3 = new Book("To Kill a Mockingbird", "Harper Lee", "11223", 1960, 2);
            library.addBook(book1);
            library.addBook(book2);
            library.addBook(book3);

            System.out.println("Books added successfully!");
        } catch (Exception e) {
            System.out.println("Error adding books: " + e.getMessage());
        }

       // Test Case 2: Checkout a book
        try {
            System.out.println("Checking out 'The Hobbit'...");
            library.checkout("12345");
            System.out.println("'The Hobbit' checked out successfully.");
        } catch (Exception e) {
            System.out.println("Error checking out book: " + e.getMessage());
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
