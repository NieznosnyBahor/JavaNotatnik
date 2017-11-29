package javanotatnik;

import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

public class MainFrame extends javax.swing.JFrame {

    public MainFrame() {
        initComponents();
        ustawNaStart();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrollPane = new javax.swing.JScrollPane();
        textPane = new javax.swing.JTextPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        MI_New = new javax.swing.JMenuItem();
        MI_Open = new javax.swing.JMenuItem();
        MI_SaveAs = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        MI_Exit = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        MI_FontPlus = new javax.swing.JMenuItem();
        MI_FontMinus = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MyNotes");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setLocation(new java.awt.Point(200, 250));

        scrollPane.setViewportView(textPane);

        jMenu1.setText("File");

        MI_New.setText("New");
        MI_New.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MI_NewActionPerformed(evt);
            }
        });
        jMenu1.add(MI_New);

        MI_Open.setText("Open");
        MI_Open.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MI_OpenActionPerformed(evt);
            }
        });
        jMenu1.add(MI_Open);

        MI_SaveAs.setText("Save as");
        MI_SaveAs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MI_SaveAsActionPerformed(evt);
            }
        });
        jMenu1.add(MI_SaveAs);
        jMenu1.add(jSeparator1);

        MI_Exit.setText("Exit");
        MI_Exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MI_ExitActionPerformed(evt);
            }
        });
        jMenu1.add(MI_Exit);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");

        jMenuItem1.setText("Add date");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        MI_FontPlus.setText("Font +");
        MI_FontPlus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MI_FontPlusActionPerformed(evt);
            }
        });
        jMenu2.add(MI_FontPlus);

        MI_FontMinus.setText("Font -");
        MI_FontMinus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MI_FontMinusActionPerformed(evt);
            }
        });
        jMenu2.add(MI_FontMinus);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Settings");
        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void MI_ExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MI_ExitActionPerformed
        int confirm = JOptionPane.showOptionDialog(null, "Are u sure?", null, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
        if (confirm != 1) {
            System.exit(0);
        }
    }//GEN-LAST:event_MI_ExitActionPerformed

    private void MI_NewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MI_NewActionPerformed
        //todo
        textPane.setText("");
    }//GEN-LAST:event_MI_NewActionPerformed

    private void MI_OpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MI_OpenActionPerformed
        JFileChooser fc = new JFileChooser();
        if (fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            File plik = fc.getSelectedFile();
            try {
                Scanner sc = new Scanner(plik);
                while (sc.hasNext()) {
                    textPane.getStyledDocument().insertString(0, sc.nextLine(), null);
                    textPane.getStyledDocument().insertString(0, "\n", null);

//                    jTextArea1.append(sc.nextLine());
//                    jTextArea1.append("\n");
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            } catch (BadLocationException ex) {
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            fc.setEnabled(false);
        }
        fc = null;

    }//GEN-LAST:event_MI_OpenActionPerformed

    private void MI_SaveAsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MI_SaveAsActionPerformed
        JFileChooser fc = new JFileChooser();
        if (fc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {

            File plik = fc.getSelectedFile();
            try {
                PrintWriter zapis = new PrintWriter(plik);
                Scanner sc = new Scanner(textPane.getText());
                while (sc.hasNextLine()) {
                    zapis.println(sc.nextLine() + "\n");
                }
                zapis.close();

            } catch (FileNotFoundException ex) {
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_MI_SaveAsActionPerformed

    private void MI_FontPlusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MI_FontPlusActionPerformed
        StyledDocument doc = textPane.getStyledDocument();
        SimpleAttributeSet keyWord = new SimpleAttributeSet();
        StyleConstants.setFontSize(keyWord, StyleConstants.getFontSize(keyWord)+1);
//        StyleConstants.setForeground(keyWord, Color.RED);
//        StyleConstants.setBackground(keyWord, Color.YELLOW);
//        StyleConstants.setBold(keyWord, true);

        try {
            //doc.insertString(0, "Start of text\n", null);
            String text = textPane.getText();
            textPane.setText("");
            doc.insertString(doc.getLength(), text, keyWord);
        } catch (Exception e) {
            System.out.println(e);
        }

//        Font font = jTextArea1.getFont();
//        Font font_new = new Font(font.getName(), Font.PLAIN, font.getSize()+1);
////        System.out.println(font.getFontName());
////        System.out.println(font.getSize());
//        jTextArea1.setFont(font_new);
//        

    }//GEN-LAST:event_MI_FontPlusActionPerformed

    private void MI_FontMinusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MI_FontMinusActionPerformed
        StyledDocument doc = textPane.getStyledDocument();
        SimpleAttributeSet keyWord = new SimpleAttributeSet();
        StyleConstants.setFontSize(keyWord, StyleConstants.getFontSize(keyWord)-1);
//        StyleConstants.setForeground(keyWord, Color.RED);
//        StyleConstants.setBackground(keyWord, Color.YELLOW);
//        StyleConstants.setBold(keyWord, true);

        try {
            //doc.insertString(0, "Start of text\n", null);
            String text = textPane.getText();
            textPane.setText("");
            doc.insertString(doc.getLength(), text, keyWord);
        } catch (Exception e) {
            System.out.println(e);
        }
        
        
//        Font font = jTextArea1.getFont();
//        Font font_new = new Font(font.getName(), Font.PLAIN, font.getSize()-1);
////        System.out.println(font.getFontName());
////        System.out.println(font.getSize());
//        jTextArea1.setFont(font_new);
//        
    }//GEN-LAST:event_MI_FontMinusActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        try {
            textPane.getStyledDocument().insertString(0, new Date().toString(), null);
        } catch (BadLocationException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem MI_Exit;
    private javax.swing.JMenuItem MI_FontMinus;
    private javax.swing.JMenuItem MI_FontPlus;
    private javax.swing.JMenuItem MI_New;
    private javax.swing.JMenuItem MI_Open;
    private javax.swing.JMenuItem MI_SaveAs;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JTextPane textPane;
    // End of variables declaration//GEN-END:variables

    private void ustawNaStart() {
//        jTextArea1.setWrapStyleWord(true);
    }

    private void konsola(String s) {
        System.out.println(s);
    }
}
