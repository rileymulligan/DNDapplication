package Frames;

import java.util.Arrays;
import javax.swing.JDesktopPane;
import javax.swing.JEditorPane;
import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.text.JTextComponent;

public interface Extendable {
    /**

    Creates a new internal frame and adds it to the specified desktop pane with the given text component.

    @param textComponent the text component to display in the internal frame

    @param desktopPane the desktop pane to which the internal frame will be added
    */
    
    default void createNewInternalFrame(JTextComponent textComponent, JDesktopPane desktopPane) {
        System.out.println("Debug1");

        // Create a new JInternalFrame object with the given properties
        JInternalFrame internalFrame = new JInternalFrame("Extended Pane", true, true, true, true);
        internalFrame.setSize(400, 400);
        internalFrame.setLocation(50, 50);

        // Wrap the text component in a JScrollPane and add it to the internal frame
        JScrollPane scrollPane = new JScrollPane(textComponent);
        internalFrame.setResizable(true);
        internalFrame.getContentPane().add(scrollPane);

        // Set the internal frame to be visible and in front
        internalFrame.setVisible(true);
        internalFrame.toFront();

        // Add the internal frame to the specified desktop pane
        desktopPane.add(internalFrame);

        // Print the list of all internal frames in the desktop pane for debugging purposes
        System.out.println(Arrays.toString(desktopPane.getAllFrames()));
    }
    
    /**
    Creates a new internal frame with a JEditorPane component containing HTML content.
    The internal frame is added to the specified JDesktopPane.
    @param textComponent the JEditorPane component containing the HTML content
    @param desktopPane the JDesktopPane to which the internal frame will be added
    */
    default void createNewInternalFrameHTML(JEditorPane textComponent, JDesktopPane desktopPane) {
        System.out.println("Debug2");
        JInternalFrame internalFrame = new JInternalFrame("Extended Pane", true, true, true, true);
        internalFrame.setSize(400, 400);
        internalFrame.setLocation(50, 50);
        JScrollPane scrollPane = new JScrollPane(textComponent);

        // Set the content type of the JEditorPane to HTML and disable editing
        textComponent.setContentType("text/html");
        textComponent.setEditable(false);

        internalFrame.setResizable(true);
        internalFrame.getContentPane().add(scrollPane);
        internalFrame.setVisible(true);

        desktopPane.add(internalFrame); // add the internal frame to the desktop pane
}
}
