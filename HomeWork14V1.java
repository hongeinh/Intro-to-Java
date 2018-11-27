/*   
 * Viết chương trình nhập số nguyên dương n và thực hiện các chức năng sau 
 * tính tổng các chữ số của n
 * phân tích n thành các thừa số nguyên tố
 * liệt kê ước của n
 * liệt kê các ước là số nguyên tố của n
 */
package hongeinh.homework;

import java.util.ArrayList;
import java.util.Scanner;

public class HomeWork14V1 {

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

        SummingDigit sum = new SummingDigit();
        Factorization fact = new Factorization();
        Divisor div = new Divisor();
        PrimeDivisor primeDiv = new PrimeDivisor();

        //Choose program
        System.out.print("\n 1. Sum of digits\n 2. Factorization\n 3. Divisors\n 4. Prime divisor\n 0. Exit\nChoose a program: ");
        do {
            choice = sc.nextInt();
            switch (choice) {
                case 1:

                    sum.display(sum.digiting(num), sum.summing(num));
                    break;
                case 2:

                    fact.display(fact.factoring(num), num);
                    break;
                case 3:
                    div.display(div.dividing(num));
                    break;
                case 4:
                    primeDiv.checkPrime(num);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Wrong value!");
            }
            System.out.println("\n\n");
        } while (choice != 0);
    }
}

class SummingDigit {

    public char[] digiting(int n) {
        String strNum = String.valueOf(n);
        char[] charNum = strNum.toCharArray();
        return charNum;
    }

    public int summing(int n) {
        int flag = 0;
        int remain = 0;
        int sum = 0;
        do {
            remain = n % 10;
            sum = sum + remain;
            n = (n - remain) / 10;
        } while (n != 0);
        return sum;
    }

    public void display(char[] array, int sum) {
        for (int i = 0; i < array.length; i++) {
            if (i != array.length - 1) {
                System.out.print(array[i] + " + ");
            } else {
                System.out.println(array[i] + " = " + sum);
            }
        }
    }
}

class Divisor extends SummingDigit {

    //array here: array will be concat if user chooses an option multiple times
    //ArrayList<Integer> arr = new ArrayList();
    public ArrayList dividing(int n) {
        ArrayList<Integer> arr = new ArrayList();
        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0) {
                arr.add(i);
            }
        }
        return arr;
    }

    public void display(ArrayList array) {

        for (int i = 0; i < array.size(); i++) {
            System.out.print(array.get(i) + " ");
        }
    }
}

class PrimeDivisor extends Divisor {

    public boolean isPrime(int n) {

        if (n == 2) {
            return true;
        }
        int check = 2;
        do {
            if (n % check == 0) {
                return false;
            } else {
                check++;
            }
        } while (check <= Math.sqrt(n));
        return true;
    }

    public void checkPrime(int n) {
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                if (isPrime(i)) {
                    System.out.print(i + " ");
                }
            }
        }
    }
}

class Factorization extends Divisor {

    public ArrayList factoring(int n) {
        ArrayList<Integer> array = new ArrayList();
        int temp = n;
        int isPrimeDiv = 2;
        do {
            if (temp % isPrimeDiv == 0) {
                array.add(isPrimeDiv);
                temp /= isPrimeDiv;
            } else {
                isPrimeDiv++;
            }
        } while (temp > 1);
        return array;
    }

    public void display(ArrayList arr, int num) {
        System.out.print(num + " = ");
        for (int i = 0; i < arr.size(); i++) {
            if (i != arr.size() - 1) {
                System.out.print(arr.get(i) + " * ");
            } else {
                System.out.println(arr.get(i));
            }
        }
    }
}
