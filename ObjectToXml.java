package TestApp.Test;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.rmi.MarshalledObject;
import java.util.ArrayList;

import javax.xml.bind.*;

public class ObjectToXml {

	public static void main(String[] args) throws JAXBException, FileNotFoundException {
		// TODO Auto-generated method stub
		JAXBContext jaxbContext = JAXBContext.newInstance(Question.class);
		Marshaller marshallerObj = jaxbContext.createMarshaller();
		marshallerObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		
		Answers answersObj1 = new Answers("101", "Java is Programing language", "John");
		Answers answersObj2 = new Answers("102", "Java is a Platform independent", "Robert");
		
		ArrayList<Answers> listAnswers = new ArrayList<>();
		listAnswers.add(answersObj1);
		listAnswers.add(answersObj2);
		
		Question question = new Question("1", "What is Java?", listAnswers);
		marshallerObj.marshal(question, new FileOutputStream("C:\\Desktop\\shelav\\test\\Output.xml"));
	}

}
