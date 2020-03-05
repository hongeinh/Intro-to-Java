
package hongeinh.homework;

import java.util.Scanner;
public class HomeWorkOneTwoV4 extends Calcu{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Insert a: ");
        double a = sc.nextFloat();
        System.out.print("Insert b: ");
        double b = sc.nextFloat();
        System.out.print("Insert c: ");
        double c = sc.nextFloat();
        System.out.print("Insert d: ");
        double d = sc.nextFloat();
        
        Calcu hw = new Calcu();
        hw.display(hw.calculate(a,b,c,d));
    }
}
        
class Calcu implements Usage{
    double[] arr1 = new double[3];
        
    @Override
    public double[] calculate(double a, double b, double c, double d){
        
        
        if (a == 0){
            double deltasq = (double) (c*c-4*b*d);
            if (deltasq == 0){
                arr1[0] = (-c/(2*b)); 
                
            }
            else if (deltasq > 0){
            arr1[0] =  ((-c+Math.sqrt(deltasq))/(2*b)) ;
            arr1[1] = ((-c-Math.sqrt(deltasq))/(2*b));
                
            }
            else{
                System.out.println("No solution");
            }
        }
        
        else{
            double deltacb = (b*b -3*a*c);
            double k = ((9*a*b*c - 2*b*b*b - 27*a*a*d)/(2*deltacb*Math.pow(Math.abs(deltacb),3)));
            double  prep1 =  ((Math.pow(Math.abs(k)+Math.sqrt(k*k-1),1/3))+(Math.pow(Math.abs(k)-Math.sqrt(k*k-1),1/3)));
            double  prep2 =  ((Math.pow(k+Math.sqrt(k*k+1),1/3))+(Math.pow(k-Math.sqrt(k*k+1),1/3)));
           
            if (deltacb>0){
                if (Math.abs(k)>1){
                    arr1[0] = ((2*Math.sqrt(deltacb)*Math.cos(Math.acos(k)/3)-b)/(3*a));
                    arr1[1] =  ((2*Math.sqrt(deltacb)*Math.cos(Math.acos(k)/3-(Math.PI*2/3))-b)/(3*a));
                    arr1[2] =  ((2*Math.sqrt(deltacb)*Math.cos(Math.acos(k)/3+(Math.PI*2/3))-b)/(3*a));
                }
                else{
                    arr1[0] =  (Math.sqrt(deltacb)*Math.abs(k)*prep1/(3*a*k)-(b/3*a));
                }
            }
            else if (deltacb==0){
                if(b*b*b-27*a*a*d == 0){
                    arr1[0] = (-b/3*a);
                }
                else{
                    arr1[0] = ((-b+Math.pow(b*b*b-27*a*a*d,1/3))/(3*a));
                }
            }
            else{
                arr1[0] = (prep2*Math.sqrt(Math.abs(deltacb))/(3*a)-(b/(3*a)));
            }
        }
        return arr1;
    }
    @Override
    public void display(double [] arr1){
        for(double i: arr1){
            System.out.println(i);
        }
    }
}

interface Usage{
    double [] calculate(double a, double b, double c, double d);
    void display(double [] arr1);
}
                
   

        
        
        
       
       
                
        
    
        
    
             
               
              
             
                    
                    
   
   
    


              
                
               
   
   
    
