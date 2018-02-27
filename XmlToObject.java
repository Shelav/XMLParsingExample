package TestApp.Test;

import java.io.File;
import java.util.List;

import javax.xml.bind.*;

public class XmlToObject {

	public static void main(String[] args) throws JAXBException {
		// TODO Auto-generated method stub
		File file = new File("C:\\Desktop\\shelav\\test\\Output.xml");
		JAXBContext jaxbContext = JAXBContext.newInstance(Question.class); 
		Unmarshaller unmarshallerObj = jaxbContext.createUnmarshaller();
		
		Question question = (Question) unmarshallerObj.unmarshal(file);
		
		System.out.println("Question ID: "+question.getId()+" Question Name: "+question.getQuestionName());
		System.out.println("Answers");
		List<Answers> listAnswers = question.getAnswers();
		for(Answers answers: listAnswers){
			System.out.println("Answer ID: "+answers.getId()+" Answer Name: "+answers.getAnswersName()+" Answer PostedBy: "+answers.getPostedBy());
		}
	}

}
