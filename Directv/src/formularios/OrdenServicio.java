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
public class OrdenServicio extends javax.swing.JFrame {
    
    private String accion ="";
    /**
     * Creates new form OrdenServicio
     */
    public OrdenServicio() {
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
            String[]   titulos = {"numero_orden","ibs","fecha","descripcion","documento",};
            Object[]  fila = new Object[5]; 
            DefaultTableModel modelo = new DefaultTableModel(null,titulos);
            
            String sSQL  = "SELECT * FROM orden_de_servicio"+condicion;
            
            try {
                
                PreparedStatement pst = con.prepareStatement(sSQL);
                rs=pst.executeQuery();
                
                while(rs.next ())
                {
                    fila[0] = rs.getString("numero_orden");
                    fila[1] = rs.getString("ibs");
                    fila[2] = rs.getString("fecha");
                    fila[3] = rs.getString("descripcion");
                    fila[4] = rs.getString("documento");
                    
                    modelo.addRow(fila);
                }  
                
                jtb_OrdenServicio.setModel(modelo);
            } 
            catch (Exception e) 
            {
            }
            desconectarBD();
        }
        
        public void mostrarDialogo()
        {
           Image icon = new ImageIcon(getClass().getResource("/imagenes/logo.png")).getImage();
           jdi_OrdenServicio.setIconImage(icon);
           jdi_OrdenServicio.setLocationRelativeTo(this);
           jdi_OrdenServicio.setSize(550,350);
           jdi_OrdenServicio.setVisible(true);
        }
        
        public void setControles(boolean activo)
        {
           txt_NumOrden.setEditable(activo);
           txt_Ibs.setEditable(activo);
           jdc_Fecha.setCalendar(null);
           txt_Descripcion.setEditable(activo);
           txt_Documento.setEditable(activo);
           
        }
        
        public void limpiarControles()
         
        {
            txt_NumOrden.setText("");
            txt_Ibs.setText("");
            jdc_Fecha.setDate(null);
            txt_Descripcion.setText("");
            txt_Documento.setText("");
            
        }
        
