import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;

public class BookShelfParser {

    public static void main(String[] args) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            File xmlFile = new File("src/bookshelf.xml");
            Document document = builder.parse(xmlFile);

            document.getDocumentElement().normalize();

            NodeList bookList = document.getElementsByTagName("book");

            System.out.println("BookShelf");

            for (int i = 0; i < bookList.getLength(); i++) {
                Node bookNode = bookList.item(i);

                if (bookNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element bookElement = (Element) bookNode;

                    String title = bookElement.getElementsByTagName("title").item(0).getTextContent();
                    String publishedYear = bookElement.getElementsByTagName("publishedyear").item(0).getTextContent();
                    String numberOfPages = bookElement.getElementsByTagName("numberofpages").item(0).getTextContent();
                    String authors = bookElement.getElementsByTagName("authors").item(0).getTextContent();

                    System.out.println("Book" + (i + 1));
                    System.out.println("Title: " + title);
                    System.out.println("Published Year: " + publishedYear);
                    System.out.println("Number of Pages: " + numberOfPages);
                    System.out.println("Authors: " + authors);
                    System.out.println();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
