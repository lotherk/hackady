package de.codingmonk.hackady.core;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.apache.log4j.Logger;

import de.codingmonk.hackady.set.HackadySet;

public class HackadySetLoader {

	private static Logger logger = Logger.getLogger(HackadySetLoader.class);
	
	public HackadySetLoader() {
		
	}
	
	public static HackadySet loadSetFromFile(File file) {
		JAXBContext context;
		HackadySet hackadySet = null;
			try {
				context = JAXBContext.newInstance(HackadySet.class);
				Unmarshaller um = context.createUnmarshaller();
				hackadySet = (HackadySet) um.unmarshal(new FileReader(file));
				return hackadySet;
			} catch (JAXBException e) {
				// TODO Auto-generated catch block
				logger.error(e);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				logger.error(e);
			}
			
		return hackadySet;
			
	}
	
	public static void saveSetToFile(HackadySet hackadySet, File file) {
		logger.debug("Creating xml for " + hackadySet);
		try {
			JAXBContext context = JAXBContext.newInstance(HackadySet.class);
			Marshaller m = context.createMarshaller();
			m.setProperty( Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE );
			m.marshal(hackadySet, new FileWriter(file));
			logger.debug("xml written to " + file);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			logger.error(e);
		} catch (Exception e) {
			logger.error(e);

		}
	}
	
	
	
}
