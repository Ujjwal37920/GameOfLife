import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class GridTest {

    @Test
    void shouldReturnZeroNeighbours() {
        Grid grid = new Grid();
        grid.addCell(new Cell(0,0));

        List<Cell> getNeighbours = grid.getNeighbours(new Cell(0,0));

        assertEquals(0, getNeighbours.size());
    }

    @Test
    void twoCellsNextToEachOtherShouldBeNeigbours() {
        Grid grid = new Grid();
        grid.addCell(new Cell(0,0));
        grid.addCell(new Cell(1,0));

        List<Cell> firstCellNeighbour =  grid.getNeighbours(new Cell(0,0));
        List<Cell> secondCellNeighbour = grid.getNeighbours(new Cell(1,0));

        assertArrayEquals(new Cell[]{new Cell(1,0)}, firstCellNeighbour.toArray());
        assertArrayEquals(new Cell[]{new Cell(0,0)}, secondCellNeighbour.toArray());
    }

    @Test
    void twoCellsFarFromEachOtherShouldNotBeNeighbour() {
        Grid grid = new Grid();
        Cell firstCell = new Cell(0, 0);
        Cell secondCell = new Cell(5, 5);

        grid.addCell(firstCell);
        grid.addCell(secondCell);

        List<Cell> firstCellNeighbour = grid.getNeighbours(firstCell);

        assertEquals(0, firstCellNeighbour.size());
    }

    @Test
    void shouldReturn8NeighboursWhenACellWith8AliveNeighboursIsCreated() {
        Grid grid = new Grid();
        Cell cell = new Cell(4, 4);
        for(int i=-1;i<2;i++){
            for(int j=-1;j<2;j++){
                grid.addCell(new Cell(cell.xCoordinate+i, cell.yCoordinate+j));
            }
        }

        List<Cell> neighbours = grid.getNeighbours(cell);

        assertEquals(8,neighbours.size());
    }

    @Test
    void shouldReturnExactNeighbourCellsWhenACellWith8AliveNeighboursIsCreated() {
        Grid grid = new Grid();
        Cell cell = new Cell(4, 4);
        List<Cell> expectedNeighbours = new ArrayList<>();
        for(int i=-1;i<2;i++){
            for(int j=-1;j<2;j++){
                grid.addCell(new Cell(cell.xCoordinate+i, cell.yCoordinate+j));
                if(i!=0 && j!=0) {
                    expectedNeighbours.add(new Cell(cell.xCoordinate + j, cell.yCoordinate + i));
                }
            }
        }
        System.out.println(expectedNeighbours.size());
        List<Cell> neighbours = grid.getNeighbours(cell);
        assertTrue(neighbours.containsAll(expectedNeighbours));
    //    assertArrayEquals(expectedNeighbours.toArray(), neighbours.toArray());
    }
}
