package honganh.notepad;

import javax.swing.JFrame;

public class MainFrame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new Grid();
		frame.setTitle("Einh Pad ");
		frame.setVisible(true);
		frame.setSize(1280, 720);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(true);
		frame.setLocationRelativeTo(null);
	}

}
