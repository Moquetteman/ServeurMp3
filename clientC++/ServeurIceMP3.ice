module serveur
{
	sequence<string> listetitre;
	sequence<string> listeauteur;
	interface ServeurIceMP3
	{
		void ajoutfichier(string titre, string auteur, string fichier);
		string recherche(string titre, string auteur);
		listetitre rechercheTitre(string titre);
		listeauteur rechercheAuteur(string auteur);
		void suppression(string titre, string auteur);
	 	string lireMp3(string titre, string auteur);
	 	string lireMp3ParFichier(string fichier);
	 	bool stopMp3(string nom);
	};
};
