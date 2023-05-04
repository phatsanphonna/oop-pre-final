
import java.awt.event.*;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author phats
 */
public class BookController implements Controllerable, WindowListener, ActionListener {

    private BookView view;
    private BookService service;

    public BookController(BookView view, BookService service) {
        this.view = view;
        this.service = service;
    }

    @Override
    public void start() {
        this.view.addWindowListener(this);
        this.view.addButton.addActionListener(this);
        this.view.nextButton.addActionListener(this);
        this.view.previousButton.addActionListener(this);
        this.view.updateButton.addActionListener(this);
        this.view.deleteButton.addActionListener(this);

        this.view.start();
    }

    @Override
    public void windowOpened(WindowEvent e) {
        this.service.loadSavedBooks();

        Book book = this.service.getBookByIndex(0);

        if (book == null) {
            this.view.callback(0, new Book());
        } else {
            this.view.callback(0, book);
        }
    }

    @Override
    public void windowClosing(WindowEvent e) {
        this.service.saveFile();
    }

    @Override
    public void windowClosed(WindowEvent e) {
    }

    @Override
    public void windowIconified(WindowEvent e) {
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(this.view.addButton)) {
            BookAddView bookAddView = new BookAddView();
            BookAddController bookAddController = new BookAddController(bookAddView, view, this.service);

            bookAddController.start();
            return;
        }

        int current = Integer.parseInt(this.view.currentObjectTextField.getText());

        String name = this.view.nameTextField.getText();
        double price = Double.parseDouble(this.view.priceTextField.getText());
        String type = this.view.typeComboBox.getSelectedItem().toString();

        if (e.getSource().equals(this.view.updateButton)) {
            Book book = new Book(name, price, type);
            this.service.updateBook(current, book);
            this.view.callback(current, book);
        } else if (e.getSource().equals(this.view.deleteButton)) {
            this.service.deleteBook(current);
            this.view.callback(0, this.service.getBookByIndex(0));
        } else if (e.getSource().equals(this.view.previousButton)) {
            if (current != 0) {
                Book book = this.service.getBookByIndex(current - 1);
                this.view.callback(current - 1, book);
            }
        } else if (e.getSource().equals(this.view.nextButton)) {
            if (current + 1 < this.service.getBooks().size()) {
                Book book = this.service.getBookByIndex(current + 1);
                this.view.callback(current + 1, book);
            }
        }
    }
}
