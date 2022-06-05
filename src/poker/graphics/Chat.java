package poker.graphics;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultCaret;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import poker.graphics.Const.Fonts;

/**
 * Chat box used for server and player messages.
 * @author Matthew Vandenberg
 *
 */
@SuppressWarnings("serial")
public class Chat extends JTextPane {
	private static final Color PLAYER_CHAT_COLOR = Color.BLACK;
	private static final Color SERVER_CHAT_COLOR = Color.RED;
	/**
	 * Constructs a new chat box.
	 */
	public Chat() {
		this.addServerText("Welcome to Poker!");
		this.setBorder(BorderFactory.createCompoundBorder(
			BorderFactory.createLineBorder(Color.BLACK, 3),
			BorderFactory.createEmptyBorder(5, 5, 5, 5)
		));
		this.setLocation(Main.fracWidth(.01), Main.fracHeight(0.125));
		this.setPreferredSize(new Dimension(Main.fracWidth(.18), Main.fracHeight(.85)));
		this.setEditable(false);
		this.setFont(Fonts.CHAT_MESSAGE);
		DefaultCaret caret = (DefaultCaret) this.getCaret();
		caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
	}
	
	/**
	 * Add text to the chat box as a new message. Called when a player sends a message.
	 * @param text Test to display from player
	 */
	public void addPlayerText(String text) {
		addText(text, false);
	}
	
	/**
	 * Add text to the chat as a server message. 
	 * @param text
	 */
	public void addServerText(String text) {
		// Also makes it red implying it's from the server
		addText(text, true);
	}
	
	/**
	 * Add text to the chat box.
	 * @param text Text to add
	 * @param isServerMessage True if server message, false otherwise
	 */
	private void addText(String text, boolean isServerMessage) {
		StyledDocument doc = this.getStyledDocument();
		Style style = this.addStyle("RED", null);
		if (isServerMessage) {
			StyleConstants.setForeground(style, SERVER_CHAT_COLOR);
			try { doc.insertString(doc.getLength(), "Server: " + text + "\n\n", style); }
	        catch (BadLocationException e){}
			StyleConstants.setForeground(style, PLAYER_CHAT_COLOR);
		} else {
			try { doc.insertString(doc.getLength(), text + "\n\n", style); }
			catch (BadLocationException e){}
		}
	}
}
