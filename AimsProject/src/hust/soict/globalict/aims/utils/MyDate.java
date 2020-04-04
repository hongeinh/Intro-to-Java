package hust.soict.globalict.aims.utils;
import java.time.LocalDate;
import java.util.Scanner;

public class MyDate {
	private int day;
	private int stringMonth;
	private int year;

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getMonth() {
		return stringMonth;
	}

	public void setMonth(int month) {
		this.stringMonth = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public MyDate() {
		String current = LocalDate.now().toString();
		String[] date = current.split("-");
		
		setDay(Integer.parseInt(date[2]));
		setMonth(Integer.parseInt(date[1]));
		setYear(Integer.parseInt(date[0]));
	}

	public MyDate(int day, int month, int year) {
		if (isValidDate(day, month, year)) {
			setDay(day);
			setMonth(month);
			setYear(year);
		} else {
			System.out.println("Sorry babe wrong format");
			
		}
	}
	public MyDate(String input) {
		input = input.trim();
		String[] date;
		if (input.contains("/")) {
			date = input.split("/");
		} else if (input.contains("-")) {
			date = input.split("-");
		} else {
			date = input.split(" ");
		}
		int month = monthConverter(date[0]);
		int day = dayConverter(date[1]);
		int year = Integer.parseInt(date[2]);
		if (isValidDate(day, month, year)) {
			setDay(day);
			setMonth(month);
			setYear(year);
		} else {
			System.out.println("Invalid date sorry bae" + + day + "/" + month + "/" + year);
		}
	}

	public MyDate(String sDay, String sMonth, String sYear) {
		int month = monthConverter(sMonth);
		int day = dayValueToInt(sDay);
		int year = yearValueToInt(sYear);

		if (isValidDate(day, month, year)) {
			setDay(day);
			setMonth(month);
			setYear(year);
		} else {
			System.out.println("Invalid date sorry bae: " + day + "/" + month + "/" + year);
		}

	}

	private int dayConverter(String stringDay) {
		if (stringDay == null)
			return -1;
		String replaceString = null;
		if (stringDay.contains("th"))
			replaceString = stringDay.replace("th", "");
		else if (stringDay.contains("st"))
			replaceString = stringDay.replace("st", "");
		else if (stringDay.contains("nd"))
			replaceString = stringDay.replace("nd", "");
		else if (stringDay.contains("rd"))
			replaceString = stringDay.replace("rd", "");
		else
			replaceString = stringDay;
		int day = Integer.parseInt(replaceString);
		return day;
	}

	private int monthConverter(String stringMonth) {
		if (stringMonth == null)
			return -1;
		
		stringMonth = stringMonth.trim();
		if (stringMonth.equals("January") || stringMonth.equals("Jan") || stringMonth.equals("Jan.")
				|| stringMonth.equals("1") || stringMonth.equals("january"))
			return 1;
		else if (stringMonth.equals("February") || stringMonth.equals("Feb") || stringMonth.equals("Feb.")
				|| stringMonth.equals("2") || stringMonth.equals("february") )
			return 2;
		else if (stringMonth.equals("March") || stringMonth.equals("Mar") || stringMonth.equals("Mar.")
				|| stringMonth.equals("3") || stringMonth.equals("march") )
			return 3;
		else if (stringMonth.equals("April") || stringMonth.equals("Apr") || stringMonth.equals("Apr.")
				|| stringMonth.equals("4") || stringMonth.equals("april") )
			return 4;
		else if (stringMonth.equals("May") || stringMonth.equals("May") || stringMonth.equals("May.")
				|| stringMonth.equals("5") || stringMonth.equals("may") )
			return 5;
		else if (stringMonth.equals("June") || stringMonth.equals("Jun") || stringMonth.equals("Jun.")
				|| stringMonth.equals("6") || stringMonth.equals("june") )
			return 6;
		else if (stringMonth.equals("July") || stringMonth.equals("Jul") || stringMonth.equals("Jul.")
				|| stringMonth.equals("7") || stringMonth.equals("july") )
			return 7;
		else if (stringMonth.equals("August") || stringMonth.equals("Aug") || stringMonth.equals("Aug.")
				|| stringMonth.equals("8") || stringMonth.equals("august") )
			return 8;
		else if (stringMonth.equals("September") || stringMonth.equals("Sep") || stringMonth.equals("Sep.")
				|| stringMonth.equals("9") || stringMonth.equals("september") )
			return 9;
		else if (stringMonth.equals("October") || stringMonth.equals("Oct") || stringMonth.equals("Oct.")
				|| stringMonth.equals("10") || stringMonth.equals("october") )
			return 10;
		else if (stringMonth.equals("November") || stringMonth.equals("Nov") || stringMonth.equals("Nov.")
				|| stringMonth.equals("11") || stringMonth.equals("november") )
			return 11;
		else if (stringMonth.equals("December") || stringMonth.equals("Dec") || stringMonth.equals("Dec.")
				|| stringMonth.equals("12") || stringMonth.equals("december") )
			return 12;
		return 0;
	}

	public int dayValueToInt(String sDay) {
		if (sDay == null)
			return -1;
		int day = 0;
		sDay = sDay.toLowerCase();
		if (sDay.contains("first")) {
			day = day + 1;
		} else if (sDay.contains("second")) {
			day = day + 2;
		} else if (sDay.contains("third")) {
			day = day + 3;
		} else if (sDay.contains("four") || sDay.contains("for")) {
			day = day + 4;
		} else if (sDay.contains("fif")) {
			day = day + 5;
		} else if (sDay.contains("six")) {
			day = day + 6;
		} else if (sDay.contains("seven")) {
			day = day + 7;
		} else if (sDay.contains("eight")) {
			day = day + 8;
		} else if (sDay.contains("nin")) {
			day = day + 9;
		}

		if (sDay.contains("teen") || sDay.equals("tenth")) {
			day = day + 10;
		} else if (sDay.contains("twenty")) {
			day = day + 20;
		} else if (sDay.contains("thirty")) {
			day = day + 30;
		}

		if (sDay.contains("elenventh"))
			day = 11;
		else if (sDay.contains("twelveth"))
			day = 12;
		else if (sDay.contains("thirteen"))
			day = 13;
		else if(sDay.contains("twentieth"))
			day = 20;
		else if(sDay.contains("thirtieth"))
			day = 30;
		return day;
	}

	public int yearValueToInt(String sYear) {
		if (sYear == null)
			return -1;
		return new YearMap().calculateYear(sYear.toLowerCase());
	}

	public boolean isValidDate(int day, int month, int year) {
		if (day <= 0 || day > 31 || month <= 0 || month > 12 || year < 0)
			return false;
		if (year % 4 != 0 && month == 2 && day > 28)
			return false;
		if ((month == 4 || month == 6 || month == 9 || month == 11) && day > 30)
			return false;
		return true;
	}

	public static String accept() {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		return input;
	}

	public String monthToString(int month) {
		String sMonth = null;
		switch (month) {
		case (1):
			sMonth = "January";
			break;
		case (2):
			sMonth = "February";
			break;
		case (3):
			sMonth = "March";
			break;
		case (4):
			sMonth = "April";
			break;
		case (5):
			sMonth = "May";
			break;
		case (6):
			sMonth = "June";
			break;
		case (7):
			sMonth = "July";
			break;
		case (8):
			sMonth = "August";
			break;
		case (9):
			sMonth = "September";
			break;
		case (10):
			sMonth = "October";
			break;
		case (11):
			sMonth = "November";
			break;
		case (12):
			sMonth = "December";
			break;
		default:
			sMonth = "Invalid month";
			break;
		}
		return sMonth;

	}

	// print current date
	public void print(int day, int month, int year) {
		System.out.println(monthToString(month) + " " + day + "th " + year);
	}

	public void print() {
		System.out.println(this.getDay() + "/" + this.getMonth() + "/" + this.getYear());
	}
}
