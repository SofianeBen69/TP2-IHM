package personnel;

/**
 * @author vde
 */
public final class Directeur extends Personnel {

    private float indemnite;
    private float prime;

    private static final long serialVersionUID = 10L;
    // for deserialization compatibility : à chq modification de la classe,
    // on affectera un numero différent

    /**
     * donne la prime d'un directeur
     */
    public float getPrime() {
        return prime;
    }

    /**
     * donne les indemnites d'un directeur
     */
    public float getIndemnites() {
        return indemnite;
    }

    /**
     * constructeur d'un directeur
     */
    public Directeur(String nom, String numero, float valIndemnite) {

        super(nom, numero);
        indemnite = valIndemnite;
        
    }

    /**
     * calcul de la paie du Directeur : la somme de l'indemenité et
     * de la prime
     */
    @Override
    public float calculPaie() {
        return indemnite ;
    }

} // Directeur
