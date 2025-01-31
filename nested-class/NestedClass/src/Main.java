import domain.Employee;
import domain.EmployeeComparator;
import domain.StoreEmployee;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Employee> employees = new ArrayList<>(
                List.of(
                        new Employee(1001, "Ralph", 1000, 2015),
                        new Employee(1002, "Carole", 1000, 2021),
                        new Employee(1003, "Jane", 1000, 2013),
                        new Employee(1004, "Laura", 1000, 2020),
                        new Employee(1005, "Jim", 1000, 2018)
                )
        );

//        var comparator = new EmployeeComparator<>();
//        employees.sort(comparator);

        // static nested class
//        employees.sort(new Employee.EmployeeComparator<>("yearStarted").reversed());

        // inner class
        List<StoreEmployee> storeEmployees = new ArrayList<>(
                List.of(
                        new StoreEmployee(1001, "Ralph", 1000, 2015, "a"),
                        new StoreEmployee(1002, "Carole", 1000, 2021, "b"),
                        new StoreEmployee(1003, "Jane", 1000, 2013, "c"),
                        new StoreEmployee(1004, "Laura", 1000, 2020, "d"),
                        new StoreEmployee(1005, "Jim", 1000, 2018, "e")
                )
        );
//
//        var comparator = new StoreEmployee().new StoreComparator<>();
//        storeEmployees.sort(comparator);
//
//        for (StoreEmployee employee : storeEmployees) {
//            System.out.println(employee);
//        }


        // anonymous class
        var c0 = new EmployeeComparator<StoreEmployee>(); // outer class
        var c1 = new Employee.EmployeeComparator<StoreEmployee>(); // static class
        var c2 = new StoreEmployee.EmployeeComparator<StoreEmployee>(); // inner class

        sortIt(storeEmployees, c0);
        sortIt(storeEmployees, c1);
        sortIt(storeEmployees, c2);

        // local class
        class NameSort<T> implements Comparator<StoreEmployee> {

            @Override
            public int compare(StoreEmployee o1, StoreEmployee o2) {
                return o1.getName().compareTo(o2.getName());
            }
        }

        var c3 = new NameSort<StoreEmployee>();

        sortIt(storeEmployees, c0);
        sortIt(storeEmployees, c1);
        sortIt(storeEmployees, c2);
        sortIt(storeEmployees, c3);
        // anonymous class
        sortIt(storeEmployees, (o1, o2) -> o1.getName().compareTo(o2.getName()));

    }

    public static <T> void sortIt(List<T> list,
                                  Comparator<? super T> comparator) {
        System.out.println("Sorting with Comparator: " + comparator.toString());
        list.sort(comparator);
        for (var employee : list) {
            System.out.println(employee);
        }
    }

    // local class
    public static void addPigLatinName(List<? extends StoreEmployee> list) {

        class DecoratedEmployee extends StoreEmployee {

            private String pigLatinName;
            private Employee originalEmployee;

            public DecoratedEmployee(String pigLatinName, Employee originalEmployee) {
                this.pigLatinName = pigLatinName;
                this.originalEmployee = originalEmployee;
            }

            @Override
            public String toString() {
                return "DecoratedEmployee{" +
                        "pigLatinName='" + pigLatinName + '\'' +
                        ", originalEmployee=" + originalEmployee +
                        '}';
            }
        }

//        list.add(new DecoratedEmployee("name", new DecoratedEmployee()));
    }
}