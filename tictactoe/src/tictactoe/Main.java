package tictactoe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {

	public static ArrayList<Integer> player1Moves = new ArrayList<Integer>();
	public static ArrayList<Integer> player2Moves = new ArrayList<Integer>();
	
	public static char[][] gameBoard = {
			{' ', '|', ' ', '|', ' '},
			{' ', '|', ' ', '|', ' '},
			{' ', '|', ' ', '|', ' '}
	};
	public static String result;
	
	public static void main(String[] args) {
		
		boolean gameRunning = true;
		
		Random random = new Random();
		
		while (gameRunning) {
			printGameBoard();
			
			
			// user input
			Scanner scanner = new Scanner(System.in);
			System.out.println("Enter your placement (1-9):");
			int player1Pos = scanner.nextInt();
			
			// check if position is already taken
			
			while (player1Moves.contains(player1Pos) || player2Moves.contains(player1Pos)) {
				scanner = new Scanner(System.in);
				
				System.out.println("some goon is already there. try again (1-9):");
				player1Pos = scanner.nextInt();
			}
			placePiece(player1Pos, 'X');
			
			if (!checkGameStatus()) {
				gameRunning = false;
				break;	
			}
					
			// CPU input
			
			int player2Pos = random.nextInt(1, 9);
			
			// check if position is already taken
			
			while (player1Moves.contains(player2Pos)  || player2Moves.contains(player2Pos)) {
				player2Pos = random.nextInt(1, 9);
			}
			placePiece(player2Pos, 'O');
			
			if (!checkGameStatus()) {
				gameRunning = false;
				break;	
			}
		}
	}
	
	public static void placePiece(int pos, char piece) {
		
		if (piece == 'X')
			player1Moves.add(pos);
		else if (piece == 'O')
			player2Moves.add(pos);
				
		switch (pos) {
		case 1:
			gameBoard[0][0] = piece;
			break;
		case 2:
			gameBoard[0][2] = piece;
			break;
		case 3:
			gameBoard[0][4] = piece;
			break;
		case 4:
			
			gameBoard[1][0] = piece;
			break;
		case 5:
			gameBoard[1][2] = piece;
			break;
		case 6:
			gameBoard[1][4] = piece;
			break;
			
		case 7:
			gameBoard[2][0] = piece;
			break;
		case 8:
			gameBoard[2][2] = piece;
			break;
		case 9:
			gameBoard[2][4] = piece;
			break;
		}
	}
	
	public static void printGameBoard() {
		for(char[] row : gameBoard) {
			for(char column : row) {
				System.out.print(column);	
			}
			System.out.println();
		}
	}
	
	public static boolean checkGameStatus() {
		
		boolean gameIsRunning = true;
		
		List topRow = Arrays.asList(1, 2, 3);
		List middleRow = Arrays.asList(4, 5, 6);
		List bottomRow = Arrays.asList(7, 8, 9);
		
		List leftColumn = Arrays.asList(1, 4, 7);
		List middleColumn = Arrays.asList(2, 5, 8);
		List rightColumn = Arrays.asList(3, 6, 9);
		
		List diagonalRight = Arrays.asList(7, 5, 3);
		List diagonalLeft = Arrays.asList(1, 5, 9);
		
		List<List> winningConditions = new ArrayList<List>();
		
		winningConditions.add(topRow);
		winningConditions.add(middleRow);
		winningConditions.add(bottomRow);
		
		winningConditions.add(leftColumn);
		winningConditions.add(middleColumn);
		winningConditions.add(rightColumn);
		
		winningConditions.add(diagonalRight);
		winningConditions.add(diagonalLeft);
		
		if (player1Moves.size() + player2Moves.size() == 9) {
			result = "Tie!";
		}
		
		for(List l : winningConditions) {
			if (player1Moves.containsAll(l)) {
				gameIsRunning = false;
				result = "X won!";
			}
			
			else if (player2Moves.containsAll(l)) {
				gameIsRunning = false;
				result = "O won!";
			}
		}
		
		if (!gameIsRunning) {
			printGameBoard();
			System.out.println();
			System.out.println("GAME OVER!");
			System.out.println(result);	
		}
		
		return gameIsRunning;
	}
}
