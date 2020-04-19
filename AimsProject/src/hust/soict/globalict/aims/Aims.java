package hust.soict.globalict.aims;

import java.util.ArrayList;
import java.util.Scanner;

import hust.soict.globalict.aims.media.Book;
import hust.soict.globalict.aims.media.CompactDisc;
import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.media.Track;
import hust.soict.globalict.aims.order.Order;
import hust.soict.globalict.aims.thread.MemoryDaemon;

/**
 * @author Nguyen Thi Hong Anh
 */
public class Aims {

	public static void main(String[] args) {
		MemoryDaemon md = new MemoryDaemon();
		Thread thread = new Thread(md);
		thread.setDaemon(true);
		thread.start();
		new Aims().showMenu();
	}
	
	
	

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
			String media, title, category, costS;
			float cost;
			switch (choice.trim()) {
			case "1":
				Order order = Order.createOrder();
				orderList.add(order);
				break;
			case "2":
				if(orderList.size() == 0) {
					System.out.println("No order has been created!");
					break;
				}
				System.out.print("Choose media type (Book or Digital video disc or Compact disc): ");
				media = sc.nextLine();
				System.out.print("Title: ");
				title = sc.nextLine();
				System.out.print("Category: ");
				category = sc.nextLine();
				System.out.print("Cost: ");
				costS = sc.nextLine();
				cost = Float.parseFloat(costS);
				media = media.toLowerCase().trim();
				
				String agree = "yes";
				
				if(media.equals("book")) {
					Book b = new Book (title.trim(), category.trim(), cost);
					orderList.get(orderList.size() - 1).addMedia(b);
				}
				else if(media.equals("digital video disc")) {
					System.out.print("Director: ");
					String dvdDirector = sc.nextLine().trim();
					System.out.print("Length: ");
					int dvdLength = Integer.parseInt(sc.nextLine());
					DigitalVideoDisc dvd = new DigitalVideoDisc (title.trim(), category.trim(), dvdDirector, dvdLength,  cost);
					orderList.get(orderList.size() - 1).addMedia(dvd);
					System.out.println("*******");
					System.out.print("Do you want to play the DVD (yes/no)? ");
					agree = sc.nextLine().toLowerCase().trim();
					System.out.println("*******");
					if(agree.equals("yes") || agree.equals("y")) {
						dvd.play();
					} else if ( (!agree.equals("yes") ) && (!agree.equals("y")) && (!agree.equals("no") ) && (!agree.equals("n")) ) {
						System.out.println("Invalid choice");
					}
				}
				else if(media.equals("compact disc")) {
					CompactDisc cd = new CompactDisc(title.trim(), category.trim(), cost);
					orderList.get(orderList.size() - 1).addMedia(cd);
					String addTrack = "\nDo you want to add track to this CD (yes/no) ?";
					agree = "yes";
					do {
						System.out.print(addTrack);
						agree = sc.nextLine().toLowerCase().trim();
						if(agree.equals("yes") || agree.equals("y")) {
							System.out.print("Track's title: ");
							String trackTitle = sc.nextLine();
							System.out.print("Track's length: ");
							int trackLength = Integer.parseInt(sc.nextLine());
							cd.addTrack(new Track(trackTitle, trackLength));
						}
					}while(agree.equals("yes") || agree.contentEquals("y"));
					System.out.println("*******");
					System.out.print("Do you want to play the CD (yes/no) ?");
					agree = sc.nextLine();
					System.out.println("*******");
					if(agree.equals("yes") || agree.equals("y")) {
						cd.play();
					} else if ( (!agree.equals("yes") ) && (!agree.equals("y")) && (!agree.equals("no") ) && (!agree.equals("n")) ) {
						System.out.println("Invalid choice");
					}
				} else {
					System.out.println("Invalid media!");
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
