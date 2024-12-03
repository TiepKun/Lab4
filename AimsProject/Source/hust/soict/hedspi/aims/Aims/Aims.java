package hust.soict.hedspi.aims.Aims;

import hust.soict.hedspi.aims.cart.Cart.Cart;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;

public class Aims {

	public static void main(String[] args) {
		// Tạo một giỏ hàng mới
		Cart anOrder = new Cart();

		// Thêm các DVD vào giỏ hàng
		DigitalVideoDisc dvd1 = new DigitalVideoDisc(1, "The Lion King", "Animation", 19.95f, "Roger Allers", 87);
		anOrder.addMedia(dvd1);

		DigitalVideoDisc dvd2 = new DigitalVideoDisc(2, "Star Wars", "Science Fiction", 24.95f, "George Lucas", 87);
		anOrder.addMedia(dvd2);

		DigitalVideoDisc dvd3 = new DigitalVideoDisc(3, "Aladdin", "Animation", 18.99f);
		anOrder.addMedia(dvd3);

		// In tổng chi phí các sản phẩm trong giỏ hàng
		System.out.println("Total cost is: " + anOrder.totalCost());

		// Xóa một DVD khỏi giỏ hàng
		anOrder.removeMedia(dvd1);
		System.out.println("The Lion King is removed from the cart.");
		System.out.println("Total cost after removing dvd1 is: " + anOrder.totalCost());
	}
}
