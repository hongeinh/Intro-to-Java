package honganh.notepad;

import java.awt.Font;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

import javax.swing.JEditorPane;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.text.Document;

public class Grid extends JFrame {
	JTextField title;
	int fileToOpen;
	int fileToSave;
	JFileChooser fileOpen;
	JFileChooser fileSave;
	Font f;
	String [] fontFamily = {"Arial", "Calibri", "Comic Sans", "Serif", "Courier", "Cursive"};
	String [] sizeValue = {"5", "10", "15", "20", "25", "30", "35", "40", "45","50"};
	int [] styleValue = {Font.BOLD, Font.ITALIC, Font.PLAIN};
	String [] styleValueName = {"Bold", "Italic", "Plain"};
	
	String ffont, fstyle, fsize;
	static int istyle = Font.PLAIN;
	static int isize = 17;
	static int isHightlighted = 0;
	Grid(){
		// menu items
		MenuBar menubar = new MenuBar();
		MenuItem menuItem = new MenuItem();
		final JEditorPane textArea = new JEditorPane();
		setMenuBar(menubar);
		Menu file = new Menu("File");
		Menu edit = new Menu("Edit");
		Menu format = new Menu("Format");
		
		menubar.add(file);
		menubar.add(edit);
		menubar.add(format);
		MenuItem newOption = new MenuItem("New");
		MenuItem open = new MenuItem("Open");
		MenuItem save = new MenuItem("Save");
		MenuItem saveAs = new MenuItem("Save as");
		MenuItem close = new MenuItem("Close");
		MenuItem print = new MenuItem("Print");
		MenuItem highlight = new MenuItem("Highlight");
		MenuItem copy = new MenuItem("Copy");
		MenuItem cut = new MenuItem("Cut");
		MenuItem paste = new MenuItem("Paste");
		MenuItem font = new MenuItem("Font");
		MenuItem textStyle = new MenuItem("Text style");
		MenuItem textSize = new MenuItem("Text size");
		file.add(newOption);
		file.add(open);
		file.add(save);
		file.add(saveAs);
		file.add(close);
		
		edit.add(highlight);
		edit.add(cut);
		edit.add(cut);
		edit.add(paste);
		
		format.add(font);
		format.add(textSize);
		format.add(textStyle);
		
		getContentPane().add(textArea);
		
		// create style options
		JList fontFamilyList = new JList(fontFamily); 
		fontFamilyList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JList sizeList = new JList(sizeValue);		  
		sizeList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JList styleList = new JList(styleValueName);
		styleList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		Document styleDoc = textArea.getDocument();
		
		// file options
		newOption.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText("");
			}
		});
		
		open.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				openFile();
				if(fileToOpen == JFileChooser.APPROVE_OPTION) {
					textArea.setText("");
					try {
						Scanner sc = new Scanner(new FileReader(fileOpen.getSelectedFile().getPath()));
						while(sc.hasNext()) {
							String addedString = sc.nextLine();
							styleDoc.insertString(styleDoc.getLength(), addedString, null);
						}
					}catch(Exception exception) {
						System.out.println(exception.getMessage());
					}
				}
			}
		});
		
		save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				saveFile();
				if(fileToSave == JFileChooser.APPROVE_OPTION) {
					try {
						BufferedWriter out = new BufferedWriter(new FileWriter(fileSave.getSelectedFile().getPath()));
						out.write(textArea.getText());
						out.close();
					} catch(Exception exception) {
						System.out.println(exception.getMessage());
					}
				}
			}
		});
		
		saveAs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				
			}
		});
		close.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				System.exit(0);
			}
		});
		
		print.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				try {
					textArea.print();
				} catch (PrinterException e) {
					e.printStackTrace();
				}
			}
		});
		
		// edit options
		highlight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				
			}
		});
		
		cut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				textArea.cut();
			}
		});
		paste.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				textArea.paste();
			}
		});
		
		// format options 
		font.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				JOptionPane.showConfirmDialog(null, fontFamilyList, "Choose font: ", JOptionPane.OK_CANCEL_OPTION);
				ffont = String.valueOf(fontFamilyList.getSelectedValue());
				f = new Font(ffont, istyle, isize);
				textArea.setFont(f);
			}
		});
		
		textStyle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				JOptionPane.showConfirmDialog(null, styleList, "Choose style: ", JOptionPane.OK_CANCEL_OPTION);
				istyle = styleValue[styleList.getSelectedIndex()];
				f = new Font(ffont, istyle, isize);
				textArea.setFont(f);
			}
		});
		
		textSize.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				JOptionPane.showConfirmDialog(null, sizeList, "Choose size: ", JOptionPane.OK_CANCEL_OPTION);
				fsize = String.valueOf(sizeList.getSelectedValue());
				isize = Integer.parseInt(fsize);
				f = new Font(ffont, istyle, isize);
				textArea.setFont(f);
			}
		});
		
	}
	public static int getIsHightlighted() {
		return isHightlighted;
	}
	public static void setIsHightlighted(int isHightlighted) {
		Grid.isHightlighted = isHightlighted;
	}
	public void openFile() {
		JFileChooser open = new JFileChooser();
		int option = open.showOpenDialog(this);
		fileToOpen = option;
		fileOpen = open;
	}
	public void saveFile() {
		JFileChooser save = new JFileChooser();
		int option = save.showSaveDialog(this);
		fileToSave = option;
		fileSave = save;
	}
}
