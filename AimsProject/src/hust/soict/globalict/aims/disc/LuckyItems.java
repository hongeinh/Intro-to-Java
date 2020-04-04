package hust.soict.globalict.aims.disc;

import java.util.HashMap;

public class LuckyItems {
	DigitalVideoDisc d0 = new DigitalVideoDisc("12 years of slavery", "drama", "Steve McQueen");
	DigitalVideoDisc d1 = new DigitalVideoDisc("The Shawshank redemption", "drama", "Frank Darabont");
	DigitalVideoDisc d2 = new DigitalVideoDisc("Forrest Gump", "realism comedy", "Robert Zemeckis");
	DigitalVideoDisc d3 = new DigitalVideoDisc("Interstellar", "science fiction", "Christopher Nolan");
	DigitalVideoDisc d4 = new DigitalVideoDisc("God father", "crime/drama", "Francis Ford Coppola");
	DigitalVideoDisc d5 = new DigitalVideoDisc("Fight club", "drama", "David Fincher");
	DigitalVideoDisc d6 = new DigitalVideoDisc("Lion King", "animation", "Jon Favreau");
	DigitalVideoDisc d7 = new DigitalVideoDisc("3 Idiots", "commedy", "Rajkumar Hirani");
	DigitalVideoDisc d8 = new DigitalVideoDisc("Inception", "science fiction", "Christopher Nolan");
	DigitalVideoDisc d9 = new DigitalVideoDisc("Lion King", "animation", "Jon Favreau");
	
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
