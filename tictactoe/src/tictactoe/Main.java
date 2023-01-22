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
			{' ', ' ', ' '},
			{' ', ' ', ' '},
			{' ', ' ', ' '}
	};
	public static String result;

	public static void pressButton(int button) {		
		if (!checkGameStatus() || player1Moves.contains(button) || player2Moves.contains(button))
			return;
		
		placePiece(button, 'X');
		
		if (!checkGameStatus())
			return;
		
		// ai shit (its random lmfao) and check if position is already taken
			
		Random random = new Random();
			
		int CPUpos = random.nextInt(1, 9);
		while (player1Moves.contains(CPUpos)  || player2Moves.contains(CPUpos)) {
			CPUpos = random.nextInt(1, 9);
		}
		placePiece(CPUpos, 'O');
		
		if (!checkGameStatus())
			return;
	}
	
	private static void placePiece(int pos, char piece) {
		
		if (player1Moves.contains(pos) || player2Moves.contains(pos))
			return;
		
		if (piece == 'X')
			player1Moves.add(pos);
		else if (piece == 'O')
			player2Moves.add(pos);
				
		switch (pos) {
		case 1:
			gameBoard[0][0] = piece;
			break;
		case 2:
			gameBoard[0][1] = piece;
			break;
		case 3:
			gameBoard[0][2] = piece;
			break;
		case 4:
			
			gameBoard[1][0] = piece;
			break;
		case 5:
			gameBoard[1][1] = piece;
			break;
		case 6:
			gameBoard[1][2] = piece;
			break;
			
		case 7:
			gameBoard[2][0] = piece;
			break;
		case 8:
			gameBoard[2][1] = piece;
			break;
		case 9:
			gameBoard[2][2] = piece;
			break;
		}
	
	refreshGameBoard();
	}
	
	public static void refreshGameBoard() {
		Visuals.button1.setText(Character.toString(gameBoard[0][0]));
		Visuals.button2.setText(Character.toString(gameBoard[0][1]));
		Visuals.button3.setText(Character.toString(gameBoard[0][2]));
		
		Visuals.button4.setText(Character.toString(gameBoard[1][0]));
		Visuals.button5.setText(Character.toString(gameBoard[1][1]));
		Visuals.button6.setText(Character.toString(gameBoard[1][2]));
		
		Visuals.button7.setText(Character.toString(gameBoard[2][0]));
		Visuals.button8.setText(Character.toString(gameBoard[2][1]));
		Visuals.button9.setText(Character.toString(gameBoard[2][2]));
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
			gameIsRunning = false;
			result = "Tie!";
		}
		
		for(List l : winningConditions) {
			if (player1Moves.containsAll(l)) {
				gameIsRunning = false;
				result = "You won!";
			}
			
			else if (player2Moves.containsAll(l)) {
				gameIsRunning = false;
				result = "You SUCK!";
			}
		}
		
		if (!gameIsRunning) {
			
			Visuals.showResults(result);
			
			printGameBoard();
			System.out.println();
			System.out.println("GAME OVER!");
			System.out.println(result);	
		}
		
		return gameIsRunning;
	}
	
	public static void resetGame() {
		player1Moves = new ArrayList<Integer>();
		player2Moves = new ArrayList<Integer>();
		
		gameBoard = new char [][]{
				{' ', ' ', ' '},
				{' ', ' ', ' '},
				{' ', ' ', ' '}
		};
		
		refreshGameBoard();		
	}
}