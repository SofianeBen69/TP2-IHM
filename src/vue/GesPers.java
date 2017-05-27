/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import conteneurGenerique.Conteneur;
import javax.swing.JOptionPane;
import personnel.*;

/**
 *
 * @author sofiane
 */
public class GesPers extends javax.swing.JFrame {

    private Conteneur<String, Personnel> leConteneur ;	
    

    

    
    private enum TypePersonnel {EMPLOYE, COMMERCIAL, DIRECTEUR};
    private TypePersonnel typePersonnel;
    private enum ModeCourant {AFFICHAGE, SAISIE, RECHERCHE};
    private ModeCourant modeCourant;
    /**
     * Creates new form GesPers
     */
    public GesPers() {
        initComponents();
        this.modeAffichage();
        
         
         Personnel p1=new Employe("Sofiane","0609931992",40.f,12);
         Personnel p2=new Commercial("Eric","0609931992",15.f,12,12,36);
         Personnel p3=new Directeur("Julien","0609931992",57.f);
         leConteneur=new Conteneur<>();
         leConteneur.ajouter(p1.getNumPers(), p1);
         leConteneur.ajouter(p2.getNumPers(),p2);
         leConteneur.ajouter(p3.getNumPers(),p3);
         this.afficher(); 
    }

    private void effacer() {
    jt_indemn.setText("");
    jt_matri.setText("");
    jt_montant.setText("");
    jt_nbHeures.setText("");
    jt_nom.setText("");
    jt_pourcen.setText("");
    jt_taux.setText("");
    jt_tel.setText("");
    jt_ventes.setText("");
    }
    
    private void modeAffichage() {
 jb_creer.setEnabled(true);
 jb_supprimer.setEnabled(true);
 jt_matri.setEnabled(false);
 jb_chercher.setVisible(true);
 jb_chercher.setEnabled(true);
 jt_nom.setEnabled(false);
 jt_tel.setEnabled(false);
 jt_taux.setEnabled(false);
 jt_nbHeures.setEnabled(false);
 jt_indemn.setEnabled(false);
 jt_ventes.setEnabled(false);
 jt_pourcen.setEnabled(false);
 jt_montant.setEnabled(false);
 jr_emp.setEnabled(false);
 jr_comm.setEnabled(false);
 jr_dir.setEnabled(false);
 jb_suivant.setEnabled(true);
 jb_recule.setEnabled(true);
 jb_debut.setEnabled(true);
 jb_fin.setEnabled(true);
    }
    private void afficher()
    {
        this.effacer(); 
        jl_nbCont.setText("Nombre d'objets présent dans le conteneur : "+ leConteneur.nbElements());
        if(leConteneur.nbElements()>0)
        {
            if (leConteneur.getCleCourante()==null) leConteneur.suivant();
            Personnel p=leConteneur.obtenir(leConteneur.getCleCourante());
            jt_nom.setText(p.getNomPers());
            jt_tel.setText(p.getNumTel());
            jt_matri.setText(p.getNumPers());
            if (p instanceof Commercial) 
            {
                Commercial c=(Commercial) p;
                jt_taux.setText(Float.toString(c.getTaux()));
                jt_nbHeures.setText(Float.toString(c.getNbHeures()));
                jt_indemn.setEnabled(false);
                jt_ventes.setText(Float.toString(c.getVentes()));
                jt_pourcen.setText(Float.toString(c.getPourcentage()));
                jt_montant.setText(Float.toString(((Employe)c).calculPaie()*c.getVentes()));
            }
            
            else if (p instanceof Employe)
           {
               Employe c=(Employe) p;
                jt_taux.setText(Float.toString(c.getTaux()));
                jt_nbHeures.setText(Float.toString(c.getNbHeures()));
                jt_indemn.setEnabled(false);
                jt_ventes.setEnabled(false);
                jt_pourcen.setEnabled(false);
                jt_montant.setText(Float.toString(c.calculPaie()));
           }
           
            else if (p instanceof Directeur)
           {
               Directeur c=(Directeur) p;
                jt_taux.setEnabled(false);
                jt_nbHeures.setEnabled(false);
                jt_indemn.setText(Float.toString(c.getIndemnites()));
                jt_ventes.setEnabled(false);
                jt_pourcen.setEnabled(false);
                jt_montant.setText(Float.toString(c.calculPaie()));
           }
            
            
        }
    }
  
