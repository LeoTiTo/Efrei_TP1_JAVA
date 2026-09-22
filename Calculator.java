/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package calculator;

import java.util.Scanner;

/**
 *
 * @author lochu
 */
public class Calculator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // AFfichange du menu
        System.out.println("Please enter the operator:");
        System.out.println("1) add");
        System.out.println("2) substract");
        System.out.println("3) multiply");
        System.out.println("4) divide");
        System.out.println("5) modulo");
        
        
        // Lecture du choix
        int operateur = sc.nextInt();
        
        
        // Lecture des deux nombres
        System.out.println("Entrer le 1er nombre:");
        int operande1 = sc.nextInt();

        System.out.println("Entrer le 2eme nombre:");
        int operande2 = sc.nextInt();
        
        // Verification temporaire des saisies
        System.out.println("Operateur choisi : " + operateur);
        System.out.println("Premier nombre : " + operande1);
        System.out.println("Deuxieme nombre : " + operande2);
        
        float resultat;
        
        switch (operateur) {
            case 1:
                resultat = operande1 + operande2;
                break;
                
            case 2:
                resultat = operande1 - operande2;
                break;
                
            case 3:
                resultat = operande1 * operande2;
                break;
                
            case 4:
                if (operande2 == 0) {
                    System.out.println("Erreur: division par 0 impossible");
                    return;
                }
                
                resultat = (float) operande1 / operande2;
                break;
                
            case 5:
                if (operande2 == 0) {
                    System.out.println("Erreur : modulo par 0 impossible");
                }
                resultat = operande1 % operande2;
                break;
                
            default:
                System.out.println("Erreur : operateur invalide.");
                return;
        }
        
        System.out.println("Le resultat est :" + resultat);
    }
    
}
