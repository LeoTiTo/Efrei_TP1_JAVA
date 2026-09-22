/*
 * Nom : Huu Loc TRAN
 * Formation : Ing1-Apprenti
 * Groupe : BDML 1
 * Enseignante : Madame Georgina ABI SEJAAN
 * Role : calculatrice en console avec verification de l'operateur
 * Date : A COMPLETER
 */
package exo2;

import java.util.Scanner;

public class Exo2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Declaration des variables
        int nb; // nombre d'entiers à additionner
        int result; // resultat
        int ind; // indice
        
        // Saisie du nombre
        Scanner sc = new Scanner(System.in);
        System.out.println("Entrer le nombre: ");
        nb = sc.nextInt();
        
        // Init du calcul
        result=0;
        ind=1;
        
        // Addition des nb premiers entiers
        while (ind <= nb) {
            result = result + ind;
            ind ++;
        }
        
        // Affichage du resultat
        System.out.println();
        System.out.println("La somme des "+ nb + " entiers est: " + result);
    }
    
}
