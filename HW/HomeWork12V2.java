/*
 * find reversible numbers (6-digit)
 * ver 2
 * using []
 */
package hongeinh.homework;

import java.lang.reflect.Array;

public class HomeWork12V2 {
    public static void main(String[] args) {
        ReversibleNum2 num = new ReversibleNum2();
        System.out.println("6-digit palindromes are: ");
        num.checkReverse();
    }
}
class ReversibleNum2 extends ReversibleNum1{
    @Override
    public boolean isReversible(int n){
        boolean reversible = false;
        String numString = Integer.toString(n);
        char[] numArr = numString.toCharArray();
        
        //check digits if equal
        if(Array.get(numArr, 0).equals(Array.get(numArr, 5)) && Array.get(numArr, 1).equals(Array.get(numArr, 4)) && Array.get(numArr, 2).equals(Array.get(numArr, 3))){
            reversible = true;
        }
        
        return reversible;
    }
    /*
        public void checkReverse() {
        int i = 100001;
        do{
            if(isReversible(i)){
                System.out.print(i+" ");
            }
            i++;
        }while(i<1000000);
    }
    */
}