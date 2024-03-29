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

public interface ServeurIceMP3Prx extends Ice.ObjectPrx
{
    public void ajoutfichier(String titre, String auteur, String fichier);

    public void ajoutfichier(String titre, String auteur, String fichier, java.util.Map<String, String> __ctx);

    public Ice.AsyncResult begin_ajoutfichier(String titre, String auteur, String fichier);

    public Ice.AsyncResult begin_ajoutfichier(String titre, String auteur, String fichier, java.util.Map<String, String> __ctx);

    public Ice.AsyncResult begin_ajoutfichier(String titre, String auteur, String fichier, Ice.Callback __cb);

    public Ice.AsyncResult begin_ajoutfichier(String titre, String auteur, String fichier, java.util.Map<String, String> __ctx, Ice.Callback __cb);

    public Ice.AsyncResult begin_ajoutfichier(String titre, String auteur, String fichier, Callback_ServeurIceMP3_ajoutfichier __cb);

    public Ice.AsyncResult begin_ajoutfichier(String titre, String auteur, String fichier, java.util.Map<String, String> __ctx, Callback_ServeurIceMP3_ajoutfichier __cb);

    public void end_ajoutfichier(Ice.AsyncResult __result);

    public String recherche(String titre, String auteur);

    public String recherche(String titre, String auteur, java.util.Map<String, String> __ctx);

    public Ice.AsyncResult begin_recherche(String titre, String auteur);

    public Ice.AsyncResult begin_recherche(String titre, String auteur, java.util.Map<String, String> __ctx);

    public Ice.AsyncResult begin_recherche(String titre, String auteur, Ice.Callback __cb);

    public Ice.AsyncResult begin_recherche(String titre, String auteur, java.util.Map<String, String> __ctx, Ice.Callback __cb);

    public Ice.AsyncResult begin_recherche(String titre, String auteur, Callback_ServeurIceMP3_recherche __cb);

    public Ice.AsyncResult begin_recherche(String titre, String auteur, java.util.Map<String, String> __ctx, Callback_ServeurIceMP3_recherche __cb);

    public String end_recherche(Ice.AsyncResult __result);

    public String[] rechercheTitre(String titre);

    public String[] rechercheTitre(String titre, java.util.Map<String, String> __ctx);

    public Ice.AsyncResult begin_rechercheTitre(String titre);

    public Ice.AsyncResult begin_rechercheTitre(String titre, java.util.Map<String, String> __ctx);

    public Ice.AsyncResult begin_rechercheTitre(String titre, Ice.Callback __cb);

    public Ice.AsyncResult begin_rechercheTitre(String titre, java.util.Map<String, String> __ctx, Ice.Callback __cb);

    public Ice.AsyncResult begin_rechercheTitre(String titre, Callback_ServeurIceMP3_rechercheTitre __cb);

    public Ice.AsyncResult begin_rechercheTitre(String titre, java.util.Map<String, String> __ctx, Callback_ServeurIceMP3_rechercheTitre __cb);

    public String[] end_rechercheTitre(Ice.AsyncResult __result);

    public String[] rechercheAuteur(String auteur);

    public String[] rechercheAuteur(String auteur, java.util.Map<String, String> __ctx);

    public Ice.AsyncResult begin_rechercheAuteur(String auteur);

    public Ice.AsyncResult begin_rechercheAuteur(String auteur, java.util.Map<String, String> __ctx);

    public Ice.AsyncResult begin_rechercheAuteur(String auteur, Ice.Callback __cb);

    public Ice.AsyncResult begin_rechercheAuteur(String auteur, java.util.Map<String, String> __ctx, Ice.Callback __cb);

    public Ice.AsyncResult begin_rechercheAuteur(String auteur, Callback_ServeurIceMP3_rechercheAuteur __cb);

    public Ice.AsyncResult begin_rechercheAuteur(String auteur, java.util.Map<String, String> __ctx, Callback_ServeurIceMP3_rechercheAuteur __cb);

