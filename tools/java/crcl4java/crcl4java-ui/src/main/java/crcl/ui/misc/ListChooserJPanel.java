/*
 * This software is public domain software, however it is preferred
 * that the following disclaimers be attached.
 * Software Copywrite/Warranty Disclaimer
 * 
 * This software was developed at the National Institute of Standards and
 * Technology by employees of the Federal Government in the course of their
 * official duties. Pursuant to title 17 Section 105 of the United States
 * Code this software is not subject to copyright protection and is in the
 * public domain.
 *
 *  This software is experimental. NIST assumes no responsibility whatsoever for its use by other
 * parties, and makes no guarantees, expressed or implied, about its
 * quality, reliability, or any other characteristic. We would appreciate
 * acknowledgement if the software is used. This software can be
 * redistributed and/or modified freely provided that any derivative works
 * bear some notice that they are derived from it, and any modified
 * versions bear some notice that they have been modified.
 * 
 *  See http://www.copyright.gov/title17/92chap1.html#105
 * 
 */
package crcl.ui.misc;

import java.awt.Dialog;
import java.awt.Window;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JDialog;

/**
 *
 * @author Will Shackleford {@literal <william.shackleford@nist.gov>}
 * @param <TT> type of object in list to be chosen.
 */
public class ListChooserJPanel<TT> extends javax.swing.JPanel {

    /**
     * Creates new form ListChooserJPanel
     */
    @SuppressWarnings("initialization")
    private ListChooserJPanel(JDialog _dialog, TT[] choices, TT defaultChoice) {
        initComponents();
        this.dialog = _dialog;
        this.defaultChoice = defaultChoice;
        this.selectedChoice = defaultChoice;
        this.choices = choices;
        this.dialog.add(this);
        this.jComboBox1.setModel(new DefaultComboBoxModel<>(choices));
        this.jComboBox1.setSelectedItem(defaultChoice);
        this.dialog.pack();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox<>();
        jButtonCancel = new javax.swing.JButton();
        jButtonOK = new javax.swing.JButton();

        FormListener formListener = new FormListener();

        jButtonCancel.setText("Cancel");
        jButtonCancel.addActionListener(formListener);

        jButtonOK.setText("OK");
        jButtonOK.addActionListener(formListener);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 253, Short.MAX_VALUE)
                        .addComponent(jButtonOK)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonCancel)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCancel)
                    .addComponent(jButtonOK))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }

    // Code for dispatching events from components to event handlers.

    private class FormListener implements java.awt.event.ActionListener {
        FormListener() {}
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            if (evt.getSource() == jButtonCancel) {
                ListChooserJPanel.this.jButtonCancelActionPerformed(evt);
            }
            else if (evt.getSource() == jButtonOK) {
                ListChooserJPanel.this.jButtonOKActionPerformed(evt);
            }
        }
    }// </editor-fold>//GEN-END:initComponents

    @SuppressWarnings("unchecked")
    private void jButtonOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOKActionPerformed
        this.selectedChoice = (TT) this.jComboBox1.getSelectedItem();
        this.dialog.setVisible(false);
    }//GEN-LAST:event_jButtonOKActionPerformed

    private void jButtonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelActionPerformed
        this.selectedChoice = this.defaultChoice;
        this.dialog.setVisible(false);
    }//GEN-LAST:event_jButtonCancelActionPerformed

    private final JDialog dialog;
    private final TT[] choices;
    private final TT defaultChoice;
    private TT selectedChoice;
    
    public TT getSelectedChoice() {
        return selectedChoice;
    }
    
    public static <T> T choose(Window owner, String title, T[] choices, T defaultChoice ) {
        JDialog dialog = new JDialog(owner, title,Dialog.ModalityType.APPLICATION_MODAL);
        ListChooserJPanel<T> panel = new ListChooserJPanel<>(dialog,choices,defaultChoice);
        dialog.setVisible(true);
        return panel.getSelectedChoice();
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancel;
    private javax.swing.JButton jButtonOK;
    private javax.swing.JComboBox<TT> jComboBox1;
    // End of variables declaration//GEN-END:variables
    private static final Logger LOG = Logger.getLogger(ListChooserJPanel.class.getName());
}
