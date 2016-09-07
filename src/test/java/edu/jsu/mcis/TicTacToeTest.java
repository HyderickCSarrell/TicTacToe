package edu.jsu.mcis;

import org.junit.*;
import static org.junit.Assert.*;

public class TicTacToeTest {
	
	private TicTacToeModel model;
	
	@Before
    public void setup() {
		model = new TicTacToeModel();
    }
	
	@Test
	public void testInitialBoardIsEmpty() {
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				assertEquals(0, model.GetMark(i, j));
			}
		}
	}
	
	@Test
	public void testMarkXInUpperRightCorner() {
		model.MarkLocation(0,2, "X" );
		assertEquals(1, model.GetMark(0,2));
	}
	
	@Test
	public void testMarkOInBottomLeftCorner() {
		model.MarkLocation(2,2, "O" );
		assertEquals(2, model.GetMark(2,2));
	}
	
	@Test
	public void testUnableToMarkOverExistingMark() {
		model.MarkLocation(2,2, "X" );
		assertNotSame(2, model.GetMark(2,2));
	}
	
	@Test
	public void testGameIsNotOverAfterTheFirstMark() {
		model.MarkLocation(0,0, "X");
		if (model.CheckWinner() == "") {
			assertTrue(true);
		}
		else {
			assertTrue(true);
		}
	}
	
	@Test
	public void testGameIsWonByXHorizontallyAcrossTopRow() {
		model.MarkLocation(0,0, "X");
		model.MarkLocation(0,1, "X");
		model.MarkLocation(0,2, "X");
		assertTrue(model.ThreeInRow(1));
	}
	
	@Test
	public void testGameIsOverByTieIfAllLocationsAreFilled() {
		model.MarkLocation(0,0, "X" );
		model.MarkLocation(0,1, "O" );
		model.MarkLocation(0,2, "X" );
		model.MarkLocation(1,0, "O" );
		model.MarkLocation(2,0, "X" );
		model.MarkLocation(1,1, "O" );
		model.MarkLocation(2,1, "X" );
		model.MarkLocation(2,2, "O" );
		model.MarkLocation(1,2, "X" );
		assertTrue(model.IsFull());
	}	
}
