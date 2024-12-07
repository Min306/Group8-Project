/**
 * Encapusulates information about a book.
 * @author Balaji Srinivasan, Judy Luo
 */
public class Book {
    String title;
    String author;
    String isbn;
    int publicationYear;
    // number of copies in the library
    // NOTE: This is not the number of copies available in the library
    int numberOfCopies; 

    /**
     * Constructor. Most properties (except number of copies are read only)
     */
    public Book(String title, String author, String isbn, int publicationYear, int numberOfCopies) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.publicationYear = publicationYear;
        this.numberOfCopies = numberOfCopies;
    }

    /**
     * @return The title of the book.
     */
    public String getTitle() {
        return title;
    }

    /**
     * @return The author of the book.
     */
    public String getAuthor() {
        return author;
    }

    /**
     * @return the ISBN for this book.
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     * @return The publication year of this book.
     */
    public int getPublicationYear() {
        return publicationYear;
    }

    /**
     * @return The number of copies of this book.
     */
    public int getNumberOfCopies() {
        return numberOfCopies;
    }

    /**
     * Adds the given mumber of copies of this book to the library.
     */
    public void addCopies(int numCopiesToAdd) {
        numberOfCopies += numCopiesToAdd;
    }

    /**
     * convert the book class to hash code
     * @return the int hash value based on the class' properties
     * @exception IllegalArgumentException the input object is not book class
     */
    @Override
    public int hashCode() {
        try{
            int result = 17;
            result = 31 * result + (title == null ? 0 : title.hashCode());
            result = 31 * result + (author == null ? 0 : author.hashCode());
            result = 31 * result + (isbn == null ? 0 : isbn.hashCode());
            result = 31 * result + publicationYear + numberOfCopies;
            //return Objects.hash(title,author,isbn,publicationYear,numberOfCopies);
            return result;
        } catch (NullPointerException e) {
            throw new NullPointerException("the object contains empty value(s)");
        }
    }

    /**
     * compare two books if they have the same Title, Author, and ISBN
     * @param that the book object to get compared with the current book
     * @return true if both books share the same identities, else false
     * @exception NullPointerException the input object contains empty value(s)
     * @exception IllegalArgumentException the input object is not book class
     */
    @Override
    public boolean equals(Object that) {
        //check if Object that is a book class
        if (that.getClass() != Book.class){
            throw new IllegalArgumentException("the input object is not book class");
        }
        try {
            Book thatBook = (Book) that;
            //compare properties
            return thatBook.getTitle().equals(title) && thatBook.getAuthor().equals(author) && thatBook.getIsbn().equals(isbn);
        } catch (NullPointerException e) {
            throw new NullPointerException("the object contains empty value(s)");
        }
    }
}
