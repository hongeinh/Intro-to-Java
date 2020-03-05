//find primes less than n
package hongeinh.homework;

import java.util.Scanner;
//import java.util.ArrayList;

public class HomeWork7V3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap n: ");
        long n = sc.nextLong();
        PrimeFinding3 hw = new PrimeFinding3();
        //hw.checkPrime(n, 2);
        //hw.isPrime(hw.checkPrime(n, 2));
        //hw.display(hw.calc(n, hw.checkPrime(n, n-1)));
        //hw.checkPrime(hw.calc(n), n-1);
        hw.calc(n);
    }
}

class PrimeFinding3 extends Eratosthenes {

    public void calc(long n) {
        for (long j = 2; j <= n; j++) {
            boolean checked = checkPrime(j, 2);
            if (checked == true) {
                System.out.print(j + " ");
            }
        }
    }

    public boolean checkPrime(long n, long i) {
        if(n<2){
            return false;
        }
        if(n ==2){
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


    /*public void isPrime(boolean isPrime) {
        if (isPrime == true) {
            System.out.println("Prime");
        } else {
            System.out.println("Not Prime");
        }
    }*/
}
