package poker.graphics;

import java.util.LinkedList;
import java.util.PriorityQueue;

public class Hand {
	LinkedList<Card> hand = new LinkedList<>();
	LinkedList<Card> table = new LinkedList<>();
	private PriorityQueue<Card> combined;
	
	public Hand() {
		combined = new PriorityQueue<>();
		for (Card card : hand) {
			combined.add(card);
		}
		for (Card card : table) {
			combined.add(card);
		}
		System.out.println(combined);
	}
}
