package hust.soict.hedspi.aims.store;

import hust.soict.hedspi.aims.media.Media;

import java.util.ArrayList;
import java.util.List;

public class Store {
    private List<Media> itemsInStore = new ArrayList<>();

    public void addMedia(Media media) {
        if (media != null && !itemsInStore.contains(media)) {
            itemsInStore.add(media);
            System.out.println(media.getTitle() + " has been added to the store.");
        } else {
            System.out.println("This media is already in the store or invalid.");
        }
    }

    public void removeMedia(String title) {
        Media mediaToRemove = findMediaByTitle(title);
        if (mediaToRemove != null) {
            itemsInStore.remove(mediaToRemove);
            System.out.println(title + " has been removed from the store.");
        } else {
            System.out.println("Media not found in the store.");
        }
    }

    public Media findMediaByTitle(String title) {
        for (Media media : itemsInStore) {
            if (media.getTitle().equalsIgnoreCase(title)) {
                return media;
            }
        }
        return null;
    }

    public void printStore() {
        if (itemsInStore.isEmpty()) {
            System.out.println("The store is currently empty.");
        } else {
            System.out.println("Items available in the store:");
            System.out.println("--------------------------------");
            for (int i = 0; i < itemsInStore.size(); i++) {
                Media media = itemsInStore.get(i);
                System.out.println((i + 1) + ". " + media.getTitle() + " - " + media.getCategory() 
                                   + " - $" + media.getCost());
            }
            System.out.println("--------------------------------");
        }
    }
}
