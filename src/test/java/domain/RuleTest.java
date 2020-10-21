package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RuleTest {

    @Test
    @DisplayName("딜러는 핸드의 총합이 16이하인가?")
    public void 딜러의_핸드가_16이하_인가() {
        CardDeck cardDeck = new CardDeck();
        Rule rule = new Rule();
        Dealer dealer = new Dealer(rule);

        dealer.receiveCard(cardDeck.draw());
        dealer.receiveCard(cardDeck.draw());

        if(rule.isDealerDrawable(dealer.cardOpen())) {
            assertTrue(rule.calculatePoint(dealer.cardOpen()) < 17);
        } else {
            assertTrue(rule.calculatePoint(dealer.cardOpen()) > 16);
        }
    }

    @Test
    @DisplayName("누가 더 21에 가까운가?")
    public void 누가_이번_게임의_승리자인가() {

        List<Player> players = new ArrayList<>();

        CardDeck cardDeck = new CardDeck();
        Rule rule = new Rule();

        Dealer dealer = new Dealer(rule);
        Gamer gamer = new Gamer();

        players.add(dealer);
        players.add(gamer);

        for(int i = 0; i < 2; i++){
            dealer.receiveCard(cardDeck.draw());
            gamer.receiveCard(cardDeck.draw());
        }

        if(rule.isDealerDrawable(dealer.cardOpen())) {
            dealer.receiveCard(cardDeck.draw());
        }

        int dealerPoint = rule.calculatePoint(dealer.cardOpen());
        int gamerPoint = rule.calculatePoint(gamer.cardOpen());

        System.out.println("Dealer Total Point : " + dealerPoint + " Gamer Total Point : " + gamerPoint);

        if(dealerPoint >= gamerPoint){
            assertEquals(rule.getWinner(players), dealer);
        } else {
            assertEquals(rule.getWinner(players), gamer);
        }
    }

}