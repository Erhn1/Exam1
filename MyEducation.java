package exam1;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyEducation extends Myself {
    @Override
    public void actionPerformed(ActionEvent e) {
        // Custom image for MyEducation class
        ImageIcon imageIcon = new ImageIcon("C:\\Users\\Charles\\Downloads\\2.jpg");

        // Inherit methods from the superclass
        JFrame frame = createFrame("MyEducation", 800, 600);
        JPanel contentPane = createPanel(frame.getSize(), new BorderLayout());
        JLabel imageLabel = createImageLabel(imageIcon, contentPane.getSize());
        JButton backButton = createBackButton();
        JButton nextButton = createNextButton();
        JPanel buttonPanel = createButtonPanel(backButton, nextButton);
        
        // Add the image and button panel to the frame
        contentPane.add(imageLabel, BorderLayout.CENTER);
        contentPane.add(buttonPanel, BorderLayout.NORTH);

        // Frame components and functions
        frame.setContentPane(contentPane);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    // Display the new image
    private JLabel createImageLabel(ImageIcon imageIcon, Dimension panelSize) {
        Image image = imageIcon.getImage().getScaledInstance(panelSize.width, panelSize.height, Image.SCALE_SMOOTH);
        ImageIcon resizedImageIcon = new ImageIcon(image);
        return new JLabel(resizedImageIcon);
    }

    // Override the fuction of the next button
    @Override
    protected JButton createNextButton() {
        JButton nextButton = new JButton(">");
        nextButton.setBackground(Color.black);
        nextButton.setForeground(Color.white);
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MyHobbies myHobbies = new MyHobbies();
                myHobbies.actionPerformed(e);
            }
        });
        return nextButton;
    }
}
