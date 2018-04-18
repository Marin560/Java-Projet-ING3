/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbcv2018;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Roxane
 */
public class Accueil extends JFrame implements ActionListener, ItemListener {
    
    private Connexion maconnexion; //Ajout d'une nouvelle connexion
    private JLabel nameECE, passwdECE, loginBDD, passwdBDD, nameBDD;
    private JTextField nameECETexte, loginBDDTexte, nameBDDTexte;
    private JPasswordField passwdECETexte, passwdBDDTexte;
    private JButton connectECE, executer, connectlocal;
    private JPanel p0, p1, p2, p3;
    
    //Liste des noms de nos conteneurs pour les deux pages
  //String[] listContent = {"ConnexionLocale", "ConnexionECE"};
  //int indice = 0;
    
 
    public Accueil(){
        
        super("Accueil");
        
         // mise en page (layout) de la fenetre visible
        setLayout(new BorderLayout());
        setBounds(0, 0, 400, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);
        setVisible(true);

        // creation des boutons
        
        connectECE = new JButton("Connexion ECE");
        connectlocal = new JButton("Connexion locale");
        executer = new JButton("Executer");
        
        
        // creation des textes
        
        nameECETexte = new JTextField();
        passwdECETexte = new JPasswordField(8);
        loginBDDTexte = new JTextField();
        passwdBDDTexte = new JPasswordField(8);
        nameBDDTexte = new JTextField();
        
        //Création des labels
        
        nameECE = new JLabel("login ECE :", JLabel.CENTER);
        passwdECE = new JLabel("password ECE :", JLabel.CENTER);
        loginBDD = new JLabel("login base :", JLabel.CENTER);
        passwdBDD = new JLabel("password base :", JLabel.CENTER);
        nameBDD = new JLabel("nom base :", JLabel.CENTER);
        
        // Création des panneaux
        
        p0 = new JPanel();
        p1 = new JPanel();
        p2 = new JPanel();
        p3 = new JPanel();
        
        
        p0.setLayout(new GridLayout(0, 1,-5,5)); 
        //p1.setLayout(new GridLayout(0,1)); 
        //p2.setLayout(new GridLayout(5, 5)); 
        //p3.setLayout(new GridLayout(8, 8)); 
        
        p0.add(nameECE);
        p0.add(nameECETexte);
         p0.add(passwdECE);
        p0.add(passwdECETexte);
        p0.add(loginBDD);
        p0.add(loginBDDTexte);
        p0.add(passwdBDD);
        p0.add(passwdBDDTexte);
        p0.add(nameBDD);
        p0.add(nameBDDTexte);
        p0.add(connectECE);
        p0.add(connectlocal);
 
         
       
       
        
        /*
        p0.add(nameECE);
        p0.add(loginBDD);
        p1.add(nameECETexte);
        p1.add(loginBDDTexte);
        p2.add(passwdECE);
        p2.add(passwdBDD);
        p3.add(passwdECETexte);
        p3.add(passwdBDDTexte);
        */
        // ajout des listeners
        connectECE.addActionListener(this);
        executer.addActionListener(this);
        connectlocal.addActionListener(this);
        nameECETexte.addActionListener(this);
        passwdECETexte.addActionListener(this);
        loginBDDTexte.addActionListener(this);
        passwdBDDTexte.addActionListener(this);
        
        //this.getContentPane().add(p0, BorderLayout.NORTH);
        this.getContentPane().add(p0, BorderLayout.CENTER);
        this.getContentPane().add(p2, BorderLayout.CENTER);
        this.getContentPane().add(p2, BorderLayout.SOUTH);
        add("North", p0); 
        add("Center", p1); 
        add("Center", p2);
        add("South", p3); 
         
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      Object Source = e.getSource();
      
      if(Source == connectECE){
          ArrayList<String> liste;
            
            String passwdECEString = new String(passwdECETexte.getPassword());
            String passwdBDDString = new String(passwdBDDTexte.getPassword());
        
      }
      else if (Source == connectlocal) {
            ArrayList<String> liste;
            
          try {
              //Connexion au serveur local (Nom bdd, user bdd, mdp bdd)
              maconnexion = new Connexion("hopital","root"," ");
          } catch (SQLException ex) {
              Logger.getLogger(Accueil.class.getName()).log(Level.SEVERE, null, ex);
          } catch (ClassNotFoundException ex) {
              Logger.getLogger(Accueil.class.getName()).log(Level.SEVERE, null, ex);
          }
    }
    }

    @Override
    public void itemStateChanged(ItemEvent ie) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
