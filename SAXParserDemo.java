package TestApp.Test;

import javax.xml.parsers.*;
import org.xml.sax.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

import org.xml.sax.helpers.*;
public class SAXParserDemo {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		// TODO Auto-generated method stub
		File file = new File("C:\\Desktop\\shelav\\test\\Output.xml");
		SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
		SAXParser saxParser = saxParserFactory.newSAXParser();
		UserHandler userHandler = new UserHandler();
		saxParser.parse(file, userHandler);
		Question question = userHandler.getQuestion();
		List<Answers> answersList = question.getAnswers();
		System.out.println("Question ID: "+question.getId());
		for(Answers answer: answersList){
			System.out.println("Answers: "+answer);
		}
		System.out.println("Question Name: "+question.getQuestionName());
	}

}
class UserHandler extends DefaultHandler{
	
	Question question = new Question();
	List<Answers> answersList = new ArrayList<>();
	Answers answers = null;
	String content = null;
	public Question getQuestion(){
		return question;
	}
	
	/*public List<Answers> getAnswersList() {
        return answersList;
    }*/
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		// TODO Auto-generated method stub
		//super.startElement(uri, localName, qName, attributes);
		
		if(qName.equalsIgnoreCase("question")){
			
			String id = attributes.getValue("id");
			//question = new Question();
			question.setId(id);
			//System.out.println("Question ID: "+id);
		}
		else if(qName.equalsIgnoreCase("answers")){
			answers = new Answers();
		}
	}
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		// TODO Auto-generated method stub
		//super.endElement(uri, localName, qName);
		if(qName.equalsIgnoreCase("answers")){
			answersList.add(answers);
		}
		if(qName.equalsIgnoreCase("questionName")){
			//bquestionName = true;
			question.setQuestionName(content);			
		}
		if(qName.equalsIgnoreCase("id")){
			answers.setId(content);
		}
		if(qName.equalsIgnoreCase("answersName")){
			answers.setAnswersName(content);
		}
		if(qName.equalsIgnoreCase("postedBy")){
			answers.setPostedBy(content);
		}
		if(qName.equalsIgnoreCase("question")){
			question.setAnswers(answersList);
		}
		
		
	}
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		// TODO Auto-generated method stub
		//super.characters(ch, start, length);
		content = new String(ch, start, length);
	}
}