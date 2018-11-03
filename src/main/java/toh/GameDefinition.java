package toh;

import java.util.ArrayList;
import java.util.List;

class GameDefinition {
    private int numDisks;
    private List<Move> moves = new ArrayList<>();

    int getNumDisks() {
        return numDisks;
    }

    void setNumDisks(int numDisks) {
        this.numDisks = numDisks;
    }

    List<Move> getMoves() {
        return moves;
    }

    void addMove(String moveStr) {
        int from = Integer.parseInt(moveStr.substring(0, 1));
        int to = Integer.parseInt(moveStr.substring(1, 2));
        moves.add(new Move(from, to));
    }

    public class Move {
        int fromDisk;
        int toDisk;

        private Move(int fromDisk, int toDisk) {
            this.fromDisk = fromDisk;
            this.toDisk = toDisk;
        }
    }
}
