import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
/**
 * A simple Store Catalog Class
 *
 * @author Shatakshi Singh
 * @version 10/15/2021
 */
public class StoreCatalog {
    private ArrayList<Book> books;
    private String fileName;

    public StoreCatalog(String fileName) throws FileNotFoundException, BookParseException {
        this.books = new ArrayList<Book>(100);
        this.fileName = fileName;
        File f = new File(fileName);
        if (!f.exists())
            throw new FileNotFoundException();
        try {
            FileReader fr = new FileReader(f);
            BufferedReader bfr = new BufferedReader(fr);
            String line = bfr.readLine();
            while (line != null) {
                books.add(parseBook(line));
                line = bfr.readLine();
            }
            bfr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Book parseBook(String line) throws BookParseException {
        int spaces = 0; 
        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == ' ')
                spaces++;
        }
        
        if (spaces != 4) {
            throw new BookParseException("Error parsing book! Data provided in a single line is invalid!");
        } else { 
            String bookName = line.substring(0, line.indexOf(" "));
            bookName = bookName.replace('_', ' ');
            line = line.substring(line.indexOf(" ") + 1);
            String authorName = line.substring(0, line.indexOf(" "));
            authorName = authorName.replace('_', ' ');
            line = line.substring(line.indexOf(" ") + 1);
            try {
                float price = Float.valueOf(line.substring(0, line.indexOf(" ")));
                line = line.substring(line.indexOf(" ") + 1);
                int quantity = Integer.valueOf(line.substring(0, line.indexOf(" ")));
                line = line.substring(line.indexOf(" ") + 1);
                int year = Integer.valueOf(line);
                Book book = new Book(bookName, authorName, price, quantity, year);
                return book;
            } catch (Exception e) {
                throw new BookParseException("Error parsing book! Failed to parse numbers from file");
            }
        }      
    }

    public ArrayList<Book> searchByName(String bookName) throws BookNotFoundException {
        ArrayList<Book> foundBooks = new ArrayList<Book>();
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getBookName().toLowerCase().contains(bookName.toLowerCase()))
                foundBooks.add(books.get(i));
        }
        if (foundBooks.isEmpty())
            throw new BookNotFoundException("No books found with the given book name!");
        return foundBooks;
    }

    public ArrayList<Book> searchByAuthor(String authorName) throws BookNotFoundException {
        ArrayList<Book> foundBooks = new ArrayList<Book>();
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getAuthorName().toLowerCase().contains(authorName.toLowerCase()))
            foundBooks.add(books.get(i));
        }
        if (foundBooks.isEmpty())
            throw new BookNotFoundException("No books found with the given author name!");
        return foundBooks;
    }

    public void purchaseBook(String bookName) throws BookNotFoundException {
        int found = 0;
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getBookName().toLowerCase().equals(bookName.toLowerCase())) {
                found++;
                if (books.get(i).getQuantity() == 1)
                    books.remove(i);
                else
                    books.get(i).setQuantity(books.get(i).getQuantity() - 1);
            }
        }
        if (found == 0)
            throw new BookNotFoundException("The given book was not found.");
    }

    public void writeChangesToFile() throws FileNotFoundException {
        FileOutputStream fos = new FileOutputStream(fileName);
        PrintWriter pw = new PrintWriter(fos);
        for (int i = 0; i < books.size(); i++) {
            String line = books.get(i).getBookName().replace(' ', '_') + " ";
            line += books.get(i).getAuthorName().replace(' ', '_') + " ";
            line += String.valueOf(books.get(i).getPrice()) + " ";
            line += String.valueOf(books.get(i).getQuantity()) + " ";
            line += String.valueOf(books.get(i).getYear()) + "\n";
            pw.print(line);
        }
        pw.close();         
    }
    
    public ArrayList<Book> getBookList() {
        return this.books;
    }
    
}
