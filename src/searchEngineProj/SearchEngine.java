/** @author Flavio Aquino, Sharon Tender, Frank Castillo,
 * Vinny Macri February 2017
 */

package searchEngineProj;

import javax.swing.JFrame;

public class SearchEngine extends JFrame {
	public static void main ( String[] args ) {
		FileMgmt.load();
		UserForm testGui = new UserForm();
	}
}