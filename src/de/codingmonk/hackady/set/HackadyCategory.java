package de.codingmonk.hackady.set;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class HackadyCategory {
	
	
	private String title;
	private String description;
	private List<HackadyAnswer> listHackadyAnswer;
	
	
	
	@XmlElement(name = "description")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@XmlAttribute(name = "title")
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@XmlElement(name = "answer")
	public List<HackadyAnswer> getAnswers() {
		if (listHackadyAnswer == null)
			listHackadyAnswer = new ArrayList<HackadyAnswer>();
		return listHackadyAnswer;
	}

	public void setAnwser(List<HackadyAnswer> listHackadyAnswer) {
		this.listHackadyAnswer = listHackadyAnswer;
	}

	public void addAnswer(HackadyAnswer answer) {
		// TODO Auto-generated method stub
		getAnswers().add(answer);
	}

	public HackadyAnswer getAnswerByValue(int value) {
		for(HackadyAnswer answ : getAnswers()) {
			if(answ.getValue() == value)
				return answ;
		}
		return null;
	}

}
