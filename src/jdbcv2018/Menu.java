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
import java.sql.Connection;
import javax.swing.JButton; 
import javax.swing.JFrame; 
import javax.swing.JPanel; 
import javax.swing.JTable;

/**
 *
 * @author Roxane
 */
  
public class Menu extends JFrame implements ActionListener, ItemListener{ 
     
    private JButton Recherche, MaJ, Reporting, Connexion; 
    private JPanel p0, p1, p2, p3; 
    
    public JTable jtable;
    public String namebdd;
    
  public Menu(){ 
       // creation par heritage de la fenetre 
        super("Bienvenue dans le logiciel de Gestion du Centre Hospitalier"); 
 
        // mise en page (layout) de la fenetre visible 
        setLayout(new BorderLayout()); 
        setBounds(0, 0, 400, 400); 
        setResizable(true); 
        setVisible(true); 
         
        // Création des boutons 
         
        Recherche = new JButton("Recherche d'informations"); 
        MaJ = new JButton ("Mise à Jour des données"); 
        Reporting = new JButton ("Reporting"); 
        Connexion = new JButton("Connexion"); 
        
         
        // Création de panneaux  
        p0 = new JPanel(); 
        p1 = new JPanel(); 
       //p2 = new JPanel();     
        
        //p0.setLayout(new GridLayout(1, 1)); 
        //p1.setLayout(new GridLayout(10, 4)); 
        //p2.setLayout(new GridLayout(15, 4)); 
        
       p0.add(Recherche); 
        p0.add(MaJ); 
        p0.add(Reporting); 
        p0.add(Connexion); 
         
      // disposition geographique des panneaux 
        this.getContentPane().add(p0, BorderLayout.NORTH);
        //this.getContentPane().add(p1, BorderLayout.CENTER);
        //this.getContentPane().add(p2, BorderLayout.SOUTH);
     // add("North", p0); 
      //  add("Center", p1); 
       // add("South", p2); 
         
         
  }  
  
  public Menu(Connection conn, int choix){
     String nameDatabase=null; 
     nameDatabase="hopital";
     namebdd=nameDatabase;
     //connecte= conn;
     //initComponents();
     
  }
     
 
    @Override 
    public void actionPerformed(ActionEvent e) { 
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods,choose Tools | Templates. 
     //Object source = e.getSource();
     
     //if (source == Recherche)
         
     
         }
    
    
 
    @Override 
    public void itemStateChanged(ItemEvent ie) { 
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates. 
    } 
} 


