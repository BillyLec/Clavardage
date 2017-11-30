import java.util.Scanner;


public class ManagePseudo {

    public void ManagePseudo(){

        boolean exit = false;
        String pseudo;
        boolean existe;

        while (exit = false){


            System.out.print("What is your pseudo ? "); //Demande pseudo
            String message = readLine(); //Ecrire Pseudo

            //Fonction verification unicite

            if (existe = false){
                exit = true;
            } else {
                System.out.print("Pseudo already exist, choose another ! ");
            }
        }
    }

    //SCANF
    public String readLine() { return getScanner().nextLine();}
    private static Scanner getScanner() { return new Scanner(System.in);}

}

// Dans cette classe, il faut creer un pseudo et une fonction qui permet de le modifier ensuite.
// 1. Demande de pseudo
// 2. Ecrire pseudo
// 3. Entrer pseudo et verifier l'unicité
// 4. Accepte ou denied
// 5. Si dienied, recommencer
// 6. Si accepte, close
