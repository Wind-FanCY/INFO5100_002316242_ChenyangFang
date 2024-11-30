import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class BookJSONParser {
    public static void main(String[] args) {
        String filePath = "src/bookshelf.json";

        JSONParser parser = new JSONParser();

        try {
            Object obj = parser.parse(new FileReader(filePath));

            JSONObject jsonObject = (JSONObject) obj;

            JSONArray bookshelf = (JSONArray) jsonObject.get("bookshelf");

            System.out.println("BookShelf");

            for (int i = 0; i < bookshelf.size(); i++) {
                JSONObject book = (JSONObject) bookshelf.get(i);

                String title = (String) book.get("title");
                Long publishedYear = (Long) book.get("publishedYear");
                Long numberOfPages = (Long) book.get("numberOfPages");
                String authors = (String) book.get("authors");

                System.out.println("Book " + (i + 1) + ":");
                System.out.println("Title: " + title);
                System.out.println("Published Year: " + publishedYear);
                System.out.println("Number of Pages: " + numberOfPages);
                System.out.println("Authors: " + authors);
                System.out.println();
            }

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }
}
