package hust.soict.globalict.aims.disc;

import java.util.Arrays;

/**
 * @author Nguyen Thi Hong Anh
 * */
public class DigitalVideoDisc {
	private String title;
	private String category;
	private String director;
	private int length;
	private float cost;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
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
	public float getCost() {
		return cost;
	}
	public void setCost(float cost) {
		this.cost = cost;
	}
	
	public DigitalVideoDisc(String title){
		this.title = title;
	}
	public DigitalVideoDisc(String title, String category){
		this(title);
		this.category = category;
	}
	public DigitalVideoDisc(String title, String category, String director ){
		this(title, category);
		this.director = director;
	}
	public DigitalVideoDisc(String title, String category, String director, int length, float cost){
		this(title, category, director);
		this.length = length;
		this.cost = cost;
	}
	/**
	 * Lab 05 requirement
	 * This function checks whether the input title matches this object's title
	 * It breaks both strings into word tokens and stores them into 2 arrays
	 * These 2 arrays will then be compared regardless of case and order.
	 * */
	public boolean search(String title) {
		String [] tokens = title.toLowerCase().split(" ");
		String [] thisTokens = this.getTitle().toLowerCase().split(" ");
		
		Arrays.sort(tokens);
		Arrays.sort(thisTokens);
		boolean isFound = Arrays.equals(tokens, thisTokens);
		return isFound;
	}
}
