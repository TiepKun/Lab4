package hust.soict.hedspi.aims.media;

import java.util.ArrayList;

public class Book extends Media {
    // Additional field specific to Book
    private ArrayList<String> authors;

    // Constructor
    public Book(int id, String title, String category, float cost) {
        super(id, title, category, cost); // Call Media's constructor
        this.authors = new ArrayList<>();
    }

    // Methods to manage authors
    public void addAuthor(String authorName) {
        if (!authors.contains(authorName)) {
            authors.add(authorName);
        } else {
            System.out.println("Author already exists: " + authorName);
        }
    }

    public void removeAuthor(String authorName) {
        if (authors.contains(authorName)) {
            authors.remove(authorName);
        } else {
            System.out.println("Author not found: " + authorName);
        }
    }

    public ArrayList<String> getAuthors() {
        return new ArrayList<>(authors);
    }
}
