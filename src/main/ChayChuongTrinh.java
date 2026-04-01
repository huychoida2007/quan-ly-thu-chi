package main;

import view.GiaoDienChinh;
import javax.swing.SwingUtilities;

public class ChayChuongTrinh {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            GiaoDienChinh ungDung = new GiaoDienChinh();
            ungDung.setVisible(true);
        });
    }
}