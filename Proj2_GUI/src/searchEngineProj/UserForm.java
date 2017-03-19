/** @author Flavio Aquino, Sharon Tender, Frank Castillo,
 * Vinny Macri February 2017
 * 
 *  Class responsible for creating the user Gui
 */

package searchEngineProj;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import searchEngineProj.FileMgmt.*;

public class UserForm extends JFrame  {
	
	JLabel title, searchItem, numberOfFiles, ouputTitle;
	JTextField input;
	JButton search, maintenance, about;
	JRadioButton andSearch, orSearch, exactPhrase;
	
	public UserForm() {
		Font titleFont = new Font("Serif", Font.BOLD, 46);
		Font regularFont = new Font("Serif", Font.PLAIN, 26);
		
		// to create the window frame
		JFrame myFrame = new JFrame();
		myFrame.setTitle("My Search Engine");
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myFrame.setLayout(new BorderLayout());
		myFrame.setMinimumSize(new Dimension(950, 700));
		myFrame.setVisible(true);
				
		// to create a panel for the main title
		Container contentPane = myFrame.getContentPane();
		JPanel northPanel = new JPanel();
		northPanel.setBackground(Color.BLUE);
		northPanel.setPreferredSize(new Dimension(850, 200));
		northPanel.setBorder(new EmptyBorder(0, 0, 0, 20));
		contentPane.add(northPanel, BorderLayout.NORTH);
		
		// to create and add the title to north panel
		title = new JLabel("My Search Engine");
		title.setFont(titleFont);
		title.setHorizontalAlignment(JLabel.CENTER);
		northPanel.setLayout(new BorderLayout(25, 25));
		northPanel.add(title, BorderLayout.NORTH);
		
		// to add search label
		searchItem = new JLabel("Search Term:");
		searchItem.setFont(regularFont);
		searchItem.setBorder(new EmptyBorder(15, 15, 15, 15));
		northPanel.add(searchItem, BorderLayout.WEST);
		
		// to add textField in north panel
		input = new JTextField();
		input.setFont(new Font("Serif", Font.PLAIN, 20));
		northPanel.add(input, BorderLayout.CENTER);
		
		// to add search button
		search = new JButton("Search");
		search.setFont(regularFont);
		search.setBorder(new EmptyBorder(40, 40, 40, 40));
		search.setHorizontalAlignment(JButton.CENTER);
		northPanel.add(search, BorderLayout.EAST);
		
		// to add action listener 
		search.addActionListener(actionEvent -> {
			JOptionPane.showMessageDialog(null, "Operation not yet supported", 
					"Temporary Message", JOptionPane.OK_OPTION);
		});
		
		// a panel to hold the radio buttons
		JPanel groupRadioButtons = new JPanel();
		groupRadioButtons.setPreferredSize(new Dimension(850, 50));
		groupRadioButtons.setLayout(new FlowLayout());
		groupRadioButtons.setBackground(Color.BLUE);
		
		((FlowLayout)groupRadioButtons.getLayout()).setHgap(35);
		((FlowLayout)groupRadioButtons.getLayout()).setVgap(5);		
				
		andSearch = new JRadioButton("And Search", true);
		andSearch.setFont(regularFont);
		andSearch.setBackground(Color.BLUE);
		orSearch = new JRadioButton("Or Search");
		orSearch.setFont(regularFont);
		orSearch.setBackground(Color.BLUE);
		exactPhrase = new JRadioButton("Exact Phrase Search");
		exactPhrase.setFont(regularFont);
		exactPhrase.setBackground(Color.BLUE);
		groupRadioButtons.add(andSearch);
		groupRadioButtons.add(orSearch);
		groupRadioButtons.add(exactPhrase);
		
		// so only one radio button can be selected
		// at a time
		ButtonGroup group = new ButtonGroup();
		group.add(andSearch);
		group.add(orSearch);
		group.add(exactPhrase);
		northPanel.add(groupRadioButtons, BorderLayout.SOUTH);
				
		northPanel.validate();
		
		// to create the south panel
		JPanel southPanel = new JPanel();
		southPanel.setLayout(new FlowLayout());
		southPanel.setBackground(Color.BLUE);
		southPanel.setPreferredSize(new Dimension(850, 100));
		contentPane.add(southPanel, BorderLayout.SOUTH);
		((FlowLayout)southPanel.getLayout()).setHgap(80);
		((FlowLayout)southPanel.getLayout()).setVgap(25);
		
		// to create maintenance button
		// and add them to south panel
		maintenance = new JButton("Maintenance");
		maintenance.setFont(regularFont);
		southPanel.add(maintenance);
		// to add action listener to add button
		maintenance.addActionListener(actionEvent -> {
			MaintenanceGui admin = new MaintenanceGui();
		});
		
		// to add number of files label
		numberOfFiles = new JLabel("This is dummy data for now");
		numberOfFiles.setFont(regularFont);
		southPanel.add(numberOfFiles);
		
		// to add about button to south panel
		about = new JButton("About");
		about.setFont(regularFont);
		southPanel.add(about);
		// to add action listener 
		about.addActionListener(actionEvent -> {
			JOptionPane.showMessageDialog(null, "Operation not yet supported", 
					"Temporary Message", JOptionPane.OK_OPTION);
		});
		southPanel.validate();
		myFrame.pack();
	}	
}
