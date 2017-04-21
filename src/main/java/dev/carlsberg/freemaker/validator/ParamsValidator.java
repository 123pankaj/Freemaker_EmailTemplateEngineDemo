package dev.carlsberg.freemaker.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by pankaj on 4/21/2017.
 */
public class ParamsValidator {

    public static boolean emailValidator(String emailId) {
        Pattern pattern;
        Matcher matcher;
        final String EMAIL_PATTERN = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        pattern = Pattern.compile(EMAIL_PATTERN);
        matcher = pattern.matcher(emailId);
        return matcher.matches();
    }

}
