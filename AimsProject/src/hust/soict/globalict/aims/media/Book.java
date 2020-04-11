package hust.soict.globalict.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media {

	protected List<String> authors = new ArrayList<String>();

	public int findAuthor(String authorName) {
		int isFound = -1;
		String temp = authorName.toLowerCase();
		int sz = authors.size();
		for (int i = 0; i < sz; i++) {
			if (authors.get(i).toLowerCase().equals(temp)) {
				isFound = i;
				break;
			}
		}
		return isFound;
	}

	Book(String title) {
		super(title);
	}
	Book(String title, String category) {
		super(title, category);
	}
	Book(String title, String category, float cost) {
		super(title, category, cost);
	}
	
	Book(String title, String category, List<String> authors) {
		super(title, category);
		int sz = authors.size();
		for(int i = 0; i < sz; i++) {
			addAuthor(authors.get(i));
		}
	}
	
	
	public static Media createMedia(String title, String category, float cost) {
		return new Book(title, category, cost);
	}
	public void addAuthor(String authorName) {
		int isFound = findAuthor(authorName);
		if (isFound == -1) {
			authors.add(authorName.trim());
			System.out.println("Author " + authorName + " added to author list successfully!");
		} else {
			System.out.println("Author " + authorName + " already exists in author list");
		}
	}
	
	public void removeAuthor(String authorName) {
		int isFound = findAuthor(authorName);
		if (isFound == -1) {
			System.out.println("Can not find author " + authorName);
		} else {
			authors.remove(isFound);
		}
	}
}
