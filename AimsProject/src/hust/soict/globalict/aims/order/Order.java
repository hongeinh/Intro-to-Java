package hust.soict.globalict.aims.order;

import hust.soict.globalict.aims.disc.DigitalVideoDisc;
import hust.soict.globalict.aims.disc.LuckyItems;
import hust.soict.globalict.aims.utils.MyDate;

/**
 * @author Nguyen Thi Hong Anh
 */

public class Order {
	public static final int MAX_NUMBER_ORDERED = 10;
	private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBER_ORDERED];
	private int qtyOrdered = 0;
	private MyDate dateOrdered;
	public static final int MAX_LIMITED_ORDERS = 5;
	private static int nbOrders = 0;

	private Order() {
		dateOrdered = new MyDate();
		nbOrders++;
	}

	public static Order createOrder() {
		if (nbOrders == MAX_LIMITED_ORDERS) {
			return null;
		} else {
			return new Order();
		}
	}

	public int findDigitalVideoDisc(DigitalVideoDisc disc, int qty) {

		for (int i = 0; i < qty; i++) {
			if (itemsOrdered[i].equals(disc)) {
				return i;
			}
		}
		return -1;
	}

	public void addDigitalVideoDisc(DigitalVideoDisc disc) {

		if (qtyOrdered < MAX_NUMBER_ORDERED) {
			itemsOrdered[qtyOrdered] = disc;
			qtyOrdered++;
			System.out.println("DVD " + disc.getTitle() + " added to order successfully!");
		} else if (qtyOrdered == MAX_NUMBER_ORDERED) {
			System.out.println("-----> Max number of items reached!\nCannot add DVD " + disc.getTitle() + " to order!");
		}
	}

	public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
		addDigitalVideoDisc(dvd1);
		addDigitalVideoDisc(dvd2);
	}

	public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList) {
		int sze = dvdList.length;
		for (int i = 0; i < sze; i++) {
			addDigitalVideoDisc(dvdList[i]);
		}
	}

	/*
	 * When try to add addDigitalVideoDisc method, it causes error because we
	 * already have similar method public void addDigitalVideoDisc1(DigitalVideoDisc
	 * ...disc) {
	 * 
	 * }
	 */

	public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
		int dvdIsInOrder = findDigitalVideoDisc(disc, qtyOrdered);
		if (qtyOrdered <= 0) {
			System.out.println("-----> Order is empty!\nCannot remove DVD " + disc.getTitle());
		} else if (dvdIsInOrder == -1) {
			System.out.println("-----> DVD is not in the order! Cannot remove DVD " + disc.getTitle());
		} else {
			for (int i = dvdIsInOrder; i < qtyOrdered - 1; i++) {
				itemsOrdered[i] = itemsOrdered[i + 1];
			}
			qtyOrdered--;
			System.out.println("DVD " + disc.getTitle() + " removed successfully!");
		}
	}

	public void displayOrder() {
		System.out.println(
				"-------------------------------------------------------ORDERS-------------------------------------------------------");
		System.out.print("Date created: ");
		dateOrdered.print();
		System.out.format("%-5s%-40s | %-20s | %-20s |%-10s |%-20s\n", "No", "Title", "Category", "Director", "Length",
				"Cost");
		System.out.println(
				"--------------------------------------------------------------------------------------------------------------------");

		for (int i = 0; i < qtyOrdered; i++) {
			System.out.format("%-5d%-40s | %-20s |%-20s | %-10d| %-20.2f\n", i + 1, itemsOrdered[i].getTitle(),
					itemsOrdered[i].getCategory(), itemsOrdered[i].getDirector(), itemsOrdered[i].getLength(),
					itemsOrdered[i].getCost());
		}
		System.out.println("Total items in order: " + qtyOrdered);
		System.out.println("Total cost: " + totalCost());
	}

	public float totalCost() {
		float sum = 0.0f;
		for (int i = 0; i < qtyOrdered; i++) {
			sum += itemsOrdered[i].getCost();
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
		int rand = (int) (Math.random()*100) % sz;
		return li.getLuckyDisc(rand);
	}
}
