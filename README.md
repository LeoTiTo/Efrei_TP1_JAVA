# Rapport de TP0 : prise en main de NetBeans et programmation Java

**Étudiant :** Huu Loc TRAN  
**Formation :** Ing1-Apprenti  
**Groupe :** BDML 1  
**Enseignante :** Madame Georgina ABI SEJAAN  
**Matière :** Java, programmation orientée objet  
**Date :** 22 septembre 2026

## 1. Objectifs et organisation du travail

Ce TP avait pour objectif de découvrir l’environnement NetBeans et les bases nécessaires à la réalisation d’un programme Java. Le travail présenté dans ce rapport porte sur trois parties : l’affichage d’un message personnalisé, l’addition des premiers entiers et la réalisation d’une calculatrice en console.

J’ai organisé ces exercices dans des projets distincts : `Exo1`, `Exo2` et `Calculator`. Pour chaque programme, la démarche consistait à écrire le code dans la méthode `main`, compiler le projet, l’exécuter, puis comparer l’affichage obtenu au résultat attendu. Cette progression permet de vérifier chaque fonctionnalité avant d’ajouter la suivante.

Dans NetBeans, l’onglet **Projects** donne accès aux packages et aux fichiers sources `.java`. La fenêtre **Output** permet de consulter les messages, de saisir les données et d’observer le résultat de l’exécution. La compilation vérifie notamment la syntaxe du code ; l’exécution permet ensuite de contrôler son comportement. Le message `BUILD SUCCESSFUL` doit donc être accompagné d’une vérification du résultat affiché.

## 2. Partie 1 : affichage et saisie d’un prénom

### Étapes importantes

J’ai commencé par afficher un message avec `System.out.println`, puis ajouté un message d’au revoir. J’ai ensuite rendu le programme interactif en demandant le prénom de l’utilisateur.

La classe `Scanner`, importée avec `import java.util.Scanner;`, permet de lire les données saisies dans la console. Le lecteur est créé avec `new Scanner(System.in)`. La méthode `nextLine()` récupère une ligne de texte et la stocke dans une variable de type `String`.

```java
String prenom;
Scanner sc = new Scanner(System.in);
System.out.println("Bonjour, quel est votre prenom ?");
prenom = sc.nextLine();
System.out.println("Bonjour " + prenom + " !");
System.out.println("Au revoir " + prenom + " !");
```

### Choix techniques et résultat

Le type `String` convient au prénom, car il s’agit d’une chaîne de caractères. L’opérateur `+` sert ici à concaténer le texte fixe et la valeur de la variable. Une variable écrite sans guillemets fournit son contenu, tandis qu’un texte entre guillemets est affiché littéralement.

Le test réalisé avec le prénom `Loc` a produit les messages `Bonjour Loc !` et `Au revoir Loc !`. Il confirme la lecture du prénom et sa réutilisation dans l’affichage.

## 3. Partie 2 : addition des premiers entiers

### Principe du calcul

Le programme calcule la somme des entiers de 1 à un nombre `nb`. Trois variables de type `int` sont utilisées :

| Variable | Rôle | Initialisation |
|---|---|---|
| `nb` | Dernier entier à additionner | D’abord 5, puis une valeur saisie |
| `result` | Somme accumulée | 0 |
| `ind` | Entier ajouté à chaque tour | 1 |

### Problème rencontré et correction

Dans le code initial, la boucle `while (ind <= nb)` additionnait `ind` à `result`, mais ne modifiait jamais `ind`. Pour `nb = 5`, l’indice restait à 1 et la condition demeurait vraie. Le programme restait donc dans une boucle infinie et n’atteignait pas l’affichage final.

La correction consiste à ajouter `ind++` après l’addition :

```java
result = 0;
ind = 1;
while (ind <= nb) {
    result = result + ind;
    ind++;
}
```

L’ordre de ces instructions est essentiel : le programme ajoute la valeur actuelle de l’indice, puis passe à l’entier suivant. Lorsque `ind` dépasse `nb`, la boucle s’arrête.

Pour analyser ce type d’erreur, le TP propose d’utiliser le débogueur : placer un point d’arrêt sur `ind = 1;`, lancer le projet en mode débogage, puis avancer avec **Step Over** et observer les variables. Cette méthode permet de repérer une variable qui n’évolue pas comme prévu, même si le code compile.

### Ajout de la saisie et résultats observés

J’ai ensuite remplacé la valeur fixe `nb = 5;` par une saisie avec `sc.nextInt()`. Cette méthode est adaptée à une variable de type `int`.

Les exécutions présentées ont donné les résultats suivants :

| Valeur de `nb` | Calcul | Résultat observé |
|---|---|---:|
| 5 | 1 + 2 + 3 + 4 + 5 | 15 |
| 3, saisi au clavier | 1 + 2 + 3 | 6 |

Cette partie montre l’importance de l’initialisation, de la condition de poursuite et de la mise à jour de l’indice dans une boucle.

## 4. Partie 3 : calculatrice en console

