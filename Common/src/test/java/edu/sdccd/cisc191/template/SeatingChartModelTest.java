package edu.sdccd.cisc191.template;

import edu.sdccd.cisc191.template.SeatingChartModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SeatingChartModelTest {
    private SeatingChartModel seatingChartModel;

    @BeforeEach
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

        String output = "";
        output = seatingChartModel.findIndexOf("Essie");

        assertEquals(output, "1, 0");

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
