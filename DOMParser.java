package TestApp.Test;
import java.io.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

public class DOMParser {
	
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		// TODO Auto-generated method stub
		File file = new File("C:\\Desktop\\shelav\\test\\Output.xml");
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(file);
		System.out.println("Root Element: "+doc.getDocumentElement().getNodeName());
		NodeList nList = doc.getElementsByTagName("question");
		System.out.println("-----------------------------------------------------");
		for(int temp = 0; temp < nList.getLength(); temp++){
			Node nNode = nList.item(temp);
			System.out.println("Current Element: "+nNode.getNodeName());
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
			Element element = (Element)nNode;
			System.out.println("Question ID: "+ element.getAttribute("id"));
			NodeList nodeList = doc.getElementsByTagName("answers");
			for(int tempNew = 0; tempNew < nodeList.getLength(); tempNew++){
				Node node = nodeList.item(tempNew); 
				System.out.println("New Current Element: "+node.getNodeName());
				Element ele = (Element)node;
				System.out.println("Answer Name: "+ ele.getElementsByTagName("answersName").item(0).getTextContent());
		        System.out.println("Answer ID: "+ ele.getElementsByTagName("id").item(0).getTextContent());
		        System.out.println("Posted By: "+ ele.getElementsByTagName("postedBy").item(0).getTextContent());
			}
	        /*System.out.println("Answer Name: "+ element.getElementsByTagName("answersName").item(0).getTextContent());
	        System.out.println("Answer ID: "+ element.getElementsByTagName("id").item(0).getTextContent());
	        System.out.println("Posted By: "+ element.getElementsByTagName("postedBy").item(0).getTextContent());*/
	        System.out.println("Question Name: "+ element.getElementsByTagName("questionName").item(0).getTextContent());
			}
		}
	}

}
