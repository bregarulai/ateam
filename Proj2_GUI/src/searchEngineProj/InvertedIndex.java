/** @author Flavio Aquino, Sharon Tender, Frank Castillo,
 * Vinny Macri February 2017
 */

package searchEngineProj;

import searchEngineProj.searchUtils.*;
import java.io.*;
import java.io.IOException;
import java.lang.*;

public class InvertedIndex  {
    
    // variables: s will change as we work on the methods
    String s;
    
    // create constructor
    public void InvertedIndex() {    
    }  
	
	///////  SEARCH METHODS  ///////
	// Search AND
	public String andIndexSearch() {
		return s;
	}
	
	// Search OR
	public String orIndexSearch() {
		return s;
	}
	
	// Search PHRASE
	public String phraseIndexSearch() {
		return s;
	}
    
    // method for displaying search results in SEARCH window
	public String displayData() {
        String s = "";
		return s;
	}
	
    // close file 
    public void closeFile(){
        
    }
}
