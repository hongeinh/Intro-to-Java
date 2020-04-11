package hust.soict.globalict.aims.order;

import java.util.ArrayList;

import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.media.LuckyItems;
import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.aims.utils.MyDate;

/**
 * @author Nguyen Thi Hong Anh
 */

public class Order {
	public static final int MAX_NUMBER_ORDERED = 10;
	private MyDate dateOrdered;
	public static final int MAX_LIMITED_ORDERS = 5;
	private static int nbOrders = 0;
	private ArrayList<Media> itemsOrdered = new ArrayList<Media>();
	private String orderId;

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public ArrayList<Media> getItemsOrdered() {
		return itemsOrdered;
	}

	public void setItemsOrdered(ArrayList<Media> itemsOrdered) {
		this.itemsOrdered = itemsOrdered;
	}

	private Order() {
		dateOrdered = new MyDate();
		setOrderId("OD" + Integer.toString(nbOrders));
		nbOrders++;
	}

	public static Order createOrder() {
		if (nbOrders == MAX_LIMITED_ORDERS) {
			return null;
		} else {
			return new Order();
		}
	}

	public void addMedia(Media m) {
		if (itemsOrdered.size() < MAX_NUMBER_ORDERED) {
			itemsOrdered.add(m);
			System.out.println(m.getTitle() + " of ID: " + m.getMediaId() + " added succesfully!");
		} else {
			System.out.println("Can not add " + m.getTitle() + " to the order!\nMax number of items reached");
		}
	}

	public void addMedia(Media m1, Media m2) {
		addMedia(m1);
		addMedia(m2);
	}

	public void addMedia(Media[] mediaList) {
		int sz = mediaList.length;
		for (int i = 0; i < sz; i++) {
			addMedia(mediaList[i]);
		}
	}

	public void removeMedia(String id) {
		int sz = itemsOrdered.size();
		for (int i = 0; i < sz; i++) {
			if (itemsOrdered.get(i).getMediaId().equals(id)) {
				itemsOrdered.remove(i);
				System.out.println("Item of id: " + id + " removed successfully!");
				return;
			}
		}
		System.out.println("Can not find media " + id + "\nRemoval unsuccess.");
	}

	public void displayOrder() {
		System.out.println(
				"-------------------------------------------------------ORDERS-------------------------------------------------------");
		System.out.print("Date created: ");
		dateOrdered.print();
		System.out.println("Order's ID: " + getOrderId());
		System.out.format("%-5s%-20s%-40s | %-20s | %-10s\n", "No.", "ID", "Title", "Category", "Cost");
		System.out.println(
				"--------------------------------------------------------------------------------------------------------------------");
		int sz = itemsOrdered.size();
		for (int i = 0; i < sz; i++) {
			System.out.format("%-5d%-20s%-40s | %-20s | %-10.2f\n", i + 1, itemsOrdered.get(i).getMediaId(),
					itemsOrdered.get(i).getTitle(), itemsOrdered.get(i).getCategory(), itemsOrdered.get(i).getCost());
		}
		System.out.println("Lucky Item: ");
		DigitalVideoDisc lucky = Order.getALuckyItem();
		System.out.format("%-5d%-20s%-40s | %-20s | %-10.2f | %-20s | %-20s\n", 0, "", lucky.getTitle(),
				lucky.getCategory(), lucky.getCost(), lucky.getDirector(), lucky.getLength());
		System.out.println("Total items in order: " + sz);
		System.out.println("Total cost: " + totalCost());
	}

	public float totalCost() {
		float sum = 0.0f;
		int sz = itemsOrdered.size();
		for (int i = 0; i < sz; i++) {
			sum += itemsOrdered.get(i).getCost();
		}
		return sum;
	}

	/**
	 * Lab 05 requirement This function returns a lucky item for the customer
	 * randomly
	 */
	public static DigitalVideoDisc getALuckyItem() {
		LuckyItems li = new LuckyItems();
		int sz = li.getItemsSize();
		int rand = (int) (Math.random() * 100) % sz;
		return li.getLuckyDisc(rand);
	}
}
