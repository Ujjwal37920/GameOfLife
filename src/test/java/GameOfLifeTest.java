import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GameOfLifeTest {
    @Test
    void aSingleCellShouldDieInNextIteration() {
        Grid grid = new Grid();
        grid.addCell(new Cell(1,1));
        grid.addCell(new Cell(5,1));
        GameOfLife gameOfLife = new GameOfLife(grid);

        Grid newGrid = gameOfLife.nextIteration();

        assertFalse(newGrid.isAlive(new Cell(5,1)));
    }

    @Test
    void aCellWithMoreThan3neighboursShouldDieInNextIteration() {
        Grid grid = new Grid();
        grid.addCell(new Cell(1,1));
        grid.addCell(new Cell(1,2));
        grid.addCell(new Cell(2,1));
        grid.addCell(new Cell(2,2));
        grid.addCell(new Cell(3,1));
        grid.addCell(new Cell(5,5));
        GameOfLife gameOfLife = new GameOfLife(grid);

        Grid newGrid = gameOfLife.nextIteration();

        assertFalse(newGrid.isAlive(new Cell(2,1)));
    }

    @Test
    void aCellWith2Or3NeighboursShouldLiveInNextIteration() {
        Grid grid = new Grid();
        grid.addCell(new Cell(1,1));
        grid.addCell(new Cell(1,2));
        grid.addCell(new Cell(2,1));
        grid.addCell(new Cell(2,2));
        grid.addCell(new Cell(3,1));
        grid.addCell(new Cell(5,5));
        GameOfLife gameOfLife = new GameOfLife(grid);

        Grid newGrid = gameOfLife.nextIteration();

        assertTrue(newGrid.isAlive(new Cell(1,1)));
    }

    @Test
    void aDeadCellWithExactly3NeighbourShouldComeBackAliveInNextIteration() {
        Grid grid = new Grid();
        grid.addCell(new Cell(1,1));
        grid.addCell(new Cell(1,2));
        grid.addCell(new Cell(2,1));
        grid.addCell(new Cell(2,2));
        grid.addCell(new Cell(3,1));
        grid.addCell(new Cell(5,5));
        GameOfLife gameOfLife = new GameOfLife(grid);

        Grid newGrid = gameOfLife.nextIteration();

        assertTrue(newGrid.isAlive(new Cell(3,2)));
    }



}
