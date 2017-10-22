package BlackJack.controller;

import BlackJack.view.IView;

import BlackJack.model.Game;
import BlackJack.model.Observer;

public class PlayGame implements Observer {
	private Game a_game;
	private IView a_view;

	public boolean Play(Game a_game, IView a_view) {
		this.a_game = a_game;
		this.a_view = a_view;
		a_game.getDealer().setObserver(this);
		a_game.getPlayer().setObserver(this);
		a_view.DisplayWelcomeMessage();



		if (a_game.IsGameOver())
		{
			this.printHands();
			a_view.DisplayGameOver(a_game.IsDealerWinner());
		}

		int input = a_view.GetInput();

		if (input == 'p')
		{
			a_game.NewGame();
		}
		else if (input == 'h')
		{
			a_game.Hit();
		}
		else if (input == 's')
		{
			a_game.Stand();
		}

		return input != 'q';


	}
	private void printHands () {
		a_view.DisplayDealerHand(a_game.GetDealerHand(), a_game.GetDealerScore());
		a_view.DisplayPlayerHand(a_game.GetPlayerHand(), a_game.GetPlayerScore());
	}

	@Override
	public void update() {
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.printHands();
	}
}