    private void modeRecherche() {
    this.effacer();
    jb_supprimer.setEnabled(false);
    jt_indemn.setEnabled(false);
    jt_montant.setEnabled(false);
    jt_nbHeures.setEnabled(false);
    jt_nom.setEnabled(false);
    jt_pourcen.setEnabled(false);
    jt_taux.setEnabled(false);
    jt_tel.setEnabled(false);
    jt_ventes.setEnabled(false);
 
    jb_debut.setEnabled(false);
    jb_recule.setEnabled(false);
    jb_suivant.setEnabled(false);
    jb_fin.setEnabled(false);
    
 jt_matri.setEnabled(true); // on le rend actif
 jt_matri.setEditable(true); // et editable
 // on donne le focus au cham Matricule
 if (!jt_matri.isFocusable()) {
 jt_matri.setFocusable(true);
 }
 jt_matri.requestFocus();
    }
    
    private void rechercher()
    {
        String res=jt_matri.getText();
        leConteneur.premier();
        
        int i=1;
        while(i<=leConteneur.nbElements())
        {
            if (leConteneur.obtenir(leConteneur.getCleCourante()).getNumPers().equals(res))
            {
                modeAffichage();
                afficher();
                jb_chercher.setText("Chercher");
                break;
                
            }
            leConteneur.suivant();
           i++;
                
            
        }
        
        if (i>leConteneur.nbElements()){
            
          JOptionPane.showMessageDialog(this, 
         "message\n Attention personnel inéxistant",
         " Warning ",
         JOptionPane.WARNING_MESSAGE);
        }
        
        
    }
    
    
    private void modeSaisie() {
jb_fin.setEnabled(false);
 jt_matri.setEnabled(false);
 jt_nom.setEnabled(true);
 jt_tel.setEnabled(true);
 jb_chercher.setVisible(false);
 jr_emp.setEnabled(true);
 jr_comm.setEnabled(true);
 jr_dir.setEnabled(true);
 jr_emp.setSelected(true);
 jb_creer.setEnabled(true);
 jb_creer.setText("Ajouter");
 jb_creer.setToolTipText("Ajouter ce nouveau Personnel");
 jb_chercher.setEnabled(false);
 jb_supprimer.setEnabled(false);
 jb_debut.setEnabled(false);
 jb_recule.setEnabled(false);
 jb_suivant.setEnabled(false);
 typePersonnel=TypePersonnel.EMPLOYE;
    }
    
     private void saisir() {

 if (typePersonnel == TypePersonnel.EMPLOYE) {
   jt_taux.setEnabled(true);
    jt_nbHeures.setEnabled(true);
   jt_indemn.setEnabled(false);
    jt_ventes.setEnabled(false);
    jt_pourcen.setEnabled(false);
   jt_montant.setEnabled(false);

} else if (typePersonnel == TypePersonnel.COMMERCIAL) {
 jt_taux.setEnabled(true);
    jt_nbHeures.setEnabled(true);
   jt_indemn.setEnabled(false);
    jt_ventes.setEnabled(true);
    jt_pourcen.setEnabled(true);
   jt_montant.setEnabled(false);}
 else
{
    jt_taux.setEnabled(false);
    jt_nbHeures.setEnabled(false);
   jt_indemn.setEnabled(true);
    jt_ventes.setEnabled(false);
    jt_pourcen.setEnabled(false);
   jt_montant.setEnabled(false);
}
     }
     
