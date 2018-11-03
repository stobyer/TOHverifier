package toh;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class InputParserTest {

//    @Test
//    void parseSolution() {
//    }
//
//    @Test
//    void validateAndSetDisks() {
//    }

    @Test
    public void validateDisksString_correct() {
        assertTrue(InputParser.validateDisksString("4"));
    }

    @Test
    public void validateDisksString_float_false() {
        assertFalse(InputParser.validateDisksString("4.5"));
    }

    @Test
    public void validateDisksString_negative_integer_false() {
        assertFalse(InputParser.validateDisksString("-3"));
    }

    @Test
    public void validateDisksString_any_string_false() {
        assertFalse(InputParser.validateDisksString("sfdw"));
    }

    @Test
    public void validateMoveString_23_correct() {
        assertTrue(InputParser.validateMoveString("23"));
    }

    @Test
    public void validateMoveString_03_incorrect() {
        assertFalse(InputParser.validateMoveString("03"));
    }

    @Test
    public void validateMoveString_24_incorrect() {
        assertFalse(InputParser.validateMoveString("24"));
    }

    @Test
    public void validateMoveString_4_digites_incorrect() {
        assertFalse(InputParser.validateMoveString("2234"));
    }

    @Test
    public void validateMoveString_any_string_correct_length_incorrect() {
        assertFalse(InputParser.validateMoveString("we"));
    }

    @Test
    public void validateMoveString_2_digits_one_negative_incorrect() {
        assertFalse(InputParser.validateMoveString("3-2"));
    }

    @Test
    public void validateMoveString_single_negative_incorrect() {
        assertFalse(InputParser.validateMoveString("3-2"));
    }

//    @Test
//    void validateAndAddMoves() {
//    }
}