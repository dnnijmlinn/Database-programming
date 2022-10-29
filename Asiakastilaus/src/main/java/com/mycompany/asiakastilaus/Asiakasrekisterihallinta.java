/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.asiakastilaus;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Denis Bogdanov
 */
public class Asiakasrekisterihallinta extends javax.swing.JFrame {

    /**
     * Creates new form Asiakasrekisterihallinta
     */
    class Asiakas{
        
        private int ASIAKASNUMERO;
        private String ETUNIMI;
        private String SUKUNIMI;
        private String YRITYS;
        private String KATUOSOITE;

        
        public Asiakas(int id, String etunimi, String sukunimi, String yritys, String katuosoite){
            this.ASIAKASNUMERO = id;
            this.ETUNIMI = etunimi;
            this.SUKUNIMI = sukunimi;
            this.YRITYS = yritys;
            this.KATUOSOITE = katuosoite;
        }
        
        public int HaeAsiakasnumero(){
            return this.ASIAKASNUMERO;
        }
        
        public String HaeEtunimi(){
            return this.ETUNIMI;
        }
        
        public String HaeSukunimi(){
            return this.SUKUNIMI;
        }
        
        public String HaeYritys(){
            return this.YRITYS;
        }
        public String HaeKatuosoite(){
            return this.KATUOSOITE;
        }
    }
    
