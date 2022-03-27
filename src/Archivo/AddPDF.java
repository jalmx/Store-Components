/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Archivo;

//import DB.Variables;
import DB.Variables;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author JOSEF
 */
public class AddPDF extends javax.swing.JDialog {

    /**
     * Creates new form AddPDF
     */
    private String save="Sin Archivo";    //path del archivo
    private String pathBase ="";

    public AddPDF(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        this.genearatePathBase();
        initComponents();
        ImageIcon imagen = new ImageIcon("Imgs"+File.separator+"TO39.png");
        setIconImage(imagen.getImage());
        setLocationRelativeTo(null);
        jrbArchivo.setSelected(true);
        jtLink.setEnabled(false);
        jSaveInt.setEnabled(false);

        createFolderToSavePDF();
        createNameFile(Variables.codigo);
    }

    public AddPDF(java.awt.Frame parent, boolean modal, String codigo) {//invoca  por edición        
        this(parent,modal);
        createNameFile(codigo);
    }

    private void createNameFile(String name) {
    	  
    	save = pathBase + File.separator+ name + ".pdf";
    	System.out.println("Full path creado" + save);
    }
    private void genearatePathBase() {
    	String url = this.getClass().getProtectionDomain().getCodeSource().getLocation().toString();
    	url = url.replace("file:","" );
		
		String[] splitPath = url.split(File.separator);
		
		StringBuilder fullPath = new StringBuilder();
		
		for ( int x =0; x < splitPath.length - 1; x++) {
			fullPath.append(splitPath[x]+File.separator);
		}
		pathBase = fullPath.toString();
		System.out.println(pathBase);
    }
    
    private void createFolderToSavePDF() {
    	pathBase = pathBase + "Datasheets";
        if (!new File(pathBase).mkdir()) {
            new File(pathBase).mkdir();
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jrbInternet = new javax.swing.JRadioButton();
        jrbArchivo = new javax.swing.JRadioButton();
        jtLink = new javax.swing.JTextField();
        jbBuscar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSaveInt = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Agregar Datasheet");
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED), "Agregar Datasheet de:"));

        buttonGroup1.add(jrbInternet);
        jrbInternet.setText("Internet:");
        jrbInternet.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jrbInternetMouseClicked(evt);
            }
        });
        jrbInternet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbInternetActionPerformed(evt);
            }
        });

        buttonGroup1.add(jrbArchivo);
        jrbArchivo.setText("Archivo:");
        jrbArchivo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jrbArchivoMouseClicked(evt);
            }
        });
        jrbArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbArchivoActionPerformed(evt);
            }
        });

        jtLink.setToolTipText("Link de descarga");

        jbBuscar.setText("Buscar");
        jbBuscar.setToolTipText("Buscar archivo y guardar");
        jbBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscarActionPerformed(evt);
            }
        });

        jSaveInt.setText("Guardar");
        jSaveInt.setToolTipText("Descargar archivo y guardar");
        jSaveInt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSaveIntActionPerformed(evt);
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
                        .addComponent(jrbArchivo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jrbInternet)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jtLink, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSaveInt, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator1)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jrbInternet)
                    .addComponent(jtLink, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSaveInt))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jrbArchivo)
                    .addComponent(jbBuscar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarActionPerformed
        InputStream in = null;
        JFileChooser ventana = new JFileChooser();
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivo PDF", "PDF");//filtro para ver solo imagenes deseadas
        ventana.addChoosableFileFilter(filtro);//se agregar el filtro a la ventana
        int v = ventana.showOpenDialog(null); //ventana para abrir archivo 

        if (v == 0) {
            try {
                in = new FileInputStream(ventana.getSelectedFile());
                FileOutputStream out = new FileOutputStream(save);

                byte[] buf = new byte[1024];
                int len;

                while ((len = in.read(buf)) > 0) {
                    out.write(buf, 0, len);
                }
                in.close();
                out.close();
                JOptionPane.showMessageDialog(null, "Guardado");

                Variables.archivo = save;//ruta en donde esta guardado el archivo seleccionado
                System.out.println("Archivo guardado en " + save);
                this.dispose();
            } catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(null, "Archivo no encontrado");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Fallo archivo");
            } finally {
                try {
                    in.close();
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Error al cerrar");
                }
            }
        }

    }//GEN-LAST:event_jbBuscarActionPerformed

    private void jrbArchivoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jrbArchivoMouseClicked

    }//GEN-LAST:event_jrbArchivoMouseClicked

    private void jrbInternetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jrbInternetMouseClicked

    }//GEN-LAST:event_jrbInternetMouseClicked

    private void jSaveIntActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSaveIntActionPerformed
//        si esta seleccionado el jradiobutton en Internet hara lo siguiente
        if (jtLink.getText().endsWith(".pdf")) {
            if (jrbInternet.isFontSet()) {
                if ("".equals(jtLink.getText())) {
                    this.dispose();//cierra si esta vacio y esta seleccionado
                } else {
                    if (jtLink.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Sin archivo");
                    } else {
                        try {
                            URL url = new URL(jtLink.getText());

                            // establecemos conexion
                            URLConnection urlCon = url.openConnection();
                            // Se obtiene el inputStream del pdf en la web y se abre el fichero local.
                            InputStream is = urlCon.getInputStream();
                            FileOutputStream arch = new FileOutputStream(save);

                            // Lectura de la foto de la web y escritura en fichero local
                            byte[] array = new byte[1000]; // buffer temporal de lectura.
                            int leido = is.read(array);
                            while (leido > 0) {
                                arch.write(array, 0, leido);
                                leido = is.read(array);
                            }
                            // cierre de conexion y fichero.
                            is.close();
                            arch.close();

                            Variables.archivo = save;
                            System.out.println("Archivo guardado en " + save);
                            JOptionPane.showMessageDialog(null, "Archivo guardado");

                        } catch (MalformedURLException e) {
                            e.printStackTrace();
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    }
                }
            }
            this.dispose();
        } else {
            JOptionPane.showConfirmDialog(null, "Link incorrecto", "Error de descarga",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
            jtLink.setText("");
        }

    }//GEN-LAST:event_jSaveIntActionPerformed

    private void jrbArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbArchivoActionPerformed
        if (jrbArchivo.isFontSet()) {
            jtLink.setEnabled(false);
            jbBuscar.setEnabled(true);
            jSaveInt.setEnabled(false);
        }
    }//GEN-LAST:event_jrbArchivoActionPerformed

    private void jrbInternetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbInternetActionPerformed
        if (jrbInternet.isFontSet()) {
            jbBuscar.setEnabled(false);
            jtLink.setEnabled(true);
            jSaveInt.setEnabled(true);
        }
    }//GEN-LAST:event_jrbInternetActionPerformed

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
            java.util.logging.Logger.getLogger(AddPDF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddPDF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddPDF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddPDF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AddPDF dialog = new AddPDF(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jSaveInt;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton jbBuscar;
    private javax.swing.JRadioButton jrbArchivo;
    private javax.swing.JRadioButton jrbInternet;
    private javax.swing.JTextField jtLink;
    // End of variables declaration//GEN-END:variables
}
