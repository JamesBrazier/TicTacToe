package model;

public class Game {
	
	public static final int empty = 0;
	public static final int player1 = 1;
	public static final int player2 = 2;
	
	private int[][] tiles = new int[3][3];
	private boolean won;
	private int turn;
	private int player;

	public Game() {
		won = false;
		turn = 0;
		player = 1;
	}
	
	public void nextTurn() {
		System.out.print(this);
		int temp = checkVictory();
		if (temp == 0) {
			turn++;
			if (turn % 2 == 1) {
				player = 1;
			} else {
				player = 2;
			}
		} else {
			won = true;
			System.out.println("WON");
		}
	}
	
	public boolean canMove(int row, int column) {
		if (tiles[row][column] == 0) {
			return true;
		}
		return false;
	}
	
	public void setMove(int player, int row, int column) {
		tiles[row][column] = player;
	}
	
	public int checkVictory() {
		for (int i = 0; i < 3; i++) {
			if (tiles[i][0] == tiles[i][1] && tiles[i][1] == tiles[i][2]) {
				System.out.println("" + tiles[i][0] + tiles[i][1] + tiles[i][2]);
				return tiles[i][0];
			} else if (tiles[0][i] == tiles[1][i] && tiles[1][i] == tiles[2][i]) {
				System.out.println("" + tiles[0][i] + tiles[1][i] + tiles[2][i]);
				return tiles[0][i];
			}
		}
		if (tiles[0][0] == tiles[1][1] && tiles[1][1] == tiles[2][2]) {
			System.out.println("" + tiles[0][0] + tiles[1][1] + tiles[2][2]);
			return tiles[0][0];
		} else if (tiles[0][2] == tiles[1][1] && tiles[1][1] == tiles[2][0]) {
			System.out.println("" + tiles[0][2] + tiles[1][1] + tiles[2][0]);
			return tiles[0][2];
		}
		return 0;
	}
	
	public boolean checkPlayerVictory(int player, int row, int column) {
		if (tiles[(row + 1) % 3][column] == player) {
			if (tiles[(row + 2) % 3][(column + 1) % 3] == player) {
				return true;
			}
		} if (tiles[row][(column + 1) % 3] == player) {
			if (tiles[(row + 1) % 3][(column + 2) % 3] == player) {
				return true;
			}
		}
		if (!(column == 1 || row == 1) || (column == 1 && row == 1)) {
			if (tiles[(row + 1) % 3][(column + 1) % 3] == player) {
				if (tiles[(row + 2) % 3][(column + 2) % 3] == player) {
					return true;
				}
			} if (tiles[(row + 1) % 3][Math.abs((column - 1) % 3)] == player) {
				if (tiles[(row + 2) % 3][Math.abs((column - 2) % 3)] == player) {
					return true;
				}
			}
		}
		return false;
	}
	
	public String toString() {
		String string = "";
		for (int i = 0; i < 3; i++) {
			string = string + tiles[i][0] + " " + tiles[i][1] + " " + tiles[i][2] + "\n";
		}
		return string;
	}
	
	public int[][] getBoard() {
		return tiles;
	}
	
	public int getTurn() {
		return turn;
	}
	
	public int getPlayer() {
		return player;
	}
	
	public boolean isWon() {
		return won;
	}

}
