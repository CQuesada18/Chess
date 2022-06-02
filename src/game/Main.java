package game;

import javax.swing.JFrame;

public class Main {
	public static void main(String args[]){
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocation(600,100);
		frame.setTitle("Chess");
		frame.add(new Board());
		frame.setResizable(false);
		frame.pack();
		frame.setVisible(true);
	}

}
