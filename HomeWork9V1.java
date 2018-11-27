//in cac so nguyen to co 5 chu so
package hongeinh.homework;

import java.util.ArrayList;

public class HomeWork9V1 {

    public static void main(String[] args) {
        System.out.println("Cac so nguyen to co 5 chu so la: ");
        FindPrimes primes = new FindPrimes();
        //primes.display(primes.calcBig(primes.calcSmall()));
        primes.display(primes.calculate());
    }
}

class FindPrimes {

    /*public ArrayList calcSmall() {
        ArrayList<Integer> holder = new ArrayList();
        ArrayList<Integer> arr = new ArrayList();
        arr.add(2);
        int isPrime = 3;
        while (isPrime < Math.sqrt(99999)) {
            for (int i = 0; i < arr.size(); i++) {
                int divisor = arr.get(i);
                if (isPrime % divisor == 0) {
                    holder.add(divisor);
                }
            }
            if (holder.isEmpty()) {
                arr.add(isPrime);
            } else {
                holder.removeAll(holder);
            }

            isPrime++;

        }
        return arr;
    }
    public ArrayList calcBig(ArrayList arr){
        ArrayList<Integer> primeList = new ArrayList();
        ArrayList<Integer> holder2 = new ArrayList();
        int isBigPrime = 10001;
        while(isBigPrime < 100000){
            for (int i = 0; i < arr.size(); i++) {
                int divisor = (int) arr.get(i);
                if(isBigPrime % divisor == 0){
                    holder2.add(divisor);
                }
            }
            if(holder2.isEmpty()){
                primeList.add(isBigPrime);
            }else{
                holder2.removeAll(holder2);
            }
        }
        return primeList;
    }*/
    public ArrayList calculate() {
        ArrayList<Long> arr = new ArrayList();

        for (long i = 10000; i <= 99999; i++) {
            arr.add(i);
            for (long j = 2; j <= (long) Math.sqrt(i); j++) {   //ì j>sqrt(i) then j does not divide i
                if (i % j == 0) {//chia het cho so khac ngoai 1 va chinh no
                    arr.remove(i);
                }
            }
        }

        return arr;
    }

    public void display(ArrayList arr) {
        for (int i = 0; i < arr.size(); i++) {
            System.out.print(arr.get(i) + " ");
        }
    }
}
