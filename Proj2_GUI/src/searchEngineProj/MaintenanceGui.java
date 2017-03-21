/** @author Flavio Aquino, Sharon Tender, Frank Castillo,
 * Vinny Macri February 2017
 * 
 *  Class responsible for creating the  Administrator
 *  GUI.
 */

package searchEngineProj;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.List;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;


public class MaintenanceGui {
	JLabel title, numberOfFiles, filePath;     // filePath added to display files being searched
	JButton addFile, updateFile, removeFile;
	public JTable table;                       // public for other classes to acces it?
	public List fileList;
	public JFrame myFrame;
	
	public MaintenanceGui() {
		Font titleFont = new Font("Serif", Font.BOLD, 46);
		Font regularFont = new Font("Serif", Font.PLAIN, 26);
		
		// to create the window frame
		JFrame myFrame = new JFrame();
		myFrame.setTitle("My Search Engine Maintenance");
		myFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		myFrame.getContentPane().setLayout(new BorderLayout());
		myFrame.setMinimumSize(new Dimension(950, 650));
		myFrame.setVisible(true);
		
		// to create a container to place the north panel into for Heading
		Container contentPane = myFrame.getContentPane();
		JPanel northPanel = new JPanel();
		northPanel.setBackground(Color.BLUE);
		northPanel.setLayout(new BorderLayout());
		northPanel.setPreferredSize(new Dimension(850, 100));
		northPanel.setBorder(new EmptyBorder(0, 0, 0, 20));
		contentPane.add(northPanel, BorderLayout.NORTH);
		
		// to create and add title label to north panel
		title = new JLabel("My Search Engine - Maintenance");
		title.setFont(titleFont);
		title.setHorizontalAlignment(JLabel.CENTER);
		northPanel.add(title, BorderLayout.CENTER);
		        
        /* panel for the search file names and status
		List centerPanel = new List();
		centerPanel.setBackground(Color.WHITE);
		centerPanel.setPreferredSize(new Dimension(850, 400));
		centerPanel.add("This is item 1");
		centerPanel.add("This is item 2");
		//centerPanel.setLayout(new BorderLayout());        

        // filePath = new JLabel("getfilepaths(string) goes here");
         * // For testing: lable to display the path of the file for searching JTextArea, JTable, JList
        //filePath = "filepath goes here";
        
		TableModel myTableModel = new TableModel();
		JTable table = new JTable(myTableModel);
		table.getTableHeader().setFont(regularFont);
		table.setFillsViewportHeight(true);
		
		centerPanel.add(table, BorderLayout.CENTER);
		centerPanel.add(table.getTableHeader(), BorderLayout.NORTH);
		contentPane.add(centerPanel, BorderLayout.CENTER);
        centerPanel.add(filePath, BorderLayout.WEST);       // WEST was the best way to get it to show up
		 */
		
		
		
		// to create the south panel
		JPanel southPanel = new JPanel();
		southPanel.setBackground(Color.BLUE);
		southPanel.setLayout(new FlowLayout());
		((FlowLayout)southPanel.getLayout()).setHgap(70);
		((FlowLayout)southPanel.getLayout()).setVgap(30);
		southPanel.setPreferredSize(new Dimension(850, 150));
		contentPane.add(southPanel, BorderLayout.SOUTH);
		
		// to create buttons and add them to south panel
		addFile = new JButton("Add File");
		addFile.setFont(regularFont);
		southPanel.add(addFile);
		
        // button event adds a file to Search Engine
		addFile.addActionListener(actionEvent -> {  
            try {
                FileMgmt addSearchFile = new FileMgmt();
                addSearchFile.addFileToIndex();
            } catch (IndexOutOfBoundsException e) {
                System.err.println("IndexOutOfBoundsException: " + e.getMessage());
            } catch (IOException e) {
                System.err.println("Caught IOException: " + e.getMessage());
            }
		});
		
		updateFile = new JButton("Update Index File");
		updateFile.setFont(regularFont);
		southPanel.add(updateFile);
		
		updateFile.addActionListener(actionEvent -> {
            // call the displayFile method from FileMgmt Class
			FileMgmt.displayFiles();

            // need to delete this when we have the method working            
			JOptionPane.showMessageDialog(null, "Operation not yet available",
					"Temporary Message", JOptionPane.OK_OPTION);
		});
		
		removeFile = new JButton("Remove Selected File");
		removeFile.setFont(regularFont);
		southPanel.add(removeFile);
		
		removeFile.addActionListener(actionEvent -> {
            // call the remove file method from FileMgmt class
            FileMgmt.removeFileFromIndex();
            
            // need to delete this when we have the method working
			JOptionPane.showMessageDialog(null, "Operation not yet available",
					"Temporary Message", JOptionPane.OK_OPTION);
		});
		
		// nested panel to put the number of file
		// label in a different line
		JPanel southPanel2 = new JPanel();
		southPanel2.setLayout(new FlowLayout());
		((FlowLayout)southPanel2.getLayout()).setVgap(5);
		southPanel2.setBackground(Color.BLUE);
		southPanel2.setPreferredSize(new Dimension(850, 100));
		numberOfFiles = new JLabel("This is dummy data for now");
		numberOfFiles.setFont(regularFont);
		southPanel2.add(numberOfFiles);
		southPanel.add(southPanel2);
		
		fileList = new List();
		myFrame.getContentPane().add(fileList, BorderLayout.CENTER);
		myFrame.pack();
		for (String listVal : FileMgmt.PERSISTENT_ARRAY) {
			fileList.add(listVal);
		}
	}
}
