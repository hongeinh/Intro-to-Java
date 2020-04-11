package hust.soict.globalict.test.disc;
import hust.soict.globalict.aims.media.DigitalVideoDisc;

/**
 * @author Nguyen Thi Hong Anh
 * */

public class TessPassingParameter {
	public static void main(String[] args) {
		DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle", "animation", 0.0f);
		DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Cinderella", "animation", 0.0f);

		swap(jungleDVD, cinderellaDVD);
		System.out.println("Jungle DVD title: " + jungleDVD.getTitle());
		System.out.println("Cinderella DVD title: " + cinderellaDVD.getTitle());

		changeTitle(jungleDVD, cinderellaDVD.getTitle());
		System.out.println("Jungle dvd title: " + jungleDVD.getTitle());

	}

	private static void changeTitle(DigitalVideoDisc dvd, String title) {
		// TODO Auto-generated method stub
		String oldTitle = dvd.getTitle();
		dvd.setTitle(title);
		dvd = new DigitalVideoDisc(oldTitle, "animation", 0.0f);
	}

	private static void swap(DigitalVideoDisc obj1, DigitalVideoDisc obj2) {
		// TODO Auto-generated method stub
		String title = obj1.getTitle();
		String director = obj1.getDirector();
		String category = obj1.getCategory();
		int length = obj1.getLength();
		float cost = obj1.getCost();
		
		obj1.setTitle(obj2.getTitle()); 
		obj1.setCategory(obj2.getCategory());
		obj1.setDirector(obj2.getDirector());
		obj1.setCost(obj2.getCost());
		obj1.setLength(obj2.getLength());
		
		obj2.setTitle(title); 
		obj2.setCategory(category);
		obj2.setDirector(director);
		obj2.setCost(cost);
		obj2.setLength(length);
		
	}
}

/*
 * Can refer to JAVA REFLECTION
 * 
 * */

/*
 * Why after swatch not change? Because when we pass the 2 dvds to swap
 * function, what we pass are their references, not the actual objects
 * themselves So when the references swap title of each other, it is just
 * between these 2 references, and has nothing to do with the 2 actual objects
 */

/*
 * Why after changeTitle(), title changes? Because when we pass the reference of
 * jungleDVD to the method, inside this method, this reference alters the value
 * of the object
 */
