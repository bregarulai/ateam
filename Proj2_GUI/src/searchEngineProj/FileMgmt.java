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
    private static ArrayList<String> displayFilePathArray = new ArrayList<>();
    
    // Persistant data: makes a string for saving to the new file that saves the persistant data
    public static String toString (String s, long l) {
        String line = "Path: " + s + "\t Date stamp: " + l;        
        return line;
    }
    
    // Persistant data: initialization block 
    //                  1) open file if it exists  
    //                  2) create file if it does not exists
    //                  3) saves data into displayFilepathArray List (for display in mainGUI)
    static final String PERSISTANT = "Persistant.txt";
    static public Path persistantFilePath = Paths.get(PERSISTANT);
    static public File persistantFile = persistantFilePath.toFile();
    static {
        System.err.println("Start of static init block");
        // 1 and 2) open file if it exists, create one if it does not
        try 
        {
            if (Files.notExists(persistantFilePath))  
            {
                System.out.println("Creating new file");
                Files.createFile(persistantFilePath);
            }
        }
        catch (IOException e) 
        {
            System.err.println("Static Initialization Block, IOException: " + e);
        }

        // 3) saves data into displayFilepathArray List (for display in mainGUI) (this saves FROM persistant.txt TO array list)             
        System.err.println("Reading data file:"); 
        try ( Scanner in = new Scanner(
                           new File(PERSISTANT)))
        {
            // if the file is not null, save to ArrayList
            if ( in != null)  
            {
                while ( in.hasNext() )     
                {
                    displayFilePathArray.add( in.nextLine() );             
                }
                in.close();
            }                                                       // NEED TO DO NEXT: make sure this displays in maintenaceGUI                  
        }
        catch (Exception e)
        {
            System.err.println("Error Reading Persistant File. " + e);
        }
    }
	
    // Add sourceFile to the targetIndexFiles
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
            displayFilePathArray.add(displayFilePathArray.size(), toString(selectedFilePath, selectedFiledate));
            
            // Persistant data: if the ArrayList is not empty, save each line of data to file
            if ( persistantFilePathArray != null ) {
                for (Iterator<String> iterator = persistantFilePathArray.iterator(); iterator.hasNext();) {
                    String next = iterator.next();

                    // save data back to PERSISTANT file with file writer
                    try ( PrintWriter out = new PrintWriter(
                                            new BufferedWriter(
                                            new FileWriter(PERSISTANT, true))))        // delete ", true" (true appends files) to replace file with new array list
                    {
                        out.println(next);
                    }
                    catch (IOException e)
                    {
                        System.err.println("IOEXCEPTION: " + e);
                    }
                }
                selectedFile.close();
            }
        
        }
        /////// TESTING: Display both array lists size and data   /////////
        System.out.println("persistant array........................");
        System.out.println(persistantFilePathArray.size());
        for (Iterator<String> it = persistantFilePathArray.iterator(); it.hasNext();) {
            String persistantFilePathArray = it.next();
            System.out.println(persistantFilePathArray);
        }
        System.out.println("display array...........................");
        System.out.println(displayFilePathArray.size());
        for (Iterator<String> it = displayFilePathArray.iterator(); it.hasNext();) {
            String displayFilePathArray = it.next();
            System.out.println(displayFilePathArray);
        }
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
        
    }
    
    // clearing files for new search data
    // note: this will also need to clear the search results in the Search Window
    public void removeFileList(String s) {        
    }

} // end of FileMgmt class
