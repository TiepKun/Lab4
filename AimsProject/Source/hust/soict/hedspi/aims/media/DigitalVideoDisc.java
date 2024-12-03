package hust.soict.hedspi.aims.media;

public class DigitalVideoDisc extends Media implements Playable {
    private String director;
    private int length;

    public DigitalVideoDisc(int id, String title, String category, float cost, String director, int length) {
        super(id, title, category, cost);
        this.director = director;
        this.length = length;
    }

    public DigitalVideoDisc(int id, String title, String category, float cost, String director) {
        this(id, title, category, cost, director, 0);
    }

    public DigitalVideoDisc(int id, String title, String category, float cost) {
        this(id, title, category, cost, null, 0);
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    // Thêm phương thức setTitle để thay đổi tiêu đề
    public void setTitle(String title) {
        super.setTitle(title); // Gọi phương thức từ lớp cha Media
    }

    @Override
    public void play() {
        System.out.println("Playing DVD: " + getTitle());
        System.out.println("DVD length: " + getLength());
    }

    @Override
    public String toString() {
        return "DVD - " + getTitle() + " - " + getCategory() + " - Director: " + director + " - Length: " + length + " - " + getCost() + " $";
    }
}
