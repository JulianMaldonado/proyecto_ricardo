
package sistemaventas;
import java.awt.HeadlessException;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.DefaultComboBoxModel;
import Conexion.ConexionMySQL;
import javax.swing.table.DefaultTableModel;

public class Proveedores extends javax.swing.JInternalFrame {
   //agrego para el filtro
    DefaultTableModel model;
 //   DefaultComboBoxModel modelociudad = new DefaultComboBoxModel();
  //   String idciudad;
     
   CallableStatement cts;
   ResultSet r;
   Connection cn;
   conexion conectar=new conexion();
     

     
    public Proveedores() {
       
        initComponents();
        
        BOTONES();
        DESABILITAR();
        cn=conectar.conectado();
        cargar("");
        llenarnivel();
        llenarciudad();
      
                
       // lblproveedor.setVisible(false); 
       // lbldepto.setVisible(false);
    }
    
    public void cargar(String valor){
        
       String [] titulos = {"No.","PROVEEDOR","DIRECCION","TELEFONO","DEPARTAMENTO","CORREO","CONTACTO","TEL. CONTACTO","TIPO PROVEEDOR"};
     String [] registros = new String [10];
     
    String sql="select proveedor.id_proveedor, proveedor.nombre_comercial,proveedor.direccion,proveedor.telefono,ciudad.descripcion,proveedor.correo,proveedor.nombre_contacto,proveedor.telefono_contacto,nivel_proveedor.nivelprodescripcion from proveedor,ciudad,nivel_proveedor where nombre_comercial LIKE '%"+valor+"%' and  proveedor.id_ciudad=ciudad.id_ciudad and proveedor.id_nivelprove=nivel_proveedor.id_nivelprove";
   // String sql="select * from empleado where em_nombre LIKE '%"+valor+"%'";
     model= new DefaultTableModel (null,titulos);
     
    //conexion conectar=new conexion();
    cn=conectar.conectado();
    Statement st;
        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while (rs.next()){
            registros [0]=rs.getString("id_proveedor");
            registros [1]=rs.getString("nombre_comercial");
            registros [2]=rs.getString("direccion");
            registros [3]=rs.getString("telefono");
            registros [4]=rs.getString("descripcion");
            registros [5]=rs.getString("correo");
            registros [6]=rs.getString("nombre_contacto");
            registros [7]=rs.getString("telefono_contacto");
            registros [8]=rs.getString("nivelprodescripcion");
          
           model.addRow(registros);
                  
            }
           jTable1.setModel(model);
                
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
     
        
        
        
        
        
        
        
        
        
        
        
        
       
       /*DefaultTableModel tabla= new DefaultTableModel();
       try{
       tabla.addColumn("No.");
       tabla.addColumn("PROVEEDOR");
       tabla.addColumn("DIRECCION");
       tabla.addColumn("TELEFONO");
       tabla.addColumn("DEPTO");
       tabla.addColumn("CORREO");
       tabla.addColumn("CONTACTO");
       tabla.addColumn("CEL CONTACTO");
       
       cts=cn.prepareCall("{call mostrarproveedor}");
       r=cts.executeQuery();
       while (r.next()){
       Object dato[]=new  Object[8];
       for (int i=0; i<8; i++){
           dato[i]=r.getString(i+1);

       }
       tabla.addRow(dato);
       }
       this.jTable1.setModel(tabla);

       }catch (Exception e){}
       
       */
       
}

public void llenarciudad(){

  Connection cn;
conexion conectar=new conexion();
    cn=conectar.conectado();
PreparedStatement pstmt = null;
ResultSet rs = null;
String sql = "SELECT descripcion as nombre FROM ciudad ORDER BY descripcion ";
try {
pstmt = cn.prepareStatement(sql);
rs = pstmt.executeQuery();
while (rs.next()) {
String valor = rs.getString("nombre");
// Aquí recuperas los valores obtenidos y realizas la carga del a mostrar

cbodepto.addItem(valor);

}
}
catch(Exception e) {}
finally {
try {
if (pstmt != null) pstmt.close();
}
catch (Exception e) {}
try {
if (rs != null) rs.close();
}
catch (Exception e) {}
}

    }    

