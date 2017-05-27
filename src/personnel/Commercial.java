package personnel;

/**
 * @author vde
 */
public final class Commercial extends Employe {

    private static final long serialVersionUID = 10L;
    // for deserialization compatibility : à chq modification de la classe,
    // on affectera un numero différent

    private float pourcentage;
    private float ventes;

    /**
     * get le pourcentage sur la vente que touche un commercial
     */
    public float getPourcentage() {
        return pourcentage;
    }

    /**
     *  get le montant des ventes d'un commercial
     */
    public float getVentes() {
        return ventes;
    }

    /**
     * constructeur d'un commercial
     */
    public Commercial(String nom, String numero, float valTaux, float Heures,
            float valPourcent, float valVentes) {
        
        super(nom, numero, valTaux, Heures);
        pourcentage = valPourcent;
        ventes = valVentes;
    }

    /**
     * Calcul de la paie du commercial : c'est la paie d'un employé
     * + un intéret sur les ventes
     */
    @Override
    public float calculPaie() {
        return super.calculPaie() + pourcentage * ventes / 100;
    }

} // Commercial
