package hust.soict.hedspi.test.disc.TestPassingParameter;

import hust.soict.hedspi.aims.media.DigitalVideoDisc;

public class TestPassingParameter {
    public static void main(String[] args) {
        // Tạo hai đối tượng DVD
        DigitalVideoDisc jungleDVD = new DigitalVideoDisc(1, "Jungle", "Adventure", 15.99f);
        DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc(2, "Cinderella", "Animation", 12.99f);

        // Test phương thức swap
        System.out.println("Before swap:");
        System.out.println("jungleDVD title: " + jungleDVD.getTitle());
        System.out.println("cinderellaDVD title: " + cinderellaDVD.getTitle());

        // Ghi chú: Phương thức này sẽ không thay đổi tham chiếu gốc
        swapTitles(jungleDVD, cinderellaDVD);

        System.out.println("After swap:");
        System.out.println("jungleDVD title: " + jungleDVD.getTitle());
        System.out.println("cinderellaDVD title: " + cinderellaDVD.getTitle());

        // Test phương thức changeTitle
        changeTitle(jungleDVD, cinderellaDVD.getTitle());
        System.out.println("After changeTitle:");
        System.out.println("jungleDVD title: " + jungleDVD.getTitle());
    }

    /**
     * Phương thức hoán đổi tiêu đề giữa hai DVD
     * Lưu ý: Chỉ thay đổi giá trị thuộc tính, không thay đổi tham chiếu gốc.
     */
    public static void swapTitles(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
        String tempTitle = dvd1.getTitle();
        dvd1.setTitle(dvd2.getTitle());
        dvd2.setTitle(tempTitle);
    }

    /**
     * Phương thức thay đổi tiêu đề của DVD
     * Tham chiếu mới được tạo bên trong phương thức sẽ không ảnh hưởng tới đối tượng ban đầu.
     */
    public static void changeTitle(DigitalVideoDisc dvd, String newTitle) {
        dvd.setTitle(newTitle); // Thay đổi tiêu đề của đối tượng gốc
    }
}
