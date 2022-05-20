import java.util.ArrayList;
import java.util.List;

public class GameOfLife {
    public Grid grid;

    public GameOfLife(Grid newGrid) {
        this.grid = newGrid;
    }

    public Grid nextIteration() {
        Grid newGrid=new Grid();
        for(Cell cell: grid.cells){
            int numberOfNeighbours = 0;
            List<Cell> neighbours =  grid.getNeighbours(cell);
            numberOfNeighbours = neighbours.size();
            if(willRemainAlive(numberOfNeighbours)) {
                newGrid.addCell(cell);

            }

            System.out.println(cell.xCoordinate);
            System.out.println(cell.yCoordinate);
            System.out.println(numberOfNeighbours);
            System.out.println();


        }
        return newGrid;
    }

    private boolean willRemainAlive(int numberOfNeighbours) {
        return 2 <= numberOfNeighbours & numberOfNeighbours <= 3;
    }
}
