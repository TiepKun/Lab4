package hust.soict.hedspi.aims.store.Store;

import hust.soict.hedspi.aims.media.Media;
import java.util.ArrayList;

public class Store {
    // Danh sách sản phẩm trong cửa hàng
    private ArrayList<Media> itemsInStore = new ArrayList<>();

    // Phương thức thêm Media vào cửa hàng
    public void addMedia(Media media) {
        itemsInStore.add(media);
        System.out.println("The media has been added to the store: " + media.getTitle());
    }

    // Phương thức xóa Media khỏi cửa hàng bằng tiêu đề
    public void removeMedia(String title) {
        boolean found = false;
        for (Media media : itemsInStore) {
            if (media.getTitle().equalsIgnoreCase(title)) {
                itemsInStore.remove(media);
                System.out.println("The media has been removed from the store: " + title);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("The media was not found in the store: " + title);
        }
    }

    // Phương thức in danh sách sản phẩm trong cửa hàng
    public void printStore() {
        System.out.println("*************** STORE INVENTORY ***************");
        if (itemsInStore.isEmpty()) {
            System.out.println("The store is currently empty.");
        } else {
            int index = 1;
            for (Media media : itemsInStore) {
                System.out.println(index + ". " + media.toString());
                index++;
            }
        }
        System.out.println("***********************************************");
    }
}