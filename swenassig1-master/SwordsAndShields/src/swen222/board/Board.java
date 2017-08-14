package swen222.board;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

import swen222.game.TextInterface;
import swen222.piece.Item;
import swen222.piece.Piece;
import swen222.piece.Shield;
import swen222.piece.Space;
import swen222.piece.Sword;
import swen222.player.Player;

public class Board {

	public static final int STARTING_YELLOW_SPOT = 10;
	public static final int STARTING_GREEN_SPOT = 25;

	private Item[][] grid = new Item[TextInterface.WIDTH][TextInterface.HEIGHT];
	private ArrayList<Piece> availableYellowPieces = new ArrayList<Piece>();
	private Map<String,Piece> mapOfPieces = new HashMap<String,Piece>();
	private Stack<Item[][]> history = new Stack<Item[][]>();

	/**
	 *
	 * This method initialises the board by filling the 2D grid up
	 * with instances of Space objects.
	 *
	 * @param player1 This is the Yellow player
	 * @param player2 This is the Green player
	 */
	public void initialiseBoard(Player player1, Player player2) {

		//fills the whole grid with Space objects
		for(int row = 0; row < TextInterface.HEIGHT; row++) {
			for(int col = 0; col < TextInterface.WIDTH; col++) {
				this.grid[row][col] = new Space();
			}
		}

		placePlayers(player1,player2);

		//create the available pieces that the players can choose to place on the grid.
		createAvailablePieces();
	}

	/**
	 *
	 * This method simply places the players "0" and "1"
	 * on fix positions on the grid.
	 *
	 * @param player1 This is the Yellow player
	 * @param player2 This is the Green player
	 */
	public void placePlayers(Player player1, Player player2) {

		this.grid[4][4] = player1; //4,4 translates to 1,1 on the grid (row,col)
		this.grid[25][25] = player2; //25,25 translates to 8,8 on the grid (row,col)
	}

