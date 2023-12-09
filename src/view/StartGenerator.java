package view;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**  
* Christopher Said - cwsaid  
* CIS171 <11961>
* Dec 4, 2023  
*/

public class StartGenerator {

	public static void main(String[] args) {
		
		/*	Algorithm
		 * 		-start program
		 * 		-render GUI fields and buttons
		 * 		-get book title, pages, days from user
		 * 		-validate user input
		 * 		-provide user feedback in JOptionPane
		 * 		-calculate pages per day
		 * 		-add title and pages to array 
		 * 		-format pages per day to have two decimal places
		 * 		get current date and from that assign dates to each days pages
		 * 		display date, title, pages per day in pane
		 * 		-repeat user input, calculations, and display until user prints output
		 * 		-when user finished output contents of pane to txt file to the client desktop
		 * 		-end program
		*/
		
		//	sets the dimensions of the program frame
		final int FRAME_WIDTH = 750;
		final int FRAME_HEIGHT = 500;
		
		//	creates and displays the program frame with contents
		JFrame frame = new JFrame();
		JPanel panel = new GeneratorPanel();
		
		frame.add(panel);
		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
	}

}