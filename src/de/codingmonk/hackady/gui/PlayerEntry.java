package de.codingmonk.hackady.gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PlayerEntry extends JPanel {
	private JTextField txtTypeYourName;
	private String defaultText = "Type Your Playername Here...";
	private Color color;
	private boolean displayText = true;
	private int playerNumber;
	
	private CtrlDialog ctrlDialog = new CtrlDialog(this);
	
	private String buzzerCode;
	
	
	
	public String getDefaultText() {
		return defaultText;
	}
	public void setDefaultText(String defaultText) {
		this.defaultText = defaultText;
		txtTypeYourName.setText(defaultText);
	}
	public String getBuzzerCode() {
		return buzzerCode;
	}
	public void setBuzzerCode(String buzzerCode) {
		this.buzzerCode = buzzerCode;
	}
	public PlayerEntry() {
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		JLabel lblPlayerName = new JLabel("Player Name:");
		add(lblPlayerName);
		
		txtTypeYourName = new JTextField();
		txtTypeYourName.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				if(displayText) {
					txtTypeYourName.setForeground(Color.BLACK);
					txtTypeYourName.setText("");
					displayText = false;
				}
			}
			@Override
			public void focusLost(FocusEvent arg0) {
				if(!displayText && txtTypeYourName.getText().length() == 0) {
					txtTypeYourName.setForeground(Color.LIGHT_GRAY);
					txtTypeYourName.setText(defaultText);
					displayText = true;
				}
			}
		});
		txtTypeYourName.setForeground(Color.LIGHT_GRAY);
		txtTypeYourName.setText(defaultText);
		add(txtTypeYourName);
		txtTypeYourName.setColumns(10);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PlayerDialog.getInstance().removeEntry((PlayerEntry) arg0.getSource());
			}
		});
		add(btnDelete);
		
		JButton btnCtrl = new JButton("Ctrl");
		btnCtrl.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				
				ctrlDialog.setVisible(true);
			}
		});
		add(btnCtrl);
	}
	public String getPlayername() {
		// TODO Auto-generated method stub
		return txtTypeYourName.getText();
	}
	public Color getColor() {
		// TODO Auto-generated method stub
		return this.color;
	}
	public int getPlayerNumber() {
		return playerNumber;
	}
	public void setPlayerNumber(int playerNumber) {
		this.playerNumber = playerNumber;
	}
	

}
