package poker.graphics;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultCaret;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

@SuppressWarnings("serial")
public class Chat extends JTextPane {
	
	Chat() {
		this.addServerMessage("Welcome to Poker!");
		this.setBorder(BorderFactory.createCompoundBorder(
			BorderFactory.createLineBorder(Color.BLACK, 3),
			BorderFactory.createEmptyBorder(5, 5, 5, 5)
		));
		this.setLocation((int) (.01 * Main.WIDTH),(int) (Main.HEIGHT * 0.125));
		this.setPreferredSize(new Dimension((int) (Main.WIDTH * .18), (int)(Main.HEIGHT * .85)));
		this.setEditable(false);
		this.setFont(new Font(Font.SANS_SERIF,  Font.PLAIN, 18));
		DefaultCaret caret = (DefaultCaret) this.getCaret();
		caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
		test();
	}
	
	public void addText(String text) {
		addText(text, false);
	}
	
	public void addText(String text, boolean isServerMessage) {
		StyledDocument doc = this.getStyledDocument();
		Style style = this.addStyle("RED", null);
		if (isServerMessage) {
			StyleConstants.setForeground(style, Color.RED);
			try { doc.insertString(doc.getLength(), "Server: " + text + "\n\n", style); }
	        catch (BadLocationException e){}
			StyleConstants.setForeground(style, Color.BLACK);
		} else {
			try { doc.insertString(doc.getLength(), text + "\n\n", style); }
			catch (BadLocationException e){}
		}
	}
	
	public void addServerMessage(String text) {
		// Also makes it red implying it's from the server
		addText(text, true);
	}
	
	// DEBUG
	public void test() {
		addText("Hello World! THIS IS REALLY LONG OMG");
		addText("message");
	}
}
