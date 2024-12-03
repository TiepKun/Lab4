package hust.soict.hedspi.aims.media;

import java.util.ArrayList;

public class Book extends Media {
    private ArrayList<String> authors;

    public Book(int id, String title, String category, float cost) {
        super(id, title, category, cost);
        this.authors = new ArrayList<>();
    }

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

    @Override
    public String toString() {
        return "Book - " + getTitle() + " - " + getCategory() + " - Authors: " + authors + " - " + getCost() + " $";
    }
}
