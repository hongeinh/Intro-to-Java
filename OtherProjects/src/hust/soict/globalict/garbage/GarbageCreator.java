package hust.soict.globalict.garbage;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class GarbageCreator {
	public static void main(String[] args) {
		String helu = "";
		Path path = Paths.get("\\OOLT.20192\\OtherProjects\\src\\hust\\soict\\globalict\\garbage\\LoremIpsum.txt");
		File file = new File(path.toString());
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