     private void ajouter()
     {
         if (typePersonnel==TypePersonnel.COMMERCIAL)
         {
             String nom=jt_nom.getText();
             String num=jt_tel.getText();
             float taux=Float.parseFloat(jt_taux.getText());
             float heure=Float.parseFloat(jt_nbHeures.getText());
             float val=Float.parseFloat(jt_pourcen.getText());
             float ventes=Float.parseFloat(jt_ventes.getText());
             
             Commercial c = new Commercial(nom,num,taux,heure,val,ventes);
             leConteneur.ajouter(c.getNumPers(),c);
         }
         else if (typePersonnel==TypePersonnel.EMPLOYE)
         {
             String nom=jt_nom.getText();
             String num=jt_tel.getText();
             float taux=Float.parseFloat(jt_taux.getText());
             float heure=Float.parseFloat(jt_nbHeures.getText());
            
             
             Employe c = new Employe(nom,num,taux,heure);
             leConteneur.ajouter(c.getNumPers(),c);
         }
         else 
         {
             String nom=jt_nom.getText();
             String num=jt_tel.getText();
             float indem=Float.parseFloat(jt_indemn.getText());
             
            
             
             Directeur c = new Directeur(nom,num,indem);
             leConteneur.ajouter(c.getNumPers(),c);
         }
     }
 
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        buttonGroup1 = new javax.swing.ButtonGroup();
        icon1 = new javax.swing.JLabel();
        icon2 = new javax.swing.JLabel();
        jp_infoGene = new javax.swing.JPanel();
        jl_nom = new javax.swing.JLabel();
        jt_nom = new javax.swing.JTextField();
        jl_tel = new javax.swing.JLabel();
        jt_tel = new javax.swing.JTextField();
        jl_Matricule = new javax.swing.JLabel();
        jt_matri = new javax.swing.JTextField();
        jp_choix = new javax.swing.JPanel();
        jr_emp = new javax.swing.JRadioButton();
        jr_comm = new javax.swing.JRadioButton();
        jr_dir = new javax.swing.JRadioButton();
        jp_info = new javax.swing.JPanel();
        jl_taux = new javax.swing.JLabel();
        jl_nbHeure = new javax.swing.JLabel();
        jl_indem = new javax.swing.JLabel();
        jl_ventes = new javax.swing.JLabel();
        jl_pourcen = new javax.swing.JLabel();
        jl_montant = new javax.swing.JLabel();
        jt_taux = new javax.swing.JTextField();
        jt_ventes = new javax.swing.JTextField();
        jt_nbHeures = new javax.swing.JTextField();
        jt_pourcen = new javax.swing.JTextField();
        jt_indemn = new javax.swing.JTextField();
        jt_montant = new javax.swing.JTextField();
        jp_gestion = new javax.swing.JPanel();
        jb_chercher = new javax.swing.JButton();
        jb_supprimer = new javax.swing.JButton();
        jb_creer = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jl_nbCont = new javax.swing.JLabel();
        jp_nav = new javax.swing.JPanel();
        jb_debut = new javax.swing.JButton();
        jb_recule = new javax.swing.JButton();
        jb_suivant = new javax.swing.JButton();
        jb_fin = new javax.swing.JButton();
        jmb_1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jmi_charger = new javax.swing.JMenuItem();
        jmi_sauvegarder = new javax.swing.JMenuItem();
        jmi_creer = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("GesPers");

        icon1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo1.gif"))); // NOI18N

        icon2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo2.gif"))); // NOI18N

        jp_infoGene.setBorder(javax.swing.BorderFactory.createTitledBorder("Informations Générales"));
        jp_infoGene.setToolTipText("");
        jp_infoGene.setName("Informations Générales"); // NOI18N

        jl_nom.setText("Nom");

