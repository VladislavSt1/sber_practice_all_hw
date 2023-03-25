import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class WordCounter {
    public static void main(String[] args) {
        Map<String, Integer> wordFrequencyMap = new HashMap<>();
        String fileName = "1.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    if (wordFrequencyMap.containsKey(word)) {
                        wordFrequencyMap.put(word, wordFrequencyMap.get(word) + 1);
                    } else {
                        wordFrequencyMap.put(word, 1);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (Map.Entry<String, Integer> entry : wordFrequencyMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}

