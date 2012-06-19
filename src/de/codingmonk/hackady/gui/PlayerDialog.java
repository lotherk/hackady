package de.codingmonk.hackady.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import org.apache.log4j.Logger;

import de.codingmonk.hackady.core.Player;
import de.codingmonk.hackady.core.PlayerList;

public class PlayerDialog extends JDialog {
	private static Logger logger = Logger.getLogger(PlayerDialog.class);
	private static final int DEFAULT_PLAYER = 3;
	private final JPanel contentPanel = new JPanel();
	private static PlayerDialog instance;
	private PlayerList playerList = PlayerList.getInstance();
	private final JPanel entryPane = new JPanel();
	private ArrayList<PlayerEntry> playerEntryList = new ArrayList<PlayerEntry>();
	private int yGrid;
	private int width = 450;
	private int height = 300;
	public static PlayerDialog getInstance() {
		if(instance == null)
			instance = new PlayerDialog();
		return instance;
	}
	

	/**
	 * Create the dialog.
	 */
	private PlayerDialog() {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setModal(true);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		
		setBounds(((dim.width - width) / 2), ((dim.height - height) / 2), width, height);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JLabel lblSelectUser = new JLabel("Select User");
			contentPanel.add(lblSelectUser, BorderLayout.NORTH);
		}
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(new BorderLayout(0, 0));
			{
				final JPanel panel_1 = new JPanel();
				panel.add(panel_1, BorderLayout.NORTH);
				panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.X_AXIS));
				{
					JButton btnAddUser = new JButton("Add User");
					btnAddUser.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							PlayerEntry playerEntry = new PlayerEntry();
							
							playerEntryList.add(playerEntry);
							entryPane.add(playerEntry);
							entryPane.updateUI();
						}
					});
					panel_1.add(btnAddUser);
				}
				{
					JButton btnClear = new JButton("Clear");
					panel_1.add(btnClear);
				}
			}
			{
				JScrollPane scrollPane = new JScrollPane();
				panel.add(scrollPane, BorderLayout.CENTER);
				{
					
					scrollPane.setViewportView(entryPane);
					entryPane.setLayout(new GridLayout(0, 1, 0, 0));
					// add default players
					for(int i = 0; i < DEFAULT_PLAYER; i++)
					{
						PlayerEntry userEntry = new PlayerEntry();
						userEntry.setDefaultText("Player " + (i+1));
						playerEntryList.add(userEntry);
						entryPane.add(userEntry);
					}
					
				}
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Start");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						for(PlayerEntry entry : playerEntryList) {
							Player player = new Player();
							player.setColor(entry.getColor());
							player.setName(entry.getPlayername());
							player.setBuzzerCode(entry.getBuzzerCode());
							playerList.add(player);
							PlayerPanel.getInstance().addPlayer(player);
							logger.debug("Added Player: " + player);
						}
						setVisible(false);
						Hackady.getInstance().startGame();
					}
				});
				okButton.setActionCommand("Start");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}


	public void removeEntry(PlayerEntry entry) {
		// TODO Auto-generated method stub
		playerEntryList.remove(entry);
		playerList.remove(entry);
		entryPane.remove(entry);
		entryPane.updateUI();
	}

}
