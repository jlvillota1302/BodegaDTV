/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formularios;

import static clases.ConexionBD.conectarBD;
import static clases.ConexionBD.desconectarBD;
import java.awt.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jose Luis
 */
public class Dispositivos extends javax.swing.JFrame {

     private String accion ="";
    /**
     * Creates new form Dispositivos
     */
    public Dispositivos() {
        initComponents();
        
        Image icon = new ImageIcon(getClass().getResource("/imagenes/logo.png")).getImage();
        setIconImage(icon);
        
        cargarTabla("");
    }
     
    /*--------------------------------------------------------------------------------------------------
        MIS METODOS
        */
    public void cargarTabla(String condicion)
        {
            Connection con = conectarBD();
            ResultSet   rs = null;
            String[]   titulos = {"serial","smartcard","codigo de modelo",};
            Object[]  fila = new Object[3]; 
            DefaultTableModel modelo = new DefaultTableModel(null,titulos);
            
            String sSQL  = "SELECT * FROM Dispositivos"+condicion;
            
            try {
                
                PreparedStatement pst = con.prepareStatement(sSQL);
                rs=pst.executeQuery();
                
                while(rs.next ())
                {
                    fila[0] = rs.getString("serial");
                    fila[1] = rs.getString("smartcard");
                    fila[2] = rs.getString("codigo de modelo");
                    
                    modelo.addRow(fila);
                }  
                
                jtb_Dispositivos.setModel(modelo);
            } 
            catch (Exception e) 
            {
            }
            desconectarBD();
        }
        
        public void mostrarDialogo()
        {
           Image icon = new ImageIcon(getClass().getResource("/imagenes/logo.png")).getImage();
           jdi_Dispositivos.setIconImage(icon);
           jdi_Dispositivos.setLocationRelativeTo(this);
           jdi_Dispositivos.setSize(550,350);
           jdi_Dispositivos.setVisible(true);
        }
        
        public void setControles(boolean activo)
        {
           txt_Serial.setEditable(activo);
           txt_Smart.setEditable(activo);
           txt_CodigoModelo.setEditable(activo);
          
        }
        
        public void limpiarControles()
         
        {
            txt_Serial.setText("");
            txt_Smart.setText("");
            txt_CodigoModelo.setText("");
          
        }
        
