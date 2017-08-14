import static org.junit.Assert.fail;

import org.junit.Test;

import swen222.game.TextInterface;

public class Tests {

	@Test
	public void test() {
		TextInterface ti = new TextInterface();
		ti.parseUserInput(ti.getBoard(), "should not work");
		if(!ti.getBoard().getGrid()[4][4].getName().equals(" ")) {
			fail("The creation grid should be empty");
		}
		
	}
	
	@Test
	public void test2() {
		TextInterface ti = new TextInterface();
		ti.parseUserInput(ti.getBoard(), "should not work");
		if(!ti.getBoard().getGrid()[4][4].getName().equals(" ")) {
			fail("The creation grid should be empty");
		}
		
	}
	
	

}
