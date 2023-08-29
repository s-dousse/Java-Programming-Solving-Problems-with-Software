package coursera.assignments;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

class BabyNames {
    public void totalBirths(int year) {
        int totalGirls = 0;
        int totalBoys = 0;
        int numGirlsNames = 0;
        int numBoysNames = 0;

        List<String[]> records = getListOfBabyNamesPerYear(year);

        for (String[] record : records) {
            int numBorn = Integer.parseInt(record[2]);
            if (record[1].equals("F")) {
                totalGirls += numBorn;
                numGirlsNames++;
            } else {
                totalBoys += numBorn;
                numBoysNames++;
            }
        }
        int totalBirths = totalGirls + totalBoys;
        System.out.println("total births = " + totalBirths);
        System.out.println("female girls = " + totalGirls);
        System.out.println("male boys = " + totalBoys);
        System.out.println("Number of girls names = " + numGirlsNames);
        System.out.println("Number of boys names = " + numBoysNames);
    }

    public int getRank(int year, String name, String gender) {
        int rank = 0;

        List<String[]> records = getListOfBabyNamesPerYear(year);

        for (String[] record : records) {
            if ( record[1].equals(gender)) {
                rank++;
                if (record[0].equals(name)) {
                    return rank;
                }
            }
        }
        return -1;
    }

    public String getName(int year, int rank, String gender) {
        List<String[]> records = getListOfBabyNamesPerYear(year);

        for (String[] record : records) {
            String name = record[0];
            if(rank == getRank(year, name, gender)){
                return name;
            }
        }
        return "NO NAME";

    }

    public void whatIsNameInYear(String name, int year, int newYear, String gender) {
        int actualRank = getRank(year, name, gender);
        String newName = getName(newYear, actualRank, gender);
        System.out.println(name + " born in " + year + " would be " + newName + " if she was born in " + newYear);
    }

    public int yearOfHighestRank(String name, String gender) {
        int year = 0;
        int highestRank = -1;

        File[] directory = getListOfBabyNamesForAllYears();

        for (File f : directory) {
            int currentYear = Integer.parseInt(f.getName().substring(3, 7));
            int currentRank = getRank(currentYear, name, gender);

            if (currentRank != -1 && currentRank > highestRank) {
                highestRank = currentRank;
                year = currentYear;
            }
        }

        return year;
    }

    public double getAverageRank(String name,String gender) {
        int numbOfFiles = 0;
        int totalRank = 0;
        File[] directory = getListOfBabyNamesForAllYears();

        for (File f : directory) {
            numbOfFiles++;
            int currentYear = Integer.parseInt(f.getName().substring(3, 7));
            if (getRank(currentYear, name, gender) == -1) { break; }
            totalRank += getRank(currentYear, name, gender);
        }
        return totalRank > 0 ? ((double) totalRank / numbOfFiles) : -1;
    }

    public int getTotalBirthsRankedHigher(int year, String name, String gender) {
        int rank = getRank(year, name, gender);
        int totalBirths = 0;

        System.out.println("Name: " + name + ". Rank: " + getRank(year, name, gender));

        int recordRank = 0;
        List<String[]> records = getListOfBabyNamesPerYear(year);

        for (String[] record : records) {
            String currentGender = record[1];

            if (currentGender.equals(gender)) {
                recordRank++;

                if (recordRank < rank) {
                    int currentBirths = Integer.parseInt(record[2]);
                    totalBirths += currentBirths;
                } else {
                    break;
                }
            }
        }

        return totalBirths;
    }

    private List<String[]> getListOfBabyNamesPerYear(int year) {
        String filename = "src/main/resources/us_babynames_by_year/yob"+ year + ".csv";

        Reader reader = null;
        Path path = Paths.get(filename);
        try {
            reader = Files.newBufferedReader(path);
        } catch (IOException e) {
            throw new RuntimeException("No data for that year: " + year);
        }

        CSVReader csvReader = new CSVReader(reader);
        List<String[]> records = null;
        try {
            records = csvReader.readAll();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (CsvException e) {
            throw new RuntimeException(e);
        }
        return records;
    }

    private File[] getListOfBabyNamesForAllYears() {
        File dir = new File("src/main/resources/us_babynames_by_year");
        File[] files = dir.listFiles((dir1, name) -> name.toLowerCase().endsWith(".csv"));
        return files;
    }

    public static void main(String[] args) {
    }
}
