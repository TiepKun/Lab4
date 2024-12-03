package hust.soict.hedspi.test.store.StoreTest;

import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.store.Store.Store;

public class StoreTest {
    public static void main(String[] args) {
        // Create a new store
        Store store = new Store();

        // Create sample Media
        DigitalVideoDisc dvd1 = new DigitalVideoDisc(1, "The Lion King", "Animation", 19.95f, "Roger Allers", 87);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc(2, "Star Wars", "Science Fiction", 24.95f, "George Lucas", 87);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc(3, "Aladdin", "Animation", 18.99f);
        Book book = new Book(4, "Harry Potter", "Fantasy", 15.99f);
        // Add Media to the store
        store.addMedia(dvd1);
        store.addMedia(dvd2);
        store.addMedia(dvd3);
        store.addMedia(book);
       

        // Print the store inventory
        System.out.println("\nStore Inventory after adding Media:");
        store.printStore();

        // Remove a Media from the store
        store.removeMedia("Star Wars");

        // Print the store inventory after removal
        System.out.println("\nStore Inventory after removing a Media:");
        store.printStore();

        // Attempt to remove a Media that doesn't exist
        store.removeMedia("Frozen");
    }
}
