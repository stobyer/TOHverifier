package toh;

import org.junit.Test;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class SolutionVerifierTest {

    @Test
    public void verifySolution_given_example_good() {
        List<String> input = Arrays.asList("3", "13", "12", "32", "13", "21", "23", "13");
        assertEquals(SolutionVerifier.Result.Yes, SolutionVerifier.verifySolution(input));
    }

    @Test
    public void verifySolution_given_example_lack_last_move() {
        List<String> input = Arrays.asList("3", "13", "12", "32", "13", "21", "23");
        assertEquals(SolutionVerifier.Result.No, SolutionVerifier.verifySolution(input));
    }

    @Test
    public void verifySolution_given_example_lack_move_in_middle() {
        List<String> input = Arrays.asList("3", "13", "12", "32", "13", "23", "13");
        assertEquals(SolutionVerifier.Result.No, SolutionVerifier.verifySolution(input));
    }

    @Test
    public void verifySolution_given_example_swapped_move() {
        List<String> input = Arrays.asList("3", "13", "21", "32", "13", "21", "23", "13");
        assertEquals(SolutionVerifier.Result.No, SolutionVerifier.verifySolution(input));
    }

    @Test
    public void verifySolution_given_example_incomplete_end_state() {
        List<String> input = Arrays.asList("4", "13", "15", "32", "13", "21", "23", "13");
        assertEquals(SolutionVerifier.Result.No, SolutionVerifier.verifySolution(input));
    }

    @Test
    public void verifySolution_5disks_good() {
        List<String> input = Arrays.asList("5", "13", "12", "32", "13", "21", "23", "13", "12", "32", "31", "21", "32", "13", "12", "32", "13", "21", "23", "12", "23", "21", "32", "31", "21", "23", "13", "12", "32", "13", "21", "23", "13");
        assertEquals(SolutionVerifier.Result.Yes, SolutionVerifier.verifySolution(input));
    }

    @Test
    public void verifySolution_5disks_lack_first_move() {
        List<String> input = Arrays.asList("5", "12", "32", "13", "21", "23", "13", "12", "32", "31", "21", "32", "13", "12", "32", "13", "21", "23", "12", "23", "21", "32", "31", "21", "23", "13", "12", "32", "13", "21", "23", "13");
        assertEquals(SolutionVerifier.Result.No, SolutionVerifier.verifySolution(input));
    }

    @Test
    public void readInputAndVerifySolution_given_example() {
        assertEquals(SolutionVerifier.Result.Yes, SolutionVerifier.readInputAndVerifySolution(getTestFilePath("given_input.txt")));
    }

    @Test
    public void readInputAndVerifySolution_file_not_exist() {
        assertEquals(SolutionVerifier.Result.No, SolutionVerifier.readInputAndVerifySolution("StamFile.txt"));
    }

    private String getTestFilePath(String fileName) {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(fileName).getFile());
        return file.getAbsolutePath();
    }
}