package ApnaCollege;

import java.util.List;

public class PotentialWinnerFinder {

    public static void main(String[] args) {
        List<Integer> potentials = List.of(20, 30, 25, 40, 35);
        long k = 30;
        int potentialWinnerIndex = getPotentialOfWinnerProblem(potentials, k);

        if (potentialWinnerIndex != -1) {
            System.out.println("The potential winning player is at index " + potentialWinnerIndex);
        } else {
            System.out.println("No player has potential greater than or equal to " + k);
        }
    }

    public static int getPotentialOfWinnerProblem(List<Integer> potential, long k) {
        if (potential == null || potential.isEmpty()) {
            throw new IllegalArgumentException("The list of potentials cannot be empty or null.");
        }

        // Initialize variables to keep track of the potential winner and their maximum potential.
        int potentialWinner = 0;
       // int maxPotential = potential.get(0);

        for (int i = 0 ; i < potential.size(); i++) {
          int currentPotential = potential.get(i);

            if (k >= currentPotential) {
                potentialWinner = i;
            }
        }
        return potentialWinner;
    }
}

