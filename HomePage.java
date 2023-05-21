package exam1;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class HomePage extends JFrame {
    private JPanel rightPanel;
    private JPanel leftPanel;

    public HomePage() {
        setTitle("Portfolio");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);

        // Create a GridLayout with 1 row and 2 columns
        setLayout(new GridLayout(1, 2));

        // Create the right panel with GridBagLayout and set its background color to white
        rightPanel = new JPanel(new GridBagLayout());
        rightPanel.setBackground(Color.white);

        JLabel rightLabel = new JLabel("My Portfolio");
        rightLabel.setFont(new Font("Monospaced", Font.BOLD, 50));

        // Create GridBagConstraints and set desired position and padding
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 0, 10, 0); // top, left, bottom, right
        rightPanel.add(rightLabel, gbc);

        // Create the buttons
        JButton button1 = new JButton("Myself");
        button1.addActionListener(new Myself());

        JButton button2 = new JButton("My Skills");
        button2.addActionListener(new MySkills());
        
        JButton button3 = new JButton("My Works");
        button3.addActionListener(new MyWorks());


        // Resize the buttons
        Dimension buttonSize = new Dimension(150, 50); // Adjust the width and height as desired
        button1.setPreferredSize(buttonSize);
        button2.setPreferredSize(buttonSize);
        button3.setPreferredSize(buttonSize);

        // Change the color of the buttons to black
        Color buttonColor = Color.black;
        button1.setBackground(buttonColor);
        button2.setBackground(buttonColor);
        button3.setBackground(buttonColor);

        Color textColor = Color.white;
        button1.setForeground(textColor);
        button2.setForeground(textColor);
        button3.setForeground(textColor);

        // Change the size of the text in the buttons
        int fontSize = 20; // Adjust the font size as desired
        Font buttonFont = new Font(Font.SANS_SERIF, Font.BOLD, fontSize);
        button1.setFont(buttonFont);
        button2.setFont(buttonFont);
        button3.setFont(buttonFont);

        gbc.gridx = 0; // Set the column to 0 for all buttons
        gbc.gridy = GridBagConstraints.RELATIVE; // Use GridBagConstraints.RELATIVE to maintain vertical alignment
        gbc.insets = new Insets(20, 0, 0, 0); // Adjust padding for the buttons

        rightPanel.add(button1, gbc);
        rightPanel.add(button2, gbc);
        rightPanel.add(button3, gbc);

        // Create the left panel and set its image background
        leftPanel = new ImagePanel(new ImageIcon("C:\\Users\\Charles\\Downloads\\download.jpg").getImage());

        // Add the panels to the frame
        add(leftPanel);
        add(rightPanel);
    }

    private static class ImagePanel extends JPanel {
        private Image backgroundImage;

        public ImagePanel(Image backgroundImage) {
            this.backgroundImage = backgroundImage;
            setPreferredSize(new Dimension(backgroundImage.getWidth(null), backgroundImage.getHeight(null)));
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), null);
        }
    }
}
