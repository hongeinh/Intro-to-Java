package hust.soict.globalict.garbage;

import java.util.Random;

public class ConcatenationInLoops {
	public static void main(String[] args) {
		Random rand = new Random(600);
		long start = System.currentTimeMillis();
		String helu = "Hong Einh is cute times ";
		for(int i = 0; i < 65536; i++) {
			helu = helu + rand.nextInt(2);
		}
		System.out.println(System.currentTimeMillis() - start);					//2962
		
		rand = new Random(123);
		start = System.currentTimeMillis();
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < 65536; i++) {
			sb.append(rand.nextInt(2));
		}
		helu = sb.toString();
		System.out.println(System.currentTimeMillis() - start);					// 4
	}
}
