/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import conteneurGenerique.Conteneur;

/**
 *
 * @author sofiane
 */
public class TP2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
Conteneur<Integer,String> cont=new Conteneur<>();
cont.ajouter(1, "ll");
cont.ajouter(2, "mr");
System.out.println(cont.cleSuivante());
System.out.println(cont.cleSuivante());
System.out.println(cont.clePrecedente());




        
        }
    
}


