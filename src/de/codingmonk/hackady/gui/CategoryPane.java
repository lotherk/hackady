package de.codingmonk.hackady.gui;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;

import de.codingmonk.hackady.set.HackadyAnswer;

public class CategoryPane extends JPanel {

	
	
	private JLabel lblTitle;
	private ArrayList<CategoryItem> itemList;
	private JPanel catPane;
	
	public JLabel getLblTitle() {
		return this.lblTitle;
	}
	/**
	 * Create the panel.
	 */
	
	
	
	public CategoryPane() {
		setLayout(new BorderLayout(0, 0));
		itemList = new ArrayList<CategoryItem>();
		lblTitle = new JLabel("New label");
		add(lblTitle, BorderLayout.NORTH);
		
		catPane = new JPanel();
		add(catPane, BorderLayout.CENTER);
		GridBagLayout gbl_catPane = new GridBagLayout();
		gbl_catPane.columnWidths = new int[]{0};
		gbl_catPane.rowHeights = new int[]{0};
		gbl_catPane.columnWeights = new double[]{Double.MIN_VALUE};
		gbl_catPane.rowWeights = new double[]{Double.MIN_VALUE};
		catPane.setLayout(new GridLayout(0, 1, 0, 0));
		
//		JButton btnNewButton = new JButton("New button");
//		
//		
//		JButton btnNewButton_1 = new JButton("New button");
//		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
//		gbc_btnNewButton_1.anchor = GridBagConstraints.NORTHWEST;
//		gbc_btnNewButton_1.gridx = 0;
//		gbc_btnNewButton_1.gridy = 1;
//		add(btnNewButton_1, gbc_btnNewButton_1);
		
//		
//		for(int i = 0; i < 5; i++) {
//			CategoryItem item = new CategoryItem();
//			item.setText("Foo " + i);
//			GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
//			gbc_btnNewButton.anchor = GridBagConstraints.NORTHWEST;
//			gbc_btnNewButton.insets = new Insets(0, 0, 5, 0);
//			gbc_btnNewButton.gridx = 0;
//			gbc_btnNewButton.gridy = i;
//			catPane.add(item, gbc_btnNewButton);
//		}

	}
	public void addAnswerList(List<HackadyAnswer> answerList) {
		// TODO Auto-generated method stub
		
		
		for(HackadyAnswer answer : answerList) {
			CategoryItem item = new CategoryItem();
			item.setAnswer(answer);
			item.setText(String.valueOf(answer.getValue()));
			catPane.add(item); //, gbc_btnNewButton);
				
		}
	}

}
