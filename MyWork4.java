package exam1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class MyWork4 extends Myself {
    @Override
    public void actionPerformed(ActionEvent e) {
        // Custom image path for MyWorks class
        ImageIcon imageIcon = new ImageIcon("C:\\Users\\Charles\\Downloads\\mywork4.jpg");

        // Call the desired methods inherited from the superclass to utilize their functionality
        JFrame frame = createFrame("MyWorks", 800, 600);
        JPanel contentPane = createPanel(frame.getSize(), new BorderLayout());
        JLabel imageLabel = createImageLabel(imageIcon, contentPane.getSize());
        JButton backButton = createBackButton();
        JPanel buttonPanel = createButtonPanel(backButton);

        contentPane.add(imageLabel, BorderLayout.CENTER);
        contentPane.add(buttonPanel, BorderLayout.NORTH);

        frame.setContentPane(contentPane);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private JLabel createImageLabel(ImageIcon imageIcon, Dimension panelSize) {
        Image image = imageIcon.getImage().getScaledInstance(panelSize.width, panelSize.height, Image.SCALE_SMOOTH);
        ImageIcon resizedImageIcon = new ImageIcon(image);
        return new JLabel(resizedImageIcon);
    }

    protected JPanel createButtonPanel(JButton button) {
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.black);
        buttonPanel.setLayout(new BorderLayout());
        buttonPanel.add(button, BorderLayout.EAST);
        return buttonPanel;
    }
}
