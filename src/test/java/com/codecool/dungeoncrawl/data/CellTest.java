package com.codecool.dungeoncrawl.data;

import com.codecool.dungeoncrawl.data.actors.Actor;
import com.codecool.dungeoncrawl.data.items.Item;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class CellTest {
    private Cell cell;
    private GameMap gameMap;
    @Mock
    Item item;
    @Mock
    Actor actor;

    @BeforeEach
    public void setUp() {
        gameMap = new GameMap(10, 10, CellType.FLOOR, null);
        cell = new Cell(gameMap, 5, 5, CellType.FLOOR);
    }

    @Test
    public void testGetType() {
        assertEquals(CellType.FLOOR, cell.getType());
    }

    @Test
    public void testSetType() {
        cell.setType(CellType.WALL);
        assertEquals(CellType.WALL, cell.getType());
    }

    @Test
    public void testSetActor() {
        cell.setActor(actor);
        assertEquals(actor, cell.getActor());
    }

    @Test
    public void testSetItem() {
        cell.setItem(item);
        assertEquals(item, cell.getItem());
    }

    @Test
    public void testGetNeighbor() {
        Cell neighbor = gameMap.getCell(6, 5);
        assertEquals(neighbor, cell.getNeighbor(1, 0));
    }

    @Test
    public void testGetTileName() {
        assertEquals("floor", cell.getTileName());
    }

    @Test
    public void testGetX() {
        assertEquals(5, cell.getX());
    }

    @Test
    public void testGetY() {
        assertEquals(5, cell.getY());
    }

    @Test
    public void testOutOfRange() {
        assertFalse(cell.outOfRange());
    }

    @Test
    public void testIsDoor() {
        assertFalse(cell.isDoor());
    }

    @Test
    public void testGetGameMap() {
        assertEquals(gameMap, cell.getGameMap());
    }
}