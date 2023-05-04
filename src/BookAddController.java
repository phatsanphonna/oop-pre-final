
import java.awt.event.*;
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author phats
 */
public class BookAddController implements Controllerable, ActionListener {

    private BookAddView bookAddView;
    private BookView bookView;
    private BookService service;

    public BookAddController(BookAddView bookAddView, BookView bookView, BookService service) {
        this.bookAddView = bookAddView;
        this.bookView = bookView;
        this.service = service;
    }

    @Override
    public void start() {
        this.bookAddView.insertButton.addActionListener(this);
        this.bookAddView.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(this.bookAddView.insertButton)) {
            String name = this.bookAddView.nameTextField.getText();
            double price = Double.parseDouble(this.bookAddView.priceTextField.getText());
            String type = this.bookAddView.typeComboBox.getSelectedItem().toString();

            Book book = new Book(name, price, type);

            this.service.addBook(book);

            int size = this.service.getBooks().size() - 1;
            System.out.println(size);

            this.bookView.callback(size, book);
            this.bookAddView.dispose();
        }
    }

}
