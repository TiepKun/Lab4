package hust.soict.hedspi.aims.cart;

import hust.soict.hedspi.aims.media.Media;

import java.util.ArrayList;
import java.util.Scanner;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private ArrayList<Media> itemsOrdered = new ArrayList<>();

    // Phương thức hiển thị giỏ hàng
    public void displayCart() {
        System.out.println("*********************** CART ***********************");
        System.out.println("Ordered Items:");
        int index = 1;
        for (Media media : itemsOrdered) {
            System.out.println(index + ". " + media.toString());
            index++;
        }
        System.out.println("Total cost: " + totalCost() + " $");
        System.out.println("***************************************************");
    }

    // Thêm Media vào giỏ hàng
    public void addMedia(Media media) {
        if (itemsOrdered.size() < MAX_NUMBERS_ORDERED) {
            itemsOrdered.add(media);
            System.out.println("The media has been added: " + media.getTitle());
        } else {
            System.out.println("The cart is full.");
        }
    }
    public void removeMedia(Scanner scanner) {
        System.out.print("Enter the title of the media to remove: ");
        String title = scanner.nextLine();
        Media mediaToRemove = findMediaByTitle(title);

        if (mediaToRemove != null) {
            itemsOrdered.remove(mediaToRemove);
            System.out.println("The media has been removed: " + mediaToRemove.getTitle());
        } else {
            System.out.println("Media not found in the cart: " + title);
        }
    }

    // Tính tổng chi phí
    public float totalCost() {
        float total = 0;
        for (Media media : itemsOrdered) {
            total += media.getCost();
        }
        return total;
    }

    // Lọc sản phẩm theo tiêu chí
    public void filterMedia(Scanner scanner) {
        System.out.println("Filter options:");
        System.out.println("1. By title");
        System.out.println("2. By cost range");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (choice) {
            case 1:
                System.out.print("Enter title to search: ");
                String title = scanner.nextLine();
                searchByTitle(title);
                break;
            case 2:
                System.out.print("Enter minimum cost: ");
                float minCost = scanner.nextFloat();
                System.out.print("Enter maximum cost: ");
                float maxCost = scanner.nextFloat();
                for (Media media : itemsOrdered) {
                    if (media.getCost() >= minCost && media.getCost() <= maxCost) {
                        System.out.println(media.toString());
                    }
                }
                break;
            default:
                System.out.println("Invalid option!");
        }
    }

    // Sắp xếp sản phẩm
    public void sortMedia(Scanner scanner) {
        System.out.println("Sort options:");
        System.out.println("1. By title");
        System.out.println("2. By cost");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();

        itemsOrdered.sort((media1, media2) -> {
            if (choice == 1) {
                return media1.getTitle().compareToIgnoreCase(media2.getTitle());
            } else if (choice == 2) {
                return Float.compare(media1.getCost(), media2.getCost());
            }
            return 0;
        });

        System.out.println("Cart sorted successfully!");
    }

    // Chơi media trong giỏ hàng
    public void playMedia(Scanner scanner) {
        System.out.print("Enter the title of the media to play: ");
        String title = scanner.nextLine();
        Media media = findMediaByTitle(title);

        if (media != null && media instanceof hust.soict.hedspi.aims.media.Playable) {
            ((hust.soict.hedspi.aims.media.Playable) media).play();
        } else if (media == null) {
            System.out.println("Media not found.");
        } else {
            System.out.println("This media cannot be played.");
        }
    }

    // Đặt hàng
    public void placeOrder() {
        if (!itemsOrdered.isEmpty()) {
            System.out.println("Your order has been placed successfully!");
            itemsOrdered.clear();
        } else {
            System.out.println("Your cart is empty.");
        }
    }

    // Tìm Media theo tiêu đề
    private Media findMediaByTitle(String title) {
        for (Media media : itemsOrdered) {
            if (media.getTitle().equalsIgnoreCase(title)) {
                return media;
            }
        }
        return null;
    }

    // Tìm kiếm Media theo tiêu đề
    public void searchByTitle(String title) {
        boolean found = false;
        for (Media media : itemsOrdered) {
            if (media.getTitle().equalsIgnoreCase(title)) {
                System.out.println("Media found: " + media.toString());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No media found with title: " + title);
        }
    }
}
