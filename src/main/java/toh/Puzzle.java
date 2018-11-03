package toh;

import java.util.*;
import java.util.stream.IntStream;

class Puzzle {

    private ArrayList<Rod> rods = new ArrayList<>();

    private Puzzle(int numOfDiscs) {
        IntStream.rangeClosed(1, 3).forEach(i -> rods.add(new Rod()));
        IntStream.rangeClosed(1, numOfDiscs).forEach(i -> rods.get(0).putDisk(numOfDiscs - i + 1));
    }

    static Puzzle createPuzzle(int numOfDiscs) {
        if (numOfDiscs <= 0) {
            throw new IllegalArgumentException("Cannot create puzzle with " + numOfDiscs + " disks, at least one disk required");
        }
        return new Puzzle(numOfDiscs);
    }

    Rod getRod(int rodNum) {
        return rods.get(rodNum - 1);
    }

    void move(int from, int to) throws IllegalStateException {
        Optional<Integer> diskToMove = rods.get(from - 1).peekDisk();
        if (!diskToMove.isPresent()) {
            throw new IllegalStateException("The source rod number " + from + " is empty");
        }
        if (!rods.get(to - 1).tryDisk(diskToMove.get())) {
            throw new IllegalStateException("Cannot move disk from rod " + from + " to rod " + to);
        }
        rods.get(to - 1).putDisk(rods.get(from - 1).getDisk());
    }

    boolean verifyEndState() {
        // Starting rod must be empty.
        // All disks in correct order must be on second or third rod.
        return rods.get(0).isEmpty() &&
                ((rods.get(1).isEmpty() && !rods.get(2).isEmpty() && rods.get(2).isValidFinal())
                        || (rods.get(2).isEmpty() && !rods.get(1).isEmpty() && rods.get(1).isValidFinal()));
    }

    public static class Rod {
        private Deque<Integer> rod = new ArrayDeque<>();

        void putDisk(int diskSize) {
            rod.push(diskSize);
        }

        int getDisk() {
            return rod.pollFirst();
        }

        int getNumDisks() {
            return rod.size();
        }

        private Optional<Integer> peekDisk() {
            return Optional.ofNullable(rod.peekFirst());
        }

        private boolean tryDisk(int disk) {
            return rod.size() == 0 || rod.peekFirst() > disk;
        }

        boolean isEmpty() {
            return rod.size() == 0;
        }

        boolean isValidFinal() {
            Integer i = 1;
            for (Iterator itr = rod.iterator(); itr.hasNext(); i++) {
                if (!i.equals(itr.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override
        public String toString() {
            return rod.toString();
        }
    }
}
