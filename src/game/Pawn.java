package game;

public class Pawn extends Piece {
	String letterForPiece = "P";

	public Pawn(int x, int y) {
		super(x, y);
		this.type = PieceType.Pawn;
	}
	public void move() {
		this.locationY --;
	}
}
