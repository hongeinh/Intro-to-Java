
package hongeinh.homework;

import java.util.Scanner;


public class HomeWork2V1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Insert a: ");
        float a = sc.nextFloat();
        System.out.print("Insert b: ");
        float b = sc.nextFloat();
        System.out.print("Insert c: ");
        float c = sc.nextFloat();
        System.out.print("Insert d: ");
        float d = sc.nextFloat();
        
        calculate(a,b,c,d);
        
    }
    public static void calculate(float a, float b, float c, float d){
       
       float delta2 = (float) (c*c-4*b*d) ;  
       float delta3 = (float) (b*b -3*a*c);
       float k = (float) ((9*a*b*c - 2*b*b*b - 27*a*a*d)/(2*delta3*Math.sqrt(delta3)));
       float  prep1 = (float) (Math.pow(Math.abs(k)+Math.sqrt(k*k-1),1/3));
       float  prep2 = (float) (Math.pow(Math.abs(k)-Math.sqrt(k*k-1),1/3));
      
       
       if(a==0){
           if (b!=0){
               System.out.println("Khong phai phuong trinh bac 2");
           
               if(delta2<0){
                   System.out.println("No solution");
               }else if (delta2>0){
                    float squaresol1 = (float)((-c +Math.sqrt(delta2))/(2*b));
                    float squaresol2 = (float)((-c -Math.sqrt(delta2))/(2*b));
                    System.out.format("%n2 solutions: %nx = %.2f %nx = %.2f ",squaresol1,squaresol2);
               }else {
                   System.out.println("One solution: x = "+(-c/2*b));
               }
           }else {
               System.out.println("one solution x = "+ (c/-d));
            }
           
       }else {
            if (delta3 > 0){
                if (Math.abs(k)<1){
                    float cubesol1 = (float) ((((float)Math.cos((float) (Math.acos ((float)k)))/3)*2*Math.sqrt(delta3)-b)/(a*3));
                    float cubesol2 = (float) (((float)Math.cos(((float) (Math.acos ((float)k)))/3 - (2*Math.PI)/3)*2*Math.sqrt(delta3)-b)/(a*3));
                    float cubesol3 = (float) (((float)Math.cos(((float) (Math.acos ((float)k)))/3 + (2*Math.PI)/3)*2*Math.sqrt(delta3)-b)/(a*3));
                    System.out.format("3 solutions:%nx = %.2f %nx = %.2f %nx = .2f",cubesol1,cubesol2,cubesol3);
                }else if (Math.abs(k)>=1){
                    
                    float cubesol4 = (float) ((((Math.sqrt(delta3)*Math.abs(k))/(3*a*k))*(prep1 + prep2))-(b/(2*a)));
                }
            }else if (delta3 == 0){
                 
                if( b*b*b -27*a*a*d == 0){
                    System.out.println("One solution: x = "+ (b/(-3*a)));
                } else { 
                    float cubesol5 = (float) ((Math.pow(b*b*b-a*a*d*27,1/3)-b)/(3*a));
                    System.out.println("One solution: x = " + cubesol5);
                    
                }
            }else {
                float cubesol6 = (float) ((prep1 + prep2)*((Math.sqrt(Math.abs(k)))/(3*a))-(b/(3*a)));
                System.out.println("One solution: x = " + cubesol6);
            }    
         }
    }
}
    
       
        
                    
                
               
               
               

