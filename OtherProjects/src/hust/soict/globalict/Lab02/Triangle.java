package hust.soict.globalict.Lab02;
/*
 * LAB 02
 * Exercise 5.4: Display a triangle with height of n
 * */
import java.util.Scanner;

public class Triangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter n please babi: ");
		int n = sc.nextInt();
		int i = n; 
		int j = n;
		do {
			for(int k = 0; k < 2*n; k++) {
				if( k >= i && k <= j) System.out.print("*");
				else System.out.print(" ");
			}
			System.out.println();
			i--;
			j++;
		}while(i >= 0 && j < 2*n);
		
		System.out.println("He he done ^^");
		sc.close();
	}
}
