package swen222.piece;

import swen222.player.Player;
import swen222.player.Player.Colour;


/**
 * 
 * The Piece class extends the Item abstract class and is centralized
 * around the letter of the piece. The class holds information about
 * a piece.
 * 
 * @author Charnon
 *
 */
public class Piece extends Item{

	private String name;
	private Colour colour;
	private Item top;
	private Item right;
	private Item bot;
	private Item left;
	private int row;
	private int col;
	
	
	public Piece(String name, Colour colour, Item top, Item right, Item bot, Item left) {
		this.name = name;
		this.colour = colour;
		this.top = top;
		this.right = right;
		this.bot = bot;
		this.left = left;
	}


	public String getName() {
		return name;
	}

	public Colour getColour() {
		return colour;
	}

	public Item getTop() {
		return top;
	}

	public Item getRight() {
		return right;
	}

	public Item getBot() {
		return bot;
	}

	public Item getLeft() {
		return left;
	}


	public void setTop(Item top) {
		this.top = top;
	}


	public void setRight(Item right) {
		this.right = right;
	}


	public void setBot(Item bot) {
		this.bot = bot;
	}


	public void setLeft(Item left) {
		this.left = left;
	}


	public int getRow() {
		return row;
	}


	public void setRow(int row) {
		this.row = row;
	}


	public int getCol() {
		return col;
	}


	public void setCol(int col) {
		this.col = col;
	}
	
	
	
	
	
	
	
	
}