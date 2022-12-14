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
public class Tecnicos extends javax.swing.JFrame {
    
    private String accion ="";
    /**
     * Creates new form Tecnicos
     */
    public Tecnicos() {
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
            String[]   titulos = {"documento","apellidos","nombres","telefono"};
            Object[]  fila = new Object[4]; 
            DefaultTableModel modelo = new DefaultTableModel(null,titulos);
            
            String sSQL  = "SELECT * FROM tecnicos"+condicion;
            
            try {
                
                PreparedStatement pst = con.prepareStatement(sSQL);
                rs=pst.executeQuery();
                
                while(rs.next ())
                {
                    fila[0] = rs.getString("documento");
                    fila[1] = rs.getString("apellidos");
                    fila[2] = rs.getString("nombres");
                    fila[3] = rs.getString("telefono");
                   
                    modelo.addRow(fila);
                }  
                
                jtb_Tecnicos.setModel(modelo);
            } 
            catch (Exception e) 
            {
            }
            desconectarBD();
        }
        
        public void mostrarDialogo()
        {
           Image icon = new ImageIcon(getClass().getResource("/imagenes/logo.png")).getImage();
           jdi_Tecnicos.setIconImage(icon);
           jdi_Tecnicos.setLocationRelativeTo(this);
           jdi_Tecnicos.setSize(550,350);
           jdi_Tecnicos.setVisible(true);
        }
        
        public void setControles(boolean activo)
        {
           txt_Documento.setEditable(activo);
           txt_Apellidos.setEditable(activo);
           txt_Nombres.setEditable(activo);
           txt_Telefono.setEditable(activo);
           
        }
        
        public void limpiarControles()
         
        {
            txt_Documento.setText("");
            txt_Apellidos.setText("");
            txt_Nombres.setText("");
            txt_Telefono.setText("");
           
        }
        
