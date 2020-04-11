package hust.soict.globalict.aims;

import java.util.ArrayList;
import java.util.Scanner;

import hust.soict.globalict.aims.media.Book;
import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.order.Order;

/**
 * @author Nguyen Thi Hong Anh
 */
public class Aims {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Order anOrder = Order.createOrder();
//		Media dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 8, 19.95f);
//
//		Media dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 124, 24.95f);
//
//		Media dvd3 = new DigitalVideoDisc("Alladin", "Animation", "John Musker", 90, 18.99f);
//
//		Media dvd4 = new DigitalVideoDisc("My life", "Commedy", "Nguyen Thi Hong Anh", 1000, 0.01f);
//
//		Media dvd5 = new DigitalVideoDisc("Spirited Away", "Animation", "Hayao Miyazaki", 90, 15.5f);
//
//		Media dvd6 = new DigitalVideoDisc("Howl's Moving Castle", "Animation", "Hayao Miyazaki", 95, 13.75f);
//
//		Media dvd7 = new DigitalVideoDisc("Princess Mononoke", "Animation", "Hayao Miyazaki", 85, 15.0f);
//
//		Media dvd8 = new DigitalVideoDisc("Ponyo", "Animation", "Hayao Miyazaki", 80, 11.25f);
//
//		Media dvd9 = new DigitalVideoDisc("Laputa Castle in the sky", "Animation", "Hayao Miyazaki", 100, 13.25f);
//
//		Media dvd10 = new DigitalVideoDisc("The cat returns", "Animation", "Hayao Miyazaki", 80, 10.25f);
//
//		Media dvd11 = new DigitalVideoDisc("Kiki's Delivery service", "Animation", "Hayao Miyazaki", 85, 11.25f);
//
//		Media[] ghibliList = { dvd5, dvd6, dvd7, dvd8, dvd9, dvd10, dvd11 };
		
		new Aims().showMenu();
	}

	@SuppressWarnings("null")
	public void showMenu() {
		ArrayList<Order> orderList = new ArrayList<Order>();
		Scanner sc = new Scanner(System.in);
		String menu = "\n\nORDER MANAGEMENT APPLICATION\n"
				+ "----------------------------------------------------------\n" 
				+ "1. Create new order\n"
				+ "2. Add item to order\n" 
				+ "3. Delete item by id\n" 
				+ "4. Display the item list of order\n"
				+ "0. Exit\n" 
				+ "-----------------------------------------------------------\n" 
				+ "Enter choice: ";
		String choice;
		do {
			System.out.print(menu);
			choice = sc.nextLine();
			//choice = Integer.parseInt(tmp);
			String media, title, category, costS;
			float cost;
			switch (choice) {
			case "1":
				Order order = Order.createOrder();
				orderList.add(order);
				break;
			case "2":
				if(orderList.size() == 0) {
					System.out.println("No order has been created!");
					break;
				}
				System.out.print("Choose media type (Book or Digital video disc): ");
				media = sc.nextLine();
				System.out.print("Title: ");
				title = sc.nextLine();
				System.out.print("Category: ");
				category = sc.nextLine();
				System.out.print("Cost: ");
				costS = sc.nextLine();
				cost = Float.parseFloat(costS);
				media = media.toLowerCase().trim();
				if(media.equals("book")) {
					orderList.get(orderList.size() - 1).addMedia(Book.createMedia(title.trim(), category.trim(), cost));
				}
				else if(media.contentEquals("digital video disc")) {
					orderList.get(orderList.size() - 1).addMedia(DigitalVideoDisc.createMedia(title.trim(), category.trim(), cost));
				}
				break;
			case "3":
				if(orderList.size() == 0) {
					System.out.println("No order has been created!");
					break;
				}
				System.out.print("Enter media id: ");
				String id = sc.nextLine();
				orderList.get(orderList.size() - 1).removeMedia(id);
				break;
			case "4": 
				if(orderList.size() == 0) {
					System.out.println("No order has been created!");
					break;
				}
				orderList.get(orderList.size() - 1).displayOrder();
				break;
			case "0":
				System.out.println("Exit program");
				break;
			default:
				System.out.println("Invalid choice!");
				break;
			}
		} while (!choice.contentEquals("0"));
		sc.close();
	}
}
