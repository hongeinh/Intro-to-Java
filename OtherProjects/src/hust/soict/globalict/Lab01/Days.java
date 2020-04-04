package hust.soict.globalict.Lab01;
import java.util.Scanner;
import java.time.YearMonth;

/*
 * NOTE: 	Valid form of input: month year
 * 		 	Invalid: month/year
 * 					 month_year
 * 					 month.year
 * 						...
 */

/*
 * LAB 02
 * Exercise 5.5: Print number of days in the month that user enter
 * */

public class Days {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter month/year: ");
		String input = sc.nextLine();
		String [] date = input.split(" ");
		
		Days d = new Days();
		int valid = d.checkValid(date[0], date[1]);
		if(valid != 0)
		{
			YearMonth y = YearMonth.of(Integer.parseInt(date[1]), valid);
			System.out.println("Result: " + y.lengthOfMonth());
		}
		else {
			System.out.println("Invalid input!");
		}
		sc.close();
	}
	
	int checkValid(String month, String year)
	{
		int iYear = Integer.parseInt(year);
		if(iYear <= 0) return 0; 

		if(month.equals("January") || month.equals("Jan") || month.equals("Jan.") || month.equals("1")) return 1; 
		else if(month.equals("February") || month.equals("Feb") || month.equals("Feb.") || month.equals("2")) return 2; 
		else if(month.equals("March") || month.equals("Mar") || month.equals("Mar.") || month.equals("3")) return 3; 
		else if(month.equals("April") || month.equals("Apr") || month.equals("Apr.") || month.equals("4")) return 4; 
		else if(month.equals("May") || month.equals("May") || month.equals("May.") || month.equals("5")) return 5; 
		else if(month.equals("June") || month.equals("Jun") || month.equals("Jun.") || month.equals("6")) return 6; 
		else if(month.equals("July") || month.equals("Jul") || month.equals("Jul.") || month.equals("7")) return 7; 
		else if(month.equals("August") || month.equals("Aug") || month.equals("Aug.") || month.equals("8")) return 8; 
		else if(month.equals("September") || month.equals("Sep") || month.equals("Sep.") || month.equals("9")) return 9; 
		else if(month.equals("October") || month.equals("Oct") || month.equals("Oct.") || month.equals("10")) return 10; 
		else if(month.equals("November") || month.equals("Nov") || month.equals("Nov.") || month.equals("11")) return 11; 
		else if(month.equals("December") || month.equals("Dec") || month.equals("Dec.") || month.equals("12")) return 12; 
		
		return 0;
	}
}
