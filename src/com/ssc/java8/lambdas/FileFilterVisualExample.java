/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ssc.java8.lambdas;

import java.awt.BorderLayout;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

/**
 *
 * @author Jesus_Serrato
 */
public class FileFilterVisualExample extends JFrame {
    
    private File selectedFile;
    
    public FileFilterVisualExample() {
        buildGUI();
        
        setSize(500, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Event Filter Visual Example");
    }
    
    private void buildGUI() {
        JMenuBar menuBar = new JMenuBar();
        
        JMenu fileMenu = new JMenu("File");
        fileMenu.setMnemonic('f');
        
        JMenuItem exitMenuItem = new JMenuItem("Exit");
        exitMenuItem.addActionListener((e) -> {
            System.exit(0);
        });
        
        fileMenu.add(exitMenuItem);
        
        menuBar.add(fileMenu);
        
        this.setJMenuBar(menuBar);
        
        JPanel mainPanel = new JPanel(new BorderLayout());
        
        JTextArea resultArea = new JTextArea();
        resultArea.setEditable(false);
        
        JScrollPane scrollPane = new JScrollPane(resultArea);
        
        JButton selectButton = new JButton("Select a directory");
        selectButton.addActionListener((event) -> {
            JFileChooser fileChooser = new JFileChooser("/");
            fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            
            int status = fileChooser.showOpenDialog(null);
            
            if (status == JFileChooser.APPROVE_OPTION) {
                selectedFile = fileChooser.getSelectedFile();
                
                if (selectedFile != null) {
                    resultArea.setText("");
                    
                    File[] listedFiles = selectedFile.listFiles(File::isFile);
                    Arrays.stream(listedFiles).forEach((f) -> {
                        resultArea.append(f.getName() + "\n");
                    });
                }
            }
        });
        
        mainPanel.add(scrollPane, BorderLayout.CENTER);
        mainPanel.add(selectButton, BorderLayout.SOUTH);
        
        this.add(mainPanel);
    }
    
    public static void main(String[] args) throws InterruptedException, InvocationTargetException {
        SwingUtilities.invokeAndWait(() -> {
            new FileFilterVisualExample().setVisible(true);        
        });
    }
    
}
