package poker;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JTextArea;
import javax.swing.text.DefaultCaret;

public class Chat extends JTextArea{
	Chat(){
		this.setText("Hi this is an example!");
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
		this.setLocation((int) (.01 * Main.WIDTH),(int) (Main.HEIGHT * 0.125));
		this.setRows(30);
		this.setColumns(15);
		this.setEditable(false);
		this.setWrapStyleWord(true);
		this.setFont(new Font(Font.SANS_SERIF,  Font.PLAIN, 12));
		this.setLineWrap(true);
		DefaultCaret caret = (DefaultCaret) this.getCaret();
		caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
		
		
		
	}
}
