//find the nth fibonacci number
package hongeinh.homework;

import java.util.Scanner;
public class HomeWork5V1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = 0;
        do{
            System.out.println("Press 0 to exit.");
            System.out.print("Enter the nth number: ");
            n = sc.nextInt();
            if(n>0){
                Fibonacci2 fin = new Fibonacci2();
                fin.display(fin.calc(n));
                System.out.println("");
            }
        }
        while (n != 0);
    }
}
        
class Fibonacci1{
    public long calc (long n){
        double phi = (1+Math.sqrt(5))/2;
        long nth = (long) ((Math.pow(phi,n)+Math.pow(1-phi, n))/2);
        return nth;
    }
    public void display(long nth){
        System.out.print("Result:"+nth+"\n\n");
    }
}        
class Fibonacci2{
    public long calc(long n){
        long temp1 = 0;
        long temp2 = 1;
        long sum = 0;
        //long sum = temp1+temp2;
        for (int i = 1; i <n; i++){ //1st loop, t1=0, t2=1, sau loop thì t1 = 1, t2=0+1; 2nd loop: t1=1, t2=1+1
            //chạy từ 1->n-1 vì như thế sẽ có n loop tất cả. hơn thì thừa
            //2 mới = 1 cũ + 2 cũ
            //1 mới = 2 cux
            sum = temp1+temp2; //dùng var trung gian tính tổng
            temp1 = temp2; //temp1 mới bằng temp2 cũ
            temp2 = sum;  //temp2 mới bằng tổng temp1 cũ và temp2 cũ
            
        }
        return sum;
    }
    public void display(long i){
        System.out.print("Result: "+i);
    }
}
        
class Fibonacci4{
    public long calc(long n){
        long sum = 0;
        long temp1 = 0;
        long temp2 = 1;
        int i = 1;
        do{
            i++;
            sum = temp1+temp2;
            temp1 = temp2;
            temp2 = sum;
        }
        while (i<n);
        return sum;
    }
    public void display(long i){
        System.out.print("Result: "+i);
    }
}

