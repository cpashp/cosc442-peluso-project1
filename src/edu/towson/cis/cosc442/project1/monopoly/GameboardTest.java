package edu.towson.cis.cosc442.project1.monopoly;

import junit.framework.TestCase;


public class GameboardTest extends TestCase {

	Cell cell;
	GameBoard gameBoard;
	
	protected void setUp() throws Exception {
		gameBoard = new GameBoard();
		cell();
	}

	private void cell() {
		cell = new PropertyCell();
		cell.setName("TempCell");
	}

	public void testAddCell() {
		assertEquals(1, gameBoard.getCellNumber());
		gameBoard.addCell(cell);
		assertEquals(2, gameBoard.getCellNumber());
	}
	
	public void testCellsForMonopoly() {
		GameBoard gb = new SimpleGameBoard();
		PropertyCell[] properties = gb.getPropertiesInMonopoly("blue");
		assertEquals("Blue 1", properties[0].getName());
		assertEquals("Blue 2", properties[1].getName());
		assertEquals("Blue 3", properties[2].getName());
		assertEquals(3, properties.length);
	}
	
	public void testPropertyNumberForColor() {
		PropertyCell cell1 = cell1();
		cell1.setColorGroup("blue");
		PropertyCell cell2 = cell2();
		cell2.setColorGroup("blue");
		PropertyCell cell3 = cell3();
		cell3.setColorGroup("green");
		
		gameBoard.addCell(cell1);
		gameBoard.addCell(cell2);
		gameBoard.addCell(cell3);
		assertEquals(2, gameBoard.getPropertyNumberForColor("blue"));
		assertEquals(1, gameBoard.getPropertyNumberForColor("green"));
	}

	private PropertyCell cell3() {
		PropertyCell cell3 = new PropertyCell();
		cell3.setName("Green 1");
		cell3.setColorGroup("green");
		return cell3;
	}

	private PropertyCell cell2() {
		PropertyCell cell2 = new PropertyCell();
		cell2.setName("Blue 2");
		cell2.setColorGroup("blue");
		return cell2;
	}

	private PropertyCell cell1() {
		PropertyCell cell1 = new PropertyCell();
		cell1.setName("Blue 1");
		cell1.setColorGroup("blue");
		return cell1;
	}
	
	public void testQueryCell() {
		gameBoard.addCell(cell);
		assertSame(cell,gameBoard.queryCell("TempCell"));
	}
	
	public void testQueryCellIndex() {
		gameBoard.addCell(cell);
		assertEquals(0,gameBoard.queryCellIndex("Go"));
		assertEquals(1,gameBoard.queryCellIndex("TempCell"));
	}
}