### Organisation du programme

La calculatrice affiche un menu de cinq opérations, lit le choix de l’utilisateur, puis demande deux nombres. Les variables `operateur`, `operande1` et `operande2` sont de type `int` et sont renseignées avec `nextInt()`.

| Choix | Opération | Expression |
|---:|---|---|
| 1 | Addition | `operande1 + operande2` |
| 2 | Soustraction | `operande1 - operande2` |
| 3 | Multiplication | `operande1 * operande2` |
| 4 | Division | `(float) operande1 / operande2` |
| 5 | Modulo, reste de la division entière | `operande1 % operande2` |

### Choix du `switch`

J’ai utilisé un `switch` pour associer chaque numéro du menu à une opération. Cette structure convient à un choix parmi plusieurs valeurs précises. Chaque `case` réalise le calcul correspondant et se termine par `break`, afin de sortir du `switch` sans exécuter les cas suivants. Le cas `default` permet de signaler un opérateur invalide.

### Choix du type `float` pour le résultat

J’ai choisi une variable `float resultat` pour conserver une partie décimale lors de la division. Toutefois, déclarer le résultat en `float` ne suffit pas : une division entre deux `int` reste une division entière avant son affectation.

```java
resultat = (float) operande1 / operande2;
```

La conversion explicite `(float)` transforme le premier opérande pour ce calcul et provoque une division flottante. Sans cette conversion, `3 / 2` donnerait 1, ensuite stocké sous la forme `1.0`. Avec la conversion, le résultat est `1.5`.

La dernière exécution présentée confirme ce comportement : le choix 4, avec les valeurs 3 et 2, affiche `Le resultat est :1.5`. Les saisies restent néanmoins limitées aux entiers, puisque les opérandes sont lus avec `nextInt()`. Le type `float` possède par ailleurs une précision limitée : il ne représente pas exactement tous les nombres décimaux.

### Gestion des erreurs et améliorations identifiées

La division vérifie si le deuxième opérande vaut zéro. Dans ce cas, le programme affiche un message d’erreur et utilise `return` pour quitter `main` avant le calcul. Contrairement à `break`, qui quitte ici le `switch`, `return` termine la méthode.

La version figurant sur la dernière capture contient encore un point à corriger : dans le cas du modulo par zéro, le message d’erreur est présent, mais il manque `return`. Sans cet arrêt, le programme tente tout de même le modulo par zéro et déclenche une exception. Le contrôle doit être complété ainsi :

```java
if (operande2 == 0) {
    System.out.println("Erreur : modulo par zero impossible.");
    return;
}
```

Deux améliorations ont également été identifiées, sans être confirmées par la dernière capture :

- Afficher le nom de l’opération plutôt que son numéro, en renseignant une variable `String nomOperateur` dans chaque `case`.
- Pour répondre à l’exercice 8, vérifier que le choix est compris entre 1 et 5 immédiatement après sa lecture, avant de demander les opérandes.

Le contrôle anticipé du choix peut s’écrire :

```java
if (operateur < 1 || operateur > 5) {
    System.out.println("Erreur : operateur invalide.");
    return;
}
```

## 5. Vérifications complémentaires avant le rendu

Les résultats observés ci-dessus valident l’affichage du prénom, deux calculs de somme et une division décimale. Les cas suivants constituent une grille de vérification complémentaire ; leurs résultats sont attendus et ne sont pas présentés comme des tests déjà réalisés.

| Test | Saisies : choix, premier nombre, deuxième nombre | Résultat attendu |
|---|---|---|
| Addition | 1, 5, 9 | 14.0 |
| Soustraction | 2, 5, 9 | -4.0 |
| Multiplication | 3, 5, 9 | 45.0 |
| Division | 4, 7, 2 | 3.5 |
| Modulo | 5, 7, 2 | 1.0 |
| Division par zéro | 4, 7, 0 | Message d’erreur et arrêt |
| Modulo par zéro, après correction | 5, 7, 0 | Message d’erreur et arrêt |
| Choix invalide, après contrôle anticipé | 8 | Message d’erreur sans demander les nombres |

## 6. Bilan

Ce TP m’a permis de prendre en main NetBeans et de construire progressivement des programmes Java en console. Les principales notions abordées sont l’affichage, les variables, la saisie avec `Scanner`, la boucle `while`, les conditions et la sélection d’une opération avec `switch`.

Les points techniques les plus importants sont la mise à jour de l’indice pour éviter une boucle infinie, la différence entre division entière et division flottante, ainsi que l’arrêt du programme avant une opération invalide. La vérification des résultats complète la compilation et permet de détecter les erreurs de logique.

Le présent rapport couvre les trois parties documentées par le code et les exécutions présentés. La partie 4 consacrée aux intervalles n’est pas décrite ici, faute d’éléments de réalisation fournis.

## 7. Lien vers le dépôt GitHub

**Dépôt contenant les projets Java :** [LIEN VERS MON DÉPÔT GITHUB À COMPLÉTER]
