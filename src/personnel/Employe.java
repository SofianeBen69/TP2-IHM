package personnel;

/**
 * @author vde
 */
public class Employe extends Personnel {

    // attributs propres à lEmploye
    private float tauxHoraire;
    private float nbHeures;
    
    private static final long serialVersionUID = 10L;
    // for deserialization compatibility : à chq modification de la classe,
    // on affectera un numero différent

    //  donne le taux d'un employe
    public float getTaux() {
        return tauxHoraire;
    }

    // nombre d'heures d'un employe
    public float getNbHeures() {
        return nbHeures;
    }

    // constructeur d'un employe
    public Employe(String nom, String numero, float valTaux, float heures) {
        super(nom, numero);
        tauxHoraire = valTaux;
        nbHeures = heures;
    }

    // calcul de la paie de l'employe
    @Override
    public float calculPaie() {
        return tauxHoraire * nbHeures;
    }

} // Employe
