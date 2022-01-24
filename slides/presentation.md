# Améliorer la qualité du code existant

---

## Plan

- Supple Design
- Smells courant

---

## Supple Design

- Intention-Revealing Interfaces
- Guards
- Closure of operations/Standalone class
- Principe de symétrie
- ( il en existe d'autres )

---
## Intention-Revealing Interfaces

> L'interface (méthodes publiques) d'un composant (classe) doit révéler son intention.

Faire une revue de code de `supple.iri`, en particulier `FlightTest` et la méthode `Flight.setSuffix()`

----

## Intention-Revealing Interfaces

- On doit regarder l’implémentation pour comprendre l'intention de la méthode
- L'interface exprime une mécanique, pas une intention
- Couple le client du composant à sa représentation interne
- Pas vraiment une interface...

----

## Intention-Revealing Interfaces

<div class="row" style="font-size: 26px">
  <div class="column">
<b>Incorrect</b><br />
On doit regarder l’implémentation d’une interface pour comprendre ce qu’elle fait

&rarr; L'encapsulation conceptuelle est perdue.

Le nommage des méthodes d'une classe n’indique pas leur contrat

&rarr; Les utilisateurs vont se fonder sur le code d’implémentation pour en deviner le contrat

Code difficile à comprendre


</div>
<div class="column fragment">
<b>Correct</b><br />
Éléments nommés suivant *ce qu’ils font* et non *comment* ils le font

Nommage utilisant l’Ubiquitous Language, immédiatement compréhensible

L’approche test-first force à raisonner en terme d’utilisateur de l’API (et non pas de son fonctionnement interne)
</div>
</div>

---

## Guards

> Programmer défensivement. Fail early.

Faire une revue de code de `supple.guard.BookingService`, en particulier `BookingService.book()`

----

## Guards

Le compilateur n'interdit pas aux clients de

```
book(int capacityMin)
``` 

de passer

``` 
capaciteMin = -1
```

----

## Guards

<div style="font-size: 28px">
Plusieurs méthodes de défense en fonction du contexte :

- Signaler un bug interne au service (`throw new AssertionError()`)
  <br/>&rarr; Adapté si c’est une méthode privée : le service contrôle ses appelants

- Signaler une utilisation incorrecte du service (`throw new IllegalArgumentException()`)
  <br/>&rarr; Adapté si c’est une méthode publique : le service ne contrôle pas ses appelants

- Signaler une absence de résultat (`return Optional.empty()`)
  <br/>&rarr; Très rarement adapté : provoque une confusion entre cas d'erreur et cas sans résultat

- Ignorer dans ce cas le paramètre `minCapacity` (« l'utilisateur voulait dire `1` »)
  <br/>&rarr; Très rarement adapté : **préférer faire rien que n'importe quoi**

</div>

----

## Guards

<div style="font-size: 28px">

- *Pré-conditions* : vérifications en début de méthode, portant sur :
    - les paramètres (`IllegalArgumentException` / `NullPointerException` / `AssertionError`)
    - l'état de l'objet (`IllegalStateException`)
- *Post-conditions* : vérifications en fin de méthode, portant sur :
    - le retour (`AssertionError`)
    - l'état de l'objet (`IllegalStateException`)

</div>

----

## Guards

<div class="row" style="font-size: 28px">
  <div class="column">
<b>Incorrect</b><br />
L'appel d'une fonction avec des paramètres incorrects ou sans respecter les prérequis est masqué

« Mis sous le tapis » silencieusement ou avec un simple log

Oblige à "creuser" dans le fonctionnement interne de l’opération

Rend les bugs très difficiles à analyser en éloignant la conséquence de sa cause première

Peuvent se produire dans une ligne de code très éloignée



  </div>
  <div class="column fragment"><b>Correct</b><br />
  Contrat d'entrée et prérequis des fonctions exprimés par des préconditions

*Fail early* : toute violation de ces conditions entraîne l'arrêt immédiat du traitement en cours

Faire *RIEN* plutôt que *N'IMPORTE QUOI*
  </div>
</div>

---

## Closure of operations / Standalone class

Pour minimiser le couplage et maximiser la cohésion à l'extrême :

- Utiliser des types auto-porteurs à chaque fois que c'est possible</li>
- Y inclure des opérateurs binaires, ou au moins retournant/prenant en paramètre le même type

----

## Closure of operations / Standalone class

Code review de `supple.vo.Bid` et refactorer

----

## Standalone class

<div class="row" style="font-size: 28px">
  <div class="column">
<b>Incorrect</b><br />
Même dans un module bien conçu, la difficulté de compréhension augmente beaucoup avec le nombre de dépendances

&rarr; Cette surcharge mentale est défavorable

&rarr; Il existe une borne à la complexité compréhensible par un développeur


</div>
<div class="column fragment">
<b>Correct</b><br />
Quand c’est possible, pousser le couplage faible à l’extrême : concevoir des types entièrement autoporteurs

&rarr; Ce pattern s'applique surtout aux *Value Objects*

&rarr; Il est lié au pattern suivant : *Closure of Operations*
</div>
</div>

----

## Closure of Operations

<div class="row" style="font-size: 26px">
  <div class="column">
<b>Incorrect</b><br />
<b>Anti-pattern</b> « Primitive Obsession »

Utilisation prolifique de types primitifs et de strings dans toutes les couches

<b>L'utilisation de Value Objects est un bon début</b>

Mais on ne les exploite pas pleinement sans le pattern <b>Closure of Operations</b>

</div>
<div class="column fragment">
<b>Correct</b><br />
Concevoir des VOs avec une interface riche, mais des dépendances minimales

De même que les types numériques sont stables par les opérations binaires arithmétiques (+ - × ÷), inclure dans les VOs des opérations binaires par lesquelles ils sont stables

Le VO et cette opération constituent:

&rarr; Un ensemble particulièrement cohérent

&rarr; Une interface sémantiquement significative

&rarr; Un type autoporteur
</div>
</div>

---

## Symétrie

Review de `supple.sym.MonetaryAmount`

----

## Symétrie

<div class="row" style="font-size: 26px">
  <div class="column">
<b>Incorrect</b><br />
Deux concepts sont "presque" symétriques, mais pas tout à fait

Le code, les commentaires, la documentation ne donnent aucune justification de cette brisure de symétrie
</div>
<div class="column fragment">
<b>Correct</b><br />

Renommer vers des concepts symétriques permet d'alleger le poids de la représentation mentale

Plusieurs concepts sont remplacés par un seul

Après renommage, vérifier que le comportement est effectivement symétrique

</div>
</div>

---

## Code smell

Terme inventé par Kent Beck et popularisé par Martin Fowler

- *Une notion intuitive...*
  - « If it stinks, change it » – Beck
  - Impression déplaisante produite par un anti-pattern

----

- *… mais rendue plus précise/objective par la littérature existante*
  - Catalogue de smells de <i>Refactoring</i>

----

- De même que les Design Patterns :
  - Fournissent un vocabulaire standard
  - Donnent des critères d'applicabilité
  - Proposent des solutions : refactors
  - Recensent des variations
  - Certains sont évidents, d'autres moins

---

## Duplicated Method

> Don't repeat yourself

La classe à refactorer est `EventAPI`. On cherche à supprimer la duplication. Contrainte : on souhaite garder des signatures simple et ne pas ajouter de paramètres dans les signatures ( ex : `sendMessage(Object t, String k)` est à éviter)

---

## Duplicated Class

Identifier le code dupliqué et proposer une solution pour exo1 et exo2

----

## Duplicated Class

Attention aux relations <b>a un</b> et <b>est un</b>

<div class="fragment">D'une manière générale vous allez plus souvent utiliser la composition que l'héritage</div>

---

## ArrayList Obsession

Exo 1 : quel soucis fonctionnel le choix d'ArrayList implique ?

Exo 2 : refactorer le code

---

## Escalier du diable

Refactorer la classe `MusicSearchService` pour la rendre plus lisible. Exécuter les tests pour vérifier qu'il n'y a pas de régressions

---

## Primitive Obsession

Identifier le soucis et refactorer