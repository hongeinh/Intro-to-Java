
package hongeinh.homework;
import java.util.Scanner;

public class HomeWork3V1 {
   
    public static void main(String[] args) {
        
        try(Scanner sc = new Scanner(System.in)){
        System.out.println("Enter n: ");
        int n = sc.nextInt();
        factorial1(n);
        factorial2(n);
        factorial3(n);
        factorial4(n);
        factorial5(n);
        factorial6(n);
        }
    }
     
     
    public  static void factorial1 (int n){
        System.out.println("\r\nFirst");
        if (n <0){
            System.out.println("Invalid value.\r\n");
        }
        else if (n == 0){
            System.out.println("The factorial fuction of 0 is 1\r\n");
        }
        else{
            int result = 1;
            //for (int i -; i < n; i++){
                //i = i -1; -->đã tăng lại còn giảm
                //sai logic
                for ( int i = 1; i <= n; i++ ){
                    System.out.print(i+" ");
                    result = result*i;
                    /* System.out.println("Result "+ result); */

                }
            System.out.println("\r\nResult: "+ result+"\r\n");
        }
    }
           
    public static void factorial2(int n){
        System.out.println("Second");
        if (n <0){
            System.out.println("Invalid value. \r\n");
        }
        else if (n == 0){
            System.out.println("The factorial fuction of 0 is 1\r\n");
        }
        else{
            int result = 1;
                for ( int i = n; i >0; i -- ){
                    System.out.print(i+" ");
                    result = result*i;
                }
            System.out.println("\r\nResult: "+ result+"\r\n");
        }
    }
    
    public static void factorial3(int n){
        System.out.println("Third");
        if(n>=0){
            int result = 1;
            int i = 0;
            while(i<n){
                i++;
                System.out.print(i+" ");
                result=result*i;
            }      
            System.out.println("\r\nResult: "+result+"\n");
        }
        else {
            System.out.println("Invalid value\r\n");
         }
     }
         
    public static void factorial4(int n){
        if(n>=0){
            System.out.println("Fourth");
            int result = 1;
            int i = n+1 ; /*i=n thì sẽ thiếu chính n*/
            while(i>=2){ /*i>=1 thì kqua là 0*/
                i--;
                System.out.print(i+" ");
                result = result *i;
            }
            System.out.println("\r\nResult: "+result +"\n");
        }
        else{
            System.out.println("Invalid value.\r\n");
        }
    }
    
    public static void factorial5(int n){
        System.out.println("Fifth");
        if (n<0){
            System.out.println("Invalid value.\r\n");
        }
        else{
            int i = 0;
            int result = 1;
            do{
                i++; 
                System.out.print(i+" ");
                result=result*i;
            }
            while (i<n);
                System.out.println("\r\nResult: "+result+"\r\n");
            }
    }

    public static void factorial6(int n){
        System.out.println("Six");
        if (n<0){
            System.out.println("Invalid value.\r\n");
        }
        else{
            int i = n+1;
            int result = 1;
            do{
                i--; 
                System.out.print(i+" ");
                result=result*i;
            }
            while (i>1);
                System.out.println("\r\nResult: "+result+"\r\n");
            }
        }
}
    
        
        
       
                
        
            
            
        
               

            
            
    

        
     
      
     
                        
        
           
            
                        

                        


                   
                        
             
                
             
                 
            
              
           
          
           
            
            
            
        
    

        
