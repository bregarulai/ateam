/** @author Flavio Aquino, Sharon Tender, Frank Castillo,
 * Vinny Macri March 2017
 * 
 *  Class responsible for handling file I/O
 */

package searchEngineProj;

import java.util.Scanner;
import javax.swing.JFileChooser;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Date;
import javax.swing.UIManager;

public class FileMgmt {    
    // default constructor
    public FileMgmt() throws IOException {         
    }   
    
    // Persistant data: Array List to hold the persistant file data 
    private static ArrayList<String> persistantFilePathArray = new ArrayList<>();
    
    // Persistant data: makes a string for saving to the new file that saves the persistant data
    public static String toString (String s, long l) {
        String line = "Path: " + s + "\t Date stamp: " + l;        
        return line;
    }
    
    // Persistant data: initialization block 
    //                  1) open file if it exists  
    //                  2) create file if it does not exists
    //                  3) saves data into displayFilepathArray List (for display in mainGUI)
    static final String PERSISTANT = "./Persistant.txt";
    static final Path persistantFilePath = Paths.get(PERSISTANT);
    static final File PERSISTANT_FILE = persistantFilePath.toFile();
    static {
        // 1 and 2) open file if it exists, create one if it does not
        try {
            if (Files.notExists(persistantFilePath))  {
                Files.createFile(persistantFilePath);
            }
        }
        catch (IOException e)  {
            System.err.println("Static Initialization Block, IOException: " + e);
        }

        // 3) saves data into displayFilepathArray List (for display in mainGUI) 
        //    this saves FROM persistant.txt TO array list          
        try ( Scanner in = new Scanner(
                           new File(PERSISTANT)))  {
            // if the file is not null, save to ArrayList
            if ( in != null) {
                while ( in.hasNext() )    {
                    persistantFilePathArray.add( in.nextLine() );             
                }
                in.close();
            }                                                                         
        } catch (Exception e)   {
            System.err.println("Error Reading Persistant File. " + e);
        }
    }
	
    // MaintenanceGui Button event "Add File"
    // This will add a selected file to the ArrayList to be searched
    public void addFileToIndex()  throws IOException {  
        
        // set look and feel to match native system UI
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            System.out.println("I guess you're stuck with Java's default look and feel");
        }
        
        // open a window to choose a file (REQUIRES: import javax.swing.JFileChooser;)
        JFileChooser fileChooser = new JFileChooser();
        if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            
            //get selected file, store path and date in a string
            File file = fileChooser.getSelectedFile();
            Scanner selectedFile = new Scanner(file);
            String selectedFilePath = file.getCanonicalPath();
            Date dateOfFile = new Date();
            long selectedFiledate = dateOfFile.getTime();               // boolean setLastModified(long time)
            
            // Persistant data: adds file path and date to ArrayList
            persistantFilePathArray.add(persistantFilePathArray.size(), toString(selectedFilePath, selectedFiledate));         
            
            // Persistant data: if the ArrayList is not empty, save selected file to persistant
            //    note: "true" appends data to files, without "true" it will overwrite
            if ( persistantFilePathArray != null ) {
                try ( PrintWriter out = new PrintWriter(
                                        new BufferedWriter(
                                        new FileWriter(PERSISTANT_FILE, true)))) {
                    out.println(toString(selectedFilePath, selectedFiledate));           
                } catch (IOException e) {
                    System.err.println("IOEXCEPTION: " + e);
                }
            }
            selectedFile.close();
        }
    }  // end of Button event "Add File"      
        
    // Remove a file from targetIndexFiles
    public void removeFileFromIndex() {        
    }
    
    // Read targetIndexFiles
    public void readIndexFile() {        
    }
    
    // save file in array for searching with InvertedIndex.java
    public void saveFilePathForSearching(String s) {
    }
    
    // write file path to display in maintenance window
    public void displayFiles(String s) {           
    }
    
    // clearing files for new search data
    // note: this will also need to clear the search results in the Search Window
    public void removeFileList(String s) {        
    }

} // end of FileMgmt class
