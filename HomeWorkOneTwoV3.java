
package hongeinh.homework;

import java.util.Scanner;

public class HomeWorkOneTwoV3 implements Calc {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Insert a: ");
        float a = sc.nextFloat();
        System.out.println("Insert b: ");
        float b = sc.nextFloat();
        System.out.println("Insert c: ");
        float c = sc.nextFloat();
        System.out.println("Insert d: ");
        float d = sc.nextFloat();
        
        HomeWorkOneTwoV3 hw = new HomeWorkOneTwoV3();
        hw.calculate(a, b, c, d);
    }
    
   
        
        
    public void calculate(float a, float b, float c, float d) {
        float result1;
        float result2;
        float result3;
       
       
        if (a == 0){
            float deltasq = (float) (c*c-4*b*d);
            if (deltasq == 0){
                result1 = (-c/(2*b)); 
                System.out.println(result1);
                
               
            }
            else if (deltasq > 0){
                result1 = (float) ((-c+Math.sqrt(deltasq))/(2*b));
                result2= (float) ((-c-Math.sqrt(deltasq))/(2*b));
                System.out.println(result1+"\n"+result2);
              
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
                    System.out.println(result1+"\n"+result2+"\n"+result3);
                    
                }
                else{
                    result1 = (float) (Math.sqrt(deltacb)*Math.abs(k)*prep1/(3*a*k)-(b/3*a));
                    System.out.println(result1);
                }
            }
            else if (deltacb==0){
                if(b*b*b-27*a*a*d == 0){
                    result1 = (-b/3*a);
                    System.out.println(result1);
                }
                else{
                    result1 = (float) ((-b+Math.pow(b*b*b-27*a*a*d,1/3))/(3*a));
                    System.out.println(result1);
                }
            }
            else{
                result1 = (float) (prep2*Math.sqrt(Math.abs(deltacb))/(3*a)-(b/(3*a)));
                System.out.println(result1);
            }
        }
        
    }
}
interface Calc{
   public abstract void calculate(float a, float b, float c, float d);
}
     
                
        
             
        
        
  
   
    
        
   

   
                
                    
                    
     
              
        
    

    
       
        
    


        
        
