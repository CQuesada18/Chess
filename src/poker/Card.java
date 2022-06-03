package poker;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.io.FileNotFoundException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Card {
	public Image image;
	protected static final int WIDTH = (int) (Main.WIDTH * .1);
	protected static final int HEIGHT = (int) (Main.HEIGHT * .25);
	
	public Card(int suit, int value) {
		try {
			this.getImageIcon(suit, value);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void getImageIcon(int suit, int value) throws FileNotFoundException {
		// FILE NAME STRUCTURE: [suit][value].png
		String fileName = value + "" + suit + ".png";
    	try {
			image = new ImageIcon(this.getClass().getResource("/Images/" + fileName)).getImage();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public JLabel getCardDisplay() {
		image = image.getScaledInstance(WIDTH, HEIGHT, Image.SCALE_DEFAULT);
		JLabel img = new JLabel(new ImageIcon(image));
		img.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
		img.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		return img;
	}
	
}


