import java.util.ArrayList;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;

// Class for calculating given mortgage
public class MortgageCalculator {

    // Reads any given file containing prospects & returns them in an arraylist
    public static ArrayList<String> readProspects(String path) {

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

    // Creates objects for each mortgage & returns them in an arraylist
    public ArrayList<Mortgage> createMortgage(ArrayList<String> currentFile) {

        ArrayList<Mortgage> mortgagesList = new ArrayList<>();

        currentFile.remove(0).split(",");    // removes unnecessary commas

        for(String i : currentFile) {

            String[] elements = i.split(("(?!\".*)(,)(?!.*\")"));    // split string at non-letter characters using regex

            if(elements.length < 4) {
                continue;
            }

            // Assign current variables to instance variables in the mortgage
            String customer = cleanUp(elements[0]);
            float totalLoan = Float.parseFloat(elements[1]);
            float interest = Float.parseFloat(elements[2]);
            int years = Integer.parseInt(elements[3]);

            Mortgage mortgage = new Mortgage(customer, totalLoan, interest, years);
            mortgagesList.add(mortgage);

        }
        return mortgagesList;
    }

    // Cleans up commas in the data that interferes with the creation of mortgage objects
    public String cleanUp(String data) {
        data = data.replace(",", " ");
        return data;
    }

    public MortgageCalculator(String path) {
        ArrayList<String> prospects = readProspects(path);
        ArrayList<Mortgage> mortgages = createMortgage(prospects);

        for (Mortgage mortgage : mortgages) {
            mortgage.calculatePaymentFormula();
            System.out.println
                    ("Customer: " + mortgage.getCustomer() + "\n"
                    + "Total loan: " + mortgage.getTotalLoan() + "\n"
                    + "Years: " + mortgage.getYears() + "\n"
                    + "Monthly payment: " + mortgage.getMonthlyPayment());
        }
    }

}