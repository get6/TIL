public class BlackjackHand<T extends BlackjackCard> extends Deck<T> {
    public int getValue() {
        int value = 0;
        int aceCount = 0;

        for (BlackjackCard card : getCards()) {
            if (card.isAce()) {
                aceCount++;
            }

            value += card.getValue();
        }

        while (aceCount > 0 && value > 21) {
            value -= 10;
            aceCount--;
        }

        return value;
    }

    public boolean isBusted() {
        return getValue() > 21;
    }

    public boolean isBlackjack() {
        return getValue() == 21 && getCards().size() == 2;
    }
}