import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckPhoneNumber {
    public static boolean isValid11DigitnMobile(String mobile) {

        if (mobile == null || mobile.trim().length() <= 0) {
            return false;
        }
        mobile = removeAllSpace(mobile);

        Pattern pattern = Pattern.compile("^([1-9][0-9]{9})|([0][1-9][0-9]{9})$");
        Matcher matcher = pattern.matcher(mobile);
        return matcher.matches();
    }


    public static String removeAllSpace(String s) {
        if (s == null) return "";
        return s.replaceAll("\\s", "");
    }
}
