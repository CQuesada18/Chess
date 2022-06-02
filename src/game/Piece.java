package game;

public class Piece {
	int locationX, locationY;
	PieceType type;
	
	public Piece(int x, int y) {
		this.locationX = x;
		this.locationY = y;
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
	
}
enum PieceType {
	Pawn,
	Bishop,
	King,
	Queen,
	Rook,
	Knight
}
