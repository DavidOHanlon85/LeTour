/**
 * 
 */
package challengeLeTour;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.ResultSet;

/**
 * @author - Daithi O hAnluain - 15621049
 */
public class CutoffPrint implements Runnable {

	@Override
	public void run() {


		File file = new File("Cutoff Results");

		try {
			FileWriter fw = new FileWriter(file);
			BufferedWriter bw = new BufferedWriter(fw);
			
			bw.write("Congratulations, you've made the cut off\n\n");

			for (Rider r : StarterApp.results) {
				if (r.getTime().isBefore(StarterApp.results.get(0).getTime().plusMinutes(30))) {
					bw.write(r.getFirstName() + " " + r.getLastName() + "\n");
					bw.write(r.getTeam() + "\n");
					bw.write(r.getTime().toString() + "\n\n");
				}
			}

			bw.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
