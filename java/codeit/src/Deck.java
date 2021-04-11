import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Deck {

    private ArrayList<Card> cards;

    public Deck() {
        this.cards = new ArrayList<>();
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public void print() {
        for (Card card : cards) {
            System.out.println(card.toString());
        }
    }

    public void shuffle() {
        ArrayList<Card> newCards = new ArrayList<>();
        while (1 < cards.size()) {
            Random random = new Random();
            int index = random.nextInt(cards.size());
            Card card = cards.remove(index);
            if (card == null) {
                continue;
            }

            newCards.add(card);
        }
        cards = newCards;
    }

    public Deck deal(int count) {
        Deck hand = new Deck();
        int start = cards.size() - count;
        for (int i = start; i < start + count; i++) {
            hand.addCard(cards.remove(start));
        }
        return hand;
    }
}
