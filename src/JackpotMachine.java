import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;  

public class JackpotMachine {

private int jeton;
private boolean paiementOK;




public JackpotMachine(int jeton){
 this.jeton = jeton;
 paiementOK=false;
} 
public int getJeton(){
    return jeton;
}

public  String insererJeton(){
    String message="";
    if(!paiementOK && jeton>0){
        jeton--;
        paiementOK=true;
        message ="Vous venez d'insérer un jeton.";
    }else if (!paiementOK && jeton ==0 ){
        message ="vous n'avez plus de jeton";
    }else if(paiementOK){
        message ="vous avez déja inséré un jeton";
    }
    return message;
}

public  String actionnerManette(){
    String message="";
    if(paiementOK){
        message = afficherRouleaux();
        paiementOK=false;
    }else {
        message = "vous devez insérer un jeton";
    }
    return message;
}
private String afficherRouleaux(){
    Random generateur = new Random(); 
    int a = generateur.nextInt(10);
    int b = generateur.nextInt(10);
    int c = generateur.nextInt(10);
    int d = generateur.nextInt(10);

    int []rouleaux = new int[]{a,b,c,d};
    
    


    String message = "Rouleaux : ";
    int i;
    for (i = 0; i < rouleaux.length; i++){
        if (i==rouleaux.length-1){
            message += rouleaux[i];
        }else {
            message += rouleaux[i] + " - "; 
    } 
        }
         
    
    // String message = "Rouleaux : " + Integer.toString(a) +" - "+ Integer.toString(b)+" - " + Integer.toString(c) +" - "+Integer.toString(d);
    return message;
}

public void run(){    
    Scanner scanner = new Scanner(System.in);
    boolean stop = false;
    System.out.println("-------------------------------------------");
    System.out.println("---- Bienvenue sur la JackpotMachine ! ----");
    System.out.println("-------------------------------------------\n");
    String action;
    while (!stop){
    
        System.out.println("j : mettre un jeton, m : actionner la manette, q : quitter");
        System.out.println("Il vous reste "+getJeton()+ " jetons.\n");
    
        System.out.print("Action : ");
         action = scanner.nextLine();
                
        if (action.equals("j")){
            System.out.println(insererJeton());
        }
        else if (action.equals("m")){
            System.out.println(actionnerManette());
            
        }
        else if (action.equals("q")){
            stop = true;
        }
        System.out.println();
    }

    scanner.close();
  }      
}

