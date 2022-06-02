package game;

public class Piece {
	int locationX, locationY;
	PieceType type;
	Board.Tile locatedOn;
	
	public Piece(int x, int y) {
		this.locationX = x;
		this.locationY = y;
		locatedOn = null;
	}
	
	public int getLocationX(){
		return locationX;
	}
	public int getLocationY(){
		return locationY;
	}
	public PieceType getType(){
		return type;
	}
	public void move(Board.Tile tile) {
		if (locatedOn == null) {
			locatedOn = tile;
			locatedOn.setText(getRep());
			return;
		}
		locatedOn.setText("");
		locatedOn = tile;
		locationX = tile.x;
		locationY = tile.y;
		locatedOn.setText(getRep());
	}
	
	public String getRep() {
		return type.toString();
	}
	
}
enum PieceType {
	Pawn,
	Bishop,
	King,
	Queen,
	Rook,
	Knight
}
