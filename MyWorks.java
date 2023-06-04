package exam1;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyWorks extends Myself {
    private String[] imagePaths = {
        "C:\\Users\\Charles\\Downloads\\5.jpg",
        "C:\\Users\\Charles\\Downloads\\6.jpg",
        "C:\\Users\\Charles\\Downloads\\7.jpg",
        "C:\\Users\\Charles\\Downloads\\8.jpg"
    };

    private int currentImageIndex = 0;
    private JButton backButton;
    private JButton nextButton;

    @Override
    public void actionPerformed(ActionEvent e) {
        ImageIcon imageIcon = new ImageIcon(imagePaths[currentImageIndex]);

        JFrame frame = createFrame("MyWorks", 800, 600);
        JPanel contentPane = createPanel(frame.getSize(), new BorderLayout());
        JLabel imageLabel = createImageLabel(imageIcon, contentPane.getSize());
        nextButton = createNextButton();
        backButton = createBackButton();
        JPanel buttonPanel = createButtonPanel(backButton, nextButton);

        contentPane.add(imageLabel, BorderLayout.CENTER);
        contentPane.add(buttonPanel, BorderLayout.NORTH);

        frame.setContentPane(contentPane);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        
        stopButton();
    }

    private JLabel createImageLabel(ImageIcon imageIcon, Dimension panelSize) {
        Image image = imageIcon.getImage().getScaledInstance(panelSize.width, panelSize.height, Image.SCALE_SMOOTH);
        ImageIcon resizedImageIcon = new ImageIcon(image);
        return new JLabel(resizedImageIcon);
    }

    @Override
    protected JButton createNextButton() {
        nextButton = new JButton(">");
        nextButton.setBackground(Color.BLACK);
        nextButton.setForeground(Color.WHITE);
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentImageIndex++;
                stopButton();
                MyWorks.this.actionPerformed(e);
            }
        });
        return nextButton;
    }

    @Override
    protected JButton createBackButton() {
        JButton backButton = new JButton("<");
        backButton.setBackground(Color.BLACK);
        backButton.setForeground(Color.WHITE);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(backButton);
                frame.dispose();
            }
        });
        return backButton;
    }

    private void stopButton() {
        int imageCount = imagePaths.length;
        if (currentImageIndex == imageCount - 1) {
            nextButton.setEnabled(false);
        } else {
            nextButton.setEnabled(true);
        }
    }
}
