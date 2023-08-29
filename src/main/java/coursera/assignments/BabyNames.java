package coursera.assignments;

import edu.duke.DirectoryResource;
import edu.duke.FileResource;
import org.apache.commons.csv.CSVRecord;

import java.io.File;

class BabyNames {
    public void totalBirths() {
        int totalGirls = 0;
        int totalBoys = 0;
        int numGirlsNames = 0;
        int numBoysNames = 0;

        FileResource fr = new FileResource();
        for (CSVRecord record : fr.getCSVParser(false)) {
            int numBorn = Integer.parseInt(record.get(2));
            if (record.get(1).equals("F")) {
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
        boolean nameFound = false;

        FileResource fr = new FileResource("Baby_Names_Data/app/src/main/resources/us_babynames_by_year/yob"+ year + ".csv");

        for (CSVRecord record : fr.getCSVParser(false)) {
            if ( record.get(1).equals(gender)) {
                rank++;
                if (record.get(0).equals(name)) {
                    return rank;
                }
            }
        }
        return -1;
    }

    public String getName(int year, int rank, String gender) {
        FileResource fr = new FileResource("Baby_Names_Data/app/src/main/resources/us_babynames_by_year/yob"+ year + ".csv");

        for (CSVRecord r : fr.getCSVParser(false)){
            String name = r.get(0);
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

        DirectoryResource directory = new DirectoryResource();
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
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
        DirectoryResource directory = new DirectoryResource();
        for (File f : directory.selectedFiles()) {
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
        FileResource fr = new FileResource("Baby_Names_Data/app/src/main/resources/us_babynames_by_year/yob"+ year + ".csv");

        for (CSVRecord record : fr.getCSVParser(false)) {
            String currentGender = record.get(1);

            if (currentGender.equals(gender)) {
                recordRank++;

                if (recordRank < rank) {
                    int currentBirths = Integer.parseInt(record.get(2));
                    totalBirths += currentBirths;
                } else {
                    break;
                }
            }
        }

        return totalBirths;
    }

    public void testTotalBirths() {
        totalBirths();
    }

    public void testGetRank() {
        int year = 1960;
        String name = "Emily";
        String gender = "F";

        int rank = getRank(year, name, gender);
        System.out.println(name + " rank is " + rank);
    }

    public void testGetName() {
        int year = 1982;
        int rank = 450;
        String gender = "M";

        String name = getName(year, rank, gender);
        System.out.println(year + " rank " + rank + " is " + name);
    }

    public void testWhatIsNameInYear() {
        whatIsNameInYear("Susan", 1972, 2014, "F");
        whatIsNameInYear("Owen", 1974, 2014, "M");
    }

    public void testYearOfHighestRank() {
        String name = "Genevieve";
        String gender = "F";
        System.out.println(name + " most popular year is " + yearOfHighestRank(name, gender));
    }

    public void testGetAverageRank() {
        String name = "Susan";
        String gender = "F";
        System.out.println("Average rank for " + name + " is " + getAverageRank(name, gender));

        name = "Robert";
        gender = "M";
        System.out.println("Average rank for " + name + " is " + getAverageRank(name, gender));
    }

    public void testGetTotalBirthsRankedHigher() {
        int year = 1990;
        String name = "Emily";
        String gender = "F";
        System.out.println("Total births higher than " + name + " is " + getTotalBirthsRankedHigher(year, name, gender));

        year = 1990;
        name = "Drew";
        gender = "M";
        System.out.println("Total births higher than " + name + " is " + getTotalBirthsRankedHigher(year, name, gender));
    }

    public static void main(String[] args) {
    }
}

//TODO: USE CSVParser.getCurrentLineNumber()???
//TODO: extract method to get file name base on year