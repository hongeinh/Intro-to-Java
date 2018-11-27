package hongeinh.homework;

import java.util.ArrayList;
import java.util.Scanner;

public class HomeWork124V2 {

    public static void main(String[] args) {
        Do output = new Do();
        Scanner sc = new Scanner(System.in);
        //short [] arr = {1,2,3,4};
        //for(short option:arr){
        short option = 0;

        do {
            System.out.print("1.Giai PT bac 2\n2.Giai PT bac 3\n3.Chuyen doi he co so\n0.Thoat\nChon chuong trinh:");
            option = sc.nextShort();

            switch (option) {
                
                case 1:
                    System.out.print("Nhap a:");
                    double aa = sc.nextFloat();
                    System.out.print("Nhap b:");
                    double bb = sc.nextFloat();
                    System.out.print("Nhap c:");
                    double cc = sc.nextFloat();
                    output.display(output.square(aa, bb, cc));
                    break;

                case 2:
                    System.out.print("Nhap d:");
                    double a = sc.nextFloat();
                    System.out.print("Nhap d:");
                    double b = sc.nextFloat();
                    System.out.print("Nhap d:");
                    double c = sc.nextFloat();
                    System.out.print("Nhap d:");
                    double d = sc.nextFloat();
                    output.display(output.cube(a, b, c, d));
                    break;
                case 3:
                    System.out.print("Nhap so de chuyen:");
                    long n = sc.nextLong();
                    System.out.print("Nhap he co so:");
                    byte base = sc.nextByte();
                    output.display(output.convert(n, base));
                    break;
            }
        } while (option != 0);
    }
}


class Do {

    public ArrayList square(double aa, double bb, double cc) {
        ArrayList<Double> arr1 = new ArrayList();
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

    public ArrayList cube(double a, double b, double c, double d) {
        ArrayList<Double> arr1 = new ArrayList();
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

    public ArrayList convert(long n, byte base) {
        ArrayList<Long> arr1 = new ArrayList();
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
