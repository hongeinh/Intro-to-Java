package hust.soict.globalict.Lab01;

import java.util.Scanner;
import java.util.Collections;
import java.util.ArrayList;

public class ArraySorting
{
    public static void main (String [] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of elements: ");
        double n = sc.nextDouble();
        System.out.println("Enter elements:");
        ArrayList<Double> arr = new ArrayList<Double>();
        double sum = 0.0;
        for(int i = 0; i < n; i++)
        {
            double temp = sc.nextDouble();
            arr.add(temp);
            sum += temp;
        }
        double average = sum/n;
        Collections.sort(arr);

        for(int i = 0; i < n; i++) System.out.print(arr.get(i) + " ");
        System.out.format("\nSum: %.2f\nAverage: %.2f", sum, average);
        
        sc.close();
    }
}