        public boolean cargarDialogo()
        {
         int fila = jtb_OrdenServicio.getSelectedRow();  
        
        if( fila == -1 ) 
        {
            JOptionPane.showMessageDialog(null,"Debe seleccionar el orden_de_servicio","Atencion",JOptionPane.WARNING_MESSAGE ); 
            return false;
        }
        else
        {
            DefaultTableModel modelo = new DefaultTableModel();
            
            modelo = (DefaultTableModel) jtb_OrdenServicio.getModel();
            
            txt_NumOrden.setText( modelo.getValueAt(fila,0).toString());
            txt_Ibs.setText( modelo.getValueAt(fila,1).toString());
            jdc_Fecha.setDateFormatString(accion);
            txt_Descripcion.setText( modelo.getValueAt(fila,3).toString());
            txt_Documento.setText( modelo.getValueAt(fila,4).toString());
            
            
            
            
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

        jdi_OrdenServicio = new javax.swing.JDialog();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txt_NumOrden = new javax.swing.JTextField();
        txt_Ibs = new javax.swing.JTextField();
        txt_Descripcion = new javax.swing.JTextField();
        txt_Documento = new javax.swing.JTextField();
        jdc_Fecha = new com.toedter.calendar.JDateChooser();
        btn_Aceptar = new javax.swing.JButton();
        btn_Cancelar = new javax.swing.JButton();
        btn_cerrar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cmb_Buscar = new javax.swing.JComboBox();
        txt_Buscar = new javax.swing.JTextField();
        btn_Buscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtb_OrdenServicio = new javax.swing.JTable();
        btn_Adicionar = new javax.swing.JButton();
        btn_Editar = new javax.swing.JButton();
        btn_Eliminar = new javax.swing.JButton();
        btn_CerrarOrden = new javax.swing.JButton();

        jLabel3.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel3.setText("Orden de Servicio");

        jLabel4.setText("Numero de Orden:");

        jLabel5.setText("Ibs:");

        jLabel7.setText("Fecha:");

        jLabel8.setText("Descripcion:");

        jLabel9.setText("Documento:");

        btn_Aceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/aceptar.png"))); // NOI18N
        btn_Aceptar.setText("Aceptar");
        btn_Aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_AceptarActionPerformed(evt);
            }
        });

        btn_Cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cancelar.png"))); // NOI18N
        btn_Cancelar.setText("Cancelar");

        btn_cerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cerrar.png"))); // NOI18N
        btn_cerrar.setText("Cerrar");
        btn_cerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cerrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jdi_OrdenServicioLayout = new javax.swing.GroupLayout(jdi_OrdenServicio.getContentPane());
        jdi_OrdenServicio.getContentPane().setLayout(jdi_OrdenServicioLayout);
        jdi_OrdenServicioLayout.setHorizontalGroup(
            jdi_OrdenServicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jdi_OrdenServicioLayout.createSequentialGroup()
                .addGroup(jdi_OrdenServicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jdi_OrdenServicioLayout.createSequentialGroup()
                        .addGap(112, 112, 112)
                        .addComponent(jLabel3))
                    .addGroup(jdi_OrdenServicioLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(jdi_OrdenServicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel9)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6)
                            .addComponent(jLabel8)
                            .addComponent(btn_Aceptar))
                        .addGroup(jdi_OrdenServicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jdi_OrdenServicioLayout.createSequentialGroup()
                                .addGap(52, 52, 52)
                                .addGroup(jdi_OrdenServicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txt_NumOrden)
                                    .addComponent(txt_Ibs)
                                    .addComponent(txt_Descripcion)
                                    .addComponent(txt_Documento)
                                    .addComponent(jdc_Fecha, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)))
                            .addGroup(jdi_OrdenServicioLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(btn_Cancelar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 122, Short.MAX_VALUE)
                                .addComponent(btn_cerrar)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jdi_OrdenServicioLayout.setVerticalGroup(
            jdi_OrdenServicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jdi_OrdenServicioLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel3)
                .addGap(38, 38, 38)
                .addGroup(jdi_OrdenServicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txt_NumOrden, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jdi_OrdenServicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txt_Ibs, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jdi_OrdenServicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jdc_Fecha, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jdi_OrdenServicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jdi_OrdenServicioLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel8))
                    .addComponent(txt_Descripcion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jdi_OrdenServicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txt_Documento, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(jdi_OrdenServicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_Aceptar)
                    .addComponent(btn_Cancelar)
                    .addComponent(btn_cerrar))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Orden de Servicio");

        jLabel2.setText("Buscar:");

        cmb_Buscar.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Todos", "Numero de Orden", "ibs", "Documento" }));

        btn_Buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/buscar.png"))); // NOI18N
        btn_Buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_BuscarActionPerformed(evt);
            }
        });

        jtb_OrdenServicio.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jtb_OrdenServicio);

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

        btn_CerrarOrden.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cerrar.png"))); // NOI18N
        btn_CerrarOrden.setText("Cerrar");
        btn_CerrarOrden.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_CerrarOrdenActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(157, 157, 157)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_Adicionar)
                        .addGap(18, 18, 18)
                        .addComponent(btn_Editar)
                        .addGap(18, 18, 18)
                        .addComponent(btn_Eliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_CerrarOrden))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 493, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(cmb_Buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_Buscar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_Buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel1)
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_Buscar)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(cmb_Buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txt_Buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_Adicionar)
                    .addComponent(btn_Editar)
                    .addComponent(btn_Eliminar)
                    .addComponent(btn_CerrarOrden))
                .addGap(32, 32, 32))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_EliminarActionPerformed
        if( cargarDialogo())
          {
             accion = "MODIFICAR";
             setControles(true);
             txt_Ibs.setEditable(false);
             mostrarDialogo();
          }
    }//GEN-LAST:event_btn_EliminarActionPerformed

    private void btn_AdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AdicionarActionPerformed
        accion ="ADICIONAR";
        mostrarDialogo();
        setControles(true);
        limpiarControles();
    }//GEN-LAST:event_btn_AdicionarActionPerformed

    private void btn_CerrarOrdenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CerrarOrdenActionPerformed
         this.dispose();
    }//GEN-LAST:event_btn_CerrarOrdenActionPerformed

    private void btn_EditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_EditarActionPerformed
        if( cargarDialogo())
          {
             accion = "MODIFICAR";
             setControles(true);
             txt_Ibs.setEditable(false);
             mostrarDialogo();
          }
    }//GEN-LAST:event_btn_EditarActionPerformed

    private void btn_cerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cerrarActionPerformed
        jdi_OrdenServicio.dispose();
    }//GEN-LAST:event_btn_cerrarActionPerformed

    private void btn_AceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AceptarActionPerformed
                String estado;
        Connection con = conectarBD();
        
        if(accion.equals("ADICIONAR"))
        {
            try
             
            {
                String sSQL="INSERT INTO orden_de_servicio VALUES (?,?,?,?,?)";
                PreparedStatement pst = con.prepareStatement(sSQL);

                

                pst.setString(1, txt_NumOrden.getText());
                pst.setString(2, txt_Ibs.getText());
                pst.setString(3, jdc_Fecha.getDateFormatString());
                pst.setString(4, txt_Descripcion.getText());
                pst.setString(5, txt_Documento.getText());
               
                
                JOptionPane.showMessageDialog(null, " "+txt_NumOrden.getText()+" "+txt_Ibs.getText()+" "+jdc_Fecha.getDateFormatString()+" "+txt_Descripcion.getText()+" "+txt_Documento.getText());

      
                pst.execute();
            }       
      
            catch (Exception e)
              {
               
                  
              
              }
        }    
        else if (accion.equals("MODIFICAR"))
        {
          
            try {
                String sSQL="update clientes set numero_orden=?,ibs=?,fecha=?,descripcion=? where documento=?";
                PreparedStatement pst = con.prepareStatement(sSQL);
                
                pst.setString(1, txt_Ibs.getText());
                pst.setString(2, jdc_Fecha.getDateFormatString());
                pst.setString(3, txt_Descripcion.getText());
                pst.setString(4, txt_Documento.getText());
                pst.setString(5, txt_NumOrden.getText());
                pst.execute();
            } catch (SQLException ex) {
                Logger.getLogger(OrdenServicio.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        else
        {
            try
            {
                String sSQL = "DELETE FROM orden_servicio WHERE numero_orden=?";
                
                PreparedStatement pst = con.prepareStatement(sSQL);
                
                pst.setString(1, txt_Ibs.getText());
                pst.execute();
                
            }
            catch ( Exception e )
            {
                JOptionPane.showMessageDialog(null, "Error al eliminar orden_de_servicio","Atencion",JOptionPane.WARNING_MESSAGE);
            }
        }
        
        cargarTabla("");
        desconectarBD();
        jdi_OrdenServicio.dispose();
    }//GEN-LAST:event_btn_AceptarActionPerformed

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
           sSQL =  " WHERE numero orden LIKE '%"+buscar+"%'";
        }
        else if( campo == 2 ) // ibs
        {
           sSQL =  " WHERE ibs LIKE '%"+buscar+"%'";
        }
        else if( campo == 3 ) //apellidos
        {
           sSQL =  " WHERE fecha LIKE '%"+buscar+"%'";
        }
        else if( campo == 4 ) // nombres
        {
           sSQL =  " WHERE descripcion LIKE '%"+buscar+"%'";
        }
        else
        {
           sSQL =  " WHERE Documento LIKE '%"+buscar+"%'";
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
            java.util.logging.Logger.getLogger(OrdenServicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OrdenServicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OrdenServicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OrdenServicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OrdenServicio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Aceptar;
    private javax.swing.JButton btn_Adicionar;
    private javax.swing.JButton btn_Buscar;
    private javax.swing.JButton btn_Cancelar;
    private javax.swing.JButton btn_CerrarOrden;
    private javax.swing.JButton btn_Editar;
    private javax.swing.JButton btn_Eliminar;
    private javax.swing.JButton btn_cerrar;
    private javax.swing.JComboBox cmb_Buscar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private com.toedter.calendar.JDateChooser jdc_Fecha;
    private javax.swing.JDialog jdi_OrdenServicio;
    private javax.swing.JTable jtb_OrdenServicio;
    private javax.swing.JTextField txt_Buscar;
    private javax.swing.JTextField txt_Descripcion;
    private javax.swing.JTextField txt_Documento;
    private javax.swing.JTextField txt_Ibs;
    private javax.swing.JTextField txt_NumOrden;
    // End of variables declaration//GEN-END:variables
}
