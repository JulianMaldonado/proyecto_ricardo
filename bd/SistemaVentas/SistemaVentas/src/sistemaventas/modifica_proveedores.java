/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaventas;
import java.awt.*;
import javax.swing.*;
import java.sql.*;
import javax.swing.DefaultComboBoxModel;
import Conexion.ConexionMySQL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

import javax.swing.JOptionPane;

/**
 *
 * @author JULIAN
 */
public class modifica_proveedores extends javax.swing.JInternalFrame {
    DefaultComboBoxModel modeloCombo = new DefaultComboBoxModel();
    String id;

    DefaultComboBoxModel modelociudad = new DefaultComboBoxModel();
     String idciudad;
     
   CallableStatement cts;
   ResultSet r;
   Connection cn;
   conexion conectar=new conexion();
    /**
     * Creates new form modifica_proveedores
     */
    public modifica_proveedores() {
        initComponents();
        llenarciudad();
        llenar_combo();
        lbldepto.setVisible(false);
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cboproveedor = new javax.swing.JComboBox();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtproveedor = new javax.swing.JTextField();
        txttelefono = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtcorreo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cbodepto = new javax.swing.JComboBox();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtcontacto = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtdireccion = new javax.swing.JTextField();
        lbldepto = new javax.swing.JLabel();
        txttelcontacto = new javax.swing.JTextField();
        btmodifica = new javax.swing.JButton();
        btmodifica1 = new javax.swing.JButton();

        cboproveedor.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        cboproveedor.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccion" }));
        cboproveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboproveedorActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos De Proveedores", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14), new java.awt.Color(51, 0, 255))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Direccion:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Correo:");

