
package hongeinh.homework;

import java.util.*;
public class HomeWork4V1  {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Insert number: ");
        long n = sc.nextLong();
        System.out.print("Insert base: ");
        byte b = sc.nextByte();
       
        HomeWork4V1 hw = new HomeWork4V1();
        hw.change(n, b);
        
            
        
        
    }
   
    public ArrayList change(long n, byte b){
        long mod = 0;
         ArrayList<Long> arr = new ArrayList();
      
       // String c = "";
        for(long div = n; div > 0; div/=b){
            
            //lúc print hay println cả div và mod bị đan xen nhau?
            // System.out.println("\n"); //=> bị in thành hàng dọc đan xen div mod
            //tốt nhất không in ra div
             mod = div%b;
             arr.add(mod);
             //System.out.print(a+ " ");
        }
        for(int i = arr.size()-1;i>=0; i--){   //trong arraylist thì dùng size ko dùng length 
            System.out.print(arr.get(i)+" ");   //get là để lấy phần tử với index là i
        }
        return arr ;
        
            
        
    }
}
      
       
             
            
        
   
   
       
            
        
        
                
            
            
            
            
        
        
            
                    
       
        
            
            
      

        
            
                    
            

   
            
                
                
            
        
        
            
            
            

        