	/**
	 *
	 * This method creates and stores all the pieces that the user can pick from.
	 *
	 */
	public void createAvailablePieces() {
		// TODO Auto-generated method stub

		//generating the pieces for Yellow player and adds them to the availableYellowPieces
		Piece a = new Piece( "a", Player.Colour.YELLOW, new Sword(), new Shield(), new Sword(), new Sword() );
		this.availableYellowPieces.add(a);
		this.mapOfPieces.put("a", a);

		Piece b = new Piece( "b", Player.Colour.YELLOW, new Sword(), new Space(), new Sword(), new Sword() );
		this.availableYellowPieces.add(b);
		this.mapOfPieces.put("b", b);

		Piece c = new Piece( "c", Player.Colour.YELLOW, new Shield(), new Shield(), new Shield(), new Shield() );
		this.availableYellowPieces.add(c);
		this.mapOfPieces.put("c", c);

		Piece d = new Piece( "d", Player.Colour.YELLOW, new Sword(), new Space(), new Shield(), new Space() );
		this.availableYellowPieces.add(d);
		this.mapOfPieces.put("d", d);

		Piece e = new Piece( "e", Player.Colour.YELLOW, new Space(), new Space(), new Space(), new Space() );
		this.availableYellowPieces.add(e);
		this.mapOfPieces.put("e", e);

		Piece f = new Piece( "f", Player.Colour.YELLOW, new Sword(), new Shield(), new Shield(), new Sword() );
		this.availableYellowPieces.add(f);
		this.mapOfPieces.put("f", f);

		Piece g = new Piece( "g", Player.Colour.YELLOW, new Sword(), new Sword(), new Sword(), new Sword() );
		this.availableYellowPieces.add(g);
		this.mapOfPieces.put("g", g);

		Piece h = new Piece( "h", Player.Colour.YELLOW, new Sword(), new Space(), new Shield(), new Shield() );
		this.availableYellowPieces.add(h);
		this.mapOfPieces.put("h", h);

		Piece i = new Piece( "i", Player.Colour.YELLOW, new Space(), new Shield(), new Space(), new Space() );
		this.availableYellowPieces.add(i);
		this.mapOfPieces.put("i", i);

		Piece j = new Piece( "j", Player.Colour.YELLOW, new Sword(), new Shield(), new Sword(), new Shield() );
		this.availableYellowPieces.add(j);
		this.mapOfPieces.put("j", j);

		Piece k = new Piece( "k", Player.Colour.YELLOW, new Sword(), new Shield(), new Space(), new Sword() );
		this.availableYellowPieces.add(k);
		this.mapOfPieces.put("k", k);

		Piece l = new Piece( "l", Player.Colour.YELLOW, new Sword(), new Space(), new Space(), new Space() );
		this.availableYellowPieces.add(l);
		this.mapOfPieces.put("l", l);

		Piece m = new Piece( "m", Player.Colour.YELLOW, new Sword(), new Shield(), new Shield(), new Space() );
		this.availableYellowPieces.add(m);
		this.mapOfPieces.put("m", m);

		Piece n = new Piece( "n", Player.Colour.YELLOW, new Space(), new Shield(), new Shield(), new Space() );
		this.availableYellowPieces.add(n);
		this.mapOfPieces.put("n", n);

		Piece o = new Piece( "o", Player.Colour.YELLOW, new Sword(), new Space(), new Sword(), new Shield() );
		this.availableYellowPieces.add(o);
		this.mapOfPieces.put("o", o);

		Piece p = new Piece( "p", Player.Colour.YELLOW, new Sword(), new Space(), new Shield(), new Sword() );
		this.availableYellowPieces.add(p);
		this.mapOfPieces.put("p",p);

		Piece q = new Piece( "q", Player.Colour.YELLOW, new Sword(), new Space(), new Space(), new Shield() );
		this.availableYellowPieces.add(q);
		this.mapOfPieces.put("q", q);

		Piece r = new Piece( "r", Player.Colour.YELLOW, new Sword(), new Shield(), new Space(), new Shield() );
		this.availableYellowPieces.add(r);
		this.mapOfPieces.put("r", r);

		Piece s = new Piece( "s", Player.Colour.YELLOW, new Space(), new Shield(), new Space(), new Shield() );
		this.availableYellowPieces.add(s);
		this.mapOfPieces.put("s",s);

		Piece t = new Piece( "t", Player.Colour.YELLOW, new Sword(), new Space(), new Sword(), new Space() );
		this.availableYellowPieces.add(t);
		this.mapOfPieces.put("t", t);

		Piece u = new Piece( "u", Player.Colour.YELLOW, new Sword(), new Space(), new Space(), new Sword() );
		this.availableYellowPieces.add(u);
		this.mapOfPieces.put("u", u);

		Piece v = new Piece( "v", Player.Colour.YELLOW, new Sword(), new Shield(), new Space(), new Space() );
		this.availableYellowPieces.add(v);
		this.mapOfPieces.put("v", v);

		Piece w = new Piece( "w", Player.Colour.YELLOW, new Sword(), new Shield(), new Shield(), new Shield() );
		this.availableYellowPieces.add(w);
		this.mapOfPieces.put("w", w);

		Piece x = new Piece( "x", Player.Colour.YELLOW, new Space(), new Shield(), new Shield(), new Shield() );
		this.availableYellowPieces.add(x);
		this.mapOfPieces.put("x", x);

	}

	///////////////////////////////////////////////////////////////////////////////////////

	/**
	 *
	 * This method draws the content of the board which includes the labelling
	 * of row and column.
	 *
	 */
	public void drawBoard() {

		for(int row = 0; row < TextInterface.HEIGHT; row++) {

			//draws the label for the rows on the left.
			if(row == 1) {
				System.out.print("0");
			}else if( ((row-1)%3) == 0 ) {
				System.out.print(((row-1)/3));
			}else {
				System.out.print(" ");
			}

			//draws the content of the board
			for(int col =0; col < TextInterface.WIDTH; col++) {
				System.out.print(this.grid[row][col].getName());
			}
			System.out.println("");
		}

		System.out.print(" ");

		//draws the label for the column at the bottom
		for(int col = 0; col < TextInterface.WIDTH; col++) {
			if(col == 1) {
				System.out.print("0");
			}else if( ((col-1)%3)==0 ) {
				System.out.print((col-1)/3);
			}else {
				System.out.print(" ");
			}
		}
		System.out.println("");

		saveState();
	}

