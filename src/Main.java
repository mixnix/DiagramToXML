import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

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
            "#  @     #\n" +
            "#$$$$    #\n" +
            "#        #\n" +
            "#        #\n" +
            "#%%%%    #\n" +
            "#        #\n" +
            "#        #\n" +
            "#        #\n" +
            "##########";
    public static void main(String[] args){

        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

            Document doc = dBuilder.newDocument();

            Element rootElement = doc.createElement("level_layout");
            doc.appendChild(rootElement);

            String[] lines = level.split("\\r\\n|\\r|\\n");
            int num_of_lines = lines.length;

            for(int n = 0; n < num_of_lines; ++n){

                //  supercars element
                Element line = doc.createElement("line");
                rootElement.appendChild(line);

                for(int i = 0; i < lines[n].length(); ++i){
                    char temp = lines[n].charAt(i);

                    if(temp == '#'){
                        // carname element
                        Element field = doc.createElement("field");
                        field.appendChild(
                                doc.createTextNode("wall"));
                        line.appendChild(field);
                    } else if(temp == ' '){
                        // carname element
                        Element field = doc.createElement("field");
                        field.appendChild(
                                doc.createTextNode("empty_field"));
                        line.appendChild(field);
                    } else if(temp == '@'){
                        Element field = doc.createElement("field");
                        field.appendChild(
                                doc.createTextNode("player"));
                        line.appendChild(field);
                    } else if(temp == '$'){
                        Element field = doc.createElement("field");
                        field.appendChild(
                                doc.createTextNode("box"));
                        line.appendChild(field);
                    } else if(temp == '%'){
                        Element field = doc.createElement("field");
                        field.appendChild(
                                doc.createTextNode("end_position"));
                        line.appendChild(field);
                    }
                }

            }



            // write the content into xml file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("C:\\wyjsciowe_pliki\\diagram.xml"));
            transformer.transform(source, result);
            // Output to console for testing
            StreamResult consoleResult = new StreamResult(System.out);
            transformer.transform(source, consoleResult);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
