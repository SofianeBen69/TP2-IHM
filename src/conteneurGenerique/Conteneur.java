/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conteneurGenerique;

import java.io.*;
import java.util.*;
/**
 *
 * @author sofiane
 */
public class Conteneur <K extends Comparable<K> & Serializable, V extends Serializable>{
    
    private TreeMap<K,V> tM;
    private K cleCourante;
            
     //Constructeur       
     public Conteneur(TreeMap<K, V> t){
		tM =t;
		cleCourante=null;
	}
     
     public Conteneur() {
		tM = new TreeMap<K, V>();
		cleCourante=null;
	}
       //ajoute un élément dans le conteneur
        public boolean ajouter(K cle, V valeur){
                
        }
        
        //désérialisation depuis un fichier
        public void charger (java.lang.String nomFic){
                
        }
        
        //renvoie la plus grande des clés
        public K cleMax(){
                
        }
        
        //renvoie la plus petite des clés
        public K cleMin(){
                
        }
        
        //renvoie la clé de l'élément précédent dans l'ordre des clés et se positionne dessus
        public K clePrecedente(){
                
        }
        
        //renvoie la clé de l'élément suivant dans l'ordre des clés et se positionne dessus
        public K cleSuivante(){
                
        }
        
        //positionnement sur le dernier élément du conteneur
        public void dernier(){
                
        }
        
        //indique si le conteneur est vide
        public boolean estVide(){
                
        }
        
        //renvoie la clé de l'objet courant 
        public K getCleCourante(){
                
        }
        
        //indique si la clé existe dans le conteneur
        public boolean existe(K cle){
                
        }
        
        //renvoie le nombre d'objets présents dans le conteneur
        public int nbElements(){
                
        }
        
        //renvoie l'objet de clé K dans le conteneur ou bien NULL
        public V obtenir(K cle){
                
        }
        
        //positionnement de la clé si ele existe
        public void positionner(K cle){
                
        }
        
        //positionnement sur lélément précédent dans l'ordre des clés
        public void precedent(){
                
        }
        
        //positionnement sur le premier élément du conteneur
        public void premier(){
                
        }
        
        //sérialisation - le type V doit être Serializable
        public void sauvegarder(java.lang.String nomFic){
                
        }
        
        //positionnement sur l'élément suivant dans l'ordre des clés
        public void suivant(){
                
        }
        
        //supprime du conteneur l'élément à partir de la clé
        public void supprimer(K cle){
                
        }
        
        //vide le contenu du  conteneur
        public void vider(){
                
        }

}



