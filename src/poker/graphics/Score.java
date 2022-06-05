package poker.graphics;

import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;

import poker.graphics.Const.Fonts;

/**
 * Responsible for displaying all scores from each player
 * @author Matthew Vandenberg
 *
 */
@SuppressWarnings("serial")
public class Score extends JLabel {
	int score;
	String name;
	
	/**
	 * Construct a new Score object given name and score.
	 * @param name Name of score
	 * @param score Score of score
	 */
	public Score(String name, int score) {
		this.score = score;
		this.name = name;
		this.setFont(Fonts.SCORE);
		this.setText(this.toString());
	}
	
	public String toString() {
		return name + ": " + score;
	}
	
	/**
	 * Collectively returns a list of all score objects and returns as a viewable object.
	 * @param scores Scores to generate JPanel for
	 * @return JPanel representing all scores
	 */
	public static JPanel getScoresAsPanel(List<Score> scores) {
		if (scores.size() > 8 || scores.size() < 2) {
			throw new IllegalArgumentException("Invalid size for \"scores\"");
		}
		JPanel scorePanel = new JPanel();
		for (int i = 0; i < scores.size(); i++) {
			JLabel scoreText = new JLabel(scores.get(i).toString());
			scoreText.setFont(Fonts.SCORE);
			scoreText.setBounds(0, i * 30, Main.fracWidth(.2), 100);
			scorePanel.add(scoreText);
		}
		return scorePanel;
	}
}
