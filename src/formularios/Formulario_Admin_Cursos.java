/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formularios;

import clases_de_sistema.Curso;
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
public class Formulario_Admin_Cursos extends javax.swing.JFrame {
    
    /**
     * Creates new form Sistema
     */
    public Formulario_Admin_Cursos() {
        initComponents();
        llenarTabla(linkDB.currentConnection, tblCursos);
        llenarFacultadComboBoxes(linkDB.currentConnection);
    }
    
    //Metodos de relleno de datos en formulario
    
    public void llenarTabla(Connection c, JTable tabla){
        DefaultTableModel model;
        String[] columnas={"Nombre", "Descripcion", "Facultad"};
        //Definimos nuevo modelo de jTable
        model = new DefaultTableModel(null, columnas);
        String [] camposDeRegistro = new String[3];
        
        String sql = "SELECT NOMBRE, "
                + "DESCRIPCION, "
                + "(SELECT NOMBRE FROM FACULTAD F WHERE F.ID_FACULTAD = C.FACULTAD_ID_FACULTAD) "
                + "FROM CURSO C";
        Statement statement = null;
        ResultSet resultadoDeQuery = null;
            
        try {
            statement = c.createStatement();
            resultadoDeQuery = statement.executeQuery(sql);
                        
            while(resultadoDeQuery.next()){
                for(int columnaActual = 0; columnaActual<3; columnaActual++){
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
    
    public void llenarFacultadComboBoxes(Connection c){
        facultadComboBoxAgregar.removeAllItems();
        facultadComboBoxModificar.removeAllItems();
        facultadComboBoxEliminar.removeAllItems();
        
        String [] camposDeRegistro = new String[1];
        String sql = "SELECT NOMBRE FROM FACULTAD";

        Statement statement = null;
        ResultSet resultadoDeQuery = null;
        
        try{
            statement = c.createStatement();
            resultadoDeQuery = statement.executeQuery(sql);
                        
            while(resultadoDeQuery.next()){
                for(int columnaActual = 0; columnaActual<1; columnaActual++){
                    camposDeRegistro[columnaActual] = resultadoDeQuery.getString(columnaActual+1);
                    String dato = resultadoDeQuery.getString(columnaActual+1);
                    System.out.println("Datos Extraidos: " + dato);
                }
                facultadComboBoxAgregar.addItem(camposDeRegistro[0]);
                facultadComboBoxModificar.addItem(camposDeRegistro[0]);
                facultadComboBoxEliminar.addItem(camposDeRegistro[0]);
            }
            
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al llenar ComboBox");
        }
    }
    
    public void llenarNombreCursoComboBoxes(Connection c, String nombreFacultad, JComboBox combobox){
        nombreCursoComboBoxModificar.removeAllItems();
        nombreCursoComboBoxEliminar.removeAllItems();
        
        String [] camposDeRegistro = new String[1];
        String sql = "SELECT NOMBRE FROM CURSO C WHERE FACULTAD_ID_FACULTAD = "
                + "(SELECT ID_FACULTAD FROM FACULTAD F WHERE F.NOMBRE = " 
                + "'" + nombreFacultad + "')";
        
        PreparedStatement statement = null;
        ResultSet resultadoDeQuery = null;
        
        try {
            statement = linkDB.currentConnection.prepareStatement(sql);
            
            
            resultadoDeQuery = statement.executeQuery(sql);
                        
            while(resultadoDeQuery.next()){
                for(int columnaActual = 0; columnaActual<1; columnaActual++){
                    camposDeRegistro[columnaActual] = resultadoDeQuery.getString(columnaActual+1);
                    String dato = resultadoDeQuery.getString(columnaActual+1);
                    System.out.println("Datos Extraidos: " + dato);
                }
                combobox.addItem(camposDeRegistro[0]);
            }
            
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al llenar ComboBox");
        }
    }
    
    public void limpiarFormulario(){
        txtNombreAgregar.setText("");
        txtDescripcionAgregar.setText("");
        txtNuevoNombreModificar.setText("");
        txtDescripcionModificar.setText("");
        txtDescripcionEliminar.setText("");
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
        jPanelAgregar = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnAgregar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        facultadComboBoxAgregar = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDescripcionAgregar = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        txtNombreAgregar = new javax.swing.JTextField();
        jPanelModificar = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnModificar = new javax.swing.JButton();
        btnRefrescarModificar = new javax.swing.JButton();
        btnSalir1 = new javax.swing.JButton();
        facultadComboBoxModificar = new javax.swing.JComboBox<>();
        nombreCursoComboBoxModificar = new javax.swing.JComboBox<>();
        jScrollPane5 = new javax.swing.JScrollPane();
        txtDescripcionModificar = new javax.swing.JTextArea();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTextArea4 = new javax.swing.JTextArea();
        txtNuevoNombreModificar = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jPanelEliminar = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        btnEliminar = new javax.swing.JButton();
        btnRefrescarEliminar = new javax.swing.JButton();
        btnSalir2 = new javax.swing.JButton();
        facultadComboBoxEliminar = new javax.swing.JComboBox<>();
        nombreCursoComboBoxEliminar = new javax.swing.JComboBox<>();
        jScrollPane8 = new javax.swing.JScrollPane();
        txtDescripcionEliminar = new javax.swing.JTextArea();
        jScrollPane9 = new javax.swing.JScrollPane();
        jTextArea6 = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCursos = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Modulo Cursos");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 0, -1, -1));

        jLabel2.setText("Facultad");

        jLabel3.setText("Nombre");

        jLabel4.setText("Descripcion");

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnLimpiar.setText("Refrescar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        facultadComboBoxAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                facultadComboBoxAgregarActionPerformed(evt);
            }
        });

        txtDescripcionAgregar.setColumns(20);
        txtDescripcionAgregar.setRows(5);
        jScrollPane2.setViewportView(txtDescripcionAgregar);

        jTextArea2.setEditable(false);
        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jTextArea2.setText("- Para eliminar y modficar el \ncurso por  favor seleccionelo \nde la lista");
        jScrollPane3.setViewportView(jTextArea2);

        javax.swing.GroupLayout jPanelAgregarLayout = new javax.swing.GroupLayout(jPanelAgregar);
        jPanelAgregar.setLayout(jPanelAgregarLayout);
        jPanelAgregarLayout.setHorizontalGroup(
            jPanelAgregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAgregarLayout.createSequentialGroup()
                .addGroup(jPanelAgregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanelAgregarLayout.createSequentialGroup()
                        .addGroup(jPanelAgregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanelAgregarLayout.createSequentialGroup()
                                .addGap(75, 75, 75)
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelAgregarLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3)
                                .addGap(15, 15, 15)))
                        .addGroup(jPanelAgregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(facultadComboBoxAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNombreAgregar)))
                    .addGroup(jPanelAgregarLayout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelAgregarLayout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelAgregarLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanelAgregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelAgregarLayout.createSequentialGroup()
                                .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelAgregarLayout.createSequentialGroup()
                                .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(164, 164, 164)))))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        jPanelAgregarLayout.setVerticalGroup(
            jPanelAgregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAgregarLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanelAgregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(facultadComboBoxAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelAgregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtNombreAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanelAgregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelAgregarLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE))
                .addGap(45, 45, 45)
                .addComponent(btnAgregar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelAgregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLimpiar)
                    .addComponent(btnSalir))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52))
        );

        jTabbedPane1.addTab("Agregar Curso", jPanelAgregar);

        jLabel5.setText("Facultad");

        jLabel6.setText("Nombre");

        jLabel7.setText("Descripcion");

        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnRefrescarModificar.setText("Refrescar");
        btnRefrescarModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefrescarModificarActionPerformed(evt);
            }
        });

        btnSalir1.setText("Salir");
        btnSalir1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalir1ActionPerformed(evt);
            }
        });

        facultadComboBoxModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                facultadComboBoxModificarActionPerformed(evt);
            }
        });

        txtDescripcionModificar.setColumns(20);
        txtDescripcionModificar.setRows(5);
        jScrollPane5.setViewportView(txtDescripcionModificar);

        jTextArea4.setEditable(false);
        jTextArea4.setColumns(20);
        jTextArea4.setRows(5);
        jTextArea4.setText("- Para eliminar y modficar el \ncurso por  favor seleccionelo \nde la lista");
        jScrollPane6.setViewportView(jTextArea4);

        txtNuevoNombreModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNuevoNombreModificarActionPerformed(evt);
            }
        });

        jLabel11.setText("Nuevo Nombre");

        javax.swing.GroupLayout jPanelModificarLayout = new javax.swing.GroupLayout(jPanelModificar);
        jPanelModificar.setLayout(jPanelModificarLayout);
        jPanelModificarLayout.setHorizontalGroup(
            jPanelModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelModificarLayout.createSequentialGroup()
                .addGroup(jPanelModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanelModificarLayout.createSequentialGroup()
                        .addGap(134, 134, 134)
                        .addGroup(jPanelModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(facultadComboBoxModificar, 0, 92, Short.MAX_VALUE)
                            .addComponent(nombreCursoComboBoxModificar, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanelModificarLayout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelModificarLayout.createSequentialGroup()
                .addGroup(jPanelModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelModificarLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelModificarLayout.createSequentialGroup()
                        .addGroup(jPanelModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelModificarLayout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelModificarLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanelModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addComponent(txtNuevoNombreModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelModificarLayout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(jPanelModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnModificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnRefrescarModificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(btnSalir1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(355, 355, 355))
        );
        jPanelModificarLayout.setVerticalGroup(
            jPanelModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelModificarLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanelModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(facultadComboBoxModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(nombreCursoComboBoxModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNuevoNombreModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
                    .addGroup(jPanelModificarLayout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnModificar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRefrescarModificar)
                    .addComponent(btnSalir1))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52))
        );

        jTabbedPane1.addTab("Modificar Curso", jPanelModificar);

        jLabel8.setText("Facultad");

        jLabel9.setText("Nombre");

        jLabel10.setText("Descripcion");

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnRefrescarEliminar.setText("Refrescar");
        btnRefrescarEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefrescarEliminarActionPerformed(evt);
            }
        });

        btnSalir2.setText("Salir");
        btnSalir2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalir2ActionPerformed(evt);
            }
        });

        facultadComboBoxEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                facultadComboBoxEliminarActionPerformed(evt);
            }
        });

        txtDescripcionEliminar.setColumns(20);
        txtDescripcionEliminar.setRows(5);
        jScrollPane8.setViewportView(txtDescripcionEliminar);

        jTextArea6.setEditable(false);
        jTextArea6.setColumns(20);
        jTextArea6.setRows(5);
        jTextArea6.setText("- Para eliminar y modficar el \ncurso por  favor seleccionelo \nde la lista");
        jScrollPane9.setViewportView(jTextArea6);

        javax.swing.GroupLayout jPanelEliminarLayout = new javax.swing.GroupLayout(jPanelEliminar);
        jPanelEliminar.setLayout(jPanelEliminarLayout);
        jPanelEliminarLayout.setHorizontalGroup(
            jPanelEliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelEliminarLayout.createSequentialGroup()
                .addGroup(jPanelEliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelEliminarLayout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelEliminarLayout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addGroup(jPanelEliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel9)
                            .addComponent(jLabel8))
                        .addGroup(jPanelEliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelEliminarLayout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addGroup(jPanelEliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(facultadComboBoxEliminar, 0, 92, Short.MAX_VALUE)
                                    .addComponent(nombreCursoComboBoxEliminar, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanelEliminarLayout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanelEliminarLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanelEliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelEliminarLayout.createSequentialGroup()
                                .addComponent(btnRefrescarEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnSalir2, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        jPanelEliminarLayout.setVerticalGroup(
            jPanelEliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelEliminarLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanelEliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(facultadComboBoxEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelEliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombreCursoComboBoxEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(jPanelEliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelEliminarLayout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE))
                .addGap(50, 50, 50)
                .addComponent(btnEliminar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelEliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRefrescarEliminar)
                    .addComponent(btnSalir2))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52))
        );

        jTabbedPane1.addTab("Eliminar Curso", jPanelEliminar);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 350, 540));

        tblCursos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Facultad", "Nombre", "Descripcion"
            }
        ));
        jScrollPane1.setViewportView(tblCursos);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 40, -1, 510));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        
        Curso curso = new Curso(
                txtNombreAgregar.getText(),
                txtDescripcionAgregar.getText(),
                facultadComboBoxAgregar.getSelectedItem().toString());
        
        try{
            curso.AgregarCursoDB(
                    txtNombreAgregar.getText(), 
                    txtDescripcionAgregar.getText(),
                    facultadComboBoxAgregar.getSelectedItem().toString());
            JOptionPane.showMessageDialog(null, "Curso agregado: " + curso.toString());
        } catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Error " + ex.getMessage());
            System.out.println("Error" + ex.getMessage());
        }
        
        llenarTabla(linkDB.currentConnection, tblCursos);
        llenarFacultadComboBoxes(linkDB.currentConnection);
        limpiarFormulario();
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void facultadComboBoxAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_facultadComboBoxAgregarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_facultadComboBoxAgregarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
         Curso curso = new Curso(
                txtNuevoNombreModificar.getText(),
                txtDescripcionModificar.getText(),
                nombreCursoComboBoxModificar.getSelectedItem().toString());

        try{
            curso.ModificarCurso(curso.getNombre(), 
                    curso.getDescripcion(), 
                    nombreCursoComboBoxModificar.getSelectedItem().toString());
            JOptionPane.showMessageDialog(null, "Curso Modificado: " + nombreCursoComboBoxModificar.getSelectedItem().toString());
        } catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Error " + ex.getMessage());
            System.out.println("Paso 1" + ex.getMessage());
        }
        llenarTabla(linkDB.currentConnection, tblCursos);
        llenarFacultadComboBoxes(linkDB.currentConnection);
        limpiarFormulario();
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnRefrescarModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefrescarModificarActionPerformed
        llenarNombreCursoComboBoxes(linkDB.currentConnection, facultadComboBoxModificar.getSelectedItem().toString(), nombreCursoComboBoxModificar);
    }//GEN-LAST:event_btnRefrescarModificarActionPerformed

    private void btnSalir1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalir1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSalir1ActionPerformed

    private void facultadComboBoxModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_facultadComboBoxModificarActionPerformed
        //llenarNombreCursoComboBoxes(linkDB.currentConnection, facultadComboBoxModificar.getSelectedItem().toString());        
    }//GEN-LAST:event_facultadComboBoxModificarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        Curso curso = new Curso("1", "1", "1");

        try{
            curso.EliminarCurso(nombreCursoComboBoxEliminar.getSelectedItem().toString());
            JOptionPane.showMessageDialog(null, "Curso Elimnado: " + nombreCursoComboBoxEliminar.getSelectedItem().toString());
        } catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Error " + ex.getMessage());
            System.out.println("Paso 1" + ex.getMessage());
        }
        llenarTabla(linkDB.currentConnection, tblCursos);
        llenarFacultadComboBoxes(linkDB.currentConnection);
        limpiarFormulario();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnRefrescarEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefrescarEliminarActionPerformed
        llenarNombreCursoComboBoxes(linkDB.currentConnection, facultadComboBoxEliminar.getSelectedItem().toString(), nombreCursoComboBoxEliminar);
    }//GEN-LAST:event_btnRefrescarEliminarActionPerformed

    private void btnSalir2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalir2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSalir2ActionPerformed

    private void facultadComboBoxEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_facultadComboBoxEliminarActionPerformed
        //llenarNombreCursoComboBoxes(linkDB.currentConnection, facultadComboBoxEliminar.getSelectedItem().toString());
    }//GEN-LAST:event_facultadComboBoxEliminarActionPerformed

    private void txtNuevoNombreModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNuevoNombreModificarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNuevoNombreModificarActionPerformed

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
            java.util.logging.Logger.getLogger(Formulario_Admin_Cursos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Formulario_Admin_Cursos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Formulario_Admin_Cursos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Formulario_Admin_Cursos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Formulario_Admin_Cursos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnRefrescarEliminar;
    private javax.swing.JButton btnRefrescarModificar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnSalir1;
    private javax.swing.JButton btnSalir2;
    private javax.swing.JComboBox<String> facultadComboBoxAgregar;
    private javax.swing.JComboBox<String> facultadComboBoxEliminar;
    private javax.swing.JComboBox<String> facultadComboBoxModificar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanelAgregar;
    private javax.swing.JPanel jPanelEliminar;
    private javax.swing.JPanel jPanelModificar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextArea jTextArea4;
    private javax.swing.JTextArea jTextArea6;
    private javax.swing.JComboBox<String> nombreCursoComboBoxEliminar;
    private javax.swing.JComboBox<String> nombreCursoComboBoxModificar;
    private javax.swing.JTable tblCursos;
    private javax.swing.JTextArea txtDescripcionAgregar;
    private javax.swing.JTextArea txtDescripcionEliminar;
    private javax.swing.JTextArea txtDescripcionModificar;
    private javax.swing.JTextField txtNombreAgregar;
    private javax.swing.JTextField txtNuevoNombreModificar;
    // End of variables declaration//GEN-END:variables
}
