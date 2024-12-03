package hust.soict.hedspi.aims.media;

public class DVD extends Media {
    private String director;  // Đạo diễn của DVD
    private int length;       // Thời gian chạy của DVD (phút)

    // Constructor
    public DVD(int id, String title, String category, float cost, String director, int length) {
        super(id, title, category, cost);  // Gọi constructor của lớp cha Media
        this.director = director;
        this.length = length;
    }

    // Getter cho director
    public String getDirector() {
        return director;
    }

    // Getter cho length
    public int getLength() {
        return length;
    }

    // Override phương thức toString() để hiển thị thông tin DVD
    @Override
    public String toString() {
        return "DVD [ID: " + getId() + ", Title: " + getTitle() + ", Category: " + getCategory() + ", Cost: $" + getCost()
                + ", Director: " + director + ", Length: " + length + " minutes]";
    }
}
