package view;

import controller.ProductController;
import model.Product;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class ProductViewOnly extends JFrame {

    JTable table = new JTable();
    DefaultTableModel model;
    JButton btnAlerts = new JButton("View Low Stock Alerts");
    ProductController controller = new ProductController();

    public ProductViewOnly() {
        setTitle("Product Management");
        setSize(750, 600);
        setLayout(null);

        JLabel lblTitle = new JLabel("Product Management");
        lblTitle.setBounds(20, 20, 400, 30);
        lblTitle.setFont(new Font("SansSerif", Font.BOLD, 24));
        add(lblTitle);

        JPanel tablePanel = new JPanel(null);
        tablePanel.setBounds(20, 70, 710, 430);
        tablePanel.setBorder(BorderFactory.createTitledBorder("Product List"));
        add(tablePanel);

        model = new DefaultTableModel(
                new String[]{"ID", "Name", "Category", "Price", "Qty"}, 0
        );
        table.setModel(model);
        table.setRowHeight(25);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        table.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        table.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
        table.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);

        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(10, 25, 690, 345);
        tablePanel.add(sp);

        JPanel bottomPanel = new JPanel(null);
        bottomPanel.setBounds(20, 500, 710, 50);
        add(bottomPanel);

        btnAlerts.setBounds(150, 10, 200, 35);
        JButton btnBack = new JButton("Back");
        btnBack.setBounds(360, 10, 120, 35);

        bottomPanel.add(btnAlerts);
        bottomPanel.add(btnBack);

        btnAlerts.addActionListener(e -> showLowStockAlerts());

        btnBack.addActionListener(e -> this.dispose());

        loadProducts();

        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    private void loadProducts() {
        model.setRowCount(0);
        ArrayList<Product> list = controller.getProducts();
        for (Product p : list) {
            model.addRow(new Object[]{
                p.getId(),
                p.getName(),
                p.getCategory(),
                p.getPrice(),
                p.getQuantity()
            });
        }
    }

    private void showLowStockAlerts() {
        ArrayList<Product> lowStock = controller.getLowStockProducts();
        if (lowStock.isEmpty()) {
            JOptionPane.showMessageDialog(
                    this,
                    "All stock levels are sufficient...",
                    "Stock Status",
                    JOptionPane.INFORMATION_MESSAGE
            );
        } else {
            StringBuilder msg = new StringBuilder("LOW STOCK ITEMS:\n\n");
            for (Product p : lowStock) {
                msg.append(p.getName())
                        .append(" (Qty: ")
                        .append(p.getQuantity())
                        .append(")\n");
            }

            JOptionPane.showMessageDialog(
                    this,
                    msg.toString(),
                    "Restock Alert",
                    JOptionPane.WARNING_MESSAGE
            );
        }
    }
}
