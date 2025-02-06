import java.util.LinkedList;
import java.util.ListIterator;

public class Main {
    public static void main(String[] args) {

        var placesToVisit = new LinkedList<String>();
        placesToVisit.add("Sydney");
        placesToVisit.addFirst("New York");
        System.out.println(placesToVisit);
        // Queue
        placesToVisit.offer("New York");
        placesToVisit.poll();
        // Stack
        placesToVisit.push("Alice Springs");

        String previousTown = placesToVisit.getFirst();
        ListIterator<String> iterator = placesToVisit.listIterator();
        while (iterator.hasNext()) {
            var town = iterator.next();
            System.out.println("--> From: " + previousTown + " to " + town);
            previousTown = town;
        }
        

    }
}