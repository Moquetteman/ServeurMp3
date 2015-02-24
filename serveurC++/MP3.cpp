#include <iostream>
#include <string>
#include "MP3.hpp"

using namespace std;

MP3 :: MP3 (string n, string t, string a)
{
	nom = n;
	titre = t;
	auteur = a;
}

string MP3 :: getnom(){return nom;}
string MP3 :: gettitre(){return titre;}
string MP3 :: getauteur(){return auteur;}
