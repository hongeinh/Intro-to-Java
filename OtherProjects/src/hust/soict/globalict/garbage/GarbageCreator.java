package hust.soict.globalict.garbage;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class GarbageCreator {
	public static void main(String[] args) {
		String helu = "";
		//Path path = Paths.get("test.txt");
		Path path = Paths.get("LoremIpsum.txt");
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
//		Random rand = new Random(600);
//		long start = System.currentTimeMillis();
//		String helu = "Hong Einh is cute times ";
//		for(int i = 0; i < Integer.MAX_VALUE; i++) {
//			helu = helu + rand.nextInt(2);
//		}
//		System.out.println(System.currentTimeMillis() - start);
	}
}
