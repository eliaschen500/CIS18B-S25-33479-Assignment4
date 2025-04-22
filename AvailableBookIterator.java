import java.util.*;

public class AvailableBookIterator implements Iterator<Book> {
    private Iterator<Book> iterator;
    private Book nextAvailable;

    public AvailableBookIterator(List<Book> books) {
        this.iterator = books.iterator();
        advance(); // find the first available book
    }

    private void advance() {
        nextAvailable = null;
        while (iterator.hasNext()) {
            Book book = iterator.next();
            if (book.isAvailable()) {
                nextAvailable = book;
                break;
            }
        }
    }

    @Override
    public boolean hasNext() {
        return nextAvailable != null;
    }

    @Override
    public Book next() {
        if (nextAvailable == null) {
            throw new NoSuchElementException();
        }
        Book current = nextAvailable;
        advance(); // move to the next available book
        return current;
    }
}