        jt_nom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jt_nomActionPerformed(evt);
            }
        });

        jl_tel.setText("Telephone");

        jt_tel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jt_telActionPerformed(evt);
            }
        });

        jl_Matricule.setText("Matricule");

        javax.swing.GroupLayout jp_infoGeneLayout = new javax.swing.GroupLayout(jp_infoGene);
        jp_infoGene.setLayout(jp_infoGeneLayout);
        jp_infoGeneLayout.setHorizontalGroup(
            jp_infoGeneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_infoGeneLayout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(jp_infoGeneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jl_nom)
                    .addComponent(jl_tel))
                .addGap(34, 34, 34)
                .addGroup(jp_infoGeneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jp_infoGeneLayout.createSequentialGroup()
                        .addComponent(jt_tel, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(117, 117, 117)
                        .addComponent(jl_Matricule)
                        .addGap(45, 45, 45)
                        .addComponent(jt_matri, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jt_nom, javax.swing.GroupLayout.PREFERRED_SIZE, 539, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(56, Short.MAX_VALUE))
        );
        jp_infoGeneLayout.setVerticalGroup(
            jp_infoGeneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_infoGeneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jp_infoGeneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jl_nom)
                    .addComponent(jt_nom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(jp_infoGeneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jl_tel)
                    .addComponent(jt_tel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jl_Matricule)
                    .addComponent(jt_matri, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26))
        );

        jp_choix.setBorder(javax.swing.BorderFactory.createTitledBorder("Choix du type de l'employé"));

        buttonGroup1.add(jr_emp);
        jr_emp.setText("Employé");
        jr_emp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jr_empActionPerformed(evt);
            }
        });

        buttonGroup1.add(jr_comm);
        jr_comm.setText("Commercial");
        jr_comm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jr_commActionPerformed(evt);
            }
        });

        buttonGroup1.add(jr_dir);
        jr_dir.setText("Directeur");
        jr_dir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jr_dirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jp_choixLayout = new javax.swing.GroupLayout(jp_choix);
        jp_choix.setLayout(jp_choixLayout);
        jp_choixLayout.setHorizontalGroup(
            jp_choixLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_choixLayout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addComponent(jr_emp, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(80, 80, 80)
                .addComponent(jr_comm)
                .addGap(140, 140, 140)
                .addComponent(jr_dir)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jp_choixLayout.setVerticalGroup(
            jp_choixLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_choixLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jp_choixLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jr_emp)
                    .addComponent(jr_comm)
                    .addComponent(jr_dir))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jp_info.setBorder(javax.swing.BorderFactory.createTitledBorder("Informations pour le calcul de la rémunération"));

        jl_taux.setText("Taux horraire");

        jl_nbHeure.setText("Nombre d'heures");

        jl_indem.setText("Indemnités");

        jl_ventes.setText("Ventes");

        jl_pourcen.setText("Pourcentage");

        jl_montant.setText("Montant brut");

        jt_ventes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jt_ventesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jp_infoLayout = new javax.swing.GroupLayout(jp_info);
        jp_info.setLayout(jp_infoLayout);
        jp_infoLayout.setHorizontalGroup(
            jp_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_infoLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jp_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jl_taux)
                    .addComponent(jl_nbHeure)
                    .addComponent(jl_indem))
                .addGap(61, 61, 61)
                .addGroup(jp_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jt_indemn, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
                    .addComponent(jt_nbHeures, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jt_taux, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jp_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jl_montant, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jp_infoLayout.createSequentialGroup()
                        .addComponent(jl_ventes)
                        .addGap(32, 32, 32))
                    .addComponent(jl_pourcen, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(jp_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jt_ventes, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
                    .addComponent(jt_pourcen, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jt_montant))
                .addContainerGap())
        );
        jp_infoLayout.setVerticalGroup(
            jp_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_infoLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jp_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jl_taux)
                    .addComponent(jl_ventes)
                    .addComponent(jt_taux, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jt_ventes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jp_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jt_pourcen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jl_pourcen)
                    .addComponent(jt_nbHeures, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jl_nbHeure))
                .addGap(18, 18, 18)
                .addGroup(jp_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jt_indemn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jl_indem)
                    .addComponent(jl_montant)
                    .addComponent(jt_montant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 16, Short.MAX_VALUE))
        );

        jp_gestion.setBorder(javax.swing.BorderFactory.createTitledBorder("Gestion du conteneur"));

        jb_chercher.setText("Chercher");
        jb_chercher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_chercherActionPerformed(evt);
            }
        });

        jb_supprimer.setText("Supprimer");
        jb_supprimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_supprimerActionPerformed(evt);
            }
        });

        jb_creer.setText("Creer");
        jb_creer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_creerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jp_gestionLayout = new javax.swing.GroupLayout(jp_gestion);
        jp_gestion.setLayout(jp_gestionLayout);
        jp_gestionLayout.setHorizontalGroup(
            jp_gestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_gestionLayout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(jb_chercher, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(129, 129, 129)
                .addComponent(jb_supprimer, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jb_creer, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(90, 90, 90))
            .addGroup(jp_gestionLayout.createSequentialGroup()
                .addGroup(jp_gestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jp_gestionLayout.createSequentialGroup()
                        .addGap(193, 193, 193)
                        .addComponent(jLabel1))
                    .addGroup(jp_gestionLayout.createSequentialGroup()
                        .addGap(243, 243, 243)
                        .addComponent(jl_nbCont)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jp_gestionLayout.setVerticalGroup(
            jp_gestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_gestionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jp_gestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jl_nbCont)
                    .addGroup(jp_gestionLayout.createSequentialGroup()
                        .addGroup(jp_gestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jp_gestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jb_supprimer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jb_creer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jb_chercher, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jp_nav.setBorder(javax.swing.BorderFactory.createTitledBorder("Navigation dans le conteneur"));

        jb_debut.setText("Début");
        jb_debut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_debutActionPerformed(evt);
            }
        });

        jb_recule.setText("<<");
        jb_recule.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_reculeActionPerformed(evt);
            }
        });

        jb_suivant.setText(">>");
        jb_suivant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_suivantActionPerformed(evt);
            }
        });

        jb_fin.setText("Fin");
        jb_fin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_finActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jp_navLayout = new javax.swing.GroupLayout(jp_nav);
        jp_nav.setLayout(jp_navLayout);
        jp_navLayout.setHorizontalGroup(
            jp_navLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_navLayout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jb_debut, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addComponent(jb_recule, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addComponent(jb_suivant, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addComponent(jb_fin, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jp_navLayout.setVerticalGroup(
            jp_navLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_navLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jp_navLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jb_recule)
                    .addComponent(jb_suivant)
                    .addComponent(jb_fin)
                    .addComponent(jb_debut))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        jMenu2.setText("Fichier");

        jmi_charger.setText("charger");
        jmi_charger.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmi_chargerActionPerformed(evt);
            }
        });
        jMenu2.add(jmi_charger);

        jmi_sauvegarder.setText("sauvegarder");
        jmi_sauvegarder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmi_sauvegarderActionPerformed(evt);
            }
        });
        jMenu2.add(jmi_sauvegarder);

        jmi_creer.setText("creer");
        jMenu2.add(jmi_creer);

        jmb_1.add(jMenu2);

        jMenu3.setText("?");
        jmb_1.add(jMenu3);

        setJMenuBar(jmb_1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(icon1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(icon2)
                .addGap(191, 191, 191))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jp_infoGene, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jp_choix, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jp_info, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jp_gestion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jp_nav, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(icon1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(icon2)))
                .addGap(18, 18, 18)
                .addComponent(jp_infoGene, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jp_choix, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jp_info, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jp_gestion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jp_nav, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jp_infoGene.getAccessibleContext().setAccessibleName("Informations générales");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jt_nomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jt_nomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jt_nomActionPerformed

    private void jt_telActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jt_telActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jt_telActionPerformed

    private void jr_commActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jr_commActionPerformed
typePersonnel = TypePersonnel.COMMERCIAL;
 this.saisir();        
    }//GEN-LAST:event_jr_commActionPerformed

    private void jt_ventesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jt_ventesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jt_ventesActionPerformed

    private void jb_chercherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_chercherActionPerformed