        public boolean cargarDialogo()
        {
         int fila = jtb_Tecnicos.getSelectedRow();  
        
        if( fila == -1 ) 
        {
            JOptionPane.showMessageDialog(null,"Debe seleccionar el tecnico","Atencion",JOptionPane.WARNING_MESSAGE ); 
            return false;
        }
        else
        {
            DefaultTableModel modelo = new DefaultTableModel();
            
            modelo = (DefaultTableModel) jtb_Tecnicos.getModel();
            
            txt_Documento.setText( modelo.getValueAt(fila,0).toString());
            txt_Apellidos.setText( modelo.getValueAt(fila,1).toString());
            txt_Nombres.setText( modelo.getValueAt(fila,2).toString() );
            txt_Telefono.setText( modelo.getValueAt(fila,3).toString());
            
            
            
            
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

        jdi_Tecnicos = new javax.swing.JDialog();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txt_Documento = new javax.swing.JTextField();
        txt_Apellidos = new javax.swing.JTextField();
        txt_Nombres = new javax.swing.JTextField();
        txt_Telefono = new javax.swing.JTextField();
        btn_Aceptar = new javax.swing.JButton();
        btn_Cancelar = new javax.swing.JButton();
        btn_Cerrar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cmb_Buscar = new javax.swing.JComboBox();
        txt_Buscar = new javax.swing.JTextField();
        btn_Buscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtb_Tecnicos = new javax.swing.JTable();
        btn_Adicionar = new javax.swing.JButton();
        btn_Editar = new javax.swing.JButton();
        btn_Eliminar = new javax.swing.JButton();
        btn_CerrarTecnicos = new javax.swing.JButton();

        jLabel3.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel3.setText("Tecnicos");

        jLabel4.setText("Documento:");

        jLabel5.setText("Apellidos:");

        jLabel6.setText("Nombres:");

        jLabel7.setText("Telefono:");

        btn_Aceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/aceptar.png"))); // NOI18N
        btn_Aceptar.setText("Aceptar");
        btn_Aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_AceptarActionPerformed(evt);
            }
        });

        btn_Cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cancelar.png"))); // NOI18N
        btn_Cancelar.setText("Cancelar");

        btn_Cerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cerrar.png"))); // NOI18N
        btn_Cerrar.setText("Cerrar");
        btn_Cerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_CerrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jdi_TecnicosLayout = new javax.swing.GroupLayout(jdi_Tecnicos.getContentPane());
        jdi_Tecnicos.getContentPane().setLayout(jdi_TecnicosLayout);
        jdi_TecnicosLayout.setHorizontalGroup(
            jdi_TecnicosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jdi_TecnicosLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jdi_TecnicosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jdi_TecnicosLayout.createSequentialGroup()
                        .addGroup(jdi_TecnicosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGap(58, 58, 58)
                        .addGroup(jdi_TecnicosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3)
                            .addComponent(txt_Documento)
                            .addComponent(txt_Apellidos)
                            .addComponent(txt_Nombres)
                            .addComponent(txt_Telefono, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jdi_TecnicosLayout.createSequentialGroup()
                        .addComponent(btn_Aceptar)
                        .addGap(18, 18, 18)
                        .addComponent(btn_Cancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
                        .addComponent(btn_Cerrar)
                        .addGap(26, 26, 26))))
        );
        jdi_TecnicosLayout.setVerticalGroup(
            jdi_TecnicosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jdi_TecnicosLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(33, 33, 33)
                .addGroup(jdi_TecnicosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(txt_Documento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jdi_TecnicosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(txt_Apellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jdi_TecnicosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(txt_Nombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jdi_TecnicosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(txt_Telefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49)
                .addGroup(jdi_TecnicosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_Aceptar)
                    .addComponent(btn_Cancelar)
                    .addComponent(btn_Cerrar))
                .addGap(24, 24, 24))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Tecnicos");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Buscar:");

        cmb_Buscar.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Todos", "Documento", "Apellidos", "Nombres", "Telefono" }));

        btn_Buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/buscar.png"))); // NOI18N
        btn_Buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_BuscarActionPerformed(evt);
            }
        });

        jtb_Tecnicos.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jtb_Tecnicos);

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

        btn_CerrarTecnicos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cerrar.png"))); // NOI18N
        btn_CerrarTecnicos.setText("Cerrar");
        btn_CerrarTecnicos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_CerrarTecnicosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmb_Buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_Buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_Buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(198, 198, 198)
                        .addComponent(jLabel1))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btn_Adicionar)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(btn_Editar)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(btn_Eliminar)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_CerrarTecnicos))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 481, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel1)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_Buscar)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cmb_Buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txt_Buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_Adicionar)
                    .addComponent(btn_Editar)
                    .addComponent(btn_Eliminar)
                    .addComponent(btn_CerrarTecnicos))
                .addGap(29, 29, 29))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_EliminarActionPerformed
        if( cargarDialogo())
          {
             accion = "MODIFICAR";
             setControles(true);
             txt_Documento.setEditable(false);
             mostrarDialogo();
          }
    }//GEN-LAST:event_btn_EliminarActionPerformed

    private void btn_EditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_EditarActionPerformed
                
        if( cargarDialogo())
          {
             accion = "MODIFICAR";
             setControles(true);
             txt_Documento.setEditable(false);
             mostrarDialogo();
          }
    }//GEN-LAST:event_btn_EditarActionPerformed

    private void btn_CerrarTecnicosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CerrarTecnicosActionPerformed
        this.dispose();
    }//GEN-LAST:event_btn_CerrarTecnicosActionPerformed

    private void btn_AdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AdicionarActionPerformed
        
        accion ="ADICIONAR";
        mostrarDialogo();
        setControles(true);
        limpiarControles();
    }//GEN-LAST:event_btn_AdicionarActionPerformed

    private void btn_CerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CerrarActionPerformed
        jdi_Tecnicos.dispose();
    }//GEN-LAST:event_btn_CerrarActionPerformed

    private void btn_BuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_BuscarActionPerformed
        
        String sSQL = "";
        String buscar = txt_Buscar.getText();
        int campo = cmb_Buscar.getSelectedIndex();
        
        if( campo == 0 )  // Todos
        {
           sSQL = "";
        }
        else if( campo == 1 ) // documento
        {
           sSQL =  " WHERE documento LIKE '%"+buscar+"%'";
        }
        else if( campo == 2 ) // apellidos
        {
           sSQL =  " WHERE apellidos LIKE '%"+buscar+"%'";
        }
        else if( campo == 3 ) //nombres
        {
           sSQL =  " WHERE nombres LIKE '%"+buscar+"%'";
        }
        else
        {
           sSQL =  " WHERE telefono LIKE '%"+buscar+"%'";
        }
   
   
        cargarTabla(sSQL);
    }//GEN-LAST:event_btn_BuscarActionPerformed

    private void btn_AceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AceptarActionPerformed
        
        String estado;
        Connection con = conectarBD();
        
        if(accion.equals("ADICIONAR"))
        {
            try
             
            {
                String sSQL="INSERT INTO tecnicos VALUES (?,?,?,?)";
                PreparedStatement pst = con.prepareStatement(sSQL);

                

                pst.setString(1, txt_Documento.getText());
                pst.setString(2, txt_Apellidos.getText());
                pst.setString(3, txt_Nombres.getText());
                pst.setString(4, txt_Telefono.getText());
               
                
                JOptionPane.showMessageDialog(null, " "+txt_Documento.getText()+" "+txt_Apellidos.getText()+" "+txt_Nombres.getText()+" "+txt_Telefono.getText());

      
                pst.execute();
            }       
      
            catch (Exception e)
              {
               
                  
              
              }
        }    
        else if (accion.equals("MODIFICAR"))
        {
          
            try {
                String sSQL="update tecnicos set apellidos=?,nombres=?,,telefono=?,where documento=?";
                PreparedStatement pst = con.prepareStatement(sSQL);
                
                pst.setString(1, txt_Apellidos.getText());
                pst.setString(2, txt_Nombres.getText());
                pst.setString(3, txt_Telefono.getText());
                pst.setString(4, txt_Documento.getText());
                pst.execute();
            } catch (SQLException ex) {
                Logger.getLogger(Tecnicos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        else
        {
            try
            {
                String sSQL = "DELETE FROM tecnicos WHERE ibs=?";
                
                PreparedStatement pst = con.prepareStatement(sSQL);
                
                pst.setString(1, txt_Documento.getText());
                pst.execute();
                
            }
            catch ( Exception e )
            {
                JOptionPane.showMessageDialog(null, "Error al eliminar el tecnico","Atencion",JOptionPane.WARNING_MESSAGE);
            }
        }
        
        cargarTabla("");
        desconectarBD();
        jdi_Tecnicos.dispose();
    }//GEN-LAST:event_btn_AceptarActionPerformed
    
    
    
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
            java.util.logging.Logger.getLogger(Tecnicos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tecnicos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tecnicos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tecnicos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tecnicos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Aceptar;
    private javax.swing.JButton btn_Adicionar;
    private javax.swing.JButton btn_Buscar;
    private javax.swing.JButton btn_Cancelar;
    private javax.swing.JButton btn_Cerrar;
    private javax.swing.JButton btn_CerrarTecnicos;
    private javax.swing.JButton btn_Editar;
    private javax.swing.JButton btn_Eliminar;
    private javax.swing.JComboBox cmb_Buscar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JDialog jdi_Tecnicos;
    private javax.swing.JTable jtb_Tecnicos;
    private javax.swing.JTextField txt_Apellidos;
    private javax.swing.JTextField txt_Buscar;
    private javax.swing.JTextField txt_Documento;
    private javax.swing.JTextField txt_Nombres;
    private javax.swing.JTextField txt_Telefono;
    // End of variables declaration//GEN-END:variables
}
