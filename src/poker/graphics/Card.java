package poker.graphics;

import java.awt.Dimension;
import java.awt.Image;
import java.io.FileNotFoundException;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import poker.graphics.Const.Suit;
import poker.graphics.Const.Value;

/**
 * Card class
 * @author Matthew Vandenberg
 *
 */
public class Card implements Comparable<Card> {
	public Image image;
	private Suit suit;
	private Value value;
	protected static final int WIDTH = (int) (Main.WIDTH * .1);
	protected static final int HEIGHT = (int) (Main.HEIGHT * .25);
	
	/**
	 * Constructs a card given a suit and value
	 * @param suit Suit to use
	 * @param value Value to use
	 */
	public Card(Suit suit, Value value) {
		this.suit = suit;
		this.value = value;
		try {
			this.getImageIcon();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Private helper method to generate the image icon based on the suit and value.
	 * Follows the structure [suit][value].png
	 * @throws FileNotFoundException If card doens't exist in file system (unlikely)
	 */
	private void getImageIcon() throws FileNotFoundException {
		String fileName = value.getValue() + "" + suit.getValue() + ".png";
    	try {
			image = new ImageIcon(this.getClass().getResource("/Images/" + fileName)).getImage();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Gets this card represented as a JLabel for use on JPanes.
	 * @return JLabel of the card
	 */
	public JLabel getCardDisplay() {
		image = image.getScaledInstance(WIDTH, HEIGHT, Image.SCALE_DEFAULT);
		JLabel img = new JLabel(new ImageIcon(image));

		img.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		return img;
	}
	
	/**
	 * Allows for reading the suit of a card.
	 * @return Suit of card
	 */
	public Suit getSuit() {
		return this.suit;
	}
	
	/**
	 * Allows for reading the value of a card.
	 * @return Value of card
	 */
	public Value getValue() {
		return this.value;
	}
	
	/**
	 * Compares one card to another as specified by {@link Comparable} for use with
	 * {@link java.util.PriorityQueue}.
	 * @return Negative if <strong>this</strong> comes before <strong>card</strong>, 
	 * 0 if equal, positive otherwise.
	 */
	public int compareTo(Card card) {
		if (this.value.getValue() == card.value.getValue()) {
			return this.suit.getValue() - card.suit.getValue();
		}
		return this.value.getValue() - card.value.getValue();
	}
	
	/**
	 * String representation of a card, used for testing purposes.
	 * @return String of card
	 */
	public String toString() {
		return String.format("%s of %s", value.getName(), suit.getName());
	}
	
}


