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

    @Test
    public void testFindIndexOf() {
        int[] answer = new int[2];
        answer[0] = 1;
        answer[1] = 0;
        int[] output = seatingChartModel.findIndexOf("Essie");

        assertEquals(output[0], answer[0]);
        assertEquals(output[1], answer[1]);

    }

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
        assertEquals(seatingChartModel.getYDimension(), 2);
        seatingChartModel.shrink();
        assertEquals(seatingChartModel.getYDimension(), 1);
    }

    @Test
    public void testToString() {
        seatingChartModel.toString();
        assertEquals(seatingChartModel.toString(), "[[Andy, Isa], [Essie, Bella]]");
    }






}
