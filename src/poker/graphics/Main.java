package poker.graphics;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Main {
	public static int WIDTH = 1200, HEIGHT = 800;
	public static Table TABLE;
	public static JFrame frame;
	
	public static void main(String[] args) {
		// Accept a width and height if arguments are passed
		try {
			WIDTH = Integer.parseInt(args[0]);
			HEIGHT = Integer.parseInt(args[1]);
		} catch (Exception e) {
			System.out.println("Defaulting to " + WIDTH + " x " + HEIGHT);
		}
		
		// Ask for host or create game
		Object[] options = {"Host Game", "Join Game"};
		int response = JOptionPane.showOptionDialog(null, "Choose a game type:" ,"Game Type", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
		switch (response) {
		case 0:
			System.out.println("Create");
			break;
		case 1: 
			System.out.println("Join");
			String ip = JOptionPane.showInputDialog("Enter the host's IP Address:");
			System.out.println(ip);
			break;
		}
		frame = new JFrame("Poker");
		TABLE = new Table();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	
	public static int fracWidth(double fraction) {
		return (int) (fraction * WIDTH);
	}
	
	public static int fracHeight(double fraction) {
		return (int) (fraction * HEIGHT);
	}
}
