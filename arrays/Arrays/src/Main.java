import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        System.out.println("Array");

        // init an array
        int[] integerArray = new int[10];

        // assign value
        integerArray[5] = 50;

        // anonymous array
        int[] firstThree = {1, 2, 3};

        // compile error
//        int[] newArray;
//        newArray = {1, 2, 3};

        System.out.println(Arrays.toString(firstThree));

        Object objVariable = firstThree;

        if (objVariable instanceof int[]) {
            System.out.println("Object variable is really an int array");
        }

        // binary search
        if (Arrays.binarySearch(firstThree, 3) > 0) {
            System.out.println("Array is really an int array");
        }
    }
}