        public boolean cargarDialogo()
        {
         int fila = jtb_Dispositivos.getSelectedRow();  
        
        if( fila == -1 ) 
        {
            JOptionPane.showMessageDialog(null,"Debe seleccionar el Dispositivo","Atencion",JOptionPane.WARNING_MESSAGE ); 
            return false;
        }
        else
        {
            DefaultTableModel modelo = new DefaultTableModel();
            
            modelo = (DefaultTableModel) jtb_Dispositivos.getModel();
            
            txt_Serial.setText( modelo.getValueAt(fila,0).toString());
            txt_Smart.setText( modelo.getValueAt(fila,1).toString());
            txt_CodigoModelo.setText( modelo.getValueAt(fila,2).toString() );
            
            
            
            
            return true;
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

        jdi_Dispositivos = new javax.swing.JDialog();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_Serial = new javax.swing.JTextField();
        txt_Smart = new javax.swing.JTextField();
        txt_CodigoModelo = new javax.swing.JTextField();
        btn_Aceptar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        btn_Cerrar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cmb_Buscar = new javax.swing.JComboBox();
        txt_Buscar = new javax.swing.JTextField();
        btn_Buscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtb_Dispositivos = new javax.swing.JTable();
        btn_Adicionar = new javax.swing.JButton();
        btn_Editar = new javax.swing.JButton();
        btn_Eliminar = new javax.swing.JButton();
        btn_CerrarDispositivos = new javax.swing.JButton();

        jLabel3.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel3.setText("Dispositivos");
        jLabel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel4.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel4.setText("Serial:");

        jLabel5.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel5.setText("SmartCard:");

        jLabel6.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel6.setText("CodigoModelo:");

        btn_Aceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/aceptar.png"))); // NOI18N
        btn_Aceptar.setText("Aceptar");
        btn_Aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_AceptarActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cancelar.png"))); // NOI18N
        jButton2.setText("Cancelar");

        btn_Cerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cerrar.png"))); // NOI18N
        btn_Cerrar.setText("Cerrar");
        btn_Cerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_CerrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jdi_DispositivosLayout = new javax.swing.GroupLayout(jdi_Dispositivos.getContentPane());
        jdi_Dispositivos.getContentPane().setLayout(jdi_DispositivosLayout);
        jdi_DispositivosLayout.setHorizontalGroup(
            jdi_DispositivosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jdi_DispositivosLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jdi_DispositivosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jdi_DispositivosLayout.createSequentialGroup()
                        .addGroup(jdi_DispositivosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(11, 11, 11)
                        .addGroup(jdi_DispositivosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_Serial, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_Smart, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_CodigoModelo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jdi_DispositivosLayout.createSequentialGroup()
                        .addComponent(btn_Aceptar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
                        .addComponent(btn_Cerrar)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jdi_DispositivosLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(134, 134, 134))
        );
        jdi_DispositivosLayout.setVerticalGroup(
            jdi_DispositivosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jdi_DispositivosLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel3)
                .addGap(35, 35, 35)
                .addGroup(jdi_DispositivosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txt_Serial, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jdi_DispositivosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txt_Smart, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(jdi_DispositivosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txt_CodigoModelo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addGroup(jdi_DispositivosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_Aceptar)
                    .addComponent(jButton2)
                    .addComponent(btn_Cerrar))
                .addGap(25, 25, 25))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Dispositivos");

        jLabel2.setText("Buscar:");

        cmb_Buscar.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Todos", "Serial", "SmartCard", "Codigo Modelo" }));

        btn_Buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/buscar.png"))); // NOI18N
        btn_Buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_BuscarActionPerformed(evt);
            }
        });

        jtb_Dispositivos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jtb_Dispositivos);

