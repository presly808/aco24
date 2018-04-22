package week2.mvc.validation;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class DataValidationTest {


    @Test
    public void validateStringValue() {
        assertEquals("testValue", DataValidation.validateStringValue("testValue"));
    }

    @Test
    public void validateStringValueNeg() {
        assertEquals(null, DataValidation.validateStringValue(""));
    }

    @Test
    public void paramIsNumber() {
        assertEquals(true, DataValidation.paramIsNumber("0977260884"));
    }

    @Test
    public void paramIsNumberNeg() {
        assertEquals(false, DataValidation.paramIsNumber("negValue123"));
    }

    @Test
    public void validateNumberFormate(){
        assertEquals("380977260880", DataValidation.validateNumberFormate("+380977260880"));
    }

    @Test
    public void validateNumberFormateNeg(){
        assertEquals(null, DataValidation.validateNumberFormate(null));
    }
}
