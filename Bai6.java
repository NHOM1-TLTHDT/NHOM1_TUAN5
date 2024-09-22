package BT;

import java.util.Scanner;

public class Bai6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n, chen, them, xoa, c;
        int i;
        do {
            System.out.print("Nhập số phần tử cho mảng: ");
            n = scanner.nextInt();
            if (n < 1) {
                System.out.println("Lỗi nhập dữ liệu!!! Yêu cầu nhập lại");
            }
        } while (n < 1);
        int[] mang = new int[n];

        for (i = 0; i < mang.length; i++) {
            System.out.print("Nhập số phần tử thứ " + i + ": ");
            mang[i] = scanner.nextInt();
        }
        System.out.print("Bạn muốn chèn vào phần tử thứ mấy: ");
        chen = scanner.nextInt();

        int m = n + 1;
        int[] mangmoi = new int[m];
        for (i = 0; i < chen; i++) {
            mangmoi[i] = mang[i];
        }
        System.out.print("Nhập vào phần tử bạn muốn chèn: ");
        them = scanner.nextInt();
        mangmoi[chen] = them;
        for (i = chen; i < n; i++) {
            mangmoi[i + 1] = mang[i];
        }

        System.out.print("Mảng sau khi bạn thêm phần tử là: ");
        for (i = 0; i < mangmoi.length; i++) {
            System.out.print(mangmoi[i] + " ");
        }

        System.out.print("\nNhập số vị trí phần tử bạn muốn xóa: ");
        xoa = scanner.nextInt();
        for (c = i = 0; i < mangmoi.length; i++) {
            if (xoa != i) {
                mangmoi[c] = mangmoi[i];
                c++;
            }
        }
        m = c;
        System.out.print("Mảng sau khi xóa phần tử thứ " + xoa + " là: ");
        for (c = 0; c < m; c++) {
            System.out.print(mangmoi[c] + " ");
        }
    }
}