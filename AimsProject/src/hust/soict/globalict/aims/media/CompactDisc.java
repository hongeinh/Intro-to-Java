package hust.soict.globalict.aims.media;

import java.util.ArrayList;

import hust.soict.globalict.aims.playable.Playable;

public class CompactDisc extends Disc implements Playable {
	private String artist;
	//private int length;
	private ArrayList<Track> tracks = new ArrayList<Track>();
	public CompactDisc(String title) {
		super(title);
	}

	public CompactDisc(String title, String category) {
		super(title, category);
	}

	public CompactDisc(String title, String category, float cost) {
		super(title, category, cost);
	}

	public CompactDisc(String title, String category, String artist, int length, float cost) {
		super(title, category, length, cost);
		this.artist = artist;
	}
	public String getArtist() {
		return artist;
	}
	
	public int findTrack(Track t) {
		int sz = tracks.size();
		for(int i = 0; i < sz; i++) {
			if(tracks.get(i).getTitle() == t.getTitle() && tracks.get(i).getLength() == t.getLength()) {
				return i;
			}
		}
		return -1;
	}
	public void addTrack(Track t) {
		int idx = findTrack(t);
		if(idx == -1) {
			tracks.add(t);
			System.out.println("Track " + t.getTitle() + " added to track list successfully.");
		} else {
			System.out.println("Track " + t.getTitle() + " is already in track list.");
		}
	}
	
	public void removeTrack(Track t) {
		int idx = findTrack(t);
		if(idx == -1) {
			System.out.println("Track " + t.getTitle() + " is not in track list. Cannot remove track.");
		} else {
			tracks.remove(idx);
			System.out.println("Track " + t.getTitle() + " removed successfully!");
		}
	}
	
	public int getLength() {
		length = 0;
		for(Track track: tracks) {
			length += track.getLength();
		}
		return length;
	}

	@Override
	public void play() {
		System.out.println("------ Playing CD " + this.getTitle());
		for(Track track: tracks) {
			System.out.println("+++");
			track.play();
		}
		System.out.println("------ CD length: " + getLength());
	}
}
