package poker.graphics;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.DefaultCaret;

@SuppressWarnings("serial")
public class ChatSender extends JPanel implements ActionListener {
	static Chat chatBox = Table.chatArea;
	JTextField userInput;
	JButton sendButton;
	
	/**
	 * Controls sending player messages
	 */
	public ChatSender() {
		super();
		userInput = new JTextField();
		userInput.setText("Send a chat!");
		userInput.addFocusListener(new FocusListener() {
		    @Override
		    public void focusGained(FocusEvent e) {
		        if (userInput.getText().equals("Send a chat!")) {
		            userInput.setText("");
		            userInput.setForeground(Color.BLACK);
		        }
		    }
		    @Override
		    public void focusLost(FocusEvent e) {
		        if (userInput.getText().isEmpty()) {
		            userInput.setForeground(Color.GRAY);
		            userInput.setText("Send a chat!");
		        }
		    }
		   });
		userInput.setPreferredSize(new Dimension(Main.fracWidth(.1), Main.fracHeight(.03)));
		DefaultCaret caret = (DefaultCaret)userInput.getCaret();
		caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
		caret.setBlinkRate(500);
		userInput.setCaretPosition(0);
		userInput.setAutoscrolls(true);
		userInput.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
		userInput.setEditable(true);
		userInput.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {

			}

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyChar() == KeyEvent.VK_ENTER) {
					actionPerformed(null);
				}
				userInput.requestFocusInWindow();
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		sendButton = new JButton("Send");
		sendButton.setSize(Main.fracWidth(.3), Main.fracHeight(.5));
		sendButton.addActionListener(this);
		this.setLayout(new FlowLayout());
		this.add(userInput);
		this.add(sendButton);
	}
	
	public void actionPerformed(ActionEvent e) {
		String toAdd = userInput.getText();
		userInput.setText("");
		chatBox.addPlayerText(toAdd);
		
	}
}