if (jb_chercher.getText().compareTo("Chercher") == 0) {       
    this.modeRecherche();
     jb_chercher.setText("Rechercher dans le Conteneur");
     jb_creer.setEnabled(false);
   
}
 else {

 this.rechercher(); 
 
 
 }
    }//GEN-LAST:event_jb_chercherActionPerformed

    private void jb_debutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_debutActionPerformed
leConteneur.premier();
 this.afficher();        // TODO add your handling code here:
    }//GEN-LAST:event_jb_debutActionPerformed

    private void jb_finActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_finActionPerformed
leConteneur.dernier();
this.afficher();// TODO add your handling code here:
    }//GEN-LAST:event_jb_finActionPerformed

    private void jmi_sauvegarderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmi_sauvegarderActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jmi_sauvegarderActionPerformed

    private void jb_creerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_creerActionPerformed
if (jb_creer.getText().compareTo("Ajouter") == 0) {       
    this.ajouter();
     jb_creer.setText("Creer");
    this.modeAffichage();
    this.afficher();
}
 else {

 this.effacer(); 
 this.modeSaisie();
 this.saisir();
 }
    }//GEN-LAST:event_jb_creerActionPerformed

    private void jr_empActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jr_empActionPerformed
typePersonnel = TypePersonnel.EMPLOYE;
 this.saisir();        
    }//GEN-LAST:event_jr_empActionPerformed

    private void jr_dirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jr_dirActionPerformed
