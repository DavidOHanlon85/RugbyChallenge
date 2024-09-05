/**
 * 
 */
package rugbyChallenge;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * 
 */
public class RugbyChallenge {

	public static void main(String[] args) {

		String line;
		String winner;
		int homeScore;
		int awayScore;

		File file = new File("Scores-2.csv");

		try {
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);

			// Removing the column headers
			line = br.readLine();
			line = br.readLine();

			// System.out.println(line); Test value

			// First line in
			line = br.readLine();
			// System.out.println(line); Test value

			while (line != null) {

				// Converting String to Array
				String[] gameDetailsSplit = line.split(",");

				// Comparing Home and Away Score

				homeScore = Integer.parseInt(gameDetailsSplit[1]);
				awayScore = Integer.parseInt(gameDetailsSplit[3]);

				// Testing values

				// System.out.println(gameDetailsSplit[1]);
				// System.out.println(gameDetailsSplit[3]);

				if (homeScore > awayScore) {
					winner = gameDetailsSplit[0];
				} else if (homeScore < awayScore) {
					winner = gameDetailsSplit[2];
				} else {
					winner = "Draw";
				}

				System.out.print(gameDetailsSplit[0] + " " + gameDetailsSplit[1] + " : " + gameDetailsSplit[2] + " "
						+ gameDetailsSplit[3] + "\t Winner : " + winner);
				System.out.println();

				line = br.readLine();
			}

			br.close();
			fr.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
