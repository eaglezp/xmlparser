package xmlparser;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.*;


public class XMLParser {

    public static void main(String[] args) throws Exception{

    	// step 1: 获得dom解析器工厂
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        // step 2:获得具体的dom解析器
        DocumentBuilder db = dbf.newDocumentBuilder();

        InputStream inputStream = XMLParser.class.getClassLoader().getResourceAsStream("xmlparser/person.xml");
       /* String filePath = XMLParser.class.getClassLoader().getResource("xmlparser/person.xml").getPath();
        System.out.println(filePath);
        File file = new File(filePath);
        inputStream = new FileInputStream(file);*/

        // step3:获得Document对象
        Document document = db.parse(inputStream);

        NodeList plist = document.getElementsByTagName("persons");
        for(int i = 0; i < plist.getLength(); i++) {
           Element pelement = (Element)plist.item(i);
           NodeList cList = pelement.getElementsByTagName("person");

           for(int j=0;j<cList.getLength();j++) {
        	   Element celement = (Element)cList.item(j);

        	   int id = Integer.parseInt(celement.getElementsByTagName("id").item(0).getFirstChild().getNodeValue());

               String name = celement.getElementsByTagName("name").item(0).getFirstChild().getNodeValue();

               int age = Integer.parseInt(celement.getElementsByTagName("age").item(0).getFirstChild().getNodeValue());

               //封装对象。。。
               System.out.println("id:"+id+",name:"+name+",age:"+age);
           }
         }
     }

    

    class Person{

        private int id;
        private String name;
        private int age;

        public Person() {
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}
