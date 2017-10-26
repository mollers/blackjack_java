package BlackJack.model.rules;

import BlackJack.model.Deck;
import BlackJack.model.Dealer;
import BlackJack.model.Player;
import BlackJack.model.Card;  

class InternationalNewGameStrategy implements INewGameStrategy {

  public boolean NewGame(Deck a_deck, Dealer a_dealer, Player a_player) {
    GetShowDealCard(a_deck, a_player, true);
    GetShowDealCard(a_deck, a_dealer, true);
    GetShowDealCard(a_deck, a_player, true);
  
    return true;
  }
  
  private void GetShowDealCard(Deck a_deck, Player a_player, boolean b) {
		Card c;
		c = a_deck.GetCard();
	    c.Show(b);
	    a_player.DealCard(c);
  }
}