package de.codingmonk.hackady.gui;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import de.codingmonk.hackady.core.KeyEventDispatcher;
import de.codingmonk.hackady.core.Player;

public class EventPanel extends JPanel {
	private JLabel lblPlayername;

	private KeyEventDispatcher ked;

	private Player player;
	public EventPanel() {
		
	}
	
	public void initialize() {
setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panel = new JPanel();
		add(panel);
		
		lblPlayername = new JLabel(player.getName());
		lblPlayername.setForeground(player.getColor());
		lblPlayername.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		panel.add(lblPlayername);
		
		JPanel panel_1 = new JPanel();
		add(panel_1);
		
		JButton button = new JButton("Right");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				setVisible(false);
				removeAll();
				player.setPoints((player.getPoints() + ked.getShowItem().getAnswer().getValue()));
				PlayerPanel.getInstance().drawTable();
				updateUI();
				ked.setLocked(false);
				ked.getShowItem().setVisible(false);
				ked.getShowItem().closeAnswer();
			}
		});
		panel_1.add(button);
		
		JButton button_1 = new JButton("Wrong");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				setVisible(false);
				removeAll();
				player.setPoints((player.getPoints() - ked.getShowItem().getAnswer().getValue()));
				PlayerPanel.getInstance().drawTable();
				updateUI();
				ked.setLocked(false);
			}
		});
		panel_1.add(button_1);
		
	}

	public void playerAction(Player player, KeyEventDispatcher ked) {
		// TODO Auto-generated method stub
		this.ked = ked;
		this.player = player;

		
		initialize();
		this.setVisible(true);
		
	}

}
