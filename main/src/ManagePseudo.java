import java.util.Scanner;


public class ManagePseudo {

    private String AncienPseudo;

    public void ManagePseudo(){

        boolean exit = false;
        String pseudo;
        boolean existe;

        while (exit = false){


            System.out.print("What is your pseudo ? "); //Demande pseudo
            String message = readLine(); //Ecrire Pseudo

            //***** Fonction verification unicite *****
            // existe = true;

            if (existe = false){
                //***** enregistrer pseudo dans la base de données *****
                exit = true;
            } else {
                System.out.print("Pseudo already exist, choose another ! ");
            }
        }
    }

    public void ModifierPseudo(){
        ManagePseudo();
        //****** if (clique sur cancel)*****
        //****** break *****
        //****** else *****
        DeletePseudo(AncienPseudo);
    }

    public void DeletePseudo(String Pseudo){
        //chercher dans la base de donnée, l'ancien pseudo
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
