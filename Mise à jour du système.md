# Mise à jour du système

## Comment faire pour éviter la coupure de service ?

Posséder un environnement répliqué et synchronisé du système principale. Lorsqu'une mise à jour a passée tous les test de pré-prod et est donc prête à être déployé, nous n'aurons qu'à la pousser sur l'environnement répliqué (qui continuera à se synchroniser avec le serveur principal) et une fois la mise à jour appliquée sur le serveur répliqué, il prendra alors le rôle de principal. Une simple bascule de flux suffira donc.

## Que faire des parties en cours ?

Comme les parties sont sauvegardée régulièrement au format JSON, nous pourrons les restaurées facilement après la mise à jour. Il faudra en amont (lors des test) vérifier que les "anciens" formats JSON soient parfaitement retro compatible en compte dans la nouvelle version.

## Comment changer l'API pour que les joueurs utilisant une vieille version du client web puissent toujours jouer ?

Pour assurer la rétro-compatibilité de notre produit il nous faut :
- Séparer les versions majeures du produit sur différentes architectures
- Créer une classe qui vérifiera la version du browser et, si la version du browser est compatible avec nos produits, choisir la version la plus récente compatible et rediriger le client dessus

Notre API doit donc donner comme réponse : Un tableau 2 comportant l'information suivante :
[[<=Browser_Version1, Produit_version1],
[<=Browser_Version2, Produit_version1, ..., Produit_versionN],
[...][<=Browser_VersionN, Produit_version1, ..., Produit_versionN]]

## Comment avertir les joueurs de la nouveauté une unique fois ?

Ajouter dans la classe player un attribut "isUpdatedAboutNews" et 2 méthodes "setIsUpdatedAboutNews" et "getIsUpdatedAboutNews". L'attribut se comportera comme un flag, lors de l'initialisation (pendant la création d'un joueur donc) l'attribut sera initialiser à False. La methode get permettra de vérifier si le joueur est au courant de la news, si il ne l'est pas, nous lui enverrons un message pop-up like et utiliserons la fonction set pour passer l'attribut à True. Lors d'une nouvelle fonctionnalité, nous aurons une fonction qui boucle sur chaque Player et passe à false cet attribut.