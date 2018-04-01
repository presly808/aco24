package patterns.adapter;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by serhii on 31.03.18.
 */
public class PoliceDepartmentTest {
    @Test
    public void testPoliceman() throws Exception {

        PoliceAdapter newPolice = new PoliceAdapter(new OldPolice());
        PoliceDepartment policeDepartment = new PoliceDepartment();
        String result = policeDepartment.testPoliceman(newPolice);

        Assert.assertEquals("Give me a bride", result);

    }

}