package nl.tweeenveertig.csveed.bean.instructions;

import nl.tweeenveertig.csveed.testclasses.BeanSimple;
import org.junit.Test;

import static junit.framework.Assert.assertNull;

public class BeanInstructionsTest {

    @Test
    public void propertyNameIsNull() {
        BeanInstructions<BeanSimple> instructions = new BeanInstructions<BeanSimple>(BeanSimple.class);
        assertNull(instructions.getBeanPropertyWithName(null));
        assertNull(instructions.getBeanPropertyWithName("definitelyNotHere"));
    }

}