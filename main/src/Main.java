import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        // Creating instance of JFrame
        JFrame frame = new JFrame("Clavardage");
        // Setting the width and height of frame
        frame.setSize(700, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Changer pseudo");
        menuBar.add(menu);
        
        JPanel panel = new JPanel(new BorderLayout());
        JPanel panelMenu = new JPanel();
        JPanel content = new JPanel(new BorderLayout());
    
    
        placeComponents(content);
        panelMenu.add(menuBar);
        panel.add(panelMenu, BorderLayout.PAGE_START);
        panel.add(content, BorderLayout.CENTER);
        
        frame.add(panel);
        
        frame.setVisible(true);
    }
    
    private static void placeComponents(JPanel panel) {
        //Init components
        int nbUsers = 20 ;
        
        JTextArea user1 = new JTextArea("coucou");
        
        JPanel listUser = new JPanel();
        listUser.setLayout(new BoxLayout(listUser, BoxLayout.Y_AXIS));
        listUser.setBackground(Color.gray);
        listUser.add(user1);
        panel.add(listUser, BorderLayout.LINE_START);
        
        JPanel chatPanel = new JPanel(new BorderLayout());
        JPanel chatWindowPanel = new JPanel();
        chatWindowPanel.setLayout(new BoxLayout(chatWindowPanel, BoxLayout.Y_AXIS));
        JPanel editMessagePanel = new JPanel();
        JTextArea writeMessage = new JTextArea("Enter message here");
        JButton sendMessage = new JButton("Send");
        
        editMessagePanel.add(writeMessage);
        editMessagePanel.add(sendMessage);
    
        editMessagePanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        
        chatPanel.add(chatWindowPanel, BorderLayout.CENTER);
        chatPanel.add(editMessagePanel, BorderLayout.PAGE_END);
        
        chatPanel.setOpaque(true);
        chatPanel.setBackground(Color.RED);
        
        panel.add(chatPanel);
        panel.repaint();
    }
}