	/**
	 *
	 * This places a piece onto the board and fills the surrounding
	 * of the piece with its own properties.
	 *
	 * @param piece This is the piece to be placed on the grid.
	 * @param row This is the row of the letter to be placed.
	 * @param col This is the column of the letter to be placed.
	 */
	public void generatePiece(Piece piece, int row, int col) {
		int adjustedRow = row*3+1;
		int adjustedCol = col*3+1;
		this.grid[adjustedRow][adjustedCol] = piece;
		piece.setRow(row);
		piece.setCol(col);

		this.grid[adjustedRow-1][adjustedCol]= piece.getTop(); //generates the top of the piece on the grid
		this.grid[adjustedRow+1][adjustedCol] = piece.getBot(); //generates the bot of the piece on the grid
		this.grid[adjustedRow][adjustedCol-1] = piece.getLeft(); //generates the left of the piece on the grid
		this.grid[adjustedRow][adjustedCol+1] = piece.getRight(); //generates the right of the piece on the grid

	}


	////////////////////////////////////////////////////////////////////////////////////////

	/**
	 *
	 * This method rotates a given piece 90 degrees clockwise.
	 *
	 * @param piece
	 */
	public void rotatePiece(Piece piece) {

		Item currentTop = piece.getTop();
		Item currentRight = piece.getRight();
		Item currentBot = piece.getBot();
		Item currentLeft = piece.getLeft();

		piece.setTop(currentLeft);
		piece.setRight(currentTop);
		piece.setBot(currentRight);
		piece.setLeft(currentBot);

		generatePiece(piece, 2, 2);

		drawBoard();
	}


	/**
	 *
	 * This method moves a piece in a given direction by generating
	 * a the piece in a new grid and removing the old instance of the piece.
	 *
	 * @param piece The piece to be moved.
	 * @param direction The direction in which the piece moves.
	 */
	public void movePiece(Piece piece, String direction) {

		int currentRow = piece.getRow();
		int currentCol = piece.getCol();

		if(direction.equals("right")) {
			generatePiece(piece,currentRow,currentCol+1);
			removePiece(currentRow,currentCol);

		}else if(direction.equals("down")) {
			generatePiece(piece,currentRow+1, currentCol);
			removePiece(currentRow,currentCol);

		}else if(direction.equals("left")) {
			generatePiece(piece, currentRow, currentCol-1);
			removePiece(currentRow,currentCol);

		}else if(direction.equals("right")) {
			generatePiece(piece,currentRow, currentCol+1);
			removePiece(currentRow,currentCol);
		}


	}

	/**
	 *
	 * This method removes a piece in a given space in the grid.
	 *
	 * @param currentRow The row in which the piece to be removed lies in
	 * @param currentCol The column in which the piece to be removed lies in.
	 */
	public void removePiece(int currentRow, int currentCol) {
		int adjustedRow = currentRow * 3 + 1;
		int adjustedCol = currentCol * 3 + 1;
		this.grid[adjustedRow][adjustedCol] = new Space(); //space out the name/letter
		this.grid[adjustedRow][adjustedCol+1] = new Space(); //space out the right
		this.grid[adjustedRow][adjustedCol-1] = new Space(); //space out the left
		this.grid[adjustedRow-1][adjustedCol] = new Space(); //space out the top
		this.grid[adjustedRow+1][adjustedCol] = new Space(); //space out the bot
		drawBoard();

	}

	/**
	 *
	 * This method pushes the current grid into a stack.
	 *
	 */
	public void saveState() {
		this.history.push(this.grid);
	}

	/////////////////////////////////////////////////////////////////////////////////////////

	public Map<String, Piece> getMap() {
		return this.mapOfPieces;
	}

	public Item[][] getGrid(){
		return this.grid;
	}

	public void setGrid(Item[][] grid) {
		this.grid = grid;
	}

	public Stack<Item[][]> getHistory(){
		return this.history;
	}


}