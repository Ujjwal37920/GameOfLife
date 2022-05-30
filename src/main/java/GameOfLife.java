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

    public static void main(String[] args) {
        Grid grid = new Grid();
        grid.addCell(new Cell(1,1));
        grid.addCell(new Cell(1,2));
        grid.addCell(new Cell(2,1));
        grid.addCell(new Cell(2,2));
        grid.addCell(new Cell(3,1));
        grid.addCell(new Cell(5,5));
        GameOfLife gameOfLife = new GameOfLife(grid);

        System.out.println("Neighbors of cell 2,1");
        List<Cell> allNeighbors = grid.getAllNeighbours(new Cell(2,1));
        for(Cell cell: allNeighbors){
            System.out.println("X coordinate: " + cell.xCoordinate + "  ,Y coordinate: " +  cell.yCoordinate);
        }

        List<Cell> allAliveNeighbours = grid.getAllAliveNeighbours(new Cell(2,1));
        for(Cell cell: allAliveNeighbours){
            System.out.println("X coordinate: " + cell.xCoordinate + "  ,Y coordinate: " +  cell.yCoordinate);
        }

        Grid newGrid = gameOfLife.nextIteration();

        for(Cell cell: newGrid.cells){
            System.out.println("X coordinate: " + cell.xCoordinate + "  ,Y coordinate: " +  cell.yCoordinate);
        }



    }
}



