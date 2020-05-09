package hust.soict.globalict.aims.media;

import java.util.ArrayList;

import hust.soict.globalict.aims.playable.Playable;

public class CompactDisc extends Disc implements Playable, Comparable {
	private String artist;
	private ArrayList<Track> tracks = new ArrayList<Track>();
	
	
	public ArrayList<Track> getTracks() {
		return tracks;
	}

	public CompactDisc(String title) {
		super(title);
		String tempID = this.getMediaId();
		this.setMediaId("cd" + tempID);
	}

	public CompactDisc(String title, String category) {
		super(title, category);
		String tempID = this.getMediaId();
		this.setMediaId("cd" + tempID);
	}

	public CompactDisc(String title, String category, float cost) {
		super(title, category, cost);
		String tempID = this.getMediaId();
		this.setMediaId("cd" + tempID);
	}

	public CompactDisc(String title, String category, String artist, int length, float cost) {
		super(title, category, length, cost);
		this.artist = artist;
		String tempID = this.getMediaId();
		this.setMediaId("cd" + tempID);
	}
	public String getArtist() {
		return artist;
	}
	

	public int findTrack(Track t) {
		int sz = tracks.size();
		for(int i = 0; i < sz; i++) {
			if(tracks.get(i).equals(t)) {
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

	
	/*
	 * This function is in lab08.6's requirement
	 * It sorts CD first by number of tracks
	 * If number of tracks are equal, sort by total length
 	 * */
	
	@Override
	public int compareTo(Object o) {
		if( !(o instanceof CompactDisc)) {
			return -1;
		}
		CompactDisc c = (CompactDisc) o;
		int tsz = this.getTracks().size();
		int osz = c.getTracks().size();
		
		if(tsz < osz) return -1;
		else if(tsz > osz) return 1;
		else {
			int tlen = this.getLength();
			int olen = c.getLength();
			if(tlen < olen) return -1;
			else if(tlen > olen) return 1;
			else return 0;
		}
	}
}
