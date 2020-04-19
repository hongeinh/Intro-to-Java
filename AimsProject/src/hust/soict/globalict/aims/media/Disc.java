package hust.soict.globalict.aims.media;

public class Disc extends Media {
	protected int length;
	private String director;
	
	public int getLength() {
		return length;
	}

	public String getDirector() {
		return director;
	}

	public Disc(String title) {
		super(title);
	}

	public Disc(String title, String category) {
		super(title, category);
	}
	
	public Disc(String title, String category, float cost) {
		super(title, category, cost);
	}
	
	public Disc(String title, String category, int length, float cost) {
		super(title, category, cost);
		this.length = length;
	}
	public Disc(String title, String category, String director, int length, float cost) {
		super(title, category, cost);
		this.director = director;
		this.length = length;
	}
}
