/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pantallas;

import Entidades.Autor;
import Entidades.Usuario;
import comunicacion.IOperacion;
import comunicacion.SOperacion;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author marti
 */
public class pRegistrarPublicacion extends javax.swing.JFrame {

    private IOperacion op;
    private Usuario usuario;

    /**
     * Creates new form pPrincipalCliente
     *
     * @param tipoPublicacion
     * @param user
     */
    public pRegistrarPublicacion(String tipoPublicacion, Usuario user) {
        initComponents();
        this.usuario = user;
        op = SOperacion.getOperacion();
        llenarCombobox();
        this.txtTipoPublicacion.setText(tipoPublicacion);
        elegirTipoPublicacion();
        ocultarCampos();
    }

    private void ocultarCampos() {
        if (usuario != null) {
            if (usuario.isEsAutor()) {
                this.lblAutor.setVisible(false);
                this.cmbAutor.setVisible(false);
            }
        }
    }

    private void llenarCombobox() {
        List<Autor> autores = op.consultarAutores();
        for (Autor autor : autores) {
            cmbAutor.addItem(autor);
        }
        String tipoPagos[] = {"Efectivo", "Transferencia", "Tarjeta"};
        for (String pago : tipoPagos) {
            cmbTipoPago.addItem(pago);
        }
    }

    public void vaciarCampos() {
        this.txtPaginas.setText("");
        this.txtTitulo.setText("");
        this.txtVar.setText("");
    }

    private void elegirTipoPublicacion() {
        if (this.txtTipoPublicacion.getText().equals("Fisico")) {
            jlbVar.setText("Pagina inicial");
        } else {
            jlbVar.setText("Tamaño en megas");
        }
    }

    private boolean camposVacios() {
        boolean vacio = false;
        if (this.txtPaginas.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Falta el campo #Paginas por llenar");
            vacio = true;
        } else if (this.txtTitulo.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Falta el campo Titulo por llenar");
            vacio = true;
        } else if (this.txtVar.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Falta el campo " + this.jlbVar.getText() + " por llenar");
            vacio = true;
        }
        return vacio;
    }

    private boolean validarCampos() {
        boolean valido = true;
        if (!op.validarCadenaEntero(this.txtPaginas.getText())) {
            JOptionPane.showMessageDialog(null, "El campo #Paginas no acepta caracteres");
            valido = false;
        }
        if (this.jlbVar.getText().equals("Fisico")) {
            if (!op.validarCadenaEntero(this.txtVar.getText())) {
                JOptionPane.showMessageDialog(null, "El campo Pagina inical no acepta caracteres o decimales");
                valido = false;
            }
        } else {
            if (!op.validarDecimal(this.txtVar.getText())) {
                JOptionPane.showMessageDialog(null, "El campo tamaño en megas no acepta caracteres");
                valido = false;
            }
        }
        return valido;
    }

    private Autor crearAutor() {
        Autor autor;
        if (usuario != null) {
            if (usuario.isEsAutor()) {
                autor = new Autor(usuario.getNombreCliente());
            } else {
                autor = (Autor) this.cmbAutor.getSelectedItem();
            }
        } else {
            autor = (Autor) this.cmbAutor.getSelectedItem();
        }
        return autor;
    }

    private void registrarPublicacion() {
        pMostrarCosto pCostos;
        if (!camposVacios()) {
            if (validarCampos()) {
                if (txtTipoPublicacion.getText().equals("Fisico")) {
                    Autor autor = crearAutor();
                    int nPaginas = Integer.parseInt(this.txtPaginas.getText());
                    String titulo = this.txtTitulo.getText();
                    int paginaInicial = Integer.parseInt(this.txtVar.getText());
                    String tipoPublicacion = this.txtTipoPublicacion.getText();
                    String tipoPago = (String) this.cmbTipoPago.getSelectedItem();
                    float costo = op.mostrarCosto(nPaginas);
                    float precioVenta = op.mostrarPrecioFisico(autor.getNacionalidad(), costo);
                    pCostos = new pMostrarCosto(costo, precioVenta, tipoPago, tipoPublicacion, nPaginas, usuario);
                    pCostos.setVisible(true);
                    pCostos.sendDataFisico(autor, titulo, paginaInicial);
                } else {
                    Autor autor = crearAutor();
                    int nPaginas = Integer.parseInt(this.txtPaginas.getText());
                    String titulo = this.txtTitulo.getText();
                    float tamMegas = Float.parseFloat(this.txtVar.getText());
                    String tipoPublicacion = this.txtTipoPublicacion.getText();
                    String tipoPago = (String) this.cmbTipoPago.getSelectedItem();
                    float costo = op.mostrarCosto(nPaginas);
                    float precioVenta = op.mostrarPrecioDigital(tamMegas, costo);
                    pCostos = new pMostrarCosto(costo, precioVenta, tipoPago, tipoPublicacion, nPaginas, usuario);
                    pCostos.setVisible(true);
                    pCostos.sendDataDigital(autor, titulo, tamMegas);
                }
            }
        }
    }

