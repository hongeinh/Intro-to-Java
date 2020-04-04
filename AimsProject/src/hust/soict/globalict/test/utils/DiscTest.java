package hust.soict.globalict.test.utils;

import java.util.Scanner;

import hust.soict.globalict.aims.disc.DigitalVideoDisc;
import hust.soict.globalict.aims.order.Order;

public class DiscTest {

	public static void main(String[] args) {
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 8, 19.95f);

		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 124, 24.95f);

		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Alladin", "Animation", "John Musker", 90, 18.99f);

		DigitalVideoDisc dvd4 = new DigitalVideoDisc("My life", "Commedy", "Nguyen Thi Hong Anh", 1000, 0.01f);

		DigitalVideoDisc dvd5 = new DigitalVideoDisc("Spirited Away", "Animation", "Hayao Miyazaki", 90, 15.5f);

		DigitalVideoDisc dvd6 = new DigitalVideoDisc("Howl's Moving Castle", "Animation", "Hayao Miyazaki", 95, 13.75f);

		DigitalVideoDisc dvd7 = new DigitalVideoDisc("Princess Mononoke", "Animation", "Hayao Miyazaki", 85, 15.0f);

		DigitalVideoDisc dvd8 = new DigitalVideoDisc("Ponyo", "Animation", "Hayao Miyazaki", 80, 11.25f);

		DigitalVideoDisc dvd9 = new DigitalVideoDisc("Laputa Castle in the sky", "Animation", "Hayao Miyazaki", 100,
				13.25f);

		DigitalVideoDisc dvd10 = new DigitalVideoDisc("The cat returns", "Animation", "Hayao Miyazaki", 80, 10.25f);

		DigitalVideoDisc dvd11 = new DigitalVideoDisc("Kiki's Delivery service", "Animation", "Hayao Miyazaki", 85,
				11.25f);
		
		DigitalVideoDisc [] dvdList = {dvd1, dvd2, dvd3, dvd4, dvd5, dvd6, dvd7, dvd8, dvd9, dvd10, dvd11};
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter title to search: ");
		String title = sc.nextLine();
		
		boolean isFound = false;
		
		for(DigitalVideoDisc d: dvdList) {
			isFound = d.search(title);
			if(isFound == true) {
				System.out.println("Sis we have yo DVD!");
				break;
			}
		}
		if(isFound == false) {
			System.out.println("No DVD of dat title found sorry");
		}
		
		System.out.println("Hey babe you will get a free item <3");
		DigitalVideoDisc freeItem = Order.getALuckyItem();
		System.out.println(freeItem.getTitle() + " by " + freeItem.getDirector());
		sc.close();
	}
}
