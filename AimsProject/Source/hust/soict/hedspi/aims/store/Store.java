package hust.soict.hedspi.aims.store;

import hust.soict.hedspi.aims.media.Media;
import java.util.ArrayList;
import java.util.List;

public class Store {
    private List<Media> itemsInStore;  // Danh sách các media trong cửa hàng

    public Store() {
        itemsInStore = new ArrayList<>();
    }

    // Phương thức thêm media vào cửa hàng
    public void addMedia(Media media) {
        itemsInStore.add(media);
    }

    // Phương thức xóa media khỏi cửa hàng theo tên
    public void removeMedia(String title) {
        itemsInStore.removeIf(media -> media.getTitle().equalsIgnoreCase(title));
    }

    // Phương thức tìm media theo tên trong cửa hàng
    public Media findMediaByTitle(String title) {
        for (Media media : itemsInStore) {
            if (media.getTitle().equalsIgnoreCase(title)) {
                return media;
            }
        }
        return null;  // Không tìm thấy media
    }

    // Phương thức in danh sách media trong cửa hàng
    public void printStore() {
        if (itemsInStore.isEmpty()) {
            System.out.println("The store is empty.");
        } else {
            for (Media media : itemsInStore) {
                System.out.println(media.toString());
            }
        }
    }

    // Phương thức tạo ID tự động cho media mới
    public int generateId() {
        return itemsInStore.size() + 1;  // ID mới sẽ là số phần tử hiện tại + 1
    }

    // Getter cho danh sách media trong cửa hàng
    public List<Media> getItemsInStore() {
        return itemsInStore;
    }
}
