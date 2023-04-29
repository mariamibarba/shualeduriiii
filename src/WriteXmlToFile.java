import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class WriteXmlToFile {
    public static void main(String[] args) {
        try {
            // create the document builder
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

            // create the root element
            Document doc = dBuilder.newDocument();
            Element rootElement = doc.createElement("departments");
            doc.appendChild(rootElement);

            // create the first department element
            Element hrDepartment = doc.createElement("department");
            rootElement.appendChild(hrDepartment);
            Element hrName = doc.createElement("name");
            hrName.appendChild(doc.createTextNode("HR"));
            hrDepartment.appendChild(hrName);
            Element hrEmail = doc.createElement("email");
            hrEmail.appendChild(doc.createTextNode("hr@oracle.com"));
            hrDepartment.appendChild(hrEmail);

            // create the second department element
            Element itDepartment = doc.createElement("department");
            rootElement.appendChild(itDepartment);
            Element itName = doc.createElement("name");
            itName.appendChild(doc.createTextNode("IT"));
            itDepartment.appendChild(itName);
            Element itEmail = doc.createElement("email");
            itEmail.appendChild(doc.createTextNode("it@java.com"));
            itDepartment.appendChild(itEmail);

            // write the XML to a file
            File file = new File("departments.xml");
            FileOutputStream fos = new FileOutputStream(file);
            byte[] xmlBytes = docToString(doc).getBytes("UTF-8");
            fos.write(xmlBytes);
            fos.close();
        } catch (ParserConfigurationException | IOException e) {
            e.printStackTrace();
        }
    }

    public static String docToString(Document doc) {
        try {
            // create a transformer factory
            javax.xml.transform.TransformerFactory transformerFactory =
                    javax.xml.transform.TransformerFactory.newInstance();
            javax.xml.transform.Transformer transformer = transformerFactory.newTransformer();
            javax.xml.transform.dom.DOMSource source = new javax.xml.transform.dom.DOMSource(doc);
            javax.xml.transform.stream.StreamResult result =
                    new javax.xml.transform.stream.StreamResult(new java.io.StringWriter());
            transformer.transform(source, result);
            return result.getWriter().toString();
        } catch (javax.xml.transform.TransformerException ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
