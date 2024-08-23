package problemSolving;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupPeople {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        // Initialize the answer list to store groups of people
        List<List<Integer>> groupedPeople = new ArrayList<>();

        // Create a map to associate group sizes with people's IDs
        Map<Integer, List<Integer>> groupMap = new HashMap<>();

        // Iterate through the groupSizes array
        for (int personID = 0; personID < groupSizes.length; personID++) {
            int desiredGroupSize = groupSizes[personID];

            // Add the current person's ID to the corresponding group
            groupMap.computeIfAbsent(desiredGroupSize, k -> new ArrayList<>()).add(personID);

            // Check if the group is complete (i.e., has the desired size)
            if (groupMap.get(desiredGroupSize).size() == desiredGroupSize) {
                // Add the complete group to the answer list
                groupedPeople.add(List.copyOf(groupMap.get(desiredGroupSize)));

                // Clear the group as it's been added to the answer
                groupMap.get(desiredGroupSize).clear();
            }
        }

        // Return the answer list containing grouped people
        return groupedPeople;
    }

    public static void main(String[] args) {
        int[] groupSizes = {3,3,3,3,3,1,3};
        GroupPeople groupPeople = new GroupPeople();
        List<List<Integer>> ans = groupPeople.groupThePeople(groupSizes);
        System.out.println(ans);
    }
}
