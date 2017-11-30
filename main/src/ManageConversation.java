

public class ManageConversation {

    public void InitConversation(){

        //Do click in a textArea:
        textField.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                textField.setText("");
            }
        });

    }

}
