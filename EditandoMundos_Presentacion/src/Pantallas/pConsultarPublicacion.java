/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pantallas;

import Entidades.Publicacion;
import Entidades.Usuario;
import comunicacion.IOperacion;
import comunicacion.SOperacion;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author marti
 */
public class pConsultarPublicacion extends javax.swing.JFrame {

    private DefaultTableModel dtmPublicaciones;
    private IOperacion op;
    private Usuario usuario;

    /**
     * Creates new form pPrincipalCliente
     *
     * @param user
     */
    public pConsultarPublicacion(Usuario user) {
        initComponents();
        this.usuario = user;
        this.txtBuscar.setVisible(true);
        this.btnBuscar.setVisible(true);
        op = SOperacion.getOperacion();
        dtmPublicaciones = new DefaultTableModel();

        setModelo();
        setDatos();
        llenarCombobox();
    }

    private void llenarCombobox() {
        String tipoPublicacionConsulta[] = {"Seleccionar", "Digital", "Fisico"};
        for (String tipo : tipoPublicacionConsulta) {
            cmbTipoPublicacion.addItem(tipo);
        }
        String tipoConsulta[] = {"Seleccionar", "fechaEntrega", "pendientes por pagar", "pagadas"};
        for (String tipo : tipoConsulta) {
            cmbTipoConsulta.addItem(tipo);
        }
    }

    private void setModelo() {
        String cabecera[] = {"Autor", "#Paginas", "Costo", "Titulo", "Pagina inicial",
            "Precio", "tipoPublicacion", "TamMB", "tipoPago", "fechaInicio", "fechaEntrega"};
        dtmPublicaciones.setColumnIdentifiers(cabecera);
        tabla.setModel(dtmPublicaciones);
    }

    private void setDatos() {
        List<Publicacion> publicaciones = op.consultarPublicaciones();
        Object[] fila = new Object[dtmPublicaciones.getColumnCount()];
        dtmPublicaciones.setRowCount(0);
        publicaciones.forEach(p -> {
            fila[0] = p.getAutor().getNombre();
            fila[1] = p.getnPaginas();
            fila[2] = p.getCosto();
            fila[3] = p.getTitulo();
            fila[4] = p.getPaginaInicial();
            fila[5] = p.getPrecioVenta();
            fila[6] = p.getTipoPublicacion();
            fila[7] = p.getTamMegas();
            fila[8] = p.getTipoPago();
            fila[9] = p.getFechaInicio();
            fila[10] = p.getFechaEntrega();
            dtmPublicaciones.addRow(fila);
        });
    }

    private void buscarTitulos() {
        List<Publicacion> publicaciones = op.consultarPublicacionesPorTitulo(this.txtBuscar.getText());
        Object[] fila = new Object[dtmPublicaciones.getColumnCount()];
        dtmPublicaciones.setRowCount(0);
        publicaciones.forEach(p -> {
            fila[0] = p.getAutor().getNombre();
            fila[1] = p.getnPaginas();
            fila[2] = p.getCosto();
            fila[3] = p.getTitulo();
            fila[4] = p.getPaginaInicial();
            fila[5] = p.getPrecioVenta();
            fila[6] = p.getTipoPublicacion();
            fila[7] = p.getTamMegas();
            fila[8] = p.getTipoPago();
            fila[9] = p.getFechaInicio();
            fila[10] = p.getFechaEntrega();
            dtmPublicaciones.addRow(fila);
        });
    }

    private void buscarTipoPublicacion(String opcion) {
        List<Publicacion> publicaciones = op.consultarPublicacionesPorTipoPublicacion(opcion);
        Object[] fila = new Object[dtmPublicaciones.getColumnCount()];
        dtmPublicaciones.setRowCount(0);
        publicaciones.forEach(p -> {
            fila[0] = p.getAutor().getNombre();
            fila[1] = p.getnPaginas();
            fila[2] = p.getCosto();
            fila[3] = p.getTitulo();
            fila[4] = p.getPaginaInicial();
            fila[5] = p.getPrecioVenta();
            fila[6] = p.getTipoPublicacion();
            fila[7] = p.getTamMegas();
            fila[8] = p.getTipoPago();
            fila[9] = p.getFechaInicio();
            fila[10] = p.getFechaEntrega();
            dtmPublicaciones.addRow(fila);
        });
    }

