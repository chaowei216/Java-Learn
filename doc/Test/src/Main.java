import java.math.BigDecimal;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        int[] arr = {2, 5, 1, 4, 3, 2};
        int[] arr1 = {2, 5, 1, 4, 3, 2};

        var set = new HashSet<Integer>();
        set.addAll((Collection<? extends Integer>) List.of(arr));
        set.add(arr1);

        var sortedList = new ArrayList<>(set);
        Collections.sort(sortedList);

        return sortedList.getFirst() + (double)(sortedList.get(sortedList.size() - 1) - sortedList.getFirst())/2;
    }

    public static int matchSubsets(int n, int[] arr, int sum) {

        int[][] subsets = new int[n + 1][sum + 1];
        for (int[] subset : subsets) {
            Arrays.fill(subset, -1);
        }

        return countSubsets(0, 0, sum, arr, subsets);
    }

    public static int countSubsets(int pos, int currSum, int sum, int[] arr, int[][] subsets) {

        // int[] arr = {2, 5, 1, 4, 3, 2};
        int n = arr.length;

        if (pos == n) {

            return currSum == sum ? 1 : 0;
        }

        if (subsets[pos][currSum] != -1) {

            return subsets[pos][currSum];
        }

        int exclude = countSubsets(pos + 1, currSum, sum, arr, subsets);

        int include = 0;
        if (currSum + arr[pos] <= sum) {

            include = countSubsets(pos + 1, currSum + arr[pos], sum, arr, subsets);
        }

        subsets[pos][currSum] = include + exclude;
        return subsets[pos][currSum];
    }

}
