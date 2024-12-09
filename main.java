public class Main {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            Gui gui = new Gui();
            gui.setVisible(true);
        });
    }
}
