package poker;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.LinkedList;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.plaf.basic.BasicScrollBarUI;

public class Table extends JPanel {
	// Left side things
	JPanel left;
	JLabel scoreTitle = new JLabel("Scores"), chatTitle = new JLabel("Chat");
	LinkedList<Score> playerScores = new LinkedList<Score>();
	JPanel scoresPanel;
	Pot pot;
	
	// Middle things
	JPanel middle;
	
	// Right things
	JPanel right;

	public Table() {
		createBoard();
	}
	
	public void createBoard() {
		this.setPreferredSize(new Dimension(Main.WIDTH, Main.HEIGHT));
		this.setLayout(new BorderLayout());
		
		left = new JPanel();
		middle = new JPanel();
		right = new JPanel();
		
		left.setPreferredSize(new Dimension((int)(Main.WIDTH * .2), Main.HEIGHT));
		left.setLayout(null);
		right.setLayout(new FlowLayout());
		middle.setPreferredSize(new Dimension((int)(Main.WIDTH * .6), Main.HEIGHT));
		right.setPreferredSize(new Dimension((int)(Main.WIDTH * .2), Main.HEIGHT));
		
		left.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
		middle.setBorder(BorderFactory.createLineBorder(Color.GRAY, 3));
		right.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
		
		
		// ALL LEFT STUFF
		
		// DEBUG
		playerScores.add(new Score("Matchew", 90));
		playerScores.add(new Score("Christopher", 1304));
		playerScores.add(new Score("Funny", 1));
		// END DEBUG
		
		scoreTitle.setFont(new Font(Font.SANS_SERIF,  Font.BOLD, 36));
		scoreTitle.setBounds((int) (.05 * Main.WIDTH),(int) (Main.HEIGHT * 0.005), 150, 100);
		chatTitle.setFont(new Font(Font.SANS_SERIF,  Font.BOLD, 36));
		chatTitle.setBounds((int) (.065 * Main.WIDTH),(int) (Main.HEIGHT * 0.005), 150, 100);
		
		
		scoresPanel = Score.getScoresAsPanel(playerScores);
		scoresPanel.setBounds(25, 100, (int) (Main.WIDTH * .15), (int) (Main.HEIGHT * .3));
		left.add(scoreTitle);
		right.add(chatTitle);
		left.add(scoresPanel);
		
		Chat chat = new Chat();
		//Right Chat Scroll Pane
		JScrollPane sp = new JScrollPane(chat, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		sp.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
			protected void configureScrollBarColors() {
				this.thumbColor = Color.BLACK;
				this.trackColor = Color.LIGHT_GRAY;
				this.thumbLightShadowColor = Color.YELLOW;
			}
		});
		sp.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, Color.BLACK));
		right.add(sp, FlowLayout.CENTER);


		
		pot = new Pot();
		
		
		
		for (JLabel score: playerScores) left.add(score);
		this.add(left, BorderLayout.LINE_START);
		this.add(middle, BorderLayout.CENTER);
		this.add(right, BorderLayout.LINE_END);
		
		Main.frame.add(this);
	}
	

}
