package hust.soict.globalict.aims.media;

import java.util.HashMap;

public class LuckyItems {
	DigitalVideoDisc d0 = new DigitalVideoDisc("12 years of slavery", "drama", "Steve McQueen", 120, 0.0f);
	DigitalVideoDisc d1 = new DigitalVideoDisc("The Shawshank redemption", "drama", "Frank Darabont", 119, 0.0f);
	DigitalVideoDisc d2 = new DigitalVideoDisc("Forrest Gump", "realism comedy", "Robert Zemeckis", 118, 0.0f);
	DigitalVideoDisc d3 = new DigitalVideoDisc("Interstellar", "science fiction", "Christopher Nolan", 117, 0.0f);
	DigitalVideoDisc d4 = new DigitalVideoDisc("God father", "crime/drama", "Francis Ford Coppola", 121, 0.0f);
	DigitalVideoDisc d5 = new DigitalVideoDisc("Fight club", "drama", "David Fincher", 110, 0.0f);
	DigitalVideoDisc d6 = new DigitalVideoDisc("Lion King", "animation", "Jon Favreau", 100, 0.0f);
	DigitalVideoDisc d7 = new DigitalVideoDisc("3 Idiots", "commedy", "Rajkumar Hirani", 101, 0.0f);
	DigitalVideoDisc d8 = new DigitalVideoDisc("Inception", "science fiction", "Christopher Nolan", 125, 0.0f);
	DigitalVideoDisc d9 = new DigitalVideoDisc("High school musical", "Musical drama", "Kenny Ortega", 90, 0.0f );
	
	HashMap<Integer, DigitalVideoDisc> items = new HashMap<Integer, DigitalVideoDisc>();

	public LuckyItems(){
		items.put(0, d0);
		items.put(1, d1);
		items.put(2, d2);
		items.put(3, d3);
		items.put(4, d4);
		items.put(5, d5);
		items.put(6, d6);
		items.put(7, d7);
		items.put(8, d8);
		items.put(9, d9);
	}
	
	public int getItemsSize() {
		return this.items.size();
	}
	public DigitalVideoDisc getLuckyDisc(int i) {
		if(items.containsKey(i)) {
			return items.get(i);
		}
		else return null;
	}
	
}
