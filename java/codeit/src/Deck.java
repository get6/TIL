import java.util.ArrayList;
import java.util.Random;

public class Deck<T extends Card> {

    private ArrayList<T> cards;

    public Deck() {
        this.cards = new ArrayList<>();
    }

    public ArrayList<T> getCards() {
        return cards;
    }

    public void addCard(T card) {
        cards.add(card);
    }

    public void print() {
        for (Card card : cards) {
            System.out.println(card.toString());
        }
    }

    public void shuffle() {
        ArrayList<T> newCards = new ArrayList<>();
        while (1 < cards.size()) {
            Random random = new Random();
            int index = random.nextInt(cards.size());
            T card = cards.remove(index);
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
