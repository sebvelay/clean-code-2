# Exo

## Supple design

### Intention-revealing Interface

Pourquoi la classse Flight pose problème ?

### guards

On peut voir ce principe sous 2 angles : la programmation par contrat (pre/post conditions+invariants), ou la programmation défensive.
Cet exo l'aborde sous l'angle précondition/programmation défensive.

La classe à refactorer est `BookingService`, qui permet de réserver une salle dont on passe la capacité (un `int`) en paramètre.
Elle retourne un `Optional<Room>`, c'est-à-dire que si aucune salle n'est disponible on retourne `Optional.empty`, et que si une salle est disponible on retourne `Optional.of(room)`.

Mais, que doit faire cette classe si on lui passe une capacité négative (qui n'a donc pas de sens) ?

### Closure of operations/Standalone class

Cet exo couvre ces 2 principes (qui sont souvent liés): la classe "standalone" introduite est un Value Object qui comprend une méthode "fermée" plus (cf. Evans, DDD).

La classe à refactorer est `Bid`.

Comprend des tests unitaires pour démontrer que le refactor ne provoque pas de régression.

Cet exercice se fait en 2 temps 

### Principe de symétrie

Ici il s'agit de regarder la cohérence du nommage et des signatures. Doit-on introduire une autre classe ?

## Smells de Martin Fowler

### Duplicated Method

La classe à refactorer est `EventAPI`. On cherche à supprimer la duplication. Contrainte : on souhaite garder des signatures simple et ne pas ajouter de paramètres dans les signatures ( ex : `sendMessage(Object t, String k)` est à éviter)

### Duplicated class

Identifier le code dupliqué et proposer une solution

### ArrayList Obsession 

Exo 1 : quel soucis fonctionnel le choix d'ArrayList implique ?

Exo 2 : refactorer le code

### Escalier du diable

Refactorer la classe MusicSearchService pour la rendre plus lisible. Exécuter les tests pour vérifier qu'il n'y a pas de régressions

### Primitive Obsession

