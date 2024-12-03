package hust.soict.hedspi.aims.media;

public class Disc extends Media {
    // Additional fields
    private int length;
    private String director;

    // Constructor
    public Disc(int id, String title, String category, float cost, int length, String director) {
        super(id, title, category, cost); // Call to Media constructor
        this.length = length;
        this.director = director;
    }

    // Getter for length
    public int getLength() {
        return length;
    }

    // Getter for director
    public String getDirector() {
        return director;
    }

    // Override toString for better representation
    @Override
    public String toString() {
        return super.toString() + ", length=" + length + ", director=" + director;
    }
}
