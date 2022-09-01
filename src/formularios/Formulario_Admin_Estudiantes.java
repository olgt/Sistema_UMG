/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formularios;

import clases_de_sistema.Estudiante;
import desktop_login.linkDB;
import javax.swing.JOptionPane;
import java.sql.*;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author olgt1
 */
public class Formulario_Admin_Estudiantes extends javax.swing.JFrame {
    /**
     * Creates new form Sistema
    */
    public Formulario_Admin_Estudiantes() {
        initComponents();
        llenarTabla(linkDB.currentConnection, tblEstudiantes);
        llenarCarreraComboBoxes(linkDB.currentConnection);
        llenarCarnetComboBoxes(linkDB.currentConnection);
    }
    
    public void llenarTabla(Connection c, JTable tabla){
        DefaultTableModel model;
        String[] columnas={"nombre", "telefono", "correo", "carnet", "ano_ingreso", "carrera"};
        
        //Definimos nuevo modelo de jTable
        model = new DefaultTableModel(null, columnas);
        String [] camposDeRegistro = new String[6];
        
        String sql = "SELECT NOMBRE, "
                + "TELEFONO, "
                + "CORREO, "
                + "CARNET, "
                + "ANO_INGRESO,"
                + "(SELECT NOMBRE FROM CARRERA C WHERE C.ID_CARRERA = E.CARRERA_ID_CARRERA) "
                + "FROM ESTUDIANTE E";
        Statement statement = null;
        ResultSet resultadoDeQuery = null;
        
        try {
            statement = c.createStatement();
            resultadoDeQuery = statement.executeQuery(sql);
                        
            while(resultadoDeQuery.next()){
                for(int columnaActual = 0; columnaActual<6; columnaActual++){
                    camposDeRegistro[columnaActual] = resultadoDeQuery.getString(columnaActual+1);
                    String dato = resultadoDeQuery.getString(columnaActual+1);
                    System.out.println("Datos Extraidos: " + dato);
                }
                model.addRow(camposDeRegistro);
            }
            tabla.setModel(model);
            
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, "No se pudo llenar tabla");
        }               
    }
    
    public void llenarCarreraComboBoxes(Connection c){ 
        carreraComboBoxAgregar.removeAllItems();
        carreraComboBoxModificar.removeAllItems();      
        
        String [] camposDeRegistro = new String[1];
        
        String sql = "SELECT NOMBRE FROM CARRERA";

        Statement statement = null;
        ResultSet resultadoDeQuery = null;
        
        try {
            statement = c.createStatement();
            resultadoDeQuery = statement.executeQuery(sql);
                        
            while(resultadoDeQuery.next()){
                for(int columnaActual = 0; columnaActual<1; columnaActual++){
                    camposDeRegistro[columnaActual] = resultadoDeQuery.getString(columnaActual+1);
                    String dato = resultadoDeQuery.getString(columnaActual+1);
                    System.out.println("Datos Extraidos: " + dato);
                }
                carreraComboBoxAgregar.addItem(camposDeRegistro[0]);
                carreraComboBoxModificar.addItem(camposDeRegistro[0]);           
            }
            
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al llenar ComboBox");
        }
    }

    public void llenarCarnetComboBoxes(Connection c){
        jComboBoxCarnetEliminar.removeAllItems();
        jComboBoxCarnetModificar.removeAllItems();
        
        String [] camposDeRegistro = new String[1];
        String sql = "SELECT CARNET FROM ESTUDIANTE";

        Statement statement = null;
        ResultSet resultadoDeQuery = null;
        
        try {
            statement = c.createStatement();
            resultadoDeQuery = statement.executeQuery(sql);
                        
            while(resultadoDeQuery.next()){
                for(int columnaActual = 0; columnaActual<1; columnaActual++){
                    camposDeRegistro[columnaActual] = resultadoDeQuery.getString(columnaActual+1);
                    String dato = resultadoDeQuery.getString(columnaActual+1);
                    System.out.println("Datos Extraidos: " + dato);
                }
                jComboBoxCarnetEliminar.addItem(camposDeRegistro[0]);
                jComboBoxCarnetModificar.addItem(camposDeRegistro[0]);
            }
            
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al llenar ComboBox");
        }
    }
    
    public void limpiarFormularios(){
        txtNombre.setText("");
        txtCelular.setText("");
        txtCarnet.setText("");
        txtAno_Ingreso.setText("");
        txtCorreo.setText("");
        carreraComboBoxAgregar.setSelectedIndex(-1);
        txtNombreModificar.setText("");
        txtCelularModificar.setText("");
        txtAno_IngresoModificar.setText("");
        txtAno_IngresoModificar.setText("");
        carreraComboBoxModificar.setSelectedIndex(-1);
        jComboBoxCarnetModificar.setSelectedIndex(-1);
        jComboBoxCarnetEliminar.setSelectedIndex(-1);
    }
  
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel_Agregar = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtCelular = new javax.swing.JTextField();
        txtCarnet = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();
        btnRefrescar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        txtAno_Ingreso = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();
        carreraComboBoxAgregar = new javax.swing.JComboBox<>();
        jPanel_Modificar = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtNombreModificar = new javax.swing.JTextField();
        txtCelularModificar = new javax.swing.JTextField();
        btnModificar = new javax.swing.JButton();
        btnRefrescar1 = new javax.swing.JButton();
        btnSalir1 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtCorreoModificar = new javax.swing.JTextField();
        txtAno_IngresoModificar = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jLabel15 = new javax.swing.JLabel();
        carreraComboBoxModificar = new javax.swing.JComboBox<>();
        jComboBoxCarnetModificar = new javax.swing.JComboBox<>();
        jPanel_Eliminar = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        btnEliminar = new javax.swing.JButton();
        btnRefrescar2 = new javax.swing.JButton();
        btnSalir2 = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea();
        jComboBoxCarnetEliminar = new javax.swing.JComboBox<>();
        jPanelDeTabla = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEstudiantes = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Modulo Estudiantes");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 20, -1, -1));

        jLabel2.setText("Carnet");

        jLabel3.setText("Nombre");

        jLabel4.setText("Telefono");

        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });

        txtCelular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCelularActionPerformed(evt);
            }
        });

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnRefrescar.setText("Refrescar");
        btnRefrescar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefrescarActionPerformed(evt);
            }
        });

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        jLabel5.setText("Año Ingreso");

        jLabel6.setText("Correo");

        txtAno_Ingreso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAno_IngresoActionPerformed(evt);
            }
        });

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setText("- Para eliminar y modficar el \nestudiante por  favor ingrese su\n numero de carnet");
        jScrollPane2.setViewportView(jTextArea1);

        jLabel8.setText("Carrera");

        carreraComboBoxAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                carreraComboBoxAgregarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel_AgregarLayout = new javax.swing.GroupLayout(jPanel_Agregar);
        jPanel_Agregar.setLayout(jPanel_AgregarLayout);
        jPanel_AgregarLayout.setHorizontalGroup(
            jPanel_AgregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_AgregarLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel_AgregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_AgregarLayout.createSequentialGroup()
                        .addComponent(btnRefrescar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(406, 406, 406))
                    .addGroup(jPanel_AgregarLayout.createSequentialGroup()
                        .addGroup(jPanel_AgregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel_AgregarLayout.createSequentialGroup()
                                .addGroup(jPanel_AgregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel_AgregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel_AgregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel4))
                                        .addComponent(jLabel2))
                                    .addGroup(jPanel_AgregarLayout.createSequentialGroup()
                                        .addGroup(jPanel_AgregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel6))
                                        .addGap(3, 3, 3))
                                    .addGroup(jPanel_AgregarLayout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                .addGroup(jPanel_AgregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(carreraComboBoxAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel_AgregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtNombre)
                                        .addComponent(txtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtCarnet, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtAno_Ingreso, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel_AgregarLayout.setVerticalGroup(
            jPanel_AgregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_AgregarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel_AgregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel_AgregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel_AgregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCarnet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel_AgregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtAno_Ingreso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel_AgregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(jPanel_AgregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(carreraComboBoxAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(90, 90, 90)
                .addComponent(btnAgregar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel_AgregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalir)
                    .addComponent(btnRefrescar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(95, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Agregar Estudiante", jPanel_Agregar);

        jLabel9.setText("Carnet");

        jLabel10.setText("Nombre");

        jLabel11.setText("Telefono");

        txtNombreModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreModificarActionPerformed(evt);
            }
        });

        txtCelularModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCelularModificarActionPerformed(evt);
            }
        });

        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnRefrescar1.setText("Refrescar");
        btnRefrescar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefrescar1ActionPerformed(evt);
            }
        });

        btnSalir1.setText("Salir");
        btnSalir1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalir1ActionPerformed(evt);
            }
        });

        jLabel12.setText("Año Ingreso");

        jLabel13.setText("Correo");

        jTextArea2.setEditable(false);
        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jTextArea2.setText("- Para eliminar y modficar el \nestudiante por  favor ingrese su\n numero de carnet");
        jScrollPane4.setViewportView(jTextArea2);

        jLabel15.setText("Carrera");

        carreraComboBoxModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                carreraComboBoxModificarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel_ModificarLayout = new javax.swing.GroupLayout(jPanel_Modificar);
        jPanel_Modificar.setLayout(jPanel_ModificarLayout);
        jPanel_ModificarLayout.setHorizontalGroup(
            jPanel_ModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_ModificarLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel_ModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel_ModificarLayout.createSequentialGroup()
                        .addComponent(btnRefrescar1)
                        .addGap(18, 18, 18)
                        .addComponent(btnSalir1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel_ModificarLayout.createSequentialGroup()
                        .addGroup(jPanel_ModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13)
                            .addComponent(jLabel15))
                        .addGap(3, 3, 3)
                        .addGroup(jPanel_ModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(carreraComboBoxModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCorreoModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtAno_IngresoModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel_ModificarLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel_ModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel_ModificarLayout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxCarnetModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel_ModificarLayout.createSequentialGroup()
                                .addGroup(jPanel_ModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel11))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel_ModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtCelularModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNombreModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(123, Short.MAX_VALUE))
        );
        jPanel_ModificarLayout.setVerticalGroup(
            jPanel_ModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_ModificarLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel_ModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jComboBoxCarnetModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel_ModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombreModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(18, 18, 18)
                .addGroup(jPanel_ModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtCelularModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel_ModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtAno_IngresoModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel_ModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txtCorreoModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(jPanel_ModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addComponent(carreraComboBoxModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(63, 63, 63)
                .addComponent(btnModificar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel_ModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalir1)
                    .addComponent(btnRefrescar1))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(81, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Modificar Estudiante", jPanel_Modificar);

        jLabel16.setText("Carnet");

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnRefrescar2.setText("Refrescar");
        btnRefrescar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefrescar2ActionPerformed(evt);
            }
        });

        btnSalir2.setText("Salir");
        btnSalir2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalir2ActionPerformed(evt);
            }
        });

        jTextArea3.setEditable(false);
        jTextArea3.setColumns(20);
        jTextArea3.setRows(5);
        jTextArea3.setText("- Para eliminar y modficar el \nestudiante por  favor ingrese su\n numero de carnet");
        jScrollPane6.setViewportView(jTextArea3);

        jComboBoxCarnetEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxCarnetEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel_EliminarLayout = new javax.swing.GroupLayout(jPanel_Eliminar);
        jPanel_Eliminar.setLayout(jPanel_EliminarLayout);
        jPanel_EliminarLayout.setHorizontalGroup(
            jPanel_EliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_EliminarLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel_EliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_EliminarLayout.createSequentialGroup()
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRefrescar2)
                        .addGap(406, 406, 406))
                    .addGroup(jPanel_EliminarLayout.createSequentialGroup()
                        .addGroup(jPanel_EliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel_EliminarLayout.createSequentialGroup()
                                .addGap(76, 76, 76)
                                .addComponent(btnSalir2, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jPanel_EliminarLayout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jLabel16)
                .addGap(18, 18, 18)
                .addComponent(jComboBoxCarnetEliminar, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(421, 421, 421))
        );
        jPanel_EliminarLayout.setVerticalGroup(
            jPanel_EliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_EliminarLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel_EliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jComboBoxCarnetEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(241, 241, 241)
                .addGroup(jPanel_EliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRefrescar2)
                    .addComponent(btnEliminar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSalir2)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(95, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Eliminar Estudiante", jPanel_Eliminar);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 340, -1));

        tblEstudiantes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Nombre", "Telefono", "Correo", "Carnet", "Año Ingreso", "Carrera"
            }
        ));
        jScrollPane1.setViewportView(tblEstudiantes);

        javax.swing.GroupLayout jPanelDeTablaLayout = new javax.swing.GroupLayout(jPanelDeTabla);
        jPanelDeTabla.setLayout(jPanelDeTablaLayout);
        jPanelDeTablaLayout.setHorizontalGroup(
            jPanelDeTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 620, Short.MAX_VALUE)
            .addGroup(jPanelDeTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDeTablaLayout.createSequentialGroup()
                    .addGap(0, 8, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 612, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanelDeTablaLayout.setVerticalGroup(
            jPanelDeTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 530, Short.MAX_VALUE)
            .addGroup(jPanelDeTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDeTablaLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 519, Short.MAX_VALUE)))
        );

        getContentPane().add(jPanelDeTabla, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 70, 620, 530));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        
        Estudiante estudiante = new Estudiante(
                txtNombre.getText(),
                txtCelular.getText(),
                txtCorreo.getText(),
                txtCarnet.getText(),
                txtAno_Ingreso.getText(),
                carreraComboBoxAgregar.getSelectedItem().toString());
        
        try{
            estudiante.AgregarEstudianteDB(
                    txtNombre.getText(), 
                    txtCelular.getText(),
                    txtCorreo.getText(),
                    txtCarnet.getText(), 
                    txtAno_Ingreso.getText(),
                    carreraComboBoxAgregar.getSelectedItem().toString());
            JOptionPane.showMessageDialog(null, "Estudiante agregado: " + estudiante.toString());
        } catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Error " + ex.getMessage());
            System.out.println("Error" + ex.getMessage());
        }
        
        llenarTabla(linkDB.currentConnection, tblEstudiantes);
        llenarCarreraComboBoxes(linkDB.currentConnection);
        llenarCarnetComboBoxes(linkDB.currentConnection);
        
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnRefrescarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefrescarActionPerformed
        llenarTabla(linkDB.currentConnection, tblEstudiantes);
        llenarCarreraComboBoxes(linkDB.currentConnection);
        llenarCarnetComboBoxes(linkDB.currentConnection);
    }//GEN-LAST:event_btnRefrescarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void txtCelularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCelularActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txtCelularActionPerformed

    private void carreraComboBoxAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_carreraComboBoxAgregarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_carreraComboBoxAgregarActionPerformed

    private void txtNombreModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreModificarActionPerformed
    
    }//GEN-LAST:event_txtNombreModificarActionPerformed

    private void txtCelularModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCelularModificarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCelularModificarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        
        Estudiante estudiante = new Estudiante("1", "1", "1", "1", "1", "1");
        
        try{
            estudiante.ModificarEstudiante(
                    txtNombreModificar.getText(), 
                    txtCelularModificar.getText(),
                    txtCorreoModificar.getText(),
                    txtAno_IngresoModificar.getText(),
                    carreraComboBoxModificar.getSelectedItem().toString(),
                    jComboBoxCarnetModificar.getSelectedItem().toString());
            JOptionPane.showMessageDialog(null, "Estudiante agregado: " + txtCarnet);
        } catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Error " + ex.getMessage());
            System.out.println("Error" + ex.getMessage());
        }
        
        
        llenarTabla(linkDB.currentConnection, tblEstudiantes);
        llenarCarreraComboBoxes(linkDB.currentConnection);
        llenarCarnetComboBoxes(linkDB.currentConnection);
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnRefrescar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefrescar1ActionPerformed
        llenarTabla(linkDB.currentConnection, tblEstudiantes);
        llenarCarreraComboBoxes(linkDB.currentConnection);
        llenarCarnetComboBoxes(linkDB.currentConnection);
    }//GEN-LAST:event_btnRefrescar1ActionPerformed

    private void btnSalir1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalir1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSalir1ActionPerformed

    private void carreraComboBoxModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_carreraComboBoxModificarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_carreraComboBoxModificarActionPerformed

    private void btnSalir2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalir2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSalir2ActionPerformed

    private void btnRefrescar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefrescar2ActionPerformed
        llenarTabla(linkDB.currentConnection, tblEstudiantes);
        llenarCarreraComboBoxes(linkDB.currentConnection);
        llenarCarnetComboBoxes(linkDB.currentConnection);
    }//GEN-LAST:event_btnRefrescar2ActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        
        Estudiante estudiante = new Estudiante("1", "1", "1", "1", "1", "1");
        
        try{
            estudiante.EliminarEstudiante(jComboBoxCarnetEliminar.getSelectedItem().toString());
            JOptionPane.showMessageDialog(null, "Estudiante Eliminado");
        } catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Error " + ex.getMessage());
            System.out.println("Error" + ex.getMessage());
        }
        
        llenarTabla(linkDB.currentConnection, tblEstudiantes);
        llenarCarreraComboBoxes(linkDB.currentConnection);
        llenarCarnetComboBoxes(linkDB.currentConnection);
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void txtAno_IngresoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAno_IngresoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAno_IngresoActionPerformed

    private void jComboBoxCarnetEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxCarnetEliminarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxCarnetEliminarActionPerformed

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
            java.util.logging.Logger.getLogger(Formulario_Admin_Estudiantes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Formulario_Admin_Estudiantes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Formulario_Admin_Estudiantes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Formulario_Admin_Estudiantes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Formulario_Admin_Estudiantes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnRefrescar;
    private javax.swing.JButton btnRefrescar1;
    private javax.swing.JButton btnRefrescar2;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnSalir1;
    private javax.swing.JButton btnSalir2;
    private javax.swing.JComboBox<String> carreraComboBoxAgregar;
    private javax.swing.JComboBox<String> carreraComboBoxModificar;
    private javax.swing.JComboBox<String> jComboBoxCarnetEliminar;
    private javax.swing.JComboBox<String> jComboBoxCarnetModificar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanelDeTabla;
    private javax.swing.JPanel jPanel_Agregar;
    private javax.swing.JPanel jPanel_Eliminar;
    private javax.swing.JPanel jPanel_Modificar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextArea jTextArea3;
    private javax.swing.JTable tblEstudiantes;
    private javax.swing.JTextField txtAno_Ingreso;
    private javax.swing.JTextField txtAno_IngresoModificar;
    private javax.swing.JTextField txtCarnet;
    private javax.swing.JTextField txtCelular;
    private javax.swing.JTextField txtCelularModificar;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtCorreoModificar;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNombreModificar;
    // End of variables declaration//GEN-END:variables
}
