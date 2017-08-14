package swen222.test;
import static org.junit.Assert.fail;

import org.junit.Test;

import swen222.game.TextInterface;

public class Tests {

	@Test
	public void test_create_1() {

		TextInterface ti = new TextInterface();

		ti.parseUserInput(ti.getBoard(), "should not work");

		if(!ti.getBoard().getGrid()[7][7].getName().equals(" ")) {
			fail("Invalid command. The creation grid should be empty");
		}

	}

	@Test
	public void test_create_2() {

		TextInterface ti = new TextInterface();

		ti.parseUserInput(ti.getBoard(), " ");

		if(!ti.getBoard().getGrid()[7][7].getName().equals(" ")) {
			fail("Empty command. The creation grid should be empty");
		}

	}

	@Test
	public void test_create_3() {

		TextInterface ti = new TextInterface();

		ti.parseUserInput(ti.getBoard(), "create a 100");

		if(!ti.getBoard().getGrid()[7][7].getName().equals(" ")) {
			fail("Invalid rotation. The creation grid should be empty");
		}

	}

	@Test
	public void test_create_4() {

		TextInterface ti = new TextInterface();

		ti.parseUserInput(ti.getBoard(), "create abd 100");

		if(!ti.getBoard().getGrid()[7][7].getName().equals(" ")) {
			fail("Invalid letter. The creation grid should be empty");
		}

	}

	@Test
	public void test_create_5() {

		TextInterface ti = new TextInterface();

		ti.parseUserInput(ti.getBoard(), "sad a 100");

		if(!ti.getBoard().getGrid()[7][7].getName().equals(" ")) {
			fail("Invalid action. The creation grid should be empty");
		}

	}

	@Test
	public void test_create_6() {

		TextInterface ti = new TextInterface();

		ti.parseUserInput(ti.getBoard(), "create a 0");

		if(!ti.getBoard().getGrid()[7][7].getName().equals("a")) {
			fail("Valid command. Should return a letter");
		}

	}

	@Test
	public void test_create_7() {
		TextInterface ti = new TextInterface();

		ti.parseUserInput(ti.getBoard(), "create a 0");
		ti.parseUserInput(ti.getBoard(), "move a right");
		ti.parseUserInput(ti.getBoard(), "create a 0");
		if(!ti.getBoard().getGrid()[7][7].getName().equals(" ")) {
			fail("Cannot recreate two of the same piece");
		}
	}

	@Test
	public void test_move_1() {

		TextInterface ti = new TextInterface();

		ti.parseUserInput(ti.getBoard(), "move a right");

		if(!ti.getBoard().getGrid()[7][10].getName().equals("a")) {
			fail("Invalid. A piece cant be moved unless it has been made");
		}

	}

	@Test
	public void test_move_2() {

		TextInterface ti = new TextInterface();

		ti.parseUserInput(ti.getBoard(), "move a down");

		if(!ti.getBoard().getGrid()[10][7].getName().equals("a")) {
			fail("Invalid. A piece cant be moved unless it has been made");
		}

	}

	@Test
	public void test_move_3() {

		TextInterface ti = new TextInterface();

		ti.parseUserInput(ti.getBoard(), "move a left");

		if(!ti.getBoard().getGrid()[7][4].getName().equals("a")) {
			fail("Invalid. A piece cant be moved unless it has been made");
		}

	}

	@Test
	public void test_move_4() {

		TextInterface ti = new TextInterface();

		ti.parseUserInput(ti.getBoard(), "move a up");

		if(!ti.getBoard().getGrid()[4][7].getName().equals("a")) {
			fail("Invalid. A piece cant be moved unless it has been made");
		}

	}

	@Test
	public void test_move_5() {

		TextInterface ti = new TextInterface();
		ti.parseUserInput(ti.getBoard(), "create a 0");
		ti.parseUserInput(ti.getBoard(), "move a right");

		if(!ti.getBoard().getGrid()[7][10].getName().equals("a")) {
			fail("Piece 'a' should be here has a right move command is executed");
		}

	}

	@Test
	public void test_move_6() {

		TextInterface ti = new TextInterface();
		ti.parseUserInput(ti.getBoard(), "create a 0");
		ti.parseUserInput(ti.getBoard(), "move a left");

		if(!ti.getBoard().getGrid()[7][4].getName().equals("a")) {
			fail("Piece 'a' should be here has a left move command is executed");
		}

	}

	@Test
	public void test_move_7() {

		TextInterface ti = new TextInterface();
		ti.parseUserInput(ti.getBoard(), "create a 0");
		ti.parseUserInput(ti.getBoard(), "move a down");

		if(!ti.getBoard().getGrid()[10][7].getName().equals("a")) {
			fail("Piece 'a' should be here has a down move command is executed");
		}

	}

	@Test
	public void test_move_8() {

		TextInterface ti = new TextInterface();
		ti.parseUserInput(ti.getBoard(), "create a 0");
		ti.parseUserInput(ti.getBoard(), "move a up");

		if(!ti.getBoard().getGrid()[4][7].getName().equals("a")) {
			fail("Piece 'a' should be here has a up move command is executed");
		}

	}

	@Test
	public void test_rotate_1() {

		TextInterface ti = new TextInterface();

		ti.parseUserInput(ti.getBoard(), "rotate a 0");

		if(!ti.getBoard().getGrid()[7][7].toString().equals("a-#--")) {
			fail("Invalid. Cant rotate a piece unless it has been created");
		}

	}

	@Test
	public void test_rotate_2() {

		TextInterface ti = new TextInterface();
		ti.parseUserInput(ti.getBoard(), "create a 0");
		ti.parseUserInput(ti.getBoard(), "rotate a 90");

		if(!ti.getBoard().getGrid()[7][7].toString().equals("a-#--")) {
			fail("Invalid. The rotation must be <1/2/3/4>");
		}

	}


	@Test
	public void test_rotate_3() {

		TextInterface ti = new TextInterface();
		ti.parseUserInput(ti.getBoard(), "create a 0");
		ti.parseUserInput(ti.getBoard(), "rotate a 1");

		if(!ti.getBoard().getGrid()[7][7].toString().equals("a--#-")) {
			fail("The toString() should be right");
		}

	}

	@Test
	public void test_rotate_4() {

		TextInterface ti = new TextInterface();
		ti.parseUserInput(ti.getBoard(), "create a 0");
		ti.parseUserInput(ti.getBoard(), "rotate a 2");

		if(!ti.getBoard().getGrid()[7][7].toString().equals("a---#")) {
			fail("The toString() should be right");
		}

	}

	@Test
	public void test_rotate_5() {

		TextInterface ti = new TextInterface();
		ti.parseUserInput(ti.getBoard(), "create a 0");
		ti.parseUserInput(ti.getBoard(), "rotate a 3");

		if(!ti.getBoard().getGrid()[7][7].toString().equals("a#---")) {
			fail("The toString() should be right");
		}

	}

	@Test
	public void test_rotate_6() {

		TextInterface ti = new TextInterface();
		ti.parseUserInput(ti.getBoard(), "create a 0");
		ti.parseUserInput(ti.getBoard(), "rotate a 4");

		if(!ti.getBoard().getGrid()[7][7].toString().equals("a-#--")) {
			fail("The toString() should be right");
		}

	}










}
