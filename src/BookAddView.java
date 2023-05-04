
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
public class BookAddView extends JFrame implements Viewable {

    private final String[] typeItems = {
        "General", "Computer", "Math&Sci", "Photo3"
    };

    public JPanel namePanel, pricePanel, typePanel;
    public JLabel nameLabel, priceLabel, typeLabel;
    public JTextField nameTextField, priceTextField;
    public JComboBox typeComboBox;

    public JPanel insertPanel;
    public JButton insertButton;

    public BookAddView() {
        this.setLayout(new GridLayout(4, 1));

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

        insertPanel = new JPanel(new FlowLayout());
        insertButton = new JButton("Insert");

        insertPanel.add(insertButton);

        this.add(insertPanel);

        this.pack();
    }

    @Override
    public void callback() {
    }

    @Override
    public void callback(int index, Book book) {
    }

    @Override
    public void start() {
        this.setVisible(true);
    }
}
