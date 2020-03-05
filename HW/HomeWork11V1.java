//sum of the digits of an integer
//formula on wiki
package hongeinh.homework;

import java.lang.reflect.Array;
import java.util.Scanner;

public class HomeWork11V1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = 0;
        do {
            System.out.println("Enter a positive integer: ");
            num = sc.nextInt();
        } while (num == 0);
        /*SumDigit sumDit = new SumDigit();
        System.out.println("Cach 1: ");
        sumDit.summing1(num);   //cach 1
        System.out.println("Cach 2: ");
        sumDit.display(num,sumDit.digiting(num), sumDit.summing2(num));*/
        SumDigit2 sum2 = new SumDigit2();
        sum2.digiting1(num);
    }
}

class SumDigit {

    public void summing1(int n) {
        /*String str1 = Integer.toString(n);
        String str2 = "";
        int sum = 0;
        for (int i = 0; i < str1.length(); i++) {
            if(i<str1.length()-1){
                str2 = (str2.concat(str1.substring(i, i + 1))).concat(" + ");
            }else{
                str2 = (str2.concat(str1.substring(i, i + 1))).concat(" = ");
            }
        }
        System.out.println(str2);
        char[] arr1 = str2.toCharArray();
        for (int i = 0; i < arr1.length; i++) {
            
        }     -->dai va vong veo<--     */
        double sum = 0;
        for (double i = 0; i < Math.log10((double) n); i++) {
            sum = sum + 1 / (Math.pow(10, i)) * (n % Math.pow(10.0, i + 1) - n % Math.pow(10.0, i));
        }
        System.out.println((int) sum);
    }

    public String digiting(int n) {
        String str1 = Integer.toString(n);
        String str2 = "";
        for (int i = 0; i < str1.length(); i++) {
            if (i < str1.length() - 1) {
                str2 = (str2.concat(str1.substring(i, i + 1))).concat(" + ");
            } else {
                str2 = (str2.concat(str1.substring(i, i + 1))).concat(" = ");
            }
        }
        return str2;
    }

    public double summing2(int n) {
        String str1 = Integer.toString(n);
        double digit = 0;

        double sum = 0;
        int temp = n;
        for (int i = 0; i < str1.length(); i++) {
            digit = temp % 10;  //day la chu so
            temp = (int) temp / 10;  //day la thuong
            sum = sum + digit;
        }
        return sum;
    }

    public void display(int input, String string, double n) {
        System.out.print(input + " ~ " + string + n);
    }

}



