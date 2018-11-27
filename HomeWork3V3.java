
package hongeinh.homework;

import java.util.Scanner;
public class HomeWork3V3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        long n = sc.nextLong();
        
        HW3V3 t = new HW3V3();
        t.display(t.factorial(n));
    }
}
class HW3V3{
    public long factorial (long n){
        if(n==1){
            return 1;
        }
        else{
            return n*factorial(n-1);
        }
    }
    public void display(long i){
        System.out.println("Reuslt:  "+i);
    }
}