package hust.soict.globalict.aims.media;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Book extends Media implements Comparable {

	protected List<String> authors = new ArrayList<String>();
	private String content;
	private List<String> contentTokens = new ArrayList<String>();
	private Map<String, Integer> wordFrequency = new HashMap<String, Integer>();
	TreeMap<String, Integer> sorted = new TreeMap<String, Integer>();

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public List<String> getContentTokens() {
		return contentTokens;
	}

	public Map<String, Integer> getWordFrequency() {
		return wordFrequency;
	}

	public void setContentTokens(List<String> contentTokens) {
		this.contentTokens = contentTokens;
	}

	public void setWordFrequency(Map<String, Integer> wordFrequency) {
		this.wordFrequency = wordFrequency;
	}

	public Book(String title) {
		super(title);
		String tempID = this.getMediaId();
		this.setMediaId("b" + tempID);
	}

	public Book(String title, String category) {
		super(title, category);
		String tempID = this.getMediaId();
		this.setMediaId("b" + tempID);
	}

	public Book(String title, String category, float cost) {
		super(title, category, cost);
		String tempID = this.getMediaId();
		this.setMediaId("b" + tempID);
	}

	public Book(String title, String category, List<String> authors) {
		super(title, category);
		int sz = authors.size();
		for (int i = 0; i < sz; i++) {
			addAuthor(authors.get(i));
		}
		String tempID = this.getMediaId();
		this.setMediaId("b" + tempID);
	}

	public Book(String title, String category, List<String> authors, float cost) {
		super(title, category, cost);
		int sz = authors.size();
		for (int i = 0; i < sz; i++) {
			addAuthor(authors.get(i));
		}
		String tempID = this.getMediaId();
		this.setMediaId("b" + tempID);
	}
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

	@Override
	public int compareTo(Object o) {
		if (!(o instanceof Book)) {
			return -1;
		}
		Book b = (Book) o;
		return this.getTitle().compareTo(b.getTitle());
	}

	/*
	 * This function is created for the sake of Lab 08.8's requirement It prompts
	 * user to add content to a Book object.
	 */
	public void createContent() {
		System.out.print("Add content to book pls:\n-->:  ");
		Scanner sc = new Scanner(System.in);
		String tmp = sc.nextLine();
		if (tmp == null) {
			System.out.println("Invalid content. ");
			return;
		}
		setContent(tmp);
	}

	/*
	 * This function is created for the sake of Lab08.8's requirement only. Split
	 * contents by space or punctuations, then sort and add to contentTokens list
	 * Count frequency of each tokens, then sort Content token can be repetitive
	 */
	public void processContent() {
		String content = getContent();
		/*
		 * content = content.replace(".", ""); content = content.replace(",", "");
		 * content = content.replace("?", ""); content = content.replace("!", "");
		 * content = content.replace(":", ""); content = content.replace(";", "");
		 * content = content.replace("-", ""); content = content.replace("_", "");
		 * content = content.replace("#", ""); content = content.replace("\"", "");
		 * content = content.replace("%", ""); content = content.replace("&", "");
		 * content = content.replace("^", ""); content = content.replace("*", "");
		 * content = content.replace("(", ""); content = content.replace(")", "");
		 * content = content.replace("[", ""); content = content.replace("]", "");
		 * content = content.replace("@", ""); content = content.replace(">", "");
		 * content = content.replace("<", ""); content = content.replace("=", "");
		 * content = content.replace("{", ""); content = content.replace("}", "");
		 * content = content.replace("/", ""); content = content.replace("~", "");
		 * content = content.replace("+", ""); content = content.replace("$", "");
		 */	
		content = content.replaceAll("\\p{Punct}", "");
		setContent(content);
		// content.replaceAll("\\p{Punct}", " ");
		String[] tokens = content.split(" ");
		//Arrays.sort(tokens);
		int sz = tokens.length;
		for (int i = 0; i < sz; i++) {
			if (!wordFrequency.containsKey(tokens[i])) {
				contentTokens.add(tokens[i]);
			}
			wordFrequency.put(tokens[i], wordFrequency.getOrDefault(tokens[i], 0) + 1);
		}

		sorted.putAll(wordFrequency);
		System.out.println("Word frequency in process content ");
		/*
		for (Map.Entry<String, Integer> entry : sorted.entrySet()) {
			System.out.println(entry.getKey() + "\t" + entry.getValue());
		}*/
	}

	@Override
	public String toString() {
		StringBuilder toReturn = new StringBuilder(
				"Title: " + getTitle() + "\nCategory: " + getCategory() + "\nAuthors: ");
		for (String au : authors) {
			toReturn.append(au);
			toReturn.append(" 	 ");
		}
		toReturn.append("\nContent: ");
		for (String cont : contentTokens) {
			toReturn.append(cont);
			toReturn.append(" ");
		}
		toReturn.append("\nWord Frequency:\n");
		for (Map.Entry<String, Integer> entry : sorted.entrySet()) {
			if(!entry.getKey().equals("")) {
				toReturn.append(entry.getKey() + ":  " + Integer.toString(entry.getValue()) + "\n");
			}
		}
		return toReturn.toString();
	}

	public List<String> getAuthors() {
		return authors;
	}

	public void setAuthors(List<String> authors) {
		this.authors = authors;
	}
}
