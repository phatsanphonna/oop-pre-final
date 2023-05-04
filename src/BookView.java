


import java.awt.*;
import javax.swing.*;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author phats
 */
public class BookView extends JFrame implements Viewable {

    private final String[] typeItems = {
        "General", "Computer", "Math&Sci", "Photo3"
    };

    public JPanel namePanel, pricePanel, typePanel;
    public JLabel nameLabel, priceLabel, typeLabel;
    public JTextField nameTextField, priceTextField;
    public JComboBox typeComboBox;

    public JPanel selectPanel;
    public JButton previousButton, nextButton;
    public JTextField currentObjectTextField;

    public JPanel operationPanel;
    public JButton addButton, updateButton, deleteButton;

    public BookView() {
        this.setLayout(new GridLayout(5, 1));

        namePanel = new JPanel(new GridLayout(1, 2));
        pricePanel = new JPanel(new GridLayout(1, 2));
        typePanel = new JPanel(new GridLayout(1, 2));

        nameLabel = new JLabel("Name");
        priceLabel = new JLabel("Price");
        typeLabel = new JLabel("Type");

        nameTextField = new JTextField();
        priceTextField = new JTextField();
        typeComboBox = new JComboBox(typeItems);

        namePanel.add(nameLabel);
        namePanel.add(nameTextField);
        pricePanel.add(priceLabel);
        pricePanel.add(priceTextField);
        typePanel.add(typeLabel);
        typePanel.add(typeComboBox);

        this.add(namePanel);
        this.add(pricePanel);
        this.add(typePanel);

        selectPanel = new JPanel(new FlowLayout());

        previousButton = new JButton("<<<");
        currentObjectTextField = new JTextField("0");
        nextButton = new JButton(">>>");

        selectPanel.add(previousButton);
        selectPanel.add(currentObjectTextField);
        selectPanel.add(nextButton);

        this.add(selectPanel);

        operationPanel = new JPanel(new FlowLayout());

        addButton = new JButton("Add");
        updateButton = new JButton("Update");
        deleteButton = new JButton("Delete");

        operationPanel.add(addButton);
        operationPanel.add(updateButton);
        operationPanel.add(deleteButton);

        this.add(operationPanel);

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pack();
    }
    
    @Override
    public void start() {
        this.setVisible(true);
    }
    
    @Override
    public void callback() {
    }

    @Override
    public void callback(int index, Book book) {
        System.out.println("Callback from BookView");
        
        this.nameTextField.setText(book.getName());
        this.priceTextField.setText(String.valueOf(book.getPrice()));
        this.typeComboBox.setSelectedItem(book.getType());
        this.currentObjectTextField.setText(String.valueOf(index));
    }
}
