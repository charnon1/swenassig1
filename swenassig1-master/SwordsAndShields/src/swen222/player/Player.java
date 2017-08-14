package swen222.player;

import swen222.piece.Item;

/**
 * 
 * The Player class extends the Item class. The Yellow player
 * is "0" and the Green player is "1".
 * 
 * @author Charnon
 *
 */

public class Player extends Item {

	private Colour colour;
	private String name;
	

	public enum Colour{
		YELLOW,
		GREEN
	}

	public Player(String name, Colour colour) {
		this.name = name;
		this.colour = colour;
	}

	public Colour getColour() {
		return colour;
	}

	public String getName() {
		return name;
	}



}
