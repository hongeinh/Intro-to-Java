//find gcd and lcm
//Euclidean's algo
package hongeinh.homework;

import java.util.Scanner;
//import java.util.ArrayList;

public class HomeWork6V1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int option = 0;
        GCD1 c = new GCD1();;
        do {
            System.out.print("\n  1.Tim UCLN\n  2.Tim BCNN\n  0.Thoat\nChon chuong trinh: ");
            option = sc.nextInt();

            switch (option) {
                case 1:
                    System.out.print("Nhap a: ");
                    double a = sc.nextDouble();
                    System.out.print("Nhap b: ");
                    double b = sc.nextDouble();
                    c.display(c.calculate(a, b));
                    break;
                case 2:
                    System.out.print("Nhap a: ");
                    double aa = sc.nextDouble();
                    System.out.print("Nhap b: ");
                    double bb = sc.nextDouble();
                    double d = Math.abs(aa * bb) / c.calculate(aa, bb);   //cthuc: lcm(a,b)* gcd(a,b)= ab
                    c.display(d);
                    break;
            }
        } while (option != 0);
    }
}

/*interface Common {
    public double calculate(double a, double b);
    public void display(double n);
}*/
class GCD1 /*implements Common*/ {

    //@Override
    public double calculate(double a, double b) {
        if (a == 0 || b == 0) {    //gcd(a,b) = gcd(a-b,b) if a>b
            return a + b;  //gcd la so con lai neu 1 trong 2 la 0
        }
        do {
            if (a > b) {
                a -= b; //a = a-b, neu a!=b thi quay lai vong lap de so sanh
            } else if (a < b) {
                b -= a;  //dung mod chuong trinh chay rat cham
            }
        } while (a != b);
        return b;  //return a hay b cung giong nhau vì loop ket thuc khi a = b = gcd
    }

    //@Override
    public void display(double n) {
        System.out.print("Result: " + n);
    }
}

/*class LCM extends GCD {
    @Override
    public double calculate(double a, double b) {
        if (a == 0 || b == 0) {
            return 0;
        }
        return 0;
    }
}*/
class GCD2 extends GCD1 {

    @Override
    public double calculate(double a, double b) {
        if (a == 0 || b == 0) {
            return a + b;
        } else {
            while (a != b) {
                if (a > b) {
                    a -= b;
                } else if (a < b) {
                    b -= a;
                }
            }
            return a;
        }
    }
}
