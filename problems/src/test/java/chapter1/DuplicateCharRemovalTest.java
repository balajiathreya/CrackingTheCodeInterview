package chapter1;

import junit.framework.Assert;
import org.junit.Test;

/**
 * Created by baathreya on 3/24/15.
 */

public class DuplicateCharRemovalTest {


    @Test
    public void testDuplicateRemoval(){
        DuplicateCharRemoval duplicateCharRemoval = new DuplicateCharRemoval();
        Assert.assertEquals("black", duplicateCharRemoval.removeDuplicates("black"));
        Assert.assertEquals("black", duplicateCharRemoval.removeDuplicates("blaaack"));
        Assert.assertEquals("black", duplicateCharRemoval.removeDuplicates("bbbblack"));
        Assert.assertEquals("black", duplicateCharRemoval.removeDuplicates("bbbblllaaaccckk"));
        Assert.assertEquals(null, duplicateCharRemoval.removeDuplicates(null));
        Assert.assertEquals("", duplicateCharRemoval.removeDuplicates(""));
    }

}
