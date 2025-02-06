public class Main {
    public static void main(String[] args) {

        DayOfTheWeek weekDay = DayOfTheWeek.THURSDAY;
        System.out.println(weekDay);
        System.out.printf("Name is %s, Ordinal Value = %d%n", weekDay.name(), weekDay.ordinal());
    }
}