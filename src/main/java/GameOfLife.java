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
            List<Cell> possibleAliveCells = grid.getAllNeighbours(cell);
            for(Cell possibleAliveCell: possibleAliveCells){
                List<Cell> possibleNeighbour = grid.getAllAliveNeighbours(possibleAliveCell);
                if(possibleNeighbour.size()==3 && !grid.isAlive(possibleAliveCell)){
                    newGrid.addCell(possibleAliveCell);
                }
            }
            List<Cell> neighbours =  grid.getAllAliveNeighbours(cell);
            numberOfNeighbours = neighbours.size();
            if(willRemainAlive(numberOfNeighbours)) {
                newGrid.addCell(cell);

            }

        }
        return newGrid;
    }

    private boolean willRemainAlive(int numberOfNeighbours) {
        return 2 <= numberOfNeighbours & numberOfNeighbours <= 3;
    }
}
