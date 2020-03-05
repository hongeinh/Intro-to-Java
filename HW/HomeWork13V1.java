/*
 * list out fibonacci numbers smaller than n
 * find fib nums
 * sieve them
 */
package hongeinh.homework;

import java.util.ArrayList;
import java.util.Scanner;

public class HomeWork13V1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 0;
        do {
            System.out.print("Enter positive integer: ");
            n = sc.nextInt();
        } while (n < 0);

        FibPrimeNum result = new FibPrimeNum();
        //result.checkPrime(result.fibNum(n), n);
        //result.display(result.fibNum(n));
        System.out.format("Fib numbers less than %d that are primes: ", n);
        result.display(result.fibNum(n));
    }
}

class FibPrimeNum {

    public ArrayList fibNum(int n) {

        ArrayList<Integer> arrFibPrime = new ArrayList();
        int firstNum = 0;
        int secondNum = 1;
        int sum = 0;
        int temp = 0;   //
        while (temp < n) {    //(sum < n)bug: thừa sum lớn hơn
            temp = sum + secondNum + firstNum;
            sum = firstNum + secondNum;
            if (isPrime(sum)) {
                arrFibPrime.add(sum);
            }
            firstNum = secondNum;
            secondNum = sum;
        }
        return arrFibPrime;
    }

    /* public ArrayList checkPrime(ArrayList arr){
        for (int i = 0; i < arr.size(); i++) {
            int p = (int) arr.get(i);
            if(p<2){
                arr.remove(arr.get(i));
            }else{
                if (true) {
                    
                }
            }
        }
        return arr;
    }*/
    public boolean isPrime(int n) {
        boolean flag = true;

        /*if(n<2){
            flag = false;
        }else if(n == 2){
            flag = true;
        }else{
            if(i*i >n){
                flag = true;
            }
            if(n%i==0){
                flag = false;
            }else{
                return isPrime(n,i+1);
            }
        }*/
        if (n == 2) {
            flag = true;
        }
        if (n % 2 == 0) {
            flag = false;
        }else{
            for (int i = 3; i < Math.sqrt((double) n); i++) {
                if(n%i==0){
                    flag = false;
                }else{
                    flag = true;
                }
            }
                
            }
        
        return flag;
    }

    public void display(ArrayList use) {

        for (int i = 0; i < use.size(); i++) {
            System.out.print(use.get(i) + " ");
        }
    }
    /*public void checkPrime(ArrayList arr, int input){
        System.out.format("Fibonacci numbers less than %d that are primes are: ",input);
        //arr.stream().map((i) -> (int) i).filter((test) -> (isPrime((int)test,2)));
        //functional operation
        for (int i = 0; i<arr.size();i++) {
            //for advance 
            if(isPrime((int)arr.get(i),2)==true){
                System.out.print(i+ " ");
            }
        }
    }*/
}
                    
