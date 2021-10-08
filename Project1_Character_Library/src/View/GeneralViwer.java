/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.GeneralViewerController;
import Model.Weapon;
import Model.Character;
import java.util.ArrayList;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.AbstractListModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import utils.ImageChooser;

/**
 *
 * @author LDAZ
 */
public class GeneralViwer extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    
    CustomListCharacterModel characterModel = new CustomListCharacterModel();
    CustomListWeaponModel characterWeaponModel = new CustomListWeaponModel();
    CustomListWeaponModel weaponModel = new CustomListWeaponModel();
    GeneralViewerController controller;
    Character selectedCharacter;
    Weapon selectedCharacterWeapon;
    Weapon selectedWeapon;
    ImageChooser imageUtils = new ImageChooser();
    public GeneralViwer() {
        controller = GeneralViewerController.getInstance();
        initComponents();
        
        initCharacterList();
        
        initWeaponCharacterList();
        initWeaponList();
        initcharacterLevelCombo();
        initcharacterVariationCombo();
        initcharacterWeaponLevelCombo();
        initcharacterWeaponVariationCombo();
        initWeaponLevelCombo();
        initWeaponVariationCombo();
    }

    private void initCharacterList(){
    characterList.setModel(characterModel);
        characterList.addListSelectionListener(new ListSelectionListener(){
            @Override
            public void valueChanged(ListSelectionEvent arg){
                 if (!arg.getValueIsAdjusting()){
                     selectedCharacter = characterModel.getCharacter(characterList.getSelectedIndex());
                     setCharacterData();
                 }
            }
        });
        characterModel.setEntities(controller.getCharacterList());
    }
    
    private void initWeaponCharacterList(){
        characterWeaponList.setModel(characterWeaponModel);
        characterWeaponList.addListSelectionListener(new ListSelectionListener(){
            @Override
            public void valueChanged(ListSelectionEvent arg){
                if(!arg.getValueIsAdjusting()){
                    selectedCharacterWeapon = characterWeaponModel.getWeapon(characterWeaponList.getSelectedIndex());
                    setCharacterWeaponData();
                    
                }
            }
        });
    }
    
    private void initcharacterLevelCombo(){
        characterLevelCombo.removeAllItems();
        characterLevelCombo.addActionListener (new ActionListener () {
            public void actionPerformed(ActionEvent e) {
                System.out.println((String)characterLevelCombo.getSelectedItem());
                if(characterLevelCombo.getSelectedItem() != null ){
                    int index = Integer.parseInt((String)characterLevelCombo.getSelectedItem());
                    int variants = selectedCharacter.getAspect().get(index).size();
                    characterVariantCombo.removeAllItems();
                    for(int i = 0; i < variants; i++ ){
                        characterVariantCombo.addItem(i + "");
                    }
                }
        }
        });
    }
    
    private void initcharacterWeaponLevelCombo(){
        characterWeaponLevelCombo.removeAllItems();
        characterWeaponLevelCombo.addActionListener (new ActionListener () {
            public void actionPerformed(ActionEvent e) {
                if(characterWeaponLevelCombo.getSelectedItem() != null){
                    int index = Integer.parseInt((String)characterWeaponLevelCombo.getSelectedItem());
                    int variants = selectedCharacterWeapon.getAspect().get(index).size();
                    characterWeaponVariantCombo.removeAllItems();
                    System.out.println(variants);
                    for(int i = 0; i < variants; i++ ){
                        characterWeaponVariantCombo.addItem(i + "");
                    }
                }
        }
        });
    }
    
    private void initWeaponLevelCombo(){
        weaponLevelCombo.removeAllItems();
        weaponLevelCombo.addActionListener (new ActionListener () {
            public void actionPerformed(ActionEvent e) {
                if(weaponLevelCombo.getSelectedItem() != null){
                    int index = Integer.parseInt((String)weaponLevelCombo.getSelectedItem());
                    int variants = selectedWeapon.getAspect().get(index).size();
                    weaponVariantCombo.removeAllItems();
                    System.out.println(variants);
                    for(int i = 0; i < variants; i++ ){
                        weaponVariantCombo.addItem(i + "");
                    }
                }
        }
        });
    }
    
    
    
    private void initcharacterVariationCombo(){
        characterVariantCombo.removeAllItems();
        characterVariantCombo.addActionListener (new ActionListener () {
            public void actionPerformed(ActionEvent e) {
                if(characterLevelCombo.getSelectedItem() != null && characterVariantCombo.getSelectedItem() != null){
                    int index = Integer.parseInt((String)characterLevelCombo.getSelectedItem());
                    int variant = Integer.parseInt((String)characterVariantCombo.getSelectedItem());
                    String path = selectedCharacter.getAspect().get(index).get(variant);
                    ImageIcon icon = getIcon(path);
                    characterPreviw.setIcon(icon);
                }
            }
        });
    }
    
    private void initcharacterWeaponVariationCombo(){
        characterWeaponVariantCombo.removeAllItems();
        characterWeaponVariantCombo.addActionListener (new ActionListener () {
            public void actionPerformed(ActionEvent e) {
                if(characterWeaponLevelCombo.getSelectedItem() != null && characterWeaponVariantCombo.getSelectedItem() != null){
                    int index = Integer.parseInt((String)characterWeaponLevelCombo.getSelectedItem());
                    int variant = Integer.parseInt((String)characterWeaponVariantCombo.getSelectedItem());
                    String path = selectedCharacterWeapon.getAspect().get(index).get(variant);
                    ImageIcon icon = getIcon(path);
                    characterWeaponPreview.setIcon(icon);
                }
            }
        });
    }
    
    
     private void initWeaponVariationCombo(){
        weaponVariantCombo.removeAllItems();
        weaponVariantCombo.addActionListener (new ActionListener () {
            public void actionPerformed(ActionEvent e) {
                if(weaponLevelCombo.getSelectedItem() != null && weaponVariantCombo.getSelectedItem() != null){
                    int index = Integer.parseInt((String)weaponLevelCombo.getSelectedItem());
                    int variant = Integer.parseInt((String)weaponVariantCombo.getSelectedItem());
                    String path = selectedWeapon.getAspect().get(index).get(variant);
                    ImageIcon icon = getIcon(path);
                   weaponPreview.setIcon(icon);
                }
            }
        });
    }
    
    private void initWeaponList(){
        weaponList.setModel(weaponModel);
        weaponModel.setEntities(controller.getWeaponList());
         
        weaponList.addListSelectionListener(new ListSelectionListener(){
            @Override
            public void valueChanged(ListSelectionEvent arg){
                if(!arg.getValueIsAdjusting()){
                   selectedWeapon = weaponModel.getWeapon(weaponList.getSelectedIndex());
                   setWeaponData();
                }
            }
        });
    }
    
    private void setCharacterData(){
        nameLabel.setText(selectedCharacter.getName());
        levelLabel.setText("" + selectedCharacter.getLevel());
        costLabel.setText("" + selectedCharacter.getCost());
        characterLife.setText("" + selectedCharacter.getLife());
        characterHitsPerTime.setText("" + selectedCharacter.getHitsPerTime());
        characterWeaponModel.setEntities(selectedCharacter.getWeapons());
        CharacterLevelRequired.setText("" + selectedCharacter.getLevelRequired());
        setCharacterIcon(selectedCharacter, 1,0);
        Set<Integer> levels = selectedCharacter.getAspect().keySet();
        System.out.println(levels);
        characterLevelCombo.removeAllItems();
        levels.forEach(level -> {
                characterLevelCombo.addItem(level + "");
            
        });
        
        characterWeaponList.updateUI();
        
    }
    
    private void setCharacterWeaponData(){
        characterWeaponName.setText(selectedCharacterWeapon.getName());
        characterWeaponLevel.setText("" + selectedCharacterWeapon.getLevel());
        characterWeaponCost.setText("" + selectedCharacterWeapon.getCost());
        characterWeaponScope.setText("" + selectedCharacterWeapon.getScope());
        characterWeaponDamage.setText("" + selectedCharacterWeapon.getDamage());
        characterWeaponExplotionRange.setText("" + selectedCharacterWeapon.getExplotionRange());
        //characterWeaponLevelIncrease.setText("" + selectedCharacterWeapon.ge);
        if(selectedCharacterWeapon.getAspect().keySet() != null){
            Set<Integer> levels = selectedCharacterWeapon.getAspect().keySet();
            for (int level : levels){
                characterWeaponLevelCombo.addItem(level + "");
            }
            setCharacterWeaponIcon(selectedCharacterWeapon, 1,0);
        }
    }
    
    private void setWeaponData(){
        
        weaponName.setText(selectedWeapon.getName());
        weaponLevel.setText("" + selectedWeapon.getLevel());
        weaponCost.setText("" + selectedWeapon.getCost());
        weaponScope.setText("" + selectedWeapon.getScope());
        weaponDamage.setText("" + selectedWeapon.getDamage());
        weaponExplotionRange.setText("" + selectedWeapon.getExplotionRange());
        //setWeaponIcon(selectedWeapon,1,0);
        //characterWeaponLevelIncrease.setText("" + selectedWeapon.ge);
         if(selectedWeapon.getAspect().keySet() != null){
            Set<Integer> levels = selectedWeapon.getAspect().keySet();
            for (int level : levels){
                weaponLevelCombo.addItem(level + "");
            }
            setCharacterWeaponIcon(selectedWeapon, 1,0);
        }
    }
    private ImageIcon getIcon(String path){
        try {
            if(new File(path).exists()){
                Image image = ImageIO.read(new File(path));
                ImageIcon icon = new ImageIcon();
                icon.setImage(image.getScaledInstance(144, 144,  java.awt.Image.SCALE_SMOOTH));
                return icon;
            }
        } catch (IOException ex) {
            Logger.getLogger(GeneralViwer.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        return null;
    }
    
    private void setCharacterIcon(Character character, int level, int variation){
        Set<Integer> keySet = character.getAspect().keySet();
        if(!keySet.contains(level)){
            characterPreviw.setText("Nivel no encontrado");
            return;
        }
        String path = characterModel.getCharacter(characterList.
                getSelectedIndex())
                .getAspect().get(level).get(variation);
        characterPreviw.setIcon(getIcon(path));
    }
    
    
    private void setCharacterWeaponIcon(Weapon weapon, int level, int variation){
        System.out.println("Icon");
        Set<Integer> keySet = weapon.getAspect().keySet();
        if(!keySet.contains(level)){
            characterWeaponPreview.setText("Nivel no encontrado");
            return;
        }
        String path = weapon.getAspect().get(level).get(variation);
        characterWeaponPreview.setIcon(getIcon(path));
    }
    
    
    private void setWeaponIcon(Weapon weapon, int level, int variation){
        System.out.println("Icon");
        Set<Integer> keySet = weapon.getAspect().keySet();
        if(!keySet.contains(level)){
            weaponPreview.setText("Nivel no encontrado");
            return;
        }
        String path = weapon.getAspect().get(level).get(variation);
        weaponPreview.setIcon(getIcon(path));
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        characterList = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        characterPreviw = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        characterWeaponList = new javax.swing.JList<>();
        jLabel2 = new javax.swing.JLabel();
        characterWeaponPreview = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        levelLabel = new javax.swing.JLabel();
        costLabel = new javax.swing.JLabel();
        characterWeaponName = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        characterWeaponLevel = new javax.swing.JLabel();
        characterWeaponCost = new javax.swing.JLabel();
        characterWeaponScope = new javax.swing.JLabel();
        characterWeaponDamage = new javax.swing.JLabel();
        characterWeaponRange = new javax.swing.JLabel();
        characterWeaponLevelIncrease = new javax.swing.JLabel();
        characterWeaponExplotionRange = new javax.swing.JLabel();
        characterLife = new javax.swing.JLabel();
        characterHitsPerTime = new javax.swing.JLabel();
        CharacterLevelRequired = new javax.swing.JLabel();
        characterLevelCombo = new javax.swing.JComboBox<>();
        characterVariantCombo = new javax.swing.JComboBox<>();
        characterWeaponLevelCombo = new javax.swing.JComboBox<>();
        characterWeaponVariantCombo = new javax.swing.JComboBox<>();
        jButton2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        weaponPreview = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        weaponList = new javax.swing.JList<>();
        jLabel14 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        weaponName = new javax.swing.JLabel();
        weaponLevel = new javax.swing.JLabel();
        weaponCost = new javax.swing.JLabel();
        weaponScope = new javax.swing.JLabel();
        weaponDamage = new javax.swing.JLabel();
        weaponExplotionRange = new javax.swing.JLabel();
        weaponLevelIncrese = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        weaponLevelCombo = new javax.swing.JComboBox<>();
        weaponVariantCombo = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        characterList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(characterList);

        jLabel1.setText("Character");

        characterPreviw.setText("Icono");

        characterWeaponList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(characterWeaponList);

        jLabel2.setText("Character weapons");

        characterWeaponPreview.setText("Weapon icon");

        jLabel3.setText("Life");

        jLabel4.setText("Hits per Time");

        jLabel5.setText("Level Required");

        jLabel6.setText("Damage");

        jLabel7.setText("Scope");

        jLabel8.setText("Explotion Range");

        jLabel9.setText("Level Increase");

        jButton1.setText("New Character");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel15.setText("Name");

        jLabel16.setText("Level");

        jLabel17.setText("Cost");

        nameLabel.setText(" ");

        levelLabel.setText(" ");

        costLabel.setText(" ");

        characterWeaponName.setText(" ");

        jLabel19.setText("Name");

        jLabel20.setText("Level");

        jLabel21.setText("Cost");

        characterWeaponLevel.setText(" ");

        characterWeaponCost.setText(" ");

        characterWeaponScope.setText(" ");

        characterWeaponDamage.setText(" ");

        characterLife.setText(" ");

        characterHitsPerTime.setText(" ");

        CharacterLevelRequired.setText(" ");

        characterLevelCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        characterVariantCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        characterWeaponLevelCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        characterWeaponVariantCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButton2.setText("Edit");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel17)
                            .addComponent(jLabel16)
                            .addComponent(jLabel15))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(nameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
                                    .addComponent(levelLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(costLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(characterLife, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(characterHitsPerTime, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(CharacterLevelRequired, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addComponent(characterPreviw, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 108, Short.MAX_VALUE)
                                .addComponent(characterLevelCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(characterVariantCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addComponent(jLabel1))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addComponent(jButton1)
                                .addGap(27, 27, 27)
                                .addComponent(jButton2)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(characterWeaponLevelIncrease, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                            .addComponent(characterWeaponExplotionRange, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(characterWeaponRange, javax.swing.GroupLayout.DEFAULT_SIZE, 5, Short.MAX_VALUE)
                        .addGap(39, 39, 39)
                        .addComponent(characterWeaponPreview, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel19)
                            .addComponent(jLabel20)
                            .addComponent(jLabel21)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(characterWeaponName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(characterWeaponLevel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(characterWeaponCost, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(characterWeaponScope, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(characterWeaponDamage, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(characterWeaponLevelCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(characterWeaponVariantCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel20)
                                    .addComponent(characterWeaponLevel))
                                .addGap(44, 44, 44)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel21)
                                    .addComponent(characterWeaponCost)))
                            .addComponent(characterWeaponPreview, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(characterWeaponScope))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(characterWeaponDamage)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(characterWeaponLevelCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(characterWeaponVariantCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(50, 50, 50)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(characterWeaponRange)
                            .addComponent(characterWeaponExplotionRange, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(characterWeaponLevelIncrease))
                        .addGap(133, 133, 133))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel15)
                                    .addComponent(nameLabel)
                                    .addComponent(jLabel19)
                                    .addComponent(characterWeaponName))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(characterPreviw, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(28, 28, 28)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel16)
                                            .addComponent(levelLabel))
                                        .addGap(39, 39, 39)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel17)
                                            .addComponent(costLabel))
                                        .addGap(38, 38, 38)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(characterLife))))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(characterLevelCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(characterVariantCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(21, 21, 21)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(characterHitsPerTime, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(57, 57, 57)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(CharacterLevelRequired))))
                        .addGap(45, 45, 45))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jButton2))
                        .addGap(10, 10, 10))))
        );

        jTabbedPane1.addTab("Characters", jPanel1);

        weaponPreview.setText("Weapon icon");

        jLabel10.setText("Level Increase");

        jLabel11.setText("Explotion Range");

        jLabel12.setText("Damage");

        jLabel13.setText("Scope");

        weaponList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane3.setViewportView(weaponList);

        jLabel14.setText("Weapons");

        jButton4.setText("Add weapon");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel18.setText("Level");

        jLabel22.setText("Cost");

        jLabel23.setText("Name");

        weaponName.setText(" ");

        weaponLevel.setText(" ");

        weaponCost.setText(" ");

        weaponScope.setText(" ");

        weaponDamage.setText(" ");

        weaponExplotionRange.setText(" ");

        weaponLevelIncrese.setText(" ");

        jButton3.setText("Edit");

        weaponLevelCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        weaponVariantCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(47, 47, 47)
                                .addComponent(jButton4)
                                .addGap(18, 18, 18)
                                .addComponent(jButton3)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel22, javax.swing.GroupLayout.Alignment.LEADING))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel11)
                                            .addComponent(jLabel10)
                                            .addComponent(jLabel12)
                                            .addComponent(jLabel18)
                                            .addComponent(jLabel23))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(weaponName, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                                            .addComponent(weaponLevel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(weaponCost, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(weaponLevelIncrese, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(weaponExplotionRange, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(weaponDamage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(weaponScope, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)))
                                .addComponent(weaponPreview, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(547, 547, 547))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(310, 310, 310)
                        .addComponent(weaponLevelCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(weaponVariantCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(11, Short.MAX_VALUE)
                .addComponent(jLabel14)
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel23)
                            .addComponent(weaponName))
                        .addGap(39, 39, 39)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(weaponLevel))
                        .addGap(46, 46, 46)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(weaponCost)
                            .addComponent(jLabel22))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(weaponScope))
                        .addGap(43, 43, 43)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(weaponDamage)
                            .addComponent(jLabel12))
                        .addGap(47, 47, 47)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(weaponExplotionRange))
                        .addGap(40, 40, 40)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(weaponLevelIncrese))
                        .addGap(38, 38, 38)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton4)
                            .addComponent(jButton3))))
                .addGap(33, 33, 33))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(weaponPreview, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(weaponLevelCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(weaponVariantCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Weapons", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        try {
            new WeaponForm().setVisible(true);
        } catch (IOException ex) {
            Logger.getLogger(GeneralViwer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new CharacterForm().setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(GeneralViwer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GeneralViwer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GeneralViwer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GeneralViwer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new GeneralViwer().setVisible(true);
            }
        });
    }
    
    public class CustomListCharacterModel extends AbstractListModel{
        private ArrayList<Character> entities;
        @Override
        public int getSize() {
            return entities.size();
        }

        @Override
        public Object getElementAt(int index) {
            Character entity = entities.get(index) ;
            return entity.getName();
        }
        
        public Character getCharacter(int index){
            return entities.get(index);
        }
        
        public void setEntities (ArrayList<Character> entities){
            this.entities = entities;
        }

    }
     
    public class CustomListWeaponModel extends AbstractListModel{
        private ArrayList<Weapon> entities = new ArrayList();
        @Override
        public int getSize() {
            return entities.size();
        }

        @Override
        public Object getElementAt(int index) {
            Weapon entity = entities.get(index) ;
            return entity.getName();
        }
        
        public Weapon getWeapon(int index){
            return entities.get(index);
        }
        
        public void setEntities (ArrayList<Weapon> entities){
            this.entities = entities;
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CharacterLevelRequired;
    private javax.swing.JLabel characterHitsPerTime;
    private javax.swing.JComboBox<String> characterLevelCombo;
    private javax.swing.JLabel characterLife;
    private javax.swing.JList<String> characterList;
    private javax.swing.JLabel characterPreviw;
    private javax.swing.JComboBox<String> characterVariantCombo;
    private javax.swing.JLabel characterWeaponCost;
    private javax.swing.JLabel characterWeaponDamage;
    private javax.swing.JLabel characterWeaponExplotionRange;
    private javax.swing.JLabel characterWeaponLevel;
    private javax.swing.JComboBox<String> characterWeaponLevelCombo;
    private javax.swing.JLabel characterWeaponLevelIncrease;
    private javax.swing.JList<String> characterWeaponList;
    private javax.swing.JLabel characterWeaponName;
    private javax.swing.JLabel characterWeaponPreview;
    private javax.swing.JLabel characterWeaponRange;
    private javax.swing.JLabel characterWeaponScope;
    private javax.swing.JComboBox<String> characterWeaponVariantCombo;
    private javax.swing.JLabel costLabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel levelLabel;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JLabel weaponCost;
    private javax.swing.JLabel weaponDamage;
    private javax.swing.JLabel weaponExplotionRange;
    private javax.swing.JLabel weaponLevel;
    private javax.swing.JComboBox<String> weaponLevelCombo;
    private javax.swing.JLabel weaponLevelIncrese;
    private javax.swing.JList<String> weaponList;
    private javax.swing.JLabel weaponName;
    private javax.swing.JLabel weaponPreview;
    private javax.swing.JLabel weaponScope;
    private javax.swing.JComboBox<String> weaponVariantCombo;
    // End of variables declaration//GEN-END:variables
}
