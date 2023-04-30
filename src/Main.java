import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.*;
import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        File file = new File("src/input.xml");
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        Document doc = dbf.newDocumentBuilder().parse(file);                        // We used dom prese xml to read it from the file
        doc.getDocumentElement().normalize();


        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Enter book ID or '0' to quit : ");                                        // let the user to choose the book id
            String bookId = scanner.nextLine().trim();
            if (bookId.equals("0")) {
                break;
            }
            NodeList nodeList = doc.getElementsByTagName("book");        // we used nodelist cuz of the dom reading the xml like node
            Element book = null;
            for (int i = 0; i < nodeList.getLength(); i++) {
                book = (Element) nodeList.item(i);                          // searching for the book
                if (book.getAttribute("id").equals(bookId)) {
                    break;
                }
                book = null;
            }

            if (book != null) {
                String author = book.getElementsByTagName("author").item(0).getTextContent();
                String title = book.getElementsByTagName("title").item(0).getTextContent();
                String genre = book.getElementsByTagName("genre").item(0).getTextContent();                     // get the book info
                String price = book.getElementsByTagName("price").item(0).getTextContent();
                String publish_date = book.getElementsByTagName("publish_date").item(0).getTextContent();
                String description = book.getElementsByTagName("description").item(0).getTextContent();


                System.out.println("===========================================");
                System.out.println("Book ID: " + bookId);
                System.out.println("Author: " + author);
                System.out.println("Title: " + title);
                System.out.println("Genre: " + genre);                              // printing on console
                System.out.println("Price: " + price);
                System.out.println("Publish Date: " + publish_date);
                System.out.println("Description: " + description);
                System.out.println("===========================================");

            } else {
                System.out.println("No book found with ID: " + bookId);
            }
        }
    }
}