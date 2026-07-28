package view;

import controller.ProductController;
import model.Product;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ProductView extends JFrame {

    JTextField txtName = new JTextField();
    JTextField txtPrice = new JTextField();
    JTextField txtQty = new JTextField();
    JTextField txtSearch = new JTextField();

    JComboBox<String> cmbCategory = new JComboBox<>(
            new String[]{"Coffee", "Tea", "Pastries", "Snacks"}
    );

    JButton btnAdd = new JButton("Add");
    JButton btnUpdate = new JButton("Update");
    JButton btnDelete = new JButton("Delete");
    JButton btnSearch = new JButton("Search");
    JButton btnBack = new JButton("Back");

    JTable table = new JTable();
    DefaultTableModel model;

    ProductController controller = new ProductController();

    public ProductView() {
        setTitle("Product Management");
        setSize(1000, 650);
        setResizable(false);
        setLayout(null);

        JLabel lblTitle = new JLabel("Product Management");
        lblTitle.setBounds(20, 20, 400, 30);
        lblTitle.setFont(new Font("SansSerif", Font.BOLD, 24));
        add(lblTitle);

        JLabel lblSearch = new JLabel("Search Product:");
        lblSearch.setBounds(500, 60, 110, 25);
        add(lblSearch);

        txtSearch.setBounds(630, 60, 220, 28);
        add(txtSearch);

        btnSearch.setBounds(860, 60, 100, 28);
        add(btnSearch);

        int formX = 30;
        int fieldWidth = 290;

        addLabel("Name", formX, 120);
        txtName.setBounds(formX, 145, fieldWidth, 28);
        add(txtName);

        addLabel("Category", formX, 180);
        cmbCategory.setBounds(formX, 205, fieldWidth, 28);
        add(cmbCategory);

        addLabel("Price", formX, 240);
        txtPrice.setBounds(formX, 265, fieldWidth, 28);
        add(txtPrice);

        addLabel("Quantity", formX, 300);
        txtQty.setBounds(formX, 325, fieldWidth, 28);
        add(txtQty);

        btnAdd.setBounds(formX, 370, 90, 32);
        btnUpdate.setBounds(formX + 100, 370, 90, 32);
        btnDelete.setBounds(formX + 200, 370, 90, 32);
        btnBack.setBounds(formX + 40, 530, 200, 32);

        add(btnAdd);
        add(btnUpdate);
        add(btnDelete);
        add(btnBack);
        
        JPanel tablePanel = new JPanel(null);
        tablePanel.setBounds(360, 120, 610, 450);
        tablePanel.setBorder(BorderFactory.createTitledBorder("Product List"));

        model = new DefaultTableModel(
                new String[]{"ID", "Name", "Category", "Price", "Qty"}, 0
        );
        table.setModel(model);
        table.setRowHeight(26);

        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(10, 25, 590, 415);
        tablePanel.add(sp);

        add(tablePanel);

        btnAdd.addActionListener(e -> addProduct());
        btnUpdate.addActionListener(e -> updateProduct());
        btnDelete.addActionListener(e -> deleteProduct());
        btnSearch.addActionListener(e -> searchProduct());
        btnBack.addActionListener(e -> this.dispose());  

        table.getSelectionModel().addListSelectionListener(e -> populateFields());

        loadProducts();

        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    private void addLabel(String text, int x, int y) {
        JLabel lbl = new JLabel(text);
        lbl.setBounds(x, y, 120, 25);
        add(lbl);
    }

    private void addProduct() {
        Product p = new Product(
                txtName.getText(),
                cmbCategory.getSelectedItem().toString(),
                Double.parseDouble(txtPrice.getText()),
                Integer.parseInt(txtQty.getText())
        );
        controller.addProduct(p);
        loadProducts();
        clearFields();
    }

    private void loadProducts() {
        model.setRowCount(0);
        for (Product p : controller.getProducts()) {
            model.addRow(new Object[]{
                    p.getId(),
                    p.getName(),
                    p.getCategory(),
                    p.getPrice(),
                    p.getQuantity()
            });
        }
    }

    private void searchProduct() {
        model.setRowCount(0);
        for (Product p : controller.search(txtSearch.getText())) {
            model.addRow(new Object[]{
                    p.getId(),
                    p.getName(),
                    p.getCategory(),
                    p.getPrice(),
                    p.getQuantity()
            });
        }
    }

    private void updateProduct() {
        int row = table.getSelectedRow();
        if (row == -1) return;

        int id = (int) model.getValueAt(row, 0);
        Product p = new Product(
                id,
                txtName.getText(),
                cmbCategory.getSelectedItem().toString(),
                Double.parseDouble(txtPrice.getText()),
                Integer.parseInt(txtQty.getText())
        );
        controller.updateProduct(p);
        loadProducts();
        clearFields();
    }

    private void deleteProduct() {
        int row = table.getSelectedRow();
        if (row == -1) return;

        int id = (int) model.getValueAt(row, 0);
        controller.deleteProduct(id);
        loadProducts();
        clearFields();
    }

    private void populateFields() {
        int row = table.getSelectedRow();
        if (row != -1) {
            txtName.setText(model.getValueAt(row, 1).toString());
            cmbCategory.setSelectedItem(model.getValueAt(row, 2).toString());
            txtPrice.setText(model.getValueAt(row, 3).toString());
            txtQty.setText(model.getValueAt(row, 4).toString());
        }
    }

    private void clearFields() {
        txtName.setText("");
        txtPrice.setText("");
        txtQty.setText("");
        cmbCategory.setSelectedIndex(0);
    }
}
