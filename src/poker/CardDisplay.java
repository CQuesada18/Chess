package poker;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class CardDisplay {
	public static JPanel displayCard(Card c) {
		JLabel cardLabel = c.getCardDisplay();
		JPanel cardPanel = new JPanel();
		cardPanel.setSize(Card.WIDTH, Card.HEIGHT);
		cardPanel.add(cardLabel);
		return cardPanel;
	}
}