 public void pasaidciudad(){


  Connection cn;
    conexion conectar=new conexion();
    cn=conectar.conectado();
PreparedStatement pstmt = null;
ResultSet rs = null;
String sql = "SELECT id_ciudad as total FROM ciudad WHERE descripcion='"+ cbodepto.getSelectedItem().toString()  +"'  ";
try {
pstmt = cn.prepareStatement(sql);
rs = pstmt.executeQuery();
while (rs.next()) {
String valor = rs.getString("total");
// Aquí recuperas los valores obtenidos y realizas la carga del a mostrar
lbldepto.setText(valor);

}
}
catch(Exception e) {}
finally {
try {
if (pstmt != null) pstmt.close();
}
catch (Exception e) {}
try {
if (rs != null) rs.close();
}
catch (Exception e) {}
}


}   

 
 public void llenarnivel(){

  Connection cn;
conexion conectar=new conexion();
    cn=conectar.conectado();
PreparedStatement pstmt = null;
ResultSet rs = null;
String sql = "SELECT nivelprodescripcion as nombre FROM nivel_proveedor ORDER BY categoria_prove ";
try {
pstmt = cn.prepareStatement(sql);
rs = pstmt.executeQuery();
while (rs.next()) {
String valor = rs.getString("nombre");
// Aquí recuperas los valores obtenidos y realizas la carga del a mostrar

cbonivel.addItem(valor);

}
}
catch(Exception e) {}
finally {
try {
if (pstmt != null) pstmt.close();
}
catch (Exception e) {}
try {
if (rs != null) rs.close();
}
catch (Exception e) {}
}

    }    

 public void pasaidnivel(){


  Connection cn;
    conexion conectar=new conexion();
    cn=conectar.conectado();
PreparedStatement pstmt = null;
ResultSet rs = null;
String sql = "SELECT id_nivelprove as total FROM nivel_proveedor WHERE nivelprodescripcion='"+ cbonivel.getSelectedItem().toString()  +"'  ";
try {
pstmt = cn.prepareStatement(sql);
rs = pstmt.executeQuery();
while (rs.next()) {
String valor = rs.getString("total");
// Aquí recuperas los valores obtenidos y realizas la carga del a mostrar
lblnivel.setText(valor);

}
}
catch(Exception e) {}
finally {
try {
if (pstmt != null) pstmt.close();
}
catch (Exception e) {}
try {
if (rs != null) rs.close();
}
catch (Exception e) {}
}


}   
 
 
 
 
 
 
 
 
 
 
 
 
 public void limpiar(){
   
        this.txtproveedor.setText("");    
        this.txttelcontacto.setText("");
        this.txttelefono.setText("");
        this.cbodepto.setSelectedIndex(0);
        this.txtcorreo.setText("");
        this.txtcontacto.setText("");
        this.txtdireccion.setText("");
        this.cbonivel.setSelectedIndex(0);
        this.txtproveedor.requestFocus();}

public void ABILITAR(){
          
           this.txtproveedor.setEnabled(true);
           this.txttelcontacto.setEnabled(true);
           this.txttelefono.setEnabled(true);
           this.cbodepto.setEnabled(true);
           this.txtcorreo.setEnabled(true);
           this.txtcontacto.setEnabled(true);
           this.txtdireccion.setEnabled(true);
           this.cbonivel.setEnabled(true);          
           this.txtproveedor.requestFocus();}


 private void DESABILITAR(){
           this.txtproveedor.setEnabled(false);
           this.txttelcontacto.setEnabled(false);
           this.txttelefono.setEnabled(false);
           this.cbodepto.setEnabled(false);
           this.txtcorreo.setEnabled(false);
           this.txtcontacto.setEnabled(false);
           this.txtdireccion.setEnabled(false);
            this.cbonivel.setEnabled(false);        
           this.txtproveedor.requestFocus();
           
                  }
 