        txtproveedor.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtproveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtproveedorActionPerformed(evt);
            }
        });
        txtproveedor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtproveedorKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtproveedorKeyTyped(evt);
            }
        });

        txttelefono.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txttelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttelefonoActionPerformed(evt);
            }
        });
        txttelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txttelefonoKeyTyped(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("Telefono:");

        txtcorreo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtcorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcorreoActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Nombre Proveedor:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 0, 0));
        jLabel5.setText("*");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 0, 0));
        jLabel7.setText("*");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 0, 0));
        jLabel8.setText("*");

        cbodepto.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbodepto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbodeptoActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("Departamento:");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setText("Contacto:");

        txtcontacto.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtcontacto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcontactoActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setText("Telefono de Contacto:");

        txtdireccion.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtdireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdireccionActionPerformed(evt);
            }
        });

        lbldepto.setText("depto");

        txttelcontacto.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txttelcontacto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttelcontactoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel9)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel8))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGap(2, 2, 2)
                                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addComponent(jLabel3))
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(jLabel5))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                            .addGap(10, 10, 10)
                                            .addComponent(jLabel7)))))
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtproveedor)
                            .addComponent(txtdireccion)
                            .addComponent(cbodepto, 0, 327, Short.MAX_VALUE)
                            .addComponent(txttelefono)
                            .addComponent(txtcorreo)
                            .addComponent(txtcontacto, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txttelcontacto)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lbldepto)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(lbldepto)
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtproveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel2)
                    .addComponent(txtdireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(txttelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbodepto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtcorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtcontacto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txttelcontacto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        btmodifica.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btmodifica.setText("MODIFICAR");
        btmodifica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btmodificaActionPerformed(evt);
            }
        });

        btmodifica1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btmodifica1.setText("CERRAR");
        btmodifica1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btmodifica1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cboproveedor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(48, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btmodifica1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(153, 153, 153)
                .addComponent(btmodifica)
                .addGap(120, 120, 120))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cboproveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btmodifica)
                    .addComponent(btmodifica1))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    void llenar_combo() {
            try {
    
            ConexionMySQL mysql = new ConexionMySQL();
            Connection cn = mysql.Conectar();
                
                
           PreparedStatement pstmt = null;
            ResultSet rs = null;
            String llenar_combo="select id_proveedor, CONCAT (nombre_comercial,' CONTACTO ',nombre_contacto) as detalle  from proveedor ";             
                      
                
pstmt = cn.prepareStatement(llenar_combo);
rs = pstmt.executeQuery();
modeloCombo.addElement(new mcombos("VER PROVEEDORES","0"));
cboproveedor.setModel(modeloCombo);
while (rs.next()) 
{
    modeloCombo.addElement(new mcombos(rs.getString("detalle"),rs.getString("id_proveedor"))); //aca meto el id q jalo con mcombos
   //  cbocargo.setModel(modeloCombo);
       }
}
catch(Exception e) {}
            
   //hay q declarar antes  DefaultComboBoxModel modeloCombo = new DefaultComboBoxModel(); en la parte de clases publicas
            
  } 
    
    
    
    
    private void cboproveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboproveedorActionPerformed
        mcombos mcombos1 =(mcombos) cboproveedor.getSelectedItem(); //esto es por el mcombos
        id = mcombos1.getID();

        btmodifica.setEnabled(true);
        
        
        
           this.txtproveedor.setEnabled(true);
           this.txttelcontacto.setEnabled(true);
           this.txttelefono.setEnabled(true);
           this.cbodepto.setEnabled(true);
           this.txtcorreo.setEnabled(true);
           this.txtcontacto.setEnabled(true);
           this.txtdireccion.setEnabled(true);
                     
           this.txtproveedor.requestFocus();
      
       

        //JOptionPane.showMessageDialog(null,id);
        JOptionPane.showMessageDialog(null,id,"EL PROVEEDOR A EDITAR ES EL NUMERO:",JOptionPane.PLAIN_MESSAGE);

    }//GEN-LAST:event_cboproveedorActionPerformed

 private void DESABILITAR(){
           this.txtproveedor.setEnabled(false);
           this.txttelcontacto.setEnabled(false);
           this.txttelefono.setEnabled(false);
           this.cbodepto.setEnabled(false);
           this.txtcorreo.setEnabled(false);
           this.txtcontacto.setEnabled(false);
           this.txtdireccion.setEnabled(false);}    
    
       
    
    void llenarciudad(){
          

 try {
    
            ConexionMySQL mysql = new ConexionMySQL();
            Connection cn = mysql.Conectar();
                
                
           PreparedStatement pstmt = null;
            ResultSet rs = null;
            String llenarciudad="select id_ciudad, descripcion as detalle  from ciudad ";             
                      
                
pstmt = cn.prepareStatement(llenarciudad);
rs = pstmt.executeQuery();
modelociudad.addElement(new mcombos("VER DEPARTAMENTOS","0"));
cbodepto.setModel(modelociudad);
while (rs.next()) 
{
    modelociudad.addElement(new mcombos(rs.getString("detalle"),rs.getString("id_ciudad"))); //aca meto el id q jalo con mcombos
   //  cbocargo.setModel(modeloCombo);
       }
}
catch(Exception e) {}
            
   //hay q declarar antes  DefaultComboBoxModel modeloCombo = new DefaultComboBoxModel(); en la parte de clases publicas
    
 
 
 
 
 }
    
    
    
    
    private void txtproveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtproveedorActionPerformed
        // TODO add your handling code here:

        txtproveedor.transferFocus();
    }//GEN-LAST:event_txtproveedorActionPerformed

    private void txtproveedorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtproveedorKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtproveedorKeyReleased

    private void txtproveedorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtproveedorKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtproveedorKeyTyped

    private void txttelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttelefonoActionPerformed
        // TODO add your handling code here:

        txttelefono.transferFocus();
    }//GEN-LAST:event_txttelefonoActionPerformed

    private void txttelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txttelefonoKeyTyped
        // TODO add your handling code here:
        char car=evt.getKeyChar();
        if(  txttelefono.getText().length()>=8)evt.consume();
        if ((car<'0'||car>'9'))evt.consume();
    }//GEN-LAST:event_txttelefonoKeyTyped

    private void txtcorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcorreoActionPerformed
        // TODO add your handling code here:

        txtcorreo.transferFocus();
    }//GEN-LAST:event_txtcorreoActionPerformed

    private void cbodeptoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbodeptoActionPerformed
        // TODO add your handling code here:
        mcombos mcombos1 =(mcombos) cbodepto.getSelectedItem(); //esto es por el mcombos
        idciudad = mcombos1.getID();

        String id = mcombos1.getID();
        lbldepto.setText(id);
    }//GEN-LAST:event_cbodeptoActionPerformed

    private void txtcontactoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcontactoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcontactoActionPerformed

    private void txtdireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdireccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdireccionActionPerformed

    private void txttelcontactoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttelcontactoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttelcontactoActionPerformed

    private void btmodificaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btmodificaActionPerformed
        // TODO add your handling code here:
        
        ConexionMySQL mysql = new ConexionMySQL(); //abre la conecxion
        Connection cn = mysql.Conectar(); //abre la conecxion
  
              
        
        String nom=txtproveedor.getText();
        String direccion=txtdireccion.getText();
        String tel=txttelefono.getText();
        String idciu=lbldepto.getText();
        String mail=txtcorreo.getText();
        String contacto=txtcontacto.getText();
        String telcontac=txttelcontacto.getText();

        try {

            if(  !nom.equals("") && !direccion.equals("") && !tel.equals("") &&! idciu.equals("") &&!mail.equals("") &&!contacto.equals("") &&!telcontac.equals(""))
            //enviar datos a validar

            {

                cts=cn.prepareCall("{ call modifica_proveedor(?,?,?,?,?,?,?,?)}");

                cts.setString(1, id);
                cts.setString(2, nom);
                cts.setString(3, direccion);
                cts.setString(4, tel);
                cts.setString(5, idciu);
                cts.setString(6, mail);
                cts.setString(7, contacto);
                cts.setString(8, telcontac);
                

                int rpta=cts.executeUpdate();
                if(rpta==1)
                JOptionPane.showMessageDialog(this,"PROVEEDOR A SIDO MODIFICADO CORRECTAMENTE!!","Atencion",JOptionPane.INFORMATION_MESSAGE);

//                BOTONES();
  //              limpiar();
                DESABILITAR();
            //   cargar();

            }

            else

            {
                JOptionPane.showMessageDialog(null, "Debe llenar todos los campos que tengan (*) .\n" +
                    "NO puede dejar ningun campo vacio");
                //txtNit.requestFocusInWindow();
                //txtNombre.requestFocusInWindow();
                //txtDireccion.requestFocusInWindow();

            }

        } catch (SQLException | HeadlessException e) {
            Logger.getLogger(Empleados.class.getName()).log(Level.SEVERE, null, e);
        }
            txtproveedor.setText(""); 
            txttelcontacto.setText(""); 
            txttelefono.setText(""); 
            cbodepto.setEnabled(false);
            txtcorreo.setText(""); 
            txtcontacto.setText(""); 
            txtdireccion.setText(""); 
            
             
            
             Proveedores prov= new Proveedores();
    SistemaV.jDesktopPane1.add(prov);
    prov.toFront();
    prov.setVisible(true);
    this.dispose();
           
        
    }//GEN-LAST:event_btmodificaActionPerformed

    private void btmodifica1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btmodifica1ActionPerformed
         Proveedores proveedor= new Proveedores();
    SistemaV.jDesktopPane1.add(proveedor);
    proveedor.toFront();
    proveedor.setVisible(true);
        
        
        this.dispose();
        
        // TODO add your handling code here:
    }//GEN-LAST:event_btmodifica1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btmodifica;
    private javax.swing.JButton btmodifica1;
    private javax.swing.JComboBox cbodepto;
    private javax.swing.JComboBox cboproveedor;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbldepto;
    private javax.swing.JTextField txtcontacto;
    private javax.swing.JTextField txtcorreo;
    private javax.swing.JTextField txtdireccion;
    private javax.swing.JTextField txtproveedor;
    private javax.swing.JTextField txttelcontacto;
    private javax.swing.JTextField txttelefono;
    // End of variables declaration//GEN-END:variables
}
