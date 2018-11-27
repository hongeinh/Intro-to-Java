//find prime up to n
//use modulo
//sieve of Eratosthenes
//segmented sieve (find primes in a range)
package hongeinh.homework;

import java.util.Scanner;
import java.util.ArrayList;

public class HomeWork7V1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so: ");
        long n = sc.nextInt();
        FindPrime hw = new Eratosthenes();
        FindPrime hw1 = new PrimeFinding1();
        hw1.display(hw1.calculate(n));
    }
}

interface FindPrime {

    public ArrayList calculate(long n);

    public void display(ArrayList arr);
}

class Eratosthenes implements FindPrime {

    @Override
    public ArrayList calculate(long n) {
        ArrayList<Long> arr = new ArrayList();
        for (long i = 2; i <= n; i++) {  //sieve of eratosthenes
            arr.add(i);  //lay tat ca cac so nho hon n
        }

        for (int i = 0; i < arr.size(); i++) {
            //for (long i = 2; i < n; i++) {  //start w 2
            long p = arr.get(i);  //take every element
            for (int j = 2; j < n; j++) {
                arr.remove(j * p);  //lay tung so trong arr, nhan len lan luot 2p,3p,4p,..
            }
        }
        return arr;
    }

    @Override
    public void display(ArrayList arr) {
        for (int i = 0; i < arr.size(); i++) {
            System.out.print(arr.get(i) + " ");
        }
    }
}

class PrimeFinding1 extends Eratosthenes {

    @Override
    public ArrayList calculate(long n) {
        ArrayList<Long> arr = new ArrayList();
        //3 loop dai qua
        for (long i = 2; i <= n; i++) {
            arr.add(i);
            for (long j = 2; j <= (long) Math.sqrt(i); j++) {   //ì j>sqrt(i) then j does not divide i
                if (i % j == 0) {//chia het cho so khac ngoai 1 va chinh no
                    arr.remove(i);
                }
            }
        }
        return arr;
    }
}


