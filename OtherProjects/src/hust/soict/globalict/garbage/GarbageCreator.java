package hust.soict.globalict.garbage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GarbageCreator {
	public static void main(String[] args) {
		String helu = "";
		File file = new File("F:\\School\\projects\\OOLT.20192\\OtherProjects\\src\\hust\\soict\\globalict\\garbage\\LoremIpsum.txt");
		try {
			Scanner sc = new Scanner(file);
			while(sc.hasNext()) {
				helu = helu + sc.next();
			}
			System.out.println("Done reading file");
			sc.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Error!");
			e.printStackTrace();
		}
		
		System.out.println("Done");
		
	}
}
