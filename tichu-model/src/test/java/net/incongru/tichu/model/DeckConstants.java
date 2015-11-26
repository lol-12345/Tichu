package net.incongru.tichu.model;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 */
public class DeckConstants {
    // Generates code for this class
    public static void main(String[] args) {
        CardDeck deck = new CardDeck();
        final Set<Card> cards = deck.allRemaining();
        for (Card card : cards) {
            final String prefix = "public static final Card ";
            final String constName;
            final String constVal;
            if (card.isSpecial()) {
                constName = card.getVal().niceName();
                constVal = " = new Card(Card.CardSpecials." + card.getVal() + ");";
            } else {
                constName = card.getSuit() + "_" + card.getVal().niceName();
                constVal = " = new Card(Card.CardNumbers." + card.getVal() + ", Card.CardSuit." + card.getSuit() + ");";
            }
            System.out.println(prefix + constName + constVal);
            System.out.println(prefix + card.shortName().replace('*', '_') + " = " + constName + ";");
        }
    }

    /**
     * Gets a card by name, where the name is a constant defined in this class. This method
     * is case-insensitive, such that byName("r2")==byName("R2")
     *
     * @param n
     * @return
     */
    public static Card byName(String n) {
        final Card card = namedCards.get(n);
        if (card == null) {
            throw new IllegalArgumentException(n + " is not a valid card name");
        }
        return card;
    }

