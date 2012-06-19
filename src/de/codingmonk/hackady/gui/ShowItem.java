package de.codingmonk.hackady.gui;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.KeyboardFocusManager;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import org.apache.log4j.Logger;

import de.codingmonk.hackady.core.KeyEventDispatcher;
import de.codingmonk.hackady.core.Player;
import de.codingmonk.hackady.core.PlayerList;
import de.codingmonk.hackady.set.HackadyAnswer;

public class ShowItem extends JDialog {
	
	private static Logger logger = Logger.getLogger(ShowItem.class);
	private HackadyAnswer answer;
	private static CategoryItem item;
	private int width = 450;
	private int height = 300;
	private KeyEventDispatcher ked;
	private EventPanel eventPanel;
	
	
	public HackadyAnswer getAnswer() {
		return answer;
	}


	public void setAnswer(HackadyAnswer answer) {
		this.answer = answer;
	}


	public ShowItem(HackadyAnswer answer, CategoryItem itemf) {
		
		ked = new KeyEventDispatcher(this) {  
			
	         public boolean dispatchKeyEvent(KeyEvent e) {  
	             boolean keyHandled = false;
	             if(! locked)
	             for(Player player : PlayerList.getInstance()) {
	            	 
	            	 if(player.getBuzzerCode() != null) {
	            		 if(String.valueOf(e.getKeyChar()).equals(player.getBuzzerCode())) {
	            			 this.locked = true;
	            			 eventPanel.playerAction(player, this);
	            			 
	            		 }
	            	 }
	             }
	             return keyHandled;  
	         }  
	     };
		 KeyboardFocusManager  
         .getCurrentKeyboardFocusManager()  
         .addKeyEventDispatcher(ked);  
		this.answer = answer;
		item = itemf;

		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setModal(true);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		
		setBounds(((dim.width - width) / 2), ((dim.height - height) / 2), width, height);
		getContentPane().setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel = new JPanel();
		getContentPane().add(panel);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblFoo = new JLabel(answer.getAnswer());
		lblFoo.setFont(new Font(lblFoo.getFont().getFontName(), Font.PLAIN, 22));
		lblFoo.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblFoo);
		
		JPanel panel_1 = new JPanel();
		
		getContentPane().add(panel_1);
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));
		
		eventPanel = new EventPanel();
		panel_1.add(eventPanel);
		eventPanel.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panel_4 = new JPanel();
		
		panel_1.add(panel_4);
		
		JButton btnNewButton_2 = new JButton("Close");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				closeAnswer();
				
			}
		});
		panel_4.add(btnNewButton_2);
		
		JButton btnReopen = new JButton("Reopen");
		btnReopen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				KeyboardFocusManager.getCurrentKeyboardFocusManager().removeKeyEventDispatcher(ked);
			}
		});
		panel_4.add(btnReopen);
		eventPanel.setVisible(false);
		setVisible(true);
	}


	public void closeAnswer() {
		// TODO Auto-generated method stub
		item.setEnabled(false);
		item.setText("-");
		item.repaint();
		setVisible(false);
		KeyboardFocusManager.getCurrentKeyboardFocusManager().removeKeyEventDispatcher(ked);
		
	}

	
	
}
