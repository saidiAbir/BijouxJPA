package com.abir.test;

import com.abir.dao.BijouxDao;
import com.abir.entities.Bijoux;

public class BijouxTest {
    public static void main(String[] args) {

        Bijoux b = new Bijoux();
        Bijoux b1 = new Bijoux();
        Bijoux b2 = new Bijoux();
        b.setNom("Bracelet");
        b.set(40);
        b1.setNom("Boucle");
        b1.set(30);
        b2.setNom("Collier");
        b2.set(10);

        BijouxDao BijDao = new BijouxDao();
        BijDao.ajouter(b);        
        BijDao.ajouter(b1);
        BijDao.ajouter(b2);

        System.out.println("Appel de la méthode listerTous");

        for (Bijoux bj : BijDao.listerTous())
            System.out.println(bj.getId() + " " + bj.getNom() + " " + bj.get());

        System.out.println("Appel de la méthode listerParNom");

        for (Bijoux bj : BijDao.listerParNom("Boucle"))
            System.out.println(bj.getId() + " " + bj.getNom());
     // Test de la méthode supprimer
        Bijoux bi = new Bijoux();
        bi = BijDao.consulter(bi, 6);
        System.out.println("Suppression avec l'id " + bi.getId());
        BijDao.supprimer(bi);
        
        // Vérifier que la Bijoux a été supprimée 
        System.out.println("Après suppression, listerTous:");
        for (Bijoux bj : BijDao.listerTous())
            System.out.println(bj.getId() + " " + bj.getNom());
        
        // Test de la méthode modifier
        System.out.println("Modification avec l'id " + b2.getId());
        b2.setNom("Bracelet AI");
        b2.set(70);
        BijDao.modifier(b2);
        
        // Vérifier que bijoux a été modifiée 
        System.out.println("Après modification, listerTous:");
        for (Bijoux bj : BijDao.listerTous())
            System.out.println(bj.getId() + " " + bj.getNom());

    }       
}
