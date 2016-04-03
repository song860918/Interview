package ds.recursion;

import java.util.HashSet;
import java.util.Set;

public class AllSubsets<T> {

    public Set<Set<T>> allSubsets(Set<T> inputSet) {
        if (inputSet == null || inputSet.isEmpty()) {
            return new HashSet<>();
        }

        Set<Set<T>> resultSet = new HashSet<>();
        allSubsetsHelper(inputSet, new HashSet<>(), resultSet);
        return resultSet;
    }

    private void allSubsetsHelper(Set<T> inputSet, Set<T> currentSet, Set<Set<T>> resultSet) {

        if (inputSet.isEmpty()) {
            resultSet.add(currentSet);
        }

        for (T data : inputSet) {
            Set<T> tempInputSet = new HashSet<>(inputSet);
            tempInputSet.remove(data);
            allSubsetsHelper(tempInputSet, currentSet, resultSet);
            Set<T> tempCurrentSet = new HashSet<>(currentSet);
            tempCurrentSet.add(data);
            allSubsetsHelper(tempInputSet, tempCurrentSet, resultSet);
        }

    }

}
