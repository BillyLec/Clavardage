import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Container;
public class ManageConversation extends JPanel implements ActionListener{
    private final JTextField editMessage;
    private final JTextArea writeMessage = null;
    private final static String newline = "\n";



    public ManageConversation( ) {
        super( Boolean.parseBoolean( "ManageConversation.java" ) );


        writeMessage.setEnabled(false);
        editMessage = new JTextField("");
        JButton sendButton = new JButton("Enviar");


        JPanel panel = new JPanel(new BorderLayout());
        JPanel chatPanel = new JPanel(new BorderLayout());
        JPanel chatWindowPanel = new JPanel();
        chatWindowPanel.setLayout(new BoxLayout(chatWindowPanel, BoxLayout.Y_AXIS));
        JPanel editMessagePanel = new JPanel();
        JTextArea writeMessage = new JTextArea("Enter message here");
        JButton sendMessage = new JButton("Send");



        JTextField editMessage1;

        editMessage1 = new JTextField(20);
        editMessage1.addActionListener(this);

        editMessage1 = new JTextField();
        editMessage = editMessage1;
        JScrollPane scrollPane = new JScrollPane(writeMessage);

        //Add Components to this panel.
        GridBagConstraints c = new GridBagConstraints();
        c.gridwidth = GridBagConstraints.REMAINDER;

        c.fill = GridBagConstraints.HORIZONTAL;
        add(editMessage, c);

        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1.0;
        c.weighty = 1.0;
        add(scrollPane, c);



        editMessagePanel.add(writeMessage);
        editMessagePanel.add(sendMessage);

        editMessagePanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        chatPanel.add(chatWindowPanel, BorderLayout.CENTER);
        chatPanel.add(editMessagePanel, BorderLayout.PAGE_END);

        panel.add(chatPanel);
        panel.repaint();

        sendButton = new JButton();
    }
    public void actionPerformed(ActionEvent evt) {
        String text = editMessage.getText();
        writeMessage.append(text + newline);
        editMessage.selectAll();

        //Make sure the new text is visible, even if there
        //was a selection in the text area.
        writeMessage.setCaretPosition(writeMessage.getDocument().getLength());

    /**
          * Create the GUI and show it.  For thread safety,
          * this method should be invoked from the
          * event dispatch thread.
          */
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("TextDemo");
        frame.setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE );

        //Add contents to the window.
        frame.add(new ManageConversation());

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        //Schedule a job for the event dispatch thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater( () -> createAndShowGUI() );
    }
}