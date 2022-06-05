package poker.graphics;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.LinkedList;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.plaf.basic.BasicScrollBarUI;

import poker.graphics.Const.Fonts;
import poker.graphics.Const.Suit;
import poker.graphics.Const.Value;

@SuppressWarnings("serial")
public class Table extends JPanel{
	// Left side things
	JPanel left;
	JLabel scoreTitle = new JLabel("Scores"), chatTitle = new JLabel("Chat");
	LinkedList<Score> playerScores = new LinkedList<Score>();
	JPanel scoresPanel;
	Pot pot;
	
	// Middle things
	JPanel middle;
	LinkedList<JPanel> centerCards = new LinkedList<>();
	JPanel centerCardPanel;
	JPanel leftCard = new JPanel();
	JPanel rightCard = new JPanel();
	
	// Right things
	JPanel right;
	ChatSender chatSender;
	static Chat chatArea;

	public Table() {
		createBoard();
	}
	
	public void createBoard() {
		this.setPreferredSize(new Dimension(Main.WIDTH, Main.HEIGHT));
		this.setLayout(new BorderLayout());
		
		left = new JPanel();
		middle = new JPanel();
		right = new JPanel();
		
		left.setPreferredSize(new Dimension(Main.fracWidth(.2), Main.HEIGHT));
		left.setBackground(Color.DARK_GRAY);
		left.setLayout(null);
		right.setLayout(new FlowLayout());
		middle.setPreferredSize(new Dimension(Main.fracWidth(.6), Main.HEIGHT));
		middle.setLayout(new BorderLayout());
		middle.setBackground(Color.DARK_GRAY);
		right.setPreferredSize(new Dimension(Main.fracWidth(.2), Main.HEIGHT));
		right.setBackground(Color.DARK_GRAY);
		
		left.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
		middle.setBorder(BorderFactory.createLineBorder(Color.GRAY, 3));
		right.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
		
		
		// ALL LEFT STUFF
		
		// DEBUG
		playerScores.add(new Score("Matchew", 90));
		playerScores.add(new Score("Christopher", 1304));
		playerScores.add(new Score("Funny", 1));
		// END DEBUG
		
		scoreTitle.setFont(Fonts.TITLE);
		scoreTitle.setBounds(Main.fracWidth(.05), Main.fracHeight(.005), 150, 100);
		chatTitle.setFont(Fonts.TITLE);
		chatTitle.setBounds(Main.fracWidth(.065), Main.fracHeight(.005), 150, 100);
		
		pot = new Pot();
		pot.setFont(Fonts.TITLE);
		pot.setBounds(Main.fracWidth(.05), Main.fracHeight(0.5), 150, 100);
		left.add(pot);
		
		
		scoresPanel = Score.getScoresAsPanel(playerScores);
		scoresPanel.setBackground(Color.DARK_GRAY);
		scoresPanel.setBounds(25, 100, Main.fracWidth(.15), Main.fracHeight(.3));
		left.add(scoreTitle);
		right.add(chatTitle);
		left.add(scoresPanel);
		for (JLabel score: playerScores) left.add(score);
		

		//Right Stuff
		chatArea = new Chat();
		JScrollPane sp = new JScrollPane(chatArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		sp.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
			protected void configureScrollBarColors() {
				this.thumbColor = Color.BLACK;
				this.trackColor = Color.LIGHT_GRAY;
				this.thumbLightShadowColor = Color.YELLOW;
			}
		});
		sp.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, Color.BLACK));
		right.add(sp, FlowLayout.CENTER);
		chatSender = new ChatSender();
		right.add(chatSender);
		
		// ALL Middle Stuff
		centerCardPanel = new JPanel();
		centerCardPanel.setBackground(Color.DARK_GRAY);
		centerCards.add(CardDisplay.displayCard(new Card(Suit.SPADES, Value.ACE)));
		centerCards.add(CardDisplay.displayCard(new Card(Suit.SPADES, Value.EIGHT))); 
		centerCards.add(CardDisplay.displayCard(new Card(Suit.DIAMONDS, Value.TWO))); 
		centerCards.add(CardDisplay.displayCard(new Card(Suit.CLUBS, Value.NINE)));
		centerCards.add(CardDisplay.displayCard(new Card(Suit.HEARTS, Value.KING))); 
		centerCardPanel.setSize(Main.fracWidth(.6), Main.fracHeight(.3));
		centerCardPanel.setBackground(Color.DARK_GRAY);
		
		for (JPanel centerCard: centerCards) centerCardPanel.add(centerCard);
		middle.add(centerCardPanel, BorderLayout.NORTH);
		
		JPanel handCardPanel = new JPanel();
		handCardPanel.setBackground(Color.DARK_GRAY);
		leftCard = CardDisplay.displayCard(new Card(Suit.DIAMONDS, Value.SEVEN));
		rightCard = CardDisplay.displayCard(new Card(Suit.HEARTS, Value.FIVE));
		handCardPanel.add(leftCard);
		handCardPanel.add(rightCard);
		
		middle.add(handCardPanel, BorderLayout.SOUTH);
		this.add(left, BorderLayout.LINE_START);
		this.add(middle, BorderLayout.CENTER);
		this.add(right, BorderLayout.LINE_END);
		
		Main.frame.add(this);
	}
	

}
