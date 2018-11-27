
package hongeinh.homework;
import java.util.Scanner;

public class HomeWork3V2 {
    public static void main(String[] args) {
       Calculate c = new Calculate();
       c.display();
    }
}
class Calculate implements Factorial{
    public void display(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Insert number:");
        int n = sc.nextInt();
        Calculate hw = new Calculate();
        hw.factorial(n);
    }
    @Override
    public void factorial (int n){
        
        int [] arr = new int [n];
        int fac = 1; //vẫn cần 1 cái để lưu kết quả 

        for (int i: arr){
            i++; //moi i thăng 1
            i*=n--; //i sau mỗi loop vẫn bằng 1
            fac = fac*i;
            //n -=1;
            //i=(i++)*n; là i =1*9 nên thiếu 10, thừa 0
            System.out.print(i+"*");
        }
        System.out.print("\nResult: "+ fac+" ");
    }
}
interface Factorial{
    void display();
    void factorial (int n);
}
        
        
        
            
            
