//find primes less than m
package hongeinh.homework;

import java.util.Scanner;

public class HomeWork7V4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap n: ");
        long n = sc.nextLong();
        PrimeFinding4 primes = new PrimeFinding4();
        //primes.findprime(n, 2);
        primes.calc(n);
    }
}

class PrimeFinding4 {

    /*public long findprime(long n, long i) {
        if (n < 2) {
            System.out.println("Invalid value");
            return 0;
        }
        if (n == 2) {
            System.out.println("Primes: 2");
            return n;
        } else {
            if (i * i > n) {
                System.out.print(n+" ");
            }
            if (n % i == 0) {
            } else {
                return findprime(n, i + 1);  -> dòng gây lỗi
            }
                
            return findprime(n - 1, i);
        }
    }*/
    
    //chỉnh lý bổ sung của ver 3
    //phần calc theo style khác chút 
    public void calc(long n) {
        boolean checked = checkPrime(n, 2);
        //không đặt trong brach sẽ bị StackOverFlow
        if (n >= 2) {
            if (checked == true) {
                System.out.print(n + " ");
            }
        calc(n - 1);
        }

    }

    public boolean checkPrime(long n, long i) {
        if (n < 2) {
            return false;
        }
        if (n == 2) {
            return true;
        }
        if (i * i > n) {      //or i==1 if i decreases from n-1           
            return true;
        }
        if (n % i == 0) {
            return false;
        } else {
            return checkPrime(n, i + 1);
        }
    }
}
