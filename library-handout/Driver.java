import java.io.IOException;
public class Driver extends DriverBase {
    
   public static void main(String[] args) {
      //Initialize the library class
       Library library = new Library();

       //Test case for adding books
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
   }
}
