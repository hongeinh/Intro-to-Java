//tìm UCLN BCNN
//Stein's Algo
package hongeinh.homework;

import java.util.Scanner;

public class HomeWork6V2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int option = 0;
        GCD3 rs = new GCD3();
        do {
            System.out.print("  1.Tim UCLN\n  2.Tim BCNN\n  0.Thoat\nChon chuong trinh: ");
            option = sc.nextInt();

            switch (option) {
                case 1:
                    System.out.print("Nhap so dau tien: ");
                    long a = sc.nextLong();
                    System.out.print("Nhap so thu hai: ");
                    long b = sc.nextLong();
                    rs.display(rs.calculate(a, b));
                    break;
                case 2:
                    System.out.print("Nhap so dau tien: ");
                    long aa = sc.nextLong();
                    System.out.print("Nhap so thu hai: ");
                    long bb = sc.nextLong();
                    long lcm = (aa * bb) / rs.calculate(aa, bb);
                    rs.display(lcm);
                    break;
            }
        } while (option != 0);
    }
}

class GCD3 {

    public long calculate(long a, long b) {

        if (a == 0 || b == 0) {
            return a + b;
        }

        /*if (a % b == 0) {
                return b;
            } else if (b % a == 0) {
                return a;
            }*/
        if (a != b) {
            if (a % 2 == 0 && b % 2 == 0) {
                return calculate(a / 2, b / 2);
            } else if (a % 2 == 0 && b % 2 == 1) {
                return calculate(a / 2, b);
            } else if (a % 2 == 1 && b % 2 == 0) {
                return calculate(a, b / 2);
            } else {
                if (a > b) {
                    return calculate((a - b) / 2, b);
                } else if (a < b) {
                    return calculate(a, (b - a) / 2);
                }
            }
        }

        return a;
    }

    public void display(long n) {
        System.out.println("Ket qua: " + n + "\n");
    }
}
