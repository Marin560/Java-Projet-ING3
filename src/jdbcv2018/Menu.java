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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton; 
import javax.swing.JComboBox;
import javax.swing.JFrame; 
import javax.swing.JPanel; 
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Roxane
 */
  
public class Menu extends JFrame implements ActionListener, ItemListener{ 
     
    private JButton Recherche, MaJ, Reporting, Connexion; //Bouttons de la fenêtre
    private JPanel p0, p1, p2, p3; 
    private JComboBox combo = new JComboBox();
    public JTable jtable = new JTable();
    public String namebdd;
    private Connection conn;
    
    public Menu(Connection s) throws SQLException{ //Constructeur
       // creation par heritage de la fenetre 
        super("Logiciel de Gestion du Centre Hospitalier"); 
        this.conn = s;
        
        // mise en page (layout) de la fenetre visible 
        setLayout(new BorderLayout()); 
        setSize(1000,1000);
        //setBounds(0, 0, 400, 400); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Quitte le programme quand la fenêtre est fermée
        setResizable(true); 
        setVisible(true); 
        
        combo.addItem("Chambre");
        combo.addItem("Docteur");
        combo.addItem("Employe");
        combo.addItem("Hospitalisation");
        combo.addItem("Infirmier");
        combo.addItem("Malade");
        combo.addItem("Service");
        combo.addItem("Soigne");
        
        combo.addActionListener(this);
         
        
         JScrollPane jScrollPane = new JScrollPane();
        jScrollPane.setViewportView(jtable);
        
        // Création des boutons 
        Recherche = new JButton("Recherche d'informations"); 
        MaJ = new JButton ("Mise à Jour des données"); 
        Reporting = new JButton ("Reporting"); 
        //Connexion = new JButton("Connexion"); 
        
        
        
        
        
        DefaultTableModel table = new DefaultTableModel();
        Statement stmt = conn.createStatement();
        
        ResultSet Requete = stmt.executeQuery("SELECT column_name FROM information_schema.columns WHERE table_name = 'chambre'");
        while(Requete.next())
        {
            //System.out.println(Requete.getString("column_name"));
            table.addColumn(Requete.getString("column_name"));
        }
       
     jtable.setModel(table);
        
        Requete = stmt.executeQuery("SELECT * FROM chambre");
        while(Requete.next())
        {
            table.addRow(new Object[]{
                Requete.getString(table.getColumnName(0)),Requete.getString(table.getColumnName(1)),Requete.getString(table.getColumnName(2)),Requete.getString(table.getColumnName(3))
            });
        }
        
        jtable.setModel(table);
      
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        // Création des pannels  
        p0 = new JPanel(); 
        p1 = new JPanel(); 
        p2 = new JPanel();  
        p3 = new JPanel();
        
        p0.setLayout(new GridLayout(1, 1)); 
        p1.setLayout(new GridLayout(0,1,-5,5)); 
        
        p2.setLayout(new GridLayout(15, 4)); 
        
        
        p0.add(Recherche); 
        p0.add(MaJ); 
        p0.add(Reporting); 
        
        p1.add(jScrollPane); 
        
        p2.add(combo);
        
        
        
        // disposition geographique des panneaux 
         this.getContentPane().add(p2, BorderLayout. CENTER);
        this.getContentPane().add(p1, BorderLayout.SOUTH);
        this.getContentPane().add(p0, BorderLayout.NORTH);
        add("North", p0); 
        add("Center", p2); 
        add("South", p1); 
         

         
    }  
  
    public Menu(Connection conn, int choix){ //Constructeur surchargé
     String nameDatabase=null; 
     nameDatabase="hopital";
     namebdd=nameDatabase;
     //connecte= conn;
     //initComponents();
     
  }
     
 
    @Override 
    public void actionPerformed(ActionEvent e) { 
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods,choose Tools | Templates. 
     Object source = e.getSource();
     
     if (source == combo)
     {
         try {
             DefaultTableModel table = new DefaultTableModel();
             Statement stmt = conn.createStatement();
             
             ResultSet Requete = stmt.executeQuery("SELECT column_name FROM information_schema.columns WHERE table_name = '"+combo.getSelectedItem()+"'");
            
           
                 while(Requete.next())
                 {
                     //System.out.println(Requete.getString("column_name"));
                     table.addColumn(Requete.getString("column_name"));
                 }
             
             jtable.setModel(table);
             
      
                 Requete = stmt.executeQuery("SELECT * FROM "+combo.getSelectedItem()+"");
                
                 if(jtable.getColumnCount()== 2){
                 while(Requete.next())
                 {
                     table.addRow(new Object[]{
                         Requete.getString(table.getColumnName(0)),Requete.getString(table.getColumnName(1))
                     });
                 }
                }
                 
                 if(jtable.getColumnCount()== 4){
                 while(Requete.next())
                 {
                     table.addRow(new Object[]{
                         Requete.getString(table.getColumnName(0)),Requete.getString(table.getColumnName(1)),Requete.getString(table.getColumnName(2)),Requete.getString(table.getColumnName(3))
                     });
                 }
                }
                 
                 if(jtable.getColumnCount()== 5){
                 while(Requete.next())
                 {
                     table.addRow(new Object[]{
                         Requete.getString(table.getColumnName(0)),Requete.getString(table.getColumnName(1)),Requete.getString(table.getColumnName(2)),Requete.getString(table.getColumnName(3)),Requete.getString(table.getColumnName(4))
                     });
                 }
                }
                 
                if(jtable.getColumnCount()== 6){
                 while(Requete.next())
                 {
                     table.addRow(new Object[]{
                         Requete.getString(table.getColumnName(0)),Requete.getString(table.getColumnName(1)),Requete.getString(table.getColumnName(2)),Requete.getString(table.getColumnName(3)),Requete.getString(table.getColumnName(4)), Requete.getString(table.getColumnName(5))
                     });
                 }
                }
                
                
             
             jtable.setModel(table);
         } catch (SQLException ex) {
             Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
         }
     }
         
     
         }
    
    
 
    @Override 
    public void itemStateChanged(ItemEvent ie) { 
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates. 
    } 
} 


