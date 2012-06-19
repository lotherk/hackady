package de.codingmonk.hackady.set;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(namespace = "http://hackady.codingmonk.de", name = "hackady")
public class HackadySet {
	private List<HackadyCategory> listHackadyCategory;

	@XmlElement(name = "category")
	public List<HackadyCategory> getCategory() {
		if (listHackadyCategory == null)
			listHackadyCategory = new ArrayList<HackadyCategory>();
		return listHackadyCategory;
	}

	public void setCategory(List<HackadyCategory> listHackadyCategory) {
		this.listHackadyCategory = listHackadyCategory;
	}

	public void addCategory(HackadyCategory cat) {
		// TODO Auto-generated method stub
		getCategory().add(cat);
	}

}
