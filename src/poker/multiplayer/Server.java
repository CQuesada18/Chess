package poker.multiplayer;

import java.util.Vector;

public class Server {
	protected static Vector<Player> players;
	private static final int MAX_PLAYERS = 8;
	
	public Server() {
		players = new Vector<>();
	}
	
	public void addPlayer(Player p) {
		if (players.size() == MAX_PLAYERS) {
			throw new IllegalStateException("Exceeded player limit!");
		}
		players.add(p);
	}
}
