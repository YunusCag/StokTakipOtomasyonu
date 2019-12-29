/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import data.Calisan;
import data.DataSource;
import data.Malzeme;
import java.awt.Color;
import java.awt.Image;
import java.awt.Point;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.transform.Scale;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import javax.swing.table.DefaultTableModel;
import org.jdesktop.swingx.painter.ImagePainter;
import ui.ButtonRenderer;

/**
 *
 * @author Yunus
 */
public class MalzemePane extends javax.swing.JPanel {

    /**
     * Creates new form MalzemePane
     */
    private DataSource dataSource;
    private ArrayList<Malzeme> allMalzeme;
    private String imagePath="yok";
    public MalzemePane() {
        initComponents();
        initUI();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tableSidePane = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableMalzeme = new org.jdesktop.swingx.JXTable();
        jLabel9 = new javax.swing.JLabel();
        tfSearch = new javax.swing.JTextField();
        sidePane = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tfID = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tfMalzemeAdi = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cbCinsi = new javax.swing.JComboBox<>();
        btnResimSeç = new org.jdesktop.swingx.JXButton();
        btnUpdate = new org.jdesktop.swingx.JXButton();
        btnClear = new org.jdesktop.swingx.JXButton();
        jLabel4 = new javax.swing.JLabel();
        tfResimPath = new javax.swing.JTextField();
        btnAdd = new org.jdesktop.swingx.JXButton();
        imageVResim = new org.jdesktop.swingx.JXImageView();
        lblError = new javax.swing.JLabel();

        setBackground(java.awt.Color.white);

        tableSidePane.setBackground(new java.awt.Color(233, 30, 99));

        jLabel15.setFont(new java.awt.Font("Cinzel Black", 1, 36)); // NOI18N
        jLabel15.setText("MALZEMELER");

        tableMalzeme.setForeground(javax.swing.UIManager.getDefaults().getColor("Table.highlight"));
        tableMalzeme.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "MALZEME ADI", "MALZEME CİNSİ", "RESİM", "SİL"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableMalzeme.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        tableMalzeme.setGridColor(java.awt.Color.black);
        tableMalzeme.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMalzemeMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tableMalzeme);

        jLabel9.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel9.setText("Arama:");

        tfSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfSearchKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout tableSidePaneLayout = new javax.swing.GroupLayout(tableSidePane);
        tableSidePane.setLayout(tableSidePaneLayout);
        tableSidePaneLayout.setHorizontalGroup(
            tableSidePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tableSidePaneLayout.createSequentialGroup()
                .addGap(102, 102, 102)
                .addComponent(jLabel15)
                .addContainerGap(158, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tableSidePaneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tableSidePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tableSidePaneLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        tableSidePaneLayout.setVerticalGroup(
            tableSidePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tableSidePaneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(tableSidePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(tfSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        sidePane.setBackground(java.awt.Color.white);

        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel1.setText("ID:");

        tfID.setEditable(false);
        tfID.setBackground(java.awt.Color.lightGray);

        jLabel2.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel2.setText("Malzeme Adı:");

        tfMalzemeAdi.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel3.setText("Malzeme Cinsi:");

        cbCinsi.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        cbCinsi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Gıda", "Elektronik", "Mobilya" }));

        btnResimSeç.setBackground(new java.awt.Color(0, 137, 123));
        btnResimSeç.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        btnResimSeç.setForeground(java.awt.Color.white);
        btnResimSeç.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-picture-16.png"))); // NOI18N
        btnResimSeç.setText("Resim Seç");
        btnResimSeç.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        btnResimSeç.setMargin(new java.awt.Insets(5, 5, 5, 5));
        btnResimSeç.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResimSeçActionPerformed(evt);
            }
        });

        btnUpdate.setBackground(new java.awt.Color(255, 152, 0));
        btnUpdate.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        btnUpdate.setForeground(java.awt.Color.white);
        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-update-left-rotation-30.png"))); // NOI18N
        btnUpdate.setText("DÜZENLE");
        btnUpdate.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btnUpdate.setMargin(new java.awt.Insets(5, 5, 5, 15));
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnClear.setBackground(new java.awt.Color(253, 216, 53));
        btnClear.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        btnClear.setForeground(java.awt.Color.white);
        btnClear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-clear-symbol-48.png"))); // NOI18N
        btnClear.setText("TEMİZLE");
        btnClear.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btnClear.setMargin(new java.awt.Insets(5, 5, 5, 15));
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel4.setText("Resim Path:");

        tfResimPath.setEditable(false);
        tfResimPath.setBackground(java.awt.Color.lightGray);

        btnAdd.setBackground(new java.awt.Color(174, 234, 0));
        btnAdd.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        btnAdd.setForeground(java.awt.Color.white);
        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-add-32.png"))); // NOI18N
        btnAdd.setText("EKLE");
        btnAdd.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        btnAdd.setMargin(new java.awt.Insets(5, 5, 5, 5));
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        imageVResim.setMaximumSize(new java.awt.Dimension(100, 100));
        imageVResim.setName(""); // NOI18N

        javax.swing.GroupLayout imageVResimLayout = new javax.swing.GroupLayout(imageVResim);
        imageVResim.setLayout(imageVResimLayout);
        imageVResimLayout.setHorizontalGroup(
            imageVResimLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        imageVResimLayout.setVerticalGroup(
            imageVResimLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        lblError.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lblError.setForeground(java.awt.Color.red);
        lblError.setText("ERROR MESSAGE");

        javax.swing.GroupLayout sidePaneLayout = new javax.swing.GroupLayout(sidePane);
        sidePane.setLayout(sidePaneLayout);
        sidePaneLayout.setHorizontalGroup(
            sidePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sidePaneLayout.createSequentialGroup()
                .addGroup(sidePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(sidePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(sidePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, sidePaneLayout.createSequentialGroup()
                            .addGroup(sidePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(btnResimSeç, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(sidePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(sidePaneLayout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(sidePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(cbCinsi, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(tfResimPath, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)))
                                .addGroup(sidePaneLayout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(imageVResim, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, sidePaneLayout.createSequentialGroup()
                            .addGroup(sidePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addComponent(jLabel1))
                            .addGap(18, 18, 18)
                            .addGroup(sidePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(tfID, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(tfMalzemeAdi, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(0, 28, Short.MAX_VALUE))
            .addGroup(sidePaneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblError)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        sidePaneLayout.setVerticalGroup(
            sidePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sidePaneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(sidePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(sidePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tfMalzemeAdi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(sidePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cbCinsi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(sidePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tfResimPath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(sidePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(sidePaneLayout.createSequentialGroup()
                        .addComponent(imageVResim, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(20, 20, 20))
                    .addGroup(sidePaneLayout.createSequentialGroup()
                        .addComponent(btnResimSeç, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(lblError)
                .addGap(29, 29, 29)
                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(tableSidePane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sidePane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tableSidePane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(sidePane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tableMalzemeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMalzemeMouseClicked
        int selectedRow = tableMalzeme.getSelectedRow();
        if (allMalzeme.size() > selectedRow && selectedRow >= 0) {
            Malzeme temp = allMalzeme.get(selectedRow);
            tfID.setText(temp.getMalzemeNo()+ "");
            tfMalzemeAdi.setText(temp.getMalzemeAdi());
            tfResimPath.setText(temp.getImagePath());
            imagePath=temp.getImagePath();
            resimGöster(imagePath);
            cbCinsi.setSelectedItem(temp.getMalzemeCinsi());
            
            
            Point point = evt.getPoint();
            int column = tableMalzeme.columnAtPoint(point);
            if (column == 4) {
                Runnable task = () -> {
                    dataSource.openConnection();
                    dataSource.deleteMalzeme(temp.getMalzemeNo());
                    dataSource.closeConnection();
                    tabloDoldur("");

                };
                Thread thread = new Thread(task);
                thread.start();
        }
            
        }
        
    }//GEN-LAST:event_tableMalzemeMouseClicked

    public void resimGöster(String imagePath){
        if(!imagePath.equals("")){
            int imageW = imageVResim.getWidth(); //My Button width
            int imageH = imageVResim.getHeight();//My button height
            try {
            File file=new File(imagePath);
            Image image=ImageIO.read(file);
            image.getScaledInstance(imageW, imageH, java.awt.Image.SCALE_SMOOTH);
            imageVResim.setImage(image);
            imageVResim.revalidate();
          } catch (IOException ex) {
            ex.printStackTrace();
          }   
        }
        
    }
    private void tfSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfSearchKeyReleased
        // TODO add your handling code here:
        String search=tfSearch.getText();
        tabloDoldur(search);
    }//GEN-LAST:event_tfSearchKeyReleased

    private void btnResimSeçActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResimSeçActionPerformed
        // TODO add your handling code here:
        JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        FileNameExtensionFilter filter =
        new FileNameExtensionFilter("*.Images", "jpg","png");
        jfc.addChoosableFileFilter(filter);
        jfc.setDialogTitle("Çalışan Resmini Seç");
        jfc.setFileSelectionMode(JFileChooser.APPROVE_OPTION);
        int returnValue = jfc.showSaveDialog(null);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            System.out.println("You selected the directory: " + jfc.getSelectedFile());
            File file=jfc.getSelectedFile();
            try {
                tfResimPath.setText(jfc.getSelectedFile().getAbsolutePath());
                Image image=ImageIO.read(file);
                imagePath=jfc.getSelectedFile().getAbsolutePath();
                resimGöster(imagePath);
                
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

    }//GEN-LAST:event_btnResimSeçActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
       String malzemeAdi = tfMalzemeAdi.getText().trim();
        int index = cbCinsi.getSelectedIndex();
        
        if (!malzemeAdi.equals("") && index!=-1) {
            String cinsi=cbCinsi.getSelectedItem().toString();
            
            int id=0;
            if(!tfID.getText().equals("")){
                id=Integer.parseInt(tfID.getText());
            }
            Malzeme malzeme=new Malzeme(id,malzemeAdi, cinsi,imagePath);
            Runnable task = () -> {
                dataSource.openConnection();
                boolean control = dataSource.updateMalzeme(malzeme);
                System.out.println("Malzeme güncellendi.");
                dataSource.closeConnection();
                System.out.println("Thread name:" + Thread.currentThread().getName());
                if (control) {
                    lblError.setVisible(true);
                    lblError.setForeground(Color.green);
                    lblError.setText("Malzeme güncellendi");
                    tabloDoldur("");
                } else {
                    lblError.setVisible(true);
                    lblError.setForeground(Color.red);
                    lblError.setText("Malzeme güncellenirken hata oluştu");
                }
            };
            Thread thread = new Thread(task);
            thread.start();

        } else {
            lblError.setVisible(true);
            lblError.setForeground(Color.red);
            lblError.setText("Gerekli Alanları doldurunuz");
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        // TODO add your handling code here:
        tfMalzemeAdi.setText("");
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        String malzemeAdi = tfMalzemeAdi.getText().trim();
        int index = cbCinsi.getSelectedIndex();
        
        if (!malzemeAdi.equals("") && index!=-1) {
            String cinsi=cbCinsi.getSelectedItem().toString();
            Malzeme malzeme=new Malzeme(malzemeAdi, cinsi,imagePath);
            Runnable task = () -> {
                dataSource.openConnection();
                boolean control = dataSource.addMalzeme(malzeme);
                System.out.println("Malzeme eklendi");
                dataSource.closeConnection();
                System.out.println("Thread name:" + Thread.currentThread().getName());
                if (control) {
                    lblError.setVisible(true);
                    lblError.setForeground(Color.green);
                    lblError.setText("Malzeme eklendi");
                    tabloDoldur("");
                } else {
                    lblError.setVisible(true);
                    lblError.setForeground(Color.red);
                    lblError.setText("Malzeme eklenirken hata oluştu");
                }
            };
            Thread thread = new Thread(task);
            thread.start();

        } else {
            lblError.setVisible(true);
            lblError.setForeground(Color.red);
            lblError.setText("Gerekli Alanları doldurunuz");
        }
    }//GEN-LAST:event_btnAddActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.jdesktop.swingx.JXButton btnAdd;
    private org.jdesktop.swingx.JXButton btnClear;
    private org.jdesktop.swingx.JXButton btnResimSeç;
    private org.jdesktop.swingx.JXButton btnUpdate;
    private javax.swing.JComboBox<String> cbCinsi;
    private org.jdesktop.swingx.JXImageView imageVResim;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblError;
    private javax.swing.JPanel sidePane;
    private org.jdesktop.swingx.JXTable tableMalzeme;
    private javax.swing.JPanel tableSidePane;
    private javax.swing.JTextField tfID;
    private javax.swing.JTextField tfMalzemeAdi;
    private javax.swing.JTextField tfResimPath;
    private javax.swing.JTextField tfSearch;
    // End of variables declaration//GEN-END:variables

    private void initUI() {
        lblError.setVisible(false);
        imageVResim.setScale(1);
        tableMalzeme.getColumn("SİL").setCellRenderer(new ButtonRenderer("SİL"));
        tabloDoldur("");
    }
    
    private void tabloDoldur(String search) {
        dataSource=new DataSource();
        DefaultTableModel model = (DefaultTableModel) tableMalzeme.getModel();
        model.setNumRows(0);
    
        Runnable task = () -> {
            dataSource.openConnection();
            allMalzeme = dataSource.getAllMalzemeler(search);
            dataSource.closeConnection();
            if (allMalzeme.size() > 0) {
                allMalzeme.forEach((m) -> {
                    model.addRow(new Object[]{m.getMalzemeNo(),m.getMalzemeAdi(),m.getMalzemeCinsi()
                            ,m.getImagePath()});
                });
            }
        };
        Thread thread = new Thread(task);
        thread.start();
    }

    
}
