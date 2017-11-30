/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ssc.java8.lambdas;

import java.io.File;
import java.util.Arrays;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 * FileFilter example by using method reference instead of anonymous class
 * 
 * @author Jesus_Serrato
 */
public class FileFilterExample {
    
    private final JFileChooser jFileChooser;
    
    public FileFilterExample() {
        jFileChooser = new JFileChooser("/");
        jFileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        int status = jFileChooser.showOpenDialog(null);
        File selectedFile = null;
        
        if (status == JFileChooser.APPROVE_OPTION) {
            selectedFile = jFileChooser.getSelectedFile();
        }
        
        String extension = JOptionPane.showInputDialog(null, "Provide file extesion, please");
        
        File[] subdirectories = listFiles(selectedFile);
        printFiles(subdirectories);  
        
        String[] fileNamesWithExtension = list(selectedFile, extension);
        print(fileNamesWithExtension);
        
        File[] files = selectedFile.listFiles();
        files = sort(files);
    }
    
    public static void printFiles(File[] files) {
        Arrays.stream(files).forEach(System.out::println);
    }
    
    public static void print(String[] names) {
        Arrays.stream(names).forEach(System.out::println);
    }
    
    public String[] list(File selectedFile, final String extension) {
        return selectedFile.list((file, name) -> {
            return name.endsWith("." + extension);
        });
    }
    
    public File[] listFiles(File selectedFile) {  
        return (selectedFile != null) ? 
                selectedFile.listFiles(File::isDirectory) : 
                null;
    } 

    public File[] sort(File[] files) {
        Arrays.sort(files, (File f1, File f2) -> {                                            
            if (f1.isDirectory() && f2.isFile())
                return -1;
            
            if (f1.isDirectory() && f2.isDirectory())
                return 0;  
            
            if (f1.isFile() && f2.isFile())
                return 0;
            
            return 1;                                           
        });
        
        Arrays.sort(files, (File f1, File f2) -> {
            if (f1.isFile() && f2.isFile())
                return String.CASE_INSENSITIVE_ORDER.compare(f1.getName(), f2.getName());
            
            if (f1.isDirectory() && f2.isDirectory())
                return String.CASE_INSENSITIVE_ORDER.compare(f1.getName(), f2.getName());
            
            return 0;
        });

        return files;
    }
    
    public static void main(String[] args) {
        new FileFilterExample();
    }
    
}
