package coursera.assignments;

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

        @DisplayName("Throws exception when there is no data for a year")
        @Test
        void getRankForNonExistingYear() {
            RuntimeException exception = Assertions.assertThrows(RuntimeException.class, () -> {
                babyNames.getRank(1879, "Liam", "M");
            });
            assertEquals("No data for that year: 1879", exception.getMessage());
        }

        @DisplayName("Throws exception when there is no data for a gender")
        @Test
        void getRankForNonExistingGender() {
            RuntimeException exception = Assertions.assertThrows(RuntimeException.class, () -> {
                babyNames.getRank(2012, "Ava", "E");
        });
        assertEquals("No data for this gender: E", exception.getMessage());
        }
    }


    @Nested
    class testGetName {
        @DisplayName("Get name for existing rank (girl)")
        @Test
        void getNameForExistingGirlName() {
            assertEquals("Georgia", babyNames.getName(1935, 123, "F"));
        }

        @DisplayName("Get name for existing rank (boy)")
        @Test
        void getNameForExistingBoyRank() {
            assertEquals("Albert", babyNames.getName(1894, 16, "M"));
        }
        @DisplayName("Get no name for non existing rank")
        @Test
        void getNameForNonExistingRank() {
            assertEquals("NO NAME", babyNames.getName(1880, 2000, "F"));
        }

        @DisplayName("Throws exception when there is no data for a year")
        @Test
        void getNameForNonExistingYear() {
            RuntimeException exception = Assertions.assertThrows(RuntimeException.class, () -> {
                babyNames.getName(1879, 17, "F");
            });
            assertEquals("No data for that year: 1879", exception.getMessage());
        }

        @DisplayName("Get no name for non existing gender")
        @Test
        void getNameForNonExistingGender() {
            RuntimeException exception = Assertions.assertThrows(RuntimeException.class, () -> {
                babyNames.getName(2009, 20, "E");
            });
            assertEquals("No data for this gender: E", exception.getMessage());
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
