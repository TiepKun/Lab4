package hust.soict.hedspi.garbage;

public class NoGarbage {
    public static void main(String[] args) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 100000; i++) {
            builder.append("Garbage ").append(i); // Sử dụng StringBuilder để tối ưu bộ nhớ
            if (i % 10000 == 0) {
                System.out.println("Appended " + i + " times");
            }
        }
        System.out.println("Completed without OutOfMemoryError");
    }
}
