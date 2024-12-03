package hust.soict.hedspi.aims.media;

// DigitalVideoDisc kế thừa từ Media và triển khai Playable
public class DigitalVideoDisc extends Media implements Playable {
    // Thuộc tính riêng của DigitalVideoDisc
    private String director;
    private int length;

    // Constructor đầy đủ
    public DigitalVideoDisc(int id, String title, String category, float cost, String director, int length) {
        super(id, title, category, cost); // Gọi constructor từ lớp Media
        this.director = director;
        this.length = length;
    }

    // Constructor rút gọn (không có length)
    public DigitalVideoDisc(int id, String title, String category, float cost, String director) {
        super(id, title, category, cost); // Gọi constructor từ lớp Media
        this.director = director;
    }

    // Constructor đơn giản (chỉ có title và category)
    public DigitalVideoDisc(int id, String title, String category, float cost) {
        super(id, title, category, cost); // Gọi constructor từ lớp Media
    }

    // Getter và Setter cho director và length
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

    // Phương thức toString để hiển thị thông tin DVD
    @Override
    public String toString() {
        return "DVD - " + getTitle() + " - " + getCategory() + " - " + director + " - " + length + ": " + getCost() + " $";
    }

    // Phương thức isMatch để so sánh tiêu đề (case-insensitive)
    public boolean isMatch(String title) {
        return this.getTitle().equalsIgnoreCase(title);
    }

    // Triển khai phương thức play() từ Playable interface
    @Override
    public void play() {
        System.out.println("Playing DVD: " + this.getTitle());
        System.out.println("DVD length: " + this.getLength());
    }
}
