package game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Board extends JPanel{
	Tile tiles[][] = new Tile[8][8];
	Pawn pawn = new Pawn(0,6);
	boolean isSelected;
	static final Color dark = new Color(135,62,35), light = new Color(234,182,118);
	Board(){
		int width = 750, height = 750;
		setPreferredSize(new Dimension(width,height));
		setLayout(new GridLayout(8,8));



		//adding buttons
		for (int row = 0; row < 8; row++) {
			for (int col = 0; col < 8; col++) {
				tiles[row][col] = new Tile(col,row);
				pawn.move(tiles[row][col]); 
				tiles[row][col].setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
				tiles[row][col].setFocusable(false);
				tiles[row][col].setOpaque(true);
				tiles[row][col].setBackground(tiles[row][col].color);
				if (pawn.getLocationY() == row && pawn.getLocationX() == col) {
						tiles[row][col].setText(pawn.type.toString());
				}
				tiles[row][col].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Tile tile = (Tile) e.getSource();
						if (!isSelected) {
							if (tile.x != pawn.locationX || tile.y != pawn.locationY) {
								return;
							}
							isSelected = true;
							tile.setBackground(Color.CYAN);
							tiles[tile.y - 1][tile.x].setBackground(Color.CYAN);
						} else {
							isSelected = false;
							if (tile.getBackground().equals(Color.CYAN)) {
								pawn.move(tile);
							}
							for (Tile[] t: tiles) {
								for (Tile toChange: t) {
									toChange.setBackground(toChange.color);
								}
							}
						}

					}
				});
				add(tiles[row][col]);
			}

		}

	}
	class Tile extends JButton{
		int x,y;
		Color color;

		Tile(int x, int y){
			this.x = x;
			this.y = y;
			this.color = (y % 2 == 0 &&  x % 2 == 1 ) || (x % 2 == 0 && y % 2 == 1) ? dark : light;
		}

		public boolean equals(Object o) {
			if (!(o instanceof Tile)) return false;

			Tile tile = (Tile) o;
			return tile.x == this.x && tile.y == this.y;
		}
	}
}