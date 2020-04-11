package hust.soict.globalict.aims.media;

public class Media {
	private static int nbMediaUsed = 0;
	private String title;
	private String category;
	private float cost;
	private String mediaId;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public float getCost() {
		return cost;
	}
	public void setCost(float cost) {
		this.cost = cost;
	}
	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}
	public Media(String title) {
		this.title = title;
		nbMediaUsed++;
		setMediaId("MDI" + Integer.toString(nbMediaUsed));
	}
	public Media(String title, String category) {
		this(title);
		this.category = category;
	}
	public Media(String title, String category, float cost) {
		this(title, category);
		this.cost = cost;
	}
	public String getMediaId() {
		return mediaId;
	}
}
