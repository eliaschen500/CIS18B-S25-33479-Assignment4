import java.util.*;
// =============================
// Main Program
// =============================
public class LibraryTest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        LibraryCollection library = new LibraryCollection();

        // Sample book data
        library.addBook(new Book("1984", "George Orwell", "Fiction"));
        library.addBook(new Book("Clean Code", "Robert Martin", "Programming"));
        library.addBook(new Book("The Martian", "Andy Weir", "Sci-Fi"));
        library.addBook(new Book("Dune", "Frank Herbert", "Sci-Fi"));
        library.addBook(new Book("The Pragmatic Programmer", "Andy Hunt", "Programming"));

        System.out.println("=== Welcome to the Library System ===");

        while (true) {
            System.out.print("\nEnter a genre to view available books (or type 'exit'): ");
            String genre = input.nextLine();
            if (genre.equalsIgnoreCase("exit")) break;

            Iterator<Book> it = library.getGenreIterator(genre);
            if (!it.hasNext()) {
                System.out.println("No available books in genre: " + genre);
                continue;
            }

            System.out.println("\nAvailable books:");
            while (it.hasNext()) {
                System.out.println("- " + it.next());
            }

            // Checkout
            System.out.print("\nEnter the title of the book to checkout (or 'skip'): ");
            String checkoutTitle = input.nextLine();
            if (!checkoutTitle.equalsIgnoreCase("skip")) {
                try {
                    Book book = library.findBookByTitle(checkoutTitle);
                    book.checkout();
                    System.out.println("Checked out: " + book);
                } catch (Exception e) {
                    System.out.println("No " + e.getMessage());
                }
            }

            // Return
            System.out.print("Do you want to return a book? (yes/no): ");
            if (input.nextLine().equalsIgnoreCase("yes")) {
                System.out.print("Enter the title of the book to return: ");
                String returnTitle = input.nextLine();
                try {
                    Book book = library.findBookByTitle(returnTitle);
                    book.returnBook();
                    System.out.println("Returned: " + book);
                } catch (BookNotFoundException e) {
                    System.out.println("No " + e.getMessage());
                }
            }
        }

        System.out.println("Thank you for visiting!");
        input.close();
    }
}
        