    public Connection luoYhteys(){
        Connection cn=null;
        try{
            cn = DriverManager.
                    getConnection("jdbc:mariadb://" + "localhost" + ":3306/ASIAKASTILAUS", "kehittaja", "Koira123!");
                    JOptionPane.showMessageDialog(null, "yhteys tietoktaan on muodostettu!");
            
            return cn;
        } catch (SQLException e){
            System.out.print("Yhteyden luominen epäonnistui!:\n" + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
    
    public ArrayList<Asiakas> HaeAsiakastaulukko(){
        ArrayList<Asiakas> Asiakastaulukko = new ArrayList<Asiakas>();
        
        Connection yhteys = luoYhteys();
        
        String query = "SELECT ASIAKASNUMERO, ETUNIMI, SUKUNIMI, YRITYS, KATUOSOITE FROM ASIAKAS";
        Statement st;
        ResultSet rs;
        
        try{
            st = yhteys.createStatement();
            rs = st.executeQuery(query);
            
            Asiakas a;
            
            while(rs.next()){
                a = new Asiakas(rs.getInt("ASIAKASNUMERO"), rs.getString("ETUNIMI"), rs.getString("SUKUNIMI"), rs.getString("YRITYS"), rs.getString("KATUOSOITE"));
                    Asiakastaulukko.add(a);
                   
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return Asiakastaulukko;
    }
    
    public void Naytaasiakkaat(){
        ArrayList<Asiakas> list = HaeAsiakastaulukko();
        DefaultTableModel model = (DefaultTableModel)jtblAsiakkaat.getModel();
        
        model.setColumnIdentifiers(new Object[]{"ASIAKASNUMERO", "ETUNIMI", "SUKUNIMI", "YRITYS", "KATUOSOITE"});
        Object[] row = new Object[5];
        
        for(int i = jtblAsiakkaat.getRowCount() - 1; i>=0; i--){
            model.removeRow(i);
        }
        
        for(int i = 0; i<list.size(); i++){
            row[0] = list.get(i).HaeAsiakasnumero();
            row[1] = list.get(i).HaeEtunimi();
            row[2] = list.get(i).HaeSukunimi();
            row[3] = list.get(i).HaeYritys();
            row[4] = list.get(i).HaeKatuosoite();
            model.addRow(row);
        }
    }
    
    public void suoritaSQLKysely(String query, String message){
        Connection yhteys = luoYhteys();
        Statement st;
        try{
            st = yhteys.createStatement();
            if((st.executeUpdate(query)) == 1){
                DefaultTableModel model = (DefaultTableModel)jtblAsiakkaat.getModel();
                model.setRowCount(0);
                Naytaasiakkaat();
                
                JOptionPane.showMessageDialog(null, "Data " + message + "onnistuneesti");
            } else {
                JOptionPane.showMessageDialog(null, "Data ei " + message);
            }
            
            yhteys.close();
            
        } catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
    public Asiakasrekisterihallinta() {
        
        initComponents();
        Naytaasiakkaat();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jlblAsiakasrekisteri = new javax.swing.JLabel();
        jlblAasiakasnumero = new javax.swing.JLabel();
        jlblEtunimi = new javax.swing.JLabel();
        jlblSukunimi = new javax.swing.JLabel();
        jlblYritys = new javax.swing.JLabel();
        jbtnUusi = new javax.swing.JButton();
        jbtnPaivita = new javax.swing.JButton();
        jbtnPoista = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtblAsiakkaat = new javax.swing.JTable();
        jtxtEtunimi = new javax.swing.JTextField();
        jtxtSukunimi = new javax.swing.JTextField();
        jtxtYritys = new javax.swing.JTextField();
        jtxtAasiakasnumero = new javax.swing.JTextField();
        jtxtSQL = new javax.swing.JTextField();
        jlblYritys1 = new javax.swing.JLabel();
        jtxtKatuosoite = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jlblAsiakasrekisteri.setText("Asiakasrekisteri");

        jlblAasiakasnumero.setText("Aasiakasnumero");

        jlblEtunimi.setText("Etunimi");

        jlblSukunimi.setText("Sukunimi");

        jlblYritys.setText("Yritys");

        jbtnUusi.setText("Uusi");
        jbtnUusi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnUusiActionPerformed(evt);
            }
        });

        jbtnPaivita.setText("Paivita");
        jbtnPaivita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnPaivitaActionPerformed(evt);
            }
        });

        jbtnPoista.setText("Poista");
        jbtnPoista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnPoistaActionPerformed(evt);
            }
        });

        jButton4.setText("MongoDB yhteyden testaus");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Testaa tietokantayhteys Amazon MarianDB-palvelimeen");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jtblAsiakkaat.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ASIAKASNUMERO", "ETUNIMI", "SUKUNIMI", "YRITYS", "Puhelin"
            }
        ));
        jtblAsiakkaat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtblAsiakkaatMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtblAsiakkaat);

        jtxtAasiakasnumero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtAasiakasnumeroActionPerformed(evt);
            }
        });

        jtxtSQL.setText("jTextField1");

        jlblYritys1.setText("Katuosoite");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jtxtSQL, javax.swing.GroupLayout.PREFERRED_SIZE, 684, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlblAsiakasrekisteri)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jbtnUusi)
                                .addGap(18, 18, 18)
                                .addComponent(jbtnPaivita)
                                .addGap(18, 18, 18)
                                .addComponent(jbtnPoista))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jlblSukunimi)
                                    .addComponent(jlblYritys)
                                    .addComponent(jlblAasiakasnumero)
                                    .addComponent(jlblEtunimi)
                                    .addComponent(jlblYritys1))
                                .addGap(68, 68, 68)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jtxtEtunimi, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                                    .addComponent(jtxtAasiakasnumero, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                                    .addComponent(jtxtSukunimi)
                                    .addComponent(jtxtYritys)
                                    .addComponent(jtxtKatuosoite))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton5))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 763, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(47, 47, 47))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jlblAsiakasrekisteri)
                .addGap(77, 77, 77)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jlblAasiakasnumero)
                                .addGap(18, 18, 18)
                                .addComponent(jlblEtunimi))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jtxtAasiakasnumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jtxtEtunimi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlblSukunimi)
                            .addComponent(jtxtSukunimi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlblYritys)
                            .addComponent(jtxtYritys, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlblYritys1)
                            .addComponent(jtxtKatuosoite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jbtnUusi)
                            .addComponent(jbtnPaivita)
                            .addComponent(jbtnPoista)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 386, Short.MAX_VALUE))
                .addGap(4, 4, 4)
                .addComponent(jtxtSQL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(jButton5))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jtxtAasiakasnumeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtAasiakasnumeroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtAasiakasnumeroActionPerformed

    private void jbtnUusiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnUusiActionPerformed
        // TODO add your handling code here:
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        
        Date tamapaiva = new Date();
        
        String query = "INSERT INTO `asiakas`(`ASIAKKAAKSITULOPAIVA`, `YRITYS`, `ETUNIMI`, `SUKUNIMI`, `KATUOSOITE`, `POSTITOIMIPAIKKA`, `PUHELIN`, `EMAIL`)";
        query = query + " VALUES('" + dateFormat.format(tamapaiva) + "','" + jtxtYritys.getText() + "','" + jtxtEtunimi.getText() + "','" + jtxtSukunimi.getText()+ "','" + jtxtKatuosoite.getText();
        query = query + "','','','')";
        
        JOptionPane.showMessageDialog(null, query);
        jtxtSQL.setText(query);
        suoritaSQLKysely(query, "lisätty");
        Naytaasiakkaat();
    }//GEN-LAST:event_jbtnUusiActionPerformed

    private void jtblAsiakkaatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtblAsiakkaatMouseClicked
        // TODO add your handling code here:
        int i = jtblAsiakkaat.getSelectedRow();
        TableModel model = jtblAsiakkaat.getModel();
        
        jtxtAasiakasnumero.setText((model.getValueAt(i,0).toString()));
        jtxtEtunimi.setText((model.getValueAt(i,1).toString()));
        jtxtSukunimi.setText((model.getValueAt(i,2).toString()));
        jtxtYritys.setText((model.getValueAt(i,3).toString()));
        jtxtKatuosoite.setText((model.getValueAt(i,4).toString()));

    }//GEN-LAST:event_jtblAsiakkaatMouseClicked

    private void jbtnPaivitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnPaivitaActionPerformed
        // TODO add your handling code here:
        String query = "UPDATE asiakas SET ETUNIMI='" + jtxtEtunimi.getText() + "', SUKUNIMI='" + jtxtSukunimi.getText()+ "', YRITYS='" + jtxtYritys.getText() + "', KATUOSOITE='" + jtxtKatuosoite.getText() + "' WHERE ASIAKASNUMERO = " + jtxtAasiakasnumero.getText();
        JOptionPane.showMessageDialog(null, query);
        
        suoritaSQLKysely(query, "Päivitetty");
    }//GEN-LAST:event_jbtnPaivitaActionPerformed

    private void jbtnPoistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnPoistaActionPerformed
        // TODO add your handling code here:
        String query = "DELETE FROM asiakas WHERE ASIAKASNUMERO=" + jtxtAasiakasnumero.getText();
        int reply = JOptionPane.showConfirmDialog(null, "Haluatko poistetta?", "An Inane Question",  JOptionPane.YES_NO_OPTION);
        if(reply==JOptionPane.YES_OPTION){
            jtxtSQL.setText(query); 
            suoritaSQLKysely(query, "Poistettu");
        } else {
            JOptionPane.showMessageDialog(null, "Ei ongelma");
        }
        
        
        
    }//GEN-LAST:event_jbtnPoistaActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        try { 
            Class.forName("org.mariadb.jdbc.Driver"); 
            } catch (ClassNotFoundException e) { 
            System.out.println("Missä on MariaDB JDBC ajuri? Oletko ladannut mariadb connectorin osoitteesta: https://mariadb.com/downloads/#connectors ja lisännyt sen Netbeansissä Asiakasrekisteri-Libraries-Add JAR/Folder kohdassa? "); 
             e.printStackTrace(); 
            return; 
            } 
 System.out.println("Mariadb JDBC Driver rekisteröity!"); 
 Connection connection = null;
 
  try { 
 connection = DriverManager. 
 getConnection("jdbc:mariadb://" + "localhost:" + "3306/ASIAKASTILAUS", "kehittaja", "Koira123!"); 
 } catch (SQLException e) { 
 System.out.println("Yhteyden luominen epäonnistui!:\n" + e.getMessage());  
 } 
 if (connection != null) { 
 System.out.println("Hienoa ja onnittelut! Sait luotua yhteyden tietokantaasi. Voit aloittaa käyttöliittymän koodaamisen!"); 
 } else { 
 System.out.println("Pahus, tarkista vielä, että kaikki tarvittava on tehty ja virheitä ei ole!"); 
 } 
 
    }//GEN-LAST:event_jButton5ActionPerformed

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
            java.util.logging.Logger.getLogger(Asiakasrekisterihallinta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Asiakasrekisterihallinta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Asiakasrekisterihallinta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Asiakasrekisterihallinta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Asiakasrekisterihallinta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtnPaivita;
    private javax.swing.JButton jbtnPoista;
    private javax.swing.JButton jbtnUusi;
    private javax.swing.JLabel jlblAasiakasnumero;
    private javax.swing.JLabel jlblAsiakasrekisteri;
    private javax.swing.JLabel jlblEtunimi;
    private javax.swing.JLabel jlblSukunimi;
    private javax.swing.JLabel jlblYritys;
    private javax.swing.JLabel jlblYritys1;
    private javax.swing.JTable jtblAsiakkaat;
    private javax.swing.JTextField jtxtAasiakasnumero;
    private javax.swing.JTextField jtxtEtunimi;
    private javax.swing.JTextField jtxtKatuosoite;
    private javax.swing.JTextField jtxtSQL;
    private javax.swing.JTextField jtxtSukunimi;
    private javax.swing.JTextField jtxtYritys;
    // End of variables declaration//GEN-END:variables
}
