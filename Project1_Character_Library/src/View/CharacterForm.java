/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.GeneralViewerController;
import Model.Weapon;
import java.awt.Image;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.AbstractListModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import utils.ImageChooser;
import Model.Character;
import Model.Direction;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author lalem
 */
public class CharacterForm extends javax.swing.JFrame {

    CustomListWeaponModel weaponModel = new CustomListWeaponModel();
    private GeneralViewerController controller;
    private ArrayList<String> images;
    private int index;
    private Character character;
    private DefaultComboBoxModel availableWeapons;
    private DefaultComboBoxModel directionsModel;

    public CharacterForm() {
        initComponents();
        this.index = 0;
        this.controller = GeneralViewerController.getInstance();
        this.availableWeapons =  new DefaultComboBoxModel();
        this.directionsModel =  new DefaultComboBoxModel(Direction.values());
        fillComboWeapons();
        fillComboDirections();
        initWeaponList();
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
    
    public CharacterForm(Character character) {
        initComponents();
        this.index = 0;
        this.controller = GeneralViewerController.getInstance();
        this.character = character;
        this.availableWeapons =  new DefaultComboBoxModel();
        this.directionsModel =  new DefaultComboBoxModel(Direction.values());
        fillComboWeapons();
        fillComboDirections();
    }

    private void initWeaponList() {
        weaponList.setModel(weaponModel);
        if(character != null){
            weaponModel.setEntities(controller.getWeapons(character));
        }
    }

    private Weapon getSelectedWeapon() {
        Weapon selectedWeapon = weaponModel.getWeapon(weaponList.getSelectedIndex());
        return selectedWeapon;
    }
    
    private void deleteSelectedWeapon() {
        weaponModel.deleteWeapon(index);
        weaponList.updateUI();
    }

    public void fillComboWeapons(){
        ArrayList<Weapon> weapons = controller.getWeaponList();
        for (int i = 0; i < weapons.size(); i++) {
            availableWeapons.addElement(weapons.get(i));
            availableWeaponsList.setModel(availableWeapons);
        }
    } 
    
    public void fillComboDirections(){
        cbxDirection.setModel(directionsModel);
    } 
    
    public Weapon getComboSelectedWeapon(){
        Weapon weapon = (Weapon) availableWeaponsList.getSelectedItem();
        return weapon;
        
    }
    
    public Direction getComboSelectedDirection(){
        return (Direction) cbxDirection.getSelectedItem();
    }

    public void openFile(javax.swing.JLabel label) {

        images = new ArrayList<>(); //Se inicializa el arreglo
        try {
            images = ImageChooser.Choose();
            String strPaths = images.toString().replace("[", "").replace("]", "");
            txtPath.setText(strPaths);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Problem choosing images", "Error", JOptionPane.ERROR_MESSAGE);
        }

        try {
            Image img;
            ImageIcon icono = new ImageIcon();
            img = img = ImageChooser.getImage(lblImage.getWidth(), lblImage.getHeight(), images.get(0));
            if (img != null) {
                icono.setImage(img);
                label.setIcon(icono);
            }
        } catch (IOException ex) {
        }

    }

    public void previousImage(javax.swing.JLabel label) {
        if (index > 0) {
            try {
                index = index - 1;
                Image img;
                ImageIcon icono = new ImageIcon();
                img = ImageChooser.getImage(label.getWidth(), label.getHeight(), images.get(index));
                if (img != null) {
                    icono.setImage(img);
                    label.setIcon(icono);
                }
            } catch (IOException ex) {
            }
        }
    }

    public void nextImage(javax.swing.JLabel label) {
        if (index < images.size() - 1) {
            try {
                index = index + 1;
                Image img;
                ImageIcon icono = new ImageIcon();
                img = ImageChooser.getImage(label.getWidth(), label.getHeight(), images.get(index));
                if (img != null) {
                    icono.setImage(img);
                    label.setIcon(icono);
                }
            } catch (IOException ex) {
            }
        }
    }

    public void addLevelAspect(javax.swing.JTextField txtlevel, javax.swing.JTextField txtpath, javax.swing.JLabel lblimage) {
        int level = Integer.parseInt(txtlevel.getText());
        ArrayList<String> paths = new ArrayList<>(Arrays.asList(txtpath.getText().split(",")));
        controller.insertCharacterLevel(level, paths);
    }

    
    public Character createCharacter(String pName, int pLife, int pLevelReq, int pLevel, double pHitsPerTime, double pFields,
                                Direction pDirection,int pCost) throws IOException {
        return controller.createCharacter(pName, pLife, pLevelReq, pLevel, pHitsPerTime, pFields, pDirection,pCost);
    }
    
    public class CustomListWeaponModel extends AbstractListModel {

        private ArrayList<Weapon> entities = new ArrayList();

        @Override
        public int getSize() {
            return entities.size();
        }

        @Override

        public Object getElementAt(int index) {
            Weapon entity = entities.get(index);
            return entity.getName();
        }

        public Weapon getWeapon(int index) {
            return entities.get(index);
        }

        public void setEntities(ArrayList<Weapon> entities) {
            this.entities = entities;
            
        }
        
        public void insertWeapon(Weapon w){
            System.out.println(w.getName());
            this.entities.add(w);
            this.entities.get(this.entities.size() - 1);
        }
        
        public void deleteWeapon(int index){
            this.entities.remove(index);
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

        jButton2 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtPath = new javax.swing.JTextField();
        btnOpenFile = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        weaponList = new javax.swing.JList<>();
        btnAddWeapon = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        txtLife = new javax.swing.JTextField();
        txtHitsPerTime = new javax.swing.JTextField();
        txtFieldsInArmy = new javax.swing.JTextField();
        txtLevelRequired = new javax.swing.JTextField();
        availableWeaponsList = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtLevel = new javax.swing.JTextField();
        jButton7 = new javax.swing.JButton();
        btnSaveAsNew = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        btnPrevious = new javax.swing.JButton();
        lblImage = new javax.swing.JLabel();
        btnNext = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        txtCost = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        cbxDirection = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        txtInitialLevel = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();

        jButton2.setText("Add");

        jLabel6.setText("Nivel");

        jLabel5.setText("Route");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel7.setText("Preview");

        jButton1.setText("Open File");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Life");

        jLabel2.setText("Hits per tine");

        jLabel3.setText("Level Required");

        jLabel4.setText("Fields in Army");

        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        jLabel8.setText("Level");

        jLabel9.setText("Route");

        btnOpenFile.setText("Open File");
        btnOpenFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOpenFileActionPerformed(evt);
            }
        });

