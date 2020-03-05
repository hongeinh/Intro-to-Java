/*
 *sum of digits of an integer 
 *ver2
 */
package hongeinh.homework;

import java.lang.reflect.Array;
import java.util.Scanner;

public class HomeWork11V2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = 0;

        do {
            System.out.println("Enter a positive integer: ");
            num = sc.nextInt();
        } while (num == 0);
        SumDigit2 sum2 = new SumDigit2();
        sum2.display(num, sum2.digiting1(num), sum2.summing2(num));
    }
}

class SumDigit2 extends SumDigit{

    public char[] digiting1(int n) {
        //valueOf(int n) chuyển int n thành 1 string. Giống Integer.toString
        String strNum = String.valueOf(n);
        char[] digit = strNum.toCharArray(); 
        //bữa trước dùng thử toCharArray không được vì bản thân mỗi digit lúc đó chưa phải là một char
        return digit;
    }
    /*public double summing2(int n) {
        String str1 = Integer.toString(n);
        double digit = 0;

        double sum = 0;                   ------> từ cách 1 hôm trước
        int temp = n;
        for (int i = 0; i < str1.length(); i++) {
            digit = temp % 10;  //day la chu so
            temp = (int) temp / 10;  //day la thuong
            sum = sum + digit;
        }
        return sum;
    }*/   
    public void display(int input, char[] arr, double result) {
        System.out.print(input +" ~ ");
        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length - 1) {
                System.out.print(Array.get(arr, i) + " = ");
            } else {
                System.out.print(Array.get(arr, i) + " + ");
            }
        }
        System.out.print(result);
    }

}
