
package hongeinh.homework;
import java.util.Scanner;

public class HomeWork1V2 {
    public static void main(String[] args) {
        //
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Insert a: ");
            float a = sc.nextInt();
            System.out.print("Insert b: ");
            float b = sc.nextInt();
            System.out.print("Insert c: ");
            float c = sc.nextInt();
            
            calculate(a,b,c);
        }
    }
    public static void calculate(float a, float b, float c){
        float delta = b*b - 4*a*c;
        if (a!=0){
            if (delta<0){
                System.out.println("No solution");
            }else if (delta > 0){
                float sol1 = (float)((-b +Math.sqrt(delta))/a);
                float sol2 = (float)((-b -Math.sqrt(delta))/a);
                System.out.format("%n2 solutions: %nx = %.2f %nx = %.2f ",sol1,sol2);
            }else{
                System.out.println("One solution: x = " + (b/(a*(-2))));
            }
        }else{
            System.out.println("One solution: x = "+ (c/(-b)));
        }
       
    }    
}
                
                
 

    
