/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conteneurGenerique;

import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author sofiane
 */
public class Conteneur <K extends Comparable<K> & Serializable, V extends Serializable>{
    
    private TreeMap<K,V> tM;
    private K cleCourante;
            
     /**
      * Constructeur de classe avec 1 argument
      * @param t instande treeMap
      */   
     public Conteneur(TreeMap<K, V> t){
		tM =t;
		cleCourante=null;
	}
     
     /**
      * Constructeur de classe sans arguments
      */
     public Conteneur() {
		tM = new TreeMap<K, V>();
		cleCourante=null;
	}

     
     
        /**
         * ajoute un élément dans le conteneur
         * @param cle
         * @param valeur
         * @return true si la clé et la valeur sont ajoutés
         */     
        public boolean ajouter(K cle, V valeur){
        if (tM.containsKey(cle))
             return false;
        tM.put(cle, valeur);
        return true;
        }
        
           /**
     * Lecture binaire du TreeMap depuis un fichier
     * Les types K et V doivent donc être sérialisables.
     * @param nomFic nom du fichier source
     * instancie la clef courante sur le dernier matricule.
     * 
     **/
           public void charger(String nomFic){
        
        try {
            
            File f1 = new File(nomFic); 
            FileInputStream fe = new FileInputStream(f1);
            try (ObjectInputStream feObj = new ObjectInputStream(fe)) {
                
// On lit un Object, il faut le convertir au type attendu, ici un TreeMap :
                tM = (TreeMap<K, V>) feObj.readObject();
// NOTA : peut lever une ClassNotFound Exception si le contenu n’est pas celui d’un TreeMap

            }
            
            if (!tM.isEmpty())          // on instancie la clef courante
                cleCourante = tM.lastKey();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conteneur.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("ERREUR : le contenu du fichier ne peut pas etre "
                    + "converti dans le TreeMap attendu");
            
        } catch(IOException e) {
            System.out.println("Fichier inaccessible !");
        }
           }
    

        /**
         * @return la plus grande des clés
         */
        
        public K cleMax(){
                return tM.lastKey();
        }
        
        /**
         * @return la plus petite des clés
         */
        public K cleMin(){
                return tM.firstKey();
        }
        
        /**
         * renvoie la clé de l'élément précédent dans l'ordre des clés et se positionne dessus
         * @return clé de l'élément précédent
         */
        public K clePrecedente(){
              if (cleCourante==null) return cleCourante;
              
              cleCourante=tM.lowerKey(cleCourante);
              return cleCourante;
                  
        }
        
        /**
         * renvoie la clé de l'élément suivant dans l'ordre des clés et se positionne dessus
         * @return clé de l'élément suivant
         */       
        public K cleSuivante(){
               if (cleCourante==null)
               {
                   cleCourante=tM.firstKey();
                   return cleCourante;
               }
               cleCourante=tM.higherKey(cleCourante);
               return cleCourante;
        }
        
        /**
         * positionnement sur le dernier élément du conteneur
         */
        public void dernier(){
                this.cleCourante = tM.lastKey();
        }
        
        /**
        * indique si le conteneur est vide
        */
        public boolean estVide(){
                return tM.size()==0;
        }
        
        /**
        * renvoie la clé de l'objet courant 
        */
        public K getCleCourante(){
                return cleCourante;
        }
        
        /**
         * indique si la clé existe dans le conteneur
         * @param cle dont on teste l'existence
         * @return true si la clé existe
         */
        public boolean existe(K cle){
                return tM.containsKey(cle);
        }
        
        /**
         * @return le nombre d'objets présents dans le conteneur
         */
        public int nbElements(){
                return tM.size();
        }
        
        /**
         * renvoie l'objet de clé K dans le conteneur ou bien NULL si la clé existe pas
         * @param cle dont on veut la valeur
         * @return la valeur situé sur cette clé
         */
        public V obtenir(K cle){
                 return tM.get(cle);
        }
        
        /**
         * positionnement de la clé si ele existe
         * @param cle sur laquelle on veut se positionner
         */
        public void positionner(K cle){
              if (tM.containsKey(cle))
              cleCourante = cle;
        }
        
        /**
         * positionnement sur l'élément précédent dans l'ordre des clés
         */
        public void precedent(){
          if (cleCourante==null) return;
           cleCourante=tM.lowerKey(cleCourante);
        }   
        
        /**
         * positionnement sur le premier élément du conteneur
         */
        public void premier(){
                cleCourante = tM.firstKey();
        }
        
        //sérialisation - le type V doit être Serializable
    /**
    * Serialise (écriture binaire) du TreeMap dans un fichier 
    * @param nomFic nom du fichier cible
    *
    **/ 
        public void sauvegarder(java.lang.String nomFic){
                        try {
            File f1 = new File(nomFic); 
            FileOutputStream fs = new FileOutputStream(f1);
            ObjectOutputStream fsObj = new ObjectOutputStream(fs);
            
            fsObj.writeObject(tM); // Ecriture du conteneur en une fois
            fsObj.close(); //On ferme le flot
            
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }

        }
        
        /**
         * positionnement sur l'élément suivant dans l'ordre des clés
         */
        public void suivant(){
          if (cleCourante==null) cleCourante=tM.firstKey();
          else cleCourante=tM.higherKey(cleCourante);
        }
        
        /**
         * supprime du conteneur l'élément à partir de la clé
         * @param cle dont veut supprimer
         */
        public void supprimer(K cle){
                tM.remove(cle);
        }
        
        /**
         * vide le contenu du  conteneur
         */
        public void vider(){
                tM.clear();
        }
        

}



