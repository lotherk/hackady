package de.codingmonk.hackady.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.apache.log4j.Logger;

public class CtrlDialog extends JDialog implements ActionListener {
	private static Logger logger = Logger.getLogger(CtrlDialog.class);
	private JTextField textField;
	private PlayerEntry playerEntry;
	private String gainedText = "Press a key... ";
	private String lostText = "Click here to set a key.. ";
	private int width = 250;
	private int height = 100;
	private JLabel lblFoo;
	
	public CtrlDialog(PlayerEntry entry) {
		playerEntry = entry;
		
		lblFoo = new JLabel("<No key set yet>");

		JButton btnNewButton = new JButton("OK");
		btnNewButton.addActionListener(this);
		getContentPane().add(btnNewButton, BorderLayout.EAST);
		
		textField = new JTextField();
		textField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				textField.setText(lostText);
			}
			@Override
			public void focusGained(FocusEvent arg0) {
				textField.setText(gainedText);
			}
		});
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				logger.debug("typed");
				textField.setText(gainedText);
				lblFoo.setText(String.valueOf(arg0.getKeyChar()));
			}
			@Override
			public void keyPressed(KeyEvent arg0) {
				logger.debug("pressed");
				logger.debug(arg0);
				textField.setText(gainedText);
			}
		});
		textField.setEditable(false);
		getContentPane().add(textField, BorderLayout.CENTER);
		textField.setBackground(this.getBackground());
		textField.setCaretColor(getBackground());
		textField.setColumns(10);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.NORTH);
		
		panel.add(lblFoo);
		setModal(true);
		textField.requestFocus();
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		
		setBounds(((dim.width - width) / 2), ((dim.height - height) / 2), width, height);
		setVisible(false);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		playerEntry.setBuzzerCode(lblFoo.getText());
		logger.debug("Modified playerEntry: " + playerEntry);
		setVisible(false);
	}
}
