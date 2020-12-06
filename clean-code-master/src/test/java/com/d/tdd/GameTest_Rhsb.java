/**
 * 
 */
package com.d.tdd;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class GameTest_Rhsb
{
	Game_Rhsb game = new Game_Rhsb();
	
	@Test
	void testAll0s()
	{		
		rollMultipleTimes(0, 20);
		
		assertEquals(0, game.score());
	}
	
	@Test
	void testAll1s()
	{		
		rollMultipleTimes(1, 20);
		
		assertEquals(20, game.score());
	}
	
	@Test
	void testHalf1sAndHalf2s()
	{		
		rollMultipleTimes(1, 10);
		rollMultipleTimes(2, 10);
		
		assertEquals(30, game.score());
	}
	
	@Test
//	@Disabled
	void testSpare()
	{		
		rollASpare();
		rollMultipleTimes(1, 18);
		
		assertEquals(29, game.score());
	}
	
	@Test
	void test2Spares()
	{		
		rollASpare();
		rollASpare();
		rollMultipleTimes(1, 16);
		
		assertEquals(42, game.score());
	}
	
	@Test
	void testStrike()
	{
		game.roll(10);
		rollMultipleTimes(1, 18);
		
		assertEquals(30, game.score());
	}

	public void rollASpare()
	{
		rollMultipleTimes(5, 2);
	}
	
	public void rollMultipleTimes(int pinsKnockedDown, int noOfTimes)
	{
		for (int i = 1; i <= noOfTimes; i++)
		{
			game.roll(pinsKnockedDown);
		}
	}
}
