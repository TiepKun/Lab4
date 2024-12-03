package hust.soict.hedspi.aims;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;
import hust.soict.hedspi.aims.store.Store;

import java.util.Scanner;

public class Aims {
    private static Store store = new Store();
    private static Cart cart = new Cart();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
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
                // Logic to add media to the store
                System.out.println("Adding media to store...");
                break;
            case 2:
                System.out.print("Enter the title of the media to remove: ");
                String title = scanner.nextLine();
                store.removeMedia(title);
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
