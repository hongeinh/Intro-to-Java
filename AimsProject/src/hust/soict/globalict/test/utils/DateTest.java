package hust.soict.globalict.test.utils;
import java.util.ArrayList;
import java.util.Scanner;

import hust.soict.globalict.aims.utils.DateUtils;
import hust.soict.globalict.aims.utils.MyDate;

public class DateTest {

	public static void main(String[] args) {
		ArrayList<MyDate> dateList = new ArrayList<MyDate>();
		menu(dateList);
	}

	public static ArrayList<MyDate> menu(ArrayList<MyDate> dateList) {
		int choice = 0;
		String options = "\n\nDate options:\n1. Print current date (Prev lab)\n"
				+ "2. Enter ints, Print date in format (February 28th 2020)\n"
				+ "3. Enter string, Print date in format (February 28th 2020)\n"
				+ "4. Enter ints, Print date in format (dd/mm/yyyy)\n"
				+ "5. Enter string, Print date in format (dd/mm/yyyy)\n"
				+ "6. User input date in 3 different word string (day, month, year)\n" 
				+ "7. Sort dates in list\n"
				+ "0. Exit";
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println(options);
			System.out.print("--> Your choice: ");
			choice = sc.nextInt();
			sc.nextLine();
			switch (choice) {
			case 1:
				MyDate currentDate = new MyDate();
				currentDate.print();
				dateList.add(currentDate);
				break;
			case 2:
				System.out.print("Enter day (int): ");
				int day = sc.nextInt();
				sc.nextLine();
				System.out.print("Enter month (int): ");
				int month = sc.nextInt();
				System.out.print("Enter year: ");
				int year = sc.nextInt();
				sc.nextLine();
				MyDate d1 = new MyDate(day, month, year);
				d1.print(d1.getDay(), d1.getMonth(), d1.getYear());
				dateList.add(d1);
				break;
			case 3:
				System.out.print("Enter date (mm/dd/yyyy): ");
				String date1 = sc.nextLine();
				MyDate d4 = new MyDate(date1);
				d4.print(d4.getDay(), d4.getMonth(), d4.getYear());
				dateList.add(d4);
				break;
			case 4: 
				System.out.println("Enter day (int): ");
				int day1 = sc.nextInt();
				sc.nextLine();
				System.out.println("Enter month (int): ");
				int month1 = sc.nextInt();
				sc.nextLine();
				System.out.println("Enter year (int): ");
				int year1 = sc.nextInt();
				sc.nextLine();
				MyDate d5 = new MyDate(day1, month1, year1);
				d5.print();
				dateList.add(d5);
				break;
			case 5:
				System.out.print("Enter date in format (February 28th 2020): ");
				String date = MyDate.accept();
				MyDate d2 = new MyDate(date);
				d2.print();
				dateList.add(d2);
				break;
			case 6:
				System.out.println(
						"For year, please enter in the following format: \n\t1999 --> one thousand nine hundred ninety nine\n\t2020 --> two thousand twenty");
				System.out.print("Enter day: ");
				String daySS = sc.nextLine();
				System.out.print("Enter month: ");
				String monthSS = sc.nextLine();
				System.out.println("Enter year: ");
				String yearSS = sc.nextLine();
				MyDate d3 = new MyDate(daySS, monthSS, yearSS);
				d3.print();
				dateList.add(d3);
				break;
			case 7:
				DateUtils du = new DateUtils();
				dateList = du.sortDate(dateList);
				break;
			case 0:
				System.out.println("Program exit!");
				break;
			default:
				System.out.println("Invalid choice");
				break;
			}
		} while (choice != 0);
		sc.close();
		return dateList;
	}
}
