package week2.mvc.validation;

import org.apache.commons.lang3.StringUtils;

public class DataValidation {

    public static String validateStringValue(String value){
        if(value == null || value.isEmpty()) {
            return null;
        }
        return value;
    }

    public static boolean paramIsNumber(String param) {
        if (param == null) return false;
        return StringUtils.isNumericSpace(validateNumberFormate(param));
    }

    public static String validateNumberFormate(String param) {
        if (param == null) return param;
        return param.substring(1);
    }

}
