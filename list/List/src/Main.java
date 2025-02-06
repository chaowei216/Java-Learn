import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

record GroceryItem(String name, String type, int count) {

    public GroceryItem(String name) {
        this(name, "DAIRY", 1);
    }

    @Override
    public String toString() {
        return String.format("%d %s in %s", count, name.toUpperCase(), type);
    }
}

public class Main {
    public static void main(String[] args) {

        Object[] groceryArray = new Object[3];
        groceryArray[0] = new GroceryItem("milk");
        groceryArray[1] = new GroceryItem("apples", "PRODUCE", 6);
        groceryArray[2] = "5 oranges";
        System.out.println(Arrays.toString(groceryArray));

        ArrayList objectList = new ArrayList();
        objectList.add(new GroceryItem("Butter"));
        objectList.add("Yogurt");

        ArrayList<GroceryItem> groceryList = new ArrayList<>();
        groceryList.add(new GroceryItem("Butter"));
        groceryList.add(new GroceryItem("Butter"));
        groceryList.add(new GroceryItem("Butter"));
        System.out.println(groceryList);

        // list
        String[] items = {"apples", "bananas", "milk", "eggs"};

        // immutable
        List<String> list = List.of(items);
        System.out.println(list);
        ArrayList<String> list1 = new ArrayList<>(list);
        list1.add("yogurt");
        System.out.println(list1);
//        System.out.println(list.getClass().getName());

        list1.retainAll(list);
        System.out.println(list1);

        list1.sort(Comparator.reverseOrder());
        ArrayList<String> list2 = new ArrayList<>(Arrays.asList(items));
    }
}