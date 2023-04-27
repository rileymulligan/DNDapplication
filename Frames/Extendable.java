package Frames;

import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

public interface Extendable {
    default void createNewInternalFrame(JTextPane textPane, JDesktopPane desktopPane) {
        JInternalFrame internalFrame = new JInternalFrame("Extended Text Pane", true, true, true, true);
        internalFrame.setSize(400, 400);
        internalFrame.setLocation(50, 50);
        JScrollPane scrollPane = new JScrollPane(textPane);
        internalFrame.setResizable(true);
        internalFrame.getContentPane().add(scrollPane);
        internalFrame.setVisible(true);
        desktopPane.add(internalFrame);
    }
}