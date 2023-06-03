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

        // Create the right panel 
        rightPanel = new JPanel(new GridBagLayout());
        rightPanel.setBackground(Color.white);
        JLabel rightLabel = new JLabel("My Portfolio");
        rightLabel.setFont(new Font("Monospaced", Font.BOLD, 50));

        // Create GridBagConstraints and set desired position
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 0, 10, 0); // top, left, bottom, right
        rightPanel.add(rightLabel, gbc);

        // Create the buttons
        JButton selfBtn = new JButton("Myself");
        selfBtn.addActionListener(new Myself());
        JButton skillsBtn = new JButton("My Skills");
        skillsBtn.addActionListener(new MySkills());
        JButton worksBtn = new JButton("My Works");
        skillsBtn.addActionListener(new MyWorks());

        // Resize the buttons
        Dimension buttonSize = new Dimension(150, 50);
        selfBtn.setPreferredSize(buttonSize);
        skillsBtn.setPreferredSize(buttonSize);
        worksBtn.setPreferredSize(buttonSize);

        // Change the color of the buttons
        Color buttonColor = Color.black;
        selfBtn.setBackground(buttonColor);
        skillsBtn.setBackground(buttonColor);
        worksBtn.setBackground(buttonColor);

        // Change the text color of the buttons
        Color textColor = Color.white;
        selfBtn.setForeground(textColor);
        skillsBtn.setForeground(textColor);
        worksBtn.setForeground(textColor);

        // Change the size of the text in the buttons
        int fontSize = 20; // Adjust the font size as desired
        Font buttonFont = new Font(Font.SANS_SERIF, Font.BOLD, fontSize);
        selfBtn.setFont(buttonFont);
        skillsBtn.setFont(buttonFont);
        worksBtn.setFont(buttonFont);

        // Adjust the location for the buttons
        gbc.gridx = 0;
        gbc.gridy = GridBagConstraints.RELATIVE;
        gbc.insets = new Insets(20, 0, 0, 0);

        rightPanel.add(selfBtn, gbc);
        rightPanel.add(skillsBtn, gbc);
        rightPanel.add(worksBtn, gbc);

        // Create the left panel and set its image background
        leftPanel = new ImagePanel(new ImageIcon("C:\\Users\\Charles\\Downloads\\homepage.jpg").getImage());

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