 private void BOTONES(){
           this.btnguardar.setEnabled(false);
           this.btnnuevo.setEnabled(true);
           this.btnbuscar.setEnabled(true);
           this.btnmodificar.setEnabled(false);
           this.btneliminar.setEnabled(false);
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
        lblproveedor = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        cbonivel = new javax.swing.JComboBox();
        lblnivel = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btnnuevo = new javax.swing.JButton();
        btnguardar = new javax.swing.JButton();
        btnbuscar = new javax.swing.JButton();
        btnmodificar = new javax.swing.JButton();
        btneliminar = new javax.swing.JButton();
        btncancelar = new javax.swing.JButton();
        btnsalir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtfiltro = new javax.swing.JTextField();

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
        txtproveedor.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtproveedorFocusLost(evt);
            }
        });
        txtproveedor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtproveedorKeyTyped(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtproveedorKeyReleased(evt);
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
        txtcorreo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtcorreoFocusLost(evt);
            }
        });
        txtcorreo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcorreoKeyTyped(evt);
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

        cbodepto.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cbodepto.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione Departamento" }));
        cbodepto.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbodeptoItemStateChanged(evt);
            }
        });
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
        txtcontacto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtcontactoFocusLost(evt);
            }
        });
        txtcontacto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcontactoKeyTyped(evt);
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
        txtdireccion.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtdireccionFocusLost(evt);
            }
        });
        txtdireccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtdireccionKeyTyped(evt);
            }
        });

        lbldepto.setText("depto");

        txttelcontacto.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txttelcontacto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttelcontactoActionPerformed(evt);
            }
        });
        txttelcontacto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txttelcontactoKeyTyped(evt);
            }
        });

        lblproveedor.setText("PROVEEDOR");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setText("Nivel Proveedor:");

        cbonivel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cbonivel.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Nivel del Proveeodor" }));
        cbonivel.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbonivelItemStateChanged(evt);
            }
        });
        cbonivel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbonivelActionPerformed(evt);
            }
        });

        lblnivel.setText("nivelPro");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lbldepto)
                        .addGap(18, 18, 18)
                        .addComponent(lblnivel)
                        .addGap(91, 91, 91)
                        .addComponent(lblproveedor)
                        .addGap(0, 0, Short.MAX_VALUE))
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
                            .addComponent(jLabel12)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbonivel, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtproveedor)
                            .addComponent(txtdireccion)
                            .addComponent(cbodepto, 0, 327, Short.MAX_VALUE)
                            .addComponent(txttelefono)
                            .addComponent(txtcorreo)
                            .addComponent(txtcontacto, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txttelcontacto))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbldepto)
                    .addComponent(lblproveedor)
                    .addComponent(lblnivel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txttelcontacto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbonivel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnnuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/16 (User add).jpg"))); // NOI18N
        btnnuevo.setText("NUEVO");
        btnnuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnuevoActionPerformed(evt);
            }
        });

        btnguardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/16 (Save).jpg"))); // NOI18N
        btnguardar.setText("REGISTRAR");
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
            }
        });

        btnbuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/16 (Search).jpg"))); // NOI18N
        btnbuscar.setText("BUSCAR");
        btnbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscarActionPerformed(evt);
            }
        });

        btnmodificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/16 (User edit).jpg"))); // NOI18N
        btnmodificar.setText("MODIFICAR");
        btnmodificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmodificarActionPerformed(evt);
            }
        });

        btneliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/16 (User delete).jpg"))); // NOI18N
        btneliminar.setText("ELIMINAR");
        btneliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminarActionPerformed(evt);
            }
        });

        btncancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Wzdelete.jpg"))); // NOI18N
        btncancelar.setText("CANCELAR");
        btncancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelarActionPerformed(evt);
            }
        });

        btnsalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/16 (Delete).jpg"))); // NOI18N
        btnsalir.setText("SALIR");
        btnsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnmodificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btneliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnbuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnnuevo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnguardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnsalir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btncancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnnuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnguardar, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnbuscar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnmodificar)
                .addGap(9, 9, 9)
                .addComponent(btneliminar)
                .addGap(9, 9, 9)
                .addComponent(btncancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnsalir, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Ingresa Proveedor:");

        txtfiltro.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtfiltro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtfiltroKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 152, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(txtfiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(230, 230, 230))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtfiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtproveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtproveedorActionPerformed
        // TODO add your handling code here:

        txtproveedor.transferFocus();

    }//GEN-LAST:event_txtproveedorActionPerformed

    
    
    
    
    
    private void txtproveedorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtproveedorKeyReleased
        // TODO add your handling code here:

    }//GEN-LAST:event_txtproveedorKeyReleased

    private void txtproveedorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtproveedorKeyTyped
        // TODO add your handling code here:
        String s;
        s= txtproveedor.getText();
        txtproveedor.setText(s.toUpperCase());

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

    
    
    
    private void txtcontactoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcontactoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcontactoActionPerformed

    private void txtdireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdireccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdireccionActionPerformed

    private void btnnuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnuevoActionPerformed
        // TODO add your handling code here:
        txtproveedor.requestFocus();
        //llenarciudad();
        //llenarnivel();
        limpiar();
        
        ABILITAR();
        btnguardar.setEnabled(true);
        btnmodificar.setEnabled(true);
        btneliminar.setEnabled(false);
        btnnuevo.setEnabled(false);
        btnbuscar.setEnabled(false);
    }//GEN-LAST:event_btnnuevoActionPerformed

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
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
        String idnivel=lblnivel.getText();
        try {

            if(  !nom.equals("") && !direccion.equals("") && !tel.equals("") &&! idciu.equals("") &&!mail.equals("") &&!contacto.equals("") &&!telcontac.equals("")&&!idnivel.equals(""))
            //enviar datos a validar

            {

                cts=cn.prepareCall("{ call guardar_proveedor(?,?,?,?,?,?,?,?)}");

                cts.setString(1, nom);
                cts.setString(2, direccion);
                cts.setString(3, tel);
                cts.setString(4, idciu);
                cts.setString(5, mail);
                cts.setString(6, contacto);
                cts.setString(7, telcontac);
                cts.setString(8, idnivel);
                

                int rpta=cts.executeUpdate();
                if(rpta==1)
                JOptionPane.showMessageDialog(this,"CLIENTE REGISTRADO CORRECTAMENTE!!","Atencion",JOptionPane.INFORMATION_MESSAGE);

                BOTONES();
                limpiar();
                DESABILITAR();
                cargar("");

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
    
    }//GEN-LAST:event_btnguardarActionPerformed

    private void btnbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscarActionPerformed
        // TODO add your handling code here:
        String cod=txtfiltro.getText(); //JOptionPane.showInputDialog("INGRESE EL DNI DE EMPLEADO A BUSCAR si decea puede editalpara modificar o eliminar el registro");
       String id=lblproveedor.getText();
        try {
            cts=cn.prepareCall("{call buscaproveedor(?)}");
            cts.setString(1, cod);
            r=cts.executeQuery();

            if(r.next()){
                JOptionPane.showMessageDialog(this,"Proveedor Encontrado!!","Aviso",JOptionPane.INFORMATION_MESSAGE);
               
                this.lblproveedor.setText(r.getString(1));
                this.txtproveedor.setText(r.getString(2));
                this.txtdireccion.setText(r.getString(3));
                this.txttelefono.setText(r.getString(4));
                this.lbldepto.setText(r.getString(5));
                this.cbodepto.setSelectedItem(r.getString(5).toString());
                this.txtcorreo.setText(r.getString(6));
                this.txtcontacto.setText(r.getString(7));
                this.txttelcontacto.setText(r.getString(8));
                this.lblnivel.setText(r.getString(9));
                ABILITAR();
                this.btnguardar.setEnabled(false);
                this.btnnuevo.setEnabled(false);
                this.btnbuscar.setEnabled(false);
                this.btnmodificar.setEnabled(true);
                this.btneliminar.setEnabled(true);
            }else{

                JOptionPane.showMessageDialog(this,"Proveedor  No Encontrado!!","Aviso",JOptionPane.INFORMATION_MESSAGE);

            }
        } catch (SQLException | HeadlessException e) {JOptionPane.showMessageDialog(this, e.toString());
        }
    }//GEN-LAST:event_btnbuscarActionPerformed

    private void btnmodificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmodificarActionPerformed
        // TODO add your handling code here:
        
       /* modifica_proveedores modifica= new modifica_proveedores();
    SistemaV.jDesktopPane1.add(modifica);
    modifica.toFront();
    modifica.setVisible(true);
    this.dispose();*/
    
        
     ConexionMySQL mysql = new ConexionMySQL(); //abre la conecxion
        Connection cn = mysql.Conectar(); //abre la conecxion
  
      
        
        String id=lblproveedor.getText();
        String nom=txtproveedor.getText();
        String direccion=txtdireccion.getText();
        String tel=txttelefono.getText();
        String idciu=lbldepto.getText();
        String mail=txtcorreo.getText();
        String contacto=txtcontacto.getText();
        String telcontac=txttelcontacto.getText();
        String idnivel=lblnivel.getText();
     
        
        

        try {

            if(  !nom.equals("") && !direccion.equals("") && !tel.equals("") &&! idciu.equals("") &&!mail.equals("") &&!contacto.equals("") &&!telcontac.equals("")&&!idnivel.equals(""))
            //enviar datos a validar

            {

                cts=cn.prepareCall("{ call modifica_proveedor(?,?,?,?,?,?,?,?,?)}");

                cts.setString(1, id);
                cts.setString(2, nom);
                cts.setString(3, direccion);
                cts.setString(4, tel);
                cts.setString(5, idciu);
                cts.setString(6, mail);
                cts.setString(7, contacto);
                cts.setString(8, telcontac);
                cts.setString(9, idnivel);

                int rpta=cts.executeUpdate();
                if(rpta==1)
                JOptionPane.showMessageDialog(this,"PROVEEDOR A SIDO MODIFICADO CORRECTAMENTE!!","Atencion",JOptionPane.INFORMATION_MESSAGE);

               BOTONES();
                limpiar();
                DESABILITAR();
                 llenarciudad();
                 llenarnivel();
            cargar("");

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
               
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
 
    }//GEN-LAST:event_btnmodificarActionPerformed

    private void btneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarActionPerformed
        // TODO add your handling code here:
        //          String cod=this.jTextField1.getText();
        try {
            cts=cn.prepareCall("{call eliminarEmpleado(?)}");
            //            cts.setString(1, cod);
            int rpta=cts.executeUpdate();

            if(rpta==1){
                JOptionPane.showMessageDialog(this, "Empleado Eliminado","Aviso",JOptionPane.INFORMATION_MESSAGE);
                limpiar();
                DESABILITAR();
                BOTONES();
            }else {
                JOptionPane.showMessageDialog(this, "Empleado No Eliminado","Aviso",JOptionPane.INFORMATION_MESSAGE);

            }

        } catch (SQLException | HeadlessException e) {JOptionPane.showMessageDialog(this, e.toString());
        }
    }//GEN-LAST:event_btneliminarActionPerformed

    private void btncancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelarActionPerformed
        // TODO add your handling code here:
        BOTONES();
        DESABILITAR();
    }//GEN-LAST:event_btncancelarActionPerformed

    private void btnsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalirActionPerformed
        // TODO add your handling code here:
        int opcion=JOptionPane.showConfirmDialog(null,"Realmente decea Salir","confirmar",JOptionPane.YES_NO_OPTION);
        if(opcion==JOptionPane.YES_NO_OPTION){
            dispose();
        }

    }//GEN-LAST:event_btnsalirActionPerformed

    private void txttelcontactoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttelcontactoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttelcontactoActionPerformed

    private void cbonivelItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbonivelItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cbonivelItemStateChanged

    private void cbonivelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbonivelActionPerformed
        // TODO add your handling code here:
        pasaidnivel();
        
    }//GEN-LAST:event_cbonivelActionPerformed

    private void cbodeptoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbodeptoActionPerformed
        pasaidciudad();
        // TODO add your handling code here:

        //     mcombos mcombos1 =(mcombos) cbodepto.getSelectedItem(); //esto es por el mcombos
        //   idciudad = mcombos1.getID();

        //   String id = mcombos1.getID();
        //        lbldepto.setText(id);
    }//GEN-LAST:event_cbodeptoActionPerformed

    private void cbodeptoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbodeptoItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cbodeptoItemStateChanged

    private void txtfiltroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtfiltroKeyReleased
        // TODO add your handling code here:
        cargar(txtfiltro.getText());

    }//GEN-LAST:event_txtfiltroKeyReleased

    private void txtproveedorFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtproveedorFocusLost
        // TODO add your handling code here:
           String s;
        s= txtproveedor.getText();
        txtproveedor.setText(s.toUpperCase());
    }//GEN-LAST:event_txtproveedorFocusLost

    private void txtdireccionFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtdireccionFocusLost
        // TODO add your handling code here:
        String s;
        s= txtdireccion.getText();
        txtdireccion.setText(s.toUpperCase());
    }//GEN-LAST:event_txtdireccionFocusLost

    private void txtdireccionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdireccionKeyTyped
        // TODO add your handling code here:
          String s;
        s= txtdireccion.getText();
        txtdireccion.setText(s.toUpperCase());
        
    }//GEN-LAST:event_txtdireccionKeyTyped

    private void txtcorreoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtcorreoFocusLost
        // TODO add your handling code here
          String s;
        s= txtcorreo.getText();
        txtcorreo.setText(s.toUpperCase());
    }//GEN-LAST:event_txtcorreoFocusLost

    private void txtcorreoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcorreoKeyTyped
        // TODO add your handling code here:
           String s;
        s= txtcorreo.getText();
        txtcorreo.setText(s.toUpperCase());
        
    }//GEN-LAST:event_txtcorreoKeyTyped

    private void txtcontactoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtcontactoFocusLost
        // TODO add your handling code here:
           String s;
        s= txtcontacto.getText();
        txtcontacto.setText(s.toUpperCase());
        
    }//GEN-LAST:event_txtcontactoFocusLost

    private void txtcontactoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcontactoKeyTyped
        // TODO add your handling code here:
       String s;
        s= txtcontacto.getText();
        txtcontacto.setText(s.toUpperCase());
                
    }//GEN-LAST:event_txtcontactoKeyTyped

    private void txttelcontactoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txttelcontactoKeyTyped
        // TODO add your handling code here:
        char car=evt.getKeyChar();
        if(  txttelefono.getText().length()>=8)evt.consume();
        if ((car<'0'||car>'9'))evt.consume();
        
    }//GEN-LAST:event_txttelcontactoKeyTyped

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnbuscar;
    private javax.swing.JButton btncancelar;
    private javax.swing.JButton btneliminar;
    private javax.swing.JButton btnguardar;
    private javax.swing.JButton btnmodificar;
    private javax.swing.JButton btnnuevo;
    private javax.swing.JButton btnsalir;
    private javax.swing.JComboBox cbodepto;
    private javax.swing.JComboBox cbonivel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lbldepto;
    private javax.swing.JLabel lblnivel;
    private javax.swing.JLabel lblproveedor;
    private javax.swing.JTextField txtcontacto;
    private javax.swing.JTextField txtcorreo;
    private javax.swing.JTextField txtdireccion;
    private javax.swing.JTextField txtfiltro;
    private javax.swing.JTextField txtproveedor;
    private javax.swing.JTextField txttelcontacto;
    private javax.swing.JTextField txttelefono;
    // End of variables declaration//GEN-END:variables
}
