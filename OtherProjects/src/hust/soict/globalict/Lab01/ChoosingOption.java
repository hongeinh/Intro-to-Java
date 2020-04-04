package hust.soict.globalict.Lab01;
/*
 * LAB 02
 * Exercise 5.1
 * */
import javax.swing.JOptionPane;

public class ChoosingOption {
	public static void main(String[] args) {
		int option = JOptionPane.showConfirmDialog(null, 
				"Do you want to change to the first class ticket? ", null, JOptionPane.YES_NO_OPTION);
		JOptionPane.showMessageDialog(null, 
				"You have chosen: " + (option == JOptionPane.YES_OPTION?"Yes":"No"));
		System.exit(0);
	}
}

// Since Pane only prints Yes if we choose Yes, any other option will result to No.
// To customize frame to only two option, we add more parameter to the method.
