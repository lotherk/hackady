package de.codingmonk.hackady.tools;

import java.io.File;

import de.codingmonk.hackady.core.HackadySetLoader;
import de.codingmonk.hackady.set.HackadyAnswer;
import de.codingmonk.hackady.set.HackadyCategory;
import de.codingmonk.hackady.set.HackadySet;

public class CreateBasicHackadySetXML {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		HackadySet hackadySet = new HackadySet();
		HackadyCategory cat = new HackadyCategory();
		cat.setTitle("L33t-TV");
		HackadyAnswer answer = new HackadyAnswer();
		answer.setAnswer("Foobar");
		cat.addAnswer(answer);
		answer = new HackadyAnswer();
		answer.setAnswer("Barfoo");
		answer.setDoubleHackady(true);
		answer.setResult("FooFooBar");
		cat.addAnswer(answer);
		hackadySet.addCategory(cat);
		HackadySetLoader.saveSetToFile(hackadySet, new File("testSet.xml"));

	}

}
