package toh;

import java.util.List;

class InputParser {
    static GameDefinition createGameDefinition(List<String> allLines){
        GameDefinition gameDefinition = new GameDefinition();

        validateAndSetDisks(allLines, gameDefinition);
        validateAndAddMoves(allLines.subList(1, allLines.size()), gameDefinition);
        return gameDefinition;
    }

    private static void validateAndSetDisks(List<String> allLines, GameDefinition gameDefinition) {
        if (!validateDisksString(allLines.get(0))) {
            throw new IllegalArgumentException("The disk amount must be a positive integer");
        }

        gameDefinition.setNumDisks(Integer.parseInt(allLines.get(0)));
//        allLines.remove(0);
    }

    static boolean validateDisksString(String disks) {
        try {
            int numDisks = Integer.parseInt(disks);
            if(numDisks <= 0){
                return false;
            }
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    private static void validateAndAddMoves(List<String> allLines, GameDefinition gameDefinition) {
        for (String move : allLines) {
            if (!validateMoveString(move)) {
                throw new IllegalArgumentException("The move string must be exactly two digits, each one between 1 and 3 inclusive");
            }
            gameDefinition.addMove(move);
        }
    }

    static boolean validateMoveString(String moveStr) throws IllegalArgumentException {
        if (moveStr.length() != 2) {
            return false;
        }
        try {
            Integer from = Integer.parseInt(moveStr.substring(0, 1));
            Integer to = Integer.parseInt(moveStr.substring(1, 2));
            if(!isInRodsRange(from) || !isInRodsRange(to)){
                return false;
            }
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    private static boolean isInRodsRange(Integer num){
        return num > 0 && num < 4;
    }
}