        weaponList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                weaponListValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(weaponList);

        btnAddWeapon.setText("Add");
        btnAddWeapon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddWeaponActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        txtLevelRequired.setText(" ");

        availableWeaponsList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                availableWeaponsListActionPerformed(evt);
            }
        });

        jLabel11.setText("Character weapons");

        jLabel12.setText("Available weapons");

        jButton7.setText("Save");

        btnSaveAsNew.setText("Save as a new Character");
        btnSaveAsNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveAsNewActionPerformed(evt);
            }
        });

        jLabel10.setText("Name");

        btnPrevious.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/previous.png"))); // NOI18N
        btnPrevious.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPreviousActionPerformed(evt);
            }
        });

        lblImage.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnNext.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/next.png"))); // NOI18N
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        jLabel13.setText("Cost");

        jLabel14.setText("Direction");

        jLabel15.setText("Initial level");

        txtInitialLevel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtInitialLevelActionPerformed(evt);
            }
        });

        jLabel16.setText("Create characters");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 616, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel11)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnDelete)
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(jButton7)
                                                .addGap(20, 20, 20)
                                                .addComponent(btnSaveAsNew))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(btnAddWeapon)
                                                    .addComponent(availableWeaponsList, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel12))
                                                .addGap(0, 0, Short.MAX_VALUE)))))))
                        .addGap(8, 8, 8))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 100, Short.MAX_VALUE)
                                .addComponent(cbxDirection, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel13))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtFieldsInArmy)
                                    .addComponent(txtHitsPerTime)
                                    .addComponent(txtLife)
                                    .addComponent(txtLevelRequired, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                                    .addComponent(txtCost)
                                    .addComponent(txtName, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel9)
                                .addComponent(jLabel8))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(btnAdd))
                            .addComponent(jLabel15))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtPath, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnOpenFile))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtLevel, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnPrevious, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblImage, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(txtInitialLevel, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(15, 15, 15))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtLife, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtHitsPerTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtFieldsInArmy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtLevelRequired, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(txtInitialLevel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8)
                                    .addComponent(txtLevel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel9)
                                        .addComponent(txtPath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnOpenFile))
                                    .addGap(51, 51, 51)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(92, 92, 92)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblImage, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(40, 40, 40))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(41, 41, 41)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(btnAdd)
                                            .addComponent(btnPrevious, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))))))))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txtCost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(cbxDirection, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 29, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnDelete)
                                    .addComponent(availableWeaponsList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(btnAddWeapon))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(146, 146, 146)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton7)
                            .addComponent(btnSaveAsNew))))
                .addGap(26, 26, 26))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void availableWeaponsListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_availableWeaponsListActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_availableWeaponsListActionPerformed

    private void btnPreviousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPreviousActionPerformed
        previousImage(lblImage);
    }//GEN-LAST:event_btnPreviousActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        nextImage(lblImage);
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnOpenFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOpenFileActionPerformed
        openFile(lblImage);
    }//GEN-LAST:event_btnOpenFileActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        addLevelAspect(txtLevel, txtPath, lblImage);
        lblImage.setIcon(null);
        txtLevel.setText("");
        txtPath.setText("");
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        deleteSelectedWeapon();
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void weaponListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_weaponListValueChanged

    }//GEN-LAST:event_weaponListValueChanged

    private void btnAddWeaponActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddWeaponActionPerformed
        Weapon weapon = getComboSelectedWeapon();
        System.out.println(weapon.getName());
        controller.insertWeapons(weapon);
        //HELP, COMO AGREGO AL JLIST Y ACTUALIZO
        weaponModel.insertWeapon(weapon);
        weaponList.updateUI();
    }//GEN-LAST:event_btnAddWeaponActionPerformed

    private void btnSaveAsNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveAsNewActionPerformed
        String name = txtName.getText();
        int life  = Integer.parseInt(txtLife.getText());
        //int levelReq = Integer.parseInt(txtLevelRequired.getText());
        int initialLevel  =  Integer.parseInt(txtInitialLevel.getText());
        double hitsPerTime =  Double.parseDouble(txtHitsPerTime.getText());
        double fields = Double.parseDouble(txtFieldsInArmy.getText());
        Direction direction = getComboSelectedDirection();
        int cost =  Integer.parseInt(txtCost.getText());
        
        try {
            createCharacter(name,life,1,initialLevel,hitsPerTime,fields,direction,cost);
            JOptionPane.showMessageDialog(null, "Character created!");
        } catch (IOException ex) {
            Logger.getLogger(CharacterForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }//GEN-LAST:event_btnSaveAsNewActionPerformed

    private void txtInitialLevelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtInitialLevelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtInitialLevelActionPerformed

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
            java.util.logging.Logger.getLogger(CharacterForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CharacterForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CharacterForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CharacterForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CharacterForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> availableWeaponsList;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnAddWeapon;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnOpenFile;
    private javax.swing.JButton btnPrevious;
    private javax.swing.JButton btnSaveAsNew;
    private javax.swing.JComboBox<String> cbxDirection;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton7;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lblImage;
    private javax.swing.JTextField txtCost;
    private javax.swing.JTextField txtFieldsInArmy;
    private javax.swing.JTextField txtHitsPerTime;
    private javax.swing.JTextField txtInitialLevel;
    private javax.swing.JTextField txtLevel;
    private javax.swing.JTextField txtLevelRequired;
    private javax.swing.JTextField txtLife;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPath;
    private javax.swing.JList<String> weaponList;
    // End of variables declaration//GEN-END:variables
}
