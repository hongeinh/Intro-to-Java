//Tim gcd lcm
//Euclidean algo
//recursive
package hongeinh.homework;

import java.util.Scanner;

public class HomeWork6V3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int option = 0;
        GCD4 gcd = new GCD4();
        do {
            System.out.print("\n  1.Tim UCLN\n  2.Tim BCNN\n  0.Thoat\nChon chuong trinh: ");
            option = sc.nextInt();
            switch (option) {
                case 1:
                    System.out.print("Nhap a: ");
                    long a = sc.nextLong();
                    System.out.print("Nhap b: ");
                    long b = sc.nextLong();
                    gcd.display(gcd.calculate(a, b));
                    break;
                case 2:
                    System.out.print("Nhap a: ");
                    long aa = sc.nextLong();
                    System.out.print("Nhap b: ");
                    long bb = sc.nextLong();
                    long d = Math.abs(aa * bb) / gcd.calculate(aa, bb);
                    gcd.display(d);
                    break;
            }
        } while (option != 0);
    }
}

class GCD4 {

    public long calculate(long a, long b) {
        if (a == 0 || b == 0) {
            return a + b;
        }
        if (a > b) {
            return calculate(a - b, b);
        } else if (a < b) {
            return calculate(a, b - a);
        }
        return a;
    }
        //dung recursive thi ko can loop nua oops oops 
        //dung se thanh thua

    public void display(long n) {
        System.out.print("Ket qua: " + n);
    }
}
