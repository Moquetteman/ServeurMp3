#include <iostream>
#include <Ice/Ice.h>
#include <list>
#include <vlc/vlc.h>
#include "MP3.hpp"
#include "ServeurIceMP3.h"

using namespace std;

class ServeurIceMP3I : public serveur :: ServeurIceMP3 {
	private: 
	list<MP3> liste;
	libvlc_instance_t *vlc;

	public:
		ServeurIceMP3I();
		~ServeurIceMP3I();
		void ajoutfichier(const string & titre, const string & auteur, const string & fichier, const Ice::Current&);
		string recherche(const string & titre, const string & auteur, const Ice::Current&);
		serveur::listeauteur rechercheAuteur(const string & auteur, const Ice::Current&);
		serveur::listetitre rechercheTitre(const string & titre, const Ice::Current&);
		void suppression(const string & titre, const string & auteur, const Ice::Current&);
		string lireMp3(const string & titre, const string &auteur, const Ice::Current&);
		string lireMp3ParFichier(const string &fichier, const Ice::Current&);
		bool stopMp3(const string & nom, const Ice::Current&);
};

// Implémentation des méthodes

ServeurIceMP3I :: ServeurIceMP3I()
{
		this->vlc = libvlc_new(0, NULL);
}

ServeurIceMP3I :: ~ServeurIceMP3I()
{
		libvlc_vlm_release(this->vlc);
}

void ServeurIceMP3I :: ajoutfichier(const string& titre, const string& auteur, const string& fichier, const Ice::Current& icec)
{
	MP3 son(fichier,titre, auteur);
	if (recherche(titre, auteur, icec) == "")
	{
		liste.push_back(son);
		cout << "Ajout du titre :"<< titre<< ", de :" << auteur << endl;
	}
	else
		cout<<"Deja existant"<<endl;
}

string ServeurIceMP3I :: recherche(const string& titre, const string& auteur, const Ice::Current& icec)
{
	for (list<MP3>::iterator it = liste.begin(); it!= liste.end(); ++it)
	{
		if (it->getauteur() == auteur && it->gettitre() == titre)
		{
			cout << "Fichier trouve" << endl;
			return it->getnom();
		}
	}
	return "";
}

serveur :: listetitre ServeurIceMP3I :: rechercheTitre(const string& titre, const Ice::Current& icec)
{
	serveur :: listetitre rech;
	for (list<MP3>::iterator it = liste.begin(); it!= liste.end(); ++it)
	{
		if (it->gettitre() == titre)
		{
			rech.push_back(it->getnom());
		}
	}
	return rech;
}

serveur :: listeauteur ServeurIceMP3I :: rechercheAuteur(const string& auteur, const Ice::Current& icec)
{
	serveur :: listeauteur rech;
	for (list<MP3>::iterator it = liste.begin(); it!= liste.end(); ++it)
	{
		if (it->getauteur() == auteur)
		{
			rech.push_back(it->getnom());
		}
	}
	return rech;
}

void ServeurIceMP3I :: suppression(const string& titre, const string& auteur, const Ice::Current& icec)
{
	if(recherche(titre, auteur,icec) == "") // 1 fois
	{
		cout << "aucun fichier à supprimer" << endl;
	}
	else
	{
		for (list<MP3>::iterator it = liste.begin(); it!= liste.end(); ++it) //2 fois
			//Je sais c'est pas très optimisé
		{
			if (it->getauteur() == auteur && it->gettitre() == titre) // Je fais 2 fois la recherche
			{
				it = liste.erase(it);
			}
		}
	}
}

string ServeurIceMP3I :: lireMp3(const string& titre, const string& auteur, const Ice::Current& icec)
{
	string nom = recherche(titre, auteur, icec);

	if (nom == "")
		return "";
	else
	{
		string url = "../Audio/" + nom;
		string sout = "#transcode{acodec=mp3,ab=128,channels=2," \
							"samplerate=44100}:http{dst=:8090/"+ nom+"}";
		const string media_name = nom;

		libvlc_vlm_add_broadcast(vlc, media_name.c_str(), url.c_str(), sout.c_str(), 0, NULL, true, false);
		libvlc_vlm_play_media(vlc, media_name.c_str());

		return nom;
	}
}

bool ServeurIceMP3I :: stopMp3(const string& nom, const Ice::Current& icec)
{
		if(nom == "")
			return false;
		else
		{
			const string media_name = nom;
			libvlc_vlm_stop_media(vlc, media_name.c_str());
			return true;
		}
}

string ServeurIceMP3I :: lireMp3ParFichier(const string &fichier, const Ice::Current&)
{
	if (fichier == "")
		return "";
	else
	{
		string url = "../Audio/" + fichier;
		string sout = "#transcode{acodec=mp3,ab=128,channels=2," \
							"samplerate=44100}:http{dst=:8090/"+ fichier +"}";
		const string media_name = fichier;

		libvlc_vlm_add_broadcast(vlc, media_name.c_str(), url.c_str(), sout.c_str(), 0, NULL, true, false);
		libvlc_vlm_play_media(vlc, media_name.c_str());

		return fichier;
	}
}

int main(int argc, char* argv[]){

	int status = 0;
	Ice::CommunicatorPtr ic;

	try {
		ic = Ice::initialize(argc, argv);
		Ice::ObjectAdapterPtr adapter =ic->createObjectAdapterWithEndpoints("SimplePrinterAdapter", "default -p 10000");
		Ice::ObjectPtr object = new ServeurIceMP3I;
		adapter->add(object, ic->stringToIdentity("SimplePrinter"));
		adapter->activate();
		ic->waitForShutdown();
	}

	catch (const Ice::Exception& e) {
		cerr << e << endl;status = 1;
	}

	catch (const char* msg) {
		cerr << msg << endl;status = 1;
	}

	if (ic) {
		try {ic->destroy();} catch (const Ice::Exception& e) {
			cerr << e << endl;
			status = 1;
		}}
	return status;
}
