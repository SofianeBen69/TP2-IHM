/*
 * classe abstraite Personnel.java
 * possède la meth abstraite calculPaie()
 */

package personnel;

import java.io.*;
/**
 * @author VDe + APi
 */

public abstract class Personnel implements Comparable<Personnel>, Serializable {
    // attributs d'instance
    private String numPers;
    private String nomPers;
    private String numTel;

    // attribut et methode de classe
    private static int dernierAttribue=1000;
    // methode de classe
    private static void setDernierAttribue(int val) {
        dernierAttribue=val;
    }
    public static void resetDernierAttribue() {
        dernierAttribue=1000;
    }
    // constructeur de la classe abstraite Personnel
    public Personnel(String nom, String numero){
        numPers = 'M' + String.valueOf(++dernierAttribue);
        nomPers = nom;
        numTel  = numero;
    }

    /** methode d'instance
     *  pour affecter le plus grand matricule au champ statique 'dernierAttribue'
     *  appelle setDernierAttribue()
     **/
    public void fixerDernierAttribue() {
        // rappel : numPers a la forme 'M1002'
        int val = Integer.parseInt(numPers.substring(1));
        if (val > dernierAttribue)
            Personnel.setDernierAttribue(val);
    }

    // recupere le numero d'affectation d'un personnel
    public String getNumPers() { return numPers;}

    // recupere le nom d'affectation d'un personnel
    public String getNomPers() {return nomPers;}

    // recupere le tel d'affectation d'un personnel
    public String getNumTel()  {return numTel;}

    // methode abstraite
    public abstract float calculPaie();

    // methode pour comparer les personnels
    @Override
    public int compareTo(Personnel p){
        return numPers.compareTo(((Personnel)p).numPers);
    }

    /**
     * Methode qui teste l'egalite de 2 personnes
     * @param p la personne avec qui comparer l'instance
     * @return true si les 2 personnes ont même numero matricule, false sinon
     **/
    public boolean equals(Personnel p){
        return numPers.equals(p.numPers);
    }
    
    /** Methode hashcode() coherente avec equals
     * @return le nouveau hashcode calculé sur le numPers
     **/ 
    public int hashcode(){
        return this.numPers.hashCode()/11;
    }

    // methode toString /
    @Override
    public String toString(){
        return this.getClass().getName();
    }

} // Personnel
