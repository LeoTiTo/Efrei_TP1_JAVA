/*
 * Nom : Huu Loc TRAN
 * Formation : Ing1-Apprenti
 * Groupe : BDML 1
 * Enseignante : Madame Georgina ABI SEJAAN
 * Role : calculatrice en console avec verification de l'operateur
 * Date : A COMPLETER
 */
package calculator;

import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Affichage du menu
        System.out.println("Please enter the operator:");
        System.out.println("1) add");
        System.out.println("2) subtract");
        System.out.println("3) multiply");
        System.out.println("4) divide");
        System.out.println("5) modulo");

        // Lecture du choix
        int operateur = sc.nextInt();

        // Bonus : verifier le choix AVANT de demander les nombres
        if (operateur < 1 || operateur > 5) {
            System.out.println(
                "Erreur : choisissez un operateur entre 1 et 5."
            );
            return;
        }

        // Lecture des deux nombres
        System.out.println("Entrer le premier nombre :");
        int operande1 = sc.nextInt();

        System.out.println("Entrer le deuxieme nombre :");
        int operande2 = sc.nextInt();

        float resultat;
        String nomOperateur;

        // Choix du calcul
        switch (operateur) {
            case 1:
                nomOperateur = "Addition";
                resultat = operande1 + operande2;
                break;

            case 2:
                nomOperateur = "Soustraction";
                resultat = operande1 - operande2;
                break;

            case 3:
                nomOperateur = "Multiplication";
                resultat = operande1 * operande2;
                break;

            case 4:
                nomOperateur = "Division";

                if (operande2 == 0) {
                    System.out.println(
                        "Erreur : division par zero impossible."
                    );
                    return;
                }

                resultat = (float) operande1 / operande2;
                break;

            case 5:
                nomOperateur = "Modulo";

                if (operande2 == 0) {
                    System.out.println(
                        "Erreur : modulo par zero impossible."
                    );
                    return;
                }

                resultat = operande1 % operande2;
                break;

            default:
                System.out.println("Erreur : operateur invalide.");
                return;
        }

        // Affichage du resultat
        System.out.println("Operation choisie : " + nomOperateur);
        System.out.println("Le resultat est : " + resultat);
    }
}