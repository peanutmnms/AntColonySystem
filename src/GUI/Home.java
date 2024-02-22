/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import java.io.File;
import javax.swing.JFileChooser;
import Grafo.*;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author santi
 */
public class Home extends javax.swing.JFrame {

    /**
     * Creates new form Home
     */
    static Grafo grafo = new Grafo();
    public Home() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Title = new javax.swing.JLabel();
        Upload = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        AddVertex = new javax.swing.JButton();
        DeleteVertex = new javax.swing.JButton();
        Start = new javax.swing.JButton();
        InputAntNum = new javax.swing.JTextField();
        Save = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Title.setText("Ant Colony");
        jPanel1.add(Title, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 10, -1, -1));

        Upload.setText("Subir Archivo");
        Upload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UploadActionPerformed(evt);
            }
        });
        jPanel1.add(Upload, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, -1));

        jScrollPane1.setViewportView(jTextPane1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 370, 270));

        AddVertex.setText("Agregar Ciudad");
        AddVertex.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddVertexActionPerformed(evt);
            }
        });
        jPanel1.add(AddVertex, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 120, 150, -1));

        DeleteVertex.setText("Eliminar Ciudad");
        DeleteVertex.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteVertexActionPerformed(evt);
            }
        });
        jPanel1.add(DeleteVertex, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 160, 150, -1));

        Start.setText("Iniciar");
        jPanel1.add(Start, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 200, 70, -1));

        InputAntNum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InputAntNumActionPerformed(evt);
            }
        });
        jPanel1.add(InputAntNum, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 200, 70, -1));

        Save.setText("Guardar Archivo");
        Save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveActionPerformed(evt);
            }
        });
        jPanel1.add(Save, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 50, 150, -1));

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 630, 430));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void UploadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UploadActionPerformed
        //Crea objeto FileChooser
        JFileChooser file=new JFileChooser();
        //Crea filtro para solo archivos txt
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("*.TXT","txt");
        //pasa el filtro al filechooser
        file.setFileFilter(filtro);
        //muestra el filechooser
        file.showSaveDialog(this);
        //guarda el filechooser
        File guarda =file.getSelectedFile();
        
        String fileName = guarda.getName().toUpperCase();
        if (fileName.endsWith(".TXT") ) {
            VertexLista v1=grafo.read_text(guarda);
            grafo.setVertices(v1);
            grafo.imprimir();
            
        }else{
            JOptionPane.showMessageDialog(null, "Ha introducido un tipo de archivo no valido");
        }
        
        
        
       

    }//GEN-LAST:event_UploadActionPerformed

    private void DeleteVertexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteVertexActionPerformed
        EliminarCiudad ciudad = new EliminarCiudad();
        ciudad.setVisible(true);
        
    }//GEN-LAST:event_DeleteVertexActionPerformed

    private void InputAntNumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InputAntNumActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_InputAntNumActionPerformed

    private void SaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveActionPerformed
        grafo.write_txt();
    }//GEN-LAST:event_SaveActionPerformed

    private void AddVertexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddVertexActionPerformed
        InsertarCiudad ciudad = new InsertarCiudad();
        ciudad.setVisible(true);
    }//GEN-LAST:event_AddVertexActionPerformed

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
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddVertex;
    private javax.swing.JButton DeleteVertex;
    private javax.swing.JTextField InputAntNum;
    private javax.swing.JButton Save;
    private javax.swing.JButton Start;
    private javax.swing.JLabel Title;
    private javax.swing.JButton Upload;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane jTextPane1;
    // End of variables declaration//GEN-END:variables
}
