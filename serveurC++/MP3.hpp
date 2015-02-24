#pragma once
#include <string>

using namespace std;

class MP3
{
	private:
		string nom;
		string titre;
		string auteur;
	public:
		MP3(string, string, string);
		string getnom();
		string gettitre();
		string getauteur();
};
