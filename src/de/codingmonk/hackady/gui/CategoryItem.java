package de.codingmonk.hackady.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import de.codingmonk.hackady.set.HackadyAnswer;

public class CategoryItem extends JButton implements ActionListener {

	HackadyAnswer answer;
	
	public CategoryItem() {
		
		addActionListener(this);
		
		
		
	}
	
	
	
	public int getValue() {
		return answer.getValue();
	}



	public void setValue(int value) {
		answer.setValue(value);
	}



	public HackadyAnswer getAnswer() {
		return answer;
	}



	public void setAnswer(HackadyAnswer answer) {
		// TODO Auto-generated method stub
		this.answer = answer;
	}



	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		new ShowItem(answer, this);
	}
	
	

}

