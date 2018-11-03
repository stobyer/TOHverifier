package toh;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InputParserTest {

//    @Test
//    void createGameDefinition() {
//    }
//
//    @Test
//    void validateAndSetDisks() {
//    }

    @Test
    void validateDisksString_correct() {
        assertTrue(InputParser.validateDisksString("4"));
    }

    @Test
    void validateDisksString_float_false() {
        assertFalse(InputParser.validateDisksString("4.5"));
    }

    @Test
    void validateDisksString_negative_integer_false() {
        assertFalse(InputParser.validateDisksString("-3"));
    }

    @Test
    void validateDisksString_any_string_false() {
        assertFalse(InputParser.validateDisksString("sfdw"));
    }

    @Test
    void validateMoveString_23_correct() {
        assertTrue(InputParser.validateMoveString("23"));
    }

    @Test
    void validateMoveString_03_incorrect() {
        assertFalse(InputParser.validateMoveString("03"));
    }

    @Test
    void validateMoveString_24_incorrect() {
        assertFalse(InputParser.validateMoveString("24"));
    }

    @Test
    void validateMoveString_4_digites_incorrect() {
        assertFalse(InputParser.validateMoveString("2234"));
    }

    @Test
    void validateMoveString_any_string_correct_length_incorrect() {
        assertFalse(InputParser.validateMoveString("we"));
    }

    @Test
    void validateMoveString_2_digits_one_negative_incorrect() {
        assertFalse(InputParser.validateMoveString("3-2"));
    }

    @Test
    void validateMoveString_single_negative_incorrect() {
        assertFalse(InputParser.validateMoveString("3-2"));
    }

//    @Test
//    void validateAndAddMoves() {
//    }
}