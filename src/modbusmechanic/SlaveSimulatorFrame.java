/*
 * Copyright 2019 Matt Jamesson <scifidryer@gmail.com>.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package modbusmechanic;

import javax.swing.JOptionPane;

/**
 *
 * @author Matt Jamesson <scifidryer@gmail.com>
 */
public class SlaveSimulatorFrame extends javax.swing.JFrame {

    /**
     * Creates new form SlaveSimulatorFrame
     */
    public SlaveSimulatorFrame(int nodeId) {
        initComponents();
        nodeIdLabel.setText("Slave simulator running at address " + nodeId);
        
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
        jPanel4 = new javax.swing.JPanel();
        nodeIdLabel = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        registerTypeSelector = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        registerNumberField = new javax.swing.JTextField();
        inputPane = new javax.swing.JPanel();
        coilPane = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        onButton = new javax.swing.JRadioButton();
        hrPane = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        dataTypeSelector = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        registerValueField = new javax.swing.JTextField();
        wordSwapCheckbox = new javax.swing.JCheckBox();
        byteSwapCheckbox = new javax.swing.JCheckBox();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.Y_AXIS));

        nodeIdLabel.setText("Slave simulator running at node address 1");
        jPanel4.add(nodeIdLabel);

        getContentPane().add(jPanel4);

        jLabel3.setText("Register type");
        jPanel1.add(jLabel3);

        registerTypeSelector.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Coils", "Discrete", "Input", "Holding" }));
        registerTypeSelector.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerTypeSelectorActionPerformed(evt);
            }
        });
        jPanel1.add(registerTypeSelector);

        jLabel1.setText("Register number");
        jPanel1.add(jLabel1);

        registerNumberField.setColumns(4);
        jPanel1.add(registerNumberField);

        inputPane.setLayout(new java.awt.CardLayout());

        jLabel6.setText("Input status");
        coilPane.add(jLabel6);

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setSelected(true);
        jRadioButton1.setText("Off");
        coilPane.add(jRadioButton1);

        buttonGroup1.add(onButton);
        onButton.setText("On");
        coilPane.add(onButton);

        inputPane.add(coilPane, "card3");

        jLabel2.setText("Data type");
        hrPane.add(jLabel2);

        dataTypeSelector.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Float", "U Int 16", "U Int 32" }));
        hrPane.add(dataTypeSelector);

        jLabel4.setText("Value");
        hrPane.add(jLabel4);

        registerValueField.setColumns(5);
        hrPane.add(registerValueField);

        wordSwapCheckbox.setText("Word Swap");
        wordSwapCheckbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wordSwapCheckboxActionPerformed(evt);
            }
        });
        hrPane.add(wordSwapCheckbox);

        byteSwapCheckbox.setText("Byte Swap");
        hrPane.add(byteSwapCheckbox);

        inputPane.add(hrPane, "card2");

        jPanel1.add(inputPane);

        getContentPane().add(jPanel1);

        jButton1.setText("Add");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1);

        getContentPane().add(jPanel2);

        jPanel3.setLayout(new javax.swing.BoxLayout(jPanel3, javax.swing.BoxLayout.LINE_AXIS));

        jLabel5.setText("Current registers");
        jPanel3.add(jLabel5);

        getContentPane().add(jPanel3);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        ModbusMechanic.stopSlaveSimulator();
    }//GEN-LAST:event_formWindowClosing

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try
        {
            int registerNumber = Integer.parseInt(registerNumberField.getText());
            int functionCode = 0;
            int dataType = 0;
            boolean error = false;
            javax.swing.JLabel functionLabel = null;
            javax.swing.JLabel typeLabel = null;
            javax.swing.JLabel valueLabel = new javax.swing.JLabel("Value: " + registerValueField.getText());
            byte[] buf = null;
            
            if (registerTypeSelector.getSelectedItem().equals("Coils"))
            {
                functionLabel = new javax.swing.JLabel("Coil " + registerNumber);
                
                functionCode = 1;
            }
            if (registerTypeSelector.getSelectedItem().equals("Discrete"))
            {
                functionLabel = new javax.swing.JLabel("Discrete " + registerNumber);
                functionCode = 2;
            }
            if (registerTypeSelector.getSelectedItem().equals("Holding"))
            {
                functionLabel = new javax.swing.JLabel("Holding Register " + registerNumber);
                functionCode = 3;
            }
            if (registerTypeSelector.getSelectedItem().equals("Input"))
            {
                functionLabel = new javax.swing.JLabel("Input Register " + registerNumber);
                functionCode = 4;
            }
            if (functionCode == 1 || functionCode == 2)
            {
                typeLabel = new javax.swing.JLabel("Type: Bit");
                String boolValue = "false";
                if (onButton.isSelected())
                {
                    boolValue = "true";
                }
                valueLabel = new javax.swing.JLabel("Value: " + boolValue);
                ModbusMechanic.setSimulatorCoilValue(functionCode, registerNumber, onButton.isSelected());
            }
            if (functionCode == 3 || functionCode == 4)
            {
                if (dataTypeSelector.getSelectedItem().equals("Float"))
                {
                    typeLabel = new javax.swing.JLabel("Type: Float");
                    float floatValue = Float.parseFloat(registerValueField.getText());
                    buf = java.nio.ByteBuffer.allocate(4).putFloat(floatValue).array();
                    buf = ModbusMechanic.wordSwap(buf);
                }
                if (dataTypeSelector.getSelectedItem().equals("U Int 16"))
                {
                    typeLabel = new javax.swing.JLabel("Type: U Int 16");
                    int intValue = Integer.parseInt(registerValueField.getText());
                    buf = java.nio.ByteBuffer.allocate(4).putInt(intValue).array();
                    buf = java.util.Arrays.copyOfRange(buf, 2, 4);
                    if (intValue < 0 || intValue > 65535)
                    {
                        JOptionPane.showMessageDialog(this, "Please enter a value between 0 and 65535", "Value out of range", JOptionPane.ERROR_MESSAGE, null);
                        error = true;
                    }
                }
                if (dataTypeSelector.getSelectedItem().equals("U Int 32"))
                {
                    typeLabel = new javax.swing.JLabel("Type: U Int 32");
                    long intValue = Long.parseLong(registerValueField.getText());
                    if (intValue < 0L || intValue > 4294967295L)
                    {
                        JOptionPane.showMessageDialog(this, "Please enter a value between 0 and 4294967295", "Value out of range", JOptionPane.ERROR_MESSAGE, null);
                        error = true;
                    }
                    buf = java.nio.ByteBuffer.allocate(8).putLong(intValue).array();
                    buf = java.util.Arrays.copyOfRange(buf, 4, 8);
                }
                if (wordSwapCheckbox.isSelected() && buf.length == 4)
                {
                    buf = ModbusMechanic.wordSwap(buf);
                }
                if (byteSwapCheckbox.isSelected())
                {
                    buf = ModbusMechanic.byteSwap(buf);
                }
                if (!error)
                {
                    ModbusMechanic.setSimulatorRegisterValue(functionCode, registerNumber, buf);   
                }
            }
            if (!error)
            {
                javax.swing.JPanel registerPanel = new javax.swing.JPanel();
                registerPanel.setLayout(new java.awt.FlowLayout());;
                registerPanel.add(functionLabel);
                registerPanel.add(typeLabel);
                registerPanel.add(valueLabel);
                javax.swing.JButton deleteButton = new javax.swing.JButton("Delete");
                final int aFunctionCode = functionCode;
                final int aRegisterNumber = registerNumber;
                
                javax.swing.JSeparator seperator = new javax.swing.JSeparator();
                deleteButton.addActionListener(new java.awt.event.ActionListener(){
                    public void actionPerformed(java.awt.event.ActionEvent e)
                    {
                        if (aFunctionCode == 1 || aFunctionCode == 2)
                        {
                            ModbusMechanic.setSimulatorCoilValue(aFunctionCode,aRegisterNumber, false);
                        }
                        if (aFunctionCode == 3 || aFunctionCode == 4)
                        {
                            ModbusMechanic.setSimulatorRegisterValue(aFunctionCode,aRegisterNumber, new byte[] {0,0,0,0});
                        }
                        java.awt.Component[] components = getContentPane().getComponents();
                        for (int i = 0; i < components.length; i++)
                        {
                            if (components[i] == registerPanel || components[i] == seperator)
                            {
                                getContentPane().remove(components[i]);
                            }
                        }
                        pack();
                    }
                });
                registerPanel.add(deleteButton);
                getContentPane().add(seperator);
                getContentPane().add(registerPanel);
                pack();
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void wordSwapCheckboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wordSwapCheckboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_wordSwapCheckboxActionPerformed

    private void registerTypeSelectorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerTypeSelectorActionPerformed
        if (registerTypeSelector.getSelectedItem().equals("Coils") || registerTypeSelector.getSelectedItem().equals("Discrete"))
        {
            hrPane.setVisible(false);
            coilPane.setVisible(true);
        }
        if (registerTypeSelector.getSelectedItem().equals("Holding") || registerTypeSelector.getSelectedItem().equals("Input"))
        {
            coilPane.setVisible(false);
            hrPane.setVisible(true);
        }
    }//GEN-LAST:event_registerTypeSelectorActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JCheckBox byteSwapCheckbox;
    private javax.swing.JPanel coilPane;
    private javax.swing.JComboBox<String> dataTypeSelector;
    private javax.swing.JPanel hrPane;
    private javax.swing.JPanel inputPane;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JLabel nodeIdLabel;
    private javax.swing.JRadioButton onButton;
    private javax.swing.JTextField registerNumberField;
    private javax.swing.JComboBox<String> registerTypeSelector;
    private javax.swing.JTextField registerValueField;
    private javax.swing.JCheckBox wordSwapCheckbox;
    // End of variables declaration//GEN-END:variables
}
