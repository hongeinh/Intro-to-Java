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
	public String getMediaId() {
		return mediaId;
	}
	Media(String title) {
		this.title = title;
		nbMediaUsed++;
		setMediaId("MDI" + Integer.toString(nbMediaUsed));
	}
	Media(String title, String category) {
		this(title);
		this.category = category;
	}
	Media(String title, String category, float cost) {
		this(title, category);
		this.cost = cost;
	}
	
	public static Media createMedia(String title, String category, float cost) {
		return new Media(title, category, cost);
	}
}
