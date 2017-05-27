/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conteneurGenerique;


import java.util.TreeMap;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author sofiane
 */
public class ConteneurTest {
    
   
    private Conteneur<Integer,String> emp=new Conteneur<Integer,String>();
    
    public ConteneurTest() {
        assertTrue(emp.getCleCourante()==null);
        
        
         TreeMap<Integer, String> treeMap = new TreeMap<>();
        assertTrue((new Conteneur<>(treeMap)).getCleCourante() == null);
    }

    
    
    /**
     * Test of ajouter method, of class Conteneur.
     */
    @Test
    public void testAjouter() {
        
        
       
        boolean expResult = emp.ajouter(1, "Sofiane");
        assertEquals(true, expResult);
        assertEquals("Sofiane", emp.obtenir(1));
        
        expResult=emp.ajouter(1, "Eric");
        assertEquals(false, expResult);
        assertEquals("Sofiane", emp.obtenir(1));

    }

   
    /**
     * Test of cleMax method, of class Conteneur.
     */
    @Test
    public void testCleMax() {
        emp.ajouter(2, "Eric");
        emp.ajouter(4, "Julien");
        int result=emp.cleMax();
        assertEquals(4, result);
    }

    /**
     * Test of cleMax method, of class Conteneur.
     */
    @Test
    public void testCleMin() {
        emp.ajouter(2, "Eric");
        emp.ajouter(4, "Julien");
        int result=emp.cleMin();
        assertEquals(2, result);
    }
   
    @Test
    public void testCleSuivante() {
        emp.ajouter(2, "Eric");
        emp.ajouter(4, "Julien");
        int result=emp.cleSuivante();
        assertEquals(2,result);
        assertTrue(emp.obtenir(emp.getCleCourante()).equals("Eric"));
    }
    
    @Test
    public void testClePrecedente() {
        emp.ajouter(2, "Eric");
        emp.ajouter(4, "Julien");
        emp.cleSuivante();
        emp.cleSuivante();
        int result=emp.clePrecedente();
        assertEquals(2,result);
        assertTrue(emp.obtenir(emp.getCleCourante()).equals("Eric"));
    }
    
    
  /**
     * Test of dernier method, of class Conteneur.
     */
    @Test
    public void testDernier() {
       emp.ajouter(2, "Eric");
        emp.ajouter(4, "Julien");
        emp.ajouter(8, "Johan");
        emp.dernier();
        int result=emp.getCleCourante();
        assertEquals(8,result);
    }

    /**
     * Test of estVide method, of class Conteneur.
     */
    @Test
    public void testEstVide() {
       assertTrue(emp.estVide());
        emp.ajouter(2, "Eric");
        emp.ajouter(4, "Julien");
        emp.ajouter(8, "Johan");
        assertTrue(emp.estVide()!=true);
        
    }

    /**
     * Test of getCleCourante method, of class Conteneur.
     */
    @Test
    public void testGetCleCourante() {
          emp.ajouter(2, "Eric");
        emp.ajouter(4, "Julien");
        emp.ajouter(8, "Johan");
        assertTrue(emp.getCleCourante()==null);
        emp.suivant();
        assertTrue(emp.getCleCourante()==2);
    }

    /**
     * Test of existe method, of class Conteneur.
     */
    @Test
    public void testExiste() {
         emp.ajouter(2, "Eric");
        emp.ajouter(4, "Julien");
        emp.ajouter(8, "Johan");
        assertTrue(emp.existe(2));
        assertTrue(emp.existe(5)!=true);
    }

    /**
     * Test of nbElements method, of class Conteneur.
     */
    @Test
    public void testNbElements() {
         emp.ajouter(2, "Eric");
        emp.ajouter(4, "Julien");
        emp.ajouter(8, "Johan");
        assertEquals(3,emp.nbElements());
    }

    /**
     * Test of obtenir method, of class Conteneur.
     */
    @Test
    public void testObtenir() {
         emp.ajouter(2, "Eric");
        assertEquals("Eric",emp.obtenir(2));
        assertTrue(emp.obtenir(3)==null);
    }

    /**
     * Test of positionner method, of class Conteneur.
     */
    @Test
    public void testPositionner() {
         emp.ajouter(2, "Eric");
        emp.ajouter(4, "Julien");
        emp.ajouter(8, "Johan");
        emp.positionner(4);
        assertEquals("Julien",emp.obtenir(emp.getCleCourante()));
    }

    /**
     * Test of precedent method, of class Conteneur.
     */
    @Test
    public void testPrecedent() {
         emp.ajouter(2, "Eric");
        emp.ajouter(4, "Julien");
        emp.ajouter(8, "Johan");
        emp.positionner(4);
        emp.precedent();
        assertTrue(emp.getCleCourante()==2);
    }

    /**
     * Test of premier method, of class Conteneur.
     */
    @Test
    public void testPremier() {
         emp.ajouter(2, "Eric");
        emp.ajouter(4, "Julien");
        emp.ajouter(8, "Johan");
        emp.positionner(4);
        emp.premier();
        assertTrue(emp.getCleCourante()==2);
    }

  

    /**
     * Test of suivant method, of class Conteneur.
     */
    @Test
    public void testSuivant() {
        emp.ajouter(2, "Eric");
        emp.ajouter(4, "Julien");
        emp.ajouter(8, "Johan");
        emp.positionner(4);
        emp.suivant();
        assertTrue(emp.getCleCourante()==8);
    }

    /**
     * Test of supprimer method, of class Conteneur.
     */
    @Test
    public void testSupprimer() {
        emp.ajouter(2, "Eric");
        emp.ajouter(4, "Julien");
        emp.ajouter(8, "Johan");
        emp.supprimer(4);
        assertTrue(emp.obtenir(4)==null);
    }

    /**
     * Test of vider method, of class Conteneur.
     */
    @Test
    public void testVider() {
        emp.ajouter(2, "Eric");
        emp.ajouter(4, "Julien");
        emp.ajouter(8, "Johan");
        emp.vider();
        assertTrue(emp.nbElements()==0);
        
        
    }
   
  

    

    
    
}
