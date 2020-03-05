//tach mot so thanh tich cac prime
package hongeinh.homework;

import java.util.ArrayList;
import java.util.Scanner;

public class HomeWork10V1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int num = sc.nextInt();
        Factoring f = new Factoring();
        f.display(f.factoring(num));
    }
}

class Factoring {

    ArrayList<Integer> arr = new ArrayList();

    public ArrayList factoring(int n) {
        //int factor = 1;
        int temp = n;
        if (n == 0) {
            System.out.println("None");

        } else if (n == 1) {
            arr.add(1);

        } else {

            for (int i = 0; i <= Math.sqrt(n); i++) {

                for (int j = 2; j <= n; j++) {
                    if (temp % j == 0) {
                        //factor = i;
                        arr.add(j);
                        temp = temp / j;
                        //n = n/j will result in a deformity of n
                        //better to use a temporary var to represent n
                        break;
                    }
                }
            }

        }
        return arr;
    }

    public void display(ArrayList arr) {
        for (int i = 0; i < arr.size(); i++) {
            System.out.print(arr.get(i) + "*");
        }
    }
}
