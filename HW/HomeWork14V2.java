/*   
 * Viết chương trình nhập số nguyên dương n và thực hiện các chức năng sau 
 * tính tổng các chữ số của n
 * phân tích n thành các thừa số nguyên tố
 * liệt kê ước của n
 * liệt kê các ước là số nguyên tố của n
 */

 /*
 * ver đơn giản 
 */
package hongeinh.homework;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * Hồng Einh
 */
public class HomeWork14V2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = 0;
        int choice = 0;

        //Enter num
        do {
            System.out.print("Enter a positive number: ");
            num = sc.nextInt();
            if (num <= 0) {
                System.out.println("Wrong value!");
            }
        } while (num <= 0);

        SummingDigit1 sum = new SummingDigit1();
        Factorization1 fact = new Factorization1();
        Divisor1 div = new Divisor1();
        PrimeDiv1 pdiv = new PrimeDiv1();
        //Choose program
        System.out.print("\n 1. Sum of digits\n 2. Factorization\n 3. Divisors\n 4. Prime divisor\n 0. Exit\n");
        do {
            System.out.print("Choose a program: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    sum.summing(num);
                    break;

                case 2:
                    fact.factorizing(num);
                    break;
                case 3:
                    div.findDiv(num);
                    break;
                case 4:
                    pdiv.primeDiv(num);
                case 0:
                    break;
                default:
                    System.out.println("Wrong value!");
            }
            System.out.println("\n\n");
        } while (choice != 0);
    }
}

class SummingDigit1 {

    public void summing(int n) {
        int sum = 0;
        int remain = 0;
        do {
            remain = n % 10;
            sum = sum + remain;
            n = (n - remain) / 10;
            if (n == 0) {
                System.out.print(remain + " = " + sum);
            } else {
                System.out.print(remain + " + ");
            }

        } while (n != 0);
    }
}

class Factorization1 {

    public void factorizing(int n) {
        if (n == 1) {
            System.out.print("1");
        }
        int factor = 2;
        do {
            if (n % factor == 0) {
                n = n / factor;
                if (n == 1) {
                    System.out.print(factor + " ");
                } else {
                    System.out.print(factor + "*");
                }
            } else {
                factor++;
            }
        } while (n > 1);

    }
}

class Divisor1 {

    public void findDiv(int n) {

        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                System.out.print(i + " ");
            }
        }

    }
}

class PrimeDiv1 {

    public void primeDiv(int n) {
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                if (checkPrime(i)) {
                    System.out.print(i + " ");
                }
            }

        }

    }

    public boolean checkPrime(int n) {
        if (n == 2) {
            return true;
        } else {
            int check = 2;
            do {
                if (n % check == 0) {
                    return false;
                } else {
                    check++;
                }
            } while (check <= n / 2);

        }

        return true;
    }
}