    public String[] end_rechercheAuteur(Ice.AsyncResult __result);

    public void suppression(String titre, String auteur);

    public void suppression(String titre, String auteur, java.util.Map<String, String> __ctx);

    public Ice.AsyncResult begin_suppression(String titre, String auteur);

    public Ice.AsyncResult begin_suppression(String titre, String auteur, java.util.Map<String, String> __ctx);

    public Ice.AsyncResult begin_suppression(String titre, String auteur, Ice.Callback __cb);

    public Ice.AsyncResult begin_suppression(String titre, String auteur, java.util.Map<String, String> __ctx, Ice.Callback __cb);

    public Ice.AsyncResult begin_suppression(String titre, String auteur, Callback_ServeurIceMP3_suppression __cb);

    public Ice.AsyncResult begin_suppression(String titre, String auteur, java.util.Map<String, String> __ctx, Callback_ServeurIceMP3_suppression __cb);

    public void end_suppression(Ice.AsyncResult __result);

    public String lireMp3(String titre, String auteur);

    public String lireMp3(String titre, String auteur, java.util.Map<String, String> __ctx);

    public Ice.AsyncResult begin_lireMp3(String titre, String auteur);

    public Ice.AsyncResult begin_lireMp3(String titre, String auteur, java.util.Map<String, String> __ctx);

    public Ice.AsyncResult begin_lireMp3(String titre, String auteur, Ice.Callback __cb);

    public Ice.AsyncResult begin_lireMp3(String titre, String auteur, java.util.Map<String, String> __ctx, Ice.Callback __cb);

    public Ice.AsyncResult begin_lireMp3(String titre, String auteur, Callback_ServeurIceMP3_lireMp3 __cb);

    public Ice.AsyncResult begin_lireMp3(String titre, String auteur, java.util.Map<String, String> __ctx, Callback_ServeurIceMP3_lireMp3 __cb);

    public String end_lireMp3(Ice.AsyncResult __result);

    public String lireMp3ParFichier(String fichier);

    public String lireMp3ParFichier(String fichier, java.util.Map<String, String> __ctx);

    public Ice.AsyncResult begin_lireMp3ParFichier(String fichier);

    public Ice.AsyncResult begin_lireMp3ParFichier(String fichier, java.util.Map<String, String> __ctx);

    public Ice.AsyncResult begin_lireMp3ParFichier(String fichier, Ice.Callback __cb);

    public Ice.AsyncResult begin_lireMp3ParFichier(String fichier, java.util.Map<String, String> __ctx, Ice.Callback __cb);

    public Ice.AsyncResult begin_lireMp3ParFichier(String fichier, Callback_ServeurIceMP3_lireMp3ParFichier __cb);

    public Ice.AsyncResult begin_lireMp3ParFichier(String fichier, java.util.Map<String, String> __ctx, Callback_ServeurIceMP3_lireMp3ParFichier __cb);

    public String end_lireMp3ParFichier(Ice.AsyncResult __result);

    public boolean stopMp3(String nom);

    public boolean stopMp3(String nom, java.util.Map<String, String> __ctx);

    public Ice.AsyncResult begin_stopMp3(String nom);

    public Ice.AsyncResult begin_stopMp3(String nom, java.util.Map<String, String> __ctx);

    public Ice.AsyncResult begin_stopMp3(String nom, Ice.Callback __cb);

    public Ice.AsyncResult begin_stopMp3(String nom, java.util.Map<String, String> __ctx, Ice.Callback __cb);

    public Ice.AsyncResult begin_stopMp3(String nom, Callback_ServeurIceMP3_stopMp3 __cb);

    public Ice.AsyncResult begin_stopMp3(String nom, java.util.Map<String, String> __ctx, Callback_ServeurIceMP3_stopMp3 __cb);

    public boolean end_stopMp3(Ice.AsyncResult __result);
}
