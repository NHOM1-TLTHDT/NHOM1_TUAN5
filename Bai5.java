package BT;

import java.util.Scanner;


public class Bai5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean dk = true;
        int n = 0;
        do {
            try {
                System.out.println("Nhập vào sô phần tử cho mảng");
                n = scanner.nextInt();
                if (n <= 0) {
                    dk = true;
                } else {
                    dk = false;
                }
            } catch (Exception e) {
                System.out.println("Lỗi nhập số phần tử cho maảng");
                scanner.next();
            }
        } while (dk);

        int[] mang = new int[n];
        for (int i = 0; i < mang.length; i++) {
            System.out.print("Nhập vào phần tử thứ " + (i + 1) + ": ");
            mang[i] = scanner.nextInt();
        }
        System.out.println("Các phần tử bạn đã nhập là: ");
        for (int i = 0; i < mang.length; i++) {
            System.out.print(mang[i] + " ");
        }

    }
}
