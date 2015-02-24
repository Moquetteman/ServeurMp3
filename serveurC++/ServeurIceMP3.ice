module serveur
{
	interface ServeurIceMP3
	{
		void ajoutfichier(string titre, string auteur, string fichier);
		string recherche(string titre, string auteur);
		void suppression(string titre, string auteur);
	 	string lireMp3(string titre, string auteur);
	 	bool stopMp3(string nom);
	};
};
