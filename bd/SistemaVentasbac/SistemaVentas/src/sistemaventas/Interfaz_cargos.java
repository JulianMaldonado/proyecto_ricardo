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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author JULIAN
 */
public class Interfaz_cargos extends javax.swing.JInternalFrame {

   CallableStatement cts;
   ResultSet r;
   Connection cn;
   conexion conectar=new conexion();
 
   
    /**
     * Creates new form Interfaz_cargos
     */
    public Interfaz_cargos() {
        initComponents();
        cn=conectar.conectado();
        inhabilitar();
        cargar();
        
       
    }
  
    public void cargar(){
             
       DefaultTableModel tabla= new DefaultTableModel();
       try{
       tabla.addColumn("No.");
       tabla.addColumn("CARGOS");
       tabla.addColumn("SUELDO");
       
       
       cts=cn.prepareCall("{call mostrarcargos}");
       r=cts.executeQuery();
       while (r.next()){
       Object dato[]=new  Object[3];
       for (int i=0; i<3; i++){
           dato[i]=r.getString(i+1);

       }
       tabla.addRow(dato);
       }
       this.jTable1.setModel(tabla);

       }catch (Exception e){}
       
       
       
}
    
    
    
    
void habilitar()
    {
       
        txtdescripcion.setEnabled(true);
        txtdescripcion.setText("");
        txtsueldo.setEnabled(true);
        txtsueldo.setText("");
        btnguardar.setEnabled(true); 
        btnbuscar.setEnabled(true);
        btncancelar.setEnabled(true);
              
    }
     void inhabilitar()
    {
       
       
        txtdescripcion.setEnabled(false);
        txtdescripcion.setText("");
        txtsueldo.setEnabled(false);
        txtsueldo.setText("");
        btnguardar.setEnabled(false); 
        btnbuscar.setEnabled(false);
        btncancelar.setEnabled(false);
              
    }
    
     
        
     
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtsueldo = new javax.swing.JTextField();
        txtdescripcion = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnguardar = new javax.swing.JButton();
        btnnuevo = new javax.swing.JButton();
        btncancelar = new javax.swing.JButton();
        btnbuscar = new javax.swing.JButton();
        btnsalir = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Creacion de Cargos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 18))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setText("Q.");

        txtsueldo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtsueldo.setText("jTextField1");
        txtsueldo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtsueldoKeyTyped(evt);
            }
        });

        txtdescripcion.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtdescripcion.setText("jTextField1");
        txtdescripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdescripcionActionPerformed(evt);
            }
        });
        txtdescripcion.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtdescripcionFocusLost(evt);
            }
        });
        txtdescripcion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtdescripcionKeyPressed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setText("Sueldo:");

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setText("Descripcion:");

        btnguardar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnguardar.setText("Guardar");
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
            }
        });

        btnnuevo.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnnuevo.setText("Nuevo");
        btnnuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnuevoActionPerformed(evt);
            }
        });

        btncancelar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btncancelar.setText("Cancelar");
        btncancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelarActionPerformed(evt);
            }
        });

        btnbuscar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnbuscar.setText("Modificar");
        btnbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscarActionPerformed(evt);
            }
        });

        btnsalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/16 (Delete).jpg"))); // NOI18N
        btnsalir.setText("SALIR");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtsueldo, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtdescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(btnnuevo)
                        .addGap(16, 16, 16)
                        .addComponent(btnguardar)
                        .addGap(18, 18, 18)
                        .addComponent(btnbuscar)
                        .addGap(18, 18, 18)
                        .addComponent(btncancelar)
                        .addGap(114, 114, 114))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(btnsalir)
                        .addGap(100, 100, 100))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(btnsalir)
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtdescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtsueldo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnguardar)
                    .addComponent(btnnuevo)
                    .addComponent(btncancelar)
                    .addComponent(btnbuscar))
                .addGap(466, 466, 466))
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 477, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 477, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(59, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(59, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

     
    
    
    
    
    
    
    
    
    
    
    
    
    String accion = "Insertar";
    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
        // GUARDAR

        ConexionMySQL mysql = new ConexionMySQL(); //abre la conecxion
        Connection cn = mysql.Conectar(); //abre la conecxion

        String des, sueldo;
        String guardar="";
        String mensaje = "";
        des = txtdescripcion.getText();
        sueldo = txtsueldo.getText();

        if (txtdescripcion.getText().isEmpty() || txtsueldo.getText().isEmpty()) //VALIDAMOS QUE LOS CAMPOS QUE NO ESTE VACIOS
        JOptionPane.showMessageDialog(null,"EXISTEN CAMPOS VACIOS","OJO",JOptionPane.PLAIN_MESSAGE);

        else if (accion.equals("Insertar"))
        {

            guardar = "call guardar_cargo (?, ?)";


            mensaje = "LOS DATOS SE HAN GUARDADO CORRECTAMENTE...";
            
            txtdescripcion.setText("");
            txtsueldo.setText("");
            
            inhabilitar ();
        cargar();
            
            
        }

        try
        {
            PreparedStatement pst = cn.prepareStatement(guardar); //preparo guardar//
            pst.setString(1, des);
            pst.setString(2, sueldo);

            int n = pst.executeUpdate();

            if(n > 0)
            {
                JOptionPane.showMessageDialog(null, mensaje);
            }
        }
        catch (SQLException ex)
        {

            //JOptionPane.showMessageDialog(null, ex);
        }

    }//GEN-LAST:event_btnguardarActionPerformed

    private void btnnuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnuevoActionPerformed
        // TODO add your handling code here:
        txtdescripcion.requestFocus();
        habilitar();
        cargar();
        

    }//GEN-LAST:event_btnnuevoActionPerformed

    private void btncancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelarActionPerformed
        // TODO add your handling code here:
        inhabilitar();
    }//GEN-LAST:event_btncancelarActionPerformed

    private void btnbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscarActionPerformed
      
    modifica_cargos modificacargo= new modifica_cargos();
    SistemaV.jDesktopPane1.add(modificacargo);
    modificacargo.toFront();
    modificacargo.setVisible(true);
        

    }//GEN-LAST:event_btnbuscarActionPerformed

    private void txtdescripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdescripcionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdescripcionActionPerformed

    private void txtdescripcionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdescripcionKeyPressed
        // TODO add your handling code here:
         String s;
        s= txtdescripcion.getText();
        txtdescripcion.setText(s.toUpperCase());
    }//GEN-LAST:event_txtdescripcionKeyPressed

    private void txtdescripcionFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtdescripcionFocusLost
        // TODO add your handling code here:
         String s;
        s= txtdescripcion.getText();
        txtdescripcion.setText(s.toUpperCase());
    }//GEN-LAST:event_txtdescripcionFocusLost

    private void txtsueldoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtsueldoKeyTyped
        // TODO add your handling code here:
        char car = evt.getKeyChar();  
if((car<'0' || car>'9') && txtsueldo.getText().contains(".")){
   evt.consume();
}else if((car<'0' || car>'9') && (car!='.')){
   evt.consume();
}
    }//GEN-LAST:event_txtsueldoKeyTyped
//******************************************//
public void filtro() {
/*//Obtiene el valor del JTextField para el filtro
 TableRowSorter trsfiltro; //creamos el filtro    
filtro = txtfiltro.getText();
int columna = 3;
trsfiltro.setRowFilter(RowFilter.regexFilter(txtfiltro.getText(), columna));
}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnbuscar;
    private javax.swing.JButton btncancelar;
    private javax.swing.JButton btnguardar;
    private javax.swing.JButton btnnuevo;
    private javax.swing.JButton btnsalir;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtdescripcion;
    private javax.swing.JTextField txtsueldo;
    // End of variables declaration//GEN-END:variables
}
