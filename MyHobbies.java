package exam1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MyHobbies extends Myself {
    @Override
    public void actionPerformed(ActionEvent e) {
        // Custom image for MyHobbies class
        ImageIcon imageIcon = new ImageIcon("C:\\Users\\Charles\\Downloads\\3.jpg");

        // Inherit methods from the superclass
        JFrame frame = createFrame("MyEducation", 800, 600);
        JPanel contentPane = createPanel(frame.getSize(), new BorderLayout());
        JLabel imageLabel = createImageLabel(imageIcon, contentPane.getSize());
        JButton backButton = createBackButton();
        JButton nextButton = createNextButton();
        JPanel buttonPanel = createButtonPanel(backButton, nextButton);

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

    // Override the fuction of the next button
    @Override
    protected JButton createNextButton() {
        JButton nextButton = new JButton(">"); // Provide your custom button label
        nextButton.setBackground(Color.black);
        nextButton.setForeground(Color.white);
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Call the actionPerformed method of the MyWorks class directly
                MySkills mySkills = new MySkills();
                mySkills.actionPerformed(e);
            }
        });
        return nextButton;
    }
}
