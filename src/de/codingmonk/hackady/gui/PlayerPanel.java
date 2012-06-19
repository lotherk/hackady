package de.codingmonk.hackady.gui;

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import de.codingmonk.hackady.core.Player;
import de.codingmonk.hackady.core.PlayerList;

public class PlayerPanel extends JPanel {

	private static PlayerPanel instance;
	
	public static PlayerPanel getInstance() {
		if(instance == null) 
			instance = new PlayerPanel();
		return instance;
	}
	
	private PlayerPanel() {
		setLayout(new GridLayout(1, 0, 0, 0));
				
		
		
		
		
		
		
	}
	
	@Deprecated
	public void addPlayer(Player player) {
		drawTable();
	}

	public void removeEntry(PlayerEntry instance2) {
		// TODO Auto-generated method stub
		
	}

	public void drawTable() {
		removeAll();
		for(Player player : PlayerList.getInstance()) {
			JPanel panel = new JPanel();
			JLabel lblPlayername = new JLabel(player.getName()+" ");
			lblPlayername.setForeground(player.getColor());
			Font f = lblPlayername.getFont();
			lblPlayername.setFont(new Font(f.getFontName(), Font.PLAIN, 20));

			panel.add(lblPlayername);
			
			JLabel label = new JLabel(String.valueOf(player.getPoints()));
			label.setFont(new Font(f.getFontName(), Font.PLAIN, 20));
			panel.add(label);
			panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
			add(panel);
		}
		updateUI();
	}
	@Deprecated
	public void updatePoints() {
		// TODO Auto-generated method stub
		drawTable();
	}
}
