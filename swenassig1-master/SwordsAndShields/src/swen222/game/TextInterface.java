package swen222.game;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

import swen222.board.Board;
import swen222.piece.Piece;
import swen222.player.Player;

/**
 *
 * The TextInterface class stores the main logic of the game and delegates
 * methods to the appropriate classes.
 *
 * @author Charnon
 *
 */
public class TextInterface {

	public static final int WIDTH = 30;
	public static final int HEIGHT = 30;

	private Board board;
	private Player player1;
	private Player player2;
	private ArrayList<Piece> cemetery = new ArrayList<Piece>();
	private String currentCommand = " ";
	private Player playerTurn;



	public TextInterface() {
		this.board = new Board();
		this.player1 = new Player("0", Player.Colour.YELLOW);
		this.player2 = new Player("1", Player.Colour.GREEN);
		this.playerTurn = this.player1;

		initialiseBoard(this.board);// initialize the grid of the board with empty spaces


		while(true) {
			while(!currentCommand.equals("pass")) {
				Scanner reader = new Scanner(System.in);
				System.out.println("Enter a command: ");
				String userInput = reader.nextLine().toLowerCase();
				this.currentCommand = userInput;

				parseUserInput(this.board, userInput);
			}
			this.playerTurn = (this.playerTurn == player1) ? player2 : player1;
			currentCommand = " ";
		}


	}


	/**
	 *
	 * This method takes the user input and looks at the very first
	 * token. The method delegates work to different methods based on
	 * the first token.
	 *
	 * @param board The board that the action will perform on
	 * @param userInput The user input.
	 */
	public boolean parseUserInput(Board board,String userInput) {

		Scanner sc = new Scanner(userInput);

		if(sc.hasNext()) {
			String token = sc.next();
			if( token.equals("create") ) {
				String tokenLine = sc.nextLine();
				parseCreate(tokenLine);

			}else if( token.equals("rotate") ) {
				String tokenLine = sc.nextLine();
				parseRotate(tokenLine);

			}else if( token.equals("move") ) {
				String tokenLine = sc.nextLine();
				parseMove(tokenLine);

			}else if( token.equals("undo") ) {
				parseUndo();

			}else if(token.equals("pass")){

			}
			else {
				System.out.println("Make sure you entered a correct command");
				return false;
			}
		}
		return false;
	}


	/**
	 *
	 * This method decides if the line following the "create" in the
	 * original user input is valid. If yes, the board will generate
	 * the piece.
	 *
	 * @param tokenLine The rest of the usere input after "create".
	 */
	public boolean parseCreate(String tokenLine) {
		System.out.println(tokenLine);
		Scanner lineSc = new Scanner(tokenLine);

		String letter = " ";
		int degree = -1;

		while(lineSc.hasNext()) {
			letter = lineSc.next();

			if(letter.matches("[a-zA-Z]")) { //checks for the letter
				if(lineSc.hasNextInt()  ) { //check for the rotation.
					degree = lineSc.nextInt();

				}else {
					System.out.println("Make sure you include the rotation in the create command");
					return false;
				}
			}else {
				System.out.println("Make sure you insert the correct letter");
				return false;
			}
		}

		//creates the piece once the command is valid.
		if(this.playerTurn == this.player1) {
			if(this.board.getMap().get(letter) != null) {
				this.board.generatePiece(this.board.getMap().get(letter),2,2);
				this.board.getMap().remove(letter);
			}else {
				System.out.println("The map does not have the piece");
				return false;
			}

		}else {
			if(this.board.getMap().get(letter) != null) {
				this.board.generatePiece(this.board.getMap().get(letter),7,7);
				this.board.getMap().remove(letter);
			}else {
				System.out.println("The map does not have the piece");
				return false;
			}

		}

		this.board.drawBoard();
		return true;
	}

	/**
	 *
	 * This method decides if the line following the "rotate" in the
	 * original user input is valid. If yes, the board will rotate the
	 * piece a certain amount of times.
	 *
	 * @param tokenLine The rest of the user input after "rotate"
	 */
	public boolean parseRotate(String tokenLine) {
		System.out.println(tokenLine);

		Scanner lineSc = new Scanner(tokenLine);

		String letter =  " ";
		int degree = -1; //this is more direction than "degree". 1 == rotate clockwise 90degree.

		while(lineSc.hasNext()) {
			letter = lineSc.next();

			if(letter.matches("[a-zA-Z]")) { //check for a letter.
				if(lineSc.hasNextInt()) { //check for the number of rotations.
					degree = lineSc.nextInt();

				}else {
					System.out.println("No degree found");
					return false;

				}
			}else {
				System.out.println("Make sure you insert the correct letter");
				return false;

			}
		}
		//rotate the piece
		Piece piece = this.board.getMap().get(letter);
		for(int i =0; i < degree; i++) {
			this.board.rotatePiece(piece);
		}
		return true;
	}

	/**
	 *
	 * This method decides if the line following the "move" in the
	 * original user input is valid. If yes, a helper method will
	 * be used to help move the piece.
	 *
	 * @param tokenLine The rest of the user input after "move"
	 */
	public boolean parseMove(String tokenLine) {

		Scanner lineSc = new Scanner(tokenLine);

		String letter = " ";
		String direction = " ";
		Piece piece = null;

		while(lineSc.hasNext()) {
			letter = lineSc.next();

			if(letter.matches("[a-zA-Z]")) { //check for the letter.
				piece = this.board.getMap().get(letter);

				//check if the user has entered a valid direction
				if(lineSc.hasNext("up") || lineSc.hasNext("right") || lineSc.hasNext("down") || lineSc.hasNext("left")) {
					direction = lineSc.next();

					if(direction.equals("up")) {
						this.board.movePiece(piece, "up");

					}else if(direction.equals("right")) {
						this.board.movePiece(piece, "right");

					}else if(direction.equals("down")) {
						this.board.movePiece(piece, "down");

					}else if(direction.equals("left")) {
						this.board.movePiece(piece, "left");

					}
				}else {
					System.out.println("Make sure you entered a valid direction");
					return false;

				}
			}else {
				System.out.println("Make sure you entered a valid letter");
				return false;
			}

		}
		return true;
	}

	/**
	 *
	 * This method reverts the state of the game.
	 *
	 */
	public void parseUndo() {
		if(this.board.getHistory().size() == 1 || this.board.getHistory().size() == 0) {
			System.out.println("Undo is not possible.");
			return;
		}else {
			this.board.getHistory().pop();
			this.board.setGrid(this.board.getHistory().pop());

		}
		this.board.drawBoard();
	}

	///////////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 *
	 * This is a helper method to intialise board
	 *
	 * @param board The board to be initialised.
	 */
	public void initialiseBoard(Board board) {
		board.initialiseBoard(this.player1, this.player2);
	}

	/**
	 *
	 * This helper method draws the grid of a given board
	 *
	 * @param board The board to be drawn
	 */
	public void drawGrid(Board board) {
		board.drawBoard();
	}

	public Board getBoard() {
		return this.board;
	}


}
