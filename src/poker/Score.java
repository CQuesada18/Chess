package poker;

import java.awt.Font;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Score extends JLabel {
	int score;
	String name;
	
	public Score(String name, int score) {
		this.score = score;
		this.name = name;
		this.setFont(new Font(Font.SANS_SERIF,  Font.PLAIN, 14));
		this.setText(this.toString());
	}
	
	public String toString() {
		return name + ": " + score;
	}
	
	public static JPanel getScoresAsPanel(List<Score> scores) {
		if (scores.size() > 8 || scores.size() < 0) {
			throw new IllegalArgumentException("Invalid size for \"scores\"");
		}
		JPanel scorePanel = new JPanel();
		for (int i = 0; i < scores.size(); i++) {
			JLabel scoreText = new JLabel(scores.get(i).toString());
			scoreText.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 20));
			scoreText.setBounds(0, i * 30, (int) (Main.WIDTH * .2), 100);
			scorePanel.add(scoreText);
		}
		return scorePanel;
	}
}
