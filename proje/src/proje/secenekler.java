/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proje;
/**
 *
 * @author Ebru
 */
public class secenekler extends javax.swing.JFrame {
    islemler islem = new islemler();
    /**
     * Creates new form secenekler
     */
    public secenekler() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel1 = new java.awt.Panel();
        aracAl = new java.awt.Button();
        aracBirak = new java.awt.Button();
        ayarlar = new java.awt.Button();
        geri = new java.awt.Button();
        cikis = new java.awt.Button();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panel1.setBackground(new java.awt.Color(113, 185, 209));

        aracAl.setBackground(new java.awt.Color(204, 204, 255));
        aracAl.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        aracAl.setForeground(new java.awt.Color(0, 153, 153));
        aracAl.setLabel("ARAÇ AL");
        aracAl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aracAlActionPerformed(evt);
            }
        });

        aracBirak.setBackground(new java.awt.Color(204, 204, 255));
        aracBirak.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        aracBirak.setForeground(new java.awt.Color(0, 153, 153));
        aracBirak.setLabel("ARAÇ BIRAK");
        aracBirak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aracBirakActionPerformed(evt);
            }
        });

        ayarlar.setBackground(new java.awt.Color(204, 204, 255));
        ayarlar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        ayarlar.setForeground(new java.awt.Color(0, 153, 153));
        ayarlar.setLabel("AYARLAR");
        ayarlar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ayarlarActionPerformed(evt);
            }
        });

        geri.setBackground(new java.awt.Color(204, 204, 255));
        geri.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        geri.setForeground(new java.awt.Color(0, 153, 153));
        geri.setLabel("GERİ GİT");
        geri.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                geriActionPerformed(evt);
            }
        });

        cikis.setBackground(new java.awt.Color(204, 204, 255));
        cikis.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        cikis.setForeground(new java.awt.Color(0, 153, 153));
        cikis.setLabel("ÇIKIŞ");
        cikis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cikisActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(geri, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cikis, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
            .addGroup(panel1Layout.createSequentialGroup()
                .addGap(250, 250, 250)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(ayarlar, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(aracAl, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(aracBirak, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(279, Short.MAX_VALUE))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(geri, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                    .addComponent(cikis, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(189, 189, 189)
                .addComponent(aracAl, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(aracBirak, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(90, 90, 90)
                .addComponent(ayarlar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(128, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ayarlarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ayarlarActionPerformed
        // TODO add your handling code here:
        ayarlar ayarla =new ayarlar();
        ayarla.setVisible(true);
        dispose();
    }//GEN-LAST:event_ayarlarActionPerformed

    private void aracAlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aracAlActionPerformed
        // TODO add your handling code here:
        aracAl aracal = new aracAl();
        aracal.setVisible(true);
        dispose();
    }//GEN-LAST:event_aracAlActionPerformed

    private void aracBirakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aracBirakActionPerformed
        // TODO add your handling code here:
        aracBirak aracbirak = new aracBirak();
        aracbirak.setVisible(true);
        dispose();
    }//GEN-LAST:event_aracBirakActionPerformed

    private void geriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_geriActionPerformed
        // TODO add your handling code here:
        proje p = new proje();
        p.setVisible(true);
        dispose();
    }//GEN-LAST:event_geriActionPerformed

    private void cikisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cikisActionPerformed
        // TODO add your handling code here:
        proje p = new proje();
        p.setVisible(true);
        dispose();
    }//GEN-LAST:event_cikisActionPerformed

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
            java.util.logging.Logger.getLogger(secenekler.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(secenekler.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(secenekler.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(secenekler.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new secenekler().setVisible(true);
            }
        });
        
        
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button aracAl;
    private java.awt.Button aracBirak;
    private java.awt.Button ayarlar;
    private java.awt.Button cikis;
    private java.awt.Button geri;
    private java.awt.Panel panel1;
    // End of variables declaration//GEN-END:variables
}