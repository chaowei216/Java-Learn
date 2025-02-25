import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        String example = "123 ne 234";

        // match with condition
        var isMatch = Pattern.matches("\\d{3}", example);
        System.out.println(isMatch);

        // match in string
        Pattern pattern = Pattern.compile("\\d{3}");
        Matcher matcher = pattern.matcher(example);

        while (matcher.find()) {
            System.out.println(matcher.group());
        }

        // replace
        String result = example.replaceAll("\\d{3}", "***");
        System.out.println(result);

        // split
        String[] items = example.split("\\d{3}");
        for (String item : items) {
            System.out.println(item);
        }

        // email matcher
        String emailRgx = "(\\w+)@(\\w+)(\\.)(\\w+)";
        String email = "luutrieuvi2003@gmail.com";

        System.out.println(Pattern.matches(emailRgx, email));

        // phone matcher
        String phoneRgx = "^(0[3|5|7|9])\\d{8}$";
        String phone = "0398371164";

        System.out.println(phone.matches(phoneRgx));
    }
}