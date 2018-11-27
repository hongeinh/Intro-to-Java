
package hongeinh.homework;

import java.util.*;
public class HomeWork124 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter a of equation: ");
        double a =sc.nextFloat();
        System.out.print("Enter b of equation: ");
        double b = sc.nextFloat();
        System.out.print("Enter c of equation: ");
        double c = sc.nextFloat();
        System.out.print("Enter d of equation: ");
        double d =sc.nextFloat();
        
        System.out.print("Enter number to convert: ");
        long n = sc.nextLong();
        System.out.print("Enter base: ");
        byte base = sc.nextByte();
        
        HW124 hw = new HW124();
        hw.display(hw.calculate(a, b, c, d),hw.convert(n, base));
    }
}
interface ChangeConvert{
      ArrayList calculate(double a, double b, double c, double d);
      ArrayList convert(long n, byte base );
      void display(ArrayList arr1,ArrayList arr2);
}
class HW124 implements ChangeConvert{
    @Override
    public ArrayList calculate(double a, double b, double c, double d){
        ArrayList<Double> arr1 = new ArrayList();
        double result1 = 0;
        double result2 = 0;
        double result3 = 0;
        if(a == 0){
            double delta2 = c*c-4*b*d;
            if(delta2 < 0){
                System.out.println("No solution");
            }
            else if(delta2 == 0){
                result1 = (-c)/(2*b);
                arr1.add(result1);
            }
            else{
                result1 = (-c+Math.sqrt(delta2))/(2*a);
                result2 = (-c-Math.sqrt(delta2))/(2*a);
                arr1.add(result1);
                arr1.add(result2);
            }
            return arr1;
        }
        else{
            double delta3 = b*b-3*a*c;
            double k = (9*a*b*c-2*b*b*b-27*a*a*d)/(2*Math.pow(Math.abs(delta3),3/2));
            double prep1 = Math.pow(Math.abs(k)+Math.sqrt(k*k-1),1/3)+Math.pow(Math.abs(k)-Math.sqrt(k*k-1),1/3);
            double prep2 = Math.pow(k+Math.sqrt(k*k+1),1/3)+Math.pow(k-Math.sqrt(k*k+1),1/3);
            if (delta3 >0){
                if (Math.abs(k)<1){
                    result1 = (2*Math.sqrt(delta3)*Math.cos(Math.acos(k)/3)-b)/(3*a);
                    result2 = (2*Math.sqrt(delta3)*Math.cos(Math.acos(k)/3-(2*Math.PI/3))-b)/(3*a);
                    result3 = (2*Math.sqrt(delta3)*Math.cos(Math.acos(k)/3+(2*Math.PI/3))-b)/(3*a);
                    arr1.add(result1);
                    arr1.add(result2);
                    arr1.add(result3);
                }
                else{
                    result1 = (Math.sqrt(delta3)*Math.abs(k)*prep1)/(3*a*k)-(b/(3*a));
                    arr1.add(result1);
                }
            }
            else if(delta3 == 0){
                if (b*b*b-27*a*a*d == 0){
                    result1 = (-b)/(3*a);
                    arr1.add(result1);
                }
                else{
                    result1 = (-b+Math.pow(b*b*b-27*a*a*d,1/3))/(3*a);
                    arr1.add(result1);
                }
            }
            else{
               result1 = (Math.sqrt(delta3)*prep2)/(3*a)-(b/(3*a));
               arr1.add(result1);
            }
        return arr1;
        }
    }
    @Override
    public ArrayList convert(long n, byte base){
        ArrayList<Long> arr2 = new ArrayList();
        long mod = 0;
        for(long div = n; div>0;div/=base){
            mod = div%base;
            arr2.add(mod);
        }
        return arr2;
    }
    @Override
    public void display(ArrayList arr1, ArrayList arr2){
        System.out.println("Result of equation");
        for(int i = arr1.size()-1; i>=0; i--){ //nếu i>0 thì bị mất giá trị đầu tiên của arr1
            System.out.print(" "+arr1.get(i));
        }
        System.out.println("\nResult of conversion");
        for(int i = arr2.size()-1; i>=0; i--){
            System.out.print(arr2.get(i)+" ");
        }
    }
        
}
 
