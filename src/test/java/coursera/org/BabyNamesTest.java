package coursera.org;

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
    }

    @Disabled
    @Nested
    class testWhatIsNameInYear {
        @DisplayName("Get a new name for existing girl name")
        @Test
        void whatIsNameInYearForExistingGirlName() {
            assertEquals("Addison", babyNames.whatIsNameInYear("susan", 1972, 2014, "F"));
        }

        @DisplayName("Get a new name for existing boy name")
        @Test
        void whatIsNameInYearForExistingBoyName() {
            assertEquals("Leonel", babyNames.whatIsNameInYear("Owen", 1974, 2014, "M"));
        }

        @DisplayName("Get no new name for existing boy name")
        @Test
        void getNameForNonExistingRank() {
            assertEquals("NO NAME", babyNames.whatIsNameInYear("", 1974, 2014, "M"));
        }

        @DisplayName("Throws exception when there is no data for a year")
        @Test
        void getNameForNonExistingYear() {
            RuntimeException exception = Assertions.assertThrows(RuntimeException.class, () -> {
                babyNames.getName(1879, 17, "F");
            });
            assertEquals("No data for that year: 1879", exception.getMessage());
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


    @Nested
    class testSanitizeGender {
        @DisplayName("Get F is gender is F (UpperCase)")
        @Test
        void getSanitizeExistingGenderUpperCase() {
            assertEquals("F", babyNames.sanitizeGender("F"));
        }

        @DisplayName("Get M is gender is m (LowerCase)")
        @Test
        void getSanitizeExistingGenderLowerCase() {
            assertEquals("M", babyNames.sanitizeGender("m"));
        }


        @DisplayName("Throws exception when there is no data for a gender")
        @Test
        void getSanitizeNonExistingGender() {
            RuntimeException exception = Assertions.assertThrows(RuntimeException.class, () -> {
                babyNames.sanitizeGender("E");
            });
            assertEquals("No data for this gender: E", exception.getMessage());
        }

        @DisplayName("Throws exception when there no gender (too short)")
        @Test
        void getSanitizeEmptyString() {
            RuntimeException exception = Assertions.assertThrows(RuntimeException.class, () -> {
                babyNames.sanitizeGender("EE");
            });
            assertEquals("No data for this gender: EE", exception.getMessage());
        }

        @DisplayName("Throws exception when there no valid gender (too long)")
        @Test
        void getSanitizeEmptyGenderString() {
            RuntimeException exception = Assertions.assertThrows(RuntimeException.class, () -> {
                babyNames.sanitizeGender("");
            });
            assertEquals("No data for this gender: ", exception.getMessage());
        }
    }

    @Nested
    class testSanitizeName {
        @DisplayName("Get Laura is name is Laura (Capitalise)")
        @Test
        void getSanitizeExistingGenderUpperCase() {
            assertEquals("F", babyNames.sanitizeName("F"));
        }

        @DisplayName("Get Johnathan is name is __JOhnaThan (MixCase with space)")
        @Test
        void getSanitizeExistingNameLowerCase() {
            assertEquals("Johnathan", babyNames.sanitizeName("  JOhnaThan"));
        }


        @DisplayName("Throws exception when the name is invalid (contains digits)")
        @Test
        void getSanitizeInvalidName() {
            RuntimeException exception = Assertions.assertThrows(RuntimeException.class, () -> {
                babyNames.sanitizeName("L1am");
            });
            assertEquals("Not a valid name: L1am", exception.getMessage());
        }

        @DisplayName("Throws exception when there no name")
        @Test
        void getSanitizeEmptyNameString() {
            RuntimeException exception = Assertions.assertThrows(RuntimeException.class, () -> {
                babyNames.sanitizeName("");
            });
            assertEquals("Not a valid name: ", exception.getMessage());
        }
    }

}
