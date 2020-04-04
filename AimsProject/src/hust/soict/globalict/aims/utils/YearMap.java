package hust.soict.globalict.aims.utils;
import java.util.HashMap;

public class YearMap {
	HashMap<String, Integer> yearMap;
	
	
	YearMap(){
		yearMap = new HashMap<String, Integer>();
		yearMap.put("zero", 0);
		yearMap.put("one", 1);
		yearMap.put("two", 2);
		yearMap.put("three", 3);
		yearMap.put("four", 4);
		yearMap.put("five", 5);
		yearMap.put("six", 6);
		yearMap.put("seven", 7);
		yearMap.put("eight", 8);
		yearMap.put("nine", 9);
		yearMap.put("ten", 10);
		yearMap.put("eleven", 11);
		yearMap.put("twelve", 12);
		yearMap.put("thirteen", 13);
		yearMap.put("forteen", 14);
		yearMap.put("fifteen", 15);
		yearMap.put("sixteen", 16);
		yearMap.put("seventeen", 17);
		yearMap.put("eighteen", 18);
		yearMap.put("nineteen", 19);
		yearMap.put("twenty", 20);
		yearMap.put("thirty", 30);
		yearMap.put("forty", 40);
		yearMap.put("fifty", 50);
		yearMap.put("sixty", 60);
		yearMap.put("seventy", 70);
		yearMap.put("eighty", 80);
		yearMap.put("ninety", 90);
		yearMap.put("hundred", 100);
		yearMap.put("thousand", 1000);
		
	}
	

	public int calculateYear(String input) {
		int result = 0;
		int finalResult = 0;
		String [] inputSplit = input.split(" ");
		for(String s: inputSplit) {
			if(yearMap.containsKey(s) == false) {
				System.out.println("Invalid input");
				return -1;
			}
		}
		for(String s: inputSplit) {
			if((!s.equals("hundred")) && (!s.equals("thousand"))) {
				result = result + yearMap.get(s);
			}
			else {
				result = result * yearMap.get(s);
				finalResult = finalResult + result;
				result = 0;
			}
		}
		finalResult += result;
		result = 0;
		return finalResult;
	}
}
