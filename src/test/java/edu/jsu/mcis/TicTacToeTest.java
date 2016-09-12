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
				assertEquals(true, model.isEmpty());
			}
		}
	}
	
	@Test
	public void testMarkXInUpperRightCorner() {
		model.markLocation(0,2, "X" );
		assertEquals(1, model.getMark(0,2));
	}
	
	@Test
	public void testMarkOInBottomLeftCorner() {
		model.clearBoard();
		model.markLocation(2,2, "O" );
		assertEquals(2, model.getMark(2,2));
	}
	
	@Test
	public void testUnableToMarkOverExistingMark() {
		model.clearBoard();
		model.markLocation(2,2, "X");
		assertNotSame(2, model.getMark(2,2));
	}
	
	@Test
	public void testGameIsNotOverAfterTheFirstMark() {
		model.clearBoard();
		model.markLocation(0,0, "X");
		assertEquals("", model.checkWinner());
		/*
		if (model.checkWinner() == "") {
			assertTrue(true);
		}
		else {
			assertTrue(true);
		}
		*/
	}
	
	@Test
	public void testGameIsWonByXHorizontallyAcrossTopRow() {
		model.clearBoard();
		model.markLocation(0,0, "X");
		model.markLocation(0,1, "X");
		model.markLocation(0,2, "X");
		assertEquals("X",model.checkWinner());
	}
	
	@Test
	public void testGameIsOverByTieIfAllLocationsAreFilled() {
		model.clearBoard();
		model.markLocation(0,0, "X" );
		model.markLocation(0,1, "O" );
		model.markLocation(0,2, "X" );
		model.markLocation(1,0, "O" );
		model.markLocation(2,0, "X" );
		model.markLocation(1,1, "O" );
		model.markLocation(2,1, "X" );
		model.markLocation(2,2, "O" );
		model.markLocation(1,2, "X" );
		assertTrue(model.isFull());
	}	
}
