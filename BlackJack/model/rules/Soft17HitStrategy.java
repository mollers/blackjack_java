package BlackJack.model.rules;


import BlackJack.model.Card;
import BlackJack.model.Player;

public class Soft17HitStrategy implements IHitStrategy {
	private final int g_hitLimit = 17;
	private boolean has_ace = false;
	private int other_cards_score = 0;
	@Override
	public boolean DoHit(Player a_dealer) {
		int cardScores[] = {
		        2, 3, 4, 5, 6, 7, 8, 9, 10, 10 ,10 ,10, 11
		    };
		has_ace = false;
		int other_card_score = 0;
		if (a_dealer.CalcScore() == g_hitLimit) {
			Iterable<Card> hand = a_dealer.GetHand();
			for (Card c : hand) {
				if (has_ace && c.GetValue() == Card.Value.Ace) {
					other_card_score += 1;
				}
				if (c.GetValue() == Card.Value.Ace) {
					has_ace = true;
				}
				if(c.GetValue() != Card.Value.Ace) {
					other_card_score += cardScores[c.GetValue().ordinal()];
				}
			}
			if(has_ace && other_card_score == 6) {
				return true;
			} else {
				return false;
			}
		}
		return a_dealer.CalcScore() < g_hitLimit;
	}

}
