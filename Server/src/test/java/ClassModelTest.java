import edu.sdccd.cisc191.template.ClassModel;
import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClassModelTest {
    private ClassModel classModel;

    @Before
    public void setUp() {
        classModel = new ClassModel();
        classModel.setAtIndex(0,"Andy");
        classModel.setAtIndex(1,"Isa");
    }

    @Test
    public void testGetAtIndex() {
        assertEquals(classModel.getAtIndex(0), "Andy");
    }

    @Test
    public void testSetAtIndex() {
        assertEquals(classModel.setAtIndex(2, "Essie"), "Essie");
    }

    @Test
    public void testFindIndexOf() {
        assertEquals(classModel.findIndexOf( "Andy"), 0);
        //TODO: doesn't include stuff from testSetAtIndex , not sure if it should
        //assertEquals(classModel.findIndexOf( "Essie"), 2);
    }

    @Test
    public void testDeleteAtIndex(){
        assertEquals(classModel.deleteAtIndex(0), null);
    }

    @Test
    public void testExpand() {
        classModel.expand();
        assertEquals(classModel.getAtIndex(2), "");
    }

    @Test
    //todo is this right?
    public void testShrink() {
        classModel.shrink();
        assertEquals(classModel.getAtIndex(2), "");
    }




}
