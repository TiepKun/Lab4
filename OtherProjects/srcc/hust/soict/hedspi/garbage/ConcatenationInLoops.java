package hust.soict.hedspi.garbage;

import java.util.Random;

public class ConcatenationInLoops {
    public static void main(String[] args) {
        Random r = new Random(123);
        long start;

        // Using + operator
        start = System.currentTimeMillis();
        String s = "";
        for (int i = 0; i < 65536; i++) {
            s += r.nextInt(2); // Concatenate using +
        }
        System.out.println("Using + operator: " + (System.currentTimeMillis() - start) + "ms");

        // Using StringBuffer
        r = new Random(123);
        start = System.currentTimeMillis();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 65536; i++) {
            sb.append(r.nextInt(2)); // Append using StringBuffer
        }
        System.out.println("Using StringBuffer: " + (System.currentTimeMillis() - start) + "ms");

        // Using StringBuilder
        r = new Random(123);
        start = System.currentTimeMillis();
        StringBuilder sbuilder = new StringBuilder();
        for (int i = 0; i < 65536; i++) {
            sbuilder.append(r.nextInt(2)); // Append using StringBuilder
        }
        System.out.println("Using StringBuilder: " + (System.currentTimeMillis() - start) + "ms");
    }
}