    public static final Card Jade_2 = new Card(Card.CardNumbers.Two, Card.CardSuit.Jade);
    public static final Card G2 = Jade_2;
    public static final Card Sword_2 = new Card(Card.CardNumbers.Two, Card.CardSuit.Sword);
    public static final Card K2 = Sword_2;
    public static final Card Pagoda_2 = new Card(Card.CardNumbers.Two, Card.CardSuit.Pagoda);
    public static final Card R2 = Pagoda_2;
    public static final Card Star_2 = new Card(Card.CardNumbers.Two, Card.CardSuit.Star);
    public static final Card B2 = Star_2;
    public static final Card Jade_3 = new Card(Card.CardNumbers.Three, Card.CardSuit.Jade);
    public static final Card G3 = Jade_3;
    public static final Card Sword_3 = new Card(Card.CardNumbers.Three, Card.CardSuit.Sword);
    public static final Card K3 = Sword_3;
    public static final Card Pagoda_3 = new Card(Card.CardNumbers.Three, Card.CardSuit.Pagoda);
    public static final Card R3 = Pagoda_3;
    public static final Card Star_3 = new Card(Card.CardNumbers.Three, Card.CardSuit.Star);
    public static final Card B3 = Star_3;
    public static final Card Jade_4 = new Card(Card.CardNumbers.Four, Card.CardSuit.Jade);
    public static final Card G4 = Jade_4;
    public static final Card Sword_4 = new Card(Card.CardNumbers.Four, Card.CardSuit.Sword);
    public static final Card K4 = Sword_4;
    public static final Card Pagoda_4 = new Card(Card.CardNumbers.Four, Card.CardSuit.Pagoda);
    public static final Card R4 = Pagoda_4;
    public static final Card Star_4 = new Card(Card.CardNumbers.Four, Card.CardSuit.Star);
    public static final Card B4 = Star_4;
    public static final Card Jade_5 = new Card(Card.CardNumbers.Five, Card.CardSuit.Jade);
    public static final Card G5 = Jade_5;
    public static final Card Sword_5 = new Card(Card.CardNumbers.Five, Card.CardSuit.Sword);
    public static final Card K5 = Sword_5;
    public static final Card Pagoda_5 = new Card(Card.CardNumbers.Five, Card.CardSuit.Pagoda);
    public static final Card R5 = Pagoda_5;
    public static final Card Star_5 = new Card(Card.CardNumbers.Five, Card.CardSuit.Star);
    public static final Card B5 = Star_5;
    public static final Card Jade_6 = new Card(Card.CardNumbers.Six, Card.CardSuit.Jade);
    public static final Card G6 = Jade_6;
    public static final Card Sword_6 = new Card(Card.CardNumbers.Six, Card.CardSuit.Sword);
    public static final Card K6 = Sword_6;
    public static final Card Pagoda_6 = new Card(Card.CardNumbers.Six, Card.CardSuit.Pagoda);
    public static final Card R6 = Pagoda_6;
    public static final Card Star_6 = new Card(Card.CardNumbers.Six, Card.CardSuit.Star);
    public static final Card B6 = Star_6;
    public static final Card Jade_7 = new Card(Card.CardNumbers.Seven, Card.CardSuit.Jade);
    public static final Card G7 = Jade_7;
    public static final Card Sword_7 = new Card(Card.CardNumbers.Seven, Card.CardSuit.Sword);
    public static final Card K7 = Sword_7;
    public static final Card Pagoda_7 = new Card(Card.CardNumbers.Seven, Card.CardSuit.Pagoda);
    public static final Card R7 = Pagoda_7;
    public static final Card Star_7 = new Card(Card.CardNumbers.Seven, Card.CardSuit.Star);
    public static final Card B7 = Star_7;
    public static final Card Jade_8 = new Card(Card.CardNumbers.Eight, Card.CardSuit.Jade);
    public static final Card G8 = Jade_8;
    public static final Card Sword_8 = new Card(Card.CardNumbers.Eight, Card.CardSuit.Sword);
    public static final Card K8 = Sword_8;
    public static final Card Pagoda_8 = new Card(Card.CardNumbers.Eight, Card.CardSuit.Pagoda);
    public static final Card R8 = Pagoda_8;
    public static final Card Star_8 = new Card(Card.CardNumbers.Eight, Card.CardSuit.Star);
    public static final Card B8 = Star_8;
    public static final Card Jade_9 = new Card(Card.CardNumbers.Nine, Card.CardSuit.Jade);
    public static final Card G9 = Jade_9;
    public static final Card Sword_9 = new Card(Card.CardNumbers.Nine, Card.CardSuit.Sword);
    public static final Card K9 = Sword_9;
    public static final Card Pagoda_9 = new Card(Card.CardNumbers.Nine, Card.CardSuit.Pagoda);
    public static final Card R9 = Pagoda_9;
    public static final Card Star_9 = new Card(Card.CardNumbers.Nine, Card.CardSuit.Star);
    public static final Card B9 = Star_9;
    public static final Card Jade_10 = new Card(Card.CardNumbers.Ten, Card.CardSuit.Jade);
    public static final Card G0 = Jade_10;
    public static final Card Sword_10 = new Card(Card.CardNumbers.Ten, Card.CardSuit.Sword);
    public static final Card K0 = Sword_10;
    public static final Card Pagoda_10 = new Card(Card.CardNumbers.Ten, Card.CardSuit.Pagoda);
    public static final Card R0 = Pagoda_10;
    public static final Card Star_10 = new Card(Card.CardNumbers.Ten, Card.CardSuit.Star);
    public static final Card B0 = Star_10;
    public static final Card Jade_Jack = new Card(Card.CardNumbers.Jack, Card.CardSuit.Jade);
    public static final Card GJ = Jade_Jack;
    public static final Card Sword_Jack = new Card(Card.CardNumbers.Jack, Card.CardSuit.Sword);
    public static final Card KJ = Sword_Jack;
    public static final Card Pagoda_Jack = new Card(Card.CardNumbers.Jack, Card.CardSuit.Pagoda);
    public static final Card RJ = Pagoda_Jack;
    public static final Card Star_Jack = new Card(Card.CardNumbers.Jack, Card.CardSuit.Star);
    public static final Card BJ = Star_Jack;
    public static final Card Jade_Queen = new Card(Card.CardNumbers.Queen, Card.CardSuit.Jade);
    public static final Card GQ = Jade_Queen;
    public static final Card Sword_Queen = new Card(Card.CardNumbers.Queen, Card.CardSuit.Sword);
    public static final Card KQ = Sword_Queen;
    public static final Card Pagoda_Queen = new Card(Card.CardNumbers.Queen, Card.CardSuit.Pagoda);
    public static final Card RQ = Pagoda_Queen;
    public static final Card Star_Queen = new Card(Card.CardNumbers.Queen, Card.CardSuit.Star);
    public static final Card BQ = Star_Queen;
    public static final Card Jade_King = new Card(Card.CardNumbers.King, Card.CardSuit.Jade);
    public static final Card GK = Jade_King;
    public static final Card Sword_King = new Card(Card.CardNumbers.King, Card.CardSuit.Sword);
    public static final Card KK = Sword_King;
    public static final Card Pagoda_King = new Card(Card.CardNumbers.King, Card.CardSuit.Pagoda);
    public static final Card RK = Pagoda_King;
    public static final Card Star_King = new Card(Card.CardNumbers.King, Card.CardSuit.Star);
    public static final Card BK = Star_King;
    public static final Card Jade_Ace = new Card(Card.CardNumbers.Ace, Card.CardSuit.Jade);
    public static final Card GA = Jade_Ace;
    public static final Card Sword_Ace = new Card(Card.CardNumbers.Ace, Card.CardSuit.Sword);
    public static final Card KA = Sword_Ace;
    public static final Card Pagoda_Ace = new Card(Card.CardNumbers.Ace, Card.CardSuit.Pagoda);
    public static final Card RA = Pagoda_Ace;
    public static final Card Star_Ace = new Card(Card.CardNumbers.Ace, Card.CardSuit.Star);
    public static final Card BA = Star_Ace;
    public static final Card MahJong = new Card(Card.CardSpecials.MahJong);
    public static final Card _1 = MahJong;
    public static final Card Dog = new Card(Card.CardSpecials.Dog);
    public static final Card _H = Dog;
    public static final Card Phoenix = new Card(Card.CardSpecials.Phoenix);
    public static final Card _P = Phoenix;
    public static final Card Dragon = new Card(Card.CardSpecials.Dragon);
    public static final Card _D = Dragon;

    private static final Map<String, Card> namedCards = cacheNamedCards();

    private static Map<String, Card> cacheNamedCards() {
        try {
            final Map<String, Card> namedCards = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
            final Field[] fields = DeckConstants.class.getFields();
            for (final Field field : fields) {
                int mod = field.getModifiers();
                if (Modifier.isStatic(mod) && Modifier.isPublic(mod) && Modifier.isFinal(mod)) {
                    if (Card.class.equals(field.getType())) {
                        namedCards.put(field.getName().toUpperCase(), (Card) field.get(null));
                    }
                }
            }
            return namedCards;
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Can't access field values of " + DeckConstants.class + ", is this system too secure?", e);
        }
    }

}
