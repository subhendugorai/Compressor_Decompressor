/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import comp_decomp.Compressor;
import comp_decomp.Decompressor;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author SUBHENDU
 */
public class AppFrame extends JFrame implements ActionListener {
    JButton compressButton;
    JButton deCompressButton;
    AppFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        compressButton = new JButton("Compress Me");
        compressButton.addActionListener(this);
        deCompressButton = new JButton("Decompress Me");
        deCompressButton.addActionListener(this);
        compressButton.setBounds(20, 100, 200, 30);
        deCompressButton.setBounds(250, 100, 200, 30);
        this.add(compressButton);
        this.add(deCompressButton);
        this.getContentPane().setBackground(Color.black);
        this.setSize(500    , 500);
        this.setLayout(null);
        this.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
         if(e.getSource()==compressButton){
             JFileChooser fileChooser=new JFileChooser();
             int response=fileChooser.showSaveDialog(null);
             if(response==fileChooser.APPROVE_OPTION){
                 File file=new File(fileChooser.getSelectedFile().getAbsolutePath());
                 System.out.print(file);
                 try{
                     Compressor.runCompression(file);
                 }catch(IOException ee){
                     JOptionPane.showMessageDialog(null,ee.toString());
                 }
            }
        }
         if(e.getSource()==deCompressButton){
             JFileChooser fileChooser=new JFileChooser();
             int response=fileChooser.showSaveDialog(null);
             if(response==fileChooser.APPROVE_OPTION){
                 File file=new File(fileChooser.getSelectedFile().getAbsolutePath());
                 System.out.println(file);
                 try{
                     Decompressor.runDecompressor(file);
                 }catch(IOException ee){
                     JOptionPane.showMessageDialog(null,ee.toString());
                 }
             }
         }
    }
}
