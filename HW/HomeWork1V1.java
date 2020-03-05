package hongeinh.homework;

import java.util.Scanner;

public class HomeWork1V1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print(" a: ");
        float a = sc.nextFloat();
        System.out.print(" b: ");
        float b = sc.nextFloat();
        System.out.print(" c: ");
        float c = sc.nextFloat();

        float delta = (float) (Math.pow(b, 2) + 4 * a * c);
        float solution = (float) ((-Math.pow(b, 2) + Math.sqrt(delta)) / a);

        if (a != 0) {
            if (delta < 0) {
                System.out.println("Phương trình vô nghiệm");
            } else if (delta == 0) {
                System.out.println("Phương trình có một nghiệm. Nghiệm của phương trình là x = " + c / -b);
            } else {
                System.out.format("%nPhương trình có 2 nghiệm phân biệt %n x = %.3f %n x = %.3f", solution, (-solution));
            }

        } else {
            System.out.println("Phương trình không phải phương trình bậc 2");
        }
    }
}