    private void cambiarDestino() {
        if (usuario.isEsAutor()) {
            pConsultarPublicacion pConsPubli = new pConsultarPublicacion(usuario);
            pConsPubli.setVisible(true);
        }
        pPrincipalCliente pCliente = new pPrincipalCliente(usuario);
        pCliente.setVisible(true);
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
        btnRegAutor = new javax.swing.JButton();
        btnConsulPubli = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        lblAutor = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtPaginas = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtTitulo = new javax.swing.JTextField();
        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        cmbAutor = new javax.swing.JComboBox<>();
        jlbVar = new javax.swing.JLabel();
        txtVar = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtTipoPublicacion = new javax.swing.JTextField();
        btnLimpiar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        cmbTipoPago = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(187, 187, 187));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Editando Mundos");

        jPanel2.setBackground(new java.awt.Color(0, 102, 204));

        btnRegAutor.setBackground(new java.awt.Color(0, 204, 204));
        btnRegAutor.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnRegAutor.setForeground(new java.awt.Color(0, 0, 0));
        btnRegAutor.setText("Registrar Autor");
        btnRegAutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegAutorActionPerformed(evt);
            }
        });

        btnConsulPubli.setBackground(new java.awt.Color(0, 204, 204));
        btnConsulPubli.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnConsulPubli.setForeground(new java.awt.Color(0, 0, 0));
        btnConsulPubli.setText("Consultar Publicación");
        btnConsulPubli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsulPubliActionPerformed(evt);
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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnConsulPubli, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnRegAutor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSalir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(btnRegAutor)
                .addGap(18, 18, 18)
                .addComponent(btnConsulPubli)
                .addGap(18, 18, 18)
                .addComponent(btnSalir)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(0, 204, 255));

        lblAutor.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblAutor.setForeground(new java.awt.Color(0, 0, 0));
        lblAutor.setText("Autor:");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("#Paginas:");

        txtPaginas.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        txtPaginas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPaginasKeyTyped(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Titulo:");

        txtTitulo.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        txtTitulo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTituloKeyTyped(evt);
            }
        });

        btnAceptar.setBackground(new java.awt.Color(0, 204, 204));
        btnAceptar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnAceptar.setForeground(new java.awt.Color(0, 0, 0));
        btnAceptar.setText("Cotizar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        btnCancelar.setBackground(new java.awt.Color(0, 204, 204));
        btnCancelar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(0, 0, 0));
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        cmbAutor.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N

        jlbVar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jlbVar.setForeground(new java.awt.Color(0, 0, 0));
        jlbVar.setText("Pagina Inicial:");

        txtVar.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        txtVar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtVarKeyTyped(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Tipo de publicación:");

        txtTipoPublicacion.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        txtTipoPublicacion.setEnabled(false);

        btnLimpiar.setBackground(new java.awt.Color(0, 204, 204));
        btnLimpiar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnLimpiar.setForeground(new java.awt.Color(0, 0, 0));
        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Medio de pago:");

        cmbTipoPago.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(lblAutor)
                            .addComponent(jlbVar)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtPaginas, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)
                            .addComponent(cmbAutor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtTipoPublicacion)
                            .addComponent(txtVar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbTipoPago, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(102, 102, 102)
                        .addComponent(btnCancelar)
                        .addGap(92, 92, 92)
                        .addComponent(btnAceptar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAutor)
                    .addComponent(cmbAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtPaginas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbVar)
                    .addComponent(txtVar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(cmbTipoPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(txtTipoPublicacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(69, 69, 69)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAceptar)
                    .addComponent(btnCancelar)
                    .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(61, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(323, 323, 323)
                .addComponent(jLabel1)
                .addContainerGap(234, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
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

    private void btnRegAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegAutorActionPerformed
        // TODO add your handling code here:
        dispose();
        pRegistrarAutor pRegAutor = new pRegistrarAutor(usuario);
        pRegAutor.setVisible(true);
    }//GEN-LAST:event_btnRegAutorActionPerformed

    private void btnConsulPubliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsulPubliActionPerformed
        // TODO add your handling code here:
        dispose();
        cambiarDestino();
    }//GEN-LAST:event_btnConsulPubliActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
        dispose();
        pLogin pLog = new pLogin();
        pLog.setVisible(true);
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        // TODO add your handling code here:
        registrarPublicacion();
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        dispose();
        pPrincipalEditor pEditor = new pPrincipalEditor(usuario);
        pEditor.setVisible(true);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtTituloKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTituloKeyTyped
        char c = evt.getKeyChar();
        if (Character.isDigit(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtTituloKeyTyped

    private void txtPaginasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPaginasKeyTyped
        char c = evt.getKeyChar();
        if (Character.isLetter(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtPaginasKeyTyped

    private void txtVarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtVarKeyTyped
        char c = evt.getKeyChar();
        if (Character.isLetter(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtVarKeyTyped

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        vaciarCampos();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnConsulPubli;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnRegAutor;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox<Object> cmbAutor;
    private javax.swing.JComboBox<String> cmbTipoPago;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel jlbVar;
    private javax.swing.JLabel lblAutor;
    private javax.swing.JTextField txtPaginas;
    private javax.swing.JTextField txtTipoPublicacion;
    private javax.swing.JTextField txtTitulo;
    private javax.swing.JTextField txtVar;
    // End of variables declaration//GEN-END:variables
}
