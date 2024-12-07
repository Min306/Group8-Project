import java.util.Scanner;
import java.util.LinkedList;

/**
 * A library management class. Has a simple shell that users can interact with to add/remove/checkout/list books in the library.
 * Also allows saving the library state to a file and reloading it from the file.
 */
public class Library {
	LinkedList<Book> library = new LinkedList<Book>();

    /**
     * Adds a book to the library. If the library already has this book then it
     * adds the number of copies the library has.
     */
    public void addBook(Book book) {
        // TODO: Implement this method.
	library.add(book);
        for(int i = 0; i < library.size(); i++) {
	    if(book.equals(book)) {
              book.addCopies(book.numberOfCopies);
	    }
        }
        // throw new UnsupportedOperationException("not implemented");
    }

    /**
     * Checks out the given book from the library. Throw the appropriate
     * exception if book doesnt exist or there are no more copies available.
     */
    public void checkout(String isbn) {
        // TODO: Implement this method.
        for(int i = 0; i < library.size(); i++) {
                    
            if(library.get(i).getIsbn().equals(isbn)) {
	        if(library.get(i).getNumberOfCopies() == 0) {
		    throw new UnsupportedOperationException("There are no more copies left in the library");
                }
			
                library.get(i).addCopies(-1);
        	library.remove(i);
                break;
			
            } else if(i == library.size() - 1) {
                throw new NoSuchElementException("This book is not in the library");
            }
        }
	// throw new UnsupportedOperationException("not implemented");
    }

    /**
     * Returns a book to the library
     */
    public void returnBook(String isnb) {
        // TODO: Implement this method.
        throw new UnsupportedOperationException("not implemented");
    }

    /**
     * Finds this book in the library. Throws appropriate exception if the book
     * doesnt exist.
     */
    public Book findByTitleAndAuthor(String title, String author) {
        // TODO: Implement this method.
        throw new UnsupportedOperationException("not implemented");
    }

    /**
     * Finds this book in the library. Throws appropriate exception if the book
     * doesnt exist.
     */
    public Book findByISBN(String isbn) {
        // TODO: Implement this method.
        throw new UnsupportedOperationException("not implemented");
    }

    /**
     * Saves the contents of this library to the given file.
     */
    public void save(String filename) {
        // TODO: Implement this method.
        throw new UnsupportedOperationException("not implemented");
    }

    /**
     * Loads the contents of this library from the given file. All existing data
     * in this library is cleared before loading from the file.
     */
    public void load(String filename) {
        // TODO: Implement this method.
        throw new UnsupportedOperationException("not implemented");
    }

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.print("library> ");
			String line = scanner.nextLine();
			// TODO: Implement code 
			if (line.startsWith("add")) {
				// TODO: Implement this case.
				// The format of the line is
				// add title author isbn publicationYear numberOfCopies
				// e.g. add Star_Trek Gene_Roddenberry ISBN-1234 1965 10
				// NOTE: If a book already exists in the library, then the number of copies should be incremented by this amount.
				// Do appropriate error checking here.
			} else if (line.startsWith("checkout")) {
				// TODO: Implement this case.
				// The format of the line is
				// checkout isbn
				// e.g. checkout ISBN-1234
				// NOTE: If the book doesnt exist in the library, then the code should print an error.
			} else if (line.startsWith("findByTitleAndAuthor")) {
				// TODO: Implement this case.
				// The format of the line is
				// findByTitleAndAuthor <title> <author>
				// e.g. findByTitleAndAuthor Star_Trek Gene_Roddenberry
				// NOTE: If the book doesnt exist in the library, then the code should print an error.
				// If the book exists in the library, this code should print the ISBN, number of copies in the library, and the number of copies availabvle
			} else if (line.startsWith("return")) {
				// TODO: Implement this case.
				// Format of the line is
				// return <isbn>
				// e.g. return ISBN-1234
				// NOTE: If the book was never checked out, this code should print an error.
			} else if (line.startsWith("list")) {
				// TODO: Implement this case.
				// Format of the line is 
				// list <isnb>
				// e.g. list ISBN-1234
				// NOTE: This code should print out the number of copies in the library and the number of copies available.
			} else if (line.startsWith("save")) {
				// TODO: Implement this case.
				// Format of the line is
				// save <filename>
				// e.g. save LbraryFile.dat
			} else if (line.startsWith("load")) {
				// TODO: Implement this case.
				// Format of the line is:
				// load <filename>
				// e.g. load LibraryFile.dat
			} else if (line.startsWith("exit")) {
				break;
			}
		}
	}
}
