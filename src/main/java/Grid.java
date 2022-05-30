import java.util.*;

public class Grid {
    public Set<Cell> cells = new HashSet<>();

    public void addCell(Cell cell) {
        cells.add(cell);
    }

    public List<Cell> getAllAliveNeighbours(Cell cell) {

        List<Cell> neighbours = new ArrayList<>();
        List<Cell> allNeighbours = getAllNeighbours(cell);
        for(Cell newCell: allNeighbours){
            if(isAlive(newCell)){
                neighbours.add(newCell);
            }
        }
        return neighbours;
    }

public List<Cell> getAllNeighbours(Cell cell){
    List<Cell> neighbours = new ArrayList<>();
    int cellXCoordinate = cell.xCoordinate;
    int cellYCoordinate = cell.yCoordinate;
    for(int dy=-1;dy<2;dy++) {
        for (int dx = -1; dx < 2; dx++) {
            Cell newCell = new Cell(cellXCoordinate + dx, cellYCoordinate + dy);
            if ( !cell.equals(newCell) ){
                neighbours.add(newCell);

            }
        }

    }
    return neighbours;
}

    public boolean isAlive(Cell newCell) {
        return cells.contains(newCell);
    }


}
