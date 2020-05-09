package hust.soict.globalict.test.media;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import hust.soict.globalict.aims.media.CompactDisc;
import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.aims.media.Track;

public class TestMediaCompareTo {
	
	
	public static void main(String[] args) {
		Collection<Media> collection  = new ArrayList<Media>();
		
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", 19.95f);

		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", 24.95f);

		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Alladin", "Animation", 18.99f);

		DigitalVideoDisc dvd4 = new DigitalVideoDisc("My life", "Commedy", 0.01f);
		
		/*
		 * collection.add(dvd1); collection.add(dvd2); collection.add(dvd3);
		 * collection.add(dvd4);
		 * 
		 * System.out.println("Before sorting dvd:");
		 * TestMediaCompareTo.print(collection);
		 * 
		 * System.out.println("\nAfter sorting dvd:"); Collections.sort((List)
		 * collection); TestMediaCompareTo.print(collection);
		 */
		
		System.out.println("\n\n--------------Toi la dai phan cach-------------------");
		Collection<Media> col = new ArrayList<Media>();
		CompactDisc cd1 = new CompactDisc("Evolve", "Alternative rock", 15.5f);
		cd1.addTrack(new Track("Whatever it takes", 4));
		cd1.addTrack(new Track("Believer", 5));
		cd1.addTrack(new Track("Walking the wire", 4));
		
		CompactDisc cd2 = new CompactDisc("Coast to coast", "Ballad/R&B", 15.5f);
		cd2.addTrack(new Track("My Love", 4));
		cd2.addTrack(new Track("I lay my love on you", 2));
		cd2.addTrack(new Track("Soledad", 2));
		cd2.addTrack(new Track("Whatever makes a man", 5));
		
		CompactDisc cd3 = new CompactDisc("LSD", "Pop", 18.0f);
		cd3.addTrack(new Track("Genius", 3));
		cd3.addTrack(new Track("Thunderclouds", 3));
		cd3.addTrack(new Track("No new friends", 4));
		cd3.addTrack(new Track("Genius (Lil Wayne remix", 2));
		col.add(cd1);
		col.add(cd2);
		col.add(cd3);
		col.add(dvd1);
		col.add(dvd2);
		col.add(dvd3);
		col.add(dvd4);
		System.out.println("\n\n--------------Toi la dai phan cach-------------------");
		System.out.println("\n\nBefore sorting CDs: ");
		TestMediaCompareTo.print(col);
		System.out.println("\nAfter sorting CDs: ");
		Collections.sort( (List) col);
		TestMediaCompareTo.print(col);
	}
	
	public static void  print(Collection<Media> col) {
		for(Media m: col) {
			System.out.println(m.getTitle());
		}
	}

}