typePersonnel = TypePersonnel.DIRECTEUR;
 this.saisir();       
    }//GEN-LAST:event_jr_dirActionPerformed

    private void jb_supprimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_supprimerActionPerformed
leConteneur.supprimer(leConteneur.getCleCourante()); 


leConteneur.premier();
this.afficher();// TODO add your handling code here:
    }//GEN-LAST:event_jb_supprimerActionPerformed

    private void jb_reculeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_reculeActionPerformed
leConteneur.precedent();
this.afficher();// TODO add your handling code here:
    }//GEN-LAST:event_jb_reculeActionPerformed

    private void jb_suivantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_suivantActionPerformed
leConteneur.suivant();
this.afficher();// TODO add your handling code here:
    }//GEN-LAST:event_jb_suivantActionPerformed

    private void jmi_chargerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmi_chargerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jmi_chargerActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GesPers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GesPers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GesPers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GesPers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GesPers().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel icon1;
    private javax.swing.JLabel icon2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JButton jb_chercher;
    private javax.swing.JButton jb_creer;
    private javax.swing.JButton jb_debut;
    private javax.swing.JButton jb_fin;
    private javax.swing.JButton jb_recule;
    private javax.swing.JButton jb_suivant;
    private javax.swing.JButton jb_supprimer;
    private javax.swing.JLabel jl_Matricule;
    private javax.swing.JLabel jl_indem;
    private javax.swing.JLabel jl_montant;
    private javax.swing.JLabel jl_nbCont;
    private javax.swing.JLabel jl_nbHeure;
    private javax.swing.JLabel jl_nom;
    private javax.swing.JLabel jl_pourcen;
    private javax.swing.JLabel jl_taux;
    private javax.swing.JLabel jl_tel;
    private javax.swing.JLabel jl_ventes;
    private javax.swing.JMenuBar jmb_1;
    private javax.swing.JMenuItem jmi_charger;
    private javax.swing.JMenuItem jmi_creer;
    private javax.swing.JMenuItem jmi_sauvegarder;
    private javax.swing.JPanel jp_choix;
    private javax.swing.JPanel jp_gestion;
    private javax.swing.JPanel jp_info;
    private javax.swing.JPanel jp_infoGene;
    private javax.swing.JPanel jp_nav;
    private javax.swing.JRadioButton jr_comm;
    private javax.swing.JRadioButton jr_dir;
    private javax.swing.JRadioButton jr_emp;
    private javax.swing.JTextField jt_indemn;
    private javax.swing.JTextField jt_matri;
    private javax.swing.JTextField jt_montant;
    private javax.swing.JTextField jt_nbHeures;
    private javax.swing.JTextField jt_nom;
    private javax.swing.JTextField jt_pourcen;
    private javax.swing.JTextField jt_taux;
    private javax.swing.JTextField jt_tel;
    private javax.swing.JTextField jt_ventes;
    // End of variables declaration//GEN-END:variables
}
