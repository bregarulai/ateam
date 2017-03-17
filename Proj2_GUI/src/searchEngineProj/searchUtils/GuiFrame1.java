package searchEngineProj.searchUtils;


//* GuiFrame1 program.
//* Creates a GUI with 2 seperate windows.  The first window acts as the drive for a 
//* search engine.  Providing various options for the search. 
//* The second window provides for maintenance or adjustments. Like adding or deleting files.
//* Written by Vinny Macri, Tampa, FL USA, Feb. 2017.
//* New Program - 2017 VL 1.0.
//*  ===============================================================================================================
//*


//package com.hcc.mywork;

import searchEngineProj.*;
	import java.awt.FlowLayout;
	import java.awt.event.*;
	import javax.swing.JButton;
	import javax.swing.JFrame;
	import javax.swing.JLabel;
	import javax.swing.JTextArea;
        import searchEngineProj.searchUtils.GuiMaint;

//	import utils.*;

	public class GuiFrame1 extends JFrame {

	     JTextArea searchTextArea;
	     JButton searchButton;
	     JLabel  headerLabel;
	     JLabel  topLineLabel;
	     JLabel  textLabel;
	     JButton maintenanceButton; 
	     
//Componants required for the GUI interface.

//JScrollPane scrollPane;
//   Builds Text areas and buttons.
	     
	     public GuiFrame1() {
	            
	            setLayout(new FlowLayout());

	            headerLabel = new JLabel("Search Engine");
	            add(headerLabel);

	            topLineLabel = new JLabel("A-Team Search Engine");
	            add(topLineLabel);

	            textLabel = new JLabel(" Search Criteria ");
	            add(textLabel);

	            searchTextArea = new JTextArea(2, 35);
	            add(searchTextArea);
	           
	            searchButton = new JButton("Search Now ");
	            add(searchButton);
	            searchButton.addActionListener(new ActionListener() {
	            public void actionPerformed( ActionEvent e) { 
	                  String text = searchTextArea.getText();
	          	}
	       }
	                );
	            
	            maintenanceButton = new JButton("Maintenance ");
	  	        add(maintenanceButton);
	  	        maintenanceButton.addActionListener(new ActionListener() {
	  	          public void actionPerformed( ActionEvent e) { 
	  	                  String text = searchTextArea.getText();    
	            }    
	       }
	        );

	}
	     // main method starts here

//Open Search window
	     
	     public static void main(String [] args) {
	            GuiFrame1 guibox = new GuiFrame1();
	            guibox.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	            guibox.setSize(500, 400);
	            guibox.setTitle("A-Team Search Engine");
	            guibox.setLocationRelativeTo( null );  // Center the screen.
	            guibox.getContentPane();
	            guibox.setVisible( true );
	            
//Open Maintenance window	          
		        GuiMaint maintbox = new GuiMaint();
		        maintbox.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		        maintbox.setSize(400, 300);
		        maintbox.setTitle("A-Team Search Engine File Maintenance");
		        maintbox.setLocationRelativeTo( null );  // Center the screen.
		        maintbox.getContentPane();
		        maintbox.setVisible( true );	            

	     }  //  end main method

	         }   //  end GuiFrame1 class



	//end program          
	        

	