
package populationdata;
import java.util.*;
import java.io.*;

/**
 *
 * @author Shanell Spann
 * Assignment 5
 * 11/01/2020
 * Objective: Write a program that reads a text file's contents into an array. 
 * The program should display three pieces of data: avg annual population change, 
 * year with greatest increase in population, and year with the smallest increase. 
 */
public class PopulationData {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
            //Array for storing data from 1950 to 1990
            int[] population = new int[41];
            int year = 0;
            String line;
            
            System.out.println("Based upon data provided in the 1950-1990 US Population Text File: \n");

            //Opening and reading data from file
            try
            {
                //Scanner class object
                Scanner reader = new Scanner(new File("C:\\Users\\Nelli Pepper\\Downloads\\Source_Code\\Source Code\\Chapter 07\\USPopulation.txt"));
                //Reading data from file
                while(reader.hasNext())
                {
                   //Reading data
                   line = reader.nextLine();
                   //Storing data in to array
                    population[year++] = Integer.parseInt(line);
                }
                //Closing file
                reader.close();
              
                //Array for storing annual change
                int[] annualChange = new int[40];

                int sumChange = 0;
                double avgAnnualChange;

                //Calculating and storing annual changes
                for (year = 0; year < 40; year++)
                {
                    annualChange[year] = population[year + 1] - population[year];
                    sumChange += annualChange[year];
                }

                //Finding average annual change
                avgAnnualChange = sumChange / (double)40.0;

                //Displaying the result
               System.out.printf("\n\t Average increase in population: %f", (avgAnnualChange));

                //Initializing min and max values
                int maxVal = annualChange[0], minVal = annualChange[0];
                int maxYear = 1950, minYear = 1950;

                //Iterating over annual change array to find min & max
                for (year = 0; year < 40; year++)
                {
                    //Finding year with max change in population
                    if (maxVal < annualChange[year])
                    {
                        //Updating max val and year with max change
                        maxVal = annualChange[year];
                        maxYear = 1950 + year;
                    }

                    //Finding year with least change in population
                    if (minVal > annualChange[year])
                    {
                        //Updating least val and year with least change
                        minVal = annualChange[year];
                        minYear = 1950 + year;
                    }
                }

                //Writing results & displaying
                System.out.printf("\n\t Year with greatest increase in population: %d", (maxYear + 1));
                System.out.printf("\n\t Year with smallest increase in population: %d", (minYear + 1));
                System.out.println("\n");
            }
            catch (Exception ex)
            {
                //Displaying error messages
                System.out.println(ex);
            }
    } 
}
