import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BookJSONModifier {
    public static void main(String[] args) {
        String filePath = "src/bookshelf.json";

        JSONParser parser = new JSONParser();

        try {
            Object obj = parser.parse(new FileReader(filePath));

            JSONObject jsonObject = (JSONObject) obj;

            JSONArray bookshelf = (JSONArray) jsonObject.get("bookshelf");

            JSONObject newBook = new JSONObject();
            newBook.put("title", "Data Structures and Algorithms in Java");
            newBook.put("publishedYear", 2015);
            newBook.put("numberOfPages", 1024);
            newBook.put("authors", "Robert Lafore");

            bookshelf.add(newBook);

            try (FileWriter writer = new FileWriter("src/bookshelf_modified.json")) {
                writer.write(jsonObject.toJSONString().replace("{", "{\n").replace("}", "\n}").replace("},", "},\n"));
                writer.flush();
            }

            String formattedJson = jsonObject.toJSONString().replace(",", ",\n").replace("{", "{\n").replace("}", "\n}");
            System.out.println(formattedJson);
            System.out.println("New book added and printed successfully!");

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }
}
