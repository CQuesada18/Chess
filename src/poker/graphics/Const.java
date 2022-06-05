package poker.graphics;

import java.awt.Font;

public class Const {
	public static class Fonts {
		public static final Font TITLE = new Font(Font.SANS_SERIF,  Font.BOLD, 36);
		public static final Font CHAT_MESSAGE = new Font(Font.SANS_SERIF,  Font.PLAIN, 18);
		public static final Font SCORE = new Font(Font.SANS_SERIF, Font.PLAIN, 20);
	}
	
	enum Suit {
		SPADES(4),
		HEARTS(3),
		DIAMONDS(2),
		CLUBS(1);
		
		private final int value;
		
		Suit(int value) {
			this.value = value;
		}
		
		public int getValue() {
			return this.value;
		}
		
		public String getName() {
			return this.name();
		}
	}

	enum Value {
		ACE(14),
		KING(13),
		QUEEN(12),
		JACK(11),
		TEN(10),
		NINE(9),
		EIGHT(8),
		SEVEN(7),
		SIX(6),
		FIVE(5),
		FOUR(4),
		THREE(3),
		TWO(2);
		
		private final int value;
		
		Value(int value) {
			this.value = value;
		}
		
		public int getValue() {
			return this.value;
		}
		
		public String getName() {
			return this.name();
		}
	}
	
	
}
