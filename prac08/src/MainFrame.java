
import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;


public class MainFrame  extends javax.swing.JFrame implements Observer{

    /**
     * Creates new form NewJFrame
     */
    private File abre,dest;
    private Boolean working;
    private ZipWorker worker;
    
    public MainFrame() {
        initComponents();
        this.setTitle("Practica 8 DIU");
        progressBar.setMaximum(100);
        progressBar.setMinimum(0);
        progressBar.setStringPainted(true);
        progressBar.setForeground(Color.blue);
        this.addWindowListener(onWindowClosing());
        working = false;
        carpetaActual.setEditable(false);
        carpetaActual.setBackground(Color.LIGHT_GRAY);
        carpetaDestino.setEditable(false);
        carpetaDestino.setBackground(Color.LIGHT_GRAY);
        this.setResizable(false);
        
    }
    
    private WindowAdapter onWindowClosing(){
        return new WindowAdapter() {
            
            @Override
            public void windowClosing(WindowEvent e){
                inCloseActionPerformed();
            }
            
        };
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        comprimirButton = new javax.swing.JButton();
        abrirCarpetaButton = new javax.swing.JButton();
        progressBar = new javax.swing.JProgressBar();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        carpetaActual = new javax.swing.JTextField();
        saveButton = new javax.swing.JButton();
        cancelarButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        carpetaDestino = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        comprimirButton.setText("Comprimir carpeta");
        comprimirButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                comprimirButtonMouseClicked(evt);
            }
        });
        comprimirButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comprimirButtonActionPerformed(evt);
            }
        });

        abrirCarpetaButton.setText("Seleccionar Carpeta Origen");
        abrirCarpetaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abrirCarpetaButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("Estado de la compresion : ");

        jLabel2.setText("Carpeta origen :");

        carpetaActual.setText("*Ninguna Seleccionada*");

        saveButton.setText("Seleccionar Carpeta Destino");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        cancelarButton.setText("Cancelar");
        cancelarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarButtonActionPerformed(evt);
            }
        });

        jLabel4.setText("Carpeta destino :");

        carpetaDestino.setText("*Ninguna Seleccionada*");
        carpetaDestino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                carpetaDestinoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(cancelarButton)
                        .addGap(107, 107, 107))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1)
                        .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addGap(18, 18, 18))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addGap(20, 20, 20)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(carpetaDestino)
                                .addComponent(carpetaActual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(abrirCarpetaButton)
                .addGap(16, 16, 16)
                .addComponent(saveButton))
            .addGroup(layout.createSequentialGroup()
                .addGap(110, 110, 110)
                .addComponent(comprimirButton, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(abrirCarpetaButton)
                    .addComponent(saveButton))
                .addGap(18, 18, 18)
                .addComponent(comprimirButton)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(carpetaActual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(carpetaDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cancelarButton)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void comprimirButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_comprimirButtonMouseClicked
        // TODO add your handling code here:
        

    }//GEN-LAST:event_comprimirButtonMouseClicked

    private void comprimirButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comprimirButtonActionPerformed
        // TODO add your handling code here:
        if(abre==null || dest == null){
            JOptionPane.showMessageDialog(this, "Falta especificar la carpeta de destino o de origen", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        working=true;
        System.out.print("Pulsado!!");
        worker = new ZipWorker(this,abre,dest.getAbsolutePath());
        
        worker.execute();
        
    }//GEN-LAST:event_comprimirButtonActionPerformed
    
    private void inCloseActionPerformed(){
        String msn="Seguro que quieres salir";
        String ObjButtons[] = {"Si","No"};
        if(working){
            msn="Se está comprimiendo un directorio actualmente, puede que el resultado se vea dañado";
            ObjButtons = new String[]{"Salir de todas formas","No"};
        }
        
        int PromptResult = JOptionPane.showOptionDialog(this,msn,"Salir",JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE,null,ObjButtons,ObjButtons[1]);
        if(PromptResult==JOptionPane.YES_OPTION)
        {
            System.exit(0);
        }else {
            this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        }
    }
    
    
    
    private void abrirCarpetaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abrirCarpetaButtonActionPerformed

        if(working){
            JOptionPane.showMessageDialog(this, "Hay una compresion realizandose", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }
        JFileChooser fileChoser = new JFileChooser();
        fileChoser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        
        FileFilter directoryFilter = new FileFilter() {
			public boolean accept(File file) {
				return file.isDirectory();
			}

            @Override
            public String getDescription() {
                return "Carpetas";
            }
		};
        fileChoser.setFileFilter(directoryFilter);
        fileChoser.setAcceptAllFileFilterUsed(false);
        int resultado = fileChoser.showOpenDialog(this);
        abre = fileChoser.getSelectedFile();
        if (abre!= null && !abre.exists()){
            JOptionPane.showMessageDialog(this, "El fichero " + abre.getAbsolutePath() + " no existe." );
        }else if(resultado == JFileChooser.APPROVE_OPTION){
            try {
            
            }catch(Exception e){System.out.println(e);}
                
        }
        carpetaActual.setText(abre.getName());
    }//GEN-LAST:event_abrirCarpetaButtonActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        // TODO add your handling code here:
        
        JFileChooser fileChoser = new JFileChooser();
        fileChoser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        
        FileFilter directoryFilter = new FileFilter() {
			public boolean accept(File file) {
				return file.isDirectory();
			}

            @Override
            public String getDescription() {
                return "Carpetas";
            }
		};
        fileChoser.setFileFilter(directoryFilter);
        fileChoser.setAcceptAllFileFilterUsed(false);
        int result = fileChoser.showSaveDialog(this);
        if(result == JFileChooser.CANCEL_OPTION)return;
        if(result == JFileChooser.APPROVE_OPTION)saveCarpeta(fileChoser.getSelectedFile());
        if(dest== null)carpetaDestino.setText("*Ninguna Seleccionada*");
        else carpetaDestino.setText(dest.getName());
    }//GEN-LAST:event_saveButtonActionPerformed

    private void carpetaDestinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_carpetaDestinoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_carpetaDestinoActionPerformed

    private void cancelarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarButtonActionPerformed
        if(worker!=null){
            
            worker.cancel(true);
            
        }
    }//GEN-LAST:event_cancelarButtonActionPerformed

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
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton abrirCarpetaButton;
    private javax.swing.JButton cancelarButton;
    private javax.swing.JTextField carpetaActual;
    private javax.swing.JTextField carpetaDestino;
    private javax.swing.JButton comprimirButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JProgressBar progressBar;
    private javax.swing.JButton saveButton;
    // End of variables declaration//GEN-END:variables

    @Override
    public void notifyProgess(int porcentage) {
        progressBar.setValue(porcentage);
    }

    void finish() {
        if(worker.isCancelled()){
            UIManager.put( "nimbusOrange", Color.RED );
            JOptionPane.showMessageDialog(this, "Operación cancelada", "Aviso", JOptionPane.WARNING_MESSAGE);
        }else{
            UIManager.put( "nimbusOrange", Color.GREEN );
            working = false;
        }
        
        
    }

    private void saveCarpeta(File file) {
        String absolutePath = file.getAbsolutePath();
        if (!file.isDirectory()){
            JOptionPane.showMessageDialog(this, "Es necesario especificar una carpeta de destino", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }else if (absolutePath.equals(abre.getAbsolutePath())){
            JOptionPane.showMessageDialog(this, "La carpeta de destino tiene que ser distinta a la de origen", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        dest  = file;
        
        
        
    }

    void errorOcurred() {
        progressBar.repaint();
        if(!worker.isCancelled())JOptionPane.showMessageDialog(this, "Ha ocurrido un error inesperado mientras se comprimia el archivo", "Error", JOptionPane.ERROR_MESSAGE);
        
    }
}



