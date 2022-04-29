import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
public class InstacartTest {

    @Test
    void instacartTest1(){
        Instacart instacart = new Instacart();
        List<Integer> prices = List.of(110, 95, 70);
        List<String> notes = List.of("10% higher than in-store", "5% lower than in-store", "Same than in-store");
        float x = 5;

        assertTrue(instacart.solution(prices, notes, x));
    }

    @Test
    void instacartTest2(){
        Instacart instacart = new Instacart();
        List<Integer> prices = List.of(48, 165);
        List<String> notes = List.of("20.00% lower than in-store", "10.00% higher than in-store");
        float x = 2;

        assertFalse(instacart.solution(prices, notes, x));
    }

    @Test
    void instacartTest3(){
        Instacart instacart = new Instacart();
        List<Integer> prices = List.of(110, 95, 70);
        List<String> notes = List.of("10.0% higher than in-store", "5.0% lower than in-store", "Same than in-store");
        float x = 5;

        assertTrue(instacart.solution(prices, notes, x));
    }


}
