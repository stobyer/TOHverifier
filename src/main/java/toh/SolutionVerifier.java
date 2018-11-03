package toh;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class SolutionVerifier {
    public static void main(String[] args) {
        System.out.println(readInputAndVerifySolution(args[0]));
    }

    static Result readInputAndVerifySolution(String fileName){
        try {
            List<String> allLines = Files.readAllLines(Paths.get(fileName));
            return verifySolution(allLines);
        } catch (IOException e) {
            return Result.No;
        }
    }

    static Result verifySolution(List<String> allLines) {
        try {
            GameDefinition gameDefinition = InputParser.createGameDefinition(allLines);
            Puzzle puzzle = Puzzle.createPuzzle(gameDefinition.getNumDisks());
            gameDefinition.getMoves().forEach(m -> puzzle.move(m.fromDisk, m.toDisk));
            if (puzzle.verifyEndState()) {
                return Result.Yes;
            }
            return Result.No;
        } catch (Throwable e) {
            return Result.No;
        }
    }

    enum Result {
        Yes, No
    }
}
