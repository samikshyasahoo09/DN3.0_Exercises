import java.util.Arrays;

class Book implements Comparable<Book> {
    int bookId;
    String title;
    String author;

    Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }

    @Override
    public int compareTo(Book other) {
        return this.title.compareTo(other.title);
    }

    @Override
    public String toString() {
        return "Book ID: " + bookId + ", Title: " + title + ", Author: " + author;
    }
}

class LibraryManagementSystem {
    private Book[] books;
    private int size;

    LibraryManagementSystem(int capacity) {
        books = new Book[capacity];
        size = 0;
    }

    // Add book
    void addBook(Book book) {
        if (size >= books.length) {
            books = Arrays.copyOf(books, size * 2);
        }
        books[size++] = book;
        Arrays.sort(books, 0, size); // Keep books sorted
    }

    // Linear search by title
    Book linearSearchByTitle(String title) {
        for (int i = 0; i < size; i++) {
            if (books[i].title.equals(title)) {
                return books[i];
            }
        }
        return null;
    }

    // Binary search by title
    Book binarySearchByTitle(String title) {
        int left = 0, right = size - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int cmp = books[mid].title.compareTo(title);
            if (cmp == 0) {
                return books[mid];
            } else if (cmp < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        LibraryManagementSystem lms = new LibraryManagementSystem(2);
        
        lms.addBook(new Book(1, "The Post Office", "Rabindra Nath Tagore"));
        lms.addBook(new Book(2, "Untouchable", "Mulk Raj Anand"));
        
        System.out.println("Linear search for 'The Post Office':");
        System.out.println(lms.linearSearchByTitle("The Post Office"));
        
        System.out.println("\nBinary search for 'Untouchable':");
        System.out.println(lms.binarySearchByTitle("Untouchable"));
    }
}
