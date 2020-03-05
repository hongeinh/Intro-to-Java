package hongeinh.homework;

import java.util.Scanner;
import java.util.ArrayList;

public class HomeWork124V4 {

    /*main: user chon option -> case phu hop -> call getInput de lay du lieu 
->dua du lieu ve cac method cua cac class phu hop cho tinh toan -> output */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int option = 0;
        Prototype prototype = null; //obj of interface Prototype //dung chung giua ca 3 class tinh toan
        do {
            System.out.print("  1.Doi he co so\n  2.Giai phuong trinh bac 2\n  3.Giai phuong trinh bac 3\n  0.Thoat. \nChon chuong trinh: ");

            option = sc.nextInt();
            switch (option) {
                case 1:
                    prototype = new ConvertValue();  //interface ko co constructor nen dung constructor cua class implements no
                    ArrayList arr = getInput(sc, option, "Long");  //option tuong tu vs length dc truyen vao
                    prototype.display(prototype.calculate(arr));
                    break;
                case 2:
                    prototype = new GPTB2();
                    ArrayList arr1 = getInput(sc, option, "Double");
                    prototype.display(prototype.calculate(arr1));
                    break;
                case 3:
                    prototype = new GPTB3();
                    ArrayList arr2 = getInput(sc, option, "Double");
                    prototype.display(prototype.calculate(arr2));
                    break;
            }
        } while (option != 0);
    }

    private static ArrayList getInput(Scanner input, int length, String type) {
        // kiem tra dieu kien tham so dau vao
        // vi du input != null
        if (input == null) {
            System.out.println("Input is null");
            return null;
        }

        //
        ArrayList arr = new ArrayList<>();   //cach viet nay co khac gì ArrayList<..> arr = new ArrayList() ko?
        //khac, co the dut bat cu loai data nao vao
        for (int i = 0; i <= length; i++) {  //de tao ra so lan loop phu hop
            switch (type) {
                case "Long":   //de phan biet input can dung cho moi truong hop
                    System.out.print("Nhap: ");
                    long a = input.nextLong();  //nextLong ko co cai linebreak nen co can bo sung nextLine?
                    arr.add(a); //case doi he thi se can nhap 2 so
                    break;
                case "String":  //case String de lam gi hmmm hmmm
                    System.out.print("Nhap: ");
                    String b = input.nextLine();
                    arr.add(b);
                    break;
                case "Double":
                    System.out.print("Nhap: ");
                    double c = input.nextDouble();
                    arr.add(c);
                    break;
            }
        }
        return arr;
    }
}

interface Prototype {

    public abstract ArrayList calculate(ArrayList arg);

    public abstract void display(ArrayList arg);
}

class ConvertValue implements Prototype {

    ArrayList use = new ArrayList<>();

    @Override
    public ArrayList calculate(ArrayList arg) {
        long num = (long) arg.get(0);
        long base = (long) arg.get(1);
        long mod = 0;
        for (long div = num; div > 0; div /= base) {
            mod = div % base;
            use.add(mod);
        }
        return use;

    }

    @Override
    public void display(ArrayList arg) {
        for (int i = arg.size() - 1; i >= 0; i--) {
            System.out.print(arg.get(i) + " ");
        }
        System.out.println("\n");

    }
}

class GPTB2 extends ConvertValue {  //ke thua luon display method cua parent class

    @Override
    public ArrayList calculate(ArrayList arg) {
        double aa = (double) arg.get(0);
        double bb = (double) arg.get(1);
        double cc = (double) arg.get(2);
        double result1 = 0;
        double result2 = 0;
        double delta2 = bb * bb - 4 * aa * cc;
        if (delta2 < 0) {
            System.out.println("No solution");
        } else if (delta2 == 0) {
            result1 = (-cc) / (2 * bb);
            use.add(result1);
        } else {
            result1 = (-cc + Math.sqrt(delta2)) / (2 * aa);
            result2 = (-cc - Math.sqrt(delta2)) / (2 * aa);
            use.add(result1);
            use.add(result2);
        }
        return use;
    }

    /*@Override
    public void display(ArrayList arg) {
        for (int i = 0; i < arg.size(); i++) {
            System.out.print(arg.get(i) + " ");
        }
        System.out.println("\n");

    }*/

}

class GPTB3 extends ConvertValue /*GPTB2*/ {

    @Override
    public ArrayList calculate(ArrayList arg) {
        double a = (double) arg.get(0);
        double b = (double) arg.get(1);
        double c = (double) arg.get(2);
        double d = (double) arg.get(3);

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
                use.add(result1);
                use.add(result2);
                use.add(result3);
            } else {
                result1 = (Math.sqrt(delta3) * Math.abs(k) * prep1) / (3 * a * k) - (b / (3 * a));
                use.add(result1);
            }
        } else if (delta3 == 0) {
            if (b * b * b - 27 * a * a * d == 0) {
                result1 = (-b) / (3 * a);
                use.add(result1);
            } else {
                result1 = (-b + Math.pow(b * b * b - 27 * a * a * d, 1 / 3)) / (3 * a);
                use.add(result1);
            }
        } else {
            result1 = (Math.sqrt(delta3) * prep2) / (3 * a) - (b / (3 * a));
            use.add(result1);
        }
        return use;
    }

}
