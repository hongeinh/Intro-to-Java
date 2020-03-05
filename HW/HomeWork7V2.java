//find primes less than n
//dùng số sau chia cho chính các số nguyên tố tìm đc
package hongeinh.homework;

import java.util.Scanner;
import java.util.ArrayList;

public class HomeWork7V2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so: ");
        long n = sc.nextInt();

        FindPrime hw1 = new PrimeFinding2();
        hw1.display(hw1.calculate(n));
    }
}

class PrimeFinding2 extends Eratosthenes {

    @Override
    public ArrayList calculate(long n) {
        ArrayList<Long> arr = new ArrayList();
        ArrayList<Long> holder = new ArrayList();
        long prime = 3;

        arr.add(new Long(2));

        do {
            for (int i = 0; i < arr.size(); i++) {
                long divisor = arr.get(i);
                if (prime % divisor == 0) {
                    holder.add(divisor);   //holder ko bh trong
                }
            }
            if (holder.isEmpty()) {
                arr.add(prime);
            } else {
                holder.removeAll(holder);
            }

            prime++;
        } while (prime <= n);

        return arr;
    }
}