    private void buscarConsulta(String opcion) {
        List<Publicacion> publicaciones = null;
        if (opcion.equals("fechaEntrega")) {
            publicaciones = op.consultarPublicacionesPorFechaEntrega(opcion);
        }
        if (opcion.equals("pendientes por pagar")) {
            opcion = "Tarjeta";
            publicaciones = op.consultarPublicacionesPorTipoPago(opcion);
        }
        if (opcion.equals("pagadas")) {
            publicaciones = op.consultarPublicacionesPorTipoPago(opcion);
        }
        Object[] fila = new Object[dtmPublicaciones.getColumnCount()];
        dtmPublicaciones.setRowCount(0);
        publicaciones.forEach(p -> {
            fila[0] = p.getAutor().getNombre();
            fila[1] = p.getnPaginas();
            fila[2] = p.getCosto();
            fila[3] = p.getTitulo();
            fila[4] = p.getPaginaInicial();
            fila[5] = p.getPrecioVenta();
            fila[6] = p.getTipoPublicacion();
            fila[7] = p.getTamMegas();
            fila[8] = p.getTipoPago();
            fila[9] = p.getFechaInicio();
            fila[10] = p.getFechaEntrega();
            dtmPublicaciones.addRow(fila);
        });
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
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnRegPubli = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        cmbTipoPublicacion = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        cmbTipoConsulta = new javax.swing.JComboBox<>();
        btnConsultar = new javax.swing.JButton();
        btnConsultar1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        txtBuscar = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 204, 255));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Editando Mundos");

        jPanel2.setBackground(new java.awt.Color(0, 102, 204));

        btnRegPubli.setBackground(new java.awt.Color(0, 204, 204));
        btnRegPubli.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnRegPubli.setForeground(new java.awt.Color(0, 0, 0));
        btnRegPubli.setText("Registrar Publicación");
        btnRegPubli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegPubliActionPerformed(evt);
            }
        });

        btnSalir.setBackground(new java.awt.Color(0, 204, 204));
        btnSalir.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnSalir.setForeground(new java.awt.Color(0, 0, 0));
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        cmbTipoPublicacion.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        cmbTipoPublicacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTipoPublicacionActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setText("Consultar por:");

        cmbTipoConsulta.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N

        btnConsultar.setBackground(new java.awt.Color(0, 204, 204));
        btnConsultar.setForeground(new java.awt.Color(0, 0, 0));
        btnConsultar.setText("Consultar");
        btnConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarActionPerformed(evt);
            }
        });

        btnConsultar1.setBackground(new java.awt.Color(0, 204, 204));
        btnConsultar1.setForeground(new java.awt.Color(0, 0, 0));
        btnConsultar1.setText("Consultar");
        btnConsultar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultar1ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setText("Consultar por tipo de publicacion");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btnSalir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRegPubli, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                            .addComponent(cmbTipoPublicacion, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGap(18, 18, 18)
                            .addComponent(btnConsultar)))
                    .addComponent(jLabel3)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(cmbTipoConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnConsultar1))
                    .addComponent(jLabel2))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(btnRegPubli)
                .addGap(18, 18, 18)
                .addComponent(btnSalir)
                .addGap(85, 85, 85)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbTipoPublicacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnConsultar))
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmbTipoConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnConsultar1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabla = new JTable(){
            public boolean isCellEditable(int row, int column){
                for (int i = 0; i < tabla.getRowCount(); i++){
                    if (row == i){
                        return false;
                    }
                }
                return true;
            }
        };
        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabla);

        txtBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarActionPerformed(evt);
            }
        });
        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscarKeyTyped(evt);
            }
        });

        btnBuscar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnBuscar.setForeground(new java.awt.Color(0, 0, 0));
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 818, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(323, 323, 323)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(257, 257, 257)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscar)))
                .addContainerGap(151, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 445, Short.MAX_VALUE)))
        );

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
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegPubliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegPubliActionPerformed
        // TODO add your handling code here:
        dispose();
        pTipoPublicacion pTipPubli = new pTipoPublicacion(usuario);
        pTipPubli.setVisible(true);
    }//GEN-LAST:event_btnRegPubliActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
        dispose();
        pLogin pLog = new pLogin();
        pLog.setVisible(true);
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        buscarTitulos();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarActionPerformed

    private void txtBuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyTyped
        char c = evt.getKeyChar();
        if (Character.isDigit(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtBuscarKeyTyped

    private void cmbTipoPublicacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTipoPublicacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbTipoPublicacionActionPerformed

    private void btnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarActionPerformed
        String busqueda = (String) cmbTipoPublicacion.getSelectedItem();
        if (!busqueda.equals("Seleccionar")) {
            buscarTipoPublicacion(busqueda);
        } else {
            JOptionPane.showMessageDialog(null, "Necesita seleccionar una opcion");
        }
    }//GEN-LAST:event_btnConsultarActionPerformed

    private void btnConsultar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultar1ActionPerformed
        String busqueda = (String) cmbTipoConsulta.getSelectedItem();
        if (!busqueda.equals("Seleccionar")) {
            buscarConsulta(busqueda);
        } else {
            JOptionPane.showMessageDialog(null, "Necesita seleccionar una opcion");
        }
    }//GEN-LAST:event_btnConsultar1ActionPerformed

    private void tablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMouseClicked
        if (evt.getClickCount() == 2) {
            List<Publicacion> publicaciones = op.consultarPublicaciones();
            Publicacion publicacion = null;
            int row = tabla.getSelectedRow();
            for (int i = 0; i < dtmPublicaciones.getRowCount(); i++) {
                if (row == i) {
                    publicacion = publicaciones.get(i);
                    break;
                }
            }
            if (publicacion.getTipoPago().equals("Tarjeta")) {
                pPagarPublicacion pagar = new pPagarPublicacion(publicacion);
                pagar.setVisible(true);
            }
        }
    }//GEN-LAST:event_tablaMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnConsultar;
    private javax.swing.JButton btnConsultar1;
    private javax.swing.JButton btnRegPubli;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox<String> cmbTipoConsulta;
    private javax.swing.JComboBox<String> cmbTipoPublicacion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
