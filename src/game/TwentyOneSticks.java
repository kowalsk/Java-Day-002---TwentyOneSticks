package game;

import java.util.Scanner;

public class TwentyOneSticks {

	int numSticks = 21;
	int numToTake = 0;

	Scanner input = new Scanner(System.in);
	Scanner take = new Scanner(System.in);

	public static void main(String[] args) {

		TwentyOneSticks game = new TwentyOneSticks();

		System.out.println("Would you like to go first? (Y/n)");
		String goFirst = game.input.nextLine().toUpperCase();

		while (game.numSticks > 0) {
			if (goFirst.equals("Y")) {
				game.playerTurn(game); // extracted to a method

				if (game.numSticks <= 0) {
					System.out.println("You lose!");
				} else {
					game.computerTurn(game);

					if (game.numSticks <= 0) {
						System.out.println("You win!");
					}
				}
			} else {
				game.computerTurn(game); // extracted to a method

				if (game.numSticks <= 0) {
					System.out.println("You win!");
				} else {
					game.playerTurn(game); // extracted to a method

					if (game.numSticks <= 0) {
						System.out.println("You lose!");
					}
				}
			} // else
		} // while
	} // main

	void playerTurn(TwentyOneSticks g) {
		System.out.println("There are " + g.numSticks + " sticks");
		System.out.println("How many sticks to take (1 or 2)");
		g.numToTake = g.take.nextInt();

		if (g.numToTake > 2) {
			g.numToTake = 2;
		} else if (g.numToTake < 1) {
			g.numToTake = 1;
		}

		System.out.println("You took " + g.numToTake + " sticks.");

		g.numSticks = g.numSticks - g.numToTake;
	}

	void computerTurn(TwentyOneSticks g) {
		if ((g.numSticks - 2) % 3 == 0 || g.numSticks - 2 == 0) {
			g.numToTake = 1;
		} else {
			g.numToTake = 2;
		}

		System.out.println("Computer takes " + g.numToTake + " sticks");
		g.numSticks = g.numSticks - g.numToTake;
	}
} // class