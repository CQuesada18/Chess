package poker.graphics;

import javax.swing.JLabel;

@SuppressWarnings("serial")
public class Pot extends JLabel {
	int balance;
	
	public Pot() {
		this.balance = 0;
		this.setText(this.toString());
	}
	
	public void addToPot(int toAdd) {
		this.balance += toAdd;
		this.setText(this.toString());
	}
	
	public void removeFromPot(int toRemove) {
		this.balance -= toRemove;
		this.setText(this.toString());
	}
	
	public String toString() {
		return "Pot: " + this.balance;
	}
}
