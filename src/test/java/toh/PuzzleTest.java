package toh;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class PuzzleTest {

    @Test
    public void rodIsValidFinal_3_disks_valid() {
        Puzzle.Rod rod = new Puzzle.Rod();
        rod.putDisk(3);
        rod.putDisk(2);
        rod.putDisk(1);
        assertTrue(rod.isValidFinal());
    }

    @Test
    public void rodIsValidFinal_empty_valid() {
        Puzzle.Rod rod = new Puzzle.Rod();
        rod.putDisk(3);
        rod.putDisk(2);
        rod.putDisk(1);
        assertTrue(rod.isValidFinal());
    }

    @Test
    public void rodIsValidFinal_3_disks_bad_order() {
        Puzzle.Rod rod = new Puzzle.Rod();
        rod.putDisk(2);
        rod.putDisk(3);
        rod.putDisk(1);
        assertFalse(rod.isValidFinal());
    }

    @Test
    public void rodIsValidFinal_3_disks_missing_one() {
        Puzzle.Rod rod = new Puzzle.Rod();
        rod.putDisk(4);
        rod.putDisk(2);
        rod.putDisk(1);
        assertFalse(rod.isValidFinal());
    }

    @Test
    public void createPazzle_3_disks() {
        createPazzle_n_disks(3);
    }

    @Test
    public void createPazzle_28_disks() {
        createPazzle_n_disks(28);
    }

    @Test(expected = IllegalArgumentException.class)
    public void createPazzle_0_disks() {
        createPazzle_n_disks(0);
    }

    private void createPazzle_n_disks(int numDisks) {
        Puzzle pm = Puzzle.createPuzzle(numDisks);
        Puzzle.Rod rod = pm.getRod(1);
        assertEquals(numDisks, rod.getNumDisks());
        assertTrue(rod.isValidFinal());
    }

    @Test
    public void move_to_emptyDisk_valid() {
        Puzzle puzzle = Puzzle.createPuzzle(3);
        puzzle.move(1, 3);
    }

    @Test
    public void move_to_not_emptyDisk_valid() {
        Puzzle puzzle = Puzzle.createPuzzle(4);
        puzzle.move(1, 3);
        puzzle.move(1, 2);
        puzzle.move(3, 2);
    }

    @Test(expected = IllegalStateException.class)
    public void move_on_larger_disk() {
        Puzzle puzzle = Puzzle.createPuzzle(3);
        puzzle.move(1, 3);
        puzzle.move(1, 2);
        puzzle.move(2, 3);
    }

    @Test(expected = IllegalStateException.class)
    public void move_from_empty_rod() {
        Puzzle puzzle = Puzzle.createPuzzle(3);
        puzzle.move(2, 3);
    }

    @Test
    public void verifyEndState_initialState_false() {
        Puzzle puzzle = Puzzle.createPuzzle(3);
        assertFalse(puzzle.verifyEndState());
    }

    @Test
    public void verifyEndState_disks_on_rod_2_success() {
        Puzzle puzzle = Puzzle.createPuzzle(1);
        puzzle.getRod(1).getDisk();
        puzzle.getRod(2).putDisk(3);
        puzzle.getRod(2).putDisk(2);
        puzzle.getRod(2).putDisk(1);
        assertTrue(puzzle.verifyEndState());
    }

    @Test
    public void verifyEndState_in_gamee_false() {
        Puzzle puzzle = Puzzle.createPuzzle(3);
        puzzle.getRod(1).getDisk();
        puzzle.getRod(2).putDisk(6);
        puzzle.getRod(2).putDisk(5);
        puzzle.getRod(2).putDisk(4);
        assertFalse(puzzle.verifyEndState());
    }

    @Test
    public void verifyEndState_monotonic_order_lack_of_disk() {
        Puzzle puzzle = Puzzle.createPuzzle(1);
        puzzle.getRod(1).getDisk();
        puzzle.getRod(2).putDisk(4);
        puzzle.getRod(2).putDisk(3);
        puzzle.getRod(2).putDisk(1);
        assertFalse(puzzle.verifyEndState());
    }

}