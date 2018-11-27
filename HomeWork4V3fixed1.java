
package hongeinh.homework;
import java.util.*;

public class HomeWork4V3fixed1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Insert number to convert: ");
        long n = sc.nextLong();
        System.out.print("Insert base:");
        byte b = sc.nextByte();
        
        Mod1 m = new Mod1();
        m.reverse(m.modCalc6(n, b));
    }
}

interface Module1{
    void reverse(String [] arr);
    String [] modCalc6(long n, byte b);
}          
    
class Mod1 implements Module1{
    
    @Override
    public String [] modCalc6(long n, byte b){
        
        long mod = 0;
        String str1 = " ";
        
        for(long div = n; div > 0; div /=b){
            //System.out.print(div+ " ");
            mod = div%b;
            //str1 = Long.toString(mod); thì nó sẽ ra những cái String mod riêng biệt 
            str1 = (str1.concat(Long.toString(mod))).concat(" ");  //str = mod+ " ";//lol vì mod không thuộc string
        }
        //System.out.println(str1);
        String [] arr = str1.split(" ");
        //System.out.println(arr);
        return arr;
    }
    @Override
    public void reverse(String [] arr){
        for(int i = arr.length -1;i>0;i--){
            System.out.print(arr[i]+ " "); 
        }
    }
}
        
       
      
       

    
        
    
        
            
            
            
        
        
        
        
      
        
        
       
        
        
        


       
        
        
   
    
