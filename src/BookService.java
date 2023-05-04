
import java.io.*;
import java.util.*;
import java.util.logging.*;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author phats
 */
public class BookService {

    private File file;
    private ArrayList<Book> books;
    
    public BookService() {
        this.books = new ArrayList<>();
    }

    public ArrayList<Book> loadSavedBooks() {
        System.out.println("Loading Save Books from File");

        this.loadFile();

        try (
                ObjectInputStream oin = new ObjectInputStream(new FileInputStream(file));) {
            ArrayList<Book> books = (ArrayList<Book>) oin.readObject();

            this.setBooks(books);

            for (Book book : this.books) {
                System.out.println(book.getName());
            }
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(BookService.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public void loadFile() {
        file = new File("Book.data");

        try {
            file.createNewFile();
        } catch (IOException ex) {
            Logger.getLogger(BookService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void saveFile() {
        System.out.println("Saving Books from File");

        try (
                ObjectOutputStream oon = new ObjectOutputStream(new FileOutputStream(file));) {
            oon.writeObject(this.getBooks());
        } catch (IOException ex) {
            Logger.getLogger(BookService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }

    public ArrayList<Book> getBooks() {
        return this.books;
    }

    public Book getBookByIndex(int index) {
        return this.getBooks().get(index);
    }

    public Book deleteBook(int index) {
        return this.getBooks().remove(index);
    }

    public Book updateBook(int index, Book book) {
        return this.getBooks().set(index, book);
    }

    public boolean addBook(Book book) {
        System.out.println("Book Added from BookService");
        return this.getBooks().add(book);
    }
}
