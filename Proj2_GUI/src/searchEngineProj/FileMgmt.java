package searchEngineProj;

import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Date;
import javax.swing.UIManager;

public class FileMgmt {    
    // default constructor
    public FileMgmt() throws IOException {         
    }
    
    private final static String FILE = "../NewFile.txt";
    private static List<FileMgmt> filePathCollection = new ArrayList<FileMgmt>();   // create ArrayList to hold each file path selected from JFileChooser
    private String path;
    Date dateObject;
    
    public void File ( String path, Date date ) {
        dateObject = new Date();
        this.path = path;
    }
    	///////  FILE MAINTENANCE METHODS  ///////  
	
    // Add sourceFile to the targetIndexFiles
    public void addFileToIndex()  throws IOException {  
        
        // set look and feel to match native system UI
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            System.out.println("I guess you're stuck with Java's default look and feel");
        }
                            
        JFileChooser fileChooser = new JFileChooser();
        if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {

            //get selected file, store path in a string
            File file = fileChooser.getSelectedFile();
            Scanner selectedFile = new Scanner(file);
            String selectedFilePath = file.getCanonicalPath();
            //filePathCollection.add(file);                   
            
            // create a file wrapper for new text file, create a PrintWriter Object for output
            File output = new File("NewlyCreatedFile.txt");
            PrintWriter createdFile = new PrintWriter(output);
            System.out.println(output.getAbsoluteFile());
            
//            Date dateObject = new Date();            
//            filePathCollection.add( new File(filePath, dateObject) );   // suppose to add path to a List collection (working off of Person.java)
//          

            displayFiles(selectedFilePath);            // display all the files to console (goal is to have the files displayed in maintGUI            
            
            
            // save the text in selectedFile line by line to createdFile
            while (selectedFile.hasNext() ) {
                String line = selectedFile.nextLine();
                createdFile.append(line);                     // this writes to file, but not line by line.
                System.out.println(line);                
            }
            selectedFile.close();
            createdFile.close();
        }
        else {
            JOptionPane.showMessageDialog(null, "No file selected.", 
                "Abort", JOptionPane.OK_OPTION); 
        }
            
//			JOptionPane.showMessageDialog(null, "Operation not yet available", 
//					"Temporaty Message", JOptionPane.OK_OPTION); 
    }
    
    // Remove a file from targetIndexFiles
    public void removeFileFromIndex() {        
    }
    
    // Read targetIndexFiles
    public void readIndexFile() {        
    }
    
    // save file in array for searching with InvertedIndex.java
    public void saveFilePathForSearching(String s) {
//        ArrayList<String> FileList = new ArrayList<String>();
//        fileList 
//        File[] fileListing = s;  // save the list of files in an array
//        fileListing.listFiles() //File[] listFiles() Returns an array of abstract pathnames denoting the files in the directory denoted by this abstract pathname.
    }
    
    // write file path to display in maintenance window
    public void displayFiles(String s) {   
        
        for (int i = 0; i < filePathCollection.size() ; i++) {
            System.out.println(filePathCollection.get(i));            
        }
        String[] filePathArray = new String[]{s};
        for (String e: filePathArray) {
            System.out.println(e);                      // temporary console output for testing
        }
//        for (Iterator<String> it = filePathCollection.iterator(); it.hasNext();) {
//            String e = it.next();
//            System.out.println(e);                      // temporary console output for testing
//        }
    }
    
    // clearing files for new search data
    // note: this will also need to clear the search results in the Search Window
    public void removeFileList() {        
    }
    
}
