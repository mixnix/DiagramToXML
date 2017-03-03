import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

/**
 * Created by user_name on 01.03.2017.
 */
public class Main {
    private static String level = "##########\n" +
            "#        #\n" +
            "#        #\n" +
            "#        #\n" +
            "#        #\n" +
            "#        #\n" +
            "#        #\n" +
            "#        #\n" +
            "#        #\n" +
            "##########";
    public static void main(String[] args){

        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

            Document doc = dBuilder.newDocument();

            String[] lines = level.split("\\r\\n|\\r|\\n");
            int num_of_lines = lines.length;

            for(int n = 0; n < num_of_lines; ++n){
                for(int i = 1; i <= lines[n].length(); ++i){
                    //here converting to xml elements will beK
                }
            }



            // write the content into xml file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("C:\\wyjsciowe_pliki\\cars.xml"));
            transformer.transform(source, result);
            // Output to console for testing
            StreamResult consoleResult = new StreamResult(System.out);
            transformer.transform(source, consoleResult);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
