package hust.soict.hedspi.garbage;

import java.util.ArrayList;

public class GarbageCreator {
    public static void main(String[] args) {
        ArrayList<String> garbage = new ArrayList<>();
        try {
            for (int i = 0; ; i++) {
                garbage.add("Garbage " + i); // Tạo garbage liên tục
                if (i % 10000 == 0) {
                    System.out.println("Created " + i + " garbage objects");
                }
            }
        } catch (OutOfMemoryError e) {
            System.err.println("OutOfMemoryError: " + e.getMessage());
        }
    }
}
