package exam1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Myself implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        // Action to perform when the button is clicked
        JFrame frame = createFrame("Myself", 800, 600);

        JPanel contentPane = createPanel(frame.getSize(), new BorderLayout());

        // Load the image and resize it to fit the panel
        ImageIcon imageIcon = new ImageIcon("C:\\Users\\Charles\\Downloads\\MYSELF.png");
        Image image = imageIcon.getImage().getScaledInstance(contentPane.getWidth(), contentPane.getHeight(),
                Image.SCALE_SMOOTH);
        ImageIcon resizedImageIcon = new ImageIcon(image);

        // Create a label with the resized image
        JLabel imageLabel = new JLabel(resizedImageIcon);
        contentPane.add(imageLabel, BorderLayout.CENTER);

        // Create the back button
        JButton backButton = createBackButton();
        // Create the next button
        JButton nextButton = createNextButton();

        // Create the button panel and add the buttons
        JPanel buttonPanel = createButtonPanel(backButton, nextButton);

        // Add the button panel to the content pane at the top
        contentPane.add(buttonPanel, BorderLayout.NORTH);

        frame.setContentPane(contentPane);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    protected JFrame createFrame(String title, int width, int height) {
        JFrame frame = new JFrame(title);
        frame.setSize(width, height);
        return frame;
    }

    protected JPanel createPanel(Dimension size, LayoutManager layout) {
        JPanel panel = new JPanel(layout);
        panel.setSize(size);
        return panel;
    }

    protected JButton createBackButton() {
        JButton backButton = new JButton("X");
        Color bback1 = Color.red;
        backButton.setBackground(bback1);
        Color tback1 = Color.white;
        backButton.setForeground(tback1);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Logic to go back to the home page
                HomePage homePage = new HomePage();
                JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor(backButton);
                currentFrame.dispose(); // Close the current frame
                homePage.setVisible(true); // Open the home page frame
            }
        });
        return backButton;
    }

    protected JButton createNextButton() {
        JButton nextButton = new JButton(">");
        Color bnext1 = Color.green;
        nextButton.setBackground(bnext1);
        Color tnext1 = Color.white;
        nextButton.setForeground(tnext1);
        nextButton.addActionListener(new MySkills());
        return nextButton;
    }

    protected JPanel createButtonPanel(JButton backButton, JButton nextButton) {
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.white);
        buttonPanel.setLayout(new BorderLayout());
        buttonPanel.add(backButton, BorderLayout.WEST);
        buttonPanel.add(nextButton, BorderLayout.EAST);
        return buttonPanel;
    }
}
