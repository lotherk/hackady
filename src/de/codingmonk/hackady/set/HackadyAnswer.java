package de.codingmonk.hackady.set;

import javax.xml.bind.annotation.XmlAttribute;

public class HackadyAnswer {
	
	private String answer;
	private boolean doubleHackady = false;
	private int value;
	private String result;
	
	
	
	@XmlAttribute(name="value")
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	@XmlAttribute(name = "text")
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	@XmlAttribute(name= "double-hackady")
	public boolean isDoubleHackady() {
		return doubleHackady;
	}
	public void setDoubleHackady(boolean doubleHackady) {
		this.doubleHackady = doubleHackady;
	}
	@XmlAttribute(name = "result")
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String toString() {
		return String.valueOf(getValue());
	}
	

}
