// **********************************************************************
//
// Copyright (c) 2003-2013 ZeroC, Inc. All rights reserved.
//
// This copy of Ice is licensed to you under the terms described in the
// ICE_LICENSE file included in this distribution.
//
// **********************************************************************
//
// Ice version 3.5.1
//
// <auto-generated>
//
// Generated from file `ServeurIceMP3.ice'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package serveur;

public interface _ServeurIceMP3Operations
{
    void ajoutfichier(String titre, String auteur, String fichier, Ice.Current __current);

    String recherche(String titre, String auteur, Ice.Current __current);

    String[] rechercheTitre(String titre, Ice.Current __current);

    String[] rechercheAuteur(String auteur, Ice.Current __current);

    void suppression(String titre, String auteur, Ice.Current __current);

    String lireMp3(String titre, String auteur, Ice.Current __current);

    String lireMp3ParFichier(String fichier, Ice.Current __current);

    boolean stopMp3(String nom, Ice.Current __current);
}
