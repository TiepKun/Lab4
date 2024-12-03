package hust.soict.hedspi.test.cart.CartTest;

import hust.soict.hedspi.aims.cart.Cart.Cart;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Book;

public class CartTest {
    public static void main(String[] args) {
        // Create a new cart
        Cart cart = new Cart();

        // Create new Media objects and add them to the cart
        DigitalVideoDisc dvd1 = new DigitalVideoDisc(1, "The Lion King", "Animation", 19.95f, "Roger Allers", 87);
        cart.addMedia(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc(2, "Star Wars", "Science Fiction", 24.95f, "George Lucas", 87);
        cart.addMedia(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc(3, "Aladdin", "Animation", 18.99f);
        cart.addMedia(dvd3);

        Book book = new Book(4, "Harry Potter", "Fantasy", 15.99f);
        cart.addMedia(book);

        // Test the print method
        cart.print();

        // Test search by ID
        System.out.println("\nSearching for Media with ID 1:");
        cart.searchById(1);

        System.out.println("\nSearching for Media with ID 4:");
        cart.searchById(4);

        System.out.println("\nSearching for Media with ID 6:");
        cart.searchById(6);

        // Test search by title
        System.out.println("\nSearching for Media with title 'Star Wars':");
        cart.searchByTitle("Star Wars");

        System.out.println("\nSearching for Media with title 'Frozen':");
        cart.searchByTitle("Frozen");
    }
}
