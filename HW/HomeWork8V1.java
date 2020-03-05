//find prime up to n primes
//ko chia hết cho số <= căn, chỉ cho 1 và chính nó 
package hongeinh.homework;

import java.util.Scanner;
import java.util.ArrayList;

public class HomeWork8V1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so: ");
        int n = sc.nextInt();
        GetPrime1 primeFound = new GetPrime1();
        primeFound.display(primeFound.calculate(n));
    }
}

class GetPrime1 extends Eratosthenes {   //kế thừa display(..) của Eratosthenes

    public ArrayList calculate(int n) {
        ArrayList<Integer> arr = new ArrayList();
        ArrayList<Integer> holder = new ArrayList();
        int prime = 5;
        if (n == 1) {
            arr.add(2);
        } else if (n < 1) {
            return null;
        } else {
            arr.add(2);
            arr.add(3);
            while (arr.size() < n) {
                /*double squareRoot = Math.sqrt(prime); 
                for(int i = 1;i<=squareRoot;i++){   2, 3 ko    10 lại được, 11 bị lặp
                    if(prime%i!=0){
                        arr.add(prime);
                    }
                }
                for (int i = 2; i<prime-1; i++){   //lăp lại prime nhiều lần nếu các i đều ko divide prime
                    if(prime%i!=0){
                        arr.add(prime);
                    }
                }*/
                /*for (int i = 2; i <= prime/2; i++) {
                    //đút các số 2->n-2 vào holder
                    if (prime % i == 0) {
                        holder.add(i); //  hold danh sách i divides prime
                    }
                }

                if (holder.isEmpty()) {   
                    arr.add(prime);  //holder rỗng == prime ko chia hết từ 2 - prime-2
                }
                prime += 1;*/
                for(int i=0;i<arr.size();i++){    //check xem cái số có chia cho bất kỳ số nguyên tố nào ko
                    int divisor = arr.get(i);
                    if(prime%divisor == 0){
                        holder.add(divisor);  //có thì add vào holder
                    }
                }
                if(holder.isEmpty()){  //ko có nghĩa là nó cũng là nguyên tố
                    arr.add(prime);
                }
                else{
                    holder.removeAll(holder);
                }
                prime ++;
            }
        }
        return arr;
    }
}
