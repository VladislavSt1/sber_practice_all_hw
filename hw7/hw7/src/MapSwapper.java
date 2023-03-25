import java.util.HashMap;
import java.util.Map;

public class MapSwapper {
    public static <K, V> Map<V, K> swapKeysAndValues(Map<K, V> originalMap) {
        Map<V, K> swappedMap = new HashMap<V, K>();
        for (Map.Entry<K, V> entry : originalMap.entrySet()) {
            swappedMap.put(entry.getValue(), entry.getKey());
        }
        return swappedMap;
    }

    public static void main(String[] args) {
        Map<String, Integer> originalMap = new HashMap<>();
        originalMap.put("one", 1);
        originalMap.put("two", 2);
        originalMap.put("three", 3);

        Map<Integer, String> swappedMap = swapKeysAndValues(originalMap);

        System.out.println("Original map: " + originalMap);
        System.out.println("Swapped map: " + swappedMap);
    }
}
