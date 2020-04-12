# Concevoir le système initial

## Est-ce que les joueurs interagiront en temps réel, ou au tour par tour et pourquoi ?

Pour notre jeu nous favorisons un mode de jeu tour par tour. Le jeu est divisé en parties claires appelées tours. À leur tour, les joueurs peuvent bénéficier d'une période d'analyse avant de lancer des actions de jeu, assurant ainsi une séparation entre la progression du jeu et les processus de réflexion. 

## Comment sera stocké l'état (toutes les données permettant de représenter le jeu) ?

Pour stocker toutes les données utilisées pour représenter le jeu, nous allons enregistrer les informations au format JSON (JavaScript  Object Notation). L'avantage de ce format est qu'il peut être utilisé  par de nombreux langages de programmation et qu'il est facile à lire et à générer, c'est une solution utilisée dans de nombreuses applications Web.

## Comment seront stockées les informations confidentielles des joueurs (emails, etc.) ?

Le joueur n'aura pas besoin de compte personnel. Nous considérons le jeu comme un jeu navigateur. Le joueur rentre son pseudo mais dès qu'il quitte la fenêtre il est éliminé.

## Comment gérer plusieurs parties en même temps ?

Chaque partie génère son fichier JSON et dès que la partie est fini le JSON est supprimé.

## Comment gérer plusieurs parties par joueurs en même temps ?

Chaque joueur ne peut accéder qu'à une seule partie.

## Comment les joueurs s'authentifieront et sauvegardent leur progression ?

Considérant ce jeu comme un jeu flash, il  n'y aura pas d'identification ni de sauvegarde.

## Comment gérer une charge imprévue ? (100x plus de joueurs que prévu par ex)

On limite le nombre de joueurs à 50 par parties.