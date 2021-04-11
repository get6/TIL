public class Card {

    public final int suitNumber;
    // 1, 11, 12, 13 = 'Ace', 'Jack', 'Queen', 'King', 2~10 = 숫자
    public final int rankNumber;

    public Card(int suitNumber, int rankNumber) {
        this.suitNumber = suitNumber;
        this.rankNumber = rankNumber;
    }

    public String getSuit() {
        switch (suitNumber) {
            case 1:
                return "Clubs";
            case 2:
                return "Hearts";
            case 3:
                return "Diamonds";
            case 4:
                return "Spades";
        }
        return null;
    }

    public String getRank() {
        switch (rankNumber) {
            case 1:
                return "Ace";
            case 11:
                return "Jack";
            case 12:
                return "Queen";
            case 13:
                return "King";
            default:
                return String.valueOf(rankNumber);
        }
    }

    @Override
    public String toString() {
        return getRank() + " of " + getSuit();
    }
}
