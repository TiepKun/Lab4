package hust.soict.hedspi.aims.media;

import java.util.Comparator;

public class MediaComparatorByTitleCost implements Comparator<Media> {
    @Override
    public int compare(Media m1, Media m2) {
        // So sánh theo tiêu đề (alphabetical)
        int titleComparison = m1.getTitle().compareToIgnoreCase(m2.getTitle());
        if (titleComparison != 0) {
            return titleComparison;
        }
        // Nếu tiêu đề bằng nhau, so sánh theo giá giảm dần
        return Float.compare(m2.getCost(), m1.getCost());
    }
}
