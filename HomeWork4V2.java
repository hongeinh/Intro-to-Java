
package hongeinh.homework;

import java.util.*;
public class HomeWork4V2 {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Insert positive number: ");
        long n = sc.nextLong();
        System.out.print("Insert base: ");
        byte b =sc.nextByte();
        if(n<0||b <0){
            System.out.println("Please re-enter  positive number or base!");
        }
        
        Mod result = new Mod();
        
        result.modCalc1(n, b);
        result.modCalc2(n, b);
        result.modCalc3(n, b);
        result.modCalc4(n, b);
        result.modCalc5(n, b);
    }
}   

class Mod implements Module{   //for loop String 
    @Override
    public void modCalc1 (long n, byte b) {
        System.out.println("First");
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
        for(int i = arr.length -1;i>0;i--){
            System.out.print(arr[i]+ " "); 
        }
    }
    @Override
    public void modCalc2(long n, byte b){  //while loop 
        System.out.println("\nSecond (ArrayList)");
        long div = n*b*b; //if div = n; div đầu trong loop sẽ là 685 => thiếu giá trị 10965 nếu input n = 10965
        //div = n*b vẫn thiếu một số dư cuối
        long mod = 0;
        String str = " ";
        ArrayList<Long> arr1 = new ArrayList();
        
        while (div >= b){ //nếu div > 0, bị thừa giá trị 0 ở mod dư
            div /= b;  //div đầu = n*b*b / b = n*b
            //System.out.print(div+ " ");
            mod = div%b; //mod đầu = n*b/b lấy dư nên mod đầu = 0    
  
            //System.out.print(mod+ " "); 
            arr1.add(mod);
        }
        for(int i = arr1.size()-1; i>0; i--){
            System.out.print(arr1.get(i)+ " ");
        }
    }
        
    @Override
    public void modCalc3(long n, byte b){   
        System.out.println("\nSecond (String)");   
        
        long div = n*b; //n*b*b thì sẽ bị mod đầu tiên là 0, thừa
        long mod = 0;  //tại sao chỉ string mới bị mà arraylist ko bị ??
        String str = " ";
        while(div >= b){
            div /=b;
            mod =div%b;
            str = (str.concat(Long.toString(mod))).concat(" ");
        }
        String [] arr2  = str.split(" ");
        for(int i = arr2.length-1; i>0; i--){
            System.out.print(arr2[i]+ " ");
        }
    }
    @Override
    public void modCalc4(long n, byte b){  //do while loop
        long div = n*b*b; 
        long mod = 0;
        ArrayList<Long> arr1 = new ArrayList();
        String str = " ";
        
        System.out.println("\nThird (ArrayList)");
        
        do{
            div /= b;
            //System.out.print(div+" ");
            mod = div%b;
            //System.out.print(mod +" ");
            arr1.add(mod);
        }
        while(div >= b);
        for(int i = arr1.size()-1; i>0; i--){
            System.out.print(arr1.get(i)+" ");
        }
    }  
        
    @Override
    public void modCalc5(long n, byte b){
        long div = n*b;
        long mod = 0;
        String str = " ";
        
        System.out.println("\nThird (String)");
        do{
            div /= b;
            mod = div%b;
            str = (str.concat(Long.toString(mod))).concat(" ");
        }
        while(div >= b);
        String[] arr2 = str.split(" ");
        for(int i = arr2.length-1; i>0; i--){
        System.out.print(arr2[i]+" ");
        }  
    }
}    

interface Module{
    void modCalc1(long n, byte b);      
    void modCalc2(long n, byte b);      
    void modCalc3(long n, byte b);      
    void modCalc4(long n, byte b);      
    void modCalc5(long n, byte b);      
  
}           
        
      

                
        
        
                
    
                
                
                
        
            
            
            



        
    
   
       
        
        
        
