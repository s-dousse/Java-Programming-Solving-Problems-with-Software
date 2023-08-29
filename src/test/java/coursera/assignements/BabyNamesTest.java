package coursera.assignments;

import coursera.assignments.BabyNames;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BabyNamesTest {
    BabyNames babyNames;

    @BeforeEach
    public void setUp() {
        babyNames = new BabyNames();
    }


    @Disabled
    @Nested
    class testTotalBirths {
        @Test
        void totalBirths() {

        }
    }


    @Nested
    class testGetRank {
        @DisplayName("Get highest rank for existing girl name")
        @Test
        void getRankForExistingGirlName() {
            assertEquals(5, babyNames.getRank(2014, "Ava", "F"));
        }

        @DisplayName("Get highest rank for existing boy name")
        @Test
        void getRankForExistingBoyName() {
            assertEquals(513, babyNames.getRank(1920, "Mason", "M"));
        }

        @DisplayName("Get no highest rank for non existing name")
        @Test
        void getRankForNonExistingName() {
            assertEquals(-1, babyNames.getRank(2012, "Kitti", "M"));
        }

        @DisplayName("Get no highest rank for non existing year")
        @Test
        void getRankForNonExistingYear() {
            assertEquals(-1, babyNames.getRank(1879, "Liam", "M"));
        }

        @DisplayName("Get not highest rank for non existing gender")
        @Test
        void getRankForNonExistingGender() {
            assertEquals(-1, babyNames.getRank(2012, "Ava", "E"));
        }
    }

    @Disabled
    @Nested
    class testGetName {
        void getName() {

        }
    }

    @Disabled
    @Nested
    class testWhatIsNameInYear {
        void whatIsNameInYear() {

        }
    }

    @Disabled
    @Nested
    class testYearOfHighestRank {
        void yearOfHighestRank() {

        }
    }

    @Disabled

    @Nested
    class testGetAverageRank {
        void getAverageRank() {

        }
    }

    @Disabled
    @Nested
    class testGetTotalBirthsRankedHigher {
        void getTotalBirthsRankedHigher() {

        }
    }

}
