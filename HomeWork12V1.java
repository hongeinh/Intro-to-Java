/*
 *tim so thuan nghich co 6 chu so
 *palindrome
 *cach vo hoc :))))))))
 */
package hongeinh.homework;


public class HomeWork12V1 {

    public static void main(String[] args) {
        ReversibleNum1 result = new ReversibleNum1();
        /*int test = 1965;
        System.out.println( Integer.reverse(test));   --> test reverse()
        *reverse(): đảo bit trong bù 2 của số này
         */
        System.out.println("6-digit palindromes are: ");
        result.checkReverse();

    }
}

class ReversibleNum1 {

    public boolean isReversible(int n) {

        boolean reversible = false;
        if (n % 10 == 0 || n % 11 != 0) {
            return false;
        }
        String strNum = String.valueOf(n);
        char[] digit = strNum.toCharArray();

        //number in form:  abccba
        /* int a = n%100000;  //so cuoi      
        int b = (n-a)%10000;   //so giua            ---->sai logic
        int c = (n-a-b)%100;    //so dau
        if(n - 100000*a - 10000*b - 1000*c == 100*c + 10*b + a){
           return true;                         
        }*/
        //number: abcdef
        int f = n%10;
        int e = ((n-f)%100)/10;
        int d = ((n-10*e-f)%1000)/100;
        int c = ((n-100*d-10*e-f)%10000)/1000;
        int b = ((n-1000*c-100*d-10*e-f)%100000)/10000;
        int a = n/100000;

        if(a == f && b == e && c == d){
            reversible = true;
        }
        
        return reversible;
    }

    public void checkReverse() {
        int i = 100001;
        do{
            if(isReversible(i)){
                System.out.print(i+" ");
            }
            i++;
        }while(i<1000000);
    }
}
          

        
