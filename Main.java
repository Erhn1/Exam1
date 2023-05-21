package exam1;

import javax.swing.SwingUtilities;

public class Main {

  public static void main(String[] args) {
        // Ensures that the initialization code is executed on the event dispatch thread
        SwingUtilities.invokeLater(() -> {
            // Create an instance of the HomePage class
            HomePage homePage = new HomePage();
            
            // Set the visibility of the homePage to true, making it visible to the user
            homePage.setVisible(true);
        });
    }
}
