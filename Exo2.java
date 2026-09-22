/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package exo2;

import java.util.Scanner;

/**
 *
 * @author lochu
 */
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
