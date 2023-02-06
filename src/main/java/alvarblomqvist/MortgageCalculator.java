package alvarblomqvist;

import java.util.ArrayList;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;

// Class for calculating given mortgage
public class MortgageCalculator {

    // Reads any given file containing prospects and returns them in an arraylist
    public ArrayList<String> readProspects(String path) {
        ArrayList<String> prospectsList = new ArrayList<>();

        try {
            File prospectsData = new File(path);
            FileReader fileReader = new FileReader(prospectsData);
            BufferedReader prospectsReader = new BufferedReader(fileReader);

            String currentLine;   // variable updating through each line that has gone through the reader

            while ((currentLine = prospectsReader.readLine()) != null) {    // loop through & add current line to arraylist
                prospectsList.add(currentLine);
            }

        } catch(Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return prospectsList;
    }
}