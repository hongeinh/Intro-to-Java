package hust.soict.globalict.aims.utils;
import java.util.ArrayList;

public class DateUtils {

	public int compareTo(MyDate date, MyDate d) {
		if (date.getYear() > d.getYear()) {
			return 1;
		} else if (date.getYear() < d.getYear()) {
			return -1;
		} else {
			if (date.getMonth() > d.getMonth()) {
				return 1;
			} else if (date.getMonth() < d.getMonth()) {
				return -1;
			} else {
				if (date.getDay() > d.getDay()) {
					return 1;
				} else if (date.getDay() < d.getDay()) {
					return -1;
				} else
					return 0;
			}
		}
	}

	public ArrayList<MyDate> sortDate(ArrayList<MyDate> dateList) {
		int sze = dateList.size();
		for (int i = 0; i < sze - 1; i++) {
			for (int j = i + 1; j < sze; j++) {
				int comp = compareTo(dateList.get(i), dateList.get(j));
				if (comp == 1) {
					int day = dateList.get(i).getDay();
					int month = dateList.get(i).getMonth();
					int year = dateList.get(i).getYear();

					dateList.get(i).setDay(dateList.get(j).getDay());
					dateList.get(i).setMonth(dateList.get(j).getMonth());
					dateList.get(i).setYear(dateList.get(j).getYear());
					
					dateList.get(j).setDay(day);
					dateList.get(j).setMonth(month);
					dateList.get(j).setYear(year);
				}
			}
		}

		for (MyDate date : dateList) {
			date.print();
		}
		return dateList;
	}
}
