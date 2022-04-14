import java.io.*;
import java.sql.Timestamp;

public class WriteHtml {

    String potDoDatoteke;

    public WriteHtml(String pot) {
        this.potDoDatoteke = pot;

        try {
            FileOutputStream fileOutputStream = new FileOutputStream(this.potDoDatoteke);
            Writer Buffer = new BufferedWriter(new OutputStreamWriter(fileOutputStream, "UTF-8"));
            Buffer.write("");

            Buffer.flush();
            Buffer.close();
        } catch (Exception e) {
            System.out.println("Napaka -> " + e.getMessage());
        }

    }

    public void HtmlStart() {
        String text = "<!DOCTYPE html>" + "\r\n" +
                "<meta charset='utf-8'" + "\r\n" +
                "<html>" + "\r\n";
        writeHTML(text);

    }

    public void Head(String naslov) {
        String text = "<head>" + "\r\n" +
                "<title>" + naslov + "</title>" + "\r\n" +
                "<link rel='/style.css'>" + "\r\n" +
                "</head>" + "\r\n" +
                "<body>" + "\r\n" +
                "<table border='1' id='JsonRead'>" + "\r\n";
        writeHTML(text);

    }

    public void TableRow(Timestamp Date, String address, String message) {
        String text = "<tr><td>" + Date + "</td>" +"<td>" + address + "</td>"+"<td>" + message + "</td></tr>"+ "\r\n";
        writeHTML(text);
    }

    public void HtmlEnd() {
        String text = "</table>\r\n" + "</body>\r\n</html>";
        writeHTML(text);
    }

    public void writeHTML(String text) {
        try {

            FileOutputStream fileOutputStream = new FileOutputStream(this.potDoDatoteke, true);
            Writer Buffer = new BufferedWriter(new OutputStreamWriter(fileOutputStream, "UTF-8"));
            Buffer.write(text);
            Buffer.flush();
            Buffer.close();
        } catch (Exception e) {
            System.out.println("Napaka -> " + e.getMessage());
        }
    }
}
