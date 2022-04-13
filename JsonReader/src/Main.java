import com.fasterxml.jackson.databind.JsonNode;
import com.github.fge.jackson.JsonLoader;

import java.io.IOException;
import java.sql.Timestamp;


public class Main {

    public static void main(String[] args) {
        try {
            JsonNode json = JsonLoader.fromPath("./Vhod.json");
            for (int index = 0; index < json.get("sporocila").size(); index++) {
                        // System.out.println(json.get("sporocila").get(index));
                //timestamp = number of seconds from 1970.01.01 00:00
                //group objects by IP address

                WriteHtml Write = new WriteHtml("./test.html");

                Write.HtmlStart();
                Write.Head("Branje Json");

                Timestamp ts = new Timestamp(json.get("sporocila").get(index).get("timestamp").asLong());

                Write.TableRow(ts);
                Write.HtmlEnd();

            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}