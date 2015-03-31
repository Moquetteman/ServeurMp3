import java.util.Scanner;
import java.util.Vector;
import java.util.*;

public class clientIce {
	public static void main(String[] args)
	{
		int status = 0;
		Ice.Communicator ic = null;
		try {
			ic = Ice.Util.initialize(args);
			Ice.ObjectPrx base = ic.stringToProxy("SimplePrinter:default -h 178.62.148.22 -p 10000");
			serveur.ServeurIceMP3Prx ServeurIceMP3 = serveur.ServeurIceMP3PrxHelper.checkedCast(base);
			if (ServeurIceMP3 == null) throw new Error("Invalid proxy");

			Scanner sc = new Scanner(System.in);
			int choix = 0;
			String nom= "";
			String[] artistes;
			String[] titres;
			while(choix != 8)
			{
				System.out.println("1 Pour Ajouter");
				System.out.println("2 Pour Supprimer");
				System.out.println("3 Pour Rechercher un titre");
				System.out.println("4 Pour Rechercher par titre");
				System.out.println("5 Pour Rechercher par auteur");
				System.out.println("6 Pour Lire un fichier");
				System.out.println("7 Pour Arreter la lecture");
				System.out.println("8 Pour Quitter");
				System.out.println("Entrez votre choix: ");
				choix = sc.nextInt();
				sc.nextLine();
				if (choix == 1) //ajout
				{
					System.out.println("Fonctionnalite ajout");

					System.out.println("Entrez le Titre: ");
					String titre = sc.nextLine();
					sc.nextLine();
					System.out.println("Entrez l'Artiste: ");
					String artiste = sc.nextLine();
					sc.nextLine();
					System.out.println("Entrez le fichier: ");
					String fichier = sc.nextLine();
					sc.nextLine();
					ServeurIceMP3.ajoutfichier(titre,artiste,fichier);

				}
				else if (choix == 2) //Supprimer
				{
					System.out.println("Fonctionnalite suppression");

					System.out.println("Entrez le Titre: ");
					String titre = sc.nextLine();
					sc.nextLine();
					System.out.println("Entrez l'Artiste: ");
					String artiste = sc.nextLine();
					sc.nextLine();
					ServeurIceMP3.suppression(titre,artiste);

				}
				else if (choix == 3) //recherche un titre
				{
					System.out.println("Fonctionnalite recherche");

					System.out.println("Entrez le Titre: ");
					String titre = sc.nextLine();
					sc.nextLine();
					System.out.println("Entrez l'Artiste: ");
					String artiste = sc.nextLine();
					sc.nextLine();
					if (ServeurIceMP3.recherche(titre,artiste).equals("") == true)
						System.out.println("Fichier inexistant");
					else
						System.out.println("Fichier trouvé");

				}
				else if (choix == 4)// recherche par titre
				{
					System.out.println("Entrez le Titre: ");
					String titre = sc.nextLine();
					sc.nextLine();
					titres = ServeurIceMP3.rechercheTitre(titre);
					if (titres.length == 0)
						System.out.println("Fichier inexistant");
					else
					{
						int cnt = 0;
						while(cnt <= titres.length - 1)
						{
							System.out.println(titres[cnt]);
							cnt++;
						}
					}
				}
				else if (choix == 5)// recherche par auteur
				{
					System.out.println("Entrez l'artiste :");
					String artiste = sc.nextLine();
					sc.nextLine();
					artistes = ServeurIceMP3.rechercheAuteur(artiste);
					if (artistes.length == 0)
						System.out.println("Fichier inexistant");
					else
					{
						int cnt = 0;
						while(cnt <= artistes.length - 1)
						{
							System.out.println(artistes[cnt]);
							cnt++;
						}
					}
				}
				else if (choix == 6) //lire
				{
					System.out.println("Lecture de fichier");
					System.out.println("Entrez le Titre: ");
					String titre = sc.nextLine();
					sc.nextLine();
					System.out.println("Entrez l'Artiste: ");
					String artiste = sc.nextLine();
					sc.nextLine();
					nom = ServeurIceMP3.lireMp3(titre, artiste);
					if (ServeurIceMP3.recherche(titre,artiste).equals("") == true)
						System.out.println("Impossible de lire");
					else
					{
						System.out.println("Debut Lecture a cette addresse");
						System.out.println("178.62.148.22:8090/" + nom );
					}
				}
				else if (choix == 7) // arret
				{
					System.out.println("STOP");
					if (ServeurIceMP3.stopMp3(nom) == false)
						System.out.println("La Musique n'est pas en cours de lecture");
					else
						System.out.println("Arret de la musique");
				}
			}
		} catch (Ice.LocalException e) {
			e.printStackTrace();
			status = 1;
		} catch (Exception e) {
			System.err.println(e.getMessage());
			status = 1;
		}
		if (ic != null) {
			try {
				ic.destroy();
			} catch (Exception e) {
				System.err.println(e.getMessage());
				status = 1;
			}
		}
		System.exit(status);		
	}							
}
