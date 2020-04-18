package hust.soict.globalict.test.utils;

import java.util.ArrayList;
import java.util.Scanner;

import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.aims.order.Order;

public class DiscTest {

	public static void main(String[] args) {
		Order anOrder = Order.createOrder();
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", 19.95f);
		dvd1.setDirector("Roger Allers");
		dvd1.setLength(8);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", 24.95f);
		dvd2.setDirector("George Lucas");
		dvd2.setLength(124);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Alladin", "Animation", 18.99f);
		dvd3.setDirector("John Musker");
		dvd3.setLength(8);
		DigitalVideoDisc dvd4 = new DigitalVideoDisc("My life", "Commedy", 0.01f);
		dvd4.setDirector("Nguyen Thi Hong Anh");
		dvd4.setLength(1000);
		DigitalVideoDisc dvd5 = new DigitalVideoDisc("Spirited Away", "Animation", 15.5f);
		dvd5.setDirector("Hayao Miyazaki");
		dvd5.setLength(90);
		DigitalVideoDisc dvd6 = new DigitalVideoDisc("Howl's Moving Castle", "Animation",
				13.75f);
		dvd6.setDirector("Hayao Miyazaki");
		dvd6.setLength(95);
		DigitalVideoDisc dvd7 = new DigitalVideoDisc("Princess Mononoke", "Animation",
				15.0f);
		dvd7.setDirector("Hayao Miyazaki");
		dvd7.setLength(85);
		DigitalVideoDisc dvd8 = new DigitalVideoDisc("Ponyo", "Animation", 11.25f);
		dvd8.setDirector("Hayao Miyazaki");
		dvd8.setLength(80);
		DigitalVideoDisc dvd9 = new DigitalVideoDisc("Laputa Castle in the sky", "Animation",
				13.25f);
		dvd9.setDirector("Hayao Miyazaki");
		dvd9.setLength(100);
		DigitalVideoDisc dvd10 = new DigitalVideoDisc("The cat returns", "Animation",
				10.25f);
		dvd10.setDirector("Hayao Miyazaki");
		dvd10.setLength(80);
		DigitalVideoDisc dvd11 = new DigitalVideoDisc("Kiki's Delivery service", "Animation",
				11.25f);
		dvd11.setDirector("Hayao Miyazaki");
		dvd11.setLength(85);
		DigitalVideoDisc[] ghibliList = { dvd5, dvd6, dvd7, dvd8, dvd9, dvd10, dvd11 };
		if (anOrder == null) {
			System.out.println("Can not add more order!\nMaximum number of orders allowed reached!\n");
		} else {
			anOrder.addMedia(dvd1);
			anOrder.addMedia(dvd2);
			anOrder.addMedia(dvd3);
			anOrder.addMedia(dvd4);
			anOrder.addMedia(ghibliList);

			anOrder.displayOrder();
		}

		boolean isFound = false;

		Scanner sc = new Scanner(System.in);
		System.out.print("\n\nEnter title to search: ");
		String title = sc.nextLine();
		ArrayList<Media> dvdList = anOrder.getItemsOrdered();
		for (Media d : dvdList) {
			if (d.getTitle().contentEquals(title)) {
				System.out.println("Sis we have yo thang!");
				break;
			}
		}
		if (isFound == false) {
			System.out.println("No thang of dat title found sorry");
		}
		sc.close();
	}
}
