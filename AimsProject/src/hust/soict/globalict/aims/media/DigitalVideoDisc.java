package hust.soict.globalict.aims.media;

import hust.soict.globalict.aims.playable.Playable;

/**
 * @author Nguyen Thi Hong Anh
 * */
public class DigitalVideoDisc extends Disc implements Playable, Comparable{
	private String director;
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
	
	public DigitalVideoDisc(String title, String category, String director ){
		super(title, category);
		String tempID = this.getMediaId();
		this.setMediaId("dvd" + tempID);
		this.director = director;
	}
	public DigitalVideoDisc(String title, String category, float cost) {
		super(title, category, cost);
		String tempID = this.getMediaId();
		this.setMediaId("dvd" + tempID);
	}
	public DigitalVideoDisc(String title, String category, String director, int length, float cost){
		super(title, category, length, cost);
		this.director = director;
		String tempID = this.getMediaId();
		this.setMediaId("dvd" + tempID);
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
	@Override
	public void play() {
		System.out.println("Playing DVD: " + this.getTitle());
		System.out.println("DVD length: " + this.getLength());
		
	}
	/*
	 * This function is in lab08.06's requirement
	 * Sort DVD by cost
	 * */
	
	@Override
	public int compareTo(Object o) {
		if( !(o instanceof DigitalVideoDisc)) {
			return -1;
		}
		DigitalVideoDisc c = (DigitalVideoDisc) o;
		float tc = this.getCost();
		float cc = c.getCost();
		
		if(tc < cc ) return -1;
		else if(tc == cc ) return 0;
		else return 1;
	}
}
