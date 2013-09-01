package algs.model.performance.chapter7;

import junit.framework.TestCase;

import org.junit.Test;

import algs.model.problems.tictactoe.model.BoardEvaluation;
import algs.model.problems.tictactoe.model.Cell;
import algs.model.problems.tictactoe.model.PlaceMark;
import algs.model.problems.tictactoe.model.Player;
import algs.model.problems.tictactoe.model.PlayerFactory;
import algs.model.problems.tictactoe.model.StraightLogic;
import algs.model.problems.tictactoe.model.TicTacToeBoard;
import algs.model.problems.tictactoe.model.TicTacToeState;

/** 
 * Move data into excel for processing. To compute "individual variation", divide the 
 * alphaBeta/Minimax for each result and then compute standard deviation.
 * 
 *  k   MM       AB      reduction   ind. variation
 *  1  549945    27565	 95%          +/-  1.3%
 *  2  549936    47508   91%          +/-  6.8%
 *  3  549864   112086   80%          +/-  10.2%
 * 
 */
public class Table7_5Test extends TestCase {
	@Test
	public void testAlphaBetaNonDebug() {
		System.out.println("Real Table 7-5");
		// create the TicTacToe game. Only instantiate the proper class
	    // that you want to play.
		StraightLogic logic = new StraightLogic();
		
		// 2-move lookahead, using the BoardEvaluation function as described in Nilsson.
	    Player xPlayer = PlayerFactory.createPlayerWithPly(PlayerFactory.AlphaBeta, Player.XMARK, 6);
	    xPlayer.logic(logic);
	    xPlayer.score(new BoardEvaluation());
	    
	    // 2-move lookahead, for O.
	    Player oPlayer = PlayerFactory.createPlayerWithPly(PlayerFactory.AlphaBeta, Player.OMARK, 6);
	    oPlayer.logic(logic);
	    oPlayer.score(new BoardEvaluation());
	    
	    
	    Cell[] cells = new Cell[9];
	    int idx = 0;
	    for (int i = 0; i < 3; i++) {
	    	for (int j = 0; j < 3; j++) {
	    		Cell c = new Cell (i,j);
	    		cells[idx++] = c;
	    	}
	    }
	    
	    // ONE MOVE
	    int i, j, k;
	    final int sz = 9;

	    for (i = 0; i < sz; i++) {
			TicTacToeBoard board = new TicTacToeBoard();
		    TicTacToeState state = new TicTacToeState(board, logic);
			    
		    new PlaceMark(cells[i].col,cells[i].row, (Player) xPlayer).execute(state);
			
			algs.model.gametree.AlphaBetaEvaluation ae = new algs.model.gametree.AlphaBetaEvaluation(8);
			/* IMove move = */ ae.bestMove(state, oPlayer, xPlayer);
			int explored = ae.numStates;
			
			algs.model.gametree.MinimaxEvaluation mme = new algs.model.gametree.MinimaxEvaluation(8);
			/* IMove move2 = */ mme.bestMove(state, oPlayer, xPlayer);
			int exploredMME = mme.numStates;
			
			// sometimes alpha beta returns NULL if there is no hope. For example, on
			// 
			//  XX.    the only defense is to play XXO  but then  XXO  means X wins
			//  O..                                O..            OX.     on next turn
			//  ...                                ...            ...
			//
			// alpha-beta detects this unfavorable situation and gives up. There is
			// nothing that can be done.
			
			System.out.println ("1-move," +i+","+ explored+","+exploredMME);
	    }
	    
	    // TWO MOVE
	    for (i = 0; i < sz; i++) {
	    	for (j = 0; j < sz; j++) {
	    		if (j == i) continue;
	    		
   				TicTacToeBoard board = new TicTacToeBoard();
   			    TicTacToeState state = new TicTacToeState(board, logic);
	    			    
   			    new PlaceMark(cells[i].col,cells[i].row, (Player) xPlayer).execute(state);
   			    new PlaceMark(cells[j].col,cells[j].row, (Player) oPlayer).execute(state);
    			
    			algs.model.gametree.AlphaBetaEvaluation ae = new algs.model.gametree.AlphaBetaEvaluation(7);
    			/* IMove move = */ ae.bestMove(state, xPlayer, oPlayer);
    			int explored = ae.numStates;
    			
    			algs.model.gametree.MinimaxEvaluation mme = new algs.model.gametree.MinimaxEvaluation(7);
    			/* IMove move2 = */ mme.bestMove(state, xPlayer, oPlayer);
    			int exploredMME = mme.numStates;
    			
    			// sometimes alpha beta returns NULL if there is no hope. For example, on
    			// 
    			//  XX.    the only defense is to play XXO  but then  XXO  means X wins
    			//  O..                                O..            OX.     on next turn
    			//  ...                                ...            ...
    			//
    			// alpha-beta detects this unfavorable situation and gives up. There is
    			// nothing that can be done.
    			System.out.println ("2-move," + i+","+j+","+explored+","+exploredMME);
    		}
	    }

	    // THREE MOVES
	    for (i = 0; i < sz; i++) {
	    	for (j = 0; j < sz; j++) {
	    		if (j == i) continue;
	    		for (k = 0; k < sz; k++) {
	    			if (j == k) continue;
	    			if (i == k) continue;
    				TicTacToeBoard board = new TicTacToeBoard();
    			    TicTacToeState state = new TicTacToeState(board, logic);
	    			    
    			    new PlaceMark(cells[i].col,cells[i].row, (Player) xPlayer).execute(state);
    			    new PlaceMark(cells[j].col,cells[j].row, (Player) oPlayer).execute(state);
	    			new PlaceMark(cells[k].col,cells[k].row, (Player) xPlayer).execute(state);
	    			
	    			algs.model.gametree.AlphaBetaEvaluation ae = new algs.model.gametree.AlphaBetaEvaluation(6);
	    			/* IMove move = */ ae.bestMove(state, oPlayer, xPlayer);
	    			int explored = ae.numStates;
	    			
	    			algs.model.gametree.MinimaxEvaluation mme = new algs.model.gametree.MinimaxEvaluation(6);
	    			/* IMove move2 = */ mme.bestMove(state, oPlayer, xPlayer);
	    			int exploredMME = mme.numStates;
	    			
	    			
	    			// sometimes alpha beta returns NULL if there is no hope. For example, on
	    			// 
	    			//  XX.    the only defense is to play XXO  but then  XXO  means X wins
	    			//  O..                                O..            OX.     on next turn
	    			//  ...                                ...            ...
	    			//
	    			// alpha-beta detects this unfavorable situation and gives up. There is
	    			// nothing that can be done.
	    			
	    			System.out.println ("3-move," + i+","+j+","+k+","+explored+","+exploredMME);
	    		}
	    	}
	    }
	}
}