
package hongeinh.homework;

import java.util.Scanner;
public class HomeWorkOneTwoV2{
       
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Insert a: ");
        float a = sc.nextInt();
        System.out.print("Insert b: ");
        float b = sc.nextInt();
        System.out.print("Insert c: ");
        float c = sc.nextInt();
        System.out.print("Insert d: ");
        float d = sc.nextInt();
        
       
        calculate(a,b,c,d);
    }
        
        

 
    public static void calculate(float a, float b, float c, float d) {
        float result1;
        float result2;
        float result3;
       
        
        if (a == 0){
            float deltasq = (float) (c*c-4*b*d);
            if (deltasq == 0){
                result1 = (-c/(2*b)); 
                display1(result1);
            }
            else if (deltasq > 0){
                result1 = (float) ((-c+Math.sqrt(deltasq))/(2*b));
                result2= (float) ((-c-Math.sqrt(deltasq))/(2*b));
                display2(result1, result2);
            }
            else{
                System.out.println("No solution");
            }
        }
        else{
            float deltacb = (float) (b*b -3*a*c);
            float k = (float) ((9*a*b*c - 2*b*b*b - 27*a*a*d)/(2*deltacb*Math.pow(Math.abs(deltacb),3)));
            float  prep1 = (float) ((Math.pow(Math.abs(k)+Math.sqrt(k*k-1),1/3))+(Math.pow(Math.abs(k)-Math.sqrt(k*k-1),1/3)));
            float  prep2 = (float) ((Math.pow(k+Math.sqrt(k*k+1),1/3))+(Math.pow(k-Math.sqrt(k*k+1),1/3)));
           
            if (deltacb>0){
                if (Math.abs(k)>1){
                    result1 = (float) ((2*Math.sqrt(deltacb)*Math.cos(Math.acos(k)/3)-b)/(3*a));
                    result2 = (float) ((2*Math.sqrt(deltacb)*Math.cos(Math.acos(k)/3-(Math.PI*2/3))-b)/(3*a));
                    result3 = (float) ((2*Math.sqrt(deltacb)*Math.cos(Math.acos(k)/3+(Math.PI*2/3))-b)/(3*a));
                    display3(result1,result2,result3);
                }
                else{
                    result1 = (float) (Math.sqrt(deltacb)*Math.abs(k)*prep1/(3*a*k)-(b/3*a));
                    display1(result1);
                }
            }
            else if (deltacb==0){
                if(b*b*b-27*a*a*d == 0){
                    result1 = (-b/3*a);
                    display1(result1);
                }
                else{
                    result1 = (float) ((-b+Math.pow(b*b*b-27*a*a*d,1/3))/(3*a));
                    display1(result1);
                }
            }
            else{
                result1 = (float) (prep2*Math.sqrt(Math.abs(deltacb))/(3*a)-(b/(3*a)));
                display1(result1);
            }
        }
       
        
    }
    public static void display1(float result1){
        
        System.out.println(result1);
    }
    public static void display2(float result1, float result2){
        System.out.println(result1+"\n"+result2);
    }
    public static void display3(float result1, float result2, float result3){
        System.out.println(result1+"\n"+result2+"\n"+result3);
    }
}
                
                
            
   
    

        
   

   


   

        
  
   
