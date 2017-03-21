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
    public FileMgmt() throws IOException {}   
    
    // Persistant data: Array List to hold the persistant file data 
    static final ArrayList<String> PERSISTENT_ARRAY = new ArrayList<>();
    
    // Persistant data: makes a string for saving to the new file that saves the persistant data
    public static String toString (String s, long l) {
        String line = "Path: " + s + "\t Date stamp: " + l;        
        return line;
    }
    
    // Persistant data: initialization block 
    //                  1) open file if it exists  
    //                  2) create file if it does not exists
    //                  3) saves data into displayFilepathArray List (for display in mainGUI)
    static final String PERSISTENT = "./Persistent.txt";
    static final Path PERSISTENT_PATH = Paths.get(PERSISTENT);
    static final File PERSISTENT_FILE = PERSISTENT_PATH.toFile();
    static {
        // 1 and 2) open file if it exists, create one if it does not
        try {
            if (Files.notExists(PERSISTENT_PATH))  {
                Files.createFile(PERSISTENT_PATH);
            }
        }
        catch (IOException e)  {
            System.err.println("Static Initialization Block, IOException: " + e);
        }

        // 3) saves data into displayFilepathArray List (for display in mainGUI) 
        //    this saves FROM persistant.txt TO array list          
        try ( Scanner in = new Scanner(
                           new File(PERSISTENT)))  {
            // if the file is not null, save to ArrayList
            if ( in != null) {
                while ( in.hasNext() )    {
                    String data = in.nextLine();
                    PERSISTENT_ARRAY.add( data );
                }
                in.close();
            }
            displayFiles();
        } catch (Exception e)   {
            System.err.println("Error Reading Persistant File: " + e);
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
            String displayString = toString(selectedFilePath, selectedFiledate);
            int arraySize = PERSISTENT_ARRAY.size();
            PERSISTENT_ARRAY.add(arraySize, displayString);         
            
            // Persistant data: if the ArrayList is not empty, save selected file to persistant
            //    note: "true" appends data to files, without "true" it will overwrite
            if ( PERSISTENT_ARRAY != null ) {
                try ( PrintWriter out = new PrintWriter(
                                        new BufferedWriter(
                                        new FileWriter(PERSISTENT_FILE, true)))) {
                    out.println(displayString); 
                } catch (IOException e) {
                    System.err.println("IOEXCEPTION: " + e);
                }
            }
            displayFiles();
            selectedFile.close();
        }
    }  // end of Button event "Add File"      
        
    // Remove a file from targetIndexFiles
    public static void removeFileFromIndex() {                             // Used in the following places: MaintenanceGui class, line 115
    }                                                                      // int indexOf(Object o) <-- returns an int of the file to remove
    
    // Read targetIndexFiles
    public void readIndexFile() {        
    }
    
    // save file in array for searching with InvertedIndex.java
    public void saveFilePathForSearching(String s) {
    }
   
	public static void displayFiles() {
        for (Iterator<String> it = PERSISTENT_ARRAY.iterator(); it.hasNext();) {
            String s = it.next();
            System.out.println(s);
        }        
	}
    
    // updates the index to reflect what's currently in the array
    public static void updateIndex() {
    }
    
    // clearing files for new search data
    // note: this will also need to clear the search results in the Search Window
    public void removeFileList(String s) {        
    }

} // end of FileMgmt class
