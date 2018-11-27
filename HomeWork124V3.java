
package hongeinh.homework;

import java.util.Scanner;
import java.util.ArrayList;

public class HomeWork124V3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Dodo dodo = new Dodo();
        int option = 0;
        
        do {
            System.out.print("  1.Doi he co so\n  2.Giai phuong trinh bac 2\n  3.Giai phuong trinh bac 3\n  0.Thoat. \nChon chuong trinh: ");
            option = sc.nextInt();
            switch (option) {
                case 1:
                    dodo.display(dodo.convert(dodo.InputLong(sc, option)));
                    break;
                case 2:
                    dodo.display(dodo.square(dodo.Input(sc, option)));
                    break;
                case 3:
                    dodo.display(dodo.cube(dodo.Input(sc, option)));
                    break;
            }
        } while (option != 0);
    }
}
interface Do2{
    public ArrayList Input(Scanner sc, int option);
    public ArrayList square(ArrayList arr);
    public ArrayList cube(ArrayList arr);
    public ArrayList convert(ArrayList arr) ;
    public void display(ArrayList arr1);
}

class Dodo implements Do2{
    public ArrayList Input(Scanner sc, int option){
        double a = 0;
        ArrayList<Double> arr = new ArrayList();
        for(int i = 0; i<=option; i++){
            System.out.print("Nhap: ");
            a = sc.nextDouble();
            arr.add(a);
        }
        return arr;
    }
    public ArrayList InputLong(Scanner sc, int option){
        long a = 0;
        ArrayList<Long> arr = new ArrayList();
        for(int i = 0; i<=option; i++){
            System.out.print("Nhap: ");
            a = sc.nextLong();
            arr.add(a);
        }
        return arr;
    }

    public ArrayList square(ArrayList arr) {
        ArrayList<Double> arr1 = new ArrayList();
        
        double aa = (double) arr.get(0);
        double bb = (double) arr.get(1);
        double cc = (double) arr.get(2);
        double result1 = 0;
        double result2 = 0;
        double delta2 = bb * bb - 4 * aa * cc;
        if (delta2 < 0) {
            System.out.println("No solution");
        } else if (delta2 == 0) {
            result1 = (-cc) / (2 * bb);
            arr1.add(result1);
        } else {
            result1 = (-cc + Math.sqrt(delta2)) / (2 * aa);
            result2 = (-cc - Math.sqrt(delta2)) / (2 * aa);
            arr1.add(result1);
            arr1.add(result2);
        }
        return arr1;
    }

    public ArrayList cube(ArrayList arr) {
        ArrayList<Double> arr1 = new ArrayList();
        
        double a = (double) arr.get(0);
        double b = (double) arr.get(1);
        double c = (double) arr.get(2);        
        double d = (double) arr.get(3);    
        
        double result1 = 0;
        double result2 = 0;
        double result3 = 0;
        double delta3 = b * b - 3 * a * c;
        double k = (9 * a * b * c - 2 * b * b * b - 27 * a * a * d) / (2 * Math.pow(Math.abs(delta3), 3 / 2));
        double prep1 = Math.pow(Math.abs(k) + Math.sqrt(k * k - 1), 1 / 3) + Math.pow(Math.abs(k) - Math.sqrt(k * k - 1), 1 / 3);
        double prep2 = Math.pow(k + Math.sqrt(k * k + 1), 1 / 3) + Math.pow(k - Math.sqrt(k * k + 1), 1 / 3);
        if (delta3 > 0) {
            if (Math.abs(k) < 1) {
                result1 = (2 * Math.sqrt(delta3) * Math.cos(Math.acos(k) / 3) - b) / (3 * a);
                result2 = (2 * Math.sqrt(delta3) * Math.cos(Math.acos(k) / 3 - (2 * Math.PI / 3)) - b) / (3 * a);
                result3 = (2 * Math.sqrt(delta3) * Math.cos(Math.acos(k) / 3 + (2 * Math.PI / 3)) - b) / (3 * a);
                arr1.add(result1);
                arr1.add(result2);
                arr1.add(result3);
            } else {
                result1 = (Math.sqrt(delta3) * Math.abs(k) * prep1) / (3 * a * k) - (b / (3 * a));
                arr1.add(result1);
            }
        } else if (delta3 == 0) {
            if (b * b * b - 27 * a * a * d == 0) {
                result1 = (-b) / (3 * a);
                arr1.add(result1);
            } else {
                result1 = (-b + Math.pow(b * b * b - 27 * a * a * d, 1 / 3)) / (3 * a);
                arr1.add(result1);
            }
        } else {
            result1 = (Math.sqrt(delta3) * prep2) / (3 * a) - (b / (3 * a));
            arr1.add(result1);
        }
        return arr1;
    }

    public ArrayList convert(ArrayList arr) {
        ArrayList<Long> arr1 = new ArrayList();
        long n = (long) arr.get(0);
        long base  = (long) arr.get(1);
        long mod = 0;
        for (long div = n; div > 0; div /= base) {
            mod = div % base;
            arr1.add(mod);
        }
        return arr1;
    }

    public void display(ArrayList arr1) {
        for (int i = arr1.size()-1; i >= 0; i--) {
            System.out.print(arr1.get(i) + " ");
        }
        System.out.println("\n");
    }
}
                    


