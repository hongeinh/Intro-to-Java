package hust.soict.globalict.aims.media;

/**
 * @author Nguyen Thi Hong Anh
 * */
public class DigitalVideoDisc extends Media{
	private String director;
	private int length;
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	
	DigitalVideoDisc(String title, String category, String director ){
		super(title, category);
		this.director = director;
	}
	DigitalVideoDisc(String title, String category, float cost) {
		super(title, category, cost);
	}
	DigitalVideoDisc(String title, String category, String director, int length, float cost){
		this(title, category, cost);
		this.director = director;
		this.length = length;
	}

	/**
	 * Lab 05 requirement
	 * This function checks whether the input title matches this object's title
	 * It breaks both strings into word tokens and stores them into 2 arrays
	 * These 2 arrays will then be compared regardless of case and order.
	 * */
	public boolean search(String title) {
		String [] tokens = title.toLowerCase().split(" ");
		String thisToken = this.getTitle().toLowerCase();
		boolean isFound = true;
		for(String i: tokens) {
			if(!thisToken.contains(i)) {
				isFound = false;
				break;
			}
		}
		return isFound;
	}
	
	public static Media createMedia(String title, String category, float cost) {
		return new DigitalVideoDisc(title, category, cost);
	}
}
