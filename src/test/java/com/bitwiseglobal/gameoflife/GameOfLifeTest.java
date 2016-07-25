package test.java.com.bitwiseglobal.gameoflife;

import org.junit.Before;
import org.junit.Test;
import main.java.com.bitwiseglobal.gameoflife.GameOfLife;

import static junit.framework.TestCase.assertEquals;


public class GameOfLifeTest {

    private GameOfLife gameOfLife;

    @Before
    public void before() {
        gameOfLife = new GameOfLife(4, 8);
    }

    @Test
    public void itShouldNotFindLivingNeighboursIfGridIsEmpty() {
        int neighboursCount = gameOfLife.countLivingNeighbours(1, 4);
        assertEquals(0, neighboursCount);
    }

    @Test
    public void itShouldFindOneLivingNeighbour() {
        gameOfLife.setLivingCell(0, 3);
        int neighboursCount = gameOfLife.countLivingNeighbours(1, 4);
        assertEquals(1, neighboursCount);
    }

    @Test
    public void itShouldFindTwoLivingNeighbours() {
        gameOfLife.setLivingCell(0, 3);
        gameOfLife.setLivingCell(1, 5);
        int neighboursCount = gameOfLife.countLivingNeighbours(1, 4);
        assertEquals(2, neighboursCount);
    }

    @Test
    public void itShouldFindThreeLivingNeighbours() {
        gameOfLife.setLivingCell(0, 3);
        gameOfLife.setLivingCell(1, 5);
        gameOfLife.setLivingCell(1, 3);
        int neighboursCount = gameOfLife.countLivingNeighbours(1, 4);
        assertEquals(3, neighboursCount);
    }

    @Test
    public void itShouldFindFourLivingNeighbours() {
        gameOfLife.setLivingCell(0, 3);
        gameOfLife.setLivingCell(1, 5);
        gameOfLife.setLivingCell(1, 3);
        gameOfLife.setLivingCell(2, 4);
        int neighboursCount = gameOfLife.countLivingNeighbours(1, 4);
        assertEquals(4, neighboursCount);
    }

    @Test
    public void itShouldFindFiveLivingNeighbours() {
        gameOfLife.setLivingCell(0, 3);
        gameOfLife.setLivingCell(1, 5);
        gameOfLife.setLivingCell(1, 3);
        gameOfLife.setLivingCell(2, 4);
        gameOfLife.setLivingCell(2, 3);
        int neighboursCount = gameOfLife.countLivingNeighbours(1, 4);
        assertEquals(5, neighboursCount);
    }

    @Test
    public void itShouldFindSixLivingNeighbours() {
        gameOfLife.setLivingCell(0, 3);
        gameOfLife.setLivingCell(1, 5);
        gameOfLife.setLivingCell(1, 3);
        gameOfLife.setLivingCell(2, 4);
        gameOfLife.setLivingCell(2, 3);
        gameOfLife.setLivingCell(0, 4);
        int neighboursCount = gameOfLife.countLivingNeighbours(1, 4);
        assertEquals(6, neighboursCount);
    }

    @Test
    public void itShouldFindSevenLivingNeighbours() {
        gameOfLife.setLivingCell(0, 3);
        gameOfLife.setLivingCell(1, 5);
        gameOfLife.setLivingCell(1, 3);
        gameOfLife.setLivingCell(2, 4);
        gameOfLife.setLivingCell(2, 3);
        gameOfLife.setLivingCell(0, 4);
        gameOfLife.setLivingCell(0, 5);
        int neighboursCount = gameOfLife.countLivingNeighbours(1, 4);
        assertEquals(7, neighboursCount);
    }

    @Test
    public void itShouldFindEightLivingNeighbours() {
        gameOfLife.setLivingCell(0, 3);
        gameOfLife.setLivingCell(1, 5);
        gameOfLife.setLivingCell(1, 3);
        gameOfLife.setLivingCell(2, 4);
        gameOfLife.setLivingCell(2, 3);
        gameOfLife.setLivingCell(0, 4);
        gameOfLife.setLivingCell(0, 5);
        gameOfLife.setLivingCell(2, 5);

        int neighboursCount = gameOfLife.countLivingNeighbours(1, 4);
        assertEquals(8, neighboursCount);
    }


    @Test
    public void itShouldFindThreeLivingCellForTheTopLeftCornerCell() {
        gameOfLife.setLivingCell(0, 1);
        gameOfLife.setLivingCell(1, 1);
        gameOfLife.setLivingCell(1, 0);

        int neighboursCount = gameOfLife.countLivingNeighbours(0, 0);
        assertEquals(3, neighboursCount);
    }

    @Test
    public void itShouldFindThreeLivingCellForTheBottomRightCornerCell() {
        gameOfLife.setLivingCell(2, 6);
        gameOfLife.setLivingCell(3, 6);
        gameOfLife.setLivingCell(2, 7);

        int neighboursCount = gameOfLife.countLivingNeighbours(3, 7);
        assertEquals(3, neighboursCount);
    }

    @Test
    public void itShouldKillACellWithFewerThanTwoNeighbours() {
        gameOfLife.setLivingCell(0, 0);
        gameOfLife.setLivingCell(0, 1);
        gameOfLife.findNextGeneration();

        assertEquals(true, gameOfLife.isDead(0, 0));


    }

    @Test
    public void itShouldKeepACellWithTwoOrThreeNeighbours() {
        gameOfLife.setLivingCell(0, 0);
        gameOfLife.setLivingCell(0, 1);
        gameOfLife.findNextGeneration();

        assertEquals(true, gameOfLife.isAlive(1, 1));

    }

    @Test
    public void itShouldKillACellWithMoreThanThreeNeighbours() {
        gameOfLife.setLivingCell(0, 0);
        gameOfLife.setLivingCell(0, 1);
        gameOfLife.setLivingCell(1, 2);
        gameOfLife.setLivingCell(2, 1);

        gameOfLife.findNextGeneration();

        assertEquals(true, gameOfLife.isDead(1, 1));

    }

    @Test
    public void itShouldKeepACellWithExactlyThreeNeighbours() {

        gameOfLife.setLivingCell(0, 0);
        gameOfLife.setLivingCell(0, 1);
        gameOfLife.setLivingCell(1, 2);

        gameOfLife.findNextGeneration();

        assertEquals(true, gameOfLife.isAlive(1, 1));

    }
}







