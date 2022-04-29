import java.util.List;

/**
 * List<Integer> prices = List.of(110, 95, 70);
 * List<String> notes = List.of("10% higher than in-store", "5% lower than in-store", "Same than in-store");
 * float x = 5;
 */

public class Instacart {
    public static void main(String[] args) {
        List<Integer> prices = List.of(110, 95, 70);
        List<String> notes = List.of("10% higher than in-store", "5% lower than in-store", "Same than in-store");
        float x = 5;
    }

    public boolean solution(List<Integer> prices, List<String> notes, float x) {
        float counter = 0;
        float inStorePrice = 0;
        for (int i = 0; i < prices.size(); i++) {
            Integer price = prices.get(i);
            String note = notes.get(i);

            try {
                float percentPrice = Integer.parseInt(note.subSequence(0, note.indexOf("% ")).toString());
                if (note.contains("higher")) {
                    inStorePrice = price / ((percentPrice + 100) / 100);
                    counter = counter + (price - inStorePrice);
                } else if (note.contains("lower")) {
                    inStorePrice = price / ((100 - percentPrice) / 100);
                    counter = counter - (inStorePrice - price);
                } else {
                    break;
                }
            } catch (StringIndexOutOfBoundsException e) {
                break;
            } catch (NumberFormatException e) {
                try {
                    float percentPrice = Integer.parseInt(note.subSequence(0, note.indexOf(".")).toString());
                    if (note.contains("higher")) {
                        inStorePrice = price / ((percentPrice + 100) / 100);
                        counter = counter + (price - inStorePrice);
                    } else if (note.contains("lower")) {
                        inStorePrice = price / ((100 - percentPrice) / 100);
                        counter = counter - (inStorePrice - price);
                    } else {
                        break;
                    }
                } catch (StringIndexOutOfBoundsException ex) {
                    break;
                }
            }
        }
        return counter <= x;
    }
}
