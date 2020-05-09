package hust.soict.globalict.test.media;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import hust.soict.globalict.aims.media.Book;

public class BookTest {
	public static void main(String[] args) {
		List<String> authors = new ArrayList<String>();
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Book title: ");
		String title = sc.nextLine();
		System.out.print("Book category: ");
		String cat = sc.nextLine();
		
		String choice = "yes";

		String au;
		do {
			System.out.print("Add author ? (yes/no):");
			choice = sc.nextLine().toLowerCase();
			if(choice.equals("yes") || choice.equals("y")) {
				System.out.println("Enter author: ");
				au = sc.nextLine();
				authors.add(au);
			} else if(choice.equals("no") || choice.equals("n")) {
				System.out.println("Add author end.");
			} else {
				System.out.println("Invalid choice.");
			}
		}while( (!choice.equals("no")) && (!choice.equals("n")) );
		
		
		/*
		 * authors.add("Christopher Kezelos"); authors.add("Christine Kezelos");
		 */
		Book book = new Book(title, cat, authors);
		/*
		 * book.setContent(
		 * "In a time and a world long 1 2 ago forgotten, there was a workshop. If a stranger found themselves within its wall, they wouldn't know where to marvel first. Aloha blah $blah good % morning"
		 * );
		 */
		
		
		book.createContent();
		book.processContent();
		System.out.println(book.toString());;

	}
}
