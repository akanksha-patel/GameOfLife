package main.java.com.bitwiseglobal.gameoflife;
import java.util.Arrays;

public class GameOfLife {

    private static final int DEAD_CELL = 0;
    private static final int ALIVE_CELL = 1;
    private int grid[][];
    private int rowCount;
    private int colCount;

    public GameOfLife(int row, int col) {
        grid = new int[row][col];
        this.rowCount = grid.length;
        this.colCount = grid[0].length;
        for (int i = 0; i < this.rowCount; i++)
            Arrays.fill(grid[i], DEAD_CELL);
    }

    public int countLivingNeighbours(int row, int column) {
        int cellsToCheck[][] = {
                { row - 1, column - 1 },
                { row - 1, column },
                { row - 1, column + 1 },
                { row, column + 1 },
                { row + 1, column + 1 },
                { row + 1, column },
                { row + 1, column - 1 },
                { row, column - 1 }
        };

        int livingNeighbours = calcLivingCells(cellsToCheck);
        return livingNeighbours;
    }

    public int calcLivingCells(int[][] cellsToCheck){
        int livingNeighbours = 0;
        for (int i = 0; i < cellsToCheck.length; i++) {
            int rowToCheck = cellsToCheck[i][0];
            int columnToCheck = cellsToCheck[i][1];

            if (isInTheGrid(rowToCheck, columnToCheck) && isAlive(rowToCheck, columnToCheck)) {
                livingNeighbours++;
            }
        }
        return livingNeighbours;
    }

    public boolean isAlive(int row, int col) {
        return grid[row][col] == ALIVE_CELL;
    }

    private boolean isInTheGrid(int row, int col) {
        return row >= 0 && col >= 0 && row < rowCount && col < colCount;
    }

    public boolean isDead(int row, int col) {
        return grid[row][col] == DEAD_CELL;
    }

    public void setLivingCell(int row, int col) {
        grid[row][col] = ALIVE_CELL;
    }

    public void findNextGeneration() {
        int nextGeneration[][] = new int[rowCount][colCount];
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                if (isAlive(i, j)&& countLivingNeighbours(i, j) < 2)
                    nextGeneration[i][j] = DEAD_CELL;
                else if ((countLivingNeighbours(i, j) == 2 || countLivingNeighbours(i, j) == 3))
                    nextGeneration[i][j] = ALIVE_CELL;
                else if (isAlive(i, j) && countLivingNeighbours(i, j) > 3)
                    nextGeneration[i][j] = DEAD_CELL;
                else if (isDead(i, j) && countLivingNeighbours(i, j) == 3)
                    nextGeneration[i][j] = ALIVE_CELL;
                else
                    nextGeneration[i][j] = grid[i][j];
            }
        }
        grid = nextGeneration.clone();
    }


}
