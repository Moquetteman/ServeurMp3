#include <Ice/Ice.h>
#include "ServeurIceMP3.h"

using namespace std;
using namespace serveur;

int main(int argc, char* argv[])
{
	    int status = 0;
		Ice::CommunicatorPtr ic;
		try {
				ic = Ice::initialize(argc, argv);
				Ice::ObjectPrx base = ic->stringToProxy("SimplePrinter:default -h 178.62.148.22 -p 10000");
				ServeurIceMP3Prx ServeurIceMP3 = ServeurIceMP3Prx::checkedCast(base);
				if (!ServeurIceMP3)
					throw "Invalid proxy";

				string titre, artiste, chemin, nom;

				int choix = 0;
				while(choix !=6 )
				{
					cout << "1 Pour Ajouter" <<endl;
					cout << "2 Pour Supprimer" <<endl;
					cout << "3 Pour Rechercher" <<endl;
					cout << "4 Pour Lire un fichier" <<endl;
					cout << "5 Pour Arreter la lecture" <<endl;
					cout << "6 Pour Quitter" <<endl;
					cout << "Entrez votre choix " << endl;
					cin >> choix;

					if (choix == 1)
					{
						cout << "Entrez le titre :" << endl;
						cin >> titre;
						cout << "Entrez l'artiste :" << endl;
						cin >> artiste;
						cout << "Entrez le chemin :" << endl;
						cin >> chemin;
						ServeurIceMP3->ajoutfichier(titre, artiste, chemin);
					}

					else if (choix == 2)
					{
						cout << "Entrez le titre :" << endl;
						cin >> titre;
						cout << "Entrez l'artiste :" << endl;
						cin >> artiste;
						ServeurIceMP3->suppression(titre, artiste);
					}

					else if (choix == 3)
					{
						cout << "Entrez le titre :" << endl;
						cin >> titre;
						cout << "Entrez l'artiste :" << endl;
						cin >> artiste;
						if (ServeurIceMP3->recherche(titre, artiste) == "")
							cout << "Fichier inexistant" <<endl;
						else
							cout << "Fichier trouve" << endl;
					}

					else if (choix == 4)
					{
						cout << "Lecture de fichier" <<endl;
						cout << "Entrez le titre :" << endl;
						cin >> titre;
						cout << "Entrez l'artiste :" << endl;
						cin >> artiste;
						nom = ServeurIceMP3->lireMp3(titre, artiste);
						if (nom == "")
							cout << "Impossible de lire" <<endl;
						else
						{
							cout << "Debut Lecture a cet addresse" << endl;
							cout << "178.62.148.22:8090/" << nom << endl;
						}
					}

					else if (choix == 5)
					{
						cout << "Stop" <<endl;
						if (ServeurIceMP3->stopMp3(nom) == false)
							cout << "La Musique n'est pas en cours de lecture" <<endl;
						else
							cout << "Arret de la musique" << endl;
					}

				}

					//printer->printString("Hello World!");
		} catch (const Ice::Exception& ex) {
		cerr << ex << endl;
		status = 1;
		} catch (const char* msg) {
		cerr << msg << endl;
		status = 1;
		}
		if (ic)
			ic->destroy();
		return status;
}
