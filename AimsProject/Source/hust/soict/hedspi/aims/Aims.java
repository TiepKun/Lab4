package hust.soict.hedspi.aims;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DVD;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;
import hust.soict.hedspi.aims.store.Store;

import java.util.Scanner;

public class Aims {
    private static Store store = new Store();
    private static Cart cart = new Cart();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Media cd = new CompactDisc(1, "The Man", "Music", 10.99f, 120, "Director", "The Beatles");
        Media dvd = new DVD(2, "Incon", "Sci-Fi", 14.99f, "Christopher Nolan", 148);
        Media book = new Book(3, "The Al", "Novel", 12.99f);
        Media cd2 = new CompactDisc(4, "Thrillestic", "Music", 9.99f, 110, "Quincy Jones", "Michael Jackson");

        Media dvd2 = new DVD(5, "Mad: Fury Road and IOP", "Action", 19.99f, "George Miller", 120);
        Media book2 = new Book(6, "Harry Potter", "Fantasy", 15.99f);
        Media dvd3 = new DVD(7, "The Sharl", "Drama", 13.49f, "Frank Darabont", 142);
        Media cd3 = new CompactDisc(8, "Kind things Blue", "Jazz", 11.49f, 55, "Miles Davis", "Miles Davis");
        Media book3 = new Book(9, "Girl with the Thurt", "Mystery", 18.49f);
        Media dvd4 = new DVD(10, "Motel", "Comedy", 17.99f, "Wes Anderson", 99);
        Media cd4 = new CompactDisc(11, "Four Seasons", "Classical", 14.49f, 80, "Antonio Vivaldi", "Vivaldi");
        
        
        store.addMedia(cd);
        store.addMedia(dvd);
        store.addMedia(book);
        store.addMedia(cd2);
        store.addMedia(dvd2);
        store.addMedia(book2);
        store.addMedia(cd3);
        store.addMedia(dvd3);
        store.addMedia(book3);
        store.addMedia(cd4);
        store.addMedia(dvd4);
        int choice;

        do {
            showMenu();
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    viewStore(scanner);
                    break;
                case 2:
                    updateStore(scanner);
                    break;
                case 3:
                    seeCurrentCart(scanner);
                    break;
                case 0:
                    System.out.println("Exiting application. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice! Please choose again.");
            }
        } while (choice != 0);

        scanner.close();
    }

    public static void showMenu() {
        System.out.println("AIMS: ");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3");
    }

    public static void viewStore(Scanner scanner) {
        int choice;
        do {
            store.printStore();
            storeMenu();
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    seeMediaDetails(scanner);
                    break;
                case 2:
                    addMediaToCart(scanner);
                    break;
                case 3:
                    playMedia(scanner);
                    break;
                case 4:
                    seeCurrentCart(scanner);
                    break;
                case 0:
                    System.out.println("Returning to main menu.");
                    break;
                default:
                    System.out.println("Invalid choice! Please choose again.");
            }
        } while (choice != 0);
    }

    public static void storeMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. See a media’s details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4");
    }

    public static void seeMediaDetails(Scanner scanner) {
        System.out.print("Enter the title of the media: ");
        String title = scanner.nextLine();
        Media media = store.findMediaByTitle(title);

        if (media != null) {
            System.out.println(media.toString()); // Display details of the media
            mediaDetailsMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    cart.addMedia(media);
                    System.out.println("Media added to cart.");
                    break;
                case 2:
                    if (media instanceof Playable) {
                        ((Playable) media).play();
                    } else {
                        System.out.println("This media cannot be played.");
                    }
                    break;
                case 0:
                    System.out.println("Returning to store menu.");
                    break;
                default:
                    System.out.println("Invalid choice! Please choose again.");
            }
        } else {
            System.out.println("Media not found.");
        }
    }

    public static void mediaDetailsMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");
    }

    public static void addMediaToCart(Scanner scanner) {
        System.out.print("Enter the title of the media: ");
        String title = scanner.nextLine();
        Media media = store.findMediaByTitle(title);

        if (media != null) {
            cart.addMedia(media);
            System.out.println("Media added to cart.");
        } else {
            System.out.println("Media not found.");
        }
    }

    public static void playMedia(Scanner scanner) {
        System.out.print("Enter the title of the media: ");
        String title = scanner.nextLine();
        Media media = store.findMediaByTitle(title);

        if (media != null && media instanceof Playable) {
            ((Playable) media).play();
        } else if (media == null) {
            System.out.println("Media not found.");
        } else {
            System.out.println("This media cannot be played.");
        }
    }

    public static void updateStore(Scanner scanner) {
        System.out.println("1. Add a media");
        System.out.println("2. Remove a media");
        System.out.print("Choose an option: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (choice) {
            case 1:
                // Nhập thông tin media mới
                System.out.print("Enter type of media (Book, DVD, CD): ");
                String type = scanner.nextLine();

                System.out.print("Enter title: ");
                String title = scanner.nextLine();

                System.out.print("Enter category: ");
                String category = scanner.nextLine();

                System.out.print("Enter cost: ");
                float cost = scanner.nextFloat();
                scanner.nextLine(); // Consume newline

                // Kiểm tra và nhập thông tin cho từng loại media
                Media media = null;
                if (type.equalsIgnoreCase("Book")) {
                    media = new Book(store.generateId(), title, category, cost);
                } else if (type.equalsIgnoreCase("DVD")) {
                    System.out.print("Enter director: ");
                    String director = scanner.nextLine();

                    System.out.print("Enter length (minutes): ");
                    int length = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    media = new DVD(store.generateId(), title, category, cost, director, length);
                } else if (type.equalsIgnoreCase("CD")) {
                    System.out.print("Enter artist: ");
                    String artist = scanner.nextLine();

                    System.out.print("Enter length (minutes): ");
                    int length = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    media = new CompactDisc(store.generateId(), title, category, cost, length, "Unknown", artist);
                } else {
                    System.out.println("Invalid media type!");
                    break;
                }

                store.addMedia(media);  // Thêm media vào cửa hàng
                System.out.println("Media added to store.");
                break;

            case 2:
                System.out.print("Enter the title of the media to remove: ");
                String titleToRemove = scanner.nextLine();
                store.removeMedia(titleToRemove);
                break;

            default:
                System.out.println("Invalid choice! Please choose again.");
        }
    }

    public static void seeCurrentCart(Scanner scanner) {
        cart.displayCart();
        int choice;

        do {
            cartMenu();
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    cart.filterMedia(scanner);
                    break;
                case 2:
                    cart.sortMedia(scanner);
                    break;
                case 3:
                    cart.removeMedia(scanner);
                    break;
                case 4:
                    cart.playMedia(scanner);
                    break;
                case 5:
                    cart.placeOrder();
                    break;
                case 0:
                    System.out.println("Returning to main menu.");
                    break;
                default:
                    System.out.println("Invalid choice! Please choose again.");
            }
        } while (choice != 0);
    }

    public static void cartMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter medias in cart");
        System.out.println("2. Sort medias in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4-5");
    }
}
