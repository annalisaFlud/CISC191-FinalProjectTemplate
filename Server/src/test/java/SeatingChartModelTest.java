import edu.sdccd.cisc191.template.ClassModel;
import edu.sdccd.cisc191.template.SeatingChartModel;
import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;

public class SeatingChartModelTest {
    private SeatingChartModel seatingChartModel;

    @Before
    public void setUp() {
        seatingChartModel = new SeatingChartModel();

        seatingChartModel.setAtIndex(0,0,"Andy");
        seatingChartModel.setAtIndex(0,1,"Isa");
        seatingChartModel.setAtIndex(1,0,"Essie");
        seatingChartModel.setAtIndex(1,1,"Bella");
    }

    @Test
    public void testGetAtIndex() {
        assertEquals(seatingChartModel.getAtIndex(0, 0), "Andy");
    }

    @Test
    public void testSetAtIndex() {
        assertEquals(seatingChartModel.setAtIndex(0, 0, "Andrew"), "Andrew");
    }

//    @Test
//    public void testFindIndexOf() {
//        assertEquals(seatingChartModel.findIndexOf("Essie"), int[] answer = new int[2]);
//
//    }

    @Test
    public void testDeleteAtIndex(){
        seatingChartModel.deleteAtIndex(1,1);
        assertEquals(seatingChartModel.getAtIndex(1,1 ), "");
    }

    @Test
    public void testExpand() {
        seatingChartModel.expand();
        assertEquals(seatingChartModel.getAtIndex(1,2), "");
    }

    @Test
    //todo : fix
    public void testShrink() {
        seatingChartModel.shrink();
        assertEquals(seatingChartModel.getAtIndex(0,1), "");
    }






}
