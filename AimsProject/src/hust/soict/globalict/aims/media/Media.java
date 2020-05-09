package hust.soict.globalict.aims.media;

public abstract class Media{
	private String title;
	private String category;
	private float cost;
	private String mediaId;

	public String getTitle() {
		return title;
	}

	public String getCategory() {
		return category;
	}

	public float getCost() {
		return cost;
	}

	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}

	public String getMediaId() {
		return mediaId;
	}

	// fix ID generator
	public Media(String title) {
		this.title = title;
		String[] tokens = title.split(" ");
		String id = "";
		for (String tok : tokens) {
			id = id + tok.charAt(0);
		}
		setMediaId(id + Integer.toString(title.length()));
	}

	public Media(String title, String category) {
		this(title);
		this.category = category;
	}

	public Media(String title, String category, float cost) {
		this(title, category);
		this.cost = cost;
	}

	@Override
	public boolean equals(Object other) {
		if (!(other instanceof Media))
			return false;
		Media p = (Media) other;
		return p.getMediaId().equals(this.getMediaId());
	}
	/*
	 * This function is in Lab08.05's requirement
	 * To sort media objects by title
	 * */
	
	
	/*
	public int compareTo(Object o) {
		if( !(o instanceof Media)) {
			return -1;
		}
		Media b = (Media) o;
		return this.getTitle().compareTo(b.getTitle());
	}*/
}
