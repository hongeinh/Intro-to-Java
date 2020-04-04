package hust.soict.globalict.Lab02;
/*
 * LAB 02
 * Exercise 5.2
 * */
import java.util.Scanner;

public class InputFromKeyboard {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("What is your name? ");
		String strName = keyboard.nextLine();
		
		System.out.println("How old are you? ");
		int age = keyboard.nextInt();
		
		System.out.println("How tall are you? ");
		double height = keyboard.nextDouble();
		
		System.out.println("Mr/Miss " + strName + ", " + age + " years old, " + height + " (m) tall.");
		keyboard.close();
	}

}
