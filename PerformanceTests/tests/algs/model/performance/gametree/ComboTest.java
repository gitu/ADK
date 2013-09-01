package algs.model.performance.gametree;

import org.junit.Test;

import algs.model.gametree.IGameMove;
import algs.model.problems.tictactoe.debug.TicTacToeDebugger;
import algs.model.problems.tictactoe.model.BoardEvaluation;
import algs.model.problems.tictactoe.model.Player;
import algs.model.problems.tictactoe.model.PlayerFactory;
import algs.model.problems.tictactoe.model.RandomPlayer;
import algs.model.problems.tictactoe.model.StraightLogic;
import algs.model.problems.tictactoe.model.TicTacToeBoard;
import algs.model.problems.tictactoe.model.TicTacToeState;

import junit.framework.TestCase;

/** Validate that NegMax produces same results as MiniMax. */
public class ComboTest extends TestCase {
	
	RandomPlayer xPlayer;
	RandomPlayer oPlayer;
	StraightLogic logic;
	
	public void setUp () {
		// create the TicTacToe game. Only instantiate the proper class
	    // that you want to play.
		logic = new StraightLogic();
		
		// Random Player, using the BoardEvaluation function as described in Nilsson.
	    xPlayer = (RandomPlayer) PlayerFactory.createPlayer(PlayerFactory.Random, Player.XMARK);
	    xPlayer.logic(logic);
	    xPlayer.score(new BoardEvaluation());
	    
	    // Random Player, for O.
	    oPlayer = (RandomPlayer) PlayerFactory.createPlayer(PlayerFactory.Random, Player.OMARK);
	    oPlayer.logic(logic);
	    oPlayer.score(new BoardEvaluation());
	}
	
	@Test
	public void testMiniMaxSameAsNegMax() {
		for (int i = 0; i < 50; i++) {
			TicTacToeBoard board = new TicTacToeBoard();
			TicTacToeState state = new TicTacToeState(board, logic);
			TicTacToeDebugger std = new TicTacToeDebugger();
		    String minMaxString;
		    String negMaxString;
		    String alphaBetaString;
		    
			// move X then O then X again.
			xPlayer.decideMove(state).execute(state);
			oPlayer.decideMove(state).execute(state);
			xPlayer.decideMove(state).execute(state);

			// two ply lookahead for MiniMax
			algs.model.gametree.debug.MinimaxEvaluation mme =
				new algs.model.gametree.debug.MinimaxEvaluation(2);
		    mme.debug(std);
		    
			IGameMove move1 = mme.bestMove (state, oPlayer, xPlayer);
			minMaxString = std.getInputString();
		    
			// two ply look ahead for NegMax
			algs.model.gametree.debug.NegMaxEvaluation nme =
				new algs.model.gametree.debug.NegMaxEvaluation(2);

			std = new TicTacToeDebugger();
			nme.debug(std);
		    IGameMove move2 = nme.bestMove (state, oPlayer, xPlayer);
			negMaxString = std.getInputString();

			// two ply look ahead for AlphaBeta
			algs.model.gametree.debug.AlphaBetaEvaluation abe =
				new algs.model.gametree.debug.AlphaBetaEvaluation(2);

			std = new TicTacToeDebugger();
			abe.debug(std);
		    IGameMove move3 = abe.bestMove (state, oPlayer, xPlayer);
		    alphaBetaString = std.getInputString();
			
			if (!move1.equals(move2)) {
				System.out.println ("failed at " + i);
				System.out.println (state);
				System.out.println ("minimax: " + move1);
				System.out.println ("negmax: " + move2);
				System.out.println ("--------------------------------------");
				System.out.println (minMaxString);
				System.out.println ("--------------------------------------");
				System.out.println (negMaxString);
				System.out.println ("--------------------------------------");
				fail ("invalid result");
			}
			
			if (!move2.equals(move3)) {
				System.out.println ("failed at " + i);
				System.out.println (state);
				System.out.println ("minimax: " + move2);
				System.out.println ("alphaBeta: " + move3);
				System.out.println ("--------------------------------------");
				System.out.println (minMaxString);
				System.out.println ("--------------------------------------");
				System.out.println (alphaBetaString);
				System.out.println ("--------------------------------------");
				fail ("invalid result");
			}
		}
	}
	
}
