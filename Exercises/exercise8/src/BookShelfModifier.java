import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
import java.io.*;

public class BookShelfModifier {

    public static void main(String[] args) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            File xmlFile = new File("src/bookshelf.xml");
            Document document = builder.parse(xmlFile);

            document.getDocumentElement().normalize();

            Element bookshelf = (Element) document.getElementsByTagName("bookshelf").item(0);

            Element newBook = document.createElement("book");

            Element title = document.createElement("title");
            title.appendChild(document.createTextNode("Data Structures and Algorithms in Java"));
            newBook.appendChild(title);

            Element publishedYear = document.createElement("publishedyear");
            publishedYear.appendChild(document.createTextNode("2015"));
            newBook.appendChild(publishedYear);

            Element numberOfPages = document.createElement("numberofpages");
            numberOfPages.appendChild(document.createTextNode("1024"));
            newBook.appendChild(numberOfPages);

            Element authors = document.createElement("authors");
            authors.appendChild(document.createTextNode("Robert Lafore"));
            newBook.appendChild(authors);

            bookshelf.appendChild(newBook);

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");


            transformer.transform(new DOMSource(document), new StreamResult(System.out));
            transformer.transform(new DOMSource(document), new StreamResult(new File("src/bookshelf_modified.xml")));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
