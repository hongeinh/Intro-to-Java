package hust.soict.globalict.aims.media;

import hust.soict.globalict.aims.playable.Playable;

public class Track implements Playable, Comparable{
	private String title;
	private int length;
	
	public String getTitle() {
		return title;
	}

	public int getLength() {
		return length;
	}

	public Track(String title, int length) {
		this.title = title;
		this.length = length;
	}

	@Override
	public void play() {
		System.out.println("Playing Track: " + this.getTitle());
		System.out.println("Track length: " + this.getLength());
	}

	@Override
	/**
	 * Compare whether this track and other is equal.
	 * The correct way to override equals is to always check whether the passing parameter is an instance of the class of this obj.
	 * And only after that can we down cast the passing parameter
	 * */
	
	public boolean equals(Object other)
	{
	    if (!(other instanceof Track))
	        return false;
	    Track p = (Track) other;
	    return p.getLength() == this.getLength() && p.getTitle().contentEquals(this.getTitle());
	}

	@Override
	public int compareTo(Object o) {
		if(! (o instanceof Track)) {
			return -1;
		}
		Track t = (Track) o;
		return this.getTitle().compareTo(t.getTitle());
	} 
}
