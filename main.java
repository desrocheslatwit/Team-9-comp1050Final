import javax.swing.SwingUtilities;

public class Main {

    public static void main(String[] args) {
        // Launch the GUI application in the Swing event-dispatching thread
        SwingUtilities.invokeLater(() -> {
            Gui gui = new Gui(); // Create the GUI instance
            gui.setVisible(true); // Make the GUI visible
        });
    }
}
