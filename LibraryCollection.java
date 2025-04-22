import java.util.*;
// =============================
// LibraryCollection Class
// =============================
public class LibraryCollection implements Iterable<Book> {
    private Map<String, List<Book>> genreMap;

    public LibraryCollection() {
        genreMap = new HashMap<>();
    }

    public void addBook(Book book) {
        
        genreMap.computeIfAbsent(book.getGenre(), k -> new ArrayList<>()).add(book);
    }

    public Iterator<Book> getGenreIterator(String genre) {
        
        List<Book> books = genreMap.getOrDefault(genre, new ArrayList<>());
        return new AvailableBookIterator(books);
    }

  

    // Finds a book by title across all genres.
    public Book findBookByTitle(String title) throws BookNotFoundException {
        for (List<Book> books : genreMap.values()) {
            for (Book book : books) {
                if (book.getTitle().equalsIgnoreCase(title)) {
                    return book;
                }
            }
        }
        throw new BookNotFoundException("Book with title '" + title + "' not found.");
    }

    
    //Returns an iterator over all available books in the collection.
     
    @Override
    public Iterator<Book> iterator() {
        List<Book> allAvailable = new ArrayList<>();
        for (List<Book> books : genreMap.values()) {
            for (Book book : books) {
                if (book.isAvailable()) {
                    allAvailable.add(book);
                }
            }
        }
        return allAvailable.iterator();
    }
}

