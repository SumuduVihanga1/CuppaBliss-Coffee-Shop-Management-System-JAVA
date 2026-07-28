package view;

import javax.swing.*;
import controller.ProductController;
import java.awt.*;
import model.Product;
import java.util.ArrayList;

public class DashboardBarista extends JFrame {

    public DashboardBarista() {
        setTitle("Barista Dashboard");
        setSize(500, 320);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel title = new JLabel("Barista Dashboard");
        title.setFont(new Font("SansSerif", Font.BOLD, 24));
        title.setBounds(160, 25, 250, 30);

        JButton btnStock = new JButton("View Restock Alerts");
        JButton btnProducts = new JButton("Product List");
        JButton btnBack = new JButton("Back");

        btnStock.setBounds(140, 90, 220, 40);
        btnProducts.setBounds(140, 145, 220, 40);
        btnBack.setBounds(140, 200, 220, 40);

        panel.add(title);
        panel.add(btnStock);
        panel.add(btnProducts);
        panel.add(btnBack);

        add(panel);

        btnStock.addActionListener(e -> {
            ProductController controller = new ProductController();
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
        });

        btnProducts.addActionListener(e -> new ProductView());
        btnBack.addActionListener(e -> this.dispose());

        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent e) {
                new LoginForm().setVisible(true);
            }
        });
    }
}
