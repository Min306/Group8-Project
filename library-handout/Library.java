import java.util.Scanner;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * A library management class. Has a simple shell that users can interact with to add/remove/checkout/list books in the library.
 * Also allows saving the library state to a file and reloading it from the file.
 */
public class Library {
	private static LinkedList<Book> library = new LinkedList<Book>();
	HashMap<String,Book> isbnHashMap = new HashMap<>();
	HashMap<String,Book> titleAuthorHashMap = new HashMap<>();
	
	/**
     * Helper method to generate a unique key for a book using title and author.
     */
	private String titleAuthorKey(String title, String author) {
		return title + author;
	}

    /**
     * Adds a book to the library. If the library already has this book then it
     * adds the number of copies the library has.
     */
    public void addBook(Book book) {
		
		if(book == null) {
			throw new IllegalArgumentException("Invalid book!");
		}
		
        for(int i = 0; i < library.size(); i++) {
	    	if(library.get(i).equals(book)) {
            	library.get(i).addCopies(book.numberOfCopies);
				return;
	    	}
        }
		library.add(book);
		isbnHashMap.put(book.getIsbn(), book);
		titleAuthorHashMap.put(titleAuthorKey(book.getTitle(),book.getAuthor()),book);
    }

    /**
     * Checks out the given book from the library. Throw the appropriate
     * exception if book doesnt exist or there are no more copies available.
     */
    public void checkout(String isbn) {

        for(int i = 0; i < library.size(); i++) {
                    
            if(library.get(i).getIsbn().equals(isbn)) {
	        	if(library.get(i).getNumberOfCopies() == 0) {
		    		throw new UnsupportedOperationException("There are no more copies left in the library");
                }
			
                library.get(i).addCopies(-1);
        		library.remove(i);
                break;
			
            } else if(i == library.size() - 1) {
                throw new UnsupportedOperationException("This book is not in the library");
            }
        }
	// throw new UnsupportedOperationException("not implemented");
    }

    /**
     * Returns a book to the library
     */
    public void returnBook(String isnb) {
        if(!isbnHashMap.containsKey(isnb)) {
			throw new IllegalArgumentException("Invalid book!");
		} else {
			Book book = isbnHashMap.get(isnb);
			book.addCopies(1);
			if(!library.contains(book)) {
				library.add(book);
			}
			System.out.println("Return book successfull!");
		}
    }

    /**
     * Finds this book in the library. Throws appropriate exception if the book
     * doesnt exist.
     */
    public Book findByTitleAndAuthor(String title, String author) {
        if(titleAuthorHashMap.containsKey(titleAuthorKey(title, author))) {
			return titleAuthorHashMap.get(titleAuthorKey(title, author));
		} else {
			throw new IllegalArgumentException("Book: " + title + ",author: " + author + " does not exist in library");
		}
    }

    /**
     * Finds this book in the library. Throws appropriate exception if the book
     * doesnt exist.
     */
    public Book findByISBN(String isbn) {
        if(isbnHashMap.containsKey(isbn)) {
			return isbnHashMap.get(isbn);
		} else {
			throw new IllegalArgumentException("Book has ISBN: " + isbn + " does not exist in library");
		}
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
	 Library library = new Library();
    	 Scanner scanner = new Scanner(System.in);

         while (true) {
       	 	System.out.print("library> ");
        	String line = scanner.nextLine().trim();
        if (line.isEmpty()) {
            System.out.println("Error: Input cannot be empty.");
            continue;
        }

        if (line.startsWith("add")) {
            String[] parts = line.split(" ", 6);
            if (parts.length != 6) {
                System.out.println("Invald-->Usage: add <title> <author> <isbn> <year> <copies>");
                continue;
            }
            String title = parts[1];
            String author = parts[2];
            String isbn = parts[3];
            int year = Integer.parseInt(parts[4]);
            int copies = Integer.parseInt(parts[5]);

            if (title.isEmpty() || author.isEmpty() || isbn.isEmpty()) {
                 System.out.println("Error: Title, author, and ISBN cannot be empty.");
                 continue;
            }

            // Validate if year and copies are numbers (already done above but keep for clarity)
            try {
                 year = Integer.parseInt(parts[4]);
                 copies = Integer.parseInt(parts[5]);
            } catch (NumberFormatException e) {
                 System.out.println("Error: Publication year and number of copies must be valid numbers.");
                 continue;
            }

            // NOTE: If a book already exists in the library, then the number of copies should be incremented by this amount.
            Book existingBook = library.findByISBN(isbn);
            if (existingBook != null) {
                 existingBook.addCopies(copies);
                 System.out.println("Book already exists. Number of copies updated.");
            } else {
                 Book newBook = new Book(title, author, isbn, year, copies);
                 library.addBook(newBook);
                 System.out.println("Book added successfully.");
            }
        } else if (line.startsWith("checkout")) {
            String[] parts = line.split(" ");
            if (parts.length != 2) {
                System.out.println("Invalid format. Correct format: checkout isbn");
                continue;
            }
            String isbn = parts[1];
            try {
                library.checkout(isbn);
                System.out.println("Book checked out successfully.");
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        } else if (line.startsWith("findByTitleAndAuthor")) {
            String[] parts = line.split(" ");
            if (parts.length != 3) {
                System.out.println("Invalid format. Correct format: findByTitleAndAuthor title author");
                continue;
            }
            String title = parts[1];
            String author = parts[2];
            if (title.isEmpty() || author.isEmpty()) {
                System.out.println("Error: Title and author cannot be empty.");
                continue;
            }

            try {
                Book book = library.findByTitleAndAuthor(title, author);
                if (book == null) {
                    System.out.println("Error: Book not found.");
                } else {
                    System.out.println("ISBN: " + book.getIsbn() + ", Copies in Library: " + book.getNumberOfCopies());
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        } else if (line.startsWith("return")) {
            String[] parts = line.split(" ");
            if (parts.length != 2) {
                System.out.println("Invalid format. Correct format: return isbn");
                continue;
            }
            String isbn = parts[1];
            try {
                library.returnBook(isbn);
                System.out.println("Book returned successfully.");
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        } else if (line.startsWith("list")) {
            String[] parts = line.split(" ");
            if (parts.length != 2) {
                System.out.println("Invalid format. Correct format: list isbn");
                continue;
            }
            String isbn = parts[1];
            try {
                Book book = library.findByISBN(isbn);
                if (book == null) {
                    System.out.println("Error: Book not found.");
                } else {
                    System.out.println("Copies in library: " + book.getNumberOfCopies() + ", Available copies: " + book.getNumberOfCopies());
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        } else if (line.startsWith("save")) {
            String[] parts = line.split(" ");
            if (parts.length != 2) {
                System.out.println("Invalid format. Correct format: save filename");
                continue;
            }
            String filename = parts[1];
            library.save(filename);
            System.out.println("Library saved to " + filename);
        } else if (line.startsWith("load")) {
            String[] parts = line.split(" ");
            if (parts.length != 2) {
                System.out.println("Invalid format. Correct format: load filename");
                continue;
            }
            String filename = parts[1];
            library.load(filename);
            System.out.println("Library loaded from " + filename);
        } else if (line.startsWith("exit")) {
            System.out.println("Exiting the system.");
            break;
        } else {
            System.out.println("Invalid command(input): try again");
        }
    }
}
}