        btn_Adicionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/adicionar.png"))); // NOI18N
        btn_Adicionar.setText("Adicionar");
        btn_Adicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_AdicionarActionPerformed(evt);
            }
        });

        btn_Editar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/editar.png"))); // NOI18N
        btn_Editar.setText("Editar");
        btn_Editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_EditarActionPerformed(evt);
            }
        });

        btn_Eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/eliminar.png"))); // NOI18N
        btn_Eliminar.setText("Eliminar");
        btn_Eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_EliminarActionPerformed(evt);
            }
        });

        btn_CerrarDispositivos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cerrar.png"))); // NOI18N
        btn_CerrarDispositivos.setText("Cerrar");
        btn_CerrarDispositivos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_CerrarDispositivosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_Adicionar)
                        .addGap(18, 18, 18)
                        .addComponent(btn_Editar)
                        .addGap(18, 18, 18)
                        .addComponent(btn_Eliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_CerrarDispositivos))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 522, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cmb_Buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_Buscar))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(185, 185, 185)
                                .addComponent(jLabel1)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_Buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(19, 19, 19))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel1)
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_Buscar)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(cmb_Buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txt_Buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_Adicionar)
                    .addComponent(btn_Editar)
                    .addComponent(btn_Eliminar)
                    .addComponent(btn_CerrarDispositivos))
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_AdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AdicionarActionPerformed
         accion ="ADICIONAR";
        mostrarDialogo();
        setControles(true);
        limpiarControles();
    }//GEN-LAST:event_btn_AdicionarActionPerformed

    private void btn_EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_EliminarActionPerformed
         if( cargarDialogo())
          {
             accion = "MODIFICAR";
             setControles(true);
             txt_Serial.setEditable(false);
             mostrarDialogo();
          }
    }//GEN-LAST:event_btn_EliminarActionPerformed

    private void btn_EditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_EditarActionPerformed
         if( cargarDialogo())
          {
             accion = "MODIFICAR";
             setControles(true);
             txt_Serial.setEditable(false);
             mostrarDialogo();
          }
    }//GEN-LAST:event_btn_EditarActionPerformed

    private void btn_CerrarDispositivosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CerrarDispositivosActionPerformed
       this.dispose();
    }//GEN-LAST:event_btn_CerrarDispositivosActionPerformed

    private void btn_CerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CerrarActionPerformed
        jdi_Dispositivos.dispose();
    }//GEN-LAST:event_btn_CerrarActionPerformed

    private void btn_AceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AceptarActionPerformed
        
        String estado;
        Connection con = conectarBD();
        
        if(accion.equals("ADICIONAR"))
        {
            try
             
            {
                String sSQL="INSERT INTO Dispositivos VALUES (?,?,?)";
                PreparedStatement pst = con.prepareStatement(sSQL);

                

                pst.setString(1, txt_Serial.getText());
                pst.setString(2, txt_Smart.getText());
                pst.setString(3, txt_CodigoModelo.getText());
               
                
                JOptionPane.showMessageDialog(null, " "+txt_Serial.getText()+" "+txt_Smart.getText()+" "+txt_CodigoModelo.getText());

      
                pst.execute();
            }       
      
            catch (Exception e)
              {
               
                  
              
              }
        }    
        else if (accion.equals("MODIFICAR"))
        {
          
            try {
                String sSQL="update Dispositivos set Serial=?,Smartcard=? where codigomodelo=?";
                PreparedStatement pst = con.prepareStatement(sSQL);
                
                pst.setString(1, txt_Smart.getText());
                pst.setString(2, txt_CodigoModelo.getText());
                pst.setString(3, txt_Serial.getText());
                pst.execute();
            } catch (SQLException ex) {
                Logger.getLogger(Dispositivos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        else
        {
            try
            {
                String sSQL = "DELETE FROM Dispositivos WHERE Serial=?";
                
                PreparedStatement pst = con.prepareStatement(sSQL);
                
                pst.setString(1, txt_Serial.getText());
                pst.execute();
                
            }
            catch ( Exception e )
            {
                JOptionPane.showMessageDialog(null, "Error al eliminar el Dispositivos","Atencion",JOptionPane.WARNING_MESSAGE);
            }
        }
        
        cargarTabla("");
        desconectarBD();
        jdi_Dispositivos.dispose();
    }//GEN-LAST:event_btn_AceptarActionPerformed

    private void btn_BuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_BuscarActionPerformed
         
        String sSQL = "";
        String buscar = txt_Buscar.getText();
        int campo = cmb_Buscar.getSelectedIndex();
        
        if( campo == 0 )  // Todos
        {
           sSQL = "";
        }
        else if( campo == 1 ) // serial
        {
           sSQL =  " WHERE Serial LIKE '%"+buscar+"%'";
        }
         else
        {
           sSQL =  " WHERE codigomodelo LIKE '%"+buscar+"%'";
        }
   
   
        cargarTabla(sSQL);
    }//GEN-LAST:event_btn_BuscarActionPerformed
    
                                             

                                    

                                       

                                      

   
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
            java.util.logging.Logger.getLogger(Dispositivos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Dispositivos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Dispositivos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dispositivos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Dispositivos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Aceptar;
    private javax.swing.JButton btn_Adicionar;
    private javax.swing.JButton btn_Buscar;
    private javax.swing.JButton btn_Cerrar;
    private javax.swing.JButton btn_CerrarDispositivos;
    private javax.swing.JButton btn_Editar;
    private javax.swing.JButton btn_Eliminar;
    private javax.swing.JComboBox cmb_Buscar;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JDialog jdi_Dispositivos;
    private javax.swing.JTable jtb_Dispositivos;
    private javax.swing.JTextField txt_Buscar;
    private javax.swing.JTextField txt_CodigoModelo;
    private javax.swing.JTextField txt_Serial;
    private javax.swing.JTextField txt_Smart;
    // End of variables declaration//GEN-END:variables
